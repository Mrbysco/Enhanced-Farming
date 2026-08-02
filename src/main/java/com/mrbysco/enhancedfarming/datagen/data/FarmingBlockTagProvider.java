package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class FarmingBlockTagProvider extends BlockTagsProvider {
	public FarmingBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, EnhancedFarming.MOD_ID);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(FarmingTags.RAKE_BLOCKS).add(
				Blocks.PODZOL.builtInRegistryHolder().key(), Blocks.GRASS_BLOCK.builtInRegistryHolder().key(), Blocks.MYCELIUM.builtInRegistryHolder().key()
		);

		this.tag(BlockTags.CROPS).add(FarmingRegistry.MINT_CROP.getKey(), FarmingRegistry.NETHER_FLOWER_CROP.getKey(),
				FarmingRegistry.TOMATO_CROP.getKey(), FarmingRegistry.CUCUMBER_CROP.getKey(), FarmingRegistry.AUBERGINE_CROP.getKey(),
				FarmingRegistry.GRAPE_CROP.getKey(), FarmingRegistry.PINEAPPLE_CROP.getKey(), FarmingRegistry.CORN_CROP.getKey(),
				FarmingRegistry.ONION_CROP.getKey(), FarmingRegistry.GARLIC_CROP.getKey(), FarmingRegistry.LETTUCE_CROP.getKey());
		this.tag(BlockItemTags.SAPLINGS.block()).add(FarmingRegistry.APPLE_SAPLING.getKey(), FarmingRegistry.LEMON_SAPLING.getKey(),
				FarmingRegistry.ORANGE_SAPLING.getKey(), FarmingRegistry.CHERRY_SAPLING.getKey(), FarmingRegistry.PEAR_SAPLING.getKey(),
				FarmingRegistry.BANANA_SAPLING.getKey(), FarmingRegistry.AVOCADO_SAPLING.getKey(), FarmingRegistry.MANGO_SAPLING.getKey(),
				FarmingRegistry.OLIVE_SAPLING.getKey()
		);
		this.tag(BlockTags.LEAVES).add(FarmingRegistry.APPLE_LEAVES.getKey(), FarmingRegistry.LEMON_LEAVES.getKey(),
				FarmingRegistry.ORANGE_LEAVES.getKey(), FarmingRegistry.CHERRY_LEAVES.getKey(), FarmingRegistry.PEAR_LEAVES.getKey(),
				FarmingRegistry.BANANA_LEAVES.getKey(), FarmingRegistry.AVOCADO_LEAVES.getKey(), FarmingRegistry.MANGO_LEAVES.getKey(),
				FarmingRegistry.OLIVE_LEAVES.getKey()
		);


	}
}