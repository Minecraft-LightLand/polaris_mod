package org.xkmc.polaris.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import org.xkmc.polaris.tileentity.ObsidianNetherFurnaceTile;

import javax.annotation.Nullable;

public class PolarisDefaultBlock extends HorizontalBlock {
    public PolarisDefaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType use(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult hit) {
        if (world.isClientSide()){
            TileEntity tileEntity = world.getBlockEntity(blockPos);

            if (playerEntity.isCrouching()){
                if (tileEntity instanceof ObsidianNetherFurnaceTile){
                    INamedContainerProvider containerProvider = (INamedContainerProvider) createTileEntity(blockState,world);
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> properties) {
        properties.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getBlock().defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
