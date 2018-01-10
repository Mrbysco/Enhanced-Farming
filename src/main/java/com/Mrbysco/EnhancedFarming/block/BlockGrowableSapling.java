package com.Mrbysco.EnhancedFarming.block;

import java.util.Random;

import com.Mrbysco.EnhancedFarming.EnhancedFarming;
import com.Mrbysco.EnhancedFarming.Reference;
import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.util.TreeHelper;
import com.Mrbysco.EnhancedFarming.world.WorldGenFruitTree;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockGrowableSapling extends BlockBush implements IGrowable, IPlantable{
	
	private EnumSaplingType TYPE;
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 4);
    
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public BlockGrowableSapling(String unlocalizedName, String registryName, EnumSaplingType type) {
		super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));

		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);	
        this.setCreativeTab(EnhancedFarming.tabFarming);
        
		this.TYPE = type;
	}
	
	public int getMatureStage() {
		return 3;
	}
	
	protected int getStage(IBlockState state)
    {
        return ((Integer)state.getValue(this.getStageProperty())).intValue();
    }
	
	protected PropertyInteger getStageProperty()
    {
        return STAGE;
    }
	
	public boolean isMature(IBlockState state) {
		return getMetaFromState(state) >= getMatureStage();
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0 && isMature(state) == true)
            {
                this.grow(worldIn, rand, pos, state);;
            }
        }
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
    	int i;
        int j = this.getMatureStage();;
        
    	if (FarmingConfigGen.general.othersettings.instantGrow)
    	{
    		i = this.getStage(state) + (j - this.getStage(state));
    	}
    	else
    	{
    		i = this.getStage(state) + this.getBonemealAgeIncrease(worldIn);
    	}

		if (i == j)
        {
            this.growTree(rand, worldIn, pos);
        }
        else
        {
        	worldIn.setBlockState(pos, state.cycleProperty(STAGE), 2);
        }
    }
    
    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
    	if(FarmingConfigGen.general.othersettings.bonemealGrow)
    	{
    		return (double)worldIn.rand.nextFloat() < 0.45D;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    protected int getBonemealAgeIncrease(World worldIn)
    {
        return MathHelper.getInt(worldIn.rand, 2, 5) / 5;
    }

	private void growTree(Random rand, World worldIn, BlockPos pos) {
		if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) {
            return;
        }
        worldIn.setBlockToAir(pos);
		
		new WorldGenFruitTree(this.TYPE).generate(worldIn, rand, pos);
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		ItemStack pickStack = new ItemStack(TreeHelper.getSaplingFromEnum(this.TYPE));

		return pickStack;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(STAGE, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
        return ((Integer)state.getValue(STAGE)).intValue();
	}
	
	@Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {STAGE});
    }
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SAPLING_AABB;
    }
}
