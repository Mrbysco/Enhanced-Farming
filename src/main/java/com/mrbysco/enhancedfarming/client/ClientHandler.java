package com.mrbysco.enhancedfarming.client;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler {
	public static void onClientSetup(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.APPLE_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.LEMON_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.ORANGE_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.CHERRY_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.PEAR_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.BANANA_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.AVOCADO_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.MANGO_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.OLIVE_SAPLING.get(), RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.APPLE_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.LEMON_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.ORANGE_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.CHERRY_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.PEAR_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.BANANA_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.AVOCADO_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.MANGO_LEAVES.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.OLIVE_LEAVES.get(), RenderType.cutoutMipped());

		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.MINT_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.NETHER_FLOWER_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.TOMATO_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.CUCUMBER_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.AUBERGINE_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.GRAPE_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.PINEAPPLE_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.CORN_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.ONION_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.GARLIC_CROP.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(FarmingRegistry.LETTUCE_CROP.get(), RenderType.cutout());
	}

	public static void registerBlockColors(final ColorHandlerEvent.Item event) {
		BlockColors blockColors = event.getBlockColors();
		ItemColors itemColors = event.getItemColors();

		blockColors.register((state, reader, pos, tintIndex) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColor.getDefaultColor(),
				FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.ORANGE_LEAVES.get(),
				FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.AVOCADO_LEAVES.get(),
				FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.BANANA_LEAVES.get());


		itemColors.register((stack, tintIndex) -> {
					BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
					return blockColors.getColor(blockstate, (BlockAndTintGetter)null, (BlockPos)null, tintIndex);
				}, FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.ORANGE_LEAVES.get(),
				FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.AVOCADO_LEAVES.get(),
				FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.BANANA_LEAVES.get());
	}
}
