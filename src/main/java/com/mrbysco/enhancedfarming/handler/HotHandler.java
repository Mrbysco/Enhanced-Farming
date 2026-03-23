package com.mrbysco.enhancedfarming.handler;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class HotHandler {
	private static final String HOT = EnhancedFarming.MOD_ID + ":hotCounter";

	@SubscribeEvent
	public void ItemHeld(PlayerTickEvent.Pre event) {
		final Player player = event.getEntity();
		if (!player.level().isClientSide() && FarmingConfig.COMMON.hotBurnsPlayer.get()) {
			if (player.level().getGameTime() % 20 == 0) {
				CompoundTag tag = player.getPersistentData();
				ItemStack mainHeldStack = player.getMainHandItem();
				ItemStack offHeldStack = player.getOffhandItem();

				if (mainHeldStack.is(FarmingTags.HOT_ITEMS) || offHeldStack.is(FarmingTags.HOT_ITEMS)) {
					if (tag.contains(HOT)) {
						int currentTimer = tag.getIntOr(HOT, 0);
						if (currentTimer < FarmingConfig.COMMON.hotTime.get()) {
							tag.putInt(HOT, currentTimer + 1);
						} else {
							player.setRemainingFireTicks(5 * 20);
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
