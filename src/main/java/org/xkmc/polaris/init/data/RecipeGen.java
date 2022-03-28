package org.xkmc.polaris.init.data;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import net.minecraft.block.Blocks;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import org.xkmc.polaris.content.item.PolarisArmorMaterial;
import org.xkmc.polaris.init.registry.PolarisBlocks;
import org.xkmc.polaris.init.registry.PolarisItems;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

public class RecipeGen {

	public static void genRecipe(RegistrateRecipeProvider pvd) {
		{
			int n = PolarisItems.STAR_COIN.length;
			for (int i = 0; i < n - 1; i++) {
				pvd.storage(PolarisItems.STAR_COIN[i], PolarisItems.STAR_COIN[i + 1]);
			}
		}
		{
			cross(pvd, PolarisBlocks.OBSIDIAN_NETHER_FURNACE.get(), Blocks.FURNACE, Blocks.NETHERITE_BLOCK);
			cross(pvd, PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get(), Items.IRON_INGOT,
					PolarisItems.SimpleItem.NETHERITE_ESSENCE.entry.get());
			cross(pvd, PolarisItems.SimpleItem.END_ALLOY_INGOT.entry.get(),
					PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get(),
					PolarisItems.SimpleItem.REFINED_NETHERITE_ESSENCE.entry.get());
			symmetric(pvd, PolarisItems.SimpleItem.CRYING_GHOST.entry.get(),
					Items.GHAST_TEAR, Items.BLAZE_POWDER, Items.GHAST_TEAR);
			symmetric(pvd, PolarisItems.SimpleItem.NETHER_STAR.entry.get(),
					PolarisItems.SimpleItem.CRYING_GHOST.entry.get(), Items.NETHER_STAR,
					PolarisItems.SimpleItem.FLAME_OF_THE_SOUL.entry.get());
			symmetric(pvd, PolarisItems.SimpleItem.THE_VOID_OF_SOURCE.entry.get(),
					PolarisItems.SimpleItem.REFINED_NETHERITE_ESSENCE.entry.get(),
					PolarisItems.SimpleItem.CRYING_GHOST.entry.get(),
					PolarisItems.SimpleItem.FLAME_OF_THE_SOUL.entry.get());

			cross(pvd, PolarisItems.SimpleItem.RUNE_CORE_1.entry.get(),
					PolarisItems.SimpleItem.NETHERITE_ESSENCE.entry.get(), Items.NETHERITE_SCRAP);
			symmetric(pvd, PolarisItems.SimpleItem.RUNE_CORE_2.entry.get(),
					PolarisItems.SimpleItem.RUNE_CORE_1_ACTIVATED.entry.get(), Items.NETHERITE_SCRAP,
					PolarisItems.SimpleItem.FLAME_OF_THE_SOUL.entry.get());
			symmetric(pvd, PolarisItems.SimpleItem.RUNE_CORE_3.entry.get(),
					PolarisItems.SimpleItem.RUNE_CORE_2_ACTIVATED.entry.get(), Items.NETHERITE_INGOT,
					PolarisItems.SimpleItem.HEART_OF_ORE.entry.get());
			symmetric(pvd, PolarisItems.SimpleItem.RUNE_CORE_4.entry.get(),
					PolarisItems.SimpleItem.RUNE_CORE_3_ACTIVATED.entry.get(),
					PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get(),
					PolarisItems.SimpleItem.DEMON_SOUL.entry.get());
		}
		{
			ShapedRecipeBuilder.shaped(PolarisBlocks.ALLOY_SMITHING_TABLE.get())
					.pattern(" A ").pattern("ABA").pattern(" A ")
					.define('A', Blocks.NETHERITE_BLOCK)
					.define('B', Blocks.CRAFTING_TABLE)
					.unlockedBy("has_" + pvd.safeName(Items.NETHERITE_BLOCK),
							DataIngredient.items(Items.NETHERITE_BLOCK).getCritereon(pvd))
					.save(pvd);
			new AlloySmithingRecipeBuilder(PolarisItems.SimpleItem.POWER_RUNE_CORE.entry.get(), 1)
					.unlockedBy(pvd, PolarisItems.SimpleItem.RUNE_CORE_4_ACTIVATED.entry.get())
					.pattern("1B2").pattern("BAB").pattern("3B4")
					.define('A', PolarisItems.SimpleItem.SPIRIT_OF_DIVINITY.entry.get())
					.define('B', PolarisItems.SimpleItem.END_ALLOY_INGOT.entry.get())
					.define('1', PolarisItems.SimpleItem.RUNE_CORE_1_ACTIVATED.entry.get())
					.define('2', PolarisItems.SimpleItem.RUNE_CORE_2_ACTIVATED.entry.get())
					.define('3', PolarisItems.SimpleItem.RUNE_CORE_3_ACTIVATED.entry.get())
					.define('4', PolarisItems.SimpleItem.RUNE_CORE_4_ACTIVATED.entry.get())
					.save(pvd);
			new AlloySmithingRecipeBuilder(PolarisItems.SimpleItem.THE_SOIL_OF_EVERYTHING.entry.get(), 1)
					.unlockedBy(pvd, Blocks.GRASS_BLOCK).pattern(" A ").pattern("ABA").pattern("CDE")
					.define('A', Items.BONE_MEAL).define('B', Blocks.GRASS_BLOCK)
					.define('C', Blocks.MYCELIUM).define('D', Blocks.SAND)
					.define('E', Blocks.PODZOL).save(pvd);
			new AlloySmithingRecipeBuilder(PolarisItems.SimpleItem.FLAME_OF_THE_SOUL.entry.get(), 1)
					.unlockedBy(pvd, Items.BLAZE_POWDER).pattern(" A ").pattern("BCD").pattern("EFE")
					.define('A', Items.GHAST_TEAR).define('B', Items.ENDER_EYE)
					.define('C', Blocks.SOUL_SAND).define('D', Items.NETHER_WART)
					.define('E', Items.LAVA_BUCKET).define('F', Items.BLAZE_POWDER).save(pvd);
			new AlloySmithingRecipeBuilder(PolarisItems.SimpleItem.PURGATORY_SOIL.entry.get(), 1)
					.unlockedBy(pvd, Items.BLAZE_POWDER).pattern(" A ").pattern(" B ").pattern("CDE")
					.define('A', Items.GHAST_TEAR).define('B', Items.BLAZE_POWDER)
					.define('C', Blocks.SOUL_SAND).define('D', Blocks.MAGMA_BLOCK)
					.define('E', Blocks.SOUL_SOIL).save(pvd);
			new AlloySmithingRecipeBuilder(PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get(), 1)
					.unlockedBy(pvd, Items.WHEAT_SEEDS).pattern("A B").pattern(" C ").pattern("D E")
					.define('A', Items.COCOA_BEANS).define('B', Items.BEETROOT_SEEDS)
					.define('C', Items.WHEAT_SEEDS).define('D', Items.PUMPKIN_SEEDS)
					.define('E', Items.MELON_SEEDS).save(pvd);
			new AlloySmithingRecipeBuilder(PolarisItems.SimpleItem.HEART_OF_ORE.entry.get(), 1)
					.unlockedBy(pvd, Items.DIAMOND).pattern(" A ").pattern("BCD").pattern("EFG")
					.define('A', Items.IRON_INGOT).define('B', Items.GOLD_INGOT)
					.define('C', Items.DIAMOND).define('D', Items.LAPIS_LAZULI)
					.define('E', Items.EMERALD).define('F', Items.COAL)
					.define('G', Items.REDSTONE).save(pvd);
			new AlloySmithingRecipeBuilder(PolarisItems.SimpleItem.SPIRIT_OF_DIVINITY.entry.get(), 1)
					.unlockedBy(pvd, PolarisItems.SimpleItem.NETHER_STAR_ESSENCE.entry.get())
					.pattern("CBC").pattern("BAB").pattern("DBD")
					.define('A', PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get())
					.define('B', PolarisItems.SimpleItem.NETHER_STAR_ESSENCE.entry.get())
					.define('C', PolarisItems.SimpleItem.FLAME_OF_THE_SOUL.entry.get())
					.define('D', PolarisItems.SimpleItem.CRYING_GHOST.entry.get())
					.save(pvd);
			new AlloySmithingRecipeBuilder(PolarisItems.SimpleItem.DEMON_SOUL.entry.get(), 1)
					.unlockedBy(pvd, Items.ROTTEN_FLESH).pattern("ABC").pattern("DEF").pattern("GHI")
					.define('A', Items.GUNPOWDER).define('B', Items.GHAST_TEAR)
					.define('C', Items.PHANTOM_MEMBRANE).define('D', Items.BONE)
					.define('E', Items.ENDER_PEARL).define('F', Items.BLAZE_ROD)
					.define('G', Items.ROTTEN_FLESH).define('H', Items.SLIME_BALL)
					.define('I', Items.SPIDER_EYE).save(pvd);

		}
		{
			netherFurnace(pvd, Items.NETHERITE_INGOT, PolarisItems.SimpleItem.NETHERITE_ESSENCE.entry.get(), 1);
			netherFurnace(pvd, PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get(),
					PolarisItems.SimpleItem.REFINED_NETHERITE_ESSENCE.entry.get(), 4);
			netherFurnace(pvd, PolarisItems.SimpleItem.NETHER_STAR.entry.get(),
					PolarisItems.SimpleItem.NETHER_STAR_ESSENCE.entry.get(), 8);
			netherFurnace(pvd, PolarisItems.SimpleItem.RUNE_CORE_1.entry.get(),
					PolarisItems.SimpleItem.RUNE_CORE_1_ACTIVATED.entry.get(), 12);
			netherFurnace(pvd, PolarisItems.SimpleItem.RUNE_CORE_2.entry.get(),
					PolarisItems.SimpleItem.RUNE_CORE_2_ACTIVATED.entry.get(), 16);
			netherFurnace(pvd, PolarisItems.SimpleItem.RUNE_CORE_3.entry.get(),
					PolarisItems.SimpleItem.RUNE_CORE_3_ACTIVATED.entry.get(), 32);
			netherFurnace(pvd, PolarisItems.SimpleItem.RUNE_CORE_4.entry.get(),
					PolarisItems.SimpleItem.RUNE_CORE_4_ACTIVATED.entry.get(), 48);
			netherFurnace(pvd, PolarisItems.SimpleItem.POWER_RUNE_CORE.entry.get(),
					PolarisItems.SimpleItem.POWER_RUNE_CORE_ACTIVATED.entry.get(), 64);
		}
		{
			Item[] netherite = new Item[]{Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS};
			for (int i = 0; i < 4; i++) {

				new AlloySmithingRecipeBuilder(PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get(), 1)
						.unlockedBy(pvd, netherite[i])
						.pattern("ABA").pattern("CDC").pattern("AEA").define('A', Items.NETHERITE_INGOT)
						.define('B', PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get())
						.define('C', PolarisItems.SimpleItem.DEMON_SOUL.entry.get())
						.define('E', PolarisItems.SimpleItem.FLAME_OF_THE_SOUL.entry.get())
						.define('D', netherite[i]).save(pvd);

				new AlloySmithingRecipeBuilder(PolarisItems.ARMORS[PolarisArmorMaterial.MS_BLUE_DRAGON.ordinal()][i].get(), 1)
						.unlockedBy(pvd, PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get())
						.pattern("ABA").pattern("ACA").pattern("EDE").define('B', Items.EMERALD)
						.define('A', PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get())
						.define('C', PolarisItems.SimpleItem.RUNE_CORE_1_ACTIVATED.entry.get())
						.define('E', PolarisItems.SimpleItem.CRYING_GHOST.entry.get())
						.define('D', PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get()).save(pvd);
				new AlloySmithingRecipeBuilder(PolarisItems.ARMORS[PolarisArmorMaterial.MS_WHITE_TIGER.ordinal()][i].get(), 1)
						.unlockedBy(pvd, PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get())
						.pattern("ABA").pattern("ACA").pattern("EDE").define('B', Items.QUARTZ)
						.define('A', PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get())
						.define('C', PolarisItems.SimpleItem.RUNE_CORE_1_ACTIVATED.entry.get())
						.define('E', PolarisItems.SimpleItem.DEMON_SOUL.entry.get())
						.define('D', PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get()).save(pvd);
				new AlloySmithingRecipeBuilder(PolarisItems.ARMORS[PolarisArmorMaterial.MS_VERMILION_BIRD.ordinal()][i].get(), 1)
						.unlockedBy(pvd, PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get())
						.pattern("EBE").pattern("FCF").pattern("ADA")
						.define('B', Items.BLAZE_POWDER).define('F', Items.FEATHER)
						.define('A', PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get())
						.define('C', PolarisItems.SimpleItem.RUNE_CORE_1_ACTIVATED.entry.get())
						.define('E', PolarisItems.SimpleItem.PURGATORY_SOIL.entry.get())
						.define('D', PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get()).save(pvd);
				new AlloySmithingRecipeBuilder(PolarisItems.ARMORS[PolarisArmorMaterial.MS_BLACK_TORTOISE.ordinal()][i].get(), 1)
						.unlockedBy(pvd, PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get())
						.pattern("AAA").pattern("ACA").pattern("EDE")
						.define('A', PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get())
						.define('C', PolarisItems.SimpleItem.RUNE_CORE_1_ACTIVATED.entry.get())
						.define('E', PolarisItems.SimpleItem.PURGATORY_SOIL.entry.get())
						.define('D', PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get()).save(pvd);
				new AlloySmithingRecipeBuilder(PolarisItems.ARMORS[PolarisArmorMaterial.STARDUST.ordinal()][i].get(), 1)
						.unlockedBy(pvd, PolarisItems.SimpleItem.RUNE_CORE_2_ACTIVATED.entry.get())
						.pattern("ABA").pattern("ACA").pattern("ADA")
						.define('A', PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get())
						.define('B', PolarisItems.SimpleItem.THE_VOID_OF_SOURCE.entry.get())
						.define('C', PolarisItems.SimpleItem.RUNE_CORE_2_ACTIVATED.entry.get())
						.define('D', PolarisItems.ARMORS[PolarisArmorMaterial.MS_BASE.ordinal()][i].get()).save(pvd);
				new AlloySmithingRecipeBuilder(PolarisItems.ARMORS[PolarisArmorMaterial.STARBURST.ordinal()][i].get(), 1)
						.unlockedBy(pvd, PolarisItems.SimpleItem.RUNE_CORE_3_ACTIVATED.entry.get())
						.pattern("BAA").pattern("ACA").pattern("ADB")
						.define('A', PolarisItems.SimpleItem.REFINED_NETHERITE_INGOT.entry.get())
						.define('B', PolarisItems.SimpleItem.NETHER_STAR.entry.get())
						.define('C', PolarisItems.SimpleItem.RUNE_CORE_3_ACTIVATED.entry.get())
						.define('D', PolarisItems.ARMORS[PolarisArmorMaterial.STARDUST.ordinal()][i].get()).save(pvd);
				new AlloySmithingRecipeBuilder(PolarisItems.ARMORS[PolarisArmorMaterial.STAR_LORD.ordinal()][i].get(), 1)
						.unlockedBy(pvd, PolarisItems.SimpleItem.RUNE_CORE_4_ACTIVATED.entry.get())
						.pattern("BAE").pattern("ACA").pattern("FDB")
						.define('A', PolarisItems.SimpleItem.END_ALLOY_INGOT.entry.get())
						.define('B', PolarisItems.SimpleItem.NETHER_STAR_ESSENCE.entry.get())
						.define('C', PolarisItems.SimpleItem.RUNE_CORE_4_ACTIVATED.entry.get())
						.define('D', PolarisItems.ARMORS[PolarisArmorMaterial.STARBURST.ordinal()][i].get())
						.define('E', PolarisItems.SimpleItem.SPIRIT_OF_DIVINITY.entry.get())
						.define('F', PolarisItems.SimpleItem.THE_VOID_OF_SOURCE.entry.get()).save(pvd);
				new AlloySmithingRecipeBuilder(PolarisItems.ARMORS[PolarisArmorMaterial.SUPREME_GENESIS.ordinal()][i].get(), 1)
						.unlockedBy(pvd, PolarisItems.SimpleItem.POWER_RUNE_CORE_ACTIVATED.entry.get())
						.pattern("152").pattern("ACA").pattern("3B4")
						.define('A', PolarisItems.SimpleItem.SPIRIT_OF_DIVINITY.entry.get())
						.define('B', PolarisItems.SimpleItem.THE_VOID_OF_SOURCE.entry.get())
						.define('C', PolarisItems.SimpleItem.POWER_RUNE_CORE_ACTIVATED.entry.get())
						.define('1', PolarisItems.ARMORS[PolarisArmorMaterial.MS_BLUE_DRAGON.ordinal()][i].get())
						.define('2', PolarisItems.ARMORS[PolarisArmorMaterial.MS_WHITE_TIGER.ordinal()][i].get())
						.define('3', PolarisItems.ARMORS[PolarisArmorMaterial.MS_VERMILION_BIRD.ordinal()][i].get())
						.define('4', PolarisItems.ARMORS[PolarisArmorMaterial.MS_BLACK_TORTOISE.ordinal()][i].get())
						.define('5', PolarisItems.ARMORS[PolarisArmorMaterial.STAR_LORD.ordinal()][i].get())
						.save(pvd);
			}
		}
	}

	private static void netherFurnace(RegistrateRecipeProvider pvd, Item in, Item out, int mult) {
		CookingRecipeBuilder.cooking(Ingredient.of(in), out,
						0.1f, 1200 * mult, PolarisRecipeTypes.RS_OBSIDIAN_FURNACE.get())
				.unlockedBy("has_" + pvd.safeName(in),
						DataIngredient.items(in).getCritereon(pvd))
				.save(pvd);
	}

	private static void cross(RegistrateRecipeProvider pvd, IItemProvider out, IItemProvider in, IItemProvider side) {
		new AlloySmithingRecipeBuilder(out, 1).unlockedBy(pvd, in).pattern(" B ").pattern("BAB").pattern(" B ")
				.define('A', in).define('B', side).save(pvd);
	}

	private static void symmetric(RegistrateRecipeProvider pvd, Item out, Item in, Item side, Item corner) {
		new AlloySmithingRecipeBuilder(out, 1).unlockedBy(pvd, in).pattern("CBC").pattern("BAB").pattern("CBC")
				.define('A', in).define('B', side).define('C', corner)
				.save(pvd);
	}

}
