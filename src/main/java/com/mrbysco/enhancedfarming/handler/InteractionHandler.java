package com.mrbysco.enhancedfarming.handler;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class InteractionHandler {
	@SubscribeEvent
	public void CowInteraction(EntityInteract event) {
		Player player = event.getEntity();
		ItemStack itemstack = event.getItemStack();
		Entity entity = event.getTarget();

		if (entity instanceof Cow cow && itemstack.getItem() == Items.GLASS_BOTTLE && !player.getAbilities().instabuild) {
			if (!cow.isBaby()) {
				player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
				itemstack.shrink(1);

				ItemStack milkStack = new ItemStack(FarmingRegistry.MILK_BOTTLE.get());
				InteractionHand hand = player.getUsedItemHand();
				if (itemstack.isEmpty()) {
					player.setItemInHand(hand, milkStack);
				} else if (!player.getInventory().add(milkStack)) {
					player.spawnAtLocation(milkStack, 0.0F);
				}
			}
		}
	}
}
