package com.mrbysco.enhancedfarming.block.crops;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

import java.util.function.Supplier;

public class SixAgeCropBlock extends CropBlock {

	private final Supplier<Item> baseSeedSupplier;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

	public SixAgeCropBlock(BlockBehaviour.Properties properties, Supplier<Item> baseSeedSupplier) {
		super(properties);
		this.baseSeedSupplier = baseSeedSupplier;
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos p2200533, CollisionContext context) {
		return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
	}

	@Override
	protected ItemLike getBaseSeedId() {
		return baseSeedSupplier.get();
	}

	@Override
	public void growCrops(Level level, BlockPos pos, BlockState state) {
		int i;
		int j = this.getMaxAge();

		if (FarmingConfig.COMMON.instantGrow.get()) {
			i = getMaxAge();
		} else {
			i = this.getAge(state) + this.getBonemealAgeIncrease(level);
		}

		if (i > j) {
			i = j;
		}

		level.setBlock(pos, this.getStateForAge(i), 2);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	protected boolean mayPlaceOn(BlockState state, BlockGetter blockGetter, BlockPos pos) {
		return state.is(Blocks.FARMLAND);
	}

	@Override
	public int getMaxAge() {
		return 6;
	}

	@Override
	public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource random) {
		if (!serverLevel.isAreaLoaded(pos, 1))
			return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (random.nextInt(5) == 0) {
			this.canSurvive(state, serverLevel, pos);
		} else {
			if (serverLevel.getRawBrightness(pos, 0) >= 9) {
				int i = this.getAge(state);
				if (i < this.getMaxAge()) {
					float f = getGrowthSpeed(this, serverLevel, pos);
					if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(serverLevel, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
						serverLevel.setBlock(pos, this.getStateForAge(i + 1), 2);
						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(serverLevel, pos, state);
					}
				}
			}
		}
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
		blockStateBuilder.add(AGE);
	}

	@Override
	public PlantType getPlantType(BlockGetter blockGetter, BlockPos pos) {
		return PlantType.CROP;
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource rand, BlockPos pos, BlockState state) {
		if (FarmingConfig.COMMON.bonemealGrow.get()) {
			return getAge(state) < getMaxAge();
		} else {
			return false;
		}
	}

	@Override
	protected int getBonemealAgeIncrease(Level level) {
		return super.getBonemealAgeIncrease(level) / 2;
	}
}