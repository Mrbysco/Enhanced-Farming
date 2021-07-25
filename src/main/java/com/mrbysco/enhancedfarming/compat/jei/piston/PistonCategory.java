package com.mrbysco.enhancedfarming.compat.jei.piston;

public class PistonCategory {//<T extends PistonRecipe> implements IRecipeCategory<PistonRecipe> {
//	private final IDrawable background;
//	private final IDrawable icon;
//	private final String localizedName;
//
//	public PistonCategory(IGuiHelper guiHelper) {
//		this.background = guiHelper.createDrawable(JEICompat.RECIPE_PISTON_JEI, 0, 0, 84, 62);
//		this.icon = guiHelper.createDrawable(JEICompat.RECIPE_PISTON_ICON_JEI, 0, 0, 16, 16);
//		this.localizedName = Translator.translateToLocal("enhancedfarming.gui.jei.category.piston");
//	}
//
//	@Override
//	public ResourceLocation getUid() {
//		return JEICompat.PISTON;
//	}
//
//	@Override
//	public Class<? extends PistonRecipe> getRecipeClass() {
//		return PistonRecipe.class;
//	}
//
//	@Override
//	public String getTitle() {
//		return localizedName;
//	}
//
//	@Override
//	public IDrawable getBackground() {
//		return background;
//	}
//
//	@Override
//	public IDrawable getIcon() {
//		return icon;
//	}
//
//	@Override
//	public void setIngredients(PistonRecipe recipe, IIngredients ingredients) {
//		ingredients.setInputIngredients(recipe.getIngredients());
//		ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
//	}
//
//	@Override
//	public void setRecipe(IRecipeLayout recipeLayout, PistonRecipe recipe, IIngredients ingredients) {
//		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
//
//		guiItemStacks.init(0, true, 0, 22);
//		guiItemStacks.init(1, false, 66, 22);
//
//		guiItemStacks.set(ingredients);
//	}
}
