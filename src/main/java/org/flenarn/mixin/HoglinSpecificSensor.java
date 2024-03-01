package org.flenarn.mixin;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.flenarn.entity.effect.NetherAdditionsStatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(net.minecraft.entity.ai.brain.sensor.HoglinSpecificSensor.class)
public class HoglinSpecificSensor {

    @Inject(at = @At("HEAD"), method = "findNearestWarpedFungus", cancellable = true)
    private void NethereAdditionsFindNearestWarpedFungus(ServerWorld world, HoglinEntity hoglin, CallbackInfoReturnable<Optional<BlockPos>> cir) {
        PlayerEntity player = hoglin.getWorld().getClosestPlayer(hoglin, 10);
        if (player != null) {
            if (player.hasStatusEffect(NetherAdditionsStatusEffects.FUNGAL_AROMA)) {
                cir.setReturnValue(Optional.ofNullable(player.getBlockPos()));
            }
        }
    }
}
