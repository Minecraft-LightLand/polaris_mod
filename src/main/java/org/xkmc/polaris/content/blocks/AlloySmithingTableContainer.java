package org.xkmc.polaris.content.blocks;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.world.World;
import org.xkmc.polaris.content.recipes.AlloySmithingRecipe;
import org.xkmc.polaris.init.registry.PolarisContainers;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

import java.util.Optional;

public class AlloySmithingTableContainer extends Container {

	private final CraftingInventory craftSlots = new CraftingInventory(this, 3, 3);
	private final CraftResultInventory resultSlots = new CraftResultInventory();
	private final IWorldPosCallable access;
	private final PlayerEntity player;

	public AlloySmithingTableContainer(ContainerType<AlloySmithingTableContainer> type, int wid, PlayerInventory plinv) {
		this(wid, plinv, IWorldPosCallable.NULL);
	}

	public AlloySmithingTableContainer(int wid, PlayerInventory plinv, IWorldPosCallable pos) {
		super(PolarisContainers.CT_ALLOY_SMITHING_TABLE.get(), wid);
		this.access = pos;
		this.player = plinv.player;
		this.addSlot(new CraftingResultSlot(plinv.player, this.craftSlots, this.resultSlots, 0, 124, 35));

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				this.addSlot(new Slot(this.craftSlots, j + i * 3, 30 + j * 18, 17 + i * 18));
			}
		}

		for (int k = 0; k < 3; ++k) {
			for (int i1 = 0; i1 < 9; ++i1) {
				this.addSlot(new Slot(plinv, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
			}
		}

		for (int l = 0; l < 9; ++l) {
			this.addSlot(new Slot(plinv, l, 8 + l * 18, 142));
		}

	}

	protected static void slotChangedCraftingGrid(int wid, World world, PlayerEntity player,
												  CraftingInventory inv, CraftResultInventory res) {
		if (!world.isClientSide) {
			ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
			ItemStack stack = ItemStack.EMPTY;
			Optional<AlloySmithingRecipe> optional = world.getServer().getRecipeManager()
					.getRecipeFor(PolarisRecipeTypes.RT_ALLOY_SMITHING, inv, world);
			if (optional.isPresent()) {
				ICraftingRecipe icraftingrecipe = optional.get();
				if (res.setRecipeUsed(world, serverPlayer, icraftingrecipe)) {
					stack = icraftingrecipe.assemble(inv);
				}
			}
			res.setItem(0, stack);
			serverPlayer.connection.send(new SSetSlotPacket(wid, 0, stack));
		}
	}

	public void slotsChanged(IInventory inventory) {
		this.access.execute((world, pos) -> slotChangedCraftingGrid(this.containerId, world, this.player, this.craftSlots, this.resultSlots));
	}

	public void removed(PlayerEntity player) {
		super.removed(player);
		this.access.execute((world, pos) -> this.clearContainer(player, world, this.craftSlots));
	}

	public boolean stillValid(PlayerEntity player) {
		return stillValid(this.access, player, Blocks.CRAFTING_TABLE);
	}

	public ItemStack quickMoveStack(PlayerEntity player, int index) {
		ItemStack result = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack base_item = slot.getItem();
			result = base_item.copy();
			if (index == 0) {
				this.access.execute((world, pos) -> base_item.getItem().onCraftedBy(base_item, world, player));
				if (!this.moveItemStackTo(base_item, 10, 46, true)) {
					return ItemStack.EMPTY;
				}

				slot.onQuickCraft(base_item, result);
			} else if (index >= 10 && index < 46) {
				if (!this.moveItemStackTo(base_item, 1, 10, false)) {
					if (index < 37) {
						if (!this.moveItemStackTo(base_item, 37, 46, false)) {
							return ItemStack.EMPTY;
						}
					} else if (!this.moveItemStackTo(base_item, 10, 37, false)) {
						return ItemStack.EMPTY;
					}
				}
			} else if (!this.moveItemStackTo(base_item, 10, 46, false)) {
				return ItemStack.EMPTY;
			}

			if (base_item.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}

			if (base_item.getCount() == result.getCount()) {
				return ItemStack.EMPTY;
			}

			ItemStack dropped = slot.onTake(player, base_item);
			if (index == 0) {
				player.drop(dropped, false);
			}
		}

		return result;
	}

	public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
		return slot.container != this.resultSlots && super.canTakeItemForPickAll(stack, slot);
	}

}
