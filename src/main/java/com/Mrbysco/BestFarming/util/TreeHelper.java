package com.Mrbysco.BestFarming.util;

import com.Mrbysco.BestFarming.block.BlockFruitLeaves;
import com.Mrbysco.BestFarming.block.BlockGrowableSapling;
import com.Mrbysco.BestFarming.block.EnumSaplingType;
import com.Mrbysco.BestFarming.init.FarmingBlocks;
import com.Mrbysco.BestFarming.init.FarmingItems;

import net.minecraft.block.BlockLeaves;
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
	
	public static IBlockState getLeaveFromEnum(EnumSaplingType type) {
		IBlockState leave = null;
		
		switch (type) {
		case Apple:
			leave = FarmingBlocks.apple_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockFruitLeaves.FRUITY, Boolean.valueOf(true));
			break;
		case Lemon:
			leave = FarmingBlocks.lemon_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockFruitLeaves.FRUITY, Boolean.valueOf(true));
			break;
		case Orange:
			leave = FarmingBlocks.orange_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockFruitLeaves.FRUITY, Boolean.valueOf(true));
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
