package org.flenarn.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;

import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import org.flenarn.NetherAdditions;

public class NetherAdditionsParticles {

    public static final SimpleParticleType LAVA_FISHING = FabricParticleTypes.simple();

    public static void registerParticles() {
        NetherAdditions.LOGGER.info("Registering particles for " + NetherAdditions.MOD_ID + ".");
        Registry.register(Registries.PARTICLE_TYPE, NetherAdditions.getModId("lava_fishing"), LAVA_FISHING);
    }
}