package org.xkmc.polaris.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import org.xkmc.polaris.content.item.PolarisArmors;
import org.xkmc.polaris.content.util.PolarisArmorMaterial;
import org.xkmc.polaris.content.util.PolarisItemGroup;

@SuppressWarnings({"rawtype", "unchecked", "unused"})
public class PolarisItems {

	public static final RegistryObject<Item> HEART_OF_ORE = Registration.ITEMS.register("heart_of_ore",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS).durability(300)));

	public static final RegistryObject<Item> PURGATORY_SOIL = Registration.ITEMS.register("purgatory_soil",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> DEMON_SOUL = Registration.ITEMS.register("demon_soul",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> THE_SOIL_OF_EVERYTHING = Registration.ITEMS.register(
			"the_soil_of_everything",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS).durability(500)));

	public static final RegistryObject<Item> NETHER_STAR = Registration.ITEMS.register("nether_star",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> NETHER_STAR_ESSENCE = Registration.ITEMS.register("nether_star_essence",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> END_ALLOY_INGOT = Registration.ITEMS.register("end_alloy_ingot",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> END_ESSENCE = Registration.ITEMS.register(
			"end_essence",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> NETHER_ALLOY_INGOT_ESSENCE = Registration.ITEMS.register(
			"nether_alloy_ingot_essence",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> NETHER_ALLOY_ESSENCE = Registration.ITEMS.register(
			"nether_alloy_essence",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> ACTIVATING_CORE_1 = Registration.ITEMS.register("activating_core_1",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> ACTIVATING_CORE_2 = Registration.ITEMS.register("activating_core_2",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> ACTIVATING_CORE_3 = Registration.ITEMS.register("activating_core_3",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> ACTIVATING_CORE_4 = Registration.ITEMS.register("activating_core_4",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> ACTIVATING_CORE_POWER = Registration.ITEMS.register(
			"activating_core_power",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> INACTIVE_CORE_1 = Registration.ITEMS.register("inactive_core_1",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> INACTIVE_CORE_2 = Registration.ITEMS.register("inactive_core_2",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> INACTIVE_CORE_3 = Registration.ITEMS.register("inactive_core_3",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> INACTIVE_CORE_4 = Registration.ITEMS.register("inactive_core_4",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> INACTIVE_CORE_POWER = Registration.ITEMS.register("inactive_core_power",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> THE_VOID_OF_SOURCE = Registration.ITEMS.register("the_void_of_source",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> FLAME_OF_THE_SOUL = Registration.ITEMS.register("flame_of_the_soul",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item> SPIRIT_OF_DIVINITY = Registration.ITEMS.register("spirit_of_divinity",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS).durability(300)));

	public static final RegistryObject<Item> LIFE_OF_SEEDS = Registration.ITEMS.register("life_of_seeds",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS).durability(300)));

	public static final RegistryObject<Item> CRYING_GHOST = Registration.ITEMS.register("crying_ghost",
			() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));

	public static final RegistryObject<Item>[] STAR_COIN;
	public static final RegistryObject<ArmorItem>[][] ARMORS;

	static {
		{
			int n = 8;
			STAR_COIN = new RegistryObject[n];
			for (int i = 0; i < n; i++) {
				STAR_COIN[i] = Registration.ITEMS.register("star_coin_" + i,
						() -> new Item(new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS)));
			}
		}
		{
			int n = PolarisArmorMaterial.values().length;
			ARMORS = new RegistryObject[n][4];
			for (int i = 0; i < n; i++) {
				PolarisArmorMaterial mat = PolarisArmorMaterial.values()[i];
				ARMORS[i][0] = Registration.ITEMS.register(mat.getName() + "_helmet", () -> new PolarisArmors(mat,
						EquipmentSlotType.HEAD, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));
				ARMORS[i][1] = Registration.ITEMS.register(mat.getName() + "_chestplate", () -> new PolarisArmors(mat,
						EquipmentSlotType.CHEST, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));
				ARMORS[i][2] = Registration.ITEMS.register(mat.getName() + "_leggings", () -> new PolarisArmors(mat,
						EquipmentSlotType.LEGS, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));
				ARMORS[i][3] = Registration.ITEMS.register(mat.getName() + "_boots", () -> new PolarisArmors(mat,
						EquipmentSlotType.FEET, new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_ARMORS)));
			}
		}
	}

	public static void register() {
	}

}
