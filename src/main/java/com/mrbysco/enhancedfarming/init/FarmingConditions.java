package com.mrbysco.enhancedfarming.init;

import com.mojang.serialization.Codec;
import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.init.conditions.CropToSeedCondition;
import com.mrbysco.enhancedfarming.init.conditions.RakeEnabledCondition;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class FarmingConditions {
	public static final DeferredRegister<Codec<? extends ICondition>> CONDITION_CODECS = DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, EnhancedFarming.MOD_ID);

	public static final DeferredHolder<Codec<? extends ICondition>, Codec<CropToSeedCondition>> CROP_TO_SEEDS = CONDITION_CODECS.register("crop_to_seeds", () -> CropToSeedCondition.CODEC);
	public static final DeferredHolder<Codec<? extends ICondition>, Codec<RakeEnabledCondition>> RAKE_ENABLED = CONDITION_CODECS.register("rake_enabled", () -> RakeEnabledCondition.CODEC);
}
