package org.xkmc.polaris.init.data;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import net.minecraft.block.Blocks;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import org.xkmc.polaris.init.registry.PolarisBlocks;
import org.xkmc.polaris.init.registry.PolarisItems;

public class RecipeGen {

	public static void genRecipe(RegistrateRecipeProvider pvd) {
		{
			int n = PolarisItems.STAR_COIN.length;
			for (int i = 0; i < n - 1; i++) {
				pvd.storage(PolarisItems.STAR_COIN[i], PolarisItems.STAR_COIN[i + 1]);
			}
		}
		{
			ShapedRecipeBuilder.shaped(PolarisBlocks.OBSIDIAN_NETHER_FURNACE.get())
					.pattern("AAA").pattern("ABA").pattern("CCC")
					.define('A', Items.NETHERITE_INGOT)
					.define('B', Blocks.FURNACE)
					.define('C', Items.GOLD_INGOT)
					.unlockedBy("has_" + pvd.safeName(Items.NETHERITE_INGOT),
							DataIngredient.items(Items.NETHERITE_INGOT).getCritereon(pvd))
					.save(pvd);
		}
	}
}
