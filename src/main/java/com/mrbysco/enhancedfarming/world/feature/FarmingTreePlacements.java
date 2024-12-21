package com.mrbysco.enhancedfarming.world.feature;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FarmingTreePlacements {

	public static final ResourceKey<PlacedFeature> APPLE_BEES_002 = createKey("apple_bees_02");
	public static final ResourceKey<PlacedFeature> FANCY_APPLE_BEES_002 = createKey("fancy_apple_bees_02");
	public static final ResourceKey<PlacedFeature> LEMON_BEES_002 = createKey("lemon_bees_02");
	public static final ResourceKey<PlacedFeature> FANCY_LEMON_BEES_002 = createKey("fancy_lemon_bees_02");
	public static final ResourceKey<PlacedFeature> ORANGE_BEES_002 = createKey("orange_bees_02");
	public static final ResourceKey<PlacedFeature> FANCY_ORANGE_BEES_002 = createKey("fancy_orange_bees_02");
	public static final ResourceKey<PlacedFeature> CHERRY_BEES_002 = createKey("cherry_bees_02");
	public static final ResourceKey<PlacedFeature> FANCY_CHERRY_BEES_002 = createKey("fancy_cherry_bees_02");
	public static final ResourceKey<PlacedFeature> PEAR_BEES_002 = createKey("pear_bees_02");
	public static final ResourceKey<PlacedFeature> FANCY_PEAR_BEES_002 = createKey("fancy_pear_bees_02");

	public static ResourceKey<PlacedFeature> createKey(String key) {
		return ResourceKey.create(Registries.PLACED_FEATURE, EnhancedFarming.modLoc(key));
	}

	public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

		PlacementUtils.register(context, APPLE_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.APPLE_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.APPLE_SAPLING.get()));
		PlacementUtils.register(context, FANCY_APPLE_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.FANCY_APPLE_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.APPLE_SAPLING.get()));
		PlacementUtils.register(context, LEMON_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.LEMON_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.LEMON_SAPLING.get()));
		PlacementUtils.register(context, FANCY_LEMON_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.FANCY_LEMON_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.LEMON_SAPLING.get()));
		PlacementUtils.register(context, ORANGE_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.ORANGE_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.ORANGE_SAPLING.get()));
		PlacementUtils.register(context, FANCY_ORANGE_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.FANCY_ORANGE_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.ORANGE_SAPLING.get()));
		PlacementUtils.register(context, CHERRY_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.CHERRY_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.CHERRY_SAPLING.get()));
		PlacementUtils.register(context, FANCY_CHERRY_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.FANCY_CHERRY_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.CHERRY_SAPLING.get()));
		PlacementUtils.register(context, PEAR_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.PEAR_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.PEAR_SAPLING.get()));
		PlacementUtils.register(context, FANCY_PEAR_BEES_002, holdergetter.getOrThrow(FarmingFeatureConfigs.FANCY_PEAR_BEES_002),
				PlacementUtils.filteredByBlockSurvival(FarmingRegistry.PEAR_SAPLING.get()));
	}
}
