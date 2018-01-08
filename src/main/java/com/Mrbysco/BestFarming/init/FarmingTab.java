package com.Mrbysco.BestFarming.init;

import com.Mrbysco.BestFarming.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class FarmingTab extends CreativeTabs{

	public FarmingTab() {
		super(Reference.MOD_ID);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(FarmingItems.lemon);
	}
}
