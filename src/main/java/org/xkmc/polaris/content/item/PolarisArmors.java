package org.xkmc.polaris.content.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Optional;
import java.util.UUID;

public class PolarisArmors extends ArmorItem {

	private final PolarisArmorMaterial armorMaterial;
	private final Multimap<Attribute, AttributeModifier> attributes;

	public PolarisArmors(PolarisArmorMaterial materialIn, EquipmentSlotType slots, Properties settings) {
		super(materialIn, slots, settings);
		armorMaterial = materialIn;
		attributes = ImmutableMultimap.<Attribute, AttributeModifier>builder()
				.putAll(getDefaultAttributeModifiers(slots)).put(Attributes.MAX_HEALTH,
						new AttributeModifier(UUID.randomUUID().toString(), armorMaterial.health,
								AttributeModifier.Operation.ADDITION)).build();
	}

	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		if (!world.isClientSide() && slot == EquipmentSlotType.CHEST && hasFullSuitOfArmorOn(player)) {
			for (EffectInstance ins : armorMaterial.ins) {
				EffectInstance old = player.getEffect(ins.getEffect());
				if (old == null || old.getDuration() < 20) {
					player.addEffect(new EffectInstance(ins));
				}
			}
			if (armorMaterial.home && player.getY() < -60) {
				teleportHome((ServerWorld) world, (ServerPlayerEntity) player);
			}
		}
		super.onArmorTick(stack, world, player);
	}

	private void teleportHome(ServerWorld world, ServerPlayerEntity player) {


		if (world.dimension() == player.getRespawnDimension()) {

			BlockPos blockpos = player.getRespawnPosition();
			float f = player.getRespawnAngle();
			boolean flag = player.isRespawnForced();
			ServerWorld serverworld = world.getServer().getLevel(player.getRespawnDimension());
			Optional<Vector3d> optional;
			if (serverworld != null && blockpos != null) {
				optional = PlayerEntity.findRespawnPositionAndUseSpawnBlock(serverworld, blockpos, f, flag, true);
			} else {
				optional = Optional.empty();
			}
			Vector3d pos = optional.orElseGet(() -> {
				BlockPos bpos = world.getSharedSpawnPos();
				return new Vector3d(bpos.getX() + 0.5, bpos.getY() + 1, bpos.getZ() + 0.5);
			});
			player.teleportTo(pos.x, pos.y, pos.z);
		} else {
			world.getServer().getPlayerList().respawn(player, true);
		}
	}

	public boolean hasFullSuitOfArmorOn(PlayerEntity player) {
		for (int i = 2; i < 6; i++) {
			EquipmentSlotType type = EquipmentSlotType.values()[i];
			ItemStack stack = player.getItemBySlot(type);
			if (stack.getItem() instanceof PolarisArmors) {
				if (((PolarisArmors) stack.getItem()).armorMaterial == armorMaterial)
					continue;
			}
			return false;
		}
		return true;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
		return slot == this.slot ? attributes : ImmutableMultimap.of();
	}

	public boolean canFly(PlayerEntity player) {
		return armorMaterial.fly && hasFullSuitOfArmorOn(player);
	}
}
