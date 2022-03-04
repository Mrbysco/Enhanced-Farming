package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FarmingTags {
	public static final TagKey<Item> HOT_ITEMS = ItemTags.create(new ResourceLocation(Reference.MOD_ID, "hot_items"));
	public static final TagKey<Block> RAKE_BLOCKS = BlockTags.create(new ResourceLocation(Reference.MOD_ID, "rake_blocks"));
}
