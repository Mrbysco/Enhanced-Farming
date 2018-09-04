package com.Mrbysco.EnhancedFarming.compat.JEI.piston;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;

public class FarmingPistonWrapper extends BlankRecipeWrapper {
	private final ItemStack input;
    private final ItemStack output;

    public FarmingPistonWrapper(ItemStack input, ItemStack output) {
    	this.input = input;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
    	ingredients.setInput(ItemStack.class, input);	
    	ingredients.setOutput(ItemStack.class, output);
    }
}