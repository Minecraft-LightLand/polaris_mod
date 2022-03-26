package org.xkmc.polaris.init;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
	public static DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS,
			Polaris.MODID);
	public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,
			Polaris.MODID);
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
			DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Polaris.MODID);

	public static void register() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		CONTAINERS.register(modEventBus);
		TILE_ENTITIES.register(modEventBus);
		RECIPE_SERIALIZER.register(modEventBus);
		PolarisItems.register();
		PolarisBlocks.register();
		PolarisTileEntities.register();
		PolarisContainers.register();
		PolarisRecipeTypes.register();
	}
}
