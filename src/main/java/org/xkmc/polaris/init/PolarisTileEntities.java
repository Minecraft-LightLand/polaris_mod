package org.xkmc.polaris.init;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import org.xkmc.polaris.content.blocks.ObsidianNetherFurnaceTile;

public class PolarisTileEntities {
	public static final RegistryObject<TileEntityType<ObsidianNetherFurnaceTile>> OBSIDIAN_NETHER_FURNACE_TILE =
			Registration.TILE_ENTITIES.register("obsidian_nether_furnace_tile", () -> TileEntityType.Builder.of(
					ObsidianNetherFurnaceTile::new, PolarisBlocks.OBSIDIAN_NETHER_FURNACE.get()).build(null));

	public static void register() {
	}
}
