package com.mrbysco.enhancedfarming.datagen.data;

import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.nio.file.Path;
import java.util.function.Consumer;

public class FarmingRecipeProvider extends RecipeProvider {
	public FarmingRecipeProvider(DataGenerator gen) {
		super(gen);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

	}

	@Override
	protected void saveAdvancement(CachedOutput cache, JsonObject advancementJson, Path path) {
		// Nope
	}
}