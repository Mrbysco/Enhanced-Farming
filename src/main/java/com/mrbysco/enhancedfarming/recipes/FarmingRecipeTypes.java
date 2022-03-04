package com.mrbysco.enhancedfarming.recipes;

import com.mrbysco.enhancedfarming.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;

public class FarmingRecipeTypes {
	public static final RecipeType<PistonRecipe> PISTON_CRAFTING_TYPE = RecipeType.register(new ResourceLocation(Reference.MOD_ID, "piston_crafting").toString());

	public static void init() {
		//For initializing the static final fields
	}
}
