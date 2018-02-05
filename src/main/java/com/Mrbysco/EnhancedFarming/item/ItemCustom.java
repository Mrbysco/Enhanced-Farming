package com.Mrbysco.EnhancedFarming.item;

import com.Mrbysco.EnhancedFarming.EnhancedFarming;
import com.Mrbysco.EnhancedFarming.Reference;

import net.minecraft.item.Item;

public class ItemCustom extends Item{
	
	public ItemCustom(String registryName) {
		setCreativeTab(EnhancedFarming.tabFarming);
		this.setUnlocalizedName(Reference.MOD_PREFIX + registryName.replaceAll("_", ""));
		this.setRegistryName(registryName);
	}

}
