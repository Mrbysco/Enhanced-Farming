package com.mrbysco.enhancedfarming.item;

import com.mrbysco.enhancedfarming.init.FarmingTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

import java.util.Arrays;
import java.util.Collection;

public class CustomFoodItem extends Item {

	private UseAction action;
	private int useTime;

	public CustomFoodItem(Item.Properties properties, int useTime, UseAction action) {
		super(properties);
		this.action = action;
		this.useTime = useTime;
	}

	public CustomFoodItem(Item.Properties properties, int useTime) {
		this(properties, useTime, UseAction.EAT);
	}

	@Override
	public Collection<ItemGroup> getCreativeTabs() {
		return Arrays.asList(ItemGroup.TAB_FOOD, FarmingTabs.TAB_MAIN);
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return this.useTime;
	}

	@Override
	public UseAction getUseAnimation(ItemStack stack) {
		return this.action;
	}
}
