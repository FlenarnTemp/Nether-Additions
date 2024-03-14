package org.flenarn.entity.projectile;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import org.flenarn.NetherAdditions;
import org.flenarn.entity.projectile.custom.WeepingFishingBobberEntity;

public class NetherAdditionsEntityTypes {

    public static final EntityType<WeepingFishingBobberEntity> WEEPING_FISHING_BOBBER_ENTITY_TYPE;

    static {
        WEEPING_FISHING_BOBBER_ENTITY_TYPE = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(NetherAdditions.MOD_ID, "weeping_fishing_bobber"),
                FabricEntityTypeBuilder.<WeepingFishingBobberEntity>create(SpawnGroup.MISC, WeepingFishingBobberEntity::new).disableSaving().disableSummon().dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build()
        );
    }
}
