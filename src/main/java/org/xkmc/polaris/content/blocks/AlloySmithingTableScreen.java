package org.xkmc.polaris.content.blocks;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class AlloySmithingTableScreen extends ContainerScreen<AlloySmithingTableContainer> {
	private static final ResourceLocation CRAFTING_TABLE_LOCATION = new ResourceLocation("textures/gui/container/crafting_table.png");

	public AlloySmithingTableScreen(AlloySmithingTableContainer container, PlayerInventory inventory, ITextComponent title) {
		super(container, inventory, title);
	}

	public void render(MatrixStack stack, int x, int y, float pTick) {
		this.renderBackground(stack);
		super.render(stack, x, y, pTick);
		this.renderTooltip(stack, x, y);
	}

	protected void renderBg(MatrixStack stack, float pTick, int x, int y) {
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bind(CRAFTING_TABLE_LOCATION);
		int i = this.leftPos;
		int j = (this.height - this.imageHeight) / 2;
		this.blit(stack, i, j, 0, 0, this.imageWidth, this.imageHeight);
	}

}
