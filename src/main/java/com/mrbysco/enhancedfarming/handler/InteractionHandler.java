package com.mrbysco.enhancedfarming.handler;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class InteractionHandler {
	@SubscribeEvent
	public void CowInteraction(EntityInteract event) {
		PlayerEntity player = event.getPlayer();
		ItemStack itemstack = event.getItemStack();
		Entity entity = event.getTarget();

		if(entity instanceof CowEntity && itemstack.getItem() == Items.GLASS_BOTTLE && !player.abilities.instabuild) {
			CowEntity cow = (CowEntity)entity;
			if(!cow.isBaby()) {
				player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
	            itemstack.shrink(1);

	            ItemStack milkStack = new ItemStack(FarmingRegistry.MILK_BOTTLE.get());
				Hand hand = player.getUsedItemHand();
	            if (itemstack.isEmpty()) {
	                player.setItemInHand(hand, milkStack);
	            } else if (!player.inventory.add(milkStack)) {
	                player.spawnAtLocation(milkStack, 0.0F);
	            }
			}
		}
	}
}
