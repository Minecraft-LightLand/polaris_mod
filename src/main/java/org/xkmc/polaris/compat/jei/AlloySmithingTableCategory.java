package org.xkmc.polaris.compat.jei;

import com.mojang.blaze3d.matrix.MatrixStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.ICraftingGridHelper;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.extensions.IExtendableRecipeCategory;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICraftingCategoryExtension;
import mezz.jei.api.recipe.category.extensions.vanilla.crafting.ICustomCraftingCategoryExtension;
import mezz.jei.config.Constants;
import mezz.jei.recipes.ExtendableRecipeCategoryHelper;
import mezz.jei.util.Translator;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.util.Size2i;
import org.xkmc.polaris.content.recipes.AlloySmithingRecipe;
import org.xkmc.polaris.init.Polaris;
import org.xkmc.polaris.init.registry.PolarisBlocks;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class AlloySmithingTableCategory implements IExtendableRecipeCategory<AlloySmithingRecipe, ICraftingCategoryExtension> {

	public static final ResourceLocation UID = new ResourceLocation(Polaris.MODID, "alloy_smithing");

	private static final int craftOutputSlot = 0;
	private static final int craftInputSlot1 = 1;

	public static final int width = 116;
	public static final int height = 54;

	private final IDrawable background;
	private final IDrawable icon;
	private final String localizedName;
	private final ICraftingGridHelper craftingGridHelper;
	private final ExtendableRecipeCategoryHelper<IRecipe<?>, ICraftingCategoryExtension> extendableHelper = new ExtendableRecipeCategoryHelper<>(AlloySmithingRecipe.class);

	public AlloySmithingTableCategory(IGuiHelper guiHelper) {
		ResourceLocation location = Constants.RECIPE_GUI_VANILLA;
		background = guiHelper.createDrawable(location, 0, 60, width, height);
		icon = guiHelper.createDrawableIngredient(new ItemStack(PolarisBlocks.ALLOY_SMITHING_TABLE.get()));
		localizedName = Translator.translateToLocal("block.polaris.alloy_smithing_table");
		craftingGridHelper = guiHelper.createCraftingGridHelper(craftInputSlot1);
	}

	@Override
	public ResourceLocation getUid() {
		return UID;
	}

	@Override
	public Class<? extends AlloySmithingRecipe> getRecipeClass() {
		return AlloySmithingRecipe.class;
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, AlloySmithingRecipe recipe, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		guiItemStacks.init(craftOutputSlot, false, 94, 18);

		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 3; ++x) {
				int index = craftInputSlot1 + x + (y * 3);
				guiItemStacks.init(index, true, x * 18, y * 18);
			}
		}

		ICraftingCategoryExtension recipeExtension = this.extendableHelper.getRecipeExtension(recipe);

		if (recipeExtension instanceof ICustomCraftingCategoryExtension) {
			ICustomCraftingCategoryExtension customExtension = (ICustomCraftingCategoryExtension) recipeExtension;
			customExtension.setRecipe(recipeLayout, ingredients);
			return;
		}

		List<List<ItemStack>> inputs = ingredients.getInputs(VanillaTypes.ITEM);
		List<List<ItemStack>> outputs = ingredients.getOutputs(VanillaTypes.ITEM);

		Size2i size = recipeExtension.getSize();
		if (size != null && size.width > 0 && size.height > 0) {
			craftingGridHelper.setInputs(guiItemStacks, inputs, size.width, size.height);
		} else {
			craftingGridHelper.setInputs(guiItemStacks, inputs);
			recipeLayout.setShapeless();
		}
		guiItemStacks.set(craftOutputSlot, outputs.get(0));
	}

	@Override
	public void setIngredients(AlloySmithingRecipe recipe, IIngredients ingredients) {
		ICraftingCategoryExtension extension = this.extendableHelper.getRecipeExtension(recipe);
		extension.setIngredients(ingredients);
	}

	@Override
	public void draw(AlloySmithingRecipe recipe, MatrixStack matrixStack, double mouseX, double mouseY) {
		ICraftingCategoryExtension extension = this.extendableHelper.getRecipeExtension(recipe);
		int recipeWidth = this.background.getWidth();
		int recipeHeight = this.background.getHeight();
		extension.drawInfo(recipeWidth, recipeHeight, matrixStack, mouseX, mouseY);
	}

	@Override
	public List<ITextComponent> getTooltipStrings(AlloySmithingRecipe recipe, double mouseX, double mouseY) {
		ICraftingCategoryExtension extension = this.extendableHelper.getRecipeExtension(recipe);
		return extension.getTooltipStrings(mouseX, mouseY);
	}

	@Override
	public boolean handleClick(AlloySmithingRecipe recipe, double mouseX, double mouseY, int mouseButton) {
		ICraftingCategoryExtension extension = this.extendableHelper.getRecipeExtension(recipe);
		return extension.handleClick(mouseX, mouseY, mouseButton);
	}

	@Override
	public boolean isHandled(AlloySmithingRecipe recipe) {
		ICraftingCategoryExtension extension = this.extendableHelper.getRecipeExtensionOrNull(recipe);
		return extension != null;
	}

	@Override
	public <R extends AlloySmithingRecipe> void addCategoryExtension(Class<? extends R> recipeClass, Function<R, ? extends ICraftingCategoryExtension> extensionFactory) {
		extendableHelper.addRecipeExtensionFactory(recipeClass, null, extensionFactory);
	}

	@Override
	public <R extends AlloySmithingRecipe> void addCategoryExtension(Class<? extends R> recipeClass, Predicate<R> extensionFilter, Function<R, ? extends ICraftingCategoryExtension> extensionFactory) {
		extendableHelper.addRecipeExtensionFactory(recipeClass, extensionFilter, extensionFactory);
	}
}
