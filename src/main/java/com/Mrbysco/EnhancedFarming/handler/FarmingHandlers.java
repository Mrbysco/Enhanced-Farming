package com.Mrbysco.EnhancedFarming.handler;

import java.util.ArrayList;
import java.util.Random;

import com.Mrbysco.EnhancedFarming.init.FarmingItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
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

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void ItemHeld(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		
		Item heldItem = player.getHeldItemMainhand() != ItemStack.EMPTY
				? player.getHeldItemOffhand().getItem() : null; 

		ArrayList<Item> hotItems = new ArrayList<>();
		hotItems.add(FarmingItems.hot_water);
		hotItems.add(FarmingItems.hot_chocolate_bottle);
		hotItems.add(FarmingItems.mint_tea);
		
		for (Item item : hotItems) {
			if (itemHeld != heldItem && itemHeld == item) 
			{
				int timeHeld = this.heldTime + 1;
				this.heldTime = timeHeld;
				
				if(timeHeld == 5 * 20){
	                player.setFire(5);
	                
	                this.heldTime = 0;
				}
			}
		}

		itemHeld = heldItem;
	}
}
