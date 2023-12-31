package com.mrbysco.enhancedfarming.handler;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.bus.api.SubscribeEvent;

public class HotHandler {
	private static final String HOT = EnhancedFarming.MOD_ID + ":hotCounter";

	@SubscribeEvent
	public void ItemHeld(TickEvent.PlayerTickEvent event) {
		if (event.phase.equals(TickEvent.Phase.START) && event.side.isServer() && FarmingConfig.COMMON.hotBurnsPlayer.get()) {
			final Player player = event.player;
			if (player.level().getGameTime() % 20 == 0) {
				CompoundTag tag = player.getPersistentData();
				ItemStack mainHeldStack = player.getMainHandItem();
				ItemStack offHeldStack = player.getOffhandItem();

				if (mainHeldStack.is(FarmingTags.HOT_ITEMS) || offHeldStack.is(FarmingTags.HOT_ITEMS)) {
					if (tag.contains(HOT)) {
						int currentTimer = tag.getInt(HOT);
						if (currentTimer < FarmingConfig.COMMON.hotTime.get()) {
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
