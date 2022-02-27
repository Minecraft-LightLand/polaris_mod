package org.xkmc.polaris.tileentity;

import com.mojang.datafixers.types.Type;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.xkmc.polaris.blocks.PolarisBlocks;
import java.util.function.Supplier;

import org.xkmc.polaris.util.Registration;

public class PolarisTileEntities {

    private static Type<?> dataType;
    public static RegistryObject<TileEntityType<ObsidianNetherFurnaceTile>> obsidianNetherFurnaceTile =
            Registration.TILE_ENTITIES.register("obsidian_nether_furnace_tile", () -> TileEntityType.Builder.of(
                    ObsidianNetherFurnaceTile::new, PolarisBlocks.ObsidianNetherFurnace.get()).build(dataType));

    public static void register() {
    }
}
