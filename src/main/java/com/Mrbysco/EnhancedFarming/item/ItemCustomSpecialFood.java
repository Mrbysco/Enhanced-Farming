package com.Mrbysco.EnhancedFarming.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemCustomSpecialFood extends ItemCustomFood{
	
	private boolean enchanted;
	private boolean directheal; 
	private boolean cure;
	private int amount;

	public ItemCustomSpecialFood(int amount, float saturation, int stacksize, int useTime,
			boolean enchanted, boolean directHeal, boolean cureEffects, String registryName) {
		super(amount, saturation, stacksize, useTime, registryName);
		
		this.directheal = directHeal;
		this.amount = amount;
		this.enchanted = enchanted;
		this.cure = cureEffects;
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (!worldIn.isRemote && cure) entityLiving.curePotionEffects(stack);
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            
            if (this.directheal)
            {
            	entityplayer.heal(this.amount);
            }
            else
            {
                this.onFoodEaten(stack, worldIn, entityplayer);	
            }

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
	public boolean hasEffect(ItemStack stack) {
		if(this.enchanted)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
