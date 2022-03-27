package org.xkmc.polaris.content.blocks;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import org.xkmc.polaris.init.registry.PolarisBlocks;
import org.xkmc.polaris.init.registry.PolarisItems;

public class EternalFurnaceTile extends AbstractFurnaceTileEntity {
	public EternalFurnaceTile() {
		super(PolarisBlocks.ETERNAL_FURNACE_TILE.get(), IRecipeType.SMELTING);
	}

	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.polaris.eternal_furnace_container");
	}

	protected Container createMenu(int wid, PlayerInventory inventory) {
		return new ObsidianNetherFurnaceContainer(wid, inventory, this, this.dataAccess);
	}

	@Override
	public void tick() {
		super.tick();
		litTime = litDuration;
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
