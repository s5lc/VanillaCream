package cx.rain.mc.vanillacream.mixin;

import cx.rain.mc.vanillacream.registry.ModTags;
import net.minecraft.world.entity.AgeableMob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AgeableMob.class)
public class AgeableMobMixin {
    @Inject(method = "isBaby", at = @At("HEAD"), cancellable = true)
    private void vanillacream$before$isBaby(CallbackInfoReturnable<Boolean> cir) {
        var entity = (AgeableMob) (Object) this;
        var name = entity.getCustomName();
        if (entity.hasCustomName() && name != null) {
            if ("Peter_Pan".equals(name.getString()) && entity.typeHolder().is(ModTags.Entity.CAN_GROW)) {
                cir.setReturnValue(true);
            }
        }
    }
}
