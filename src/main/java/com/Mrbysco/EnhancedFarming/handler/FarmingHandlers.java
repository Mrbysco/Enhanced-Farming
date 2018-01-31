package com.Mrbysco.EnhancedFarming.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.Mrbysco.EnhancedFarming.block.crops.BlockCropstickCrop;
import com.Mrbysco.EnhancedFarming.block.crops.BlockNetherFlower;
import com.Mrbysco.EnhancedFarming.block.crops.BlockRegularCrop;
import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.init.FarmingItems;

import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FarmingHandlers {
	
	@SubscribeEvent
	public void CowInteraction(EntityInteract event) {
		EntityPlayer player = event.getEntityPlayer();
		ItemStack itemstack = event.getItemStack();
		EnumHand hand = player.getActiveHand();
		
		Entity entity = event.getTarget();

		if(entity instanceof EntityCow && itemstack.getItem() == Items.GLASS_BOTTLE)
		{
			player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            itemstack.shrink(1);

            if (itemstack.isEmpty())
            {
                player.setHeldItem(hand, new ItemStack(FarmingItems.milk_bottle));
            }
            else if (!player.inventory.addItemStackToInventory(new ItemStack(FarmingItems.milk_bottle)))
            {
                player.dropItem(new ItemStack(FarmingItems.milk_bottle), false);
            }
		}
	}
	
	public Item itemHeld;
	private int heldTime;
	private Random rand;

	@SubscribeEvent
	public void ItemHeld(TickEvent.PlayerTickEvent event) {
		if (FarmingConfigGen.general.othersettings.tooHot)
		{
			EntityPlayer player = event.player;
			
			if (player.world.isRemote)
			    return;
			
			Item heldItem = null;
			
			if (!player.getHeldItemMainhand().isEmpty())
			{
				heldItem = player.getHeldItemMainhand().getItem();
			}
			if (!player.getHeldItemOffhand().isEmpty())
			{
				heldItem = player.getHeldItemOffhand().getItem();
			}
	
			ArrayList<Item> hotItems = new ArrayList<>();
			hotItems.add(FarmingItems.hot_water);
			hotItems.add(FarmingItems.hot_chocolate_bottle);
			hotItems.add(FarmingItems.mint_tea);
			
			for (Item item : hotItems) 
			{
			    if (itemHeld != heldItem && heldItem == item) 
			    {
			        this.heldTime = 0;
			        itemHeld = heldItem;
			    }
			    
			    if (itemHeld == item)
			    {
			        int timeHeld = ++this.heldTime;

			        if(timeHeld == 300)
			        {
			            player.setFire(5);
			            this.heldTime = 0;
			        }
			    }
			}
	
			this.itemHeld = heldItem;
		}
	}
}
