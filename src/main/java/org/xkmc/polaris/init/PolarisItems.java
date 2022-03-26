package org.xkmc.polaris.init;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import org.xkmc.polaris.content.item.PolarisArmorMaterial;
import org.xkmc.polaris.content.item.PolarisArmors;
import org.xkmc.polaris.content.item.PolarisItemGroup;

@SuppressWarnings({"rawtype", "unchecked", "unused"})
public class PolarisItems {

	static {
		Polaris.REGISTRATE.itemGroup(() -> PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS);
	}

	public static final ItemEntry<Item>
			HEART_OF_ORE,
			PURGATORY_SOIL,
			DEMON_SOUL,
			THE_SOIL_OF_EVERYTHING,
			NETHER_STAR,
			NETHER_STAR_ESSENCE,
			END_ALLOY_INGOT,
			END_ESSENCE,
			NETHER_ALLOY_INGOT_ESSENCE,
			NETHER_ALLOY_ESSENCE,
			THE_VOID_OF_SOURCE,
			FLAME_OF_THE_SOUL,
			SPIRIT_OF_DIVINITY,
			LIFE_OF_SEEDS,
			CRYING_GHOST;

	public static final ItemEntry<Item>[] STAR_COIN;
	public static final ItemEntry<PolarisArmors>[][] ARMORS;

	static {
		{
			HEART_OF_ORE = Polaris.REGISTRATE.item("heart_of_ore", p -> new Item(p.durability(300)))
					.defaultModel().defaultLang().register();
			THE_SOIL_OF_EVERYTHING = Polaris.REGISTRATE.item("the_soil_of_everything", p -> new Item(p.durability(500)))
					.defaultModel().defaultLang().register();

			PURGATORY_SOIL = Polaris.REGISTRATE.item("purgatory_soil", Item::new)
					.defaultModel().defaultLang().register();
			DEMON_SOUL = Polaris.REGISTRATE.item("demon_soul", Item::new)
					.defaultModel().defaultLang().register();
			NETHER_STAR = Polaris.REGISTRATE.item("nether_star", Item::new)
					.defaultModel().defaultLang().register();
			NETHER_STAR_ESSENCE = Polaris.REGISTRATE.item("nether_star_essence", Item::new)
					.defaultModel().defaultLang().register();
			END_ALLOY_INGOT = Polaris.REGISTRATE.item("end_alloy_ingot", Item::new)
					.defaultModel().defaultLang().register();
			END_ESSENCE = Polaris.REGISTRATE.item("end_essence", Item::new)
					.defaultModel().defaultLang().register();
			NETHER_ALLOY_INGOT_ESSENCE = Polaris.REGISTRATE.item("nether_alloy_ingot_essence", Item::new)
					.defaultModel().defaultLang().register();
			NETHER_ALLOY_ESSENCE = Polaris.REGISTRATE.item("nether_alloy_essence", Item::new)
					.defaultModel().defaultLang().register();
			THE_VOID_OF_SOURCE = Polaris.REGISTRATE.item("the_void_of_source", Item::new)
					.defaultModel().defaultLang().register();
			FLAME_OF_THE_SOUL = Polaris.REGISTRATE.item("flame_of_the_soul", Item::new)
					.defaultModel().defaultLang().register();
			SPIRIT_OF_DIVINITY = Polaris.REGISTRATE.item("spirit_of_divinity", Item::new)
					.defaultModel().defaultLang().register();
			LIFE_OF_SEEDS = Polaris.REGISTRATE.item("life_of_seeds", Item::new)
					.defaultModel().defaultLang().register();
			CRYING_GHOST = Polaris.REGISTRATE.item("crying_ghost", Item::new)
					.defaultModel().defaultLang().register();
		}
		{
			int n = 8;
			STAR_COIN = new ItemEntry[n];
			for (int i = 0; i < n; i++) {
				STAR_COIN[i] = Polaris.REGISTRATE.item("star_coin_" + (i + 1), Item::new)
						.defaultModel().defaultLang().register();
			}
		}
		{
			int n = PolarisArmorMaterial.values().length;
			ARMORS = new ItemEntry[n][4];
			for (int i = 0; i < n; i++) {
				PolarisArmorMaterial mat = PolarisArmorMaterial.values()[i];
				ARMORS[i][0] = Polaris.REGISTRATE.item(mat.name + "_helmet",
						p -> new PolarisArmors(mat, EquipmentSlotType.HEAD, p)).defaultModel().defaultLang().register();
				ARMORS[i][1] = Polaris.REGISTRATE.item(mat.name + "_chestplate",
						p -> new PolarisArmors(mat, EquipmentSlotType.CHEST, p)).defaultModel().defaultLang().register();
				ARMORS[i][2] = Polaris.REGISTRATE.item(mat.name + "_leggings",
						p -> new PolarisArmors(mat, EquipmentSlotType.LEGS, p)).defaultModel().defaultLang().register();
				ARMORS[i][3] = Polaris.REGISTRATE.item(mat.name + "_boots",
						p -> new PolarisArmors(mat, EquipmentSlotType.FEET, p)).defaultModel().defaultLang().register();
			}
		}
	}

	public static void register() {
	}

}
