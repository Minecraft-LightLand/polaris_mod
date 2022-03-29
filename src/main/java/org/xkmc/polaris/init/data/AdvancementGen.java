package org.xkmc.polaris.init.data;

import com.tterrag.registrate.providers.RegistrateAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.xkmc.polaris.content.item.PolarisArmorMaterial;
import org.xkmc.polaris.init.Polaris;
import org.xkmc.polaris.init.registry.PolarisItems;

public class AdvancementGen {

	public static void genAdvancement(RegistrateAdvancementProvider pvd) {
		Advancement adv = addArmorAdvancement(PolarisArmorMaterial.STAR_LORD, FrameType.GOAL,
				LangData.ADVANCEMENT_STARLORD_TITLE.get(),
				LangData.ADVANCEMENT_STARLORD_TEXT.get()
		).save(pvd, PolarisArmorMaterial.STAR_LORD.getName());

		addArmorAdvancement(PolarisArmorMaterial.SUPREME_GENESIS, FrameType.CHALLENGE,
				LangData.ADVANCEMENT_SUPREME_TITLE.get(),
				LangData.ADVANCEMENT_SUPREME_TEXT.get()
		).parent(adv).save(pvd, PolarisArmorMaterial.SUPREME_GENESIS.getName());
	}

	private static Advancement.Builder addArmorAdvancement(PolarisArmorMaterial mat, FrameType type,
														   ITextComponent title, ITextComponent text) {
		Item[] items = new Item[4];
		for (int i = 0; i < 4; i++) {
			items[i] = PolarisItems.ARMORS[mat.ordinal()][i].get();
		}
		return Advancement.Builder.advancement().display(
				PolarisItems.ARMORS[mat.ordinal()][1].get(), title, text,
				new ResourceLocation(Polaris.MODID, "textures/gui/advancements/backgrounds/netherite_block.png"),
				type, true, true, false
		).addCriterion("equip_" + mat.name, InventoryChangeTrigger.Instance.hasItems(items));

	}

}
