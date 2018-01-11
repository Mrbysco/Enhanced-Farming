package com.Mrbysco.EnhancedFarming.util;

import com.Mrbysco.EnhancedFarming.block.BlockGrowableSapling;
import com.Mrbysco.EnhancedFarming.block.EnumSaplingType;
import com.Mrbysco.EnhancedFarming.init.FarmingBlocks;
import com.Mrbysco.EnhancedFarming.init.FarmingItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TreeHelper {

	public static BlockGrowableSapling getSaplingFromEnum(EnumSaplingType type) {
		BlockGrowableSapling sapling = null;
		
		switch (type) {
        case Apple:
        	sapling = FarmingBlocks.apple_sapling;
        	break;
        case Lemon:
        	sapling = FarmingBlocks.lemon_sapling;
        	break;
        case Orange:
        	sapling = FarmingBlocks.orange_sapling;
        	break;
		}
		
		return sapling; 
	}
	
	public static IBlockState getBloomingLeaveFromEnum(EnumSaplingType type) {
		IBlockState leave = null;	
		
		switch (type) {
		case Apple:
			leave = FarmingBlocks.blooming_apple_leaves.getDefaultState();
			break;
		case Lemon:
			leave = FarmingBlocks.blooming_lemon_leaves.getDefaultState();
			break;
		case Orange:
			leave = FarmingBlocks.blooming_orange_leaves.getDefaultState();
			break;
		}
		
		return leave; 
	}
	
	public static IBlockState getLeaveFromEnum(EnumSaplingType type) {
		IBlockState leave = null;
		
		switch (type) {
		case Apple:
			leave = FarmingBlocks.apple_leaves.getDefaultState();
			break;
		case Lemon:
			leave = FarmingBlocks.lemon_leaves.getDefaultState();
			break;
		case Orange:
			leave = FarmingBlocks.orange_leaves.getDefaultState();
			break;
		}
		
		return leave; 
	}
	
	public static Item getFruitfromEnum(EnumSaplingType type) {
		Item fruit = null;
		
		switch (type) {
        case Apple:
        	fruit = Items.APPLE;
        	break;
        case Lemon:
        	fruit = FarmingItems.lemon;
        	break;
        case Orange:
        	fruit = FarmingItems.orange;
        	break;
		}
		
		return fruit; 
	}
}
