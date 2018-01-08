package com.Mrbysco.BestFarming.block;

import java.util.Random;

import com.Mrbysco.BestFarming.Reference;
import com.Mrbysco.BestFarming.init.FarmingItems;

import net.minecraft.block.BlockBush;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockNetherFlower extends BlockBush implements INetherCrop{

    private static final AxisAlignedBB[] NETHERFLOWER_AABB = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
    public static final PropertyInteger WART_AGE = PropertyInteger.create("age", 0, 5);

    public BlockNetherFlower(String unlocalizedName, String registryName) {
    	super();
    	this.setDefaultState(this.blockState.getBaseState().withProperty(WART_AGE, Integer.valueOf(0)));
        this.setCreativeTab((CreativeTabs)null);
        
        this.blockSoundType = blockSoundType.PLANT;

		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
	}
    
    protected PropertyInteger getAgeProperty()
    {
        return WART_AGE;
    }
    
    protected Item getSeed()
    {
        return FarmingItems.nether_flower_seeds;
    }
    
    protected Item getCrop()
    {
        return Items.BLAZE_POWDER;
    }
    
	public int getMaxAge() 
	{
		return 5;
	}
	
	protected int getAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }
	
	public boolean isMaxAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }
	
    @Override
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.SOUL_SAND;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
    	return EnumPlantType.Nether;
    }
    
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        int i = ((Integer)state.getValue(WART_AGE)).intValue();

        if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt(10) == 0))
        {
            IBlockState newState = state.withProperty(WART_AGE, Integer.valueOf(i + 1));
            worldIn.setBlockState(pos, newState, 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, newState);
        }

        super.updateTick(worldIn, pos, state, rand);
    }
    
    @Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if(!this.isMaxAge(state)) {
			return getSeed();
		}
		else {
			return getCrop();
		}
	}
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return NETHERFLOWER_AABB[((Integer)state.getValue(WART_AGE)).intValue()];
    }

    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        if (isMaxAge(state))
        {
            drops.add(new ItemStack(this.getCrop()));
        }
        else	
        {
        	drops.add(new ItemStack(this.getSeed()));
        }
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(WART_AGE, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(WART_AGE)).intValue();
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {WART_AGE});
    }
    
    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        return super.canBlockStay(worldIn, pos, state);
    }
}
