package com.mrbysco.enhancedfarming.datagen.data;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.world.feature.FarmingFeatureConfigs;
import com.mrbysco.enhancedfarming.world.feature.FarmingVegetation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;

import java.util.List;
import java.util.Map;

public class FarmingBiomeModifierProvider {
	private static final ResourceLocation ADD_NETHER_FLOWER = new ResourceLocation(Reference.MOD_ID, "add_nether_flower_patch");
	private static final ResourceLocation ADD_OLIVE_TREE = new ResourceLocation(Reference.MOD_ID, "add_olive_tree");
	private static final ResourceLocation ADD_BANANA_TREE = new ResourceLocation(Reference.MOD_ID, "add_banana_tree");
	private static final ResourceLocation ADD_APPLE_TREE = new ResourceLocation(Reference.MOD_ID, "add_apple_tree");
	private static final ResourceLocation ADD_LEMON_TREE = new ResourceLocation(Reference.MOD_ID, "add_lemon_tree");
	private static final ResourceLocation ADD_ORANGE_TREE = new ResourceLocation(Reference.MOD_ID, "add_orange_tree");
	private static final ResourceLocation ADD_CHERRY_TREE = new ResourceLocation(Reference.MOD_ID, "add_cherry_tree");
	private static final ResourceLocation ADD_PEAR_TREE = new ResourceLocation(Reference.MOD_ID, "add_pear_tree");
	private static final ResourceLocation ADD_AVOCADO_TREE = new ResourceLocation(Reference.MOD_ID, "add_avocado_tree");
	private static final ResourceLocation ADD_MANGO_TREE = new ResourceLocation(Reference.MOD_ID, "add_mango_tree");

