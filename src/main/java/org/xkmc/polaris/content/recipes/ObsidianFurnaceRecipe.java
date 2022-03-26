package org.xkmc.polaris.content.recipes;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.xkmc.polaris.init.Polaris;
import org.xkmc.polaris.init.PolarisRecipeTypes;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

public class ObsidianFurnaceRecipe extends AbstractCookingRecipe implements IRecipe<IInventory> {
	protected final IRecipeType<?> type;
	protected final ResourceLocation id;
	protected final String group;
	protected final Ingredient ingredient;
	protected final ItemStack result;
	protected final float experience;
	protected final int cookingTime;

	public ObsidianFurnaceRecipe(IRecipeType<?> type, ResourceLocation id, String group, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
		super(type, id, group, ingredient, result, experience, cookingTime);
		this.type = type;
		this.id = id;
		this.group = group;
		this.ingredient = ingredient;
		this.result = result;
		this.experience = experience;
		this.cookingTime = cookingTime;
	}

	@Override
	public int getCookingTime() {
		return this.cookingTime;
	}

	@Override
	@Nonnull
	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	@Nonnull
	public IRecipeSerializer<?> getSerializer() {
		return PolarisRecipeTypes.OBSIDIAN_FURNACE_SERIALIZER.get();
	}

	@Override
	@Nonnull
	public IRecipeType<?> getType() {
		return this.type;
	}

	@Override
	public boolean isSpecial() {
		return true;
	}

	@Override
	@ParametersAreNonnullByDefault
	public boolean matches(IInventory inventory, World worldIn) {
		if (ingredient.test(inventory.getItem(0))) {
			return ingredient.test(inventory.getItem(1));
		}
		return false;
	}

	@Override
	@Nonnull
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> ingredients = NonNullList.create();
		ingredients.add(Ingredient.merge(ingredients));
		return ingredients;
	}

	@Override
	public float getExperience() {
		return this.experience;
	}

	@Override
	@Nonnull
	public String getGroup() {
		return this.group;
	}

	@Override
	@Nonnull
	public ItemStack assemble(@Nonnull IInventory inventory) {
		return this.result.copy();
	}

	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}

	@Override
	@Nonnull
	public ItemStack getResultItem() {
		return this.result;
	}

	public static class ObsidianFurnaceRecipeType implements IRecipeType<ObsidianFurnaceRecipe> {
		@Override
		public String toString() {
			return new ResourceLocation(Polaris.MODID, "obsidian_furnace").toString();
		}
	}
}
