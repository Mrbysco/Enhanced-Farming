package com.Mrbysco.EnhancedFarming.item;

import com.Mrbysco.EnhancedFarming.EnhancedFarming;
import com.Mrbysco.EnhancedFarming.Reference;

import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemCustomFood extends ItemFood{

	public boolean drinkable;
	private boolean enchanted = false; 
	private int useTime;
	
	public ItemCustomFood(int amount, float saturation, boolean isWolfFood, int stacksize, int useTime, boolean enchanted, String unlocalizedName, String registryName) {
		super(amount, saturation, isWolfFood);
		this.maxStackSize=stacksize;
		setCreativeTab(EnhancedFarming.tabFarming);
		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
		
		this.drinkable = false;		
		this.enchanted = enchanted;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return this.useTime;
	}
	
	public ItemCustomFood setDrinkable(){
		this.drinkable = true;
		return this;
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return this.enchanted;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
		if(this.drinkable = true)
		{
			return EnumAction.DRINK;
		}
		else
		{
			return EnumAction.EAT;
		}
    }
	
	public ItemCustomFood setContaining(Item item) {
		return (ItemCustomFood) this.setContainerItem(item);
    }
}
