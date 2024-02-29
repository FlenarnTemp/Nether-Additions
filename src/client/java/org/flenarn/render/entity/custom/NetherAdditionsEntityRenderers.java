package org.flenarn.render.entity.custom;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.flenarn.NetherAdditions;

public class NetherAdditionsEntityRenderers {
    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(NetherAdditions.WEEPING_FISHING_BOBBER_ENTITY_TYPE,  WeepingFishingBobberEntityRenderer::new);
    }
}
