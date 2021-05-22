package com.mrbysco.enhancedfarming.block;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class GrowableSaplingBlock extends BushBlock implements IGrowable {
	public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 4);

	private static final VoxelShape[] SHAPE_BY_STAGE = new VoxelShape[]{
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D)};
	private final Tree treeGrower;

	public GrowableSaplingBlock(Tree tree, AbstractBlock.Properties properties) {
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
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (world.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(7) == 0) {
			if (!world.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
			this.advanceTree(world, pos, state, random);
		}
	}

	public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random random) {
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
	public boolean isValidBonemealTarget(IBlockReader reader, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

    @Override
    public boolean isBonemealSuccess(World world, Random random, BlockPos pos, BlockState state) {
		return (double)world.random.nextFloat() < 0.45D;
	}

    protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.nextInt(worldIn.random, 2, 5) / 4;
	}

	public void performBonemeal(ServerWorld world, Random random, BlockPos pos, BlockState state) {
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

	public VoxelShape getShape(BlockState state, IBlockReader blockReader, BlockPos pos, ISelectionContext context) {
		return SHAPE_BY_STAGE[state.getValue(this.getStageProperty())];
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> blockStateBuilder) {
		blockStateBuilder.add(STAGE);
	}
}
