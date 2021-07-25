package com.mrbysco.enhancedfarming.compat.jei;

//@JeiPlugin
public class JEICompat {//implements IModPlugin {
//	public static final ResourceLocation RECIPE_PISTON_JEI = new ResourceLocation(Reference.MOD_ID, "textures/gui/jei/piston.png");
//	public static final ResourceLocation RECIPE_PISTON_ICON_JEI = new ResourceLocation(Reference.MOD_ID, "textures/gui/jei/piston_icon.png");
//
//	public static final ResourceLocation PLUGIN_UID = new ResourceLocation(Reference.MOD_ID, "main");
//	public static final ResourceLocation PISTON = new ResourceLocation(Reference.MOD_ID, "piston");
//
//	@Nullable
//	private IRecipeCategory<PistonRecipe> pistonCategory;
//
//	@Override
//	public ResourceLocation getPluginUid() {
//		return PLUGIN_UID;
//	}
//
//
//	@Override
//	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//		registration.addRecipeCatalyst(new ItemStack(Items.PISTON), PISTON);
//		registration.addRecipeCatalyst(new ItemStack(Items.STICKY_PISTON), PISTON);
//	}
//
//	@Override
//	public void registerCategories(IRecipeCategoryRegistration registration) {
//		IJeiHelpers jeiHelpers = registration.getJeiHelpers();
//		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
//		registration.addRecipeCategories(
//				pistonCategory = new PistonCategory(guiHelper)
//		);
//	}
//
//	@Override
//	public void registerRecipes(IRecipeRegistration registration) {
//		ErrorUtil.checkNotNull(pistonCategory, "pistonCategory");
//
//		ClientLevel world = Objects.requireNonNull(Minecraft.getInstance().level);
//		registration.addRecipes(world.getRecipeManager().getAllRecipesFor(FarmingRecipes.PISTON_CRAFTING_TYPE), PISTON);
//	}
}
