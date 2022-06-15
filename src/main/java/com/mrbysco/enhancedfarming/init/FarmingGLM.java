package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.lootmodifiers.GrassDropModifier.GrassDropSerializer;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FarmingGLM {
	public static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, Reference.MOD_ID);

	public static final RegistryObject<GrassDropSerializer> ENHANCED_SEED_DROPS = GLM.register("enhanced_seed_drops", GrassDropSerializer::new);
}
