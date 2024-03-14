package org.flenarn.entity.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.flenarn.NetherAdditions;

public class NetherAdditionsStatusEffects {

    public static final StatusEffect FUNGAL_AROMA = new FungalAromaEffect(StatusEffectCategory.NEUTRAL, 2146192);

    public static void registeringStatusEffects() {
        NetherAdditions.LOGGER.info("Registering status effects for " + NetherAdditions.MOD_ID + ".");
        Registry.register(Registries.STATUS_EFFECT, new Identifier(NetherAdditions.MOD_ID, "fungal_aroma"), FUNGAL_AROMA);
    }
}