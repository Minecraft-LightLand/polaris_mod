package org.xkmc.polaris.init;

import com.tterrag.registrate.util.entry.BlockEntry;
import dev.lcy0x1.base.block.BlockProxy;
import dev.lcy0x1.base.block.LightLandBlock;
import dev.lcy0x1.base.block.LightLandBlockProperties;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;

public class PolarisBlocks {

	public static final BlockEntry<LightLandBlock> ALLOY_SMITHING_TABLE;
	public static final BlockEntry<LightLandBlock> OBSIDIAN_NETHER_FURNACE;

	static {
		LightLandBlockProperties prop = new LightLandBlockProperties(AbstractBlock.Properties.of(Material.STONE)
				.sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2));

		ALLOY_SMITHING_TABLE = Polaris.REGISTRATE.block("alloy_smithing_table",
						p -> LightLandBlock.newBaseBlock(prop, BlockProxy.HORIZONTAL))
				.blockstate((ctx, pvd) -> pvd
						.horizontalBlock(ctx.getEntry(), pvd.models().cube(ctx.getName(),
								blockTex("alloy_smithing_table_bottom"),
								blockTex("alloy_smithing_table_top"),
								blockTex("alloy_smithing_table_front"),
								blockTex("alloy_smithing_table_side"),
								blockTex("alloy_smithing_table_side"),
								blockTex("alloy_smithing_table_side")))
				).defaultLang().defaultLoot().simpleItem().register();

		OBSIDIAN_NETHER_FURNACE = Polaris.REGISTRATE.block("obsidian_nether_furnace",
						p -> LightLandBlock.newBaseBlock(prop, BlockProxy.HORIZONTAL))
				.blockstate((ctx, pvd) -> pvd
						.horizontalBlock(ctx.getEntry(), pvd.models().cube(ctx.getName(),
								blockTex("obsidian_nether_furnace_bottom"),
								blockTex("obsidian_nether_furnace_top"),
								blockTex("obsidian_nether_furnace_front"),
								blockTex("obsidian_nether_furnace_side"),
								blockTex("obsidian_nether_furnace_side"),
								blockTex("obsidian_nether_furnace_side")))
				).defaultLang().defaultLoot().simpleItem().register();
	}

	private static ResourceLocation blockTex(String str) {
		return new ResourceLocation(Polaris.MODID, "block/" + str);
	}

	public static void register() {
	}

}
