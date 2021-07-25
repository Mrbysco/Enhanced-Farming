package com.mrbysco.enhancedfarming.datagen;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.block.FruitLeavesBlock;
import com.mrbysco.enhancedfarming.block.GrowableSaplingBlock;
import com.mrbysco.enhancedfarming.block.crops.CropstickCropBlock;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.mrbysco.enhancedfarming.init.FarmingRegistry.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarmingDataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(new FarmingLoot(generator));
			generator.addProvider(new FarmingRecipes(generator));
		}
		if (event.includeClient()) {
//			generator.addProvider(new Language(generator));
			generator.addProvider(new FarmingBlockStates(generator, helper));
			generator.addProvider(new FarmingItemModels(generator, helper));
		}
	}

	private static class FarmingLoot extends LootTableProvider {
		public FarmingLoot(DataGenerator gen) {
			super(gen);
		}

		@Override
		protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
			return ImmutableList.of(Pair.of(FarmingBlocks::new, LootParameterSets.BLOCK));
		}

		private static class FarmingBlocks extends BlockLootTables {
			private final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
			private final float[] JUNGLE_LEAVES_SAPLING_CHANGES = new float[]{0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F};

			@Override
			protected void addTables() {
				this.dropSelf(APPLE_SAPLING.get());
				this.dropSelf(LEMON_SAPLING.get());
				this.dropSelf(ORANGE_SAPLING.get());
				this.dropSelf(CHERRY_SAPLING.get());
				this.dropSelf(PEAR_SAPLING.get());
				this.dropSelf(BANANA_SAPLING.get());
				this.dropSelf(AVOCADO_SAPLING.get());
				this.dropSelf(MANGO_SAPLING.get());
				this.dropSelf(OLIVE_SAPLING.get());

				this.add(APPLE_LEAVES.get(), (block) -> createLeavesDrops(APPLE_LEAVES.get(), APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(APPLE_LEAVES.get(), (block) -> createLeavesDrops(APPLE_LEAVES.get(), APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(LEMON_LEAVES.get(), (block) -> createLeavesDrops(LEMON_LEAVES.get(), LEMON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(ORANGE_LEAVES.get(), (block) -> createLeavesDrops(ORANGE_LEAVES.get(), ORANGE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(CHERRY_LEAVES.get(), (block) -> createLeavesDrops(CHERRY_LEAVES.get(), CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(PEAR_LEAVES.get(), (block) -> createLeavesDrops(PEAR_LEAVES.get(), PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(BANANA_LEAVES.get(), (block) -> createLeavesDrops(BANANA_LEAVES.get(), BANANA_SAPLING.get(), JUNGLE_LEAVES_SAPLING_CHANGES));
				this.add(AVOCADO_LEAVES.get(), (block) -> createLeavesDrops(AVOCADO_LEAVES.get(), AVOCADO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(MANGO_LEAVES.get(), (block) -> createLeavesDrops(MANGO_LEAVES.get(), MANGO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(OLIVE_LEAVES.get(), (block) -> createLeavesDrops(OLIVE_LEAVES.get(), OLIVE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

				this.add(CROP_STICK.get(), (block) -> createSilkTouchDispatchTable(block, applyExplosionCondition(block, ItemLootEntry.lootTableItem(Items.STICK).apply(SetCount.setCount(ConstantRange.exactly(3))))));

				this.add(MINT_CROP.get(), (block) -> createCropDrops(MINT_CROP.get(), MINT.get(), MINT_SEEDS.get(), getBuilder((CropsBlock) MINT_CROP.get())));
				ILootCondition.IBuilder netherBuilder = BlockStateProperty.hasBlockStateProperties(NETHER_FLOWER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NetherFlowerBlock.AGE, 5));
				this.add(NETHER_FLOWER_CROP.get(), (block) -> createCropDrops(NETHER_FLOWER_CROP.get(), Items.BLAZE_ROD, NETHER_FLOWER_SEEDS.get(), netherBuilder));
				this.add(TOMATO_CROP.get(), (block) -> createCropDrops(TOMATO_CROP.get(), TOMATO.get(), TOMATO_SEEDS.get(), getBuilder((CropsBlock) TOMATO_CROP.get())));
				this.add(CUCUMBER_CROP.get(), (block) -> createCropDrops(CUCUMBER_CROP.get(), CUCUMBER.get(), CUCUMBER_SEEDS.get(), getBuilder((CropsBlock) CUCUMBER_CROP.get())));
				this.add(AUBERGINE_CROP.get(), (block) -> createCropDrops(AUBERGINE_CROP.get(), AUBERGINE.get(), AUBERGINE_SEEDS.get(), getBuilder((CropsBlock) AUBERGINE_CROP.get())));
				this.add(GRAPE_CROP.get(), (block) -> createCropDrops(GRAPE_CROP.get(), GRAPES.get(), GRAPE_SEEDS.get(), getBuilder((CropsBlock) GRAPE_CROP.get())));
				this.add(PINEAPPLE_CROP.get(), (block) -> createCropDrops(PINEAPPLE_CROP.get(), PINEAPPLE.get(), PINEAPPLE_SEEDS.get(), getBuilder((CropsBlock) PINEAPPLE_CROP.get())));
				this.add(CORN_CROP.get(), (block) -> createCropDrops(CORN_CROP.get(), CORN.get(), CORN_SEEDS.get(), getBuilder((CropsBlock) CORN_CROP.get())));
				this.add(ONION_CROP.get(), (block) -> createCropDrops(ONION_CROP.get(), ONION.get(), ONION_SEEDS.get(), getBuilder((CropsBlock) ONION_CROP.get())));
				this.add(GARLIC_CROP.get(), (block) -> createCropDrops(GARLIC_CROP.get(), GARLIC.get(), GARLIC_SEEDS.get(), getBuilder((CropsBlock) GARLIC_CROP.get())));
				this.add(LETTUCE_CROP.get(), (block) -> createCropDrops(LETTUCE_CROP.get(), LETTUCE.get(), LETTUCE_SEEDS.get(), getBuilder((CropsBlock) LETTUCE_CROP.get())));

				this.dropSelf(SCARECROW.get());
			}

			public ILootCondition.IBuilder getBuilder(CropsBlock block) {
				return BlockStateProperty.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(block.getAgeProperty(), block.getMaxAge()));
			}

			@Override
			protected Iterable<Block> getKnownBlocks() {
				return (Iterable<Block>) FarmingRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
			}
		}

		@Override
		protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationTracker validationtracker) {
			map.forEach((name, table) -> LootTableManager.validate(validationtracker, name, table));
		}
	}


	private static class FarmingRecipes extends RecipeProvider {
		public FarmingRecipes(DataGenerator gen) {
			super(gen);
		}

		@Override
		protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

		}

		@Override
		protected void saveAdvancement(DirectoryCache cache, JsonObject advancementJson, Path path) {
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
			ITEMS.getEntries().stream()
					.map(RegistryObject::get)
					.forEach(item -> {
						String path = Objects.requireNonNull(item.getRegistryName()).getPath();
						if(!path.equals("scarecrow")) {
							if(path.endsWith("_sapling")) {
								singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("block/saplings/" + path));
							} else if(path.endsWith("_leaves")) {
								withExistingParent(path, modLoc("block/" + path + "_fruity"));
							} else if(path.endsWith("_rake")) {
								singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("item/" + path));
							} else {
								singleTexture(path, mcLoc("item/generated"), "layer0", modLoc("item/" + path));
							}
						}
					});
		}

		@Override
		public String getName() {
			return "Item Models";
		}
	}

	private static class FarmingBlockStates extends BlockStateProvider {

		public FarmingBlockStates(DataGenerator gen, ExistingFileHelper helper) {
			super(gen, Reference.MOD_ID, helper);
		}

		@Override
		protected void registerStatesAndModels() {
			buildCrops((CropsBlock) MINT_CROP.get());
			buildNetherCrops((NetherFlowerBlock) NETHER_FLOWER_CROP.get());
			buildCrops((CropsBlock) TOMATO_CROP.get());
			buildCrops((CropsBlock) CUCUMBER_CROP.get());
			buildCrops((CropsBlock) AUBERGINE_CROP.get());
			buildStickCropCrops((CropstickCropBlock) GRAPE_CROP.get());
			buildCrops((CropsBlock) PINEAPPLE_CROP.get());
			buildCrops((CropsBlock) CORN_CROP.get());
			buildCrops((CropsBlock) ONION_CROP.get());
			buildCrops((CropsBlock) GARLIC_CROP.get());
			buildCrops((CropsBlock) LETTUCE_CROP.get());

			buildSaplings((GrowableSaplingBlock) APPLE_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) LEMON_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) ORANGE_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) CHERRY_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) PEAR_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) BANANA_SAPLING.get(), "jungle_sapling");
			buildSaplings((GrowableSaplingBlock) AVOCADO_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) MANGO_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) OLIVE_SAPLING.get(), "acacia_sapling");

			buildLeaves((FruitLeavesBlock) APPLE_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) LEMON_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) ORANGE_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) CHERRY_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) PEAR_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) BANANA_LEAVES.get(), "jungle_leaves");
			buildLeaves((FruitLeavesBlock) AVOCADO_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) MANGO_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) OLIVE_LEAVES.get(), "acacia_leaves");

			model(CROP_STICK.get());

			horizontalBlock(SCARECROW.get(), models().getExistingFile(modLoc("block/scarecrow")));
		}

		protected void model(Block block) {
			ModelFile file = models().getExistingFile(block.getRegistryName());
			getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(file).build());
		}

		protected void buildNetherCrops(NetherFlowerBlock block) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				ModelFile file = models().crop(block.getRegistryName().getPath() + "_" + (i),
						new ResourceLocation(Reference.MOD_ID, "block/crops/" + block.getRegistryName().getPath() + "_" + (i)));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}

		protected void buildCrops(CropsBlock block) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				ModelFile file = models().crop(block.getRegistryName().getPath() + "_" + (i),
						new ResourceLocation(Reference.MOD_ID, "block/crops/" + block.getRegistryName().getPath() + "_" + (i)));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}

		protected void buildStickCropCrops(CropstickCropBlock block) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				ModelFile file = models().singleTexture(block.getRegistryName().getPath() + "_" + (i), modLoc("block/stick_crops"), "crop",
						new ResourceLocation(Reference.MOD_ID, "block/crops/" + block.getRegistryName().getPath() + "_" + (i)));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}

		protected void buildSaplings(GrowableSaplingBlock block, String base) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMatureStage(); i++) {
				if(i == block.getMatureStage()) {
					ModelFile file = models().crop(block.getRegistryName().getPath() + "_" + (i),
							new ResourceLocation(Reference.MOD_ID, "block/saplings/" + block.getRegistryName().getPath()));
					builder.partialState().with(block.getStageProperty(), i).modelForState().modelFile(file).addModel();
				} else {
					ModelFile file = models().crop(block.getRegistryName().getPath() + "_" + (i),
							new ResourceLocation(Reference.MOD_ID, "block/saplings/" + base + "_" + (i)));
					builder.partialState().with(block.getStageProperty(), i).modelForState().modelFile(file).addModel();
				}
			}
		}

		protected void buildLeaves(FruitLeavesBlock block, String originalLeaves) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				if(i != block.getMaxAge()) {
					ModelFile file = models().singleTexture(block.getRegistryName().getPath() + "_blooming", modLoc("block/leave_overlay"), "layer1",
							new ResourceLocation(Reference.MOD_ID, "block/leaves/" + block.getRegistryName().getPath() + "_blooming")).texture("layer0", mcLoc("block/" + originalLeaves));
					builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
				} else {
					ModelFile file = models().singleTexture(block.getRegistryName().getPath() + "_fruity", modLoc("block/leave_overlay"), "layer1",
							new ResourceLocation(Reference.MOD_ID, "block/leaves/" + block.getRegistryName().getPath() + "_fruity")).texture("layer0", mcLoc("block/" + originalLeaves));
					builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
				}
			}
		}
	}
}
