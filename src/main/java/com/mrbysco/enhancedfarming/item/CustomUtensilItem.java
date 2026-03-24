package com.mrbysco.enhancedfarming.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import org.jspecify.annotations.Nullable;

public class CustomUtensilItem extends Item {

	public CustomUtensilItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public @Nullable ItemStackTemplate getCraftingRemainder(ItemInstance instance) {
		return new ItemStackTemplate(instance.typeHolder(), instance.count());
	}
}
