package com.mrbysco.enhancedfarming.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;

public class CustomFoodItem extends Item {

	private final ItemUseAnimation action;
	private final int useTime;

	public CustomFoodItem(Item.Properties properties, int useTime, ItemUseAnimation action) {
		super(properties);
		this.action = action;
		this.useTime = useTime;
	}

	public CustomFoodItem(Item.Properties properties, int useTime) {
		this(properties, useTime, ItemUseAnimation.EAT);
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity livingEntity) {
		return this.useTime;
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack stack) {
		return this.action;
	}
}
