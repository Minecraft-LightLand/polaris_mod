package org.xkmc.polaris.data.recipes;

import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import org.xkmc.polaris.util.Registration;

public class PolarisRecipeTypes {

    public static final RegistryObject<ObsidianFurnaceRecipe.Serializer> OBSIDIAN_FURNACE_SERIALIZER =
            Registration.RECIPE_SERIALIZER.register("obsidian_furnace", ObsidianFurnaceRecipe.Serializer::new);
    public static IRecipeType<ObsidianFurnaceRecipe> OBSIDIAN_NETHER_FURNACE_RECIPE = new ObsidianFurnaceRecipe.ObsidianFurnaceRecipeType();


    public static void register() {
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation("asd"), OBSIDIAN_NETHER_FURNACE_RECIPE);
    }
}
