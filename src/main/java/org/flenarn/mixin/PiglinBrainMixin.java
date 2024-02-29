package org.flenarn.mixin;

import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ItemStack;
import org.flenarn.item.NetherAdditionsItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {
	@Inject(at = @At("HEAD"), method = "acceptsForBarter", cancellable = true)
	private static void NetherAdditionsAcceptsForBarter(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
		if (stack.isOf(NetherAdditionsItems.GOLDHEAD_WRASSE)) {
			cir.setReturnValue(true);
		}
	}
}