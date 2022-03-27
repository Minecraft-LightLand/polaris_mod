package org.xkmc.polaris.init.registry;

import com.tterrag.registrate.util.entry.ContainerEntry;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.ResourceLocation;
import org.xkmc.polaris.content.blocks.AlloySmithingTableContainer;
import org.xkmc.polaris.content.blocks.AlloySmithingTableScreen;
import org.xkmc.polaris.content.blocks.ObsidianNetherFurnaceContainer;
import org.xkmc.polaris.content.blocks.ObsidianNetherFurnaceScreen;
import org.xkmc.polaris.init.Polaris;

public class PolarisContainers {

	public static final ContainerEntry<ObsidianNetherFurnaceContainer> OBSIDIAN_NETHER_FURNACE_CONTAINER =
			Polaris.REGISTRATE.container("obsidian_nether_furnace_container",
							ObsidianNetherFurnaceContainer::new, () -> ObsidianNetherFurnaceScreen::new)
					.lang(PolarisContainers::contLang).register();

	public static final ContainerEntry<AlloySmithingTableContainer> CT_ALLOY_SMITHING_TABLE =
			Polaris.REGISTRATE.container("alloy_smithing_table_container",
							AlloySmithingTableContainer::new, () -> AlloySmithingTableScreen::new)
					.lang(PolarisContainers::contLang).register();

	public static void register() {
	}

	private static String contLang(ContainerType<?> type) {
		ResourceLocation id = type.getRegistryName();
		return "container." + id.getNamespace() + "." + id.getPath();
	}

}
