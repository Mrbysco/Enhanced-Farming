package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class FarmingTags {
	public static final IOptionalNamedTag<Item> HOT_ITEMS = itemTag("hot_items");
	public static final IOptionalNamedTag<Block> RAKE_BLOCKS = blockTag("rake_blocks");

	private static IOptionalNamedTag<Item> itemTag(String name) {
		return ItemTags.createOptional(new ResourceLocation(Reference.MOD_ID, name));
	}

	private static IOptionalNamedTag<Block> blockTag(String name) {
		return BlockTags.createOptional(new ResourceLocation(Reference.MOD_ID, name));
	}
}
