package org.xkmc.polaris.container;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import org.xkmc.polaris.util.Registration;

public class PolarisContainers {
    public static final RegistryObject<ContainerType<ObsidianNetherFurnaceContainer>> OBSIDIAN_NETHER_FURNACE_CONTAINER =
            Registration.CONTAINERS.register("obsidian_nether_furnace_container", () ->
                    IForgeContainerType.create((containerID, inventory, data) ->
                            new ObsidianNetherFurnaceContainer(containerID, inventory)));

    public static void register() {
    }
}
