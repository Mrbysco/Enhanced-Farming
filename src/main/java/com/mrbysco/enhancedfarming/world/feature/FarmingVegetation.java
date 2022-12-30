package com.mrbysco.enhancedfarming.world.feature;

import com.mrbysco.enhancedfarming.Reference;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class FarmingVegetation {

	public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_FRUIT_VEGETATION = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "apple_fruit_vegetation").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_FRUIT_VEGETATION = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "lemon_fruit_vegetation").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_FRUIT_VEGETATION = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "orange_fruit_vegetation").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_FRUIT_VEGETATION = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "cherry_fruit_vegetation").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_FRUIT_VEGETATION = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "pear_fruit_vegetation").toString());

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
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
