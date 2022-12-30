package com.mrbysco.enhancedfarming.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class CustomFoodItem extends Item {

	private final UseAnim action;
	private final int useTime;

	public CustomFoodItem(Item.Properties properties, int useTime, UseAnim action) {
		super(properties);
		this.action = action;
		this.useTime = useTime;
	}

	public CustomFoodItem(Item.Properties properties, int useTime) {
		this(properties, useTime, UseAnim.EAT);
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return this.useTime;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return this.action;
	}
}
