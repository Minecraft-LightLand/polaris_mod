package org.xkmc.polaris.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

	@Inject(at = @At("TAIL"), method = "readAdditionalSaveData")
	public void readAdditionalSaveData(CompoundNBT tag, CallbackInfo ci) {
		PlayerEntity player = (PlayerEntity) (Object) this;
		player.collectEquipmentChanges();
		if (tag.contains("Health", 99)) {
			player.setHealth(tag.getFloat("Health"));
		}
	}

}
