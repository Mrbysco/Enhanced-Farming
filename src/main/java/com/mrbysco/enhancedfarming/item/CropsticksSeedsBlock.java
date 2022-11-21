package com.mrbysco.enhancedfarming.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CropsticksSeedsBlock extends CustomBlockNamedItem {

//    private final Block crops;

	public CropsticksSeedsBlock(Block crops, Item.Properties properties) {
		super(crops, properties);
	}

//	@Override
//	public ActionResultType onItemUse(PlayerEntity player, World level, BlockPos pos, Hand hand, Direction facing, float hitX, float hitY, float hitZ)
//    {
//        ItemStack itemstack = player.getHeldItem(hand);
//        BlockState state = level.getBlockState(pos);
//
//        if (possibleSide(facing) && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && state.getBlock() instanceof CropStickBlock)
//        {
//            level.setBlockState(pos, this.crops.getDefaultState());
//
//            itemstack.shrink(1);
//            return ActionResultType.SUCCESS;
//        }
//        else
//        {
//            return ActionResultType.FAIL;
//        }
//    }
//
//	public boolean possibleSide(Direction facing) {
//        if (!(facing == Direction.DOWN))
//        	return true;
//        else
//        	return false;
//	}
//
//    @Override
//    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
//    {
//        return EnumPlantType.Crop;
//    }
//
//    @Override
//    public BlockState getPlant(IBlockAccess world, BlockPos pos)
//    {
//        return this.crops.getDefaultState();
//    }
}
