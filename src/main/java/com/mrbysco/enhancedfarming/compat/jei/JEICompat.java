package com.mrbysco.enhancedfarming.compat.jei;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.compat.jei.piston.PistonCategory;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import com.mrbysco.enhancedfarming.recipes.PistonRecipeCache;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

@JeiPlugin
public class JEICompat implements IModPlugin {
	public static final ResourceLocation RECIPE_PISTON_JEI = EnhancedFarming.modLoc("textures/gui/jei/piston.png");
	public static final ResourceLocation RECIPE_PISTON_ICON_JEI = EnhancedFarming.modLoc("textures/gui/jei/piston_icon.png");

	public static final ResourceLocation PLUGIN_UID = EnhancedFarming.modLoc("main");

	public static final IRecipeType<PistonRecipe> PISTON_TYPE = IRecipeType.create(EnhancedFarming.MOD_ID, "piston", PistonRecipe.class);

	@Nullable
	private IRecipeCategory<PistonRecipe> pistonCategory;

	@Override
	public ResourceLocation getPluginUid() {
		return PLUGIN_UID;
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addCraftingStation(PISTON_TYPE, new ItemStack(Items.PISTON));
		registration.addCraftingStation(PISTON_TYPE, new ItemStack(Items.STICKY_PISTON));
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		IJeiHelpers jeiHelpers = registration.getJeiHelpers();
		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
		registration.addRecipeCategories(
				pistonCategory = new PistonCategory<>(guiHelper)
		);
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addRecipes(PISTON_TYPE, PistonRecipeCache.pistonRecipes.stream()
				.map(RecipeHolder::value).toList());
	}
}
