package org.xkmc.polaris.content.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import org.xkmc.polaris.init.Polaris;
import org.xkmc.polaris.init.registry.PolarisItems;

import java.util.function.Supplier;

public enum PolarisArmorMaterial implements IArmorMaterial {
	STARDUST("stardust", 5, new int[]{3, 8, 6, 3}, 15,
			SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.1F, () -> Ingredient.of(PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get())),
	STARBURST("starburst", 5, new int[]{3, 9, 6, 3}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.125F, () -> Ingredient.of(PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get())),
	STAR_LORD("star_lord", 5, new int[]{4, 9, 7, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.15F, () -> Ingredient.of(PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get())),
	MS_BASE("ms_base", 5, new int[]{3, 8, 6, 3}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(PolarisItems.HEART_OF_ORE.get())),
	MS_WHITE_TIGER("ms_white_tiger", 5, new int[]{4, 9, 7, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(PolarisItems.HEART_OF_ORE.get())),
	MS_BLUE_DRAGON("ms_blue_dragon", 5, new int[]{4, 9, 7, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(PolarisItems.HEART_OF_ORE.get())),
	MS_VERMILION_BIRD("ms_vermilion_bird", 5, new int[]{3, 8, 6, 3}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(PolarisItems.HEART_OF_ORE.get())),
	MS_BLACK_TORTOISE("ms_black_tortoise", 5, new int[]{4, 9, 7, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.2F, () -> Ingredient.of(PolarisItems.HEART_OF_ORE.get())),
	SUPREME_GENESIS("supreme_genesis", 5, new int[]{7, 10, 10, 7}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.225F, () -> Ingredient.of(PolarisItems.SimpleItem.SPIRIT_OF_DIVINITY.entry.get())),
	SUPREME_GENESIS_WHITE("supreme_genesis_white", 6, new int[]{8, 11, 11, 8}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 7.0F, 0.25F, () -> Ingredient.of(PolarisItems.SimpleItem.SPIRIT_OF_DIVINITY.entry.get())),
	EMPERORS_NEW_CLOTHES("emperors_new_clothes", 5, new int[]{4, 8, 6, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(PolarisItems.THE_SOIL_OF_EVERYTHING.get())),
	LITTLE_CAT_YELLOW("little_cat_yellow", 5, new int[]{4, 8, 6, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(PolarisItems.THE_SOIL_OF_EVERYTHING.get())),
	LITTLE_CAT_BLUE("little_cat_blue", 5, new int[]{4, 8, 6, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(PolarisItems.THE_SOIL_OF_EVERYTHING.get())),
	LITTLE_CAT_PINK("little_cat_pink", 5, new int[]{4, 8, 6, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> Ingredient.of(PolarisItems.THE_SOIL_OF_EVERYTHING.get()));
	public final String name;
	private final int durabilityMultiplier;
	private final int[] slotProtections;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyValue<Ingredient> repairIngredient;

	PolarisArmorMaterial(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.slotProtections = slotProtections;
		this.enchantmentValue = enchantmentValue;
		this.sound = soundEvent;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = new LazyValue<>(repairIngredient);
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlotType slotType) {
		return this.slotProtections[slotType.getIndex()] * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlotType slotType) {
		return this.slotProtections[slotType.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String getName() {
		return Polaris.MODID + ":" + this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

}
