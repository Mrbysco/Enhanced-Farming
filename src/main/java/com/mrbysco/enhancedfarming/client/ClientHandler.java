package com.mrbysco.enhancedfarming.client;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientHandler {
	public static void onClientSetup(final FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(FarmingRegistry.APPLE_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.LEMON_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.ORANGE_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.CHERRY_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.PEAR_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.BANANA_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.AVOCADO_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.MANGO_SAPLING.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.OLIVE_SAPLING.get(), RenderType.cutout());

		RenderTypeLookup.setRenderLayer(FarmingRegistry.APPLE_LEAVES.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.LEMON_LEAVES.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.ORANGE_LEAVES.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.CHERRY_LEAVES.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.PEAR_LEAVES.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.BANANA_LEAVES.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.AVOCADO_LEAVES.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.MANGO_LEAVES.get(), RenderType.cutoutMipped());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.OLIVE_LEAVES.get(), RenderType.cutoutMipped());

		RenderTypeLookup.setRenderLayer(FarmingRegistry.MINT_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.NETHER_FLOWER_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.TOMATO_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.CUCUMBER_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.AUBERGINE_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.GRAPE_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.PINEAPPLE_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.CORN_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.ONION_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.GARLIC_CROP.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(FarmingRegistry.LETTUCE_CROP.get(), RenderType.cutout());
	}

	public static void registerBlockColors(final ColorHandlerEvent.Item event) {
		BlockColors blockColors = event.getBlockColors();
		ItemColors itemColors = event.getItemColors();

		blockColors.register((state, reader, pos, tintIndex) -> reader != null && pos != null ? BiomeColors.getAverageFoliageColor(reader, pos) : FoliageColors.getDefaultColor(),
				FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.ORANGE_LEAVES.get(),
				FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.AVOCADO_LEAVES.get(),
				FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.BANANA_LEAVES.get());


		itemColors.register((stack, tintIndex) -> {
					BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
					return blockColors.getColor(blockstate, (IBlockDisplayReader)null, (BlockPos)null, tintIndex);
				}, FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.ORANGE_LEAVES.get(),
				FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.AVOCADO_LEAVES.get(),
				FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.BANANA_LEAVES.get());
	}
}
