package org.flenarn.render.entity.state;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class WeepingFishingBobberEntityState extends EntityRenderState {
    public Vec3d pos;

    public WeepingFishingBobberEntityState() {
        this.pos = Vec3d.ZERO;
    }
}
