package com.Mrbysco.EnhancedFarming.compat.JEI.piston;

import com.Mrbysco.EnhancedFarming.Reference;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.util.Translator;
import net.minecraft.util.ResourceLocation;

public class FarmingPistonCategory implements IRecipeCategory {

	public static final String UID = "farming.piston";
    private final IDrawableStatic background;
    private final String title;
    private final IDrawableStatic icon;
	
	public FarmingPistonCategory(IGuiHelper guiHelper) {
		title = Translator.translateToLocal("gui.farming.piston");
		 
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, "textures/gui/piston.png");
		background = guiHelper.createDrawable(location, 0, 0, 84, 62);

		ResourceLocation iconLocation = new ResourceLocation(Reference.MOD_ID, "textures/gui/piston_icon.png");
		icon = guiHelper.createDrawable(iconLocation, 0, 0, 16, 16);
	}
	
	@Override
	public String getUid() {
		return UID;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getModName() {
		return Reference.MOD_NAME;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

		int inputSlot = 0;
        guiItemStacks.init(inputSlot, true, 0, 22);
        guiItemStacks.set(ingredients);

        int outputSlot = 1;
        guiItemStacks.init(outputSlot, false, 66, 22);
        guiItemStacks.set(ingredients);
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}
}