package com.mrbysco.enhancedfarming.init.conditions;

import com.mojang.serialization.Codec;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.neoforged.neoforge.common.conditions.ICondition;

public class CropToSeedCondition implements ICondition {
	public static final CropToSeedCondition INSTANCE = new CropToSeedCondition();

	public static final Codec<CropToSeedCondition> CODEC = Codec.unit(INSTANCE).stable();

	private CropToSeedCondition() {
	}

	@Override
	public boolean test(IContext context) {
		return FarmingConfig.COMMON.cropToSeeds.get();
	}

	@Override
	public Codec<? extends ICondition> codec() {
		return CODEC;
	}

	@Override
	public String toString() {
		return "crop_to_seeds";
	}
}