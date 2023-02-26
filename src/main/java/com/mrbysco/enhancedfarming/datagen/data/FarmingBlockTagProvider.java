package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class FarmingBlockTagProvider extends BlockTagsProvider {
	public FarmingBlockTagProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
		super(dataGenerator, Reference.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(FarmingTags.RAKE_BLOCKS).add(
				Blocks.PODZOL, Blocks.GRASS_BLOCK, Blocks.MYCELIUM
		);

		this.tag(BlockTags.CROPS).add(FarmingRegistry.MINT_CROP.get(), FarmingRegistry.NETHER_FLOWER_CROP.get(),
				FarmingRegistry.TOMATO_CROP.get(), FarmingRegistry.CUCUMBER_CROP.get(), FarmingRegistry.AUBERGINE_CROP.get(),
				FarmingRegistry.GRAPE_CROP.get(), FarmingRegistry.PINEAPPLE_CROP.get(), FarmingRegistry.CORN_CROP.get(),
				FarmingRegistry.ONION_CROP.get(), FarmingRegistry.GARLIC_CROP.get(), FarmingRegistry.LETTUCE_CROP.get());
		this.tag(BlockTags.SAPLINGS).add(FarmingRegistry.APPLE_SAPLING.get(), FarmingRegistry.LEMON_SAPLING.get(),
				FarmingRegistry.ORANGE_SAPLING.get(), FarmingRegistry.CHERRY_SAPLING.get(), FarmingRegistry.PEAR_SAPLING.get(),
				FarmingRegistry.BANANA_SAPLING.get(), FarmingRegistry.AVOCADO_SAPLING.get(), FarmingRegistry.MANGO_SAPLING.get(),
				FarmingRegistry.OLIVE_SAPLING.get()
		);
		this.tag(BlockTags.LEAVES).add(FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.LEMON_LEAVES.get(),
				FarmingRegistry.ORANGE_LEAVES.get(), FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.PEAR_LEAVES.get(),
				FarmingRegistry.BANANA_LEAVES.get(), FarmingRegistry.AVOCADO_LEAVES.get(), FarmingRegistry.MANGO_LEAVES.get(),
				FarmingRegistry.OLIVE_LEAVES.get()
		);


	}
}