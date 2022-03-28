package org.xkmc.polaris.init.registry;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import org.xkmc.polaris.content.item.ActivatableItem;
import org.xkmc.polaris.content.item.PolarisArmorMaterial;
import org.xkmc.polaris.content.item.PolarisArmors;
import org.xkmc.polaris.content.item.PolarisItemGroup;
import org.xkmc.polaris.init.Polaris;

import java.util.Locale;

@SuppressWarnings({"rawtype", "unchecked", "unused"})
public class PolarisItems {

	public enum SimpleItem {
		PURGATORY_SOIL,
		DEMON_SOUL,
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
		CRYING_GHOST,
		EMPTY_RUNE_CORE,
		RUNE_CORE_1,
		RUNE_CORE_2,
		RUNE_CORE_3,
		RUNE_CORE_4,
		POWER_RUNE_CORE,
		RUNE_CORE_1_ACTIVATED,
		RUNE_CORE_2_ACTIVATED,
		RUNE_CORE_3_ACTIVATED,
		RUNE_CORE_4_ACTIVATED,
		POWER_RUNE_CORE_ACTIVATED;

		public final ItemEntry<Item> entry;

		SimpleItem() {
			entry = Polaris.REGISTRATE.item(name().toLowerCase(Locale.ROOT), Item::new)
					.defaultModel().defaultLang().register();
		}

		public static void register() {
		}

	}

	public enum RuneCoreItem {
		;

		public static final ResourceLocation ID = new ResourceLocation(Polaris.MODID, "activated");


		public final ItemEntry<ActivatableItem> entry;

		RuneCoreItem() {
			entry = Polaris.REGISTRATE.item(name().toLowerCase(Locale.ROOT), ActivatableItem::new)
					.model(RuneCoreItem::model).defaultLang().register();
		}

		private static void model(DataGenContext<Item, ActivatableItem> ctx, RegistrateItemModelProvider pvd) {
			pvd.generated(ctx).override().predicate(ID, 1).model(
					pvd.getBuilder(ctx.getName() + "_activated").parent(new ModelFile.UncheckedModelFile("item/generated"))
							.texture("layer0", pvd.modLoc("item/" + ctx.getName() + "_activated")));
		}

		public static void register() {
		}
	}

	public static final ItemEntry<Item>
			HEART_OF_ORE,
			THE_SOIL_OF_EVERYTHING;

	public static final ItemEntry<Item>[] STAR_COIN;
	public static final ItemEntry<PolarisArmors>[][] ARMORS;

	static {
		Polaris.REGISTRATE.itemGroup(() -> PolarisItemGroup.TAB_POLARIS_MISCELLANEOUS);
		SimpleItem.register();
		RuneCoreItem.register();
		{
			HEART_OF_ORE = Polaris.REGISTRATE.item("heart_of_ore", p -> new Item(p.durability(300)))
					.defaultModel().defaultLang().register();
			THE_SOIL_OF_EVERYTHING = Polaris.REGISTRATE.item("the_soil_of_everything", p -> new Item(p.durability(500)))
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
		Polaris.REGISTRATE.itemGroup(() -> PolarisItemGroup.TAB_POLARIS_ARMORS);
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
