package org.flenarn.particles;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FishingParticle;
import org.flenarn.particle.NetherAdditionsParticles;

public class NetherAdditionsParticlesClient {
    public static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(NetherAdditionsParticles.LAVA_FISHING, FishingParticle.Factory::new);
    }
}
