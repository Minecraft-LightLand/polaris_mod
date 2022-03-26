package org.xkmc.polaris.init.registry;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import org.xkmc.polaris.content.recipes.ObsidianFurnaceRecipe;
import org.xkmc.polaris.content.recipes.Serializer;
import org.xkmc.polaris.init.Polaris;

public class PolarisRecipeTypes {

	public static final IRecipeType<ObsidianFurnaceRecipe> RT_OBSIDIAN_FURNACE = IRecipeType.register(Polaris.MODID + ":obsidian_furnace");

	public static final RegistryEntry<Serializer<ObsidianFurnaceRecipe>> RS_OBSIDIAN_FURNACE =
			Polaris.REGISTRATE.simple("obsidian_furnace", IRecipeSerializer.class, Serializer::new);

	public static void register() {
	}
}
