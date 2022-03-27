package org.xkmc.polaris.content.recipes;

import com.google.gson.JsonObject;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import org.xkmc.polaris.init.registry.PolarisRecipeTypes;

public class AlloySmithingRecipe extends ShapedRecipe {

	private AlloySmithingRecipe(ShapedRecipe base) {
		super(base.getId(), base.getGroup(), base.getWidth(), base.getHeight(), base.getIngredients(), base.getResultItem());
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		return PolarisRecipeTypes.RS_ALLOY_SMITHING.get();
	}

	@Override
	public IRecipeType<?> getType() {
		return PolarisRecipeTypes.RT_ALLOY_SMITHING;
	}

	public static class Serializer extends ShapedRecipe.Serializer {

		@Override
		public AlloySmithingRecipe fromJson(ResourceLocation id, JsonObject json) {
			return new AlloySmithingRecipe(super.fromJson(id, json));
		}

		@Override
		public AlloySmithingRecipe fromNetwork(ResourceLocation id, PacketBuffer buffer) {
			ShapedRecipe base = super.fromNetwork(id, buffer);
			return base == null ? null : new AlloySmithingRecipe(base);
		}

		@Override
		public void toNetwork(PacketBuffer id, ShapedRecipe buffer) {
			super.toNetwork(id, buffer);
		}
	}

}
