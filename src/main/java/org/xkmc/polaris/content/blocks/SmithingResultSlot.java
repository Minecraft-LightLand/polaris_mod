package org.xkmc.polaris.content.blocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.ForgeHooks;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

public class SmithingResultSlot extends Slot {

	private final CraftingInventory craftSlots;
	private final PlayerEntity player;
	private int removeCount;

	public SmithingResultSlot(PlayerEntity player, CraftingInventory grid, IInventory inv, int index, int x, int y) {
		super(inv, index, x, y);
		this.player = player;
		this.craftSlots = grid;
	}

	public boolean mayPlace(ItemStack stack) {
		return false;
	}

	public ItemStack remove(int count) {
		if (this.hasItem()) {
			this.removeCount += Math.min(count, this.getItem().getCount());
		}

		return super.remove(count);
	}

	protected void onQuickCraft(ItemStack stack, int count) {
		this.removeCount += count;
		this.checkTakeAchievements(stack);
	}

	protected void onSwapCraft(int count) {
		this.removeCount += count;
	}

	protected void checkTakeAchievements(ItemStack stack) {
		if (this.removeCount > 0) {
			stack.onCraftedBy(this.player.level, this.player, this.removeCount);
			net.minecraftforge.fml.hooks.BasicEventHooks.firePlayerCraftingEvent(this.player, stack, this.craftSlots);
		}

		if (this.container instanceof IRecipeHolder) {
			((IRecipeHolder) this.container).awardUsedRecipes(this.player);
		}

		this.removeCount = 0;
	}

	@Override
	public boolean mayPickup(PlayerEntity player) {
		if (!player.abilities.instabuild && player.experienceLevel < 3)
			return false;
		return super.mayPickup(player);
	}

	@Override
	public ItemStack onTake(PlayerEntity player, ItemStack stack) {
		player.giveExperienceLevels(-3);
		this.checkTakeAchievements(stack);
		ForgeHooks.setCraftingPlayer(player);
		NonNullList<ItemStack> remainders = player.level.getRecipeManager().getRemainingItemsFor(PolarisRecipeTypes.RT_ALLOY_SMITHING, this.craftSlots, player.level);
		ForgeHooks.setCraftingPlayer(null);
		for (int i = 0; i < remainders.size(); ++i) {
			ItemStack original = this.craftSlots.getItem(i);
			ItemStack remainder = remainders.get(i);
			if (!original.isEmpty()) {
				this.craftSlots.removeItem(i, 1);
				original = this.craftSlots.getItem(i);
			}

			if (!remainder.isEmpty()) {
				if (original.isEmpty()) {
					this.craftSlots.setItem(i, remainder);
				} else if (ItemStack.isSame(original, remainder) && ItemStack.tagMatches(original, remainder)) {
					remainder.grow(original.getCount());
					this.craftSlots.setItem(i, remainder);
				} else if (!this.player.inventory.add(remainder)) {
					this.player.drop(remainder, false);
				}
			}
		}

		return stack;
	}
}
