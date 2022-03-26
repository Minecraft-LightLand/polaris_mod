package org.xkmc.polaris.data.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;


public class Serializer<T extends ObsidianFurnaceRecipe> extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {
    private final int defaultCookingTime;
    private final Serializer.IFactory<T> factory;

    public Serializer(Serializer.IFactory<T> factory, int defaultCookingTime) {
        this.defaultCookingTime = defaultCookingTime;
        this.factory = factory;
    }

    public Serializer() {
        this.defaultCookingTime = 200;
        this.factory = this.getFactory();
    }

    public IFactory<T> getFactory() {
        return factory;
    }

    public Serializer<T> get() {
        return new Serializer<T>(this.getFactory(), 200);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public T fromJson(ResourceLocation resourceLocation, JsonObject json) {
        String s = JSONUtils.getAsString(json, "group", "");
        JsonElement jsonelement = JSONUtils.isArrayNode(json, "ingredient") ? JSONUtils.getAsJsonArray(json, "ingredient") : JSONUtils.getAsJsonObject(json, "ingredient");
        Ingredient ingredient = Ingredient.fromJson(jsonelement);
        //Forge: Check if primitive string to keep vanilla or an object which can contain a count field.
        if (!json.has("result")) throw new JsonSyntaxException("Missing result, expected to find a string or object");
        ItemStack itemstack;
        if (json.get("result").isJsonObject())
            itemstack = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
        else {
            String s1 = JSONUtils.getAsString(json, "result");
            ResourceLocation resourcelocation = new ResourceLocation(s1);
            itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() ->
                    new IllegalStateException("Item: " + s1 + " does not exist")));
        }
        float f = JSONUtils.getAsFloat(json, "experience", 0.0F);
        int i = JSONUtils.getAsInt(json, "cookingtime", this.defaultCookingTime);
        return this.factory.create(new T.ObsidianFurnaceRecipeType(), resourceLocation, s, ingredient, itemstack, f, i);
    }

    @Override
    @Nullable
    @ParametersAreNonnullByDefault
    public T fromNetwork(ResourceLocation resourceLocation, PacketBuffer json) {
        String s = json.readUtf(32767);
        Ingredient ingredient = Ingredient.fromNetwork(json);
        ItemStack itemstack = json.readItem();
        float f = json.readFloat();
        int i = json.readVarInt();
        return this.factory.create(new T.ObsidianFurnaceRecipeType(), resourceLocation, s, ingredient, itemstack, f, i);
    }

    @Override
    public void toNetwork(PacketBuffer buffer, T obsidianFurnaceRecipe) {
        buffer.writeUtf(obsidianFurnaceRecipe.getGroup());
        obsidianFurnaceRecipe.ingredient.toNetwork(buffer);
        buffer.writeItem(obsidianFurnaceRecipe.result);
        buffer.writeFloat(obsidianFurnaceRecipe.experience);
        buffer.writeVarInt(obsidianFurnaceRecipe.cookingTime);
    }

    public interface IFactory<T extends ObsidianFurnaceRecipe> {
        T create(IRecipeType<?> recipeType, ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result, float experience, int cookingTime);
    }
}
