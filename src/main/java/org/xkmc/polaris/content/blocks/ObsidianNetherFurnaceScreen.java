package org.xkmc.polaris.content.blocks;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.recipebook.FurnaceRecipeGui;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.ITextProperties;

import java.util.ArrayList;
import java.util.List;

public class ObsidianNetherFurnaceScreen extends AbstractFurnaceScreen<ObsidianNetherFurnaceContainer> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/furnace.png");

	public ObsidianNetherFurnaceScreen(ObsidianNetherFurnaceContainer container, PlayerInventory playerInventory, ITextComponent titleIn) {
		super(container, new FurnaceRecipeGui(), playerInventory, titleIn, TEXTURE);
	}

	@Override
	protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
		List<ITextProperties> list = new ArrayList<>();
		list.add(ITextProperties.of("test"));
		this.renderBackground(matrixStack);
		this.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderWrappedToolTip(matrixStack, list, mouseX, mouseY, font);
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}
}
