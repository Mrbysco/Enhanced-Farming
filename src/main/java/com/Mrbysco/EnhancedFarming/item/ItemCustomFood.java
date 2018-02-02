package com.Mrbysco.EnhancedFarming.item;

import com.Mrbysco.EnhancedFarming.EnhancedFarming;
import com.Mrbysco.EnhancedFarming.Reference;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemCustomFood extends ItemFood{

	public boolean drinkable;
	//private boolean enchanted; 
	private int useTime;
	
	public ItemCustomFood(int amount, float saturation, int stacksize, int useTime, String unlocalizedName, String registryName) {
		super(amount, saturation, false);
		this.maxStackSize=stacksize;
		setCreativeTab(EnhancedFarming.tabFarming);
		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
		
		this.useTime = useTime;
		this.drinkable = false;		
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.getObjectUseStats(this));

            if (entityplayer instanceof EntityPlayerMP)
            {
                CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
            }
        }
        
        stack.shrink(1);
        return stack;
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
	
	@Override
	public ItemFood setAlwaysEdible() {
		return super.setAlwaysEdible();
	}
}
