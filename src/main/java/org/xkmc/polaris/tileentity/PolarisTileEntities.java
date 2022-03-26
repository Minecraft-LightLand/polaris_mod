package org.xkmc.polaris.tileentity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import org.xkmc.polaris.blocks.PolarisBlocks;
import org.xkmc.polaris.util.Registration;

public class PolarisTileEntities {
    public static final RegistryObject<TileEntityType<ObsidianNetherFurnaceTile>> obsidianNetherFurnaceTile =
            Registration.TILE_ENTITIES.register("obsidian_nether_furnace_tile", () -> TileEntityType.Builder.of(
                    ObsidianNetherFurnaceTile::new, PolarisBlocks.ObsidianNetherFurnace.get()).build(null));

    public static void register() {
    }
}
