package com.mrbysco.enhancedfarming.world.feature;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;
import java.util.function.Supplier;

public class FarmingVegetationPlacements {
	public static void initialize() {}

	public static final PlacedFeature APPLE = PlacementUtils.register(Reference.MOD_PREFIX + "apple", FarmingVegetation.APPLE_FRUIT_VEGETATION.placed(fruitTreePlacement(FarmingConfig.COMMON.appleTreeRarity::get, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.AVOCADO_SAPLING.get())));
	public static final PlacedFeature LEMON = PlacementUtils.register(Reference.MOD_PREFIX + "lemon", FarmingVegetation.LEMON_FRUIT_VEGETATION.placed(fruitTreePlacement(FarmingConfig.COMMON.lemonTreeRarity::get, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.AVOCADO_SAPLING.get())));
	public static final PlacedFeature ORANGE = PlacementUtils.register(Reference.MOD_PREFIX + "orange", FarmingVegetation.ORANGE_FRUIT_VEGETATION.placed(fruitTreePlacement(FarmingConfig.COMMON.orangeTreeRarity::get, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.AVOCADO_SAPLING.get())));
	public static final PlacedFeature CHERRY = PlacementUtils.register(Reference.MOD_PREFIX + "cherry", FarmingVegetation.CHERRY_FRUIT_VEGETATION.placed(fruitTreePlacement(FarmingConfig.COMMON.cherryTreeRarity::get, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.AVOCADO_SAPLING.get())));
	public static final PlacedFeature PEAR = PlacementUtils.register(Reference.MOD_PREFIX + "pear", FarmingVegetation.PEAR_FRUIT_VEGETATION.placed(fruitTreePlacement(FarmingConfig.COMMON.pearTreeRarity::get, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.AVOCADO_SAPLING.get())));
	public static final PlacedFeature AVOCADO = PlacementUtils.register(Reference.MOD_PREFIX + "avocado", FarmingFeatureConfigs.AVOCADO.placed(fruitTreePlacement(FarmingConfig.COMMON.avocadoTreeRarity::get, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.AVOCADO_SAPLING.get())));
	public static final PlacedFeature MANGO = PlacementUtils.register(Reference.MOD_PREFIX + "mango", FarmingFeatureConfigs.MANGO.placed(fruitTreePlacement(FarmingConfig.COMMON.mangoTreeRarity::get, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.MANGO_SAPLING.get())));
	public static final PlacedFeature BANANA = PlacementUtils.register(Reference.MOD_PREFIX + "banana", FarmingFeatureConfigs.BANANA.placed(fruitTreePlacement(FarmingConfig.COMMON.bananaTreeRarity::get, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.BANANA_SAPLING.get())));
	public static final PlacedFeature OLIVE = PlacementUtils.register(Reference.MOD_PREFIX + "olive", FarmingFeatureConfigs.OLIVE.placed(fruitTreePlacement(FarmingConfig.COMMON.oliveTreeRarity::get, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.OLIVE_SAPLING.get())));

	public static final PlacedFeature PATCH_NETHER_FLOWER = PlacementUtils.register("patch_nether_flower", FarmingFeatureConfigs.PATCH_NETHER_FLOWER.placed(NetherPlacements.FIRE_PLACEMENT));

	private static Builder<PlacementModifier> treePlacementBase(PlacementModifier modifier) {
		return ImmutableList.<PlacementModifier>builder().add(modifier).add(InSquarePlacement.spread()).add(VegetationPlacements.TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
	}

	public static List<PlacementModifier> fruitTreePlacement(Supplier<Integer> rarity, PlacementModifier modifier, Block block) {
		return treePlacementBase(modifier).add(RarityFilter.onAverageOnceEvery(rarity.get())).add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO))).add(RarityFilter.onAverageOnceEvery(2)).add(CountPlacement.of(1)).build();
	}
}
