package org.xkmc.polaris.content.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.xkmc.polaris.content.blocks.ObsidianNetherFurnaceContainer;
import org.xkmc.polaris.content.blocks.ObsidianNetherFurnaceTile;
import org.xkmc.polaris.init.PolarisTileEntities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class PolarisDefaultBlock extends HorizontalBlock {
    public PolarisDefaultBlock(Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    @ParametersAreNonnullByDefault
    public ActionResultType use(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        TileEntity tileEntity = world.getBlockEntity(blockPos);
        if (!world.isClientSide) {
            if (player.isCrouching()) {
                if (tileEntity instanceof ObsidianNetherFurnaceTile) {
                    INamedContainerProvider containerProvider = createContainerProvider();
                    NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getBlockPos());
                } else {
                    throw new IllegalStateException("Our container provider is missing!");
                }
            }
        }
        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvider() {
        return new INamedContainerProvider() {
            @Nonnull
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.polaris.obsidian_nether_future");
            }

            @Nonnull
            @Override
            @ParametersAreNonnullByDefault
            public Container createMenu(int containerId, PlayerInventory playerInventory, PlayerEntity player) {
                return new ObsidianNetherFurnaceContainer(containerId, player.inventory);
            }
        };
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> properties) {
        properties.add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return PolarisTileEntities.OBSIDIAN_NETHER_FURNACE_TILE.get().create();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getBlock().defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
