package com.mrbysco.enhancedfarming.client;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import com.mrbysco.enhancedfarming.recipes.PistonRecipeCache;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Collection;

public class ClientHandler {

	public static void onClientSetup(final FMLClientSetupEvent event) {
		for (DeferredHolder<Block, ? extends Block> registryObject : FarmingRegistry.BLOCKS.getEntries()) {
			if (registryObject.get() instanceof BushBlock) {
				ItemBlockRenderTypes.setRenderLayer(registryObject.get(), ChunkSectionLayer.CUTOUT);
			}
		}
	}

	public static void registerBlockColors(final RegisterColorHandlersEvent.Block event) {
		event.register((state, reader, pos, tintIndex) -> reader != null && pos != null ?
						BiomeColors.getAverageFoliageColor(reader, pos) :
						FoliageColor.FOLIAGE_DEFAULT,
				FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.ORANGE_LEAVES.get(),
				FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.AVOCADO_LEAVES.get(),
				FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.BANANA_LEAVES.get());
	}

	public static void onRecipeReceived(final RecipesReceivedEvent event) {
		PistonRecipeCache.pistonRecipes.clear();
		Collection<RecipeHolder<PistonRecipe>> compressingRecipes = event.getRecipeMap().byType(FarmingRecipes.PISTON_CRAFTING_TYPE.get());
		PistonRecipeCache.pistonRecipes.addAll(compressingRecipes);
	}
}
