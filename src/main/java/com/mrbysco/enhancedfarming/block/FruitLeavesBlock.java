package com.mrbysco.enhancedfarming.block;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class FruitLeavesBlock extends LeavesBlock implements BonemealableBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	public final Supplier<Item> itemSupplier;

	public FruitLeavesBlock(BlockBehaviour.Properties properties, Supplier<Item> itemSupplier) {
		super(properties.randomTicks().strength(0.2F).sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating(Blocks::never).isViewBlocking(Blocks::never));
		this.itemSupplier = itemSupplier;

		this.registerDefaultState(this.stateDefinition.any()
				.setValue(DISTANCE, Integer.valueOf(7))
				.setValue(PERSISTENT, Boolean.valueOf(false))
				.setValue(WATERLOGGED, Boolean.valueOf(false))
				.setValue(AGE, Integer.valueOf(3)));

	}

	@Override
	public int getFlammability(BlockState state, BlockGetter blockGetter, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter blockGetter, BlockPos pos, Direction face) {
		return 30;
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	protected int getAge(BlockState state) {
		return state.getValue(this.getAgeProperty());
	}

	public int getMaxAge() {
		return 3;
	}

	public BlockState withAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(age));
	}

	public boolean isMaxAge(BlockState state) {
		return state.getValue(this.getAgeProperty()) >= this.getMaxAge();
	}

	@Override
	public void tick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource random) {
		super.tick(state, serverLevel, pos, random);

		if (state.getValue(DISTANCE) <= 6) {
			if (!isMaxAge(state)) {
				if (!state.getValue(PERSISTENT)) {
					float f = 1.0F;
					if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(serverLevel, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
						this.grow(serverLevel, pos, state, 1);
						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(serverLevel, pos, state);
					}
				}
			} else {
				if (!state.getValue(PERSISTENT)) {
					if (!serverLevel.isClientSide && !FarmingConfig.COMMON.rightClickFruitHarvest.get()) {
						if (random.nextInt(FarmingConfig.COMMON.treeDropChance.get()) == 0) {
							ItemEntity fruitItem = new ItemEntity(serverLevel, pos.getX(), pos.getY() - 0.2, pos.getZ(), new ItemStack(itemSupplier.get()));
							serverLevel.addFreshEntity(fruitItem);
							serverLevel.setBlock(pos, state.setValue(AGE, 0), 4);
						}
					}
				}
			}
		}
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
		if (FarmingConfig.COMMON.rightClickFruitHarvest.get() && isMaxAge(state)) {
			if (FarmingConfig.COMMON.relocationAllowed.get() || !state.getValue(PERSISTENT)) {
				ItemEntity fruitItem = new ItemEntity(level, pos.getX(), pos.getY() - 0.2, pos.getZ(), new ItemStack(itemSupplier.get()));
				level.addFreshEntity(fruitItem);
				level.setBlock(pos, state.setValue(AGE, 0), 4);
			}

			return InteractionResult.SUCCESS;
		}
		return super.use(state, level, pos, player, hand, result);
	}

	protected int getBonemealAgeIncrease(Level level) {
		return Mth.nextInt(level.random, 0, 2);
	}

	@Override
	public void performBonemeal(ServerLevel serverLevel, RandomSource random, BlockPos pos, BlockState state) {
		this.grow(serverLevel, pos, state, this.getBonemealAgeIncrease(serverLevel));
	}

	public void grow(Level level, BlockPos pos, BlockState state, int increaseBy) {
		int i = this.getAge(state) + increaseBy;
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}

		level.setBlock(pos, this.withAge(i), 2);
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader blockGetter, BlockPos pos, BlockState state, boolean isClient) {
		return !isMaxAge(state);
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return (double) level.random.nextFloat() < 0.45D;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
		return super.getStateForPlacement(placeContext).setValue(AGE, 0);
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> blockStateBuilder) {
		blockStateBuilder.add(DISTANCE, PERSISTENT, WATERLOGGED, AGE);
	}
}
