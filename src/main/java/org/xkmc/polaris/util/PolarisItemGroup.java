package org.xkmc.polaris.util;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.xkmc.polaris.item.PolarisItems;

public class PolarisItemGroup {
    public static final ItemGroup TAB_POLARIS_MISCELLANEOUS;

    static {
        TAB_POLARIS_MISCELLANEOUS = new ItemGroup("tab_polaris_miscellaneous") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(PolarisItems.HeartOfOre.get());
            }
        };
    }

    public static final ItemGroup TAB_POLARIS_BLOCKS;

    static {
        TAB_POLARIS_BLOCKS = new ItemGroup("tab_polaris_blocks") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(PolarisItems.LifeOfSeeds.get());
            }
        };
    }

    public static final ItemGroup TAB_POLARIS_ARMORS;

    static {
        TAB_POLARIS_ARMORS = new ItemGroup("tab_polaris_armors") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(Items.DIAMOND_HELMET.getItem());
            }
        };
    }
}
