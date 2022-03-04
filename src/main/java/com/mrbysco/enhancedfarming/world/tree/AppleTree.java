package com.mrbysco.enhancedfarming.world.tree;

import com.mrbysco.enhancedfarming.world.feature.FarmingFeatureConfigs;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class AppleTree extends AbstractTreeGrower {
	@Nullable
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean withBees) {
		if (random.nextInt(10) == 0) {
			return withBees ? FarmingFeatureConfigs.FANCY_APPLE_BEES_005 : FarmingFeatureConfigs.FANCY_APPLE;
		} else {
			return withBees ? FarmingFeatureConfigs.APPLE_BEES_005 : FarmingFeatureConfigs.APPLE;
		}
	}
}