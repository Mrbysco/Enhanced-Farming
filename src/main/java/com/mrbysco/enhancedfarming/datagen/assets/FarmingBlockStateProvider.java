package com.mrbysco.enhancedfarming.datagen.assets;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.block.FruitLeavesBlock;
import com.mrbysco.enhancedfarming.block.GrowableSaplingBlock;
import com.mrbysco.enhancedfarming.block.crops.CropstickCropBlock;
import com.mrbysco.enhancedfarming.block.crops.FiveAgeCropBlock;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.block.crops.SevenAgeCropBlock;
import com.mrbysco.enhancedfarming.block.crops.SixAgeCropBlock;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FarmingBlockStateProvider extends BlockStateProvider {

	public FarmingBlockStateProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, Reference.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		buildCrops((CropBlock) FarmingRegistry.MINT_CROP.get(), FiveAgeCropBlock.AGE);
		buildNetherCrops((NetherFlowerBlock) FarmingRegistry.NETHER_FLOWER_CROP.get());
		buildCrops((CropBlock) FarmingRegistry.TOMATO_CROP.get(), SixAgeCropBlock.AGE);
		buildCrops((CropBlock) FarmingRegistry.CUCUMBER_CROP.get(), FiveAgeCropBlock.AGE);
		buildCrops((CropBlock) FarmingRegistry.AUBERGINE_CROP.get(), FiveAgeCropBlock.AGE);
		buildStickCropCrops((CropstickCropBlock) FarmingRegistry.GRAPE_CROP.get());
		buildCrops((CropBlock) FarmingRegistry.PINEAPPLE_CROP.get(), FiveAgeCropBlock.AGE);
		buildCrops((CropBlock) FarmingRegistry.CORN_CROP.get(), SevenAgeCropBlock.AGE);
		buildCrops((CropBlock) FarmingRegistry.ONION_CROP.get(), FiveAgeCropBlock.AGE);
		buildCrops((CropBlock) FarmingRegistry.GARLIC_CROP.get(), FiveAgeCropBlock.AGE);
		buildCrops((CropBlock) FarmingRegistry.LETTUCE_CROP.get(), FiveAgeCropBlock.AGE);

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
		ModelFile file = models().getExistingFile(BuiltInRegistries.BLOCK.getKey(block));
		getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(file).build());
	}

	protected void buildNetherCrops(NetherFlowerBlock block) {
		VariantBlockStateBuilder builder = getVariantBuilder(block);
		for (int i = 0; i <= block.getMaxAge(); i++) {
			ModelFile file = models().crop(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + (i),
					new ResourceLocation(Reference.MOD_ID, "block/crops/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + (i))).renderType(new ResourceLocation("cutout"));
			builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
		}
	}

	protected void buildCrops(CropBlock block, IntegerProperty property) {
		VariantBlockStateBuilder builder = getVariantBuilder(block);
		for (int i = 0; i <= block.getMaxAge(); i++) {
			ModelFile file = models().crop(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + (i),
					new ResourceLocation(Reference.MOD_ID, "block/crops/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + (i))).renderType(new ResourceLocation("cutout"));
			builder.partialState().with(property, i).modelForState().modelFile(file).addModel();
		}
	}

	protected void buildStickCropCrops(CropstickCropBlock block) {
		VariantBlockStateBuilder builder = getVariantBuilder(block);
		for (int i = 0; i <= block.getMaxAge(); i++) {
			ModelFile file = models().singleTexture(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + (i), modLoc("block/stick_crops"), "crop",
					new ResourceLocation(Reference.MOD_ID, "block/crops/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + (i))).renderType(new ResourceLocation("cutout"));
			builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
		}
	}

	protected void buildSaplings(GrowableSaplingBlock block, String base) {
		VariantBlockStateBuilder builder = getVariantBuilder(block);
		for (int i = 0; i <= block.getMatureStage(); i++) {
			if (i == block.getMatureStage()) {
				ModelFile file = models().crop(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + (i),
						new ResourceLocation(Reference.MOD_ID, "block/saplings/" + BuiltInRegistries.BLOCK.getKey(block).getPath())).renderType(new ResourceLocation("cutout"));
				builder.partialState().with(block.getStageProperty(), i).modelForState().modelFile(file).addModel();
			} else {
				ModelFile file = models().crop(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_" + (i),
						new ResourceLocation(Reference.MOD_ID, "block/saplings/" + base + "_" + (i))).renderType(new ResourceLocation("cutout"));
				builder.partialState().with(block.getStageProperty(), i).modelForState().modelFile(file).addModel();
			}
		}
	}

	protected void buildLeaves(FruitLeavesBlock block, String originalLeaves) {
		VariantBlockStateBuilder builder = getVariantBuilder(block);
		for (int i = 0; i <= block.getMaxAge(); i++) {
			if (i != block.getMaxAge()) {
				ModelFile file = models().singleTexture(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_blooming", modLoc("block/leave_overlay"), "layer1",
						new ResourceLocation(Reference.MOD_ID, "block/leaves/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + "_blooming")).texture("layer0", mcLoc("block/" + originalLeaves)).renderType(new ResourceLocation("cutout_mipped"));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			} else {
				ModelFile file = models().singleTexture(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_fruity", modLoc("block/leave_overlay"), "layer1",
						new ResourceLocation(Reference.MOD_ID, "block/leaves/" + BuiltInRegistries.BLOCK.getKey(block).getPath() + "_fruity")).texture("layer0", mcLoc("block/" + originalLeaves)).renderType(new ResourceLocation("cutout_mipped"));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}
	}
}