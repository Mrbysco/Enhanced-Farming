package com.mrbysco.enhancedfarming.block.crops;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.item.Item;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;

import java.util.Random;
import java.util.function.Supplier;

public class SixAgeCropBlock extends CropsBlock {

	private final Supplier<Item> baseSeedSupplier;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

	public SixAgeCropBlock(AbstractBlock.Properties properties, Supplier<Item> baseSeedSupplier) {
		super(properties);
		this.baseSeedSupplier = baseSeedSupplier;
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
		return SHAPE_BY_AGE[p_220053_1_.getValue(this.getAgeProperty())];
	}

	@Override
	protected IItemProvider getBaseSeedId() {
		return baseSeedSupplier.get();
	}

	@Override
	public void growCrops(World worldIn, BlockPos pos, BlockState state) {
		int i;
		int j = this.getMaxAge();

		if (FarmingConfig.COMMON.instantGrow.get()) {
			i = getMaxAge();
		} else {
			i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
		}

		if (i > j) {
			i = j;
		}

		worldIn.setBlock(pos, this.getStateForAge(i), 2);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	protected boolean mayPlaceOn(BlockState state, IBlockReader reader, BlockPos pos) {
		return state.is(Blocks.FARMLAND);
	}

	@Override
	public int getMaxAge() {
		return 6;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (!world.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if(random.nextInt(5) == 0) {
			this.canSurvive(state, world, pos);
		} else {
			if (world.getRawBrightness(pos, 0) >= 9) {
				int i = this.getAge(state);
				if (i < this.getMaxAge()) {
					float f = getGrowthSpeed(this, world, pos);
					if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
						world.setBlock(pos, this.getStateForAge(i + 1), 2);
						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state);
					}
				}
			}
		}
	}

	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> blockStateBuilder) {
		blockStateBuilder.add(AGE);
	}

	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return PlantType.CROP;
	}

	@Override
	public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
		if(FarmingConfig.COMMON.bonemealGrow.get()) {
			return getAge(state) < getMaxAge();
		} else {
			return false;
		}
	}

	@Override
	protected int getBonemealAgeIncrease(World worldIn) {
		return super.getBonemealAgeIncrease(worldIn) / 2;
	}
}