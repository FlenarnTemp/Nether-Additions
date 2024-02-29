package org.flenarn.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;

public class NetherAdditionsPotions {

    public static final Potion LEVITATION_POTION =
            Registry.register(Registries.POTION, new Identifier(NetherAdditions.MOD_ID, "levitation_potion"),
                    new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 300, 0)));

    public static final Potion LONGER_LEVITATION_POTION =
            Registry.register(Registries.POTION, new Identifier(NetherAdditions.MOD_ID, "longer_levitation_potion"),
                    new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 600, 0)));

    public static void registerPotions() {

    }

    public static void registerPotionsRecipes() {
        BrewingRecipeRegistry.registerPotionRecipe(NetherAdditionsPotions.LEVITATION_POTION, Items.REDSTONE, NetherAdditionsPotions.LONGER_LEVITATION_POTION);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, NetherAdditionsItems.ECTOCARP, NetherAdditionsPotions.LEVITATION_POTION);
    }
}
