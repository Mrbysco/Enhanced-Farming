package com.mrbysco.enhancedfarming.world.feature;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class FarmingVegetation {

	public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_FRUIT_VEGETATION = createKey("apple_fruit_vegetation");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_FRUIT_VEGETATION = createKey("lemon_fruit_vegetation");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_FRUIT_VEGETATION = createKey("orange_fruit_vegetation");
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_FRUIT_VEGETATION = createKey("cherry_fruit_vegetation");
	public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_FRUIT_VEGETATION = createKey("pear_fruit_vegetation");

	public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, EnhancedFarming.modLoc(name));
	}

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		HolderGetter<PlacedFeature> placedHolderGetter = context.lookup(Registries.PLACED_FEATURE);
		FeatureUtils.register(context, APPLE_FRUIT_VEGETATION, Feature.RANDOM_SELECTOR,
				new RandomFeatureConfiguration(List.of(
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.APPLE_BEES_002), 0.2F),
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.FANCY_APPLE_BEES_002), 0.1F)),
						placedHolderGetter.getOrThrow(FarmingTreePlacements.APPLE_BEES_002)));
		FeatureUtils.register(context, LEMON_FRUIT_VEGETATION, Feature.RANDOM_SELECTOR,
				new RandomFeatureConfiguration(List.of(
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.LEMON_BEES_002), 0.2F),
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.FANCY_LEMON_BEES_002), 0.1F)),
						placedHolderGetter.getOrThrow(FarmingTreePlacements.LEMON_BEES_002)));
		FeatureUtils.register(context, ORANGE_FRUIT_VEGETATION, Feature.RANDOM_SELECTOR,
				new RandomFeatureConfiguration(List.of(
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.ORANGE_BEES_002), 0.2F),
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.FANCY_ORANGE_BEES_002), 0.1F)),
						placedHolderGetter.getOrThrow(FarmingTreePlacements.ORANGE_BEES_002)));
		FeatureUtils.register(context, CHERRY_FRUIT_VEGETATION, Feature.RANDOM_SELECTOR,
				new RandomFeatureConfiguration(List.of(
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.CHERRY_BEES_002), 0.2F),
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.FANCY_CHERRY_BEES_002), 0.1F)),
						placedHolderGetter.getOrThrow(FarmingTreePlacements.CHERRY_BEES_002)));
		FeatureUtils.register(context, PEAR_FRUIT_VEGETATION, Feature.RANDOM_SELECTOR,
				new RandomFeatureConfiguration(List.of(
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.PEAR_BEES_002), 0.2F),
						new WeightedPlacedFeature(placedHolderGetter.getOrThrow(FarmingTreePlacements.FANCY_PEAR_BEES_002), 0.1F)),
						placedHolderGetter.getOrThrow(FarmingTreePlacements.PEAR_BEES_002)));
	}
}
