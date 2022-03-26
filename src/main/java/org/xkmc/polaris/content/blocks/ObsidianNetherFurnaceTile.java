package org.xkmc.polaris.content.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.xkmc.polaris.content.recipes.ObsidianFurnaceRecipe;
import org.xkmc.polaris.init.PolarisItems;
import org.xkmc.polaris.init.PolarisRecipeTypes;
import org.xkmc.polaris.init.PolarisTileEntities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class ObsidianNetherFurnaceTile extends TileEntity implements ITickableTileEntity {
	private final ItemStackHandler itemHandler = createHandler();
	private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);
	private final Inventory inventory = new Inventory(1);
	private final ObsidianNetherFurnaceItemNumber itemNumber = new ObsidianNetherFurnaceItemNumber();

	public ObsidianNetherFurnaceTile(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}

	public ObsidianNetherFurnaceTile() {
		this(PolarisTileEntities.OBSIDIAN_NETHER_FURNACE_TILE.get());
	}

	@Override
	public void load(@Nonnull BlockState state, CompoundNBT nbt) {
		itemHandler.deserializeNBT(nbt.getCompound("inv"));
		super.load(state, nbt);
	}

	@Nonnull
	@Override
	public CompoundNBT save(CompoundNBT compound) {
		compound.put("inv", itemHandler.serializeNBT());
		return super.save(compound);
	}

	private ItemStackHandler createHandler() {
		return new ItemStackHandler(2) {
			@Override
			protected void onContentsChanged(int slot) {
				setChanged();
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				switch (slot) {
					case 0:
						return stack.getItem() == Items.GLASS_PANE;
					case 1:
						return stack.getItem() == PolarisItems.DEMON_SOUL.get() || stack.getItem() == PolarisItems.HEART_OF_ORE.get();
					default:
						return false;
				}
			}

			@Override
			public int getSlotLimit(int slot) {
				return 1;
			}

			@Nonnull
			@Override
			public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
				if (!isItemValid(slot, stack)) {
					return stack;
				}
				return super.insertItem(slot, stack, simulate);
			}
		};
	}

	@Override
	@Nonnull
	public TileEntityType<?> getType() {
		return PolarisTileEntities.OBSIDIAN_NETHER_FURNACE_TILE.get();
	}

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return handler.cast();
		}
		return super.getCapability(cap);
	}

	public void craft() {
		Inventory inv = new Inventory(itemHandler.getSlots());
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			inv.setItem(i, itemHandler.getStackInSlot(i));
		}

		Optional<ObsidianFurnaceRecipe> recipe = this.level.getRecipeManager()
				.getRecipeFor(PolarisRecipeTypes.OBSIDIAN_FURNACE_RECIPE_TYPE, inv, this.level);

		recipe.ifPresent(iRecipe -> {
			ItemStack output = iRecipe.getResultItem();
			craftTheItem(output);
			setChanged();
		});
	}

	private void craftTheItem(ItemStack output) {
		itemHandler.extractItem(0, 1, false);
		itemHandler.extractItem(1, 1, false);
		itemHandler.insertItem(1, output, false);
	}

	@Override
	public void tick() {
		craft();
	}
}
