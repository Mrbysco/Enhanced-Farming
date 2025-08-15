package com.mrbysco.enhancedfarming.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CustomUtensilItem extends Item {

	public CustomUtensilItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack getCraftingRemainder(ItemStack itemStack) {
		return itemStack.copy();
	}
}
