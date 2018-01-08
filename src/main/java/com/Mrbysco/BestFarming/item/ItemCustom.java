package com.Mrbysco.BestFarming.item;

import com.Mrbysco.BestFarming.BestFarming;
import com.Mrbysco.BestFarming.Reference;

import net.minecraft.item.Item;

public class ItemCustom extends Item{
	
	public ItemCustom(String unlocalizedName, String registryName) {
		setCreativeTab(BestFarming.tabFarming);
		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
	}

}
