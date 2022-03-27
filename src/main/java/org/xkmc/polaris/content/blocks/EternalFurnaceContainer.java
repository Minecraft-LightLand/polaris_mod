package org.xkmc.polaris.content.blocks;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import org.xkmc.polaris.init.registry.PolarisContainers;
import org.xkmc.polaris.init.registry.PolarisItems;

public class EternalFurnaceContainer extends AbstractFurnaceContainer {

	public EternalFurnaceContainer(ContainerType<EternalFurnaceContainer> type, int wid, PlayerInventory inventory, PacketBuffer buffer) {
		super(type, IRecipeType.SMELTING, RecipeBookCategory.FURNACE, wid, inventory);
	}

	public EternalFurnaceContainer(int wid, PlayerInventory inventory, IInventory inv, IIntArray data) {
		super(PolarisContainers.CT_ETERNAL_FURNACE_CONTAINER.get(), IRecipeType.SMELTING,
				RecipeBookCategory.FURNACE, wid, inventory, inv, data);
	}

	@Override
	protected boolean isFuel(ItemStack stack) {
		return stack.getItem() == PolarisItems.SimpleItem.FLAME_OF_THE_SOUL.entry.get();
	}
}
