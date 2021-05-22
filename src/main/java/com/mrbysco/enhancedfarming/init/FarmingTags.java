package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.Reference;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags.IOptionalNamedTag;

public class FarmingTags {
	public static final IOptionalNamedTag<Item> HOT_ITEMS = tag("hot_items");

	private static IOptionalNamedTag<Item> tag(String name) {
		return ItemTags.createOptional(new ResourceLocation(Reference.MOD_ID, name));
	}
}
