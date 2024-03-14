package org.flenarn;

import net.fabricmc.api.ClientModInitializer;

import org.flenarn.item.NetherAdditionsModelPredicateProviders;
import org.flenarn.particles.NetherAdditionsParticlesClient;
import org.flenarn.render.entity.custom.NetherAdditionsEntityRenderers;

public class NetherAdditionsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		NetherAdditionsEntityRenderers.registerEntityRenderers();
		NetherAdditionsModelPredicateProviders.registerModelPredicateProviders();
		NetherAdditionsParticlesClient.registerParticles();
	}
}