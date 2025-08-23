package io.github.cgau3.abysmaldelight.mixin;

import io.github.cgau3.abysmaldelight.core.bait.BaitType;
import io.github.cgau3.abysmaldelight.item.BaitItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingHook.class)
public abstract class FishingHookMixin extends Projectile {

    @Shadow
    private int timeUntilLured;
    @Shadow
    @Final
    private int lureSpeed;

    protected FishingHookMixin(EntityType<? extends Projectile> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(
        method = "catchingFish(Lnet/minecraft/core/BlockPos;)V",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/entity/projectile/FishingHook;lureSpeed:I"),
        cancellable = true)
    public void modifiedCatchingFish(BlockPos pos, CallbackInfo ci) {

        Entity owner = this.getOwner();
        BaitType bait = null;
        if (owner instanceof LivingEntity livingOwner) {
            ItemStack mainHand = livingOwner.getMainHandItem();
            ItemStack offhand = livingOwner.getOffhandItem();
            if (mainHand.getItem() instanceof FishingRodItem && offhand.getItem() instanceof BaitItem baitItem) {
                bait = baitItem.getType().value();
            }
            if (offhand.getItem() instanceof FishingRodItem && mainHand.getItem() instanceof BaitItem baitItem) {
                bait = baitItem.getType().value();
            }
        }
        if (bait == null) return;

        ci.cancel();

        this.timeUntilLured = this.timeUntilLured - this.lureSpeed - bait.lureBoost * 20;
        if (this.timeUntilLured < 0) this.timeUntilLured = 10;
    }
}
