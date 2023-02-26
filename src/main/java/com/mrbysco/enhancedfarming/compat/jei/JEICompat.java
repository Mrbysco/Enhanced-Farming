package com.mrbysco.enhancedfarming.compat.jei;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.compat.jei.piston.PistonCategory;
import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import javax.annotation.Nullable;
import java.util.Objects;

@JeiPlugin
public class JEICompat implements IModPlugin {
	public static final ResourceLocation RECIPE_PISTON_JEI = new ResourceLocation(Reference.MOD_ID, "textures/gui/jei/piston.png");
	public static final ResourceLocation RECIPE_PISTON_ICON_JEI = new ResourceLocation(Reference.MOD_ID, "textures/gui/jei/piston_icon.png");

	public static final ResourceLocation PLUGIN_UID = new ResourceLocation(Reference.MOD_ID, "main");

	public static final ResourceLocation PISTON = new ResourceLocation(Reference.MOD_ID, "piston");
	public static final RecipeType<PistonRecipe> PISTON_TYPE = RecipeType.create(Reference.MOD_ID, "piston", PistonRecipe.class);

	@Nullable
	private IRecipeCategory<PistonRecipe> pistonCategory;

	@Override
	public ResourceLocation getPluginUid() {
		return PLUGIN_UID;
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(Items.PISTON), PISTON_TYPE);
		registration.addRecipeCatalyst(new ItemStack(Items.STICKY_PISTON), PISTON_TYPE);
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		IJeiHelpers jeiHelpers = registration.getJeiHelpers();
		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
		registration.addRecipeCategories(
				pistonCategory = new PistonCategory(guiHelper)
		);
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		assert PISTON_TYPE != null;

		ClientLevel world = Objects.requireNonNull(Minecraft.getInstance().level);
		registration.addRecipes(PISTON_TYPE, world.getRecipeManager().getAllRecipesFor(FarmingRecipes.PISTON_CRAFTING_TYPE.get()));
	}
}
