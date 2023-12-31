package com.mrbysco.enhancedfarming.world.tree;

import com.mrbysco.enhancedfarming.world.feature.FarmingFeatureConfigs;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class FarmingTrees {
	public static final TreeGrower APPLE = new TreeGrower(
			"enhancedfarming:apple",
			0.1F,
			Optional.empty(),
			Optional.empty(),
			Optional.of(FarmingFeatureConfigs.APPLE),
			Optional.of(FarmingFeatureConfigs.FANCY_APPLE),
			Optional.of(FarmingFeatureConfigs.APPLE_BEES_005),
			Optional.of(FarmingFeatureConfigs.FANCY_APPLE_BEES_005)
	);

	public static final TreeGrower AVOCADO = new TreeGrower(
			"enhancedfarming:avocado",
			Optional.empty(),
			Optional.of(FarmingFeatureConfigs.AVOCADO),
			Optional.empty());

	public static final TreeGrower BANANA = new TreeGrower(
			"enhancedfarming:banana",
			Optional.empty(),
			Optional.of(FarmingFeatureConfigs.BANANA),
			Optional.empty());

	public static final TreeGrower CHERRY = new TreeGrower(
			"enhancedfarming:cherry",
			0.1F,
			Optional.empty(),
			Optional.empty(),
			Optional.of(FarmingFeatureConfigs.CHERRY),
			Optional.of(FarmingFeatureConfigs.FANCY_CHERRY),
			Optional.of(FarmingFeatureConfigs.CHERRY_BEES_005),
			Optional.of(FarmingFeatureConfigs.FANCY_CHERRY_BEES_005)
	);

	public static final TreeGrower LEMON = new TreeGrower(
			"enhancedfarming:lemon",
			0.1F,
			Optional.empty(),
			Optional.empty(),
			Optional.of(FarmingFeatureConfigs.LEMON),
			Optional.of(FarmingFeatureConfigs.FANCY_LEMON),
			Optional.of(FarmingFeatureConfigs.LEMON_BEES_005),
			Optional.of(FarmingFeatureConfigs.FANCY_LEMON_BEES_005)
	);

	public static final TreeGrower MANGO = new TreeGrower(
			"enhancedfarming:mango",
			Optional.empty(),
			Optional.of(FarmingFeatureConfigs.MANGO),
			Optional.empty());

	public static final TreeGrower OLIVE = new TreeGrower(
			"enhancedfarming:olive",
			Optional.empty(),
			Optional.of(FarmingFeatureConfigs.OLIVE),
			Optional.empty());


	public static final TreeGrower ORANGE = new TreeGrower(
			"enhancedfarming:orange",
			0.1F,
			Optional.empty(),
			Optional.empty(),
			Optional.of(FarmingFeatureConfigs.ORANGE),
			Optional.of(FarmingFeatureConfigs.FANCY_ORANGE),
			Optional.of(FarmingFeatureConfigs.ORANGE_BEES_005),
			Optional.of(FarmingFeatureConfigs.FANCY_ORANGE_BEES_005)
	);

	public static final TreeGrower PEAR = new TreeGrower(
			"enhancedfarming:pear",
			0.1F,
			Optional.empty(),
			Optional.empty(),
			Optional.of(FarmingFeatureConfigs.PEAR),
			Optional.of(FarmingFeatureConfigs.FANCY_PEAR),
			Optional.of(FarmingFeatureConfigs.PEAR_BEES_005),
			Optional.of(FarmingFeatureConfigs.FANCY_PEAR_BEES_005)
	);
}
