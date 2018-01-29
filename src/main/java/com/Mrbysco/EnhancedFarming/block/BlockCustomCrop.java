package com.Mrbysco.EnhancedFarming.block;

import java.util.Random;

import com.Mrbysco.EnhancedFarming.Reference;
import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.init.FarmingItems;

import net.minecraft.block.BlockCrops;
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

public class BlockCustomCrop extends BlockCrops{
	
	public static int MAX_AGE = 5;
    public static final PropertyInteger CROP_AGE = PropertyInteger.create("age", 0, MAX_AGE);
    private static final AxisAlignedBB[] CROP_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.4375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D)};
	
    public BlockCustomCrop(String unlocalizedName, String registryName, int maxAge) {
    	super();
    	this.setDefaultState(this.blockState.getBaseState().withProperty(CROP_AGE, Integer.valueOf(0)));
        this.setCreativeTab((CreativeTabs)null);

        this.MAX_AGE = maxAge;
		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
	}
    
    @Override
    public void grow(World worldIn, BlockPos pos, IBlockState state) {
    	int i;
        int j = this.getMaxAge();;
        
    	if (FarmingConfigGen.general.othersettings.instantGrow)
    	{
    		i = this.getAge(state) + (j - this.getAge(state));
    	}
    	else
    	{
    		i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
    	}

        if (i > j)
        {
            i = j;
        }

        worldIn.setBlockState(pos, this.withAge(i), 2);
    }
    
    protected PropertyInteger getAgeProperty()
    {
        return CROP_AGE;
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
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(CROP_AGE, Integer.valueOf(meta));
    }
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(CROP_AGE)).intValue();
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CROP_AGE});
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CROP_AABB[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
    	return EnumPlantType.Crop;
    }
    
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
    	if(FarmingConfigGen.general.othersettings.bonemealGrow)
    	{
    		return getAge(state) < getMaxAge();
    	}
    	else
    	{
    		return false;
    	}
    }
    
    @Override
    protected int getBonemealAgeIncrease(World worldIn)
    {
        return super.getBonemealAgeIncrease(worldIn) / 2;
    }
}