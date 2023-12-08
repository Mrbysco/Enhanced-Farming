package com.mrbysco.enhancedfarming.item;

import com.mrbysco.enhancedfarming.block.CropStickBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class CropsticksSeedsBlock extends ItemNameBlockItem {

	public CropsticksSeedsBlock(Block crops, Item.Properties properties) {
		super(crops, properties);
	}

	@Override
	protected boolean canPlace(BlockPlaceContext placeContext, BlockState cropState) {
		//Check if right-clicked on a Crop Stick else return false
		BlockPos pos = placeContext.getClickedPos().relative(placeContext.getClickedFace().getOpposite());
		BlockState state = placeContext.getLevel().getBlockState(pos);
		if (!(state.getBlock() instanceof CropStickBlock))
			return false;
		return cropState.canSurvive(placeContext.getLevel(), pos);
	}

	@Override
	protected boolean placeBlock(BlockPlaceContext placeContext, BlockState state) {
		BlockPos pos = placeContext.getClickedPos().relative(placeContext.getClickedFace().getOpposite());
		return placeContext.getLevel().setBlock(pos, state, 11);
	}
}
