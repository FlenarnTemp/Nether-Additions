package org.flenarn.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class NetherAdditionsFoodComponents {
    private static FoodComponent.Builder createStew(int hunger) {
        return (new FoodComponent.Builder()).hunger(hunger).saturationModifier(0.6F);
    }

    public static final FoodComponent GOLDHEAD_WRASSE = new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).build();
    public static final FoodComponent PYROLITHID = new FoodComponent.Builder().hunger(4).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 400, 0), 0.4f).build();
    public static final FoodComponent LAVACANTH = new FoodComponent.Builder().hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 900, 0), 1f).build();
    public static final FoodComponent ECTOCARP = new FoodComponent.Builder().hunger(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 40), 1.0f).alwaysEdible().build();
    public static final FoodComponent LITHID_SOUP = createStew(8).build();
}
