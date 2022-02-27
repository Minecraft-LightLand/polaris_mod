package org.xkmc.polaris.container;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import org.xkmc.polaris.util.Registration;

public class PolarisContainers {
    public static final RegistryObject<ContainerType<?>> OBSIDIAN_NETHER_FURNACE_CONTAINER =
            Registration.CONTAINERS.register("obsidian_nether_furnace_container", () -> IForgeContainerType.create((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.level;
                return new ObsidianNetherFurnaceContainer(windowId, world, pos, inv, inv.player);
            }));
}
