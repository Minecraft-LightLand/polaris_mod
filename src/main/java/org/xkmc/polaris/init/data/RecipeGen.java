package org.xkmc.polaris.init.data;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import net.minecraft.block.Blocks;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
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
		}
		{
			netherFurnace(pvd, Items.NETHERITE_INGOT, PolarisItems.SimpleItem.NETHER_ALLOY_ESSENCE.entry.get(), 1);
			netherFurnace(pvd, PolarisItems.SimpleItem.END_ALLOY_INGOT.entry.get(), PolarisItems.SimpleItem.END_ESSENCE.entry.get(), 2);
		}
	}

	private static void netherFurnace(RegistrateRecipeProvider pvd, Item in, Item out, int mult) {
		CookingRecipeBuilder.cooking(Ingredient.of(in), out,
						0.1f, 1200 * mult, PolarisRecipeTypes.RS_OBSIDIAN_FURNACE.get())
				.unlockedBy("has_" + pvd.safeName(in),
						DataIngredient.items(in).getCritereon(pvd))
				.save(pvd);
	}

}
