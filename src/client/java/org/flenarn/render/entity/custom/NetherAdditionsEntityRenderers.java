package org.flenarn.render.entity.custom;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.flenarn.entity.projectile.NetherAdditionsEntityTypes;

public class NetherAdditionsEntityRenderers {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(NetherAdditionsEntityTypes.WEEPING_FISHING_BOBBER_ENTITY_TYPE,  WeepingFishingBobberEntityRenderer::new);
    }
}
