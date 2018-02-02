package com.Mrbysco.EnhancedFarming.item;

import com.Mrbysco.EnhancedFarming.EnhancedFarming;
import com.Mrbysco.EnhancedFarming.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCustomUtensil extends Item{
	
	public ItemCustomUtensil(String unlocalizedName, String registryName) {
		setCreativeTab(EnhancedFarming.tabFarming);
		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		ItemStack stack = itemStack.copy();
		return stack;
	}
	
	@Override
	public boolean hasContainerItem() {
		return true;
	}
}
