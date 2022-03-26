package org.xkmc.polaris.content.blocks;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.RecipeBookCategory;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

public class ObsidianNetherFurnaceContainer extends AbstractFurnaceContainer {
	public ObsidianNetherFurnaceContainer(ContainerType<ObsidianNetherFurnaceContainer> type, int wid, PlayerInventory inventory) {
		super(type, PolarisRecipeTypes.RT_OBSIDIAN_FURNACE, RecipeBookCategory.FURNACE, wid, inventory);
	}
}
