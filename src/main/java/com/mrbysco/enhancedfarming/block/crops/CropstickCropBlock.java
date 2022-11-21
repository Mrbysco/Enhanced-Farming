package com.mrbysco.enhancedfarming.block.crops;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class CropstickCropBlock extends CropBlock {
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	private final Supplier<Item> baseSeedSupplier;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

	public CropstickCropBlock(BlockBehaviour.Properties properties, Supplier<Item> baseSeedSupplier) {
		super(properties.strength(0.5F));
		this.baseSeedSupplier = baseSeedSupplier;
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos p2200533, CollisionContext context) {
		return SHAPE;
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
		return 5;
	}

	@Override
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity tileEntity, ItemStack stack) {
		if (!level.isClientSide) {
			level.setBlock(pos, FarmingRegistry.CROP_STICK.get().defaultBlockState(), 6);
		}
		super.playerDestroy(level, player, pos, state, tileEntity, stack);
	}

	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (!level.isAreaLoaded(pos, 1))
			return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (random.nextInt(5) == 0) {
			this.canSurvive(state, level, pos);
		} else {
			if (level.getRawBrightness(pos, 0) >= 9) {
				int i = this.getAge(state);
				if (i < this.getMaxAge()) {
					float f = getGrowthSpeed(this, level, pos);
					if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
						level.setBlock(pos, this.getStateForAge(i + 1), 2);
						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
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