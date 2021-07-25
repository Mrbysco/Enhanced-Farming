package com.mrbysco.enhancedfarming.world.tree;

import com.mrbysco.enhancedfarming.world.feature.FarmingFeatureConfigs;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;
import java.util.Random;

public class AvocadoTree extends AbstractTreeGrower {
	@Nullable
	protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean withBees) {
		return FarmingFeatureConfigs.AVOCADO;
	}
}