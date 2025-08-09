package org.flenarn.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import org.flenarn.NetherAdditions;
import org.flenarn.entity.projectile.custom.WeepingFishingBobberEntity;

public class NetherAdditionsEntityTypes {

    public static final EntityType<WeepingFishingBobberEntity> WEEPING_FISHING_BOBBER_ENTITY_TYPE;

    static {
        WEEPING_FISHING_BOBBER_ENTITY_TYPE = registerEntityType(
                "weeping_fishing_bobber",
                EntityType.Builder.create(WeepingFishingBobberEntity::new, SpawnGroup.MISC)
        );
    }

    public static <T extends Entity> EntityType<T> registerEntityType(String path, EntityType.Builder<T> entityTypeBuilder) {
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, NetherAdditions.getModId(path));

        return Registry.register(Registries.ENTITY_TYPE, key, entityTypeBuilder.build(key));
    }

    public static void registerEntities() {
        NetherAdditions.LOGGER.info("Registering entity types for " + NetherAdditions.MOD_ID + ".");
    }
}