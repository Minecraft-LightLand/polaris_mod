package org.xkmc.polaris.content.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.xkmc.polaris.init.registry.PolarisBlocks;
import org.xkmc.polaris.init.registry.PolarisItems;

public class PolarisItemGroup {
	public static final ItemGroup TAB_POLARIS_MISCELLANEOUS;

	static {
		TAB_POLARIS_MISCELLANEOUS = new ItemGroup("tab_polaris_miscellaneous") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PolarisItems.SimpleItem.LIFE_OF_SEEDS.entry.get());
			}
		};
	}

	public static final ItemGroup TAB_POLARIS_BLOCKS;

	static {
		TAB_POLARIS_BLOCKS = new ItemGroup("tab_polaris_blocks") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PolarisBlocks.OBSIDIAN_NETHER_FURNACE.get());
			}
		};
	}

	public static final ItemGroup TAB_POLARIS_ARMORS;

	static {
		TAB_POLARIS_ARMORS = new ItemGroup("tab_polaris_armors") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PolarisItems.ARMORS[PolarisArmorMaterial.SUPREME_GENESIS.ordinal()][0].get());
			}
		};
	}
}
