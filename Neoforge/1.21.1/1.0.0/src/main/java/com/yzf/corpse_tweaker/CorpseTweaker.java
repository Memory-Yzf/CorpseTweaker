package com.yzf.corpse_tweaker;

import com.yzf.corpse_tweaker.config.Config;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(CorpseTweaker.MODID)
public class CorpseTweaker {
    public static final String MODID = "corpse_tweaker";

    public CorpseTweaker(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, Config.SPEC, "corpse_tweaker.toml");
    }
}