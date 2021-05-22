package com.mrbysco.enhancedfarming.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CustomUtensilItem extends Item {
	
	public CustomUtensilItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		ItemStack stack = itemStack.copy();
		return stack;
	}

	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return true;
	}
}
