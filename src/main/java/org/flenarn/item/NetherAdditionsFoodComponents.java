package org.flenarn.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import org.flenarn.entity.effect.NetherAdditionsStatusEffects;

public class NetherAdditionsFoodComponents {

    private static FoodComponent.Builder createStew(int nutrition) {
        return (new FoodComponent.Builder()).nutrition(nutrition).saturationModifier(0.6F).usingConvertsTo(Items.BOWL);
    }

    public static final FoodComponent GOLDHEAD_WRASSE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final FoodComponent PYROLITHID = new FoodComponent.Builder().nutrition(4).saturationModifier(0.4f).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 400), 0.4f).build();
    public static final FoodComponent LAVACANTH = new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600), 1f).build();
    public static final FoodComponent ECTOCARP = new FoodComponent.Builder().nutrition(4).saturationModifier(0.2f).statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 40), 1.0f).alwaysEdible().build();
    public static final FoodComponent LITHID_SOUP = createStew(8).statusEffect(new StatusEffectInstance(NetherAdditionsStatusEffects.FUNGAL_AROMA, 3000), 1.0f).build();
}
