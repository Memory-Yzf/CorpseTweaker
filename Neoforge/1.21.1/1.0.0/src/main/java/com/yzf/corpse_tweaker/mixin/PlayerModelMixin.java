package com.yzf.corpse_tweaker.mixin;

import com.yzf.corpse_tweaker.config.Config;
import de.maxhenkel.corpse.Main;
import de.maxhenkel.corpse.entities.DummyPlayer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerModel.class)
public abstract class PlayerModelMixin<T extends LivingEntity> extends HumanoidModel<T> {
    @Shadow
    @Final
    public ModelPart jacket;
    @Shadow
    @Final
    public ModelPart leftSleeve;
    @Shadow
    @Final
    public ModelPart rightSleeve;
    @Shadow
    @Final
    public ModelPart leftPants;
    @Shadow
    @Final
    public ModelPart rightPants;
    @Unique
    private float corpse_Tweaker$headX, corpse_Tweaker$headY, corpse_Tweaker$headZ, corpse_Tweaker$headXScale, corpse_Tweaker$headYScale, corpse_Tweaker$headZScale;
    @Unique
    private float corpse_Tweaker$bodyX, corpse_Tweaker$bodyY, corpse_Tweaker$bodyZ, corpse_Tweaker$bodyXScale, corpse_Tweaker$bodyYScale, corpse_Tweaker$bodyZScale;
    @Unique
    private float corpse_Tweaker$leftArmX, corpse_Tweaker$leftArmY, corpse_Tweaker$leftArmZ, corpse_Tweaker$leftArmXScale, corpse_Tweaker$leftArmYScale, corpse_Tweaker$leftArmZScale;
    @Unique
    private float corpse_Tweaker$rightArmX, corpse_Tweaker$rightArmY, corpse_Tweaker$rightArmZ, corpse_Tweaker$rightArmXScale, corpse_Tweaker$rightArmYScale, corpse_Tweaker$rightArmZScale;
    @Unique
    private float corpse_Tweaker$leftLegX, corpse_Tweaker$leftLegY, corpse_Tweaker$leftLegZ, corpse_Tweaker$leftLegXScale, corpse_Tweaker$leftLegYScale, corpse_Tweaker$leftLegZScale;
    @Unique
    private float corpse_Tweaker$rightLegX, corpse_Tweaker$rightLegY, corpse_Tweaker$rightLegZ, corpse_Tweaker$rightLegXScale, corpse_Tweaker$rightLegYScale, corpse_Tweaker$rightLegZScale;
    @Unique
    private boolean corpse_Tweaker$saved = false;

    public PlayerModelMixin(ModelPart root) {
        super(root);
    }

