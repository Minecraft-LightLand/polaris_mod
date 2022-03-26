package org.xkmc.polaris.content.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.xkmc.polaris.content.recipes.ObsidianFurnaceRecipe;
import org.xkmc.polaris.init.registry.PolarisBlocks;
import org.xkmc.polaris.init.registry.PolarisItems;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class ObsidianNetherFurnaceTile extends AbstractFurnaceTileEntity {
	public ObsidianNetherFurnaceTile() {
		super(PolarisBlocks.OBSIDIAN_NETHER_FURNACE_TILE.get(), PolarisRecipeTypes.RT_OBSIDIAN_FURNACE);
	}

	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.furnace");
	}

	protected Container createMenu(int wid, PlayerInventory inventory) {
		return new ObsidianNetherFurnaceContainer(wid, inventory, this, this.dataAccess);
	}
}
