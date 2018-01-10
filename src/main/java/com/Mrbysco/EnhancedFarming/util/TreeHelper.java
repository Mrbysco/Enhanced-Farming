package com.Mrbysco.EnhancedFarming.util;

import com.Mrbysco.EnhancedFarming.block.BlockFruitLeaves;
import com.Mrbysco.EnhancedFarming.block.BlockGrowableSapling;
import com.Mrbysco.EnhancedFarming.block.EnumSaplingType;
import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.init.FarmingBlocks;
import com.Mrbysco.EnhancedFarming.init.FarmingItems;

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
		boolean flag = FarmingConfigGen.general.othersettings.oldLeaveDecay;
		
		switch (type) {
		case Apple:
			leave = flag ? FarmingBlocks.apple_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockFruitLeaves.FRUITY, Boolean.valueOf(true)) 
						: FarmingBlocks.apple_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockFruitLeaves.FRUITY, Boolean.valueOf(false));
			break;
		case Lemon:
			leave = flag ? FarmingBlocks.lemon_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockFruitLeaves.FRUITY, Boolean.valueOf(true)) 
					: FarmingBlocks.lemon_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockFruitLeaves.FRUITY, Boolean.valueOf(false));
			break;
		case Orange:
			leave = flag ? FarmingBlocks.orange_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockFruitLeaves.FRUITY, Boolean.valueOf(true)) 
					: FarmingBlocks.orange_leaves.getDefaultState().withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)).withProperty(BlockFruitLeaves.FRUITY, Boolean.valueOf(false));
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
