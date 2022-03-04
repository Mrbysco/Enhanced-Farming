package com.mrbysco.enhancedfarming.world.feature;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FarmingTreePlacements {
	public static void initialize() {}

	public static final PlacedFeature APPLE_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "apple_bees_02", FarmingFeatureConfigs.APPLE_BEES_002.filteredByBlockSurvival(FarmingRegistry.APPLE_SAPLING.get()));
	public static final PlacedFeature FANCY_APPLE_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "fancy_apple_bees_02", FarmingFeatureConfigs.FANCY_APPLE_BEES_002.filteredByBlockSurvival(FarmingRegistry.APPLE_SAPLING.get()));
	public static final PlacedFeature LEMON_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "lemon_bees_02", FarmingFeatureConfigs.LEMON_BEES_002.filteredByBlockSurvival(FarmingRegistry.LEMON_SAPLING.get()));
	public static final PlacedFeature FANCY_LEMON_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "fancy_lemon_bees_02", FarmingFeatureConfigs.FANCY_LEMON_BEES_002.filteredByBlockSurvival(FarmingRegistry.LEMON_SAPLING.get()));
	public static final PlacedFeature ORANGE_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "orange_bees_02", FarmingFeatureConfigs.ORANGE_BEES_002.filteredByBlockSurvival(FarmingRegistry.ORANGE_SAPLING.get()));
	public static final PlacedFeature FANCY_ORANGE_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "fancy_orange_bees_02", FarmingFeatureConfigs.FANCY_ORANGE_BEES_002.filteredByBlockSurvival(FarmingRegistry.ORANGE_SAPLING.get()));
	public static final PlacedFeature CHERRY_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "cherry_bees_02", FarmingFeatureConfigs.CHERRY_BEES_002.filteredByBlockSurvival(FarmingRegistry.CHERRY_SAPLING.get()));
	public static final PlacedFeature FANCY_CHERRY_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "fancy_cherry_bees_02", FarmingFeatureConfigs.FANCY_CHERRY_BEES_002.filteredByBlockSurvival(FarmingRegistry.CHERRY_SAPLING.get()));
	public static final PlacedFeature PEAR_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "pear_bees_02", FarmingFeatureConfigs.PEAR_BEES_002.filteredByBlockSurvival(FarmingRegistry.PEAR_SAPLING.get()));
	public static final PlacedFeature FANCY_PEAR_BEES_002 = PlacementUtils.register(Reference.MOD_PREFIX + "fancy_pear_bees_02", FarmingFeatureConfigs.FANCY_PEAR_BEES_002.filteredByBlockSurvival(FarmingRegistry.PEAR_SAPLING.get()));

}
