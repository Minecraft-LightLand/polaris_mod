package org.xkmc.polaris.content.blocks;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IntArray;
import org.xkmc.polaris.init.PolarisContainers;
import org.xkmc.polaris.content.recipes.PolarisRecipeTypes;

public class ObsidianNetherFurnaceContainer extends AbstractFurnaceContainer {
    public ObsidianNetherFurnaceContainer(int containerID, PlayerInventory playerInventory) {
        super(PolarisContainers.OBSIDIAN_NETHER_FURNACE_CONTAINER.get(), PolarisRecipeTypes.OBSIDIAN_FURNACE_RECIPE_TYPE, RecipeBookCategory.FURNACE, containerID, playerInventory);
    }
    public ObsidianNetherFurnaceContainer(int containerID, PlayerInventory playerInventory, IInventory data, IntArray slots) {
        super(PolarisContainers.OBSIDIAN_NETHER_FURNACE_CONTAINER.get(), PolarisRecipeTypes.OBSIDIAN_FURNACE_RECIPE_TYPE, RecipeBookCategory.FURNACE, containerID, playerInventory, data,slots);
    }
}
