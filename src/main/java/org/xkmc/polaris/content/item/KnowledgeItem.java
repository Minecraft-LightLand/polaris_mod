package org.xkmc.polaris.content.item;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraftforge.common.ForgeSpawnEggItem;

public class KnowledgeItem extends Item {

	public KnowledgeItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResultType useOn(ItemUseContext ctx) {
		PlayerEntity player = ctx.getPlayer();
		if (player != null && ctx.getLevel().getBlockState(ctx.getClickedPos()).getBlock() == Blocks.SPAWNER) {
			if (!ctx.getLevel().isClientSide()) {
				ctx.getLevel().setBlockAndUpdate(ctx.getClickedPos(), Blocks.AIR.defaultBlockState());
				ctx.getItemInHand().shrink(1);
				if (!player.inventory.add(new ItemStack(Blocks.SPAWNER))) {
					player.drop(new ItemStack(Blocks.SPAWNER), false, false);
				}
			}
			return ActionResultType.sidedSuccess(player.level.isClientSide);
		}
		return ActionResultType.FAIL;
	}

	@Override
	public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity player, LivingEntity target, Hand hand) {
		SpawnEggItem item = ForgeSpawnEggItem.fromEntityType(target.getType());
		if (item != null) {
			if (!player.level.isClientSide()) {
				stack.shrink(1);
				player.drop(new ItemStack(item), false, false);
			}
			return ActionResultType.sidedSuccess(player.level.isClientSide);
		}
		return ActionResultType.FAIL;
	}
}
