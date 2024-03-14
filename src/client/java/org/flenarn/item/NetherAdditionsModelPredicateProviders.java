package org.flenarn.item;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import org.flenarn.item.custom.WeepingFishingRodItem;

public class NetherAdditionsModelPredicateProviders {
    public static void registerModelPredicateProviders() {
        ModelPredicateProviderRegistry.register(NetherAdditionsItems.WEEPING_FISHING_ROD, new Identifier("cast"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            } else {
                boolean mainHandStackMatches = entity.getMainHandStack() == stack;
                boolean offHandStackMatches = entity.getOffHandStack() == stack;

                if (entity.getMainHandStack().getItem() instanceof WeepingFishingRodItem) {
                    offHandStackMatches = false;
                }
                return (mainHandStackMatches || offHandStackMatches) && entity instanceof PlayerEntity && ((PlayerEntity)entity).fishHook != null ? 1.0F : 0.0F;
            }
        });
    }
}
