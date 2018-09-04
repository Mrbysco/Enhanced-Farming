package com.Mrbysco.EnhancedFarming.compat.JEI;

import java.util.ArrayList;
import java.util.List;

import com.Mrbysco.EnhancedFarming.compat.JEI.piston.FarmingPistonCategory;
import com.Mrbysco.EnhancedFarming.compat.JEI.piston.FarmingPistonHandler;
import com.Mrbysco.EnhancedFarming.compat.JEI.piston.FarmingPistonWrapper;
import com.Mrbysco.EnhancedFarming.init.FarmingBlocks;
import com.Mrbysco.EnhancedFarming.init.FarmingItems;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class FarmingJEIPlugin implements IModPlugin{
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        registry.addRecipeCategories(new FarmingPistonCategory(jeiHelpers.getGuiHelper()));
	}
	
	@Override
	public void register(IModRegistry registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();
		registry.addRecipeHandlers(new FarmingPistonHandler());
		
		registry.addRecipes(getPistonRecipes(), FarmingPistonCategory.UID);
		registry.addRecipeCatalyst(new ItemStack(Blocks.PISTON), FarmingPistonCategory.UID);
		
		for(Block block : FarmingBlocks.BLOCKS) {
			if(block.getLocalizedName().contains("crop"))
			{
				jeiHelpers.getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(block));
			}
		}
	}
	
	private List<FarmingPistonWrapper> getPistonRecipes() {
        List<FarmingPistonWrapper> result = new ArrayList<FarmingPistonWrapper>();
        
        result.add(new FarmingPistonWrapper(new ItemStack(FarmingItems.olive), new ItemStack(FarmingItems.olive_oil)));
        
        return result;
	}
}
