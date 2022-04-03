package com.mrbysco.enhancedfarming.compat.jei.piston;

import com.mrbysco.enhancedfarming.compat.jei.JEICompat;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class PistonCategory<T extends PistonRecipe> implements IRecipeCategory<PistonRecipe> {
	private final IDrawable background;
	private final IDrawable icon;
	private final Component localizedName;

	public PistonCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(JEICompat.RECIPE_PISTON_JEI, 0, 0, 84, 62);
		this.icon = guiHelper.createDrawable(JEICompat.RECIPE_PISTON_ICON_JEI, 0, 0, 16, 16);
		this.localizedName = new TranslatableComponent("enhancedfarming.gui.jei.category.piston");
	}

	@Override
	public RecipeType<PistonRecipe> getRecipeType() {
		return JEICompat.PISTON_TYPE;
	}

	@Override
	public ResourceLocation getUid() {
		return JEICompat.PISTON;
	}

	@Override
	public Class<? extends PistonRecipe> getRecipeClass() {
		return PistonRecipe.class;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, PistonRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 22).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 66, 22).addItemStack(recipe.getResultItem());
	}
}
