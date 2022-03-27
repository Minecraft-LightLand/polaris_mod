package org.xkmc.polaris.init;

import net.minecraft.item.ItemModelsProperties;
import org.xkmc.polaris.init.registry.PolarisItems;

public class PolarisClient {

	public static void registerItemProperties() {
		for (PolarisItems.RuneCoreItem item : PolarisItems.RuneCoreItem.values()) {
			ItemModelsProperties.register(item.entry.get(), PolarisItems.RuneCoreItem.ID, (stack, world, entity) ->
					item.entry.get().isActivated(stack) ? 1 : 0);
		}
	}

}
