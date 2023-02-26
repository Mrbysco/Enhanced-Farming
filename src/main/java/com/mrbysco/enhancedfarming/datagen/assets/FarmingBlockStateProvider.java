package com.mrbysco.enhancedfarming.datagen.assets;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.block.FruitLeavesBlock;
import com.mrbysco.enhancedfarming.block.GrowableSaplingBlock;
import com.mrbysco.enhancedfarming.block.crops.CropstickCropBlock;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class FarmingBlockStateProvider extends BlockStateProvider {

	public FarmingBlockStateProvider(DataGenerator gen, ExistingFileHelper helper) {
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