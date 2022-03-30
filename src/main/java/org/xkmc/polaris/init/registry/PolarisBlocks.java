package org.xkmc.polaris.init.registry;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.TileEntityEntry;
import dev.lcy0x1.base.block.BlockProxy;
import dev.lcy0x1.base.block.LightLandBlock;
import dev.lcy0x1.base.block.LightLandBlockProperties;
import dev.lcy0x1.base.block.impl.ContainerBlockMethodImpl;
import dev.lcy0x1.base.block.impl.LitBlockMethodImpl;
import dev.lcy0x1.base.block.impl.TitleEntityBlockMethodImpl;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import org.xkmc.polaris.content.blocks.AlloySmithingTableContainer;
import org.xkmc.polaris.content.blocks.EternalFurnaceTile;
import org.xkmc.polaris.content.blocks.ObsidianNetherFurnaceTile;
import org.xkmc.polaris.content.item.PolarisItemGroup;
import org.xkmc.polaris.init.Polaris;

public class PolarisBlocks {

	public static final BlockEntry<LightLandBlock> ALLOY_SMITHING_TABLE;
	public static final BlockEntry<LightLandBlock> OBSIDIAN_NETHER_FURNACE;
	public static final BlockEntry<LightLandBlock> ETERNAL_FURNACE;

	public static final TileEntityEntry<ObsidianNetherFurnaceTile> OBSIDIAN_NETHER_FURNACE_TILE;
	public static final TileEntityEntry<EternalFurnaceTile> ETERNAL_FURNACE_TILE;

	static {
		Polaris.REGISTRATE.itemGroup(() -> PolarisItemGroup.TAB_POLARIS_BLOCKS);
		LightLandBlockProperties prop = new LightLandBlockProperties(AbstractBlock.Properties.copy(Blocks.NETHERITE_BLOCK));

		ALLOY_SMITHING_TABLE = Polaris.REGISTRATE.block("alloy_smithing_table",
						p -> LightLandBlock.newBaseBlock(prop, BlockProxy.HORIZONTAL,
								new ContainerBlockMethodImpl<>("container.polaris.alloy_smithing_table_container", AlloySmithingTableContainer::new)))
				.blockstate((ctx, pvd) -> pvd.horizontalBlock(ctx.getEntry(),
						four_side(ctx, pvd, "alloy_smithing_table", "_front", "")))
				.defaultLang().defaultLoot().simpleItem().register();

		OBSIDIAN_NETHER_FURNACE = Polaris.REGISTRATE.block("obsidian_nether_furnace",
						p -> LightLandBlock.newBaseBlock(prop, BlockProxy.HORIZONTAL, new LitBlockMethodImpl(13),
								new TitleEntityBlockMethodImpl(() -> PolarisBlocks.OBSIDIAN_NETHER_FURNACE_TILE)))
				.blockstate((ctx, pvd) -> {
							ModelFile off = four_side(ctx, pvd, "obsidian_nether_furnace", "_front", "");
							ModelFile on = four_side(ctx, pvd, "obsidian_nether_furnace", "_on", "_on");
							pvd.horizontalBlock(ctx.getEntry(), state -> state.getValue(BlockStateProperties.LIT) ? on : off);
						}
				).defaultLang().defaultLoot().simpleItem().register();

		ETERNAL_FURNACE = Polaris.REGISTRATE.block("eternal_furnace",
						p -> LightLandBlock.newBaseBlock(prop, BlockProxy.HORIZONTAL, new LitBlockMethodImpl(13),
								new TitleEntityBlockMethodImpl(() -> PolarisBlocks.ETERNAL_FURNACE_TILE)))
				.blockstate((ctx, pvd) -> {
							ModelFile off = six_side(ctx, pvd, "eternal_furnace", "", "_front", "_back", "_side", "_side");
							ModelFile on = six_side(ctx, pvd, "eternal_furnace", "_on", "_on", "_back", "_side", "_side");
							pvd.horizontalBlock(ctx.getEntry(), state -> state.getValue(BlockStateProperties.LIT) ? on : off);
						}
				).defaultLang().defaultLoot().simpleItem().register();

		OBSIDIAN_NETHER_FURNACE_TILE =
				Polaris.REGISTRATE.tileEntity("obsidian_nether_furnace_tile", ObsidianNetherFurnaceTile::new)
						.validBlock(PolarisBlocks.OBSIDIAN_NETHER_FURNACE).register();
		ETERNAL_FURNACE_TILE =
				Polaris.REGISTRATE.tileEntity("eternal_furnace_tile", EternalFurnaceTile::new)
						.validBlock(PolarisBlocks.ETERNAL_FURNACE).register();
	}

	private static ResourceLocation blockTex(String str) {
		return new ResourceLocation(Polaris.MODID, "block/" + str);
	}

	private static ModelFile four_side(DataGenContext<Block, LightLandBlock> ctx, RegistrateBlockstateProvider pvd, String base, String front, String sufx) {
		return pvd.models().cube(ctx.getName() + sufx,
						blockTex(base + "_bottom"),
						blockTex(base + "_top"),
						blockTex(base + front),
						blockTex(base + "_side"),
						blockTex(base + "_side"),
						blockTex(base + "_side"))
				.texture("particle", blockTex(base + "_top"));
	}

	private static ModelFile six_side(DataGenContext<Block, LightLandBlock> ctx, RegistrateBlockstateProvider pvd, String base, String sufx, String north, String south, String east, String west) {
		return pvd.models().cube(ctx.getName() + sufx,
						blockTex(base + "_bottom"),
						blockTex(base + "_top"),
						blockTex(base + north),
						blockTex(base + south),
						blockTex(base + east),
						blockTex(base + west))
				.texture("particle", blockTex(base + "_top"));
	}

	public static void register() {
	}

}
