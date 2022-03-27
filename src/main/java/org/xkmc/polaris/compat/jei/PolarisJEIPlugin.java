package org.xkmc.polaris.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IJeiRuntime;
import mezz.jei.plugins.vanilla.crafting.CraftingCategoryExtension;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.xkmc.polaris.content.recipes.AlloySmithingRecipe;
import org.xkmc.polaris.init.Polaris;
import org.xkmc.polaris.init.registry.PolarisBlocks;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

@JeiPlugin
public class PolarisJEIPlugin implements IModPlugin {

	public static final ResourceLocation UID = new ResourceLocation(Polaris.MODID, "jei_plugin");

	public static PolarisJEIPlugin INSTANCE;

	public PolarisJEIPlugin() {
		INSTANCE = this;
	}


	@Override
	public ResourceLocation getPluginUid() {
		return UID;
	}

	@Override
	public void registerItemSubtypes(ISubtypeRegistration registration) {
	}

	@Override
	public void registerIngredients(IModIngredientRegistration registration) {
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
		registration.addRecipeCategories(new ObsidianNetherFurnaceCategory(helper,
				PolarisBlocks.OBSIDIAN_NETHER_FURNACE.get(),
				"block.polaris.obsidian_nether_furnace", 100));
		AlloySmithingTableCategory alloy = new AlloySmithingTableCategory(helper);
		alloy.addCategoryExtension(AlloySmithingRecipe.class, e -> true, CraftingCategoryExtension::new);
		registration.addRecipeCategories(alloy);
	}

	@Override
	public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addRecipes(Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(PolarisRecipeTypes.RT_OBSIDIAN_FURNACE), ObsidianNetherFurnaceCategory.UID);
		registration.addRecipes(Minecraft.getInstance().level.getRecipeManager()
				.getAllRecipesFor(PolarisRecipeTypes.RT_ALLOY_SMITHING), AlloySmithingTableCategory.UID);
	}

	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(PolarisBlocks.OBSIDIAN_NETHER_FURNACE.get().asItem().getDefaultInstance(), ObsidianNetherFurnaceCategory.UID);
		registration.addRecipeCatalyst(PolarisBlocks.ALLOY_SMITHING_TABLE.get().asItem().getDefaultInstance(), AlloySmithingTableCategory.UID);
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
	}

	@Override
	public void registerAdvanced(IAdvancedRegistration registration) {
	}

	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
	}
}
