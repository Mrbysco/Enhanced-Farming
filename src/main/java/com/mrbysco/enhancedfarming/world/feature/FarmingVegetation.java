package com.mrbysco.enhancedfarming.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;

import java.util.List;

public class FarmingVegetation {
	public static void initialize() {
	}

	public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> APPLE_FRUIT_VEGETATION = FeatureUtils.register("apple_fruit_vegetation", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(FarmingTreePlacements.APPLE_BEES_002, 0.2F), new WeightedPlacedFeature(FarmingTreePlacements.FANCY_APPLE_BEES_002, 0.1F)), FarmingTreePlacements.APPLE_BEES_002));
	public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> LEMON_FRUIT_VEGETATION = FeatureUtils.register("lemon_fruit_vegetation", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(FarmingTreePlacements.LEMON_BEES_002, 0.2F), new WeightedPlacedFeature(FarmingTreePlacements.FANCY_LEMON_BEES_002, 0.1F)), FarmingTreePlacements.LEMON_BEES_002));
	public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ORANGE_FRUIT_VEGETATION = FeatureUtils.register("orange_fruit_vegetation", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(FarmingTreePlacements.ORANGE_BEES_002, 0.2F), new WeightedPlacedFeature(FarmingTreePlacements.FANCY_ORANGE_BEES_002, 0.1F)), FarmingTreePlacements.ORANGE_BEES_002));
	public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CHERRY_FRUIT_VEGETATION = FeatureUtils.register("cherry_fruit_vegetation", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(FarmingTreePlacements.CHERRY_BEES_002, 0.2F), new WeightedPlacedFeature(FarmingTreePlacements.FANCY_CHERRY_BEES_002, 0.1F)), FarmingTreePlacements.CHERRY_BEES_002));
	public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PEAR_FRUIT_VEGETATION = FeatureUtils.register("pear_fruit_vegetation", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(FarmingTreePlacements.PEAR_BEES_002, 0.2F), new WeightedPlacedFeature(FarmingTreePlacements.FANCY_PEAR_BEES_002, 0.1F)), FarmingTreePlacements.PEAR_BEES_002));
}
