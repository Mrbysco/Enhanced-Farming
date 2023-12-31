package com.mrbysco.enhancedfarming.block;

import com.mojang.serialization.MapCodec;
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
import net.neoforged.neoforge.common.PlantType;

import java.util.stream.Stream;

public class CropStickBlock extends BushBlock {
	public static final MapCodec<CropStickBlock> CODEC = simpleCodec(CropStickBlock::new);
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
	protected MapCodec<? extends BushBlock> codec() {
		return CODEC;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
		return CROPSTICK_SHAPE;
	}

	@Override
	public PlantType getPlantType(BlockGetter blockGetter, BlockPos pos) {
		return PlantType.CROP;
	}

	@Override
	public BlockState getPlant(BlockGetter blockGetter, BlockPos pos) {
		BlockState state = blockGetter.getBlockState(pos);
		if (state.getBlock() != this) return defaultBlockState();
		return state;
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
		return state.is(Blocks.FARMLAND);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
		return (reader.getRawBrightness(pos, 0) >= 8 || reader.canSeeSky(pos)) && super.canSurvive(state, reader, pos);
	}
}