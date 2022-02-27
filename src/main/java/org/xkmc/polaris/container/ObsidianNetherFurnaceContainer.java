package org.xkmc.polaris.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.xkmc.polaris.data.recipes.PolarisRecipeTypes;


public class ObsidianNetherFurnaceContainer extends AbstractFurnaceContainer {

    private final TileEntity tileEntity;
    private final PlayerEntity playerEntity;
    private final IItemHandler playerInventory;


    public ObsidianNetherFurnaceContainer(int windowId, World world, BlockPos blockPos, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        super(PolarisContainers.OBSIDIAN_NETHER_FURNACE_CONTAINER.get(), PolarisRecipeTypes.OBSIDIAN_NETHER_FURNACE_RECIPE, RecipeBookCategory.FURNACE, windowId, playerInventory);
        this.tileEntity = world.getBlockEntity(blockPos);
        this.playerEntity = playerEntity;
        this.playerInventory = new InvWrapper(playerInventory);
    }


    @Override
    public boolean recipeMatches(IRecipe<? super IInventory> recipe) {
        return super.recipeMatches(recipe);
    }

    @Override
    public int getBurnProgress() {
        return super.getBurnProgress();
    }

    @Override
    public RecipeBookCategory getRecipeBookType() {
        return super.getRecipeBookType();
    }
}
