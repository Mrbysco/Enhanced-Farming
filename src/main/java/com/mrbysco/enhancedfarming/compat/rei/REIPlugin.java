package com.mrbysco.enhancedfarming.compat.rei;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.compat.rei.category.PistonCategory;
import com.mrbysco.enhancedfarming.compat.rei.display.PistonDisplay;
import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;

@REIPluginClient
public class REIPlugin implements REIClientPlugin {
	public static final CategoryIdentifier<PistonDisplay> PISTON = CategoryIdentifier.of(EnhancedFarming.MOD_ID, "plugins/piston");

	@Override
	public void registerCategories(CategoryRegistry registry) {
		registry.add(new PistonCategory());

		registry.addWorkstations(PISTON, EntryStacks.of(Items.PISTON), EntryStacks.of(Items.STICKY_PISTON));
	}

	@Override
	public void registerDisplays(DisplayRegistry registry) {
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel level = minecraft.level;
		if (level == null) {
			throw new NullPointerException("level must not be null.");
		}
		RegistryAccess registryAccess = level.registryAccess();

		List<RecipeHolder<PistonRecipe>> recipeHolders = registry.getRecipeManager().getAllRecipesFor(FarmingRecipes.PISTON_CRAFTING_TYPE.get());
		recipeHolders.stream().map(RecipeHolder::value).map(recipe -> new PistonDisplay(recipe, registryAccess)).forEach(registry::add);
	}
}
