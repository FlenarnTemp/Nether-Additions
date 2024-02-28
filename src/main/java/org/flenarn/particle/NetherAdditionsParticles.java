package org.flenarn.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.flenarn.NetherAdditions;

public class NetherAdditionsParticles {
    public static final DefaultParticleType LAVA_FISHING = FabricParticleTypes.simple();

    public static void registerParticles() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(NetherAdditions.MOD_ID, "lava_fishing"), LAVA_FISHING);
    }
}