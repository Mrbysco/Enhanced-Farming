package com.mrbysco.enhancedfarming.compat.emi.recipe;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.compat.emi.EMICompat;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EMIPistonRecipe implements EmiRecipe {
	public static final ResourceLocation PISTON_BACKGROUND_TEXTURE = EnhancedFarming.modLoc("textures/gui/jei/piston.png");
	public static final EmiTexture BACKGROUND = new EmiTexture(PISTON_BACKGROUND_TEXTURE, 0, 0, 84, 62);

	EmiIngredient input;
	List<EmiIngredient> inputs;
	EmiStack output;
	ResourceLocation id;

	public EMIPistonRecipe(RecipeHolder<PistonRecipe> recipeHolder) {
		PistonRecipe recipe = recipeHolder.value();
		this.input = EmiIngredient.of(recipe.getIngredients().getFirst());
		this.inputs = List.of(input);
		this.output = EmiStack.of(recipe.getResultItem(null));
		this.id = recipeHolder.id();
	}

	@Override
	public EmiRecipeCategory getCategory() {
		return EMICompat.PISTON_CATEGORY;
	}

	@Override
	public @Nullable ResourceLocation getId() {
		return this.id;
	}

	@Override
	public List<EmiIngredient> getInputs() {
		return inputs;
	}

	@Override
	public List<EmiStack> getOutputs() {
		return List.of(output);
	}

	@Override
	public int getDisplayWidth() {
		return 84;
	}

	@Override
	public int getDisplayHeight() {
		return 62;
	}

	@Override
	public void addWidgets(WidgetHolder widgets) {
		widgets.addTexture(BACKGROUND, 0, 0);

		widgets.addSlot(input, 1, 23);
		widgets.addSlot(output, 67, 22).recipeContext(this);
	}
}
