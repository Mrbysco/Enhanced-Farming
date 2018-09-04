package com.Mrbysco.EnhancedFarming.compat.JEI.piston;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.ingredients.Ingredients;
import net.minecraft.item.ItemStack;

public class FarmingPistonHandler implements IRecipeHandler<FarmingPistonWrapper>{

	@Override
	public Class<FarmingPistonWrapper> getRecipeClass() {
		return FarmingPistonWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid(FarmingPistonWrapper recipe) {
		return FarmingPistonCategory.UID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(FarmingPistonWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(FarmingPistonWrapper recipe) {
		IIngredients ingredients = new Ingredients();
        recipe.getIngredients(ingredients);
        return ingredients.getInputs(ItemStack.class).size() > 0 && ingredients.getOutputs(ItemStack.class).size() > 0;
	}
}
