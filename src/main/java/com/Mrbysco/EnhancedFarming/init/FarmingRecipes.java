package com.Mrbysco.EnhancedFarming.init;

import com.Mrbysco.EnhancedFarming.block.ILeafColor;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class FarmingRecipes {

	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(FarmingItems.cold_chocolate_bottle), new ItemStack(FarmingItems.hot_chocolate_bottle), 0.1F);
		GameRegistry.addSmelting(getWaterBottle(), new ItemStack(FarmingItems.hot_water), 0.1F);
		GameRegistry.addSmelting(FarmingItems.dough, new ItemStack(Items.BREAD), 0.1F);
		GameRegistry.addSmelting(Items.EGG, new ItemStack(FarmingItems.baked_egg), 0.1F);
	}
	
	public static ItemStack getWaterBottle()
    {
        return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.WATER);
    }
	
	public static void initOredict()
	{
		for(Block block : FarmingBlocks.BLOCKS)
		{
			if (block instanceof ILeafColor)
			{
				OreDictionary.registerOre("treeLeaves",  new ItemStack(block, 1));
			}
		}
        
    	OreDictionary.registerOre("rawMeat", Items.BEEF);
    	OreDictionary.registerOre("rawMeat", Items.CHICKEN);
    	OreDictionary.registerOre("rawMeat", Items.MUTTON);
        OreDictionary.registerOre("rawMeat", Items.PORKCHOP);
        OreDictionary.registerOre("rawMeat", Items.RABBIT);

    	OreDictionary.registerOre("cookedMeat", Items.COOKED_BEEF);
    	OreDictionary.registerOre("cookedMeat", Items.COOKED_CHICKEN);
    	OreDictionary.registerOre("cookedMeat", Items.COOKED_MUTTON);
    	OreDictionary.registerOre("cookedMeat", Items.COOKED_PORKCHOP);
    	OreDictionary.registerOre("cookedMeat", Items.COOKED_RABBIT);

    	OreDictionary.registerOre("fruitList", Items.APPLE);
    	OreDictionary.registerOre("fruitList", Items.MELON);
    	OreDictionary.registerOre("fruitList", FarmingItems.banana);
    	OreDictionary.registerOre("fruitList", FarmingItems.cherry);
    	OreDictionary.registerOre("fruitList", FarmingItems.grapes);
    	OreDictionary.registerOre("fruitList", FarmingItems.lemon);
    	OreDictionary.registerOre("fruitList", FarmingItems.mango);
    	OreDictionary.registerOre("fruitList", FarmingItems.orange);
    	OreDictionary.registerOre("fruitList", FarmingItems.pear);
    	OreDictionary.registerOre("fruitList", FarmingItems.pineapple);
    	//OreDictionary.registerOre("fruitList", FarmingItems.tomato); Million dollar question right here xD

    	OreDictionary.registerOre("vegetableList", Blocks.PUMPKIN);
    	OreDictionary.registerOre("vegetableList", Items.POTATO);
    	OreDictionary.registerOre("vegetableList", Items.CARROT);
    	OreDictionary.registerOre("vegetableList", Items.BEETROOT);
    	OreDictionary.registerOre("vegetableList", FarmingItems.aubergine);
    	OreDictionary.registerOre("vegetableList", FarmingItems.tomato);
    	OreDictionary.registerOre("vegetableList", FarmingItems.cucumber);
    	OreDictionary.registerOre("vegetableList", FarmingItems.onion);
    	OreDictionary.registerOre("vegetableList", FarmingItems.lettuce);
    	
    	OreDictionary.registerOre("allMilk", FarmingItems.milk_bottle);
    	OreDictionary.registerOre("allMilk", Items.MILK_BUCKET);
    	
    	OreDictionary.registerOre("allWater", getWaterBottle());
    	OreDictionary.registerOre("allWater", Items.WATER_BUCKET);
	}
}
