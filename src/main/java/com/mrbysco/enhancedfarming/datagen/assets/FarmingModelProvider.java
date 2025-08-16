package com.mrbysco.enhancedfarming.datagen.assets;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.block.FruitLeavesBlock;
import com.mrbysco.enhancedfarming.block.GrowableSaplingBlock;
import com.mrbysco.enhancedfarming.block.crops.CropstickCropBlock;
import com.mrbysco.enhancedfarming.block.crops.FiveAgeCropBlock;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.block.crops.SevenAgeCropBlock;
import com.mrbysco.enhancedfarming.block.crops.SixAgeCropBlock;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class FarmingModelProvider extends ModelProvider {
	public static final ModelTemplate CUTOUT_CROP = ModelTemplates.CROP.extend().renderType("cutout").build();
	public static final ModelTemplate STICK_CROP = ModelTemplates.create("enhancedfarming:stick_crops", TextureSlot.CROP);
	public static final ModelTemplate LEAVE_OVERLAY = ModelTemplates.create("enhancedfarming:leave_overlay", TextureSlot.LAYER0, TextureSlot.LAYER1)
			.extend().renderType("cutout_mipped").build();

	public FarmingModelProvider(PackOutput output) {
		super(output, EnhancedFarming.MOD_ID);
	}

	@Override
	protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		blockModels.createCropBlock(FarmingRegistry.MINT_CROP.get(), FiveAgeCropBlock.AGE, 0, 1, 2, 3, 4, 5);
		blockModels.createCropBlock(FarmingRegistry.NETHER_FLOWER_CROP.get(), NetherFlowerBlock.AGE, 0, 1, 2, 3, 4, 5);
		blockModels.createCropBlock(FarmingRegistry.TOMATO_CROP.get(), SixAgeCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
		blockModels.createCropBlock(FarmingRegistry.CUCUMBER_CROP.get(), FiveAgeCropBlock.AGE, 0, 1, 2, 3, 4, 5);
		blockModels.createCropBlock(FarmingRegistry.AUBERGINE_CROP.get(), FiveAgeCropBlock.AGE, 0, 1, 2, 3, 4, 5);
		blockModels.createCropBlock(FarmingRegistry.GRAPE_CROP.get(), CropstickCropBlock.AGE, 0, 1, 2, 3, 4, 5);
		blockModels.createCropBlock(FarmingRegistry.PINEAPPLE_CROP.get(), FiveAgeCropBlock.AGE, 0, 1, 2, 3, 4, 5);
		createCropStickBlock(blockModels, FarmingRegistry.CORN_CROP.get(), SevenAgeCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
		blockModels.createCropBlock(FarmingRegistry.ONION_CROP.get(), FiveAgeCropBlock.AGE, 0, 1, 2, 3, 4, 5);
		blockModels.createCropBlock(FarmingRegistry.GARLIC_CROP.get(), FiveAgeCropBlock.AGE, 0, 1, 2, 3, 4, 5);
		blockModels.createCropBlock(FarmingRegistry.LETTUCE_CROP.get(), FiveAgeCropBlock.AGE, 0, 1, 2, 3, 4, 5);

		buildSaplings(blockModels, FarmingRegistry.APPLE_SAPLING.get(), "oak_sapling");
		buildSaplings(blockModels, FarmingRegistry.LEMON_SAPLING.get(), "oak_sapling");
		buildSaplings(blockModels, FarmingRegistry.ORANGE_SAPLING.get(), "oak_sapling");
		buildSaplings(blockModels, FarmingRegistry.CHERRY_SAPLING.get(), "oak_sapling");
		buildSaplings(blockModels, FarmingRegistry.PEAR_SAPLING.get(), "oak_sapling");
		buildSaplings(blockModels, FarmingRegistry.BANANA_SAPLING.get(), "jungle_sapling");
		buildSaplings(blockModels, FarmingRegistry.AVOCADO_SAPLING.get(), "oak_sapling");
		buildSaplings(blockModels, FarmingRegistry.MANGO_SAPLING.get(), "oak_sapling");
		buildSaplings(blockModels, FarmingRegistry.OLIVE_SAPLING.get(), "acacia_sapling");

		buildLeaves(blockModels, FarmingRegistry.APPLE_LEAVES.get(), "oak_leaves", -12012264);
		buildLeaves(blockModels, FarmingRegistry.LEMON_LEAVES.get(), "oak_leaves", -12012264);
		buildLeaves(blockModels, FarmingRegistry.ORANGE_LEAVES.get(), "oak_leaves", -12012264);
		buildLeaves(blockModels, FarmingRegistry.CHERRY_LEAVES.get(), "oak_leaves", -12012264);
		buildLeaves(blockModels, FarmingRegistry.PEAR_LEAVES.get(), "oak_leaves", -12012264);
		buildLeaves(blockModels, FarmingRegistry.BANANA_LEAVES.get(), "jungle_leaves", -12012264);
		buildLeaves(blockModels, FarmingRegistry.AVOCADO_LEAVES.get(), "oak_leaves", -12012264);
		buildLeaves(blockModels, FarmingRegistry.MANGO_LEAVES.get(), "oak_leaves", -12012264);
		buildLeaves(blockModels, FarmingRegistry.OLIVE_LEAVES.get(), "acacia_leaves", -12012264);

		model(blockModels, FarmingRegistry.CROP_STICK.get());
		itemModels.generateFlatItem(FarmingRegistry.CROP_STICK.asItem(), ModelTemplates.FLAT_ITEM);

		blockModels.createNonTemplateHorizontalBlock(FarmingRegistry.SCARECROW.get());
		blockModels.registerSimpleItemModel(FarmingRegistry.SCARECROW.get(), EnhancedFarming.modLoc("block/scarecrow"));

		FarmingRegistry.ITEMS.getEntries()
				.forEach(holder -> {
					String path = holder.getId().getPath();
					if (!path.equals("scarecrow")) {
						if (holder.value() instanceof BlockItem) {
							return; // Skip block items, they will be handled by the block model generation
						}
						if (path.endsWith("_rake")) {
							itemModels.generateFlatItem(holder.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
						} else {
							itemModels.generateFlatItem(holder.get(), ModelTemplates.FLAT_ITEM);
						}
					}
				});
	}

	protected void model(BlockModelGenerators blockModels, Block block) {
		ResourceLocation model = BuiltInRegistries.BLOCK.getKey(block).withPrefix("block/");
		blockModels.blockStateOutput
				.accept(
						MultiVariantGenerator.multiVariant(
								block, Variant.variant().with(VariantProperties.MODEL, model)
						)
				);
	}

	private void createCropStickBlock(BlockModelGenerators blockModels, Block cropBlock, IntegerProperty ageProperty, int... ageToVisualStageMapping) {
		if (ageProperty.getPossibleValues().size() != ageToVisualStageMapping.length) {
			throw new IllegalArgumentException();
		} else {
			Int2ObjectMap<ResourceLocation> int2objectmap = new Int2ObjectOpenHashMap<>();
			PropertyDispatch propertydispatch = PropertyDispatch.property(ageProperty)
					.generate(
							p_388091_ -> {
								int i = ageToVisualStageMapping[p_388091_];
								ResourceLocation resourcelocation = int2objectmap.computeIfAbsent(
										i, p_387534_ -> blockModels.createSuffixedVariant(cropBlock, "_stage" + i, STICK_CROP, TextureMapping::crop)
								);
								return Variant.variant().with(VariantProperties.MODEL, resourcelocation);
							}
					);
			blockModels.registerSimpleFlatItemModel(cropBlock.asItem());
			blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(cropBlock).with(propertydispatch));
		}
	}

	protected void buildSaplings(BlockModelGenerators blockModels, GrowableSaplingBlock block, String base) {
		String path = BuiltInRegistries.BLOCK.getKey(block).getPath();
		ResourceLocation finalModel = CUTOUT_CROP.createWithSuffix(block, ("_" + block.getMatureStage()),
				TextureMapping.crop(
						EnhancedFarming.modLoc("block/saplings/" + path)),
				blockModels.modelOutput);

		var propertyDispatch = PropertyDispatch.property(block.getStageProperty());
		for (int i = 0; i <= block.getMatureStage(); i++) {
			if (i == block.getMatureStage()) {
				propertyDispatch.select(i, Variant.variant().with(
						VariantProperties.MODEL, finalModel)
				);
			} else {
				propertyDispatch.select(i, Variant.variant().with(
						VariantProperties.MODEL, CUTOUT_CROP.createWithSuffix(block, "_" + i,
								TextureMapping.crop(EnhancedFarming.modLoc("block/saplings/" + base + "_" + (i))), blockModels.modelOutput)
				));
			}
		}
		blockModels.blockStateOutput
				.accept(
						MultiVariantGenerator.multiVariant(block)
								.with(propertyDispatch)
				);

		ResourceLocation itemModel = ModelTemplates.FLAT_ITEM.create(ModelLocationUtils.getModelLocation(block.asItem()),
				TextureMapping.layer0(
						EnhancedFarming.modLoc("block/saplings/" + path)
				), blockModels.modelOutput);
		blockModels.registerSimpleItemModel(block, itemModel);
	}

	protected void buildLeaves(BlockModelGenerators blockModels, FruitLeavesBlock block, String originalLeaves, int tint) {
		ResourceLocation bloomingModel = LEAVE_OVERLAY.createWithSuffix(block, "_blooming",
				TextureMapping.singleSlot(TextureSlot.LAYER1,
						EnhancedFarming.modLoc("block/leaves/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + "_blooming")
				).put(
						TextureSlot.LAYER0,
						ResourceLocation.withDefaultNamespace("block/" + originalLeaves)
				),
				blockModels.modelOutput);
		ResourceLocation fruityModel = LEAVE_OVERLAY.createWithSuffix(block, "_fruity",
				TextureMapping.singleSlot(TextureSlot.LAYER1,
						EnhancedFarming.modLoc("block/leaves/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + "_fruity")
				).put(
						TextureSlot.LAYER0,
						ResourceLocation.withDefaultNamespace("block/" + originalLeaves)
				),
				blockModels.modelOutput);
		var propertyDispatch = PropertyDispatch.property(block.getAgeProperty());
		for (int i = 0; i <= block.getMaxAge(); i++) {
			if (i != block.getMaxAge()) {
				propertyDispatch.select(i, Variant.variant().with(
						VariantProperties.MODEL, bloomingModel
				));
			} else {
				propertyDispatch.select(i, Variant.variant().with(
						VariantProperties.MODEL, fruityModel
				));
			}
		}
		blockModels.blockStateOutput
				.accept(
						MultiVariantGenerator.multiVariant(block)
								.with(propertyDispatch)
				);
		blockModels.registerSimpleTintedItemModel(block, fruityModel, ItemModelUtils.constantTint(tint));
	}
}
