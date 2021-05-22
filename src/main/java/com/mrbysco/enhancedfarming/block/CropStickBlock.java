package com.mrbysco.enhancedfarming.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.PlantType;

import java.util.stream.Stream;

public class CropStickBlock extends BushBlock {
    protected static final VoxelShape CROPSTICK_SHAPE = Stream.of(
			Block.box(4, 8, 10, 12, 9, 11),
			Block.box(5, -1, 5, 6, 12, 6),
			Block.box(10, -1, 5, 11, 12, 6),
			Block.box(10, -1, 10, 11, 12, 11),
			Block.box(5, -1, 10, 6, 12, 11),
			Block.box(10, 4, 4, 11, 5, 12),
			Block.box(5, 4, 4, 6, 5, 12),
			Block.box(4, 4, 10, 12, 5, 11),
			Block.box(4, 4, 5, 12, 5, 6),
			Block.box(4, 8, 5, 12, 9, 6),
			Block.box(5, 8, 4, 6, 9, 12),
			Block.box(10, 8, 4, 11, 9, 12)
		).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public CropStickBlock(AbstractBlock.Properties properties) {
		super(properties.strength(0.5F).sound(SoundType.WOOD));
	}

	@Override
	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
		return CROPSTICK_SHAPE;
	}

	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return PlantType.CROP;
	}

	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		if (state.getBlock() != this) return defaultBlockState();
		return state;
	}

	protected boolean mayPlaceOn(BlockState state, IBlockReader reader, BlockPos pos) {
		return state.is(Blocks.FARMLAND);
	}

	public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState soil = worldIn.getBlockState(pos.below());
        return (worldIn.getLightEmission(pos) >= 8 || worldIn.canSeeSky(pos)) && soil.getBlock().canSustainPlant(soil, worldIn, pos.below(), Direction.UP, this);
    }
}