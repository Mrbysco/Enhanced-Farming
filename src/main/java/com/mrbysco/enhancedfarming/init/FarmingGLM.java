package com.mrbysco.enhancedfarming.init;

import com.mojang.serialization.Codec;
import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.lootmodifiers.GrassDropModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class FarmingGLM {
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, EnhancedFarming.MOD_ID);

	public static final Supplier<Codec<? extends IGlobalLootModifier>> GRASS_DROPS = GLM.register("grass_drops", GrassDropModifier.CODEC);
}
