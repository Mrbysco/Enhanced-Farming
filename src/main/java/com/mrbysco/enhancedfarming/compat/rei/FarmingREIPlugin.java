//package com.mrbysco.enhancedfarming.compat.rei;
//
//import com.mrbysco.enhancedfarming.EnhancedFarming;
//import com.mrbysco.enhancedfarming.compat.rei.display.PistonDisplay;
//import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
//import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
//import me.shedaniel.rei.api.common.category.CategoryIdentifier;
//import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
//import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
//import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
//import me.shedaniel.rei.forge.REIPluginCommon;
//
//@REIPluginCommon
//public class FarmingREIPlugin implements REICommonPlugin {
//	public static final CategoryIdentifier<PistonDisplay> PISTON = CategoryIdentifier.of(EnhancedFarming.MOD_ID, "plugins/piston");
//
//	@Override
//	public void registerDisplays(ServerDisplayRegistry registry) {
//		registry.beginRecipeFiller(PistonRecipe.class)
//				.filterType(FarmingRecipes.PISTON_CRAFTING_TYPE.get())
//				.fill(PistonDisplay::new);
//	}
//
//	@Override
//	public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
//		registry.register(EnhancedFarming.modLoc("piston_recipes"), PistonDisplay.SERIALIZER);
//	}
//}
