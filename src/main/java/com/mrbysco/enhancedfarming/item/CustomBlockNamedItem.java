package com.mrbysco.enhancedfarming.item;

import com.mrbysco.enhancedfarming.init.FarmingTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.Collection;

public class CustomBlockNamedItem extends ItemNameBlockItem {
	public CustomBlockNamedItem(Block block, Properties properties) {
		super(block, properties);
	}

	@Override
	public Collection<CreativeModeTab> getCreativeTabs() {
		return Arrays.asList(CreativeModeTab.TAB_FOOD, FarmingTabs.TAB_MAIN);
	}
}
