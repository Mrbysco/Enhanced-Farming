package com.mrbysco.enhancedfarming.compat.emi;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.compat.emi.recipe.EMIPistonRecipe;
import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.EmiRecipeSorting;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.Objects;

@EmiEntrypoint
public class EMICompat implements EmiPlugin {
	private static final ResourceLocation UID = EnhancedFarming.modLoc("emi_plugin");

	private static final EmiTexture PISTON_ICON = new EmiTexture(EnhancedFarming.modLoc("textures/gui/jei/piston_icon.png"), 0, 0, 16, 16);
	public static final EmiRecipeCategory PISTON_CATEGORY = new EmiRecipeCategory(EnhancedFarming.modLoc("plugins/piston"),
			EmiStack.of(Items.PISTON), PISTON_ICON, EmiRecipeSorting.compareOutputThenInput());

	@Override
	public void register(EmiRegistry registry) {
		RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		manager.getAllRecipesFor(FarmingRecipes.PISTON_CRAFTING_TYPE.get()).forEach(holder -> {
			registry.addRecipe(new EMIPistonRecipe(holder));
		});

		registry.addWorkstation(PISTON_CATEGORY, EmiStack.of(Items.PISTON));
	}
}
