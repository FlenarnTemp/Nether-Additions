package org.flenarn.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;
import org.flenarn.entity.effect.NetherAdditionsStatusEffects;

public class NetherAdditionsConsumableComponents {

    public static final ConsumableComponent PYROLIHID;
    public static final ConsumableComponent LAVACANTH;
    public static final ConsumableComponent ECTOCARP;
    public static final ConsumableComponent LITHID_SOUP;

    public NetherAdditionsConsumableComponents() {
    }

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }

    static {
        PYROLIHID = food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 400), 0.4F)).build();
        LAVACANTH = food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600), 1F)).build();
        ECTOCARP = food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 40), 1F)).build();
        LITHID_SOUP = food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(NetherAdditionsStatusEffects.FUNGAL_AROMA, 3000), 1F)).build();
    }
}
