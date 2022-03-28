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
			ShapedRecipeBuilder.shaped(PolarisBlocks.ALLOY_SMITHING_TABLE.get())
					.pattern(" A ").pattern("ABA").pattern(" A ")
					.define('A', Blocks.NETHERITE_BLOCK)
					.define('B', Blocks.CRAFTING_TABLE)
					.unlockedBy("has_" + pvd.safeName(Items.NETHERITE_BLOCK),
							DataIngredient.items(Items.NETHERITE_BLOCK).getCritereon(pvd))
					.save(pvd);
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
	}

	private static void netherFurnace(RegistrateRecipeProvider pvd, Item in, Item out, int mult) {
		CookingRecipeBuilder.cooking(Ingredient.of(in), out,
						0.1f, 1200 * mult, PolarisRecipeTypes.RS_OBSIDIAN_FURNACE.get())
				.unlockedBy("has_" + pvd.safeName(in),
						DataIngredient.items(in).getCritereon(pvd))
				.save(pvd);
	}

	private static void cross(RegistrateRecipeProvider pvd, IItemProvider out, IItemProvider in, IItemProvider side) {
		new AlloySmithingRecipeBuilder(out, 1).pattern(" B ").pattern("BAB").pattern(" B ")
				.define('A', in).define('B', side)
				.unlockedBy("has_" + pvd.safeName(in.asItem()), DataIngredient.items(in.asItem()).getCritereon(pvd))
				.save(pvd);
	}

	private static void symmetric(RegistrateRecipeProvider pvd, Item out, Item in, Item side, Item corner) {
		new AlloySmithingRecipeBuilder(out, 1).pattern("CBC").pattern("BAB").pattern("CBC")
				.define('A', in).define('B', side).define('C', corner)
				.unlockedBy("has_" + pvd.safeName(in), DataIngredient.items(in).getCritereon(pvd))
				.save(pvd);
	}

}
