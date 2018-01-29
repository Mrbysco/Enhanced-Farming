package com.Mrbysco.EnhancedFarming.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class FarmingRecipes {

	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(FarmingItems.cold_chocolate_bottle), new ItemStack(FarmingItems.hot_chocolate_bottle), 0.1F);
		GameRegistry.addSmelting(Items.POTIONITEM.getDefaultInstance(), new ItemStack(FarmingItems.hot_water), 0.1F);
	}
	
	public static void initOredict()
	{
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.blooming_apple_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.apple_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.blooming_lemon_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.lemon_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.blooming_orange_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.orange_leaves, 1));
        
        //New Content
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.blooming_cherry_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.cherry_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.blooming_pear_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.pear_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.blooming_banana_leaves, 1));
        OreDictionary.registerOre("treeLeaves",  new ItemStack(FarmingBlocks.banana_leaves, 1));
	}
}
