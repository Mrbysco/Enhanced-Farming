package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.lootmodifiers.GrassDropModifier;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

public class FarmingLootModifierProvider extends GlobalLootModifierProvider {
	public FarmingLootModifierProvider(PackOutput packOutput) {
		super(packOutput, EnhancedFarming.MOD_ID);
	}

	@Override
	protected void start() {
		this.add("grass_drops", new GrassDropModifier());
	}
}