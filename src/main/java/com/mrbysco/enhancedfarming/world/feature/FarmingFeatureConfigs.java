package com.mrbysco.enhancedfarming.world.feature;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import java.util.OptionalInt;

public class FarmingFeatureConfigs {
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> APPLE = register("apple", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.APPLE_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> APPLE_BEES_0002 = register("apple_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(APPLE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> APPLE_BEES_002 = register("apple_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(APPLE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> APPLE_BEES_005 = register("apple_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(APPLE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_APPLE = register("fancy_apple", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.APPLE_LEAVES), new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_APPLE_BEES_0002 = register("fancy_apple_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_APPLE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_APPLE_BEES_002 = register("fancy_apple_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_APPLE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_APPLE_BEES_005 = register("fancy_apple_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_APPLE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON = register("lemon", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.LEMON_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON_BEES_0002 = register("lemon_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(LEMON.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON_BEES_002 = register("lemon_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(LEMON.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LEMON_BEES_005 = register("lemon_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(LEMON.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_LEMON = register("fancy_lemon", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.LEMON_LEAVES), new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_LEMON_BEES_0002 = register("fancy_lemon_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_LEMON.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_LEMON_BEES_002 = register("fancy_lemon_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_LEMON.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_LEMON_BEES_005 = register("fancy_lemon_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_LEMON.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE = register("orange", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.ORANGE_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_BEES_0002 = register("orange_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(ORANGE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_BEES_002 = register("orange_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(ORANGE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORANGE_BEES_005 = register("orange_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(ORANGE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ORANGE = register("fancy_orange", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.ORANGE_LEAVES), new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ORANGE_BEES_0002 = register("fancy_orange_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_ORANGE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ORANGE_BEES_002 = register("fancy_orange_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_ORANGE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_ORANGE_BEES_005 = register("fancy_orange_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_ORANGE.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY = register("cherry", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.CHERRY_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_BEES_0002 = register("cherry_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(CHERRY.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_BEES_002 = register("cherry_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(CHERRY.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CHERRY_BEES_005 = register("cherry_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(CHERRY.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_CHERRY = register("fancy_cherry", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.CHERRY_LEAVES), new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_CHERRY_BEES_0002 = register("fancy_cherry_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_CHERRY.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_CHERRY_BEES_002 = register("fancy_cherry_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_CHERRY.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_CHERRY_BEES_005 = register("fancy_cherry_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_CHERRY.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEAR = register("pear", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.PEAR_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEAR_BEES_0002 = register("pear_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(PEAR.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEAR_BEES_002 = register("pear_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(PEAR.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> PEAR_BEES_005 = register("pear_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(PEAR.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_PEAR = register("fancy_pear", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.PEAR_LEAVES), new FancyFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(4), 4), new FancyTrunkPlacer(3, 11, 0), new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))).ignoreVines().heightmap(Heightmap.Type.MOTION_BLOCKING).build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_PEAR_BEES_0002 = register("fancy_pear_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_PEAR.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_0002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_PEAR_BEES_002 = register("fancy_pear_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_PEAR.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_002))));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> FANCY_PEAR_BEES_005 = register("fancy_pear_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_PEAR.config().withDecorators(ImmutableList.of(Features.Placements.BEEHIVE_005))));

	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> BANANA = register("banana", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.JUNGLE_LOG), new SimpleBlockStateProvider(States.BANANA_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 8, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> AVOCADO = register("avocado", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.AVOCADO_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MANGO = register("mango", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.OAK_LOG), new SimpleBlockStateProvider(States.MANGO_LEAVES), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OLIVE = register("olive", FarmingFeatures.FRUIT_TREE.get().configured((new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(States.ACACIA_LOG), new SimpleBlockStateProvider(States.OLIVE_LEAVES), new AcaciaFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0)), new ForkyTrunkPlacer(5, 2, 2), new TwoLayerFeature(1, 0, 2))).ignoreVines().build()));

	public static final ConfiguredFeature<?, ?> APPLE_FRUIT_VEGETATION = register("apple_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(APPLE_BEES_002.weighted(0.2F), FANCY_APPLE_BEES_002.weighted(0.1F)), APPLE_BEES_002)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> LEMON_FRUIT_VEGETATION = register("lemon_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(LEMON_BEES_002.weighted(0.2F), FANCY_LEMON_BEES_002.weighted(0.1F)), LEMON_BEES_002)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> ORANGE_FRUIT_VEGETATION = register("orange_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(ORANGE_BEES_002.weighted(0.2F), FANCY_ORANGE_BEES_002.weighted(0.1F)), ORANGE_BEES_002)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> CHERRY_FRUIT_VEGETATION = register("cherry_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(CHERRY_BEES_002.weighted(0.2F), FANCY_CHERRY_BEES_002.weighted(0.1F)), CHERRY_BEES_002)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> PEAR_FRUIT_VEGETATION = register("pear_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new MultipleRandomFeatureConfig(ImmutableList.of(PEAR_BEES_002.weighted(0.2F), FANCY_PEAR_BEES_002.weighted(0.1F)), PEAR_BEES_002)).decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> AVOCADO_FRUIT_VEGETATION = register("avocado_fruit_vegetation", AVOCADO.decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> MANGO_FRUIT_VEGETATION = register("mango_fruit_vegetation", MANGO.decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> BANANA_FRUIT_VEGETATION = register("banana_fruit_vegetation", BANANA.decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> OLIVE_FRUIT_VEGETATION = register("olive_fruit_vegetation", OLIVE.decorated(Features.Placements.HEIGHTMAP_SQUARE).decorated(Placement.COUNT_EXTRA.configured(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

	public static final ConfiguredFeature<?, ?> PATCH_NETHER_FLOWER = register("patch_nether_flower", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(States.NETHER_FLOWER_CROP), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(States.SOUL_SAND.getBlock())).noProjection().build()).decorated(Features.Placements.FIRE));


	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> feature) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(Reference.MOD_ID, key), feature);
	}

	public static final class States {
		protected static final BlockState ACACIA_LOG = Blocks.ACACIA_LOG.defaultBlockState();
		protected static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.defaultBlockState();
		protected static final BlockState OAK_LOG = Blocks.OAK_LOG.defaultBlockState();

		protected static final BlockState APPLE_LEAVES = FarmingRegistry.APPLE_LEAVES.get().defaultBlockState();
		protected static final BlockState LEMON_LEAVES = FarmingRegistry.LEMON_LEAVES.get().defaultBlockState();
		protected static final BlockState ORANGE_LEAVES = FarmingRegistry.ORANGE_LEAVES.get().defaultBlockState();
		protected static final BlockState CHERRY_LEAVES = FarmingRegistry.CHERRY_LEAVES.get().defaultBlockState();
		protected static final BlockState PEAR_LEAVES = FarmingRegistry.PEAR_LEAVES.get().defaultBlockState();
		protected static final BlockState BANANA_LEAVES = FarmingRegistry.BANANA_LEAVES.get().defaultBlockState();
		protected static final BlockState AVOCADO_LEAVES = FarmingRegistry.AVOCADO_LEAVES.get().defaultBlockState();
		protected static final BlockState MANGO_LEAVES = FarmingRegistry.MANGO_LEAVES.get().defaultBlockState();
		protected static final BlockState OLIVE_LEAVES = FarmingRegistry.OLIVE_LEAVES.get().defaultBlockState();

		protected static final BlockState SOUL_SAND = Blocks.SOUL_SAND.defaultBlockState();
		protected static final BlockState NETHER_FLOWER_CROP = FarmingRegistry.NETHER_FLOWER_CROP.get().defaultBlockState().setValue(NetherFlowerBlock.AGE, Integer.valueOf(5));
	}
}
