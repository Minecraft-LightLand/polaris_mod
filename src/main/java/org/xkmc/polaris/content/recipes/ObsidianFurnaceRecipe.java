package org.xkmc.polaris.content.recipes;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

import javax.annotation.Nonnull;

public class ObsidianFurnaceRecipe extends AbstractCookingRecipe implements IRecipe<IInventory> {

	public ObsidianFurnaceRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
		super(PolarisRecipeTypes.RT_OBSIDIAN_FURNACE, id, group, ingredient, result, experience, cookingTime);
	}

	@Override
	@Nonnull
	public IRecipeSerializer<?> getSerializer() {
		return PolarisRecipeTypes.RS_OBSIDIAN_FURNACE.get();
	}

}
