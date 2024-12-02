package org.flenarn.item;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import org.flenarn.NetherAdditions;

public class NetherAdditionsPotions {

    public static final RegistryEntry<Potion> LEVITATION_POTION;
    public static final RegistryEntry<Potion> LONGER_LEVITATION_POTION;
    public NetherAdditionsPotions() {
    }

    public static RegistryEntry<Potion> register(String name, Potion potion)
    {
        return Registry.registerReference(Registries.POTION, Identifier.of(NetherAdditions.MOD_ID, name), potion);
    }

    static {
        LEVITATION_POTION = register("levitation_potion", new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 300, 0)));
        LONGER_LEVITATION_POTION = register("longer_levitation_potion", new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 600, 0)));
    }

    public static void registerPotions() {
        NetherAdditions.LOGGER.info("Registering potions for " + NetherAdditions.MOD_ID + ".");
    }

    public static void registerPotionRecipes() {
        NetherAdditions.LOGGER.info("Registering potion recipes for " + NetherAdditions.MOD_ID + ".");
        FabricBrewingRecipeRegistryBuilder.BUILD.register(
                builder -> {
                    builder.registerPotionRecipe(Potions.AWKWARD, NetherAdditionsItems.ECTOCARP, NetherAdditionsPotions.LEVITATION_POTION);
                    builder.registerPotionRecipe(NetherAdditionsPotions.LEVITATION_POTION, Items.REDSTONE, NetherAdditionsPotions.LONGER_LEVITATION_POTION);
                }
        );
    }
}
