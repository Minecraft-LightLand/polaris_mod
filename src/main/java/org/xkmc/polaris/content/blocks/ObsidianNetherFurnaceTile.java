package org.xkmc.polaris.content.blocks;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.xkmc.polaris.init.registry.PolarisBlocks;
import org.xkmc.polaris.init.registry.PolarisItems;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

public class ObsidianNetherFurnaceTile extends AbstractFurnaceTileEntity {
	public ObsidianNetherFurnaceTile() {
		super(PolarisBlocks.OBSIDIAN_NETHER_FURNACE_TILE.get(), PolarisRecipeTypes.RT_OBSIDIAN_FURNACE);
	}

	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.polaris.obsidian_nether_furnace_container");
	}

	protected Container createMenu(int wid, PlayerInventory inventory) {
		return new ObsidianNetherFurnaceContainer(wid, inventory, this, this.dataAccess);
	}

	public boolean canPlaceItem(int slot, ItemStack stack) {
		if (slot == 2) {
			return false;
		} else if (slot != 1) {
			return true;
		} else {
			return stack.getItem() == PolarisItems.SimpleItem.FLAME_OF_THE_SOUL.entry.get();
		}
	}

	protected int getBurnDuration(ItemStack stack) {
		if (stack.getItem() == PolarisItems.SimpleItem.FLAME_OF_THE_SOUL.entry.get()) {
			return 1200;
		} else {
			return 0;
		}
	}


}
