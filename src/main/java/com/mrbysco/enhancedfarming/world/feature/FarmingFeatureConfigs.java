package com.mrbysco.enhancedfarming.world.feature;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;

import java.util.OptionalInt;

public class FarmingFeatureConfigs {
	public static final ConfiguredFeature<TreeConfiguration, ?> APPLE = register("apple", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), new SimpleStateProvider(States.APPLE_LEAVES), new SimpleStateProvider(States.APPLE_SAPLING), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> APPLE_BEES_0002 = register("apple_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(APPLE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> APPLE_BEES_002 = register("apple_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(APPLE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> APPLE_BEES_005 = register("apple_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(APPLE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_APPLE = register("fancy_apple", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new FancyTrunkPlacer(3, 11, 0), new SimpleStateProvider(States.APPLE_LEAVES), new SimpleStateProvider(States.APPLE_SAPLING), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_APPLE_BEES_0002 = register("fancy_apple_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_APPLE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_APPLE_BEES_002 = register("fancy_apple_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_APPLE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_APPLE_BEES_005 = register("fancy_apple_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_APPLE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));

	public static final ConfiguredFeature<TreeConfiguration, ?> LEMON = register("lemon", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), new SimpleStateProvider(States.LEMON_LEAVES), new SimpleStateProvider(States.LEMON_SAPLING), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> LEMON_BEES_0002 = register("lemon_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(LEMON.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> LEMON_BEES_002 = register("lemon_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(LEMON.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> LEMON_BEES_005 = register("lemon_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(LEMON.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_LEMON = register("fancy_lemon", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new FancyTrunkPlacer(3, 11, 0), new SimpleStateProvider(States.LEMON_LEAVES), new SimpleStateProvider(States.LEMON_SAPLING), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_LEMON_BEES_0002 = register("fancy_lemon_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_LEMON.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_LEMON_BEES_002 = register("fancy_lemon_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_LEMON.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_LEMON_BEES_005 = register("fancy_lemon_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_LEMON.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));

	public static final ConfiguredFeature<TreeConfiguration, ?> ORANGE = register("orange", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), new SimpleStateProvider(States.ORANGE_LEAVES), new SimpleStateProvider(States.ORANGE_SAPLING), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> ORANGE_BEES_0002 = register("orange_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(ORANGE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> ORANGE_BEES_002 = register("orange_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(ORANGE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> ORANGE_BEES_005 = register("orange_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(ORANGE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_ORANGE = register("fancy_orange", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new FancyTrunkPlacer(3, 11, 0), new SimpleStateProvider(States.ORANGE_LEAVES), new SimpleStateProvider(States.ORANGE_SAPLING), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_ORANGE_BEES_0002 = register("fancy_orange_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_ORANGE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_ORANGE_BEES_002 = register("fancy_orange_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_ORANGE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_ORANGE_BEES_005 = register("fancy_orange_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_ORANGE.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));

	public static final ConfiguredFeature<TreeConfiguration, ?> CHERRY = register("cherry", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), new SimpleStateProvider(States.CHERRY_LEAVES), new SimpleStateProvider(States.CHERRY_SAPLING), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> CHERRY_BEES_0002 = register("cherry_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(CHERRY.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> CHERRY_BEES_002 = register("cherry_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(CHERRY.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> CHERRY_BEES_005 = register("cherry_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(CHERRY.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_CHERRY = register("fancy_cherry", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new FancyTrunkPlacer(3, 11, 0), new SimpleStateProvider(States.CHERRY_LEAVES), new SimpleStateProvider(States.CHERRY_SAPLING), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_CHERRY_BEES_0002 = register("fancy_cherry_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_CHERRY.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_CHERRY_BEES_002 = register("fancy_cherry_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_CHERRY.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_CHERRY_BEES_005 = register("fancy_cherry_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_CHERRY.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));

	public static final ConfiguredFeature<TreeConfiguration, ?> PEAR = register("pear", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), new SimpleStateProvider(States.PEAR_LEAVES), new SimpleStateProvider(States.PEAR_SAPLING), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> PEAR_BEES_0002 = register("pear_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(PEAR.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> PEAR_BEES_002 = register("pear_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(PEAR.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> PEAR_BEES_005 = register("pear_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(PEAR.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_PEAR = register("fancy_pear", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new FancyTrunkPlacer(3, 11, 0), new SimpleStateProvider(States.PEAR_LEAVES), new SimpleStateProvider(States.PEAR_SAPLING), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_PEAR_BEES_0002 = register("fancy_pear_bees_0002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_PEAR.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_0002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_PEAR_BEES_002 = register("fancy_pear_bees_002", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_PEAR.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_002))));
	public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_PEAR_BEES_005 = register("fancy_pear_bees_005", FarmingFeatures.FRUIT_TREE.get().configured(FANCY_PEAR.config().withDecorators(ImmutableList.of(Features.Decorators.BEEHIVE_005))));

	public static final ConfiguredFeature<TreeConfiguration, ?> BANANA = register("banana", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.JUNGLE_LOG), new StraightTrunkPlacer(4, 8, 0), new SimpleStateProvider(States.BANANA_LEAVES), new SimpleStateProvider(States.BANANA_SAPLING), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> AVOCADO = register("avocado", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), new SimpleStateProvider(States.AVOCADO_LEAVES), new SimpleStateProvider(States.AVOCADO_SAPLING), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> MANGO = register("mango", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), new SimpleStateProvider(States.MANGO_LEAVES), new SimpleStateProvider(States.MANGO_SAPLING), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
	public static final ConfiguredFeature<TreeConfiguration, ?> OLIVE = register("olive", FarmingFeatures.FRUIT_TREE.get().configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(States.ACACIA_LOG), new ForkingTrunkPlacer(5, 2, 2), new SimpleStateProvider(States.OLIVE_LEAVES), new SimpleStateProvider(States.OLIVE_SAPLING), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build()));

	public static final ConfiguredFeature<?, ?> APPLE_FRUIT_VEGETATION = register("apple_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(APPLE_BEES_002.weighted(0.2F), FANCY_APPLE_BEES_002.weighted(0.1F)), APPLE_BEES_002)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> LEMON_FRUIT_VEGETATION = register("lemon_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(LEMON_BEES_002.weighted(0.2F), FANCY_LEMON_BEES_002.weighted(0.1F)), LEMON_BEES_002)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> ORANGE_FRUIT_VEGETATION = register("orange_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(ORANGE_BEES_002.weighted(0.2F), FANCY_ORANGE_BEES_002.weighted(0.1F)), ORANGE_BEES_002)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> CHERRY_FRUIT_VEGETATION = register("cherry_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(CHERRY_BEES_002.weighted(0.2F), FANCY_CHERRY_BEES_002.weighted(0.1F)), CHERRY_BEES_002)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> PEAR_FRUIT_VEGETATION = register("pear_fruit_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(PEAR_BEES_002.weighted(0.2F), FANCY_PEAR_BEES_002.weighted(0.1F)), PEAR_BEES_002)).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> AVOCADO_FRUIT_VEGETATION = register("avocado_fruit_vegetation", AVOCADO.decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> MANGO_FRUIT_VEGETATION = register("mango_fruit_vegetation", MANGO.decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> BANANA_FRUIT_VEGETATION = register("banana_fruit_vegetation", BANANA.decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));
	public static final ConfiguredFeature<?, ?> OLIVE_FRUIT_VEGETATION = register("olive_fruit_vegetation", OLIVE.decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(1, 0.1F, 1))));

	public static final ConfiguredFeature<?, ?> PATCH_NETHER_FLOWER = register("patch_nether_flower", Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(States.NETHER_FLOWER_CROP), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(States.SOUL_SAND.getBlock())).noProjection().build()).decorated(Features.Decorators.FIRE));

	private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> feature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Reference.MOD_ID, key), feature);
	}

	public static final class States {
		protected static final BlockState ACACIA_LOG = Blocks.ACACIA_LOG.defaultBlockState();
		protected static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.defaultBlockState();
		protected static final BlockState OAK_LOG = Blocks.OAK_LOG.defaultBlockState();

		protected static final BlockState APPLE_SAPLING = FarmingRegistry.APPLE_SAPLING.get().defaultBlockState();
		protected static final BlockState LEMON_SAPLING = FarmingRegistry.LEMON_SAPLING.get().defaultBlockState();
		protected static final BlockState ORANGE_SAPLING = FarmingRegistry.ORANGE_SAPLING.get().defaultBlockState();
		protected static final BlockState CHERRY_SAPLING = FarmingRegistry.CHERRY_SAPLING.get().defaultBlockState();
		protected static final BlockState PEAR_SAPLING = FarmingRegistry.PEAR_SAPLING.get().defaultBlockState();
		protected static final BlockState BANANA_SAPLING = FarmingRegistry.BANANA_SAPLING.get().defaultBlockState();
		protected static final BlockState AVOCADO_SAPLING = FarmingRegistry.AVOCADO_SAPLING.get().defaultBlockState();
		protected static final BlockState MANGO_SAPLING = FarmingRegistry.MANGO_SAPLING.get().defaultBlockState();
		protected static final BlockState OLIVE_SAPLING = FarmingRegistry.OLIVE_SAPLING.get().defaultBlockState();

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