	public static Map<ResourceLocation, PlacedFeature> getConfiguredFeatures(RegistryOps<JsonElement> ops) {
		final ResourceKey<ConfiguredFeature<?, ?>> appleTreeFeatureKey = FarmingVegetation.APPLE_FRUIT_VEGETATION.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> appleTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(appleTreeFeatureKey);
		final PlacedFeature appleTreeFeature = new PlacedFeature(
				appleTreeFeatureHolder,
				fruitTreePlacement(4, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.APPLE_SAPLING.get()));

		final ResourceKey<ConfiguredFeature<?, ?>> lemonTreeFeatureKey = FarmingVegetation.LEMON_FRUIT_VEGETATION.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> lemonTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(lemonTreeFeatureKey);
		final PlacedFeature lemonTreeFeature = new PlacedFeature(
				lemonTreeFeatureHolder,
				fruitTreePlacement(4, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.LEMON_SAPLING.get()));

		final ResourceKey<ConfiguredFeature<?, ?>> orangeTreeFeatureKey = FarmingVegetation.ORANGE_FRUIT_VEGETATION.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> orangeTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(orangeTreeFeatureKey);
		final PlacedFeature orangeTreeFeature = new PlacedFeature(
				orangeTreeFeatureHolder,
				fruitTreePlacement(4, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.ORANGE_SAPLING.get()));

		final ResourceKey<ConfiguredFeature<?, ?>> cherryTreeFeatureKey = FarmingVegetation.CHERRY_FRUIT_VEGETATION.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> cherryTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(cherryTreeFeatureKey);
		final PlacedFeature cherryTreeFeature = new PlacedFeature(
				cherryTreeFeatureHolder,
				fruitTreePlacement(4, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.CHERRY_SAPLING.get()));

		final ResourceKey<ConfiguredFeature<?, ?>> pearTreeFeatureKey = FarmingVegetation.PEAR_FRUIT_VEGETATION.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> pearTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(pearTreeFeatureKey);
		final PlacedFeature pearTreeFeature = new PlacedFeature(
				pearTreeFeatureHolder,
				fruitTreePlacement(4, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.PEAR_SAPLING.get()));

		final ResourceKey<ConfiguredFeature<?, ?>> avocadoTreeFeatureKey = FarmingFeatureConfigs.AVOCADO.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> avocadoTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(avocadoTreeFeatureKey);
		final PlacedFeature avocadoTreeFeature = new PlacedFeature(
				avocadoTreeFeatureHolder,
				fruitTreePlacement(4, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.AVOCADO_SAPLING.get()));

		final ResourceKey<ConfiguredFeature<?, ?>> mangoTreeFeatureKey = FarmingFeatureConfigs.MANGO.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> mangoTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(mangoTreeFeatureKey);
		final PlacedFeature mangoTreeFeature = new PlacedFeature(
				mangoTreeFeatureHolder,
				fruitTreePlacement(4, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.MANGO_SAPLING.get()));

		final ResourceKey<ConfiguredFeature<?, ?>> bananaTreeFeatureKey = FarmingFeatureConfigs.BANANA.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> bananaTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(bananaTreeFeatureKey);
		final PlacedFeature bananaTreeFeature = new PlacedFeature(
				bananaTreeFeatureHolder,
				fruitTreePlacement(4, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.BANANA_SAPLING.get()));

		final ResourceKey<ConfiguredFeature<?, ?>> oliveTreeFeatureKey = FarmingFeatureConfigs.OLIVE.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> oliveTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(oliveTreeFeatureKey);
		final PlacedFeature oliveTreeFeature = new PlacedFeature(
				oliveTreeFeatureHolder,
				fruitTreePlacement(4, PlacementUtils.countExtra(6, 0.1F, 1), FarmingRegistry.OLIVE_SAPLING.get()));

		final ResourceKey<ConfiguredFeature<?, ?>> netherFlowerTreeFeatureKey = FarmingFeatureConfigs.PATCH_NETHER_FLOWER.unwrapKey().get().cast(Registry.CONFIGURED_FEATURE_REGISTRY).get();
		final Holder<ConfiguredFeature<?, ?>> netherFlowerTreeFeatureHolder = ops.registry(Registry.CONFIGURED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(netherFlowerTreeFeatureKey);
		final PlacedFeature netherFlowerTreeFeature = new PlacedFeature(
				netherFlowerTreeFeatureHolder,
				NetherPlacements.FIRE_PLACEMENT);


		return Map.of(
				new ResourceLocation(Reference.MOD_ID, "patch_nether_flower"), netherFlowerTreeFeature,
				new ResourceLocation(Reference.MOD_ID, "apple"), appleTreeFeature,
				new ResourceLocation(Reference.MOD_ID, "lemon"), lemonTreeFeature,
				new ResourceLocation(Reference.MOD_ID, "orange"), orangeTreeFeature,
				new ResourceLocation(Reference.MOD_ID, "cherry"), cherryTreeFeature,
				new ResourceLocation(Reference.MOD_ID, "pear"), pearTreeFeature,
				new ResourceLocation(Reference.MOD_ID, "avocado"), avocadoTreeFeature,
				new ResourceLocation(Reference.MOD_ID, "mango"), mangoTreeFeature,
				new ResourceLocation(Reference.MOD_ID, "banana"), bananaTreeFeature,
				new ResourceLocation(Reference.MOD_ID, "olive"), oliveTreeFeature
		);
	}

	private static ImmutableList.Builder<PlacementModifier> treePlacementBase(PlacementModifier modifier) {
		return ImmutableList.<PlacementModifier>builder().add(modifier).add(InSquarePlacement.spread()).add(VegetationPlacements.TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR).add(BiomeFilter.biome());
	}

	private static List<PlacementModifier> fruitTreePlacement(int rarity, PlacementModifier modifier, Block block) {
		return treePlacementBase(modifier).add(RarityFilter.onAverageOnceEvery(rarity))
				.add(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO))).add(CountPlacement.of(1)).build();
	}

	public static Map<ResourceLocation, BiomeModifier> getBiomeModifiers(RegistryOps<JsonElement> ops) {
		final HolderSet.Named<Biome> badlandsTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_NETHER);
		final BiomeModifier addNetherFlowerPatch = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				badlandsTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "patch_nether_flower")))),
				GenerationStep.Decoration.UNDERGROUND_DECORATION);

		final HolderSet.Named<Biome> savannaTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_SAVANNA);
		final BiomeModifier addOliveTree = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				savannaTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "olive")))),
				GenerationStep.Decoration.VEGETAL_DECORATION);

		final HolderSet.Named<Biome> jungleTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_JUNGLE);
		final BiomeModifier addBananaTree = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				jungleTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "banana")))),
				GenerationStep.Decoration.VEGETAL_DECORATION);
		final HolderSet.Named<Biome> forestTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_FOREST);
		final BiomeModifier addAppleTree = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "apple")))),
				GenerationStep.Decoration.VEGETAL_DECORATION);
		final BiomeModifier addLemonTree = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "lemon")))),
				GenerationStep.Decoration.VEGETAL_DECORATION);
		final BiomeModifier addOrangeTree = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "orange")))),
				GenerationStep.Decoration.VEGETAL_DECORATION);
		final BiomeModifier addCherryTree = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "cherry")))),
				GenerationStep.Decoration.VEGETAL_DECORATION);
		final BiomeModifier addPearTree = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "pear")))),
				GenerationStep.Decoration.VEGETAL_DECORATION);
		final BiomeModifier addAvocadoTree = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "avocado")))),
				GenerationStep.Decoration.VEGETAL_DECORATION);
		final BiomeModifier addMangoTree = new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "mango")))),
				GenerationStep.Decoration.VEGETAL_DECORATION);

		return Map.of(
				ADD_NETHER_FLOWER, addNetherFlowerPatch,
				ADD_OLIVE_TREE, addOliveTree,
				ADD_BANANA_TREE, addBananaTree,
				ADD_APPLE_TREE, addAppleTree,
				ADD_LEMON_TREE, addLemonTree,
				ADD_ORANGE_TREE, addOrangeTree,
				ADD_CHERRY_TREE, addCherryTree,
				ADD_PEAR_TREE, addPearTree,
				ADD_AVOCADO_TREE, addAvocadoTree,
				ADD_MANGO_TREE, addMangoTree
		);
	}
}
