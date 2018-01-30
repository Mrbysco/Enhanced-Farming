package com.Mrbysco.EnhancedFarming.item;

import com.Mrbysco.EnhancedFarming.EnhancedFarming;
import com.Mrbysco.EnhancedFarming.Reference;
import com.Mrbysco.EnhancedFarming.block.BlockCropStick;
import com.Mrbysco.EnhancedFarming.init.FarmingBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class ItemCropstickSeeds extends ItemSeeds{
    
    private final Block crops;
    
	public ItemCropstickSeeds(Block crops, String unlocalizedName, String registryName) {
		super(crops, FarmingBlocks.crop_stick);
        
		setCreativeTab(EnhancedFarming.tabFarming);
		
		this.crops = crops;
        
		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);
        IBlockState state = worldIn.getBlockState(pos);
        
        if (possibleSide(facing) && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock() instanceof BlockCropStick)
        {
            worldIn.setBlockState(pos, this.crops.getDefaultState());

            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        else
        {
            return EnumActionResult.FAIL;
        }
    }
	
	public boolean possibleSide(EnumFacing facing) {
        if (!(facing == EnumFacing.DOWN))
        	return true;
        else
        	return false;
	}
	
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
    {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos)
    {
        return this.crops.getDefaultState();
    }
}
