package com.mrbysco.enhancedfarming.compat.jei.piston;

import com.mrbysco.enhancedfarming.compat.jei.JEICompat;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

public class PistonCategory<T extends PistonRecipe> implements IRecipeCategory<PistonRecipe> {
	private final IDrawable background;
	private final IDrawable icon;
	private final Component localizedName;

	public PistonCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(JEICompat.RECIPE_PISTON_JEI, 0, 0, 84, 62);
		this.icon = guiHelper.createDrawable(JEICompat.RECIPE_PISTON_ICON_JEI, 0, 0, 16, 16);
		this.localizedName = Component.translatable("enhancedfarming.gui.jei.category.piston");
	}

	@Override
	public IRecipeType<PistonRecipe> getRecipeType() {
		return JEICompat.PISTON_TYPE;
	}

	@Override
	public Component getTitle() {
		return localizedName;
	}

	@Override
	public int getWidth() {
		return 84;
	}

	@Override
	public int getHeight() {
		return 62;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, PistonRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 23).add(recipe.ingredient());
		builder.addSlot(RecipeIngredientRole.OUTPUT, 67, 23).add(recipe.result());
	}

	@Override
	public void draw(PistonRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
		IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
	}
}
