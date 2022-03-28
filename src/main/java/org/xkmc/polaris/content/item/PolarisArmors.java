package org.xkmc.polaris.content.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPlayerPositionLookPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.minecraftforge.event.entity.living.EntityTeleportEvent;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;
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
				if (old == null || old.getDuration() <= 20) {
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
		ServerWorld targetWorld = world.getServer().getLevel(player.getRespawnDimension());
		BlockPos blockpos = player.getRespawnPosition();
		float f = player.getRespawnAngle();
		boolean flag = player.isRespawnForced();
		Optional<Vector3d> optional;
		if (targetWorld != null && blockpos != null) {
			optional = PlayerEntity.findRespawnPositionAndUseSpawnBlock(targetWorld, blockpos, f, flag, true);
		} else {
			optional = Optional.empty();
		}
		Vector3d pos;
		if (targetWorld == null || !optional.isPresent()) {
			targetWorld = world.getServer().overworld();
			BlockPos bpos = targetWorld.getSharedSpawnPos();
			pos = new Vector3d(bpos.getX() + 0.5, bpos.getY() + 1, bpos.getZ() + 0.5);
		} else {
			pos = optional.get();
		}
		if (world == targetWorld) {
			player.teleportTo(pos.x, pos.y, pos.z);
		} else {
			performTeleport(player, targetWorld, pos.x, pos.y, pos.z, player.getRespawnAngle(), player.getYHeadRot());
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

	private static void performTeleport(Entity entity, ServerWorld world, double x, double y, double z, float yRot, float xRot) {
		Set<SPlayerPositionLookPacket.Flags> set = EnumSet.noneOf(SPlayerPositionLookPacket.Flags.class);
		EntityTeleportEvent.TeleportCommand event = net.minecraftforge.event.ForgeEventFactory.onEntityTeleportCommand(entity, x, y, z);
		if (event.isCanceled()) return;
		x = event.getTargetX();
		y = event.getTargetY();
		z = event.getTargetZ();

		if (entity instanceof ServerPlayerEntity) {
			ChunkPos chunkpos = new ChunkPos(new BlockPos(x, y, z));
			world.getChunkSource().addRegionTicket(TicketType.POST_TELEPORT, chunkpos, 1, entity.getId());
			entity.stopRiding();
			if (((ServerPlayerEntity) entity).isSleeping()) {
				((ServerPlayerEntity) entity).stopSleepInBed(true, true);
			}

			if (world == entity.level) {
				((ServerPlayerEntity) entity).connection.teleport(x, y, z, yRot, xRot, set);
			} else {
				((ServerPlayerEntity) entity).teleportTo(world, x, y, z, yRot, xRot);
			}

			entity.setYHeadRot(yRot);
		} else {
			float f1 = MathHelper.wrapDegrees(yRot);
			float f = MathHelper.wrapDegrees(xRot);
			f = MathHelper.clamp(f, -90.0F, 90.0F);
			if (world == entity.level) {
				entity.moveTo(x, y, z, f1, f);
				entity.setYHeadRot(f1);
			} else {
				entity.unRide();
				Entity e = entity;
				entity = entity.getType().create(world);
				if (entity == null) {
					return;
				}

				entity.restoreFrom(e);
				entity.moveTo(x, y, z, f1, f);
				entity.setYHeadRot(f1);
				world.addFromAnotherDimension(entity);
			}
		}

		if (!(entity instanceof LivingEntity) || !((LivingEntity) entity).isFallFlying()) {
			entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D));
			entity.setOnGround(true);
		}

		if (entity instanceof CreatureEntity) {
			((CreatureEntity) entity).getNavigation().stop();
		}

	}

}
