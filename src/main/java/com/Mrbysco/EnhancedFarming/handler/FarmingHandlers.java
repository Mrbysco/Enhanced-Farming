package com.Mrbysco.EnhancedFarming.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.init.FarmingItems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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

		if(entity instanceof EntityCow && itemstack.getItem() == Items.GLASS_BOTTLE && !player.capabilities.isCreativeMode)
		{
			EntityCow cow = (EntityCow)entity;
			if(!cow.isChild())
			{
				player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
	            itemstack.shrink(1);

	            if (itemstack.isEmpty() && hand != null)
	            {
	                player.setHeldItem(hand, new ItemStack(FarmingItems.milk_bottle));
	            }
	            else if (!player.inventory.addItemStackToInventory(new ItemStack(FarmingItems.milk_bottle)))
	            {
	                player.dropItem(new ItemStack(FarmingItems.milk_bottle), false);
	            }
			}
		}
	}
	
	public Item itemHeld;
	private int heldTime;
	private Random rand;

	@SubscribeEvent
	public void ItemHeld(TickEvent.PlayerTickEvent event) {
		if (event.phase.equals(TickEvent.Phase.START) && event.side.isServer())
		{
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
	
	@SubscribeEvent
	public void InWorldCrafting(TickEvent.PlayerTickEvent event) {
		if (event.phase.equals(TickEvent.Phase.START) && event.side.isServer())
		{
			EntityPlayer player = event.player;
			World world = player.world;
			ItemStack oilStack = new ItemStack(FarmingItems.olive_oil);

			List<Entity> entitylist = player.world.loadedEntityList;
			
			for (Entity entity : entitylist)
			{
				if (entity instanceof EntityItem) {
					EntityItem itemEntity = (EntityItem) entity;
					ItemStack stack = itemEntity.getItem();
					Item item = stack.getItem();
					
					if(item == FarmingItems.olive)
					{
						BlockPos pos = entity.getPosition();
						Block block = world.getBlockState(pos).getBlock();
						Block blockDown = world.getBlockState(pos.down()).getBlock();
						
						Double posY = itemEntity.posY;
						int yInt = posY.intValue();
						
						if (block == Blocks.PISTON_HEAD && posY < yInt + 0.25 && blockDown != Blocks.PISTON)
						{
							if(!world.isRemote)
							{
								oilStack.setCount(stack.getCount());
								
								itemEntity.setItem(oilStack);
							}
						}
					}
				}
			}	
		}
	}
}
