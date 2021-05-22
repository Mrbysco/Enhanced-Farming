package com.mrbysco.enhancedfarming.item;

import com.mrbysco.enhancedfarming.init.FarmingTabs;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemGroup;

import java.util.Arrays;
import java.util.Collection;

public class CustomBlockNamedItem extends BlockNamedItem {
	public CustomBlockNamedItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public Collection<ItemGroup> getCreativeTabs() {
		return Arrays.asList(ItemGroup.TAB_FOOD, FarmingTabs.TAB_MAIN);
	}
}
