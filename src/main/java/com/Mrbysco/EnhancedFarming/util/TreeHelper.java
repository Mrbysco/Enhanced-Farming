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
        case APPLE:
        	sapling = FarmingBlocks.apple_sapling;
        	break;
        case LEMON:
        	sapling = FarmingBlocks.lemon_sapling;
        	break;
        case ORANGE:
        	sapling = FarmingBlocks.orange_sapling;
        	break;
		case CHERRY:
        	sapling = FarmingBlocks.cherry_sapling;
			break;
		case PEAR:
			sapling = FarmingBlocks.pear_sapling;
			break;
		case BANANA:
			sapling = FarmingBlocks.banana_sapling;
			break;
		case AVOCADO:
			sapling = FarmingBlocks.avocado_sapling;
			break;
		case MANGO:
			sapling = FarmingBlocks.mango_sapling;
			break;
		default:
			sapling = FarmingBlocks.apple_sapling;
			break;
		}
		
		return sapling; 
	}
	
	public static IBlockState getBloomingLeaveFromEnum(EnumSaplingType type) {
		IBlockState leave = null;	
		
		switch (type) {
		case APPLE:
			leave = FarmingBlocks.blooming_apple_leaves.getDefaultState();
			break;
		case LEMON:
			leave = FarmingBlocks.blooming_lemon_leaves.getDefaultState();
			break;
		case ORANGE:
			leave = FarmingBlocks.blooming_orange_leaves.getDefaultState();
			break;
		case CHERRY:
			leave = FarmingBlocks.blooming_cherry_leaves.getDefaultState();
			break;
		case PEAR:
			leave = FarmingBlocks.blooming_pear_leaves.getDefaultState();
			break;
		case BANANA:
			leave = FarmingBlocks.blooming_banana_leaves.getDefaultState();
			break;
		case AVOCADO:
			leave = FarmingBlocks.blooming_avocado_leaves.getDefaultState();
			break;
		case MANGO:
			leave = FarmingBlocks.blooming_mango_leaves.getDefaultState();
			break;
		default:
			leave = FarmingBlocks.blooming_apple_leaves.getDefaultState();
			break;
		}
		
		return leave; 
	}
	
	public static IBlockState getLeaveFromEnum(EnumSaplingType type) {
		IBlockState leave = null;
		
		switch (type) {
		case APPLE:
			leave = FarmingBlocks.apple_leaves.getDefaultState();
			break;
		case LEMON:
			leave = FarmingBlocks.lemon_leaves.getDefaultState();
			break;
		case ORANGE:
			leave = FarmingBlocks.orange_leaves.getDefaultState();
			break;
		case CHERRY:
			leave = FarmingBlocks.cherry_leaves.getDefaultState();
			break;
		case PEAR:
			leave = FarmingBlocks.pear_leaves.getDefaultState();
			break;
		case BANANA:
			leave = FarmingBlocks.banana_leaves.getDefaultState();
			break;
		case AVOCADO:
			leave = FarmingBlocks.avocado_leaves.getDefaultState();
			break;
		case MANGO:
			leave = FarmingBlocks.mango_leaves.getDefaultState();
			break;
		default:
			leave = FarmingBlocks.apple_leaves.getDefaultState();
			break;
		}
		
		return leave; 
	}
	
	public static Item getFruitfromEnum(EnumSaplingType type) {
		Item fruit = null;
		
		switch (type) {
        case APPLE:
        	fruit = Items.APPLE;
        	break;
        case LEMON:
        	fruit = FarmingItems.lemon;
        	break;
        case ORANGE:
        	fruit = FarmingItems.orange;
        	break;
		case CHERRY:
			fruit = FarmingItems.cherry;
			break;
		case PEAR:
			fruit = FarmingItems.pear;
			break;
		case BANANA:
			fruit = FarmingItems.banana;
			break;
		case AVOCADO:
			fruit = FarmingItems.avocado;
			break;
		case MANGO:
			fruit = FarmingItems.mango;
			break;
		default:
			fruit = Items.APPLE;
			break;
		}
		
		return fruit; 
	}
}
