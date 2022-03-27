package org.xkmc.polaris.content.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ActivatableItem extends Item {

	public ActivatableItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if (!world.isClientSide()) {
			setActivated(stack, !isActivated(stack));
		}
		return ActionResult.success(stack);
	}

	public boolean isActivated(ItemStack stack) {
		return stack.getOrCreateTag().getBoolean("activated");
	}

	public void setActivated(ItemStack stack, boolean activate) {
		stack.getOrCreateTag().putBoolean("activated", activate);
	}

}
