package com.Mrbysco.EnhancedFarming.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FarmingRecipes {

	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(FarmingItems.cold_chocolate_bottle), new ItemStack(FarmingItems.hot_chocolate_bottle), 0.1F);
		GameRegistry.addSmelting(Items.POTIONITEM.getDefaultInstance(), new ItemStack(FarmingItems.hot_water), 0.1F);
	}
}
