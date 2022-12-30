package com.mrbysco.enhancedfarming.world.feature;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class FarmingFeatureConfigs {

	public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "apple").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "apple_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "apple_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "apple_bees_005").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_APPLE = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_apple").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_APPLE_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_apple_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_APPLE_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_apple_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_APPLE_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_apple_bees_005").toString());

	public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "lemon").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "lemon_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "lemon_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> LEMON_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "lemon_bees_005").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_LEMON = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_lemon").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_LEMON_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_lemon_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_LEMON_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_lemon_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_LEMON_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_lemon_bees_005").toString());

	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "orange").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "orange_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "orange_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "orange_bees_005").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ORANGE = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_orange").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ORANGE_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_orange_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ORANGE_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_orange_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_ORANGE_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_orange_bees_005").toString());

	public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "cherry").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "cherry_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "cherry_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "cherry_bees_005").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_CHERRY = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_cherry").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_CHERRY_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_cherry_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_CHERRY_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_cherry_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_CHERRY_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_cherry_bees_005").toString());

	public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "pear").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "pear_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "pear_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "pear_bees_005").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_PEAR = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_pear").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_PEAR_BEES_0002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_pear_bees_0002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_PEAR_BEES_002 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_pear_bees_002").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> FANCY_PEAR_BEES_005 = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "fancy_pear_bees_005").toString());

	public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "banana").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> AVOCADO = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "avocado").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "mango").toString());
	public static final ResourceKey<ConfiguredFeature<?, ?>> OLIVE = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "olive").toString());

	public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_NETHER_FLOWER = FeatureUtils.createKey(new ResourceLocation(Reference.MOD_ID, "patch_nether_flower").toString());


	private static TreeConfiguration.TreeConfigurationBuilder getApple() {
		return (new TreeConfiguration.TreeConfigurationBuilder(
				SimpleStateProvider.simple(States.OAK_LOG), new StraightTrunkPlacer(4, 2, 0),
				SimpleStateProvider.simple(States.APPLE_LEAVES),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getFancyApple() {
		return (new TreeConfiguration.TreeConfigurationBuilder(
				SimpleStateProvider.simple(States.OAK_LOG), new FancyTrunkPlacer(3, 11, 0),
				SimpleStateProvider.simple(States.APPLE_LEAVES),
				new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getLemon() {
		return (new TreeConfiguration.TreeConfigurationBuilder(
				SimpleStateProvider.simple(States.OAK_LOG), new StraightTrunkPlacer(4, 2, 0),
				SimpleStateProvider.simple(States.LEMON_LEAVES),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getFancyLemon() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.OAK_LOG),
				new FancyTrunkPlacer(3, 11, 0), SimpleStateProvider.simple(States.LEMON_LEAVES),
				new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getOrange() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.OAK_LOG),
				new StraightTrunkPlacer(4, 2, 0), SimpleStateProvider.simple(States.ORANGE_LEAVES),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getFancyOrange() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.OAK_LOG),
				new FancyTrunkPlacer(3, 11, 0), SimpleStateProvider.simple(States.ORANGE_LEAVES),
				new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getCherry() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.OAK_LOG),
				new StraightTrunkPlacer(4, 2, 0), SimpleStateProvider.simple(States.CHERRY_LEAVES),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getFancyCherry() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.OAK_LOG),
				new FancyTrunkPlacer(3, 11, 0), SimpleStateProvider.simple(States.CHERRY_LEAVES),
				new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getPear() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.OAK_LOG),
				new StraightTrunkPlacer(4, 2, 0), SimpleStateProvider.simple(States.PEAR_LEAVES),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getFancyPear() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.OAK_LOG),
				new FancyTrunkPlacer(3, 11, 0), SimpleStateProvider.simple(States.PEAR_LEAVES),
				new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
				new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getBanana() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.JUNGLE_LOG),
				new StraightTrunkPlacer(4, 8, 0), SimpleStateProvider.simple(States.BANANA_LEAVES),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getAvocado() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.OAK_LOG),
				new StraightTrunkPlacer(4, 2, 0), SimpleStateProvider.simple(States.AVOCADO_LEAVES),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getMango() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.OAK_LOG),
				new StraightTrunkPlacer(4, 2, 0), SimpleStateProvider.simple(States.MANGO_LEAVES),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1))).ignoreVines();
	}

	private static TreeConfiguration.TreeConfigurationBuilder getOlive() {
		return (new TreeConfiguration.TreeConfigurationBuilder(SimpleStateProvider.simple(States.ACACIA_LOG),
				new ForkingTrunkPlacer(5, 2, 2), SimpleStateProvider.simple(States.OLIVE_LEAVES),
				new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
				new TwoLayersFeatureSize(1, 0, 2))).ignoreVines();
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

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
		BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F);
		BeehiveDecorator BEEHIVE_002 = new BeehiveDecorator(0.02F);
		BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F);

		FeatureUtils.register(context, APPLE, FarmingFeatures.FRUIT_TREE.get(), getApple().build());
		FeatureUtils.register(context, APPLE_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getApple().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, APPLE_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getApple().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, APPLE_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getApple().decorators(List.of(BEEHIVE_005)).build());
		FeatureUtils.register(context, FANCY_APPLE, FarmingFeatures.FRUIT_TREE.get(), getFancyApple().build());
		FeatureUtils.register(context, FANCY_APPLE_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getFancyApple().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, FANCY_APPLE_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getFancyApple().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, FANCY_APPLE_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getFancyApple().decorators(List.of(BEEHIVE_005)).build());

		FeatureUtils.register(context, LEMON, FarmingFeatures.FRUIT_TREE.get(), getLemon().build());
		FeatureUtils.register(context, LEMON_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getLemon().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, LEMON_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getLemon().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, LEMON_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getLemon().decorators(List.of(BEEHIVE_005)).build());
		FeatureUtils.register(context, FANCY_LEMON, FarmingFeatures.FRUIT_TREE.get(), getFancyLemon().build());
		FeatureUtils.register(context, FANCY_LEMON_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getFancyLemon().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, FANCY_LEMON_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getFancyLemon().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, FANCY_LEMON_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getFancyLemon().decorators(List.of(BEEHIVE_005)).build());

		FeatureUtils.register(context, ORANGE, FarmingFeatures.FRUIT_TREE.get(), getOrange().build());
		FeatureUtils.register(context, ORANGE_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getOrange().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, ORANGE_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getOrange().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, ORANGE_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getOrange().decorators(List.of(BEEHIVE_005)).build());
		FeatureUtils.register(context, FANCY_ORANGE, FarmingFeatures.FRUIT_TREE.get(), getFancyOrange().build());
		FeatureUtils.register(context, FANCY_ORANGE_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getFancyOrange().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, FANCY_ORANGE_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getFancyOrange().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, FANCY_ORANGE_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getFancyOrange().decorators(List.of(BEEHIVE_005)).build());

		FeatureUtils.register(context, CHERRY, FarmingFeatures.FRUIT_TREE.get(), getCherry().build());
		FeatureUtils.register(context, CHERRY_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getCherry().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, CHERRY_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getCherry().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, CHERRY_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getCherry().decorators(List.of(BEEHIVE_005)).build());
		FeatureUtils.register(context, FANCY_CHERRY, FarmingFeatures.FRUIT_TREE.get(), getFancyCherry().build());
		FeatureUtils.register(context, FANCY_CHERRY_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getFancyCherry().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, FANCY_CHERRY_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getFancyCherry().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, FANCY_CHERRY_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getFancyCherry().decorators(List.of(BEEHIVE_005)).build());

		FeatureUtils.register(context, PEAR, FarmingFeatures.FRUIT_TREE.get(), getPear().build());
		FeatureUtils.register(context, PEAR_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getPear().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, PEAR_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getPear().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, PEAR_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getPear().decorators(List.of(BEEHIVE_005)).build());
		FeatureUtils.register(context, FANCY_PEAR, FarmingFeatures.FRUIT_TREE.get(), getFancyPear().build());
		FeatureUtils.register(context, FANCY_PEAR_BEES_0002, FarmingFeatures.FRUIT_TREE.get(), getFancyPear().decorators(List.of(BEEHIVE_0002)).build());
		FeatureUtils.register(context, FANCY_PEAR_BEES_002, FarmingFeatures.FRUIT_TREE.get(), getFancyPear().decorators(List.of(BEEHIVE_002)).build());
		FeatureUtils.register(context, FANCY_PEAR_BEES_005, FarmingFeatures.FRUIT_TREE.get(), getFancyPear().decorators(List.of(BEEHIVE_005)).build());

		FeatureUtils.register(context, BANANA, FarmingFeatures.FRUIT_TREE.get(), getBanana().build());
		FeatureUtils.register(context, AVOCADO, FarmingFeatures.FRUIT_TREE.get(), getAvocado().build());
		FeatureUtils.register(context, MANGO, FarmingFeatures.FRUIT_TREE.get(), getMango().build());
		FeatureUtils.register(context, OLIVE, FarmingFeatures.FRUIT_TREE.get(), getOlive().build());

		FeatureUtils.register(context, PATCH_NETHER_FLOWER, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
				new SimpleBlockConfiguration(BlockStateProvider.simple(States.NETHER_FLOWER_CROP)),
				List.of(Blocks.SOUL_SAND), 64));

	}
}
