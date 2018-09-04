package com.Mrbysco.EnhancedFarming.block;

import java.util.Random;

import com.Mrbysco.EnhancedFarming.Reference;
import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.init.FarmingColors;
import com.Mrbysco.EnhancedFarming.util.TreeHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFruitLeaves extends BlockLeaves implements ILeafColor{

	public EnumSaplingType fruitType;

	public BlockFruitLeaves(String registryName, EnumSaplingType type) {
		super();
        this.setTickRandomly(true);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setSoundType(SoundType.PLANT);

        this.fruitType = type;

        this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.setUnlocalizedName(Reference.MOD_PREFIX + registryName.replaceAll("_", ""));
		this.setRegistryName(registryName);
	}
	
	@Override
	public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
    }
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
		int i = 0;
		if(!((Boolean) state.getValue((IProperty) DECAYABLE)).booleanValue())
		{
			i |= 2;
		}
		if(((Boolean) state.getValue((IProperty) CHECK_DECAY)).booleanValue())
		{
			i |= 4;
		}
		return i;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 2) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 4) > 0));
    }
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		ItemStack fruit = new ItemStack(TreeHelper.getFruitfromEnum(this.fruitType));
		EntityItem fruitItem = new EntityItem(worldIn, pos.getX(), pos.getY() - 0.2, pos.getZ(), fruit);
		boolean decayFlag = FarmingConfigGen.general.othersettings.oldLeaveDecay;

		boolean decay_value = ((Boolean)state.getValue(DECAYABLE)).booleanValue();
		boolean check_value = ((Boolean)state.getValue(CHECK_DECAY)).booleanValue();
		IBlockState regularLeaf = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(DECAYABLE, Boolean.valueOf(decay_value)).withProperty(CHECK_DECAY, Boolean.valueOf(check_value));
		IBlockState notFruity = TreeHelper.getBloomingLeaveFromEnum(this.fruitType).withProperty(DECAYABLE, Boolean.valueOf(decay_value)).withProperty(CHECK_DECAY, Boolean.valueOf(check_value));
		
		
		if (((Boolean)state.getValue(DECAYABLE)).booleanValue())
		{
			if (worldIn.getChunkFromBlockCoords(pos).isLoaded())
			{
				if (random.nextInt(FarmingConfigGen.general.othersettings.treeDropRate) == 0)
				{
					if (!worldIn.isRemote)
					{
						worldIn.spawnEntity(fruitItem);
					}
					
					if (decayFlag)
					{
						if (random.nextInt(3) == 0)
						{
							worldIn.setBlockState(pos, regularLeaf, 6);
						}
					}
					
					if (!decayFlag)
					{
			            worldIn.setBlockState(pos, notFruity, 6);
					}
						
				}
			}
		}

        this.updateTick(worldIn, pos, state, random);
	}
	

	@Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
    	IBlockState newState = state.withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false));
    	
    	return super.getSilkTouchDrop(newState);
    }
	
	/*
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
    	return new ItemStack(this, 1, this.getMetaFromState(this.getDefaultState().withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false))));
	}*/
	
	@Override
	public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack((Block) this, 1) );
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return TreeHelper.getFruitfromEnum(this.fruitType);
	}
    
    @SideOnly(Side.CLIENT)
    public IBlockColor getBlockColor()
    {
        return new IBlockColor()
        {
            @Override
            public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex)
            {
            	boolean inWorld = world != null && pos != null;
    			if (tintIndex == 0) 
    			{
    				return inWorld ? BiomeColorHelper.getFoliageColorAtPos(world, pos) : ColorizerFoliage.getFoliageColorBasic();
    			}
    			else
    			return 0xFFFFFF;
            }
        };
    }
    
    @SideOnly(Side.CLIENT)
    public IItemColor getItemColor() { 
    	return FarmingColors.ITEM_RENDER; 
    }

	@Override
	public EnumType getWoodType(int meta) {
		return null;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return Blocks.LEAVES.getFlammability(world, pos, face);
	}
	
	@Override
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
		return Blocks.LEAVES.getFireSpreadSpeed(world, pos, face);
    }
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		 return this.getStateFromMeta(meta).withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false));	
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return true;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
	}
}
