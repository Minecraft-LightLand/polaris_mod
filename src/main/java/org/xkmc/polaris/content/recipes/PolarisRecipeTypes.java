package org.xkmc.polaris.content.recipes;

import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import org.xkmc.polaris.init.Registration;

public class PolarisRecipeTypes {

    public static final RegistryObject<Serializer<ObsidianFurnaceRecipe>> OBSIDIAN_FURNACE_SERIALIZER =
            Registration.RECIPE_SERIALIZER.register("obsidian_furnace", Serializer::new);
    public static final IRecipeType<ObsidianFurnaceRecipe> OBSIDIAN_FURNACE_RECIPE_TYPE = new ObsidianFurnaceRecipe.ObsidianFurnaceRecipeType();

    public static void register() {
        Registry.register(Registry.RECIPE_TYPE, OBSIDIAN_FURNACE_RECIPE_TYPE.toString(), OBSIDIAN_FURNACE_RECIPE_TYPE);
    }
}
