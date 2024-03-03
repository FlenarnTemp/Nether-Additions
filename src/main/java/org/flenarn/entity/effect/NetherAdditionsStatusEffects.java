package org.flenarn.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;

public class NetherAdditionsStatusEffects {

    public static RegistryEntry<StatusEffect> FUNGAL_AROMA;

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, new Identifier(NetherAdditions.MOD_ID, id), statusEffect);
    }

    public static void registeringStatusEffects() {
        NetherAdditions.LOGGER.info("Registering status effects for " + NetherAdditions.MOD_ID + ".");
        FUNGAL_AROMA = register("fungal_aroma", new FungalAromaEffect(StatusEffectCategory.NEUTRAL, 2146192));
    }
}