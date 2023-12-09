package com.mrbysco.enhancedfarming.client;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

public class ClientHandler {

	public static void registerBlockColors(final RegisterColorHandlersEvent.Block event) {
		event.register((state, reader, pos, tintIndex) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor(),
				FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.ORANGE_LEAVES.get(),
				FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.AVOCADO_LEAVES.get(),
				FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.BANANA_LEAVES.get());
	}

	public static void registerItemColors(final RegisterColorHandlersEvent.Item event) {
		event.register((stack, tintIndex) -> {
					BlockState blockstate = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
					return event.getBlockColors().getColor(blockstate, (BlockAndTintGetter) null, (BlockPos) null, tintIndex);
				}, FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.ORANGE_LEAVES.get(),
				FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.AVOCADO_LEAVES.get(),
				FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.BANANA_LEAVES.get());
	}
}
