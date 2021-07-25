package com.mrbysco.enhancedfarming.block;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.util.Mth;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;

import java.util.Random;
import java.util.function.Supplier;

public class FruitLeavesBlock extends LeavesBlock implements BonemealableBlock {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	public final Supplier<Item> itemSupplier;

	public FruitLeavesBlock(BlockBehaviour.Properties properties, Supplier<Item> itemSupplier) {
		super(properties.randomTicks().strength(0.2F).sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating(Blocks::never).isViewBlocking(Blocks::never));
		this.itemSupplier = itemSupplier;

		this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)).setValue(AGE, Integer.valueOf(3)));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
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
	public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		super.tick(state, world, pos, random);

		if(state.getValue(DISTANCE) <= 6) {
			if (!isMaxAge(state)) {
				if(!state.getValue(PERSISTENT)) {
					float f = 1.0F;
					if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
						this.grow(world, pos, state, 1);
						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state);
					}
				}
			} else {
				if(!world.isClientSide && !FarmingConfig.COMMON.rightClickFruitHarvest.get()) {
					if(random.nextInt(FarmingConfig.COMMON.treeDropChance.get()) == 0) {
						ItemEntity fruitItem = new ItemEntity(world, pos.getX(), pos.getY() - 0.2, pos.getZ(), new ItemStack(itemSupplier.get()));
						world.addFreshEntity(fruitItem);
						world.setBlock(pos, state.setValue(AGE, 0), 4);
					}
				}
			}
		}
	}

	@Override
	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult traceResult) {
		if(FarmingConfig.COMMON.rightClickFruitHarvest.get() && isMaxAge(state)) {
			ItemEntity fruitItem = new ItemEntity(world, pos.getX(), pos.getY() - 0.2, pos.getZ(), new ItemStack(itemSupplier.get()));
			world.addFreshEntity(fruitItem);
			world.setBlock(pos, state.setValue(AGE, 0), 4);

			return InteractionResult.SUCCESS;
		}
		return super.use(state, world, pos, player, hand, traceResult);
	}

	protected int getBonemealAgeIncrease(Level worldIn) {
		return Mth.nextInt(worldIn.random, 0, 2);
	}

	@Override
	public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
		this.grow(world, pos, state, this.getBonemealAgeIncrease(world));
	}

	public void grow(Level worldIn, BlockPos pos, BlockState state, int increaseBy) {
		int i = this.getAge(state) + increaseBy;
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}

		worldIn.setBlock(pos, this.withAge(i), 2);
	}

	@Override
	public boolean isValidBonemealTarget(BlockGetter blockReader, BlockPos pos, BlockState state, boolean isClient) {
		return !isMaxAge(state);
	}

	@Override
	public boolean isBonemealSuccess(Level world, Random random, BlockPos pos, BlockState state) {
		return (double)world.random.nextFloat() < 0.45D;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext useContext) {
		return super.getStateForPlacement(useContext).setValue(AGE, 3);
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> blockStateBuilder) {
		blockStateBuilder.add(DISTANCE, PERSISTENT, AGE);
	}
}