    @Inject(method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", at = @At("HEAD"))
    private void set1(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (!corpse_Tweaker$saved) {
            corpse_Tweaker$headX = this.head.x;
            corpse_Tweaker$headY = this.head.y;
            corpse_Tweaker$headZ = this.head.z;
            corpse_Tweaker$headXScale = this.head.xScale;
            corpse_Tweaker$headYScale = this.head.yScale;
            corpse_Tweaker$headZScale = this.head.zScale;
            corpse_Tweaker$bodyX = this.body.x;
            corpse_Tweaker$bodyY = this.body.y;
            corpse_Tweaker$bodyZ = this.body.z;
            corpse_Tweaker$bodyXScale = this.body.xScale;
            corpse_Tweaker$bodyYScale = this.body.yScale;
            corpse_Tweaker$bodyZScale = this.body.zScale;
            corpse_Tweaker$leftArmX = this.leftArm.x;
            corpse_Tweaker$leftArmY = this.leftArm.y;
            corpse_Tweaker$leftArmZ = this.leftArm.z;
            corpse_Tweaker$leftArmXScale = this.leftArm.xScale;
            corpse_Tweaker$leftArmYScale = this.leftArm.yScale;
            corpse_Tweaker$leftArmZScale = this.leftArm.zScale;
            corpse_Tweaker$rightArmX = this.rightArm.x;
            corpse_Tweaker$rightArmY = this.rightArm.y;
            corpse_Tweaker$rightArmZ = this.rightArm.z;
            corpse_Tweaker$rightArmXScale = this.rightArm.xScale;
            corpse_Tweaker$rightArmYScale = this.rightArm.yScale;
            corpse_Tweaker$rightArmZScale = this.rightArm.zScale;
            corpse_Tweaker$leftLegX = this.leftLeg.x;
            corpse_Tweaker$leftLegY = this.leftLeg.y;
            corpse_Tweaker$leftLegZ = this.leftLeg.z;
            corpse_Tweaker$leftLegXScale = this.leftLeg.xScale;
            corpse_Tweaker$leftLegYScale = this.leftLeg.yScale;
            corpse_Tweaker$leftLegZScale = this.leftLeg.zScale;
            corpse_Tweaker$rightLegX = this.rightLeg.x;
            corpse_Tweaker$rightLegY = this.rightLeg.y;
            corpse_Tweaker$rightLegZ = this.rightLeg.z;
            corpse_Tweaker$rightLegXScale = this.rightLeg.xScale;
            corpse_Tweaker$rightLegYScale = this.rightLeg.yScale;
            corpse_Tweaker$rightLegZScale = this.rightLeg.zScale;

            corpse_Tweaker$saved = true;
        }
    }

    @Inject(method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", at = @At("TAIL"))
    private void set2(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (entity instanceof DummyPlayer) {
            if (!Main.SERVER_CONFIG.spawnCorpseOnFace.get()) {
                head.setPos(Config.headPos_up.get().get(0).floatValue(), Config.headPos_up.get().get(1).floatValue(), Config.headPos_up.get().get(2).floatValue());
                head.setRotation((float) Math.toRadians(Config.headRot_up.get().get(0).floatValue()), (float) Math.toRadians(Config.headRot_up.get().get(1).floatValue()), (float) Math.toRadians(Config.headRot_up.get().get(2).floatValue()));
                head.xScale = Config.headScale_up.get().get(0).floatValue();
                head.yScale = Config.headScale_up.get().get(1).floatValue();
                head.zScale = Config.headScale_up.get().get(2).floatValue();
                body.setPos(Config.bodyPos_up.get().get(0).floatValue(), Config.bodyPos_up.get().get(1).floatValue(), Config.bodyPos_up.get().get(2).floatValue());
                body.setRotation((float) Math.toRadians(Config.bodyRot_up.get().get(0).floatValue()), (float) Math.toRadians(Config.bodyRot_up.get().get(1).floatValue()), (float) Math.toRadians(Config.bodyRot_up.get().get(2).floatValue()));
                body.xScale = Config.bodyScale_up.get().get(0).floatValue();
                body.yScale = Config.bodyScale_up.get().get(1).floatValue();
                body.zScale = Config.bodyScale_up.get().get(2).floatValue();
                jacket.copyFrom(body);
                leftArm.setPos(Config.leftArmPos_up.get().get(0).floatValue(), Config.leftArmPos_up.get().get(1).floatValue(), Config.leftArmPos_up.get().get(2).floatValue());
                leftArm.setRotation((float) Math.toRadians(Config.leftArmRot_up.get().get(0).floatValue()), (float) Math.toRadians(Config.leftArmRot_up.get().get(1).floatValue()), (float) Math.toRadians(Config.leftArmRot_up.get().get(2).floatValue()));
                leftArm.xScale = Config.leftArmScale_up.get().get(0).floatValue();
                leftArm.yScale = Config.leftArmScale_up.get().get(1).floatValue();
                leftArm.zScale = Config.leftArmScale_up.get().get(2).floatValue();
                leftSleeve.copyFrom(leftArm);
                rightArm.setPos(Config.rightArmPos_up.get().get(0).floatValue(), Config.rightArmPos_up.get().get(1).floatValue(), Config.rightArmPos_up.get().get(2).floatValue());
                rightArm.setRotation((float) Math.toRadians(Config.rightArmRot_up.get().get(0).floatValue()), (float) Math.toRadians(Config.rightArmRot_up.get().get(1).floatValue()), (float) Math.toRadians(Config.rightArmRot_up.get().get(2).floatValue()));
                rightArm.xScale = Config.rightArmScale_up.get().get(0).floatValue();
                rightArm.yScale = Config.rightArmScale_up.get().get(1).floatValue();
                rightArm.zScale = Config.rightArmScale_up.get().get(2).floatValue();
                rightSleeve.copyFrom(rightArm);
                leftLeg.setPos(Config.leftLegPos_up.get().get(0).floatValue(), Config.leftLegPos_up.get().get(1).floatValue(), Config.leftLegPos_up.get().get(2).floatValue());
                leftLeg.setRotation((float) Math.toRadians(Config.leftLegRot_up.get().get(0).floatValue()), (float) Math.toRadians(Config.leftLegRot_up.get().get(1).floatValue()), (float) Math.toRadians(Config.leftLegRot_up.get().get(2).floatValue()));
                leftLeg.xScale = Config.leftLegScale_up.get().get(0).floatValue();
                leftLeg.yScale = Config.leftLegScale_up.get().get(1).floatValue();
                leftLeg.zScale = Config.leftLegScale_up.get().get(2).floatValue();
                leftPants.copyFrom(leftLeg);
                rightLeg.setPos(Config.rightLegPos_up.get().get(0).floatValue(), Config.rightLegPos_up.get().get(1).floatValue(), Config.rightLegPos_up.get().get(2).floatValue());
                rightLeg.setRotation((float) Math.toRadians(Config.rightLegRot_up.get().get(0).floatValue()), (float) Math.toRadians(Config.rightLegRot_up.get().get(1).floatValue()), (float) Math.toRadians(Config.rightLegRot_up.get().get(2).floatValue()));
                rightLeg.xScale = Config.rightLegScale_up.get().get(0).floatValue();
                rightLeg.yScale = Config.rightLegScale_up.get().get(1).floatValue();
                rightLeg.zScale = Config.rightLegScale_up.get().get(2).floatValue();
                rightPants.copyFrom(rightLeg);
            } else {
                head.setPos(Config.headPos_down.get().get(0).floatValue(), Config.headPos_down.get().get(1).floatValue(), Config.headPos_down.get().get(2).floatValue());
                head.setRotation((float) Math.toRadians(Config.headRot_down.get().get(0).floatValue()), (float) Math.toRadians(Config.headRot_down.get().get(1).floatValue()), (float) Math.toRadians(Config.headRot_down.get().get(2).floatValue()));
                head.xScale = Config.headScale_down.get().get(0).floatValue();
                head.yScale = Config.headScale_down.get().get(1).floatValue();
                head.zScale = Config.headScale_down.get().get(2).floatValue();
                body.setPos(Config.bodyPos_down.get().get(0).floatValue(), Config.bodyPos_down.get().get(1).floatValue(), Config.bodyPos_down.get().get(2).floatValue());
                body.setRotation((float) Math.toRadians(Config.bodyRot_down.get().get(0).floatValue()), (float) Math.toRadians(Config.bodyRot_down.get().get(1).floatValue()), (float) Math.toRadians(Config.bodyRot_down.get().get(2).floatValue()));
                body.xScale = Config.bodyScale_down.get().get(0).floatValue();
                body.yScale = Config.bodyScale_down.get().get(1).floatValue();
                body.zScale = Config.bodyScale_down.get().get(2).floatValue();
                jacket.copyFrom(body);
                leftArm.setPos(Config.leftArmPos_down.get().get(0).floatValue(), Config.leftArmPos_down.get().get(1).floatValue(), Config.leftArmPos_down.get().get(2).floatValue());
                leftArm.setRotation((float) Math.toRadians(Config.leftArmRot_down.get().get(0).floatValue()), (float) Math.toRadians(Config.leftArmRot_down.get().get(1).floatValue()), (float) Math.toRadians(Config.leftArmRot_down.get().get(2).floatValue()));
                leftArm.xScale = Config.leftArmScale_down.get().get(0).floatValue();
                leftArm.yScale = Config.leftArmScale_down.get().get(1).floatValue();
                leftArm.zScale = Config.leftArmScale_down.get().get(2).floatValue();
                leftSleeve.copyFrom(leftArm);
                rightArm.setPos(Config.rightArmPos_down.get().get(0).floatValue(), Config.rightArmPos_down.get().get(1).floatValue(), Config.rightArmPos_down.get().get(2).floatValue());
                rightArm.setRotation((float) Math.toRadians(Config.rightArmRot_down.get().get(0).floatValue()), (float) Math.toRadians(Config.rightArmRot_down.get().get(1).floatValue()), (float) Math.toRadians(Config.rightArmRot_down.get().get(2).floatValue()));
                rightArm.xScale = Config.rightArmScale_down.get().get(0).floatValue();
                rightArm.yScale = Config.rightArmScale_down.get().get(1).floatValue();
                rightArm.zScale = Config.rightArmScale_down.get().get(2).floatValue();
                rightSleeve.copyFrom(rightArm);
                leftLeg.setPos(Config.leftLegPos_down.get().get(0).floatValue(), Config.leftLegPos_down.get().get(1).floatValue(), Config.leftLegPos_down.get().get(2).floatValue());
                leftLeg.setRotation((float) Math.toRadians(Config.leftLegRot_down.get().get(0).floatValue()), (float) Math.toRadians(Config.leftLegRot_down.get().get(1).floatValue()), (float) Math.toRadians(Config.leftLegRot_down.get().get(2).floatValue()));
                leftLeg.xScale = Config.leftLegScale_down.get().get(0).floatValue();
                leftLeg.yScale = Config.leftLegScale_down.get().get(1).floatValue();
                leftLeg.zScale = Config.leftLegScale_down.get().get(2).floatValue();
                leftPants.copyFrom(leftLeg);
                rightLeg.setPos(Config.rightLegPos_down.get().get(0).floatValue(), Config.rightLegPos_down.get().get(1).floatValue(), Config.rightLegPos_down.get().get(2).floatValue());
                rightLeg.setRotation((float) Math.toRadians(Config.rightLegRot_down.get().get(0).floatValue()), (float) Math.toRadians(Config.rightLegRot_down.get().get(1).floatValue()), (float) Math.toRadians(Config.rightLegRot_down.get().get(2).floatValue()));
                rightLeg.xScale = Config.rightLegScale_down.get().get(0).floatValue();
                rightLeg.yScale = Config.rightLegScale_down.get().get(1).floatValue();
                rightLeg.zScale = Config.rightLegScale_down.get().get(2).floatValue();
                rightPants.copyFrom(rightLeg);
            }
        } else {
            head.setPos(corpse_Tweaker$headX, corpse_Tweaker$headY, corpse_Tweaker$headZ);
            head.xScale = corpse_Tweaker$headXScale;
            head.yScale = corpse_Tweaker$headYScale;
            head.zScale = corpse_Tweaker$headZScale;
            body.setPos(corpse_Tweaker$bodyX, corpse_Tweaker$bodyY, corpse_Tweaker$bodyZ);
            body.xScale = corpse_Tweaker$bodyXScale;
            body.yScale = corpse_Tweaker$bodyYScale;
            body.zScale = corpse_Tweaker$bodyZScale;
            leftArm.setPos(corpse_Tweaker$leftArmX, corpse_Tweaker$leftArmY, corpse_Tweaker$leftArmZ);
            leftArm.xScale = corpse_Tweaker$leftArmXScale;
            leftArm.yScale = corpse_Tweaker$leftArmYScale;
            leftArm.zScale = corpse_Tweaker$leftArmZScale;
            rightArm.setPos(corpse_Tweaker$rightArmX, corpse_Tweaker$rightArmY, corpse_Tweaker$rightArmZ);
            rightArm.xScale = corpse_Tweaker$rightArmXScale;
            rightArm.yScale = corpse_Tweaker$rightArmYScale;
            rightArm.zScale = corpse_Tweaker$rightArmZScale;
            leftLeg.setPos(corpse_Tweaker$leftLegX, corpse_Tweaker$leftLegY, corpse_Tweaker$leftLegZ);
            leftLeg.xScale = corpse_Tweaker$leftLegXScale;
            leftLeg.yScale = corpse_Tweaker$leftLegYScale;
            leftLeg.zScale = corpse_Tweaker$leftLegZScale;
            rightLeg.setPos(corpse_Tweaker$rightLegX, corpse_Tweaker$rightLegY, corpse_Tweaker$rightLegZ);
            rightLeg.xScale = corpse_Tweaker$rightLegXScale;
            rightLeg.yScale = corpse_Tweaker$rightLegYScale;
            rightLeg.zScale = corpse_Tweaker$rightLegZScale;
        }
        jacket.copyFrom(body);
        leftSleeve.copyFrom(leftArm);
        rightSleeve.copyFrom(rightArm);
        leftPants.copyFrom(leftLeg);
        rightPants.copyFrom(rightLeg);
    }
}