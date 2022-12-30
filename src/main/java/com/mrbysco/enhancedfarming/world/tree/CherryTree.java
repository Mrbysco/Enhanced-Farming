package com.mrbysco.enhancedfarming.world.tree;

import com.mrbysco.enhancedfarming.world.feature.FarmingFeatureConfigs;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

public class CherryTree extends AbstractTreeGrower {
	@Nullable
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean withBees) {
		if (random.nextInt(10) == 0) {
			return withBees ? FarmingFeatureConfigs.FANCY_CHERRY_BEES_005 : FarmingFeatureConfigs.FANCY_CHERRY;
		} else {
			return withBees ? FarmingFeatureConfigs.CHERRY_BEES_005 : FarmingFeatureConfigs.CHERRY;
		}
	}
}