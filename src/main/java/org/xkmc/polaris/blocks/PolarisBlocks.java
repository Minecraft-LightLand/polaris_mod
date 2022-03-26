package org.xkmc.polaris.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import org.xkmc.polaris.util.PolarisDefaultBlock;
import org.xkmc.polaris.util.PolarisItemGroup;
import org.xkmc.polaris.util.Registration;

import java.util.function.Supplier;

public class PolarisBlocks {

    public static final RegistryObject<Block> AlloySmithingTable = register("alloy_smithing_table", () ->
            new PolarisDefaultBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<Block> ObsidianNetherFurnace = register("obsidian_nether_furnace", () ->
            new PolarisDefaultBlock(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));

    public static void register() {
    }

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    protected static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> registryObject = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().tab(PolarisItemGroup.TAB_POLARIS_BLOCKS)));
        return registryObject;
    }

}
