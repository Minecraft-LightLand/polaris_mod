package org.xkmc.polaris.init;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import org.xkmc.polaris.init.Polaris;

public class PolarisBlocks {

	public static final BlockEntry<Block> ALLOY_SMITHING_TABLE = Polaris.REGISTRATE.block("alloy_smithing_table",
					p -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)))
			.defaultBlockstate().defaultLang().defaultLoot().simpleItem().register();

	public static final BlockEntry<Block> OBSIDIAN_NETHER_FURNACE = Polaris.REGISTRATE.block("obsidian_nether_furnace",
					p -> new Block(AbstractBlock.Properties.of(Material.STONE).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)))
			.defaultBlockstate().defaultLang().defaultLoot().simpleItem().register();


	public static void register() {
	}

}
