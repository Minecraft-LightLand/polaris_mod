package org.xkmc.polaris.content.blocks;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import org.xkmc.polaris.init.registry.PolarisContainers;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

public class ObsidianNetherFurnaceContainer extends AbstractFurnaceContainer {

	public ObsidianNetherFurnaceContainer(ContainerType<ObsidianNetherFurnaceContainer> type, int wid, PlayerInventory inventory, PacketBuffer buffer) {
		super(type, PolarisRecipeTypes.RT_OBSIDIAN_FURNACE, RecipeBookCategory.FURNACE, wid, inventory);
	}

	public ObsidianNetherFurnaceContainer(int wid, PlayerInventory inventory, IInventory inv, IIntArray data) {
		super(PolarisContainers.OBSIDIAN_NETHER_FURNACE_CONTAINER.get(), PolarisRecipeTypes.RT_OBSIDIAN_FURNACE,
				RecipeBookCategory.FURNACE, wid, inventory, inv, data);
	}

}
