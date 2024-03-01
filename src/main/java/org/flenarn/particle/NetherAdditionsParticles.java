package org.flenarn.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;
import org.flenarn.entity.effect.NetherAdditionsStatusEffects;

public class NetherAdditionsParticles {
    public static final DefaultParticleType LAVA_FISHING = FabricParticleTypes.simple();

    public static void registerParticles() {
        NetherAdditions.LOGGER.info("Registering particles for " + NetherAdditions.MOD_ID + ".");
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(NetherAdditions.MOD_ID, "lava_fishing"), LAVA_FISHING);
    }
}