package com.Mrbysco.BestFarming.block;

import java.util.Random;

import com.Mrbysco.BestFarming.Reference;
import com.Mrbysco.BestFarming.init.FarmingItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockMint extends BlockCrops{
	
    public static final PropertyInteger MINT_AGE = PropertyInteger.create("age", 0, 5);
    private static final AxisAlignedBB[] MINT_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.4375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D)};
	
    public BlockMint(String unlocalizedName, String registryName) {
    	super();
    	this.setDefaultState(this.blockState.getBaseState().withProperty(MINT_AGE, Integer.valueOf(0)));
        this.setCreativeTab((CreativeTabs)null);

		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
	}
    
    protected PropertyInteger getAgeProperty()
    {
        return MINT_AGE;
    }
    
    @Override
    protected Item getSeed()
    {
        return FarmingItems.mint_seeds;
    }
    
    @Override
    protected Item getCrop()
    {
        return FarmingItems.mint;
    }
    
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.FARMLAND;
    }
    
	@Override
	public int getMaxAge() {
		return 5;
	}
    
    @Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(!isMaxAge(state)) {
			return getSeed();
		}
		else {
			return getCrop();
		}
	}
    
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (rand.nextInt(5) == 0)
        {
            this.checkAndDropBlock(worldIn, pos, state);
        }
        else
        {
            super.updateTick(worldIn, pos, state, rand);
        }
    }
    
    @Override
    protected int getBonemealAgeIncrease(World worldIn)
    {
        return super.getBonemealAgeIncrease(worldIn) / 5;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(MINT_AGE, Integer.valueOf(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(MINT_AGE)).intValue();
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {MINT_AGE});
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return MINT_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
    	return EnumPlantType.Crop;
    }
    
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
    	return getAge(state) < getMaxAge();
    }
}
