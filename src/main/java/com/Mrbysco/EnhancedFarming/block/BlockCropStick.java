package com.Mrbysco.EnhancedFarming.block;

import java.util.Random;

import com.Mrbysco.EnhancedFarming.EnhancedFarming;
import com.Mrbysco.EnhancedFarming.Reference;

import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockCropStick extends BlockBush
{
    protected static final AxisAlignedBB CROPSTICK_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.6000000238418579D, 0.699999988079071D);

    public BlockCropStick(String unlocalizedName, String registryName) {
    	super();
        this.setHardness(1.0F);
        this.disableStats();
        this.setTickRandomly(false);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(EnhancedFarming.tabFarming);

		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
	}
    
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CROPSTICK_AABB;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    	return Items.STICK;
    }
    
    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
    		int fortune) {
    	super.getDrops(drops, world, pos, state, fortune);
    	drops.add(new ItemStack(Items.STICK, 3));
    }
    
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
	}

	/**
     * Return true if the block can sustain a Bush
     */
    protected boolean canSustainBush(IBlockState state)
    {
        return state.getBlock() == Blocks.FARMLAND;
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos)) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
}