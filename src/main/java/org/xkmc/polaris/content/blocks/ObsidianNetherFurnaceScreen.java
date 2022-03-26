package org.xkmc.polaris.content.blocks;

import net.minecraft.client.gui.recipebook.FurnaceRecipeGui;
import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ObsidianNetherFurnaceScreen extends AbstractFurnaceScreen<ObsidianNetherFurnaceContainer> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/furnace.png");

	public ObsidianNetherFurnaceScreen(ObsidianNetherFurnaceContainer container, PlayerInventory playerInventory, ITextComponent titleIn) {
		super(container, new FurnaceRecipeGui(), playerInventory, titleIn, TEXTURE);
	}

	/**
	 * prevent adding button
	 */
	@Override
	protected <T extends Widget> T addButton(T t) {
		return t;
	}
}
