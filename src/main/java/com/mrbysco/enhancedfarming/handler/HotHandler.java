package com.mrbysco.enhancedfarming.handler;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class HotHandler {
	private static final String HOT = Reference.MOD_ID + ":hotCounter";
	@SubscribeEvent
	public void ItemHeld(TickEvent.PlayerTickEvent event) {
		if (event.phase.equals(TickEvent.Phase.START) && event.side.isServer() && FarmingConfig.COMMON.hotBurnsPlayer.get()) {
			final PlayerEntity player = event.player;
			if (player.level.getGameTime() % 20 == 0) {
				CompoundNBT tag = player.getPersistentData();
				ItemStack mainHeldStack = player.getMainHandItem();
				ItemStack offHeldStack = player.getOffhandItem();

				if(mainHeldStack.getItem().is(FarmingTags.HOT_ITEMS) || offHeldStack.getItem().is(FarmingTags.HOT_ITEMS)) {
					if(tag.contains(HOT)) {
						int currentTimer = tag.getInt(HOT);
						if(currentTimer < FarmingConfig.COMMON.hotTime.get()) {
							tag.putInt(HOT, currentTimer + 1);
						} else {
							player.setSecondsOnFire(5);
							tag.remove(HOT);
						}
					} else {
						tag.putInt(HOT, 1);
					}
				}
			}
		}
	}
}
