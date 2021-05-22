package com.mrbysco.enhancedfarming.block;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Supplier;

public class FruitLeavesBlock extends LeavesBlock implements IGrowable {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	public final Supplier<Item> itemSupplier;

	public FruitLeavesBlock(AbstractBlock.Properties properties, Supplier<Item> itemSupplier) {
		super(properties.randomTicks().strength(0.2F).sound(SoundType.GRASS).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating(Blocks::never).isViewBlocking(Blocks::never));
		this.itemSupplier = itemSupplier;

		this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)).setValue(AGE, Integer.valueOf(3)));
	}

	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
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
	public void tick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
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
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult traceResult) {
		if(FarmingConfig.COMMON.rightClickFruitHarvest.get() && isMaxAge(state)) {
			ItemEntity fruitItem = new ItemEntity(world, pos.getX(), pos.getY() - 0.2, pos.getZ(), new ItemStack(itemSupplier.get()));
			world.addFreshEntity(fruitItem);
			world.setBlock(pos, state.setValue(AGE, 0), 4);

			return ActionResultType.SUCCESS;
		}
		return super.use(state, world, pos, player, hand, traceResult);
	}

	protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.nextInt(worldIn.random, 0, 2);
	}

	@Override
	public void performBonemeal(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		this.grow(world, pos, state, this.getBonemealAgeIncrease(world));
	}

	public void grow(World worldIn, BlockPos pos, BlockState state, int increaseBy) {
		int i = this.getAge(state) + increaseBy;
		int j = this.getMaxAge();
		if (i > j) {
			i = j;
		}

		worldIn.setBlock(pos, this.withAge(i), 2);
	}

	@Override
	public boolean isValidBonemealTarget(IBlockReader blockReader, BlockPos pos, BlockState state, boolean isClient) {
		return !isMaxAge(state);
	}

	@Override
	public boolean isBonemealSuccess(World world, Random random, BlockPos pos, BlockState state) {
		return (double)world.random.nextFloat() < 0.45D;
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext useContext) {
		return super.getStateForPlacement(useContext).setValue(AGE, 3);
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> blockStateBuilder) {
		blockStateBuilder.add(DISTANCE, PERSISTENT, AGE);
	}
}
