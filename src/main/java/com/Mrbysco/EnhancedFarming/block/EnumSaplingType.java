package com.Mrbysco.EnhancedFarming.block;

import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public enum EnumSaplingType 
{
	Apple(Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK)),
    Lemon(Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK)),
    Orange(Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK));
	
	private final IBlockState woodType;
    
	private EnumSaplingType(IBlockState wood) {
		this.woodType = wood;
	}
	
	public IBlockState getWoodType()
    {
        return this.woodType;
    }

}
