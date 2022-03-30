package org.xkmc.polaris.init.registry;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import org.xkmc.polaris.content.magic.PersistentEffect;
import org.xkmc.polaris.init.Polaris;

public class PolarisMagic {

	public static final RegistryEntry<PersistentEffect> PERSISTENT = Polaris.REGISTRATE.simple("knowledge", Effect.class, () -> new PersistentEffect(EffectType.BENEFICIAL, 0xffffff));

	public static void register() {

	}

}
