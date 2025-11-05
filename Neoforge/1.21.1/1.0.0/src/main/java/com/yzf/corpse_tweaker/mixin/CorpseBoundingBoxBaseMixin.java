package com.yzf.corpse_tweaker.mixin;

import de.maxhenkel.corpse.entities.CorpseBoundingBoxBase;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CorpseBoundingBoxBase.class)
public abstract class CorpseBoundingBoxBaseMixin extends Entity {
    public CorpseBoundingBoxBaseMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "recalculateBoundingBox", at = @At("HEAD"), cancellable = true)
    public void recalculateBoundingBox(CallbackInfo ci) {
        double size = 1.6;
        double height = 0.4;
        double half = size /2.0;
        this.setBoundingBox(new AABB(this.getX() - half, this.getY(), this.getZ() - half, this.getX() + half, this.getY() + height, this.getZ() + half));
        ci.cancel();
    }
}