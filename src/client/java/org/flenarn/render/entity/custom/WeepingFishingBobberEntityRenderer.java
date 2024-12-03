package org.flenarn.render.entity.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.FishingBobberEntityState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

import org.flenarn.NetherAdditions;
import org.flenarn.entity.projectile.custom.WeepingFishingBobberEntity;
import org.flenarn.item.NetherAdditionsItems;
import org.flenarn.render.entity.state.WeepingFishingBobberEntityState;

@Environment(EnvType.CLIENT)
public class WeepingFishingBobberEntityRenderer extends EntityRenderer<WeepingFishingBobberEntity, WeepingFishingBobberEntityState> {
    private static final Identifier TEXTURE = NetherAdditions.getModId("textures/entity/weeping_fishing_hook.png");
    private static final RenderLayer LAYER;

    public WeepingFishingBobberEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public boolean shouldRender(WeepingFishingBobberEntity weepingFishingBobberEntity, Frustum frustum, double d, double e, double f) {
        return super.shouldRender(weepingFishingBobberEntity, frustum, d, e, f) && weepingFishingBobberEntity.getPlayerOwner() != null;
    }

    public void render(WeepingFishingBobberEntityState weepingFishingBobberEntityState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.push();
        matrixStack.scale(0.5F, 0.5F, 0.5F);
        matrixStack.multiply(this.dispatcher.getRotation());
        MatrixStack.Entry entry = matrixStack.peek();
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(LAYER);
        vertex(vertexConsumer, entry, i, 0.0F, 0, 0, 1);
        vertex(vertexConsumer, entry, i, 1.0F, 0, 1, 1);
        vertex(vertexConsumer, entry, i, 1.0F, 1, 1, 0);
        vertex(vertexConsumer, entry, i, 0.0F, 1, 0, 0);
        matrixStack.pop();
        float f = (float) weepingFishingBobberEntityState.pos.x;
        float g = (float) weepingFishingBobberEntityState.pos.y;
        float h = (float) weepingFishingBobberEntityState.pos.z;

        VertexConsumer vertexConsumer1 = vertexConsumerProvider.getBuffer(RenderLayer.getLineStrip());
        MatrixStack.Entry entry1 = matrixStack.peek();

        int j = 16;

        for (int k = 0; k < 6; ++k) {
            renderFishingLine(f, g, h, vertexConsumer1, entry1, percentage(k, 16), percentage(k + 1, 16));
        }

        matrixStack.pop();
        super.render(weepingFishingBobberEntityState, matrixStack, vertexConsumerProvider, i);
    }

    private Vec3d getHandPos(PlayerEntity player, float f, float tickDelta) {
        int i = player.getMainArm() == Arm.RIGHT ? 1 : -1;
        ItemStack itemStack = player.getMainHandStack();
        if (!itemStack.isOf(NetherAdditionsItems.WEEPING_FISHING_ROD)) {
            i = -i;
        }

        if (this.dispatcher.gameOptions.getPerspective().isFirstPerson() && player == MinecraftClient.getInstance().player) {
            double m = (double)960.0F / (double) this.dispatcher.gameOptions.getFov().getValue();
            Vec3d vec3d = this.dispatcher.camera.getProjection().getPosition((float)i * 0.525F, -0.1F).multiply(m).rotateY(f * 0.5F).rotateX(-f * 0.7F);
            return player.getCameraPosVec(tickDelta).add(vec3d);
        } else {
            float g = MathHelper.lerp(tickDelta, player.prevBodyYaw, player.bodyYaw) * ((float)Math.PI / 180F);
            double d = MathHelper.sin(g);
            double e = MathHelper.cos(g);
            float h = player.getScale();
            double j = (double)i * 0.35 * (double)h;
            double k = 0.8 * (double)h;
            float l = player.isInSneakingPose() ? -0.1875F : 0.0F;
            return player.getCameraPosVec(tickDelta).add(-e * j - d * k, (double)l - 0.45 * (double)h, -d * j + e * k);
        }
    }

    private static float percentage(int value, int max) {
        return (float)value / (float)max;
    }

    private static void vertex(VertexConsumer buffer, MatrixStack.Entry matrix, int light, float x, int y, int u, int v) {
        buffer.vertex(matrix, x - 0.5F, (float)y - 0.5F, 0.0F).color(-1).texture((float)u, (float)v).overlay(OverlayTexture.DEFAULT_UV).light(light).normal(matrix, 0.0F, 1.0F, 0.0F);
    }

    private static void renderFishingLine(float x, float y, float z, VertexConsumer buffer, MatrixStack.Entry matrices, float segmentStart, float segmentEnd) {
        float f = x * segmentStart;
        float g = y * (segmentStart * segmentStart + segmentStart) * 0.5F + 0.25F;
        float h = z * segmentStart;
        float i = x * segmentEnd - f;
        float j = y * (segmentEnd * segmentEnd + segmentEnd) * 0.5F + 0.25F - g;
        float k = z * segmentEnd - h;
        float l = MathHelper.sqrt(i * i + j * j + k * k);
        i /= l;
        j /= l;
        k /= l;
        buffer.vertex(matrices, f, g, h).color(0, 0, 0, 255).normal(matrices, i, j, k);
    }

    public WeepingFishingBobberEntityState createRenderState() {
        return new WeepingFishingBobberEntityState();
    }

    protected boolean canBeCulled(WeepingFishingBobberEntity weepingFishingBobberEntity) {
        return false;
    }

    static {
        LAYER = RenderLayer.getEntityCutout(TEXTURE);
    }
}
