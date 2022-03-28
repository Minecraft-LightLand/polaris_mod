package org.xkmc.polaris.content.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import org.xkmc.polaris.init.Polaris;
import org.xkmc.polaris.init.registry.PolarisItems;

import java.util.function.Supplier;

public enum PolarisArmorMaterial implements IArmorMaterial {
	STARDUST("stardust", 1500, new int[]{3, 8, 6, 3}, 15,
			SoundEvents.ARMOR_EQUIP_DIAMOND, 3.0F, 0.1F,
			() -> Ingredient.of(PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get()),
			2, false, false),
	STARBURST("starburst", 2000, new int[]{3, 9, 6, 3}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.125F,
			() -> Ingredient.of(PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get()),
			3, false, false),
	STAR_LORD("star_lord", 2500, new int[]{4, 9, 7, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.15F,
			() -> Ingredient.of(PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get()),
			4, true, false),
	MS_BASE("ms_base", 1500, new int[]{3, 8, 6, 3}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
			() -> Ingredient.of(PolarisItems.SimpleItem.HEART_OF_ORE.entry.get()),
			2, false, false),
	MS_WHITE_TIGER("ms_white_tiger", 2000, new int[]{4, 9, 7, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
			() -> Ingredient.of(PolarisItems.SimpleItem.HEART_OF_ORE.entry.get()),
			3, false, false,
			get(Effects.MOVEMENT_SPEED, 0),
			get(Effects.DIG_SPEED, 0),
			get(Effects.DAMAGE_BOOST, 1)),
	MS_BLUE_DRAGON("ms_blue_dragon", 2000, new int[]{4, 9, 7, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
			() -> Ingredient.of(PolarisItems.SimpleItem.HEART_OF_ORE.entry.get()),
			3, false, false,
			get(Effects.REGENERATION, 0),
			get(Effects.DIG_SPEED, 0),
			get(Effects.CONDUIT_POWER, 0)),
	MS_VERMILION_BIRD("ms_vermilion_bird", 2000, new int[]{3, 8, 6, 3}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
			() -> Ingredient.of(PolarisItems.SimpleItem.HEART_OF_ORE.entry.get()),
			2, false, false,
			get(Effects.REGENERATION, 0),
			get(Effects.DIG_SPEED, 0),
			get(Effects.FIRE_RESISTANCE, 0)),
	MS_BLACK_TORTOISE("ms_black_tortoise", 2000, new int[]{4, 9, 7, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.2F,
			() -> Ingredient.of(PolarisItems.SimpleItem.HEART_OF_ORE.entry.get()),
			4, false, false,
			get(Effects.REGENERATION, 0),
			get(Effects.DAMAGE_RESISTANCE, 0),
			get(Effects.SATURATION, 0)),
	SUPREME_GENESIS("supreme_genesis", 8000, new int[]{6, 10, 8, 6}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 6.0F, 0.225F,
			() -> Ingredient.of(PolarisItems.SimpleItem.SPIRIT_OF_DIVINITY.entry.get()),
			10, true, true,
			get(Effects.DAMAGE_RESISTANCE, 1),
			get(Effects.DIG_SPEED, 1),
			get(Effects.DAMAGE_BOOST, 1),
			get(Effects.CONDUIT_POWER, 0),
			get(Effects.LUCK, 0)),
	SUPREME_GENESIS_WHITE("supreme_genesis_white", 8000, new int[]{6, 10, 8, 6}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 7.0F, 0.25F,
			() -> Ingredient.of(PolarisItems.SimpleItem.SPIRIT_OF_DIVINITY.entry.get()),
			10, true, true,
			get(Effects.DAMAGE_RESISTANCE, 1),
			get(Effects.DIG_SPEED, 1),
			get(Effects.DAMAGE_BOOST, 1),
			get(Effects.CONDUIT_POWER, 0),
			get(Effects.LUCK, 0)),
	EMPERORS_NEW_CLOTHES("emperors_new_clothes", 2000, new int[]{4, 8, 6, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
			() -> Ingredient.of(PolarisItems.SimpleItem.THE_SOIL_OF_EVERYTHING.entry.get()),
			2, false, false),
	LITTLE_CAT_YELLOW("little_cat_yellow", 5, new int[]{4, 8, 6, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
			() -> Ingredient.of(PolarisItems.SimpleItem.THE_SOIL_OF_EVERYTHING.entry.get()),
			2, false, false),
	LITTLE_CAT_BLUE("little_cat_blue", 5, new int[]{4, 8, 6, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
			() -> Ingredient.of(PolarisItems.SimpleItem.THE_SOIL_OF_EVERYTHING.entry.get()),
			2, false, false),
	LITTLE_CAT_PINK("little_cat_pink", 5, new int[]{4, 8, 6, 4}, 15,
			SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F,
			() -> Ingredient.of(PolarisItems.SimpleItem.THE_SOIL_OF_EVERYTHING.entry.get()),
			2, false, false),
	;

	public final String name;
	private final int durability;
	private final int[] prot;
	private final int ench;
	private final SoundEvent sound;
	private final float toughness;
	private final float kbRes;
	private final LazyValue<Ingredient> repair;

	public final int health;
	public final boolean fly, home;
	public final EffectInstance[] ins;

	PolarisArmorMaterial(String name, int durability, int[] prot, int ench, SoundEvent sound, float toughness,
						 float kbRes, Supplier<Ingredient> repair,
						 int health, boolean fly, boolean home, EffectInstance... ins) {
		this.name = name;
		this.durability = durability;
		this.prot = prot;
		this.ench = ench;
		this.sound = sound;
		this.toughness = toughness;
		this.kbRes = kbRes;
		this.repair = new LazyValue<>(repair);

		this.health = health;
		this.fly = fly;
		this.home = home;
		this.ins = ins;
	}

	@Override
	public int getDurabilityForSlot(EquipmentSlotType slotType) {
		return this.durability;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlotType slotType) {
		return this.prot[slotType.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return this.ench;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repair.get();
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
		return this.kbRes;
	}

	private static EffectInstance get(Effect eff, int lv) {
		return new EffectInstance(eff, 40, lv, true, false, true);
	}

}
