package org.xkmc.polaris.content.magic;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;

public class PersistentEffect extends Effect {

	public PersistentEffect(EffectType type, int color) {
		super(type, color);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int lv) {
		for (EffectInstance ins : entity.getActiveEffects()) {
			if (ins.getEffect().isBeneficial() && ins.getEffect() != this && ins.getDuration() < 30) {
				ins.duration = 30;
			}
		}
	}
}
