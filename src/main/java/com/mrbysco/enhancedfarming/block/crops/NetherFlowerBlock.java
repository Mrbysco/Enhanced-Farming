package com.mrbysco.enhancedfarming.block.crops;

import com.mojang.serialization.MapCodec;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import net.neoforged.neoforge.common.PlantType;

import java.util.Random;

public class NetherFlowerBlock extends BushBlock implements BonemealableBlock {
	public static final MapCodec<NetherFlowerBlock> CODEC = simpleCodec(NetherFlowerBlock::new);
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D),
			Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D)};
	public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

	public NetherFlowerBlock(BlockBehaviour.Properties properties) {
		super(properties.randomTicks().sound(SoundType.CROP));
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	@Override
	protected MapCodec<? extends BushBlock> codec() {
		return CODEC;
	}

	public ItemStack getCloneItemStack(BlockGetter reader, BlockPos pos, BlockState state) {
		return new ItemStack(FarmingRegistry.NETHER_FLOWER_SEEDS.get());
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.is(Blocks.SOUL_SAND);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return 5;
	}

	protected int getAge(BlockState state) {
		return ((Integer) state.getValue(this.getAgeProperty())).intValue();
	}

	public boolean isMaxAge(BlockState state) {
		return ((Integer) state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
	}

	public BlockState getStateForAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(age));
	}

	@Override
	public PlantType getPlantType(BlockGetter blockGetter, BlockPos pos) {
		return PlantType.NETHER;
	}

	public boolean isRandomlyTicking(BlockState state) {
		return state.getValue(AGE) < 5;
	}

	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
		int i = state.getValue(AGE);
		int maxAge = this.getMaxAge();
		if (i < maxAge && CommonHooks.onCropsGrowPre(level, pos, state, random.nextInt(10) == 0)) {
			state = state.setValue(AGE, Integer.valueOf(i + 1));
			level.setBlock(pos, state, 2);
			CommonHooks.onCropsGrowPost(level, pos, state);
		}
	}

	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[state.getValue(AGE)];
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state) {
		if (FarmingConfig.COMMON.bonemealGrow.get()) {
			return getAge(state) < getMaxAge();
		} else {
			return false;
		}
	}

	protected int getBonemealAgeIncrease(Level level) {
		return Mth.nextInt(level.getRandom(), 2, 5) / 2;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader blockGetter, BlockPos pos, BlockState state) {
		return !this.isMaxAge(state);
	}

	@Override
	public void performBonemeal(ServerLevel serverLevel, RandomSource random, BlockPos pos, BlockState state) {
		int i;
		int j = this.getMaxAge();

		if (FarmingConfig.COMMON.instantGrow.get()) {
			i = getMaxAge();
		} else {
			i = this.getAge(state) + this.getBonemealAgeIncrease(serverLevel);
		}

		if (i > j) {
			i = j;
		}

		serverLevel.setBlock(pos, this.getStateForAge(i), 2);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
		stateBuilder.add(AGE);
	}
}
