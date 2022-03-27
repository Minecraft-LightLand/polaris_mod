package org.xkmc.polaris.compat.jei;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.plugins.vanilla.cooking.AbstractCookingCategory;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import org.xkmc.polaris.content.recipes.ObsidianFurnaceRecipe;
import org.xkmc.polaris.init.Polaris;

public class ObsidianNetherFurnaceCategory extends AbstractCookingCategory<ObsidianFurnaceRecipe> {

	public static final ResourceLocation UID = new ResourceLocation(Polaris.MODID, "obsidian_nether_furnace");

	public ObsidianNetherFurnaceCategory(IGuiHelper guiHelper, Block icon, String translationKey, int regularCookTime) {
		super(guiHelper, icon, translationKey, regularCookTime);
	}

	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Override
	public Class<ObsidianFurnaceRecipe> getRecipeClass() {
		return ObsidianFurnaceRecipe.class;
	}

}
