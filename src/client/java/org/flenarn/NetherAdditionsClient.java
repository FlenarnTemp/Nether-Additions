package org.flenarn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.particle.FishingParticle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.flenarn.item.NetherAdditionsItems;
import org.flenarn.item.custom.WeepingFishingRodItem;
import org.flenarn.particle.NetherAdditionsParticles;
import org.flenarn.render.entity.custom.WeepingFishingBobberEntityRenderer;

public class NetherAdditionsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(NetherAdditions.WEEPING_FISHING_BOBBER_ENTITY_TYPE,  WeepingFishingBobberEntityRenderer::new);

		ModelPredicateProviderRegistry.register(NetherAdditionsItems.WEEPING_FISHING_ROD, new Identifier("cast"), (stack, world, entity, seed) -> {
			if (entity == null) {
				return 0.0f;
			} else {
				boolean bl = entity.getMainHandStack() == stack;
				boolean bl2 = entity.getOffHandStack() == stack;

				if (entity.getMainHandStack().getItem() instanceof WeepingFishingRodItem) {
					bl2 = false;
				}
				return (bl || bl2) && entity instanceof PlayerEntity && ((PlayerEntity)entity).fishHook != null ? 1.0F : 0.0F;
			}
		});

		ParticleFactoryRegistry.getInstance().register(NetherAdditionsParticles.LAVA_FISHING, FishingParticle.Factory::new);
	}
}