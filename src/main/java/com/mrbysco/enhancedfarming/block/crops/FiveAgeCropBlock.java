package com.mrbysco.enhancedfarming.block.crops;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.ItemLike;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.common.PlantType;

import java.util.Random;
import java.util.function.Supplier;

public class FiveAgeCropBlock extends CropBlock {

	private final Supplier<Item> baseSeedSupplier;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{ Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public FiveAgeCropBlock(BlockBehaviour.Properties properties, Supplier<Item> baseSeedSupplier) {
		super(properties);
		this.baseSeedSupplier = baseSeedSupplier;
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	public VoxelShape getShape(BlockState p_220053_1_, BlockGetter p_220053_2_, BlockPos p_220053_3_, CollisionContext p_220053_4_) {
		return SHAPE_BY_AGE[p_220053_1_.getValue(this.getAgeProperty())];
	}

	@Override
	protected ItemLike getBaseSeedId() {
		return baseSeedSupplier.get();
	}
    
    @Override
    public void growCrops(Level worldIn, BlockPos pos, BlockState state) {
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

	protected boolean mayPlaceOn(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.is(Blocks.FARMLAND);
	}
    
	@Override
	public int getMaxAge() {
		return 5;
	}

	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
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
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
		blockStateBuilder.add(AGE);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.CROP;
	}
    
    @Override
    public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
    	if(FarmingConfig.COMMON.bonemealGrow.get()) {
    		return getAge(state) < getMaxAge();
    	} else {
    		return false;
    	}
    }
    
    @Override
    protected int getBonemealAgeIncrease(Level worldIn) {
        return super.getBonemealAgeIncrease(worldIn) / 2;
    }
}