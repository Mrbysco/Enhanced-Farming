package com.mrbysco.enhancedfarming.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
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
	).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public CropStickBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(0.5F).sound(SoundType.WOOD));
	}

	@Override
	public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
		return CROPSTICK_SHAPE;
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.CROP;
	}

	@Override
	public BlockState getPlant(BlockGetter world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		if (state.getBlock() != this) return defaultBlockState();
		return state;
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.is(Blocks.FARMLAND);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
		return (reader.getRawBrightness(pos, 0) >= 8 || reader.canSeeSky(pos)) && super.canSurvive(state, reader, pos);
	}
}