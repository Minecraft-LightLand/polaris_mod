package org.xkmc.polaris.init.data;

import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import org.xkmc.polaris.init.registry.PolarisItems;

public class RecipeGen {

	public static void genRecipe(RegistrateRecipeProvider pvd) {
		int n = PolarisItems.STAR_COIN.length;
		for (int i = 0; i < n - 1; i++) {
			pvd.storage(PolarisItems.STAR_COIN[i], PolarisItems.STAR_COIN[i + 1]);
		}
	}
}
