package com.mrbysco.enhancedfarming.handler;

import com.mrbysco.enhancedfarming.init.FarmingActions;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.world.BlockEvent.BlockToolInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RakeHandler {
	@SubscribeEvent
	public void onToolUse(BlockToolInteractEvent event) {
		if(event.getToolAction() == FarmingActions.RAKE_GATHER) {
			BlockState state = event.getState();
			if(state.is(FarmingTags.RAKE_BLOCKS)) {
				event.setFinalState(Blocks.DIRT.defaultBlockState());
			}
		}
	}
}
