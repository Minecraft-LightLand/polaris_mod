package org.xkmc.polaris.init.registry;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import org.xkmc.polaris.content.recipes.AlloySmithingRecipe;
import org.xkmc.polaris.content.recipes.ObsidianFurnaceRecipe;
import org.xkmc.polaris.init.Polaris;

public class PolarisRecipeTypes {

	public static final IRecipeType<ObsidianFurnaceRecipe> RT_OBSIDIAN_FURNACE = IRecipeType.register(Polaris.MODID + ":obsidian_furnace");
	public static final IRecipeType<AlloySmithingRecipe> RT_ALLOY_SMITHING = IRecipeType.register(Polaris.MODID + ":alloy_smithing");

	public static final RegistryEntry<CookingRecipeSerializer<ObsidianFurnaceRecipe>> RS_OBSIDIAN_FURNACE =
			Polaris.REGISTRATE.simple("obsidian_furnace", IRecipeSerializer.class,
					() -> new CookingRecipeSerializer<>(ObsidianFurnaceRecipe::new, 100));

	public static final RegistryEntry<AlloySmithingRecipe.Serializer> RS_ALLOY_SMITHING =
			Polaris.REGISTRATE.simple("alloy_smithing", IRecipeSerializer.class,
					AlloySmithingRecipe.Serializer::new);

	public static void register() {
	}
}
