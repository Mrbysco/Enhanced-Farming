package com.Mrbysco.EnhancedFarming.block;

import java.util.Random;

import com.Mrbysco.EnhancedFarming.Reference;
import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.init.FarmingColors;
import com.Mrbysco.EnhancedFarming.util.TreeHelper;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFruitLeaves extends BlockLeaves {

	public EnumSaplingType fruitType;
    public static final PropertyBool FRUITY = PropertyBool.create("fruity");
    int[] surroundings;

	public BlockFruitLeaves(String unlocalizedName, String registryName, EnumSaplingType type) {
		super();
        this.setTickRandomly(true);
        this.setHardness(0.2F);
        this.setLightOpacity(1);
        this.setSoundType(SoundType.PLANT);

        this.fruitType = type;

        this.setDefaultState(getDefaultState().withProperty(FRUITY, Boolean.valueOf(true)).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
	}
	
	@Override
	public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FRUITY, CHECK_DECAY, DECAYABLE});
    }
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = ((Boolean)state.getValue(FRUITY)).booleanValue() ? 1 : 0;

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 8;
        }
        
        return i;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FRUITY, this.getFruityness(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		ItemStack fruit = new ItemStack(TreeHelper.getFruitfromEnum(this.fruitType));
		EntityItem fruitItem = new EntityItem(worldIn, pos.getX(), pos.getY() - 0.2, pos.getZ(), fruit);
		IBlockState regularLeaf = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockOldLeaf.CHECK_DECAY, Boolean.valueOf(false));

		if (FarmingConfigGen.general.othersettings.oldLeaveDecay)
		{
			if (((Boolean)state.getValue(FRUITY)).booleanValue()){
				if (worldIn.getChunkFromBlockCoords(pos).isLoaded())
				{
					if (random.nextInt(FarmingConfigGen.general.othersettings.treeDropRate) == 0)
					{
						if (!worldIn.isRemote)
						{
							worldIn.spawnEntity(fruitItem);
						}
						
						if (random.nextInt(2) == 0)
						{
				            worldIn.setBlockState(pos, regularLeaf, 2);
						}
					}
				}
			}
		}
		else
		{
			if (((Boolean)state.getValue(FRUITY)).booleanValue()){
				if (worldIn.getChunkFromBlockCoords(pos).isLoaded())
				{
					if (random.nextInt(FarmingConfigGen.general.othersettings.treeDropRate) == 0)
					{
						fruitItem.setAgeToCreativeDespawnTime();
						
						if (!worldIn.isRemote)
						{
							worldIn.spawnEntity(fruitItem);
						}
			            worldIn.setBlockState(pos, state.withProperty(FRUITY, Boolean.valueOf(false)), 2);
					}
				}
			}
			else
			{
				if (worldIn.getChunkFromBlockCoords(pos).isLoaded())
				{
					if (random.nextInt(4) == 1)
					{
						if(random.nextInt(2) == 1)
						{
							worldIn.setBlockState(pos, state.withProperty(FRUITY, Boolean.valueOf(true)), 2);
						}
					}
				}
			}
		}
		
        this.updateTick(worldIn, pos, state, random);
	}
	

	@Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
    	IBlockState newState = state.withProperty(FRUITY, Boolean.valueOf(false)).withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false));
    	
    	return super.getSilkTouchDrop(newState);
    }
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
    	IBlockState newState = state.withProperty(FRUITY, Boolean.valueOf(false)).withProperty(CHECK_DECAY, Boolean.valueOf(false)).withProperty(DECAYABLE, Boolean.valueOf(false));

		return super.getPickBlock(newState, target, world, pos, player);
	}
	
	@Override
	public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		IBlockState state = world.getBlockState(pos);

		return NonNullList.withSize(1, new ItemStack(this, 1));
	}

	public boolean getFruityness(int meta)
    {
		boolean myBool;
		
		if (meta == 1)
			myBool = true;
		else
			myBool = false;
		
        return myBool;
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return TreeHelper.getFruitfromEnum(this.fruitType);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return Blocks.LEAVES.isOpaqueCube(state);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return Blocks.LEAVES.shouldSideBeRendered(state, world, pos, side);
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
}
