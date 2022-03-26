package org.xkmc.polaris.content.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import org.xkmc.polaris.content.util.PolarisArmorMaterial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PolarisArmors extends ArmorItem {
    public static final List<Effect> EFFECTS = new ArrayList<>();

    public static List<Effect> getEffects() {
        EFFECTS.add(Effects.DIG_SPEED);
        EFFECTS.add(Effects.HEALTH_BOOST);
        return EFFECTS;
    }

    private static final Map<IArmorMaterial, List<Effect>> MATERIAL_EFFECT_MAP =
            new ImmutableMap.Builder<IArmorMaterial, List<Effect>>()
                    .put(PolarisArmorMaterial.STARDUST, getEffects())
                    .build();

    public PolarisArmors(IArmorMaterial materialIn, EquipmentSlotType slots, Properties settings) {
        super(materialIn, slots, settings);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (hasFullSuitOfArmorOn(player) && !player.isCreative()) {
            evaluateArmorEffects(player);
        }
        super.onArmorTick(stack, world, player);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<IArmorMaterial, List<Effect>> entry : MATERIAL_EFFECT_MAP.entrySet()) {
            IArmorMaterial mapArmorMaterial = entry.getKey();
            List<Effect> mapStatusEffects = entry.getValue();
            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                for (Effect mapStatusEffect : mapStatusEffects) {
                    addStatusEffectsForMaterial(player, mapArmorMaterial, mapStatusEffect);
                }

            }
        }
    }

    private void addStatusEffectsForMaterial(PlayerEntity player, IArmorMaterial mapArmorMaterial, Effect mapStatusEffect) {
        boolean hasPlayerEffect = !Objects.equals(player.getEffect(mapStatusEffect), null);
        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect && player.tickCount % 1000 == 0) {
//            player.addEffect(new EffectInstance(mapStatusEffect, 100));
            player.setAbsorptionAmount(2f);
        }
    }


    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlotType.HEAD);
        ItemStack chestplate = player.getItemBySlot(EquipmentSlotType.CHEST);
        ItemStack leggings = player.getItemBySlot(EquipmentSlotType.LEGS);
        ItemStack boots = player.getItemBySlot(EquipmentSlotType.FEET);
        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(IArmorMaterial material, PlayerEntity player) {
        ArmorItem helmet = ((ArmorItem) player.getItemBySlot(EquipmentSlotType.HEAD).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getItemBySlot(EquipmentSlotType.CHEST).getItem());
        ArmorItem leggings = ((ArmorItem) player.getItemBySlot(EquipmentSlotType.LEGS).getItem());
        ArmorItem boots = ((ArmorItem) player.getItemBySlot(EquipmentSlotType.FEET).getItem());

        return helmet.getMaterial().equals(material)
                && chestplate.getMaterial().equals(material)
                && leggings.getMaterial().equals(material)
                && boots.getMaterial().equals(material);
    }
}
