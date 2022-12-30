package com.mrbysco.enhancedfarming.datagen;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.JsonOps;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.block.FruitLeavesBlock;
import com.mrbysco.enhancedfarming.block.GrowableSaplingBlock;
import com.mrbysco.enhancedfarming.block.crops.CropstickCropBlock;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.init.FarmingLootTables;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.lootmodifiers.GrassDropModifier;
import com.mrbysco.enhancedfarming.world.feature.FarmingFeatureConfigs;
import com.mrbysco.enhancedfarming.world.feature.FarmingVegetation;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.GiftLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarmingDataGen {

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

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		final RegistryOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.builtinCopy());
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		generator.addProvider(event.includeServer(), new FarmingLoot(generator));
		generator.addProvider(event.includeServer(), new FarmingLootModifiers(generator));
//			generator.addProvider(new FarmingRecipes(generator));

		generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(
				generator, existingFileHelper, Reference.MOD_ID, ops, Registry.PLACED_FEATURE_REGISTRY, getConfiguredFeatures(ops)));

		generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(
				generator, existingFileHelper, Reference.MOD_ID, ops, ForgeRegistries.Keys.BIOME_MODIFIERS, getBiomeModifiers(ops)));

		generator.addProvider(event.includeClient(), new Language(generator));
		generator.addProvider(event.includeClient(), new FarmingBlockStates(generator, existingFileHelper));
		generator.addProvider(event.includeClient(), new FarmingItemModels(generator, existingFileHelper));
	}

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
		final BiomeModifier addNetherFlowerPatch = new AddFeaturesBiomeModifier(
				badlandsTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "patch_nether_flower")))),
				Decoration.UNDERGROUND_DECORATION);

		final HolderSet.Named<Biome> savannaTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_SAVANNA);
		final BiomeModifier addOliveTree = new AddFeaturesBiomeModifier(
				savannaTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "olive")))),
				Decoration.VEGETAL_DECORATION);

		final HolderSet.Named<Biome> jungleTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_JUNGLE);
		final BiomeModifier addBananaTree = new AddFeaturesBiomeModifier(
				jungleTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "banana")))),
				Decoration.VEGETAL_DECORATION);
		final HolderSet.Named<Biome> forestTag = new HolderSet.Named<>(ops.registry(Registry.BIOME_REGISTRY).get(), BiomeTags.IS_FOREST);
		final BiomeModifier addAppleTree = new AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "apple")))),
				Decoration.VEGETAL_DECORATION);
		final BiomeModifier addLemonTree = new AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "lemon")))),
				Decoration.VEGETAL_DECORATION);
		final BiomeModifier addOrangeTree = new AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "orange")))),
				Decoration.VEGETAL_DECORATION);
		final BiomeModifier addCherryTree = new AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "cherry")))),
				Decoration.VEGETAL_DECORATION);
		final BiomeModifier addPearTree = new AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "pear")))),
				Decoration.VEGETAL_DECORATION);
		final BiomeModifier addAvocadoTree = new AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "avocado")))),
				Decoration.VEGETAL_DECORATION);
		final BiomeModifier addMangoTree = new AddFeaturesBiomeModifier(
				forestTag,
				HolderSet.direct(ops.registry(Registry.PLACED_FEATURE_REGISTRY).get().getOrCreateHolderOrThrow(ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY,
						new ResourceLocation(Reference.MOD_ID, "mango")))),
				Decoration.VEGETAL_DECORATION);

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

	private static class FarmingLoot extends LootTableProvider {
		public FarmingLoot(DataGenerator gen) {
			super(gen);
		}

		@Override
		protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
			return ImmutableList.of(Pair.of(FarmingBlocks::new, LootContextParamSets.BLOCK), Pair.of(FarmingRakeDrops::new, LootContextParamSets.GIFT));
		}

		private static class FarmingBlocks extends BlockLoot {
			private final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
			private final float[] JUNGLE_LEAVES_SAPLING_CHANGES = new float[]{0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F};

			@Override
			protected void addTables() {
				this.dropSelf(FarmingRegistry.APPLE_SAPLING.get());
				this.dropSelf(FarmingRegistry.LEMON_SAPLING.get());
				this.dropSelf(FarmingRegistry.ORANGE_SAPLING.get());
				this.dropSelf(FarmingRegistry.CHERRY_SAPLING.get());
				this.dropSelf(FarmingRegistry.PEAR_SAPLING.get());
				this.dropSelf(FarmingRegistry.BANANA_SAPLING.get());
				this.dropSelf(FarmingRegistry.AVOCADO_SAPLING.get());
				this.dropSelf(FarmingRegistry.MANGO_SAPLING.get());
				this.dropSelf(FarmingRegistry.OLIVE_SAPLING.get());

				this.add(FarmingRegistry.APPLE_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(FarmingRegistry.APPLE_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(FarmingRegistry.LEMON_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.LEMON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(FarmingRegistry.ORANGE_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.ORANGE_LEAVES.get(), FarmingRegistry.ORANGE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(FarmingRegistry.CHERRY_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(FarmingRegistry.PEAR_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(FarmingRegistry.BANANA_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.BANANA_LEAVES.get(), FarmingRegistry.BANANA_SAPLING.get(), JUNGLE_LEAVES_SAPLING_CHANGES));
				this.add(FarmingRegistry.AVOCADO_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.AVOCADO_LEAVES.get(), FarmingRegistry.AVOCADO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(FarmingRegistry.MANGO_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.MANGO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(FarmingRegistry.OLIVE_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.OLIVE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

				this.add(FarmingRegistry.CROP_STICK.get(), (block) -> createSilkTouchDispatchTable(block, applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3))))));

				this.add(FarmingRegistry.MINT_CROP.get(), (block) -> createCropDrops(FarmingRegistry.MINT_CROP.get(), FarmingRegistry.MINT.get(), FarmingRegistry.MINT_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.MINT_CROP.get())));
				LootItemCondition.Builder netherBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(FarmingRegistry.NETHER_FLOWER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NetherFlowerBlock.AGE, 5));
				this.add(FarmingRegistry.NETHER_FLOWER_CROP.get(), (block) -> createCropDrops(FarmingRegistry.NETHER_FLOWER_CROP.get(), Items.BLAZE_ROD, FarmingRegistry.NETHER_FLOWER_SEEDS.get(), netherBuilder));
				this.add(FarmingRegistry.TOMATO_CROP.get(), (block) -> createCropDrops(FarmingRegistry.TOMATO_CROP.get(), FarmingRegistry.TOMATO.get(), FarmingRegistry.TOMATO_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.TOMATO_CROP.get())));
				this.add(FarmingRegistry.CUCUMBER_CROP.get(), (block) -> createCropDrops(FarmingRegistry.CUCUMBER_CROP.get(), FarmingRegistry.CUCUMBER.get(), FarmingRegistry.CUCUMBER_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.CUCUMBER_CROP.get())));
				this.add(FarmingRegistry.AUBERGINE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.AUBERGINE_CROP.get(), FarmingRegistry.AUBERGINE.get(), FarmingRegistry.AUBERGINE_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.AUBERGINE_CROP.get())));
				this.add(FarmingRegistry.GRAPE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.GRAPE_CROP.get(), FarmingRegistry.GRAPES.get(), FarmingRegistry.GRAPE_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.GRAPE_CROP.get())));
				this.add(FarmingRegistry.PINEAPPLE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.PINEAPPLE_CROP.get(), FarmingRegistry.PINEAPPLE.get(), FarmingRegistry.PINEAPPLE_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.PINEAPPLE_CROP.get())));
				this.add(FarmingRegistry.CORN_CROP.get(), (block) -> createCropDrops(FarmingRegistry.CORN_CROP.get(), FarmingRegistry.CORN.get(), FarmingRegistry.CORN_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.CORN_CROP.get())));
				this.add(FarmingRegistry.ONION_CROP.get(), (block) -> createCropDrops(FarmingRegistry.ONION_CROP.get(), FarmingRegistry.ONION.get(), FarmingRegistry.ONION_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.ONION_CROP.get())));
				this.add(FarmingRegistry.GARLIC_CROP.get(), (block) -> createCropDrops(FarmingRegistry.GARLIC_CROP.get(), FarmingRegistry.GARLIC.get(), FarmingRegistry.GARLIC_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.GARLIC_CROP.get())));
				this.add(FarmingRegistry.LETTUCE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.LETTUCE_CROP.get(), FarmingRegistry.LETTUCE.get(), FarmingRegistry.LETTUCE_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.LETTUCE_CROP.get())));

				this.dropSelf(FarmingRegistry.SCARECROW.get());
			}

			public LootItemCondition.Builder getBuilder(CropBlock block) {
				return LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(block.getAgeProperty(), block.getMaxAge()));
			}

			@Override
			protected Iterable<Block> getKnownBlocks() {
				return (Iterable<Block>) FarmingRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
			}
		}


		private static class FarmingRakeDrops extends GiftLoot {
			@Override
			public void accept(BiConsumer<ResourceLocation, Builder> consumer) {
				consumer.accept(FarmingLootTables.GAMEPLAY_RAKE_DROPS,
						LootTable.lootTable()
								.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
										.add(LootItem.lootTableItem(FarmingRegistry.APPLE_SAPLING.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.LEMON_SAPLING.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.ORANGE_SAPLING.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.MINT_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.NETHER_FLOWER_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.CHERRY_SAPLING.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.PEAR_SAPLING.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.BANANA_SAPLING.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.AVOCADO_SAPLING.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.MANGO_SAPLING.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.TOMATO_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.CUCUMBER_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.AUBERGINE_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.PINEAPPLE_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.GRAPE_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.CORN_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.ONION_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.GARLIC_SEEDS.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.OLIVE_SAPLING.get()))
										.add(LootItem.lootTableItem(FarmingRegistry.LETTUCE_SEEDS.get()))
								));
			}
		}

		@Override
		protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext validationtracker) {
			map.forEach((name, table) -> LootTables.validate(validationtracker, name, table));
		}
	}


	private static class FarmingRecipes extends RecipeProvider {
		public FarmingRecipes(DataGenerator gen) {
			super(gen);
		}

		@Override
		protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

		}

		@Override
		protected void saveAdvancement(CachedOutput cache, JsonObject advancementJson, Path path) {
			// Nope
		}
	}

	private static class FarmingLanguage extends LanguageProvider {
		public FarmingLanguage(DataGenerator gen) {
			super(gen, Reference.MOD_ID, "en_us");
		}

		@Override
		protected void addTranslations() {
			//
		}
	}

	private static class FarmingItemModels extends ItemModelProvider {
		public FarmingItemModels(DataGenerator gen, ExistingFileHelper helper) {
			super(gen, Reference.MOD_ID, helper);
		}

		@Override
		protected void registerModels() {
			FarmingRegistry.ITEMS.getEntries().stream()
					.map(RegistryObject::get)
					.forEach(item -> {
						String path = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
						if (!path.equals("scarecrow")) {
							if (path.endsWith("_sapling")) {
								singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("block/saplings/" + path));
							} else if (path.endsWith("_leaves")) {
								withExistingParent(path, modLoc("block/" + path + "_fruity"));
							} else if (path.endsWith("_rake")) {
								singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("item/" + path));
							} else {
								singleTexture(path, mcLoc("item/generated"), "layer0", modLoc("item/" + path));
							}
						} else {
							withExistingParent(path, modLoc("block/scarecrow"));
						}
					});
		}

		@Override
		public String getName() {
			return "Item Models";
		}
	}

	private static class Language extends LanguageProvider {
		public Language(DataGenerator gen) {
			super(gen, Reference.MOD_ID, "en_us");
		}

		@Override
		protected void addTranslations() {
			add("enhancedfarming.config.title", "Enhanced Farming Config");
			add("itemGroup.enhancedfarming", "Enhanced Farming");

			addBlocks();
			addItems();

			add("enhancedfarming.gui.jei.category.piston", "Piston crafting");
		}

		private void addBlocks() {
			addBlock(FarmingRegistry.MINT_CROP, "Mint Crop");
			addBlock(FarmingRegistry.NETHER_FLOWER_CROP, "Nether Flower Crop");
			addBlock(FarmingRegistry.TOMATO_CROP, "Tomato Crop");
			addBlock(FarmingRegistry.CUCUMBER_CROP, "Cucumber Crop");
			addBlock(FarmingRegistry.AUBERGINE_CROP, "Aubergine Crop");
			addBlock(FarmingRegistry.GRAPE_CROP, "Grape Crop");
			addBlock(FarmingRegistry.PINEAPPLE_CROP, "Pineapple Crop");
			addBlock(FarmingRegistry.CORN_CROP, "Corn Crop");
			addBlock(FarmingRegistry.ONION_CROP, "Onion Crop");
			addBlock(FarmingRegistry.GARLIC_CROP, "Garlic Crop");
			addBlock(FarmingRegistry.LETTUCE_CROP, "Lettuce Crop");

			addBlock(FarmingRegistry.APPLE_LEAVES, "Apple Leaves");
			addBlock(FarmingRegistry.LEMON_LEAVES, "Lemon Leaves");
			addBlock(FarmingRegistry.ORANGE_LEAVES, "Orange Leaves");
			addBlock(FarmingRegistry.CHERRY_LEAVES, "Cherry Leaves");
			addBlock(FarmingRegistry.PEAR_LEAVES, "Pear Leaves");
			addBlock(FarmingRegistry.BANANA_LEAVES, "Banana Leaves");
			addBlock(FarmingRegistry.AVOCADO_LEAVES, "Avocado Leaves");
			addBlock(FarmingRegistry.MANGO_LEAVES, "Mango Leaves");
			addBlock(FarmingRegistry.OLIVE_LEAVES, "Olive Leaves");

			addBlock(FarmingRegistry.APPLE_SAPLING, "Apple Seeds");
			addBlock(FarmingRegistry.LEMON_SAPLING, "Lemon Seeds");
			addBlock(FarmingRegistry.ORANGE_SAPLING, "Orange Seeds");
			addBlock(FarmingRegistry.CHERRY_SAPLING, "Cherry Seeds");
			addBlock(FarmingRegistry.PEAR_SAPLING, "Pear Seeds");
			addBlock(FarmingRegistry.BANANA_SAPLING, "Banana Seeds");
			addBlock(FarmingRegistry.AVOCADO_SAPLING, "Avocado Seed");
			addBlock(FarmingRegistry.MANGO_SAPLING, "Mango Seed");
			addBlock(FarmingRegistry.OLIVE_SAPLING, "Olive Seeds");

			addBlock(FarmingRegistry.CROP_STICK, "Crop Sticks");
			addBlock(FarmingRegistry.SCARECROW, "Scarecrow");
		}

		private void addItems() {
			addItem(FarmingRegistry.MINT_SEEDS, "Mint Seeds");
			addItem(FarmingRegistry.NETHER_FLOWER_SEEDS, "Nether Flower Seeds");
			addItem(FarmingRegistry.TOMATO_SEEDS, "Tomato Seeds");
			addItem(FarmingRegistry.CUCUMBER_SEEDS, "Cucumber Seeds");
			addItem(FarmingRegistry.AUBERGINE_SEEDS, "Aubergine Seeds");
			addItem(FarmingRegistry.GRAPE_SEEDS, "Grape Seeds");
			addItem(FarmingRegistry.CORN_SEEDS, "Corn Seeds");
			addItem(FarmingRegistry.PINEAPPLE_SEEDS, "Pineapple Seeds");
			addItem(FarmingRegistry.ONION_SEEDS, "Onion Seeds");
			addItem(FarmingRegistry.GARLIC_SEEDS, "Garlic Seeds");
			addItem(FarmingRegistry.LETTUCE_SEEDS, "Lettuce Seeds");
			addItem(FarmingRegistry.POT, "Pot");
			addItem(FarmingRegistry.CUTTING_BOARD, "Cutting Board");
			addItem(FarmingRegistry.MORTAR_AND_PESTLE, "Mortar And Pestle");
			addItem(FarmingRegistry.MINT, "Mint");
			addItem(FarmingRegistry.LEMON, "Lemon");
			addItem(FarmingRegistry.ORANGE, "Orange");
			addItem(FarmingRegistry.CHERRY, "Cherry");
			addItem(FarmingRegistry.PEAR, "Pear");
			addItem(FarmingRegistry.BANANA, "Banana");
			addItem(FarmingRegistry.OLIVE, "Olive");
			addItem(FarmingRegistry.AVOCADO, "Avocado");
			addItem(FarmingRegistry.MANGO, "Mango");
			addItem(FarmingRegistry.TOMATO, "Tomato");
			addItem(FarmingRegistry.CUCUMBER, "Cucumber");
			addItem(FarmingRegistry.AUBERGINE, "Aubergine");
			addItem(FarmingRegistry.GRAPES, "Grapes");
			addItem(FarmingRegistry.PINEAPPLE, "Pineapple");
			addItem(FarmingRegistry.CORN, "Corn");
			addItem(FarmingRegistry.ONION, "Onion");
			addItem(FarmingRegistry.GARLIC, "Garlic");
			addItem(FarmingRegistry.LETTUCE, "Lettuce");
			addItem(FarmingRegistry.GOLDEN_LEMON, "Golden lemon");
			addItem(FarmingRegistry.GOLDEN_ORANGE, "Golden Orange");
			addItem(FarmingRegistry.CHOCOLATE_BAR, "Chocolate Bar");
			addItem(FarmingRegistry.CHOCOLATE_CANDY, "Chocolate Candy");
			addItem(FarmingRegistry.CHOCOLATE_CHERRY, "Chocolate Cherry");
			addItem(FarmingRegistry.CHOCOLATE_BANANA, "Chocolate Banana");
			addItem(FarmingRegistry.MINT_CHOCOLATE_BAR, "Mint Chocolate Bar");
			addItem(FarmingRegistry.MINT_TEA, "Mint Tea");
			addItem(FarmingRegistry.APPLE_JUICE, "Apple Juice");
			addItem(FarmingRegistry.LEMONADE, "Lemonade");
			addItem(FarmingRegistry.ORANGE_JUICE, "Orange Juice");
			addItem(FarmingRegistry.CHERRY_JUICE, "Cherry Juice");
			addItem(FarmingRegistry.PEAR_JUICE, "Pear Juice");
			addItem(FarmingRegistry.BANANA_JUICE, "Banana Juice");
			addItem(FarmingRegistry.GRAPE_JUICE, "Grape Juice");
			addItem(FarmingRegistry.MANGO_JUICE, "Mango Juice");
			addItem(FarmingRegistry.PINEAPPLE_JUICE, "Pineapple Juice");
			addItem(FarmingRegistry.MILK_BOTTLE, "Milk Bottle");
			addItem(FarmingRegistry.COLD_CHOCOLATE_BOTTLE, "Cold Chocolate Bottle");
			addItem(FarmingRegistry.HOT_CHOCOLATE_BOTTLE, "Hot Chocolate Bottle");
			addItem(FarmingRegistry.HOT_WATER, "Boiled Water");
			addItem(FarmingRegistry.SMOOTHIE_APPLE, "Apple Smoothie");
			addItem(FarmingRegistry.SMOOTHIE_LEMON, "Lemon Smoothie");
			addItem(FarmingRegistry.SMOOTHIE_ORANGE, "Orange Smoothie");
			addItem(FarmingRegistry.SMOOTHIE_CHERRY, "Cherry Smoothie");
			addItem(FarmingRegistry.SMOOTHIE_PEAR, "Pear Smoothie");
			addItem(FarmingRegistry.SMOOTHIE_BANANA, "Banana Smoothie");
			addItem(FarmingRegistry.SMOOTHIE_GRAPE, "Grape Smoothie");
			addItem(FarmingRegistry.SMOOTHIE_MANGO, "Mango Smoothie");
			addItem(FarmingRegistry.SMOOTHIE_PINEAPPLE, "Pineapple Smoothie");
			addItem(FarmingRegistry.SMOOTHIE_CUCUMBER, "Cucumber Smoothie");
			addItem(FarmingRegistry.STOCK, "Stock");
			addItem(FarmingRegistry.SALT, "Salt");
			addItem(FarmingRegistry.FLOUR, "Flour");
			addItem(FarmingRegistry.DOUGH, "Dough");
			addItem(FarmingRegistry.OLIVE_OIL, "Olive Oil");
			addItem(FarmingRegistry.PASTA, "Pasta");
			addItem(FarmingRegistry.RAW_FRIES, "Raw Fries");
			addItem(FarmingRegistry.FRUIT_SALAD, "Fruit Salad");
			addItem(FarmingRegistry.SALAD, "Salad");
			addItem(FarmingRegistry.CORN_SOUP, "Corn Soup");
			addItem(FarmingRegistry.CUCUMBER_SOUP, "Cucumber Soup");
			addItem(FarmingRegistry.TOMATO_SOUP, "Tomato Soup");
			addItem(FarmingRegistry.POTATO_SOUP, "Potato Soup");
			addItem(FarmingRegistry.CARROT_SOUP, "Carrot Soup");
			addItem(FarmingRegistry.ONION_SOUP, "Onion Soup");
			addItem(FarmingRegistry.CHICKEN_NOODLE_SOUP, "Chicken Noodle Soup");
			addItem(FarmingRegistry.HAMBURGER, "Hamburger");
			addItem(FarmingRegistry.CHICKENBURGER, "Chicken Burger");
			addItem(FarmingRegistry.CHEESEBURGER, "Cheese Burger");
			addItem(FarmingRegistry.BOILED_EGG, "Boiled Egg");
			addItem(FarmingRegistry.BAKED_EGG, "Baked Egg");
			addItem(FarmingRegistry.SLICED_BREAD, "Sliced Bread");
			addItem(FarmingRegistry.CHEESE, "Cheese");
			addItem(FarmingRegistry.SPAGHETTI, "Spaghetti");
			addItem(FarmingRegistry.JAM, "Fruit Jam");
			addItem(FarmingRegistry.FRIES, "Fries");
			addItem(FarmingRegistry.FISH_AND_CHIPS, "Fish And Chips");
			addItem(FarmingRegistry.POTATO_CHIPS, "Potato Chips");
			addItem(FarmingRegistry.GUACAMOLE, "Guacamole");
			addItem(FarmingRegistry.GUAC_AND_CHIPS, "Guac and Chips");
			addItem(FarmingRegistry.EGG_SANDWICH, "Egg Sandwich");
			addItem(FarmingRegistry.BACON_SANDWICH, "Bacon Sandwich");
			addItem(FarmingRegistry.CHICKEN_SANDWICH, "Chicken Sandwich");
			addItem(FarmingRegistry.JC_SANDWICH, "Jam And Cheese Sandwich");
			addItem(FarmingRegistry.PINEAPPLE_PIZZA, "Pineapple Pizza");
			addItem(FarmingRegistry.CHEESE_PIZZA, "Cheese Pizza");
			addItem(FarmingRegistry.BACON_PIZZA, "Bacon Pizza");
			addItem(FarmingRegistry.APPLE_PIE, "Apple Pie");
			addItem(FarmingRegistry.BANANA_PIE, "Banana Cream Pie");
			addItem(FarmingRegistry.BACON_AND_EGG_PIE, "Bacon And Egg Pie");
			addItem(FarmingRegistry.CHERRY_PIE, "Cherry Pie");
			addItem(FarmingRegistry.GRAPE_PIE, "Grape Pie");
			addItem(FarmingRegistry.LEMON_PIE, "Lemon Meringue Pie");
			addItem(FarmingRegistry.PEAR_PIE, "Pear Pie");
			addItem(FarmingRegistry.WOODEN_RAKE, "Wooden Rake");
			addItem(FarmingRegistry.STONE_RAKE, "Stone Rake");
			addItem(FarmingRegistry.IRON_RAKE, "Iron Rake");
			addItem(FarmingRegistry.GOLD_RAKE, "Gold Rake");
			addItem(FarmingRegistry.DIAMOND_RAKE, "Diamond Rake");
		}
	}

	private static class FarmingBlockStates extends BlockStateProvider {

		public FarmingBlockStates(DataGenerator gen, ExistingFileHelper helper) {
			super(gen, Reference.MOD_ID, helper);
		}

		@Override
		protected void registerStatesAndModels() {
			buildCrops((CropBlock) FarmingRegistry.MINT_CROP.get());
			buildNetherCrops((NetherFlowerBlock) FarmingRegistry.NETHER_FLOWER_CROP.get());
			buildCrops((CropBlock) FarmingRegistry.TOMATO_CROP.get());
			buildCrops((CropBlock) FarmingRegistry.CUCUMBER_CROP.get());
			buildCrops((CropBlock) FarmingRegistry.AUBERGINE_CROP.get());
			buildStickCropCrops((CropstickCropBlock) FarmingRegistry.GRAPE_CROP.get());
			buildCrops((CropBlock) FarmingRegistry.PINEAPPLE_CROP.get());
			buildCrops((CropBlock) FarmingRegistry.CORN_CROP.get());
			buildCrops((CropBlock) FarmingRegistry.ONION_CROP.get());
			buildCrops((CropBlock) FarmingRegistry.GARLIC_CROP.get());
			buildCrops((CropBlock) FarmingRegistry.LETTUCE_CROP.get());

			buildSaplings((GrowableSaplingBlock) FarmingRegistry.APPLE_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) FarmingRegistry.LEMON_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) FarmingRegistry.ORANGE_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) FarmingRegistry.CHERRY_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) FarmingRegistry.PEAR_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) FarmingRegistry.BANANA_SAPLING.get(), "jungle_sapling");
			buildSaplings((GrowableSaplingBlock) FarmingRegistry.AVOCADO_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) FarmingRegistry.MANGO_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) FarmingRegistry.OLIVE_SAPLING.get(), "acacia_sapling");

			buildLeaves((FruitLeavesBlock) FarmingRegistry.APPLE_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) FarmingRegistry.LEMON_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) FarmingRegistry.ORANGE_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) FarmingRegistry.CHERRY_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) FarmingRegistry.PEAR_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) FarmingRegistry.BANANA_LEAVES.get(), "jungle_leaves");
			buildLeaves((FruitLeavesBlock) FarmingRegistry.AVOCADO_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) FarmingRegistry.MANGO_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) FarmingRegistry.OLIVE_LEAVES.get(), "acacia_leaves");

			model(FarmingRegistry.CROP_STICK.get());

			horizontalBlock(FarmingRegistry.SCARECROW.get(), models().getExistingFile(modLoc("block/scarecrow")));
		}

		protected void model(Block block) {
			ModelFile file = models().getExistingFile(ForgeRegistries.BLOCKS.getKey(block));
			getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(file).build());
		}

		protected void buildNetherCrops(NetherFlowerBlock block) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				ModelFile file = models().crop(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_" + (i),
						new ResourceLocation(Reference.MOD_ID, "block/crops/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_" + (i))).renderType(new ResourceLocation("cutout"));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}

		protected void buildCrops(CropBlock block) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				ModelFile file = models().crop(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_" + (i),
						new ResourceLocation(Reference.MOD_ID, "block/crops/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_" + (i))).renderType(new ResourceLocation("cutout"));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}

		protected void buildStickCropCrops(CropstickCropBlock block) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				ModelFile file = models().singleTexture(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_" + (i), modLoc("block/stick_crops"), "crop",
						new ResourceLocation(Reference.MOD_ID, "block/crops/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_" + (i))).renderType(new ResourceLocation("cutout"));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}

		protected void buildSaplings(GrowableSaplingBlock block, String base) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMatureStage(); i++) {
				if (i == block.getMatureStage()) {
					ModelFile file = models().crop(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_" + (i),
							new ResourceLocation(Reference.MOD_ID, "block/saplings/" + ForgeRegistries.BLOCKS.getKey(block).getPath())).renderType(new ResourceLocation("cutout"));
					builder.partialState().with(block.getStageProperty(), i).modelForState().modelFile(file).addModel();
				} else {
					ModelFile file = models().crop(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_" + (i),
							new ResourceLocation(Reference.MOD_ID, "block/saplings/" + base + "_" + (i)));
					builder.partialState().with(block.getStageProperty(), i).modelForState().modelFile(file).addModel();
				}
			}
		}

		protected void buildLeaves(FruitLeavesBlock block, String originalLeaves) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				if (i != block.getMaxAge()) {
					ModelFile file = models().singleTexture(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_blooming", modLoc("block/leave_overlay"), "layer1",
							new ResourceLocation(Reference.MOD_ID, "block/leaves/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_blooming")).texture("layer0", mcLoc("block/" + originalLeaves)).renderType(new ResourceLocation("cutout_mipped"));
					;
					builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
				} else {
					ModelFile file = models().singleTexture(ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fruity", modLoc("block/leave_overlay"), "layer1",
							new ResourceLocation(Reference.MOD_ID, "block/leaves/" + ForgeRegistries.BLOCKS.getKey(block).getPath() + "_fruity")).texture("layer0", mcLoc("block/" + originalLeaves)).renderType(new ResourceLocation("cutout_mipped"));
					;
					builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
				}
			}
		}
	}

	public static class FarmingLootModifiers extends GlobalLootModifierProvider {
		public FarmingLootModifiers(DataGenerator generator) {
			super(generator, Reference.MOD_ID);
		}

		@Override
		protected void start() {
			this.add("grass_drops", new GrassDropModifier());
		}
	}
}
