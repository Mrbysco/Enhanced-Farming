package com.mrbysco.enhancedfarming.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.bus.api.Event;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.level.SaplingGrowTreeEvent;

public class GrowableSaplingBlock extends BushBlock implements BonemealableBlock {
	public static final MapCodec<GrowableSaplingBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
		return instance.group(TreeGrower.CODEC.fieldOf("tree").forGetter((saplingBlock) -> {
			return saplingBlock.treeGrower;
		}), propertiesCodec()).apply(instance, GrowableSaplingBlock::new);
	});
	public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 4);

	private static final VoxelShape[] SHAPE_BY_STAGE = new VoxelShape[]{
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D)};
	private final TreeGrower treeGrower;

	public GrowableSaplingBlock(TreeGrower tree, BlockBehaviour.Properties properties) {
		super(properties);
		this.treeGrower = tree;
		this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
	}

	@Override
	protected MapCodec<? extends BushBlock> codec() {
		return CODEC;
	}

	public IntegerProperty getStageProperty() {
		return STAGE;
	}

	public int getMatureStage() {
		return 4;
	}

	protected int getStage(BlockState state) {
		return ((Integer) state.getValue(this.getStageProperty())).intValue();
	}

	public boolean isMature(BlockState state) {
		return getStage(state) >= getMatureStage();
	}

	@Override
	public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource random) {
		if (serverLevel.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(7) == 0) {
			if (!serverLevel.isAreaLoaded(pos, 1))
				return; // Forge: prevent loading unloaded chunks when checking neighbor's light
			this.advanceTree(serverLevel, pos, state, random);
		}
	}

	public void advanceTree(ServerLevel serverLevel, BlockPos pos, BlockState state, RandomSource random) {
		if (!isMature(state)) {
			if (FarmingConfig.COMMON.instantGrow.get()) {
				serverLevel.setBlock(pos, state.setValue(STAGE, getMatureStage()), 4);
			} else {
				serverLevel.setBlock(pos, state.cycle(STAGE), 4);
			}
		} else {
			SaplingGrowTreeEvent event = EventHooks.blockGrowFeature(serverLevel, random, pos, null);
			if (event.getResult().equals(Event.Result.DENY)) return;
			this.treeGrower.growTree(serverLevel, serverLevel.getChunkSource().getGenerator(), pos, state, random);
		}
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader reader, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return (double) level.random.nextFloat() < 0.45D;
	}

	protected int getBonemealAgeIncrease(Level level) {
		return Mth.nextInt(level.random, 2, 5) / 4;
	}

	public void performBonemeal(ServerLevel serverLevel, RandomSource random, BlockPos pos, BlockState state) {
		if (!isMature(state)) {
			int i;
			int j = this.getMatureStage();

			if (FarmingConfig.COMMON.instantGrow.get()) {
				i = getMatureStage();
			} else {
				i = this.getStage(state) + this.getBonemealAgeIncrease(serverLevel);
			}

			if (i > j) {
				i = j;
			}

			if (FarmingConfig.COMMON.instantGrow.get()) {
				serverLevel.setBlock(pos, state.setValue(STAGE, getMatureStage()), 4);
			} else {
				serverLevel.setBlock(pos, state.setValue(STAGE, i), 4);
			}
		} else {
			this.advanceTree(serverLevel, pos, state, random);
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
