package org.xkmc.polaris.init.data;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import net.minecraft.util.text.TranslationTextComponent;
import org.xkmc.polaris.init.Polaris;

public enum LangData {
	ADVANCEMENT_STARLORD_TITLE("advancement.starlord.title", "I'm the star load"),
	ADVANCEMENT_STARLORD_TEXT("advancement.starlord.text", "Equip full star load armor"),
	ADVANCEMENT_SUPREME_TITLE("advancement.supreme.title", "I'm the god"),
	ADVANCEMENT_SUPREME_TEXT("advancement.supreme.text", "Equip full supreme genesis armor"),
	ARMOR_EXTRA("tooltip.armor.extra", "When equip full set:"),
	ARMOR_FLY("tooltip.armor.fly", "Enable creative fly"),
	ARMOR_HOME("tooltip.armor.home", "Return home when dropped in the void");

	private final String key, def;

	LangData(String key, String def) {
		this.key = Polaris.MODID + "." + key;
		this.def = def;
	}

	public TranslationTextComponent get() {
		return new TranslationTextComponent(key);
	}

	public static void genLang(RegistrateLangProvider pvd) {
		for (LangData data : LangData.values()) {
			pvd.add(data.key, data.def);
		}
	}
}
