package com.mrbysco.enhancedfarming.client;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import com.mrbysco.enhancedfarming.recipes.PistonRecipeCache;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

import java.util.Collection;
import java.util.List;

@EventBusSubscriber(Dist.CLIENT)
public class ClientHandler {

	@SubscribeEvent
	public static void registerBlockColors(final RegisterColorHandlersEvent.BlockTintSources event) {
		event.register(List.of(BlockTintSources.foliage()),
				FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.ORANGE_LEAVES.get(),
				FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.AVOCADO_LEAVES.get(),
				FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.BANANA_LEAVES.get());
	}

	@SubscribeEvent
	public static void onRecipeReceived(final RecipesReceivedEvent event) {
		PistonRecipeCache.pistonRecipes.clear();
		Collection<RecipeHolder<PistonRecipe>> compressingRecipes = event.getRecipeMap().byType(FarmingRecipes.PISTON_CRAFTING_TYPE.get());
		PistonRecipeCache.pistonRecipes.addAll(compressingRecipes);
	}
}
