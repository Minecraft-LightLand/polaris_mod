package org.xkmc.polaris.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nonnull;

public class ObsidianFurnaceRecipe extends AbstractCookingRecipe {

    private static IRecipeType<?> type;
    private static ResourceLocation resourceLocation;
    private static String group;
    private static NonNullList<Ingredient> ingredient;
    private static ItemStack result;
    private static float experience;
    private static int cookingTime;

    @Override
    public int getCookingTime() {
        return cookingTime;
    }

    public ObsidianFurnaceRecipe(IRecipeType<?> type, ResourceLocation resourceLocation, String group, NonNullList<Ingredient> ingredient, ItemStack result, float experience, int cookingTime) {
        super(type, resourceLocation, group, Ingredient.merge(ingredient), result, experience, cookingTime);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return PolarisRecipeTypes.OBSIDIAN_FURNACE_SERIALIZER.get();
    }

    @Override
    public IRecipeType<?> getType() {
        return type;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean matches(IInventory inventory, World worldIn) {
        if (ingredient.get(0).test(inventory.getItem(0))) {
            return ingredient.get(1).test(inventory.getItem(1));
        }
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return super.getIngredients();
    }

    @Override
    public float getExperience() {
        return super.getExperience();
    }

    @Override
    public String getGroup() {
        return super.getGroup();
    }

    @Override
    @Nonnull
    public ItemStack assemble(@Nonnull IInventory inventory) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    @Nonnull
    public ItemStack getResultItem() {
        return result.copy();
    }

    public static class ObsidianFurnaceRecipeType implements IRecipeType<ObsidianFurnaceRecipe> {
        @Override
        public String toString() {
            return resourceLocation.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ObsidianFurnaceRecipe> {

        @Override
        @Nonnull
        public ObsidianFurnaceRecipe fromJson(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
            ItemStack result = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
            JsonArray ingredients = JSONUtils.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new ObsidianFurnaceRecipe();
        }

        @Override
        public ObsidianFurnaceRecipe fromNetwork(@Nonnull ResourceLocation resourceLocation, @Nonnull PacketBuffer buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }
            ItemStack result = buffer.readItem();
            return new ObsidianFurnaceRecipe();
        }

        @Override
        public void toNetwork(PacketBuffer buffer, ObsidianFurnaceRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeItemStack(recipe.getResultItem().copy(), false);
        }
    }
}
