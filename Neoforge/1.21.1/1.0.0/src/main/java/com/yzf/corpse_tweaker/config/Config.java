package com.yzf.corpse_tweaker.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class Config {
    private static final ModConfigSpec.Builder BUILDER;

    public static ModConfigSpec.ConfigValue<List<? extends Double>> headPos_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> headRot_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> headScale_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> bodyPos_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> bodyRot_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> bodyScale_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftArmPos_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftArmRot_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftArmScale_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightArmPos_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightArmRot_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightArmScale_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftLegPos_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftLegRot_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftLegScale_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightLegPos_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightLegRot_up;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightLegScale_up;

    public static ModConfigSpec.ConfigValue<List<? extends Double>> headPos_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> headRot_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> headScale_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> bodyPos_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> bodyRot_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> bodyScale_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftArmPos_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftArmRot_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftArmScale_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightArmPos_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightArmRot_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightArmScale_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftLegPos_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftLegRot_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> leftLegScale_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightLegPos_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightLegRot_down;
    public static ModConfigSpec.ConfigValue<List<? extends Double>> rightLegScale_down;

    public static final ModConfigSpec SPEC;

    static {
        BUILDER = new ModConfigSpec.Builder();

        BUILDER.push("Face_Up");
        headPos_up = BUILDER.defineList("headPos", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, x -> x instanceof Double);
        headRot_up = BUILDER.defineList("headRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        headScale_up = BUILDER.defineList("headScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        bodyPos_up = BUILDER.defineList("bodyPos", List.of(0.0D, 0.0D, -0.001D), () -> 0.0D, x -> x instanceof Double);
        bodyRot_up = BUILDER.defineList("bodyRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        bodyScale_up = BUILDER.defineList("bodyScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        leftArmPos_up = BUILDER.defineList("leftArmPos", List.of(5.0D, 2.0D, 0.0D), () -> 0.0D, x -> x instanceof Double);
        leftArmRot_up = BUILDER.defineList("leftArmRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        leftArmScale_up = BUILDER.defineList("leftArmScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        rightArmPos_up = BUILDER.defineList("rightArmPos", List.of(-5.0D, 2.0D, 0.0D), () -> 0.0D, x -> x instanceof Double);
        rightArmRot_up = BUILDER.defineList("rightArmRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        rightArmScale_up = BUILDER.defineList("rightArmScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        leftLegPos_up = BUILDER.defineList("leftLegPos", List.of(-2.0D, 12.0D, 0.001D), () -> 0.0D, x -> x instanceof Double);
        leftLegRot_up = BUILDER.defineList("leftLegRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        leftLegScale_up = BUILDER.defineList("leftLegScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        rightLegPos_up = BUILDER.defineList("rightLegPos", List.of(2.0D, 12.0D, 0.0D), () -> 0.0D, x -> x instanceof Double);
        rightLegRot_up = BUILDER.defineList("rightLegRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        rightLegScale_up = BUILDER.defineList("rightLegScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);

        BUILDER.pop();

        BUILDER.push("Face_Down");
        headPos_down = BUILDER.defineList("headPos", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, x -> x instanceof Double);
        headRot_down = BUILDER.defineList("headRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        headScale_down = BUILDER.defineList("headScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        bodyPos_down = BUILDER.defineList("bodyPos", List.of(0.0D, 0.0D, -0.001D), () -> 0.0D, x -> x instanceof Double);
        bodyRot_down = BUILDER.defineList("bodyRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        bodyScale_down = BUILDER.defineList("bodyScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        leftArmPos_down = BUILDER.defineList("leftArmPos", List.of(5.0D, 2.0D, 0.0D), () -> 0.0D, x -> x instanceof Double);
        leftArmRot_down = BUILDER.defineList("leftArmRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        leftArmScale_down = BUILDER.defineList("leftArmScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        rightArmPos_down = BUILDER.defineList("rightArmPos", List.of(-5.0D, 2.0D, 0.0D), () -> 0.0D, x -> x instanceof Double);
        rightArmRot_down = BUILDER.defineList("rightArmRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        rightArmScale_down = BUILDER.defineList("rightArmScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        leftLegPos_down = BUILDER.defineList("leftLegPos", List.of(-2.0D, 12.0D, 0.001D), () -> 0.0D, x -> x instanceof Double);
        leftLegRot_down = BUILDER.defineList("leftLegRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        leftLegScale_down = BUILDER.defineList("leftLegScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        rightLegPos_down = BUILDER.defineList("rightLegPos", List.of(2.0D, 12.0D, 0.0D), () -> 0.0D, x -> x instanceof Double);
        rightLegRot_down = BUILDER.defineList("rightLegRot", List.of(0.0D, 0.0D, 0.0D), () -> 0.0D, y -> y instanceof Double);
        rightLegScale_down = BUILDER.defineList("rightLegScale", List.of(1.0D, 1.0D, 1.0D), () -> 1.0D, z -> z instanceof Double);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}