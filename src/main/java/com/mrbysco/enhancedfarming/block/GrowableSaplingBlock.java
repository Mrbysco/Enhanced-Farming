package com.mrbysco.enhancedfarming.block;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class GrowableSaplingBlock extends BushBlock implements BonemealableBlock {
	public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 4);

	private static final VoxelShape[] SHAPE_BY_STAGE = new VoxelShape[]{
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D)};
	private final AbstractTreeGrower treeGrower;

	public GrowableSaplingBlock(AbstractTreeGrower tree, BlockBehaviour.Properties properties) {
		super(properties);
		this.treeGrower = tree;
		this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
	}

	public IntegerProperty getStageProperty() {
		return STAGE;
	}

	public int getMatureStage() {
		return 4;
	}

	protected int getStage(BlockState state) {
        return ((Integer)state.getValue(this.getStageProperty())).intValue();
    }

	public boolean isMature(BlockState state) {
		return getStage(state) >= getMatureStage();
	}

	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		if (world.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(7) == 0) {
			if (!world.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
			this.advanceTree(world, pos, state, random);
		}
	}

	public void advanceTree(ServerLevel world, BlockPos pos, BlockState state, Random random) {
		if (!isMature(state)) {
			if(FarmingConfig.COMMON.instantGrow.get()) {
				world.setBlock(pos, state.setValue(STAGE, getMatureStage()), 4);
			} else {
				world.setBlock(pos, state.cycle(STAGE), 4);
			}
		} else {
			if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(world, random, pos)) return;
			this.treeGrower.growTree(world, world.getChunkSource().getGenerator(), pos, state, random);
		}
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter reader, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

    @Override
    public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
		return (double)world.random.nextFloat() < 0.45D;
	}

    protected int getBonemealAgeIncrease(Level worldIn) {
		return Mth.nextInt(worldIn.random, 2, 5) / 4;
	}

	public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
		if (!isMature(state)) {
			int i;
			int j = this.getMatureStage();

			if (FarmingConfig.COMMON.instantGrow.get()) {
				i = getMatureStage();
			} else {
				i = this.getStage(state) + this.getBonemealAgeIncrease(world);
			}

			if (i > j) {
				i = j;
			}

			if(FarmingConfig.COMMON.instantGrow.get()) {
				world.setBlock(pos, state.setValue(STAGE, getMatureStage()), 4);
			} else {
				world.setBlock(pos, state.setValue(STAGE, i), 4);
			}
		} else {
			this.advanceTree(world, pos, state, random);
		}
	}

	public VoxelShape getShape(BlockState state, BlockGetter blockReader, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_STAGE[state.getValue(this.getStageProperty())];
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
		blockStateBuilder.add(STAGE);
	}
}
