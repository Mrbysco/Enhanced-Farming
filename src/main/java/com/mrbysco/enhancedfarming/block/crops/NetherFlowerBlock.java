package com.mrbysco.enhancedfarming.block.crops;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class NetherFlowerBlock extends BushBlock implements IGrowable{

	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D)};
	public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public NetherFlowerBlock(AbstractBlock.Properties properties) {
		super(properties.randomTicks().sound(SoundType.CROP));
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	public ItemStack getCloneItemStack(IBlockReader reader, BlockPos pos, BlockState state) {
		return new ItemStack(FarmingRegistry.NETHER_FLOWER_SEEDS.get());
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}
    
	public int getMaxAge() {
		return 5;
	}
	
	protected int getAge(BlockState state) {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }
	
	public boolean isMaxAge(BlockState state) {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }

	public BlockState getStateForAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(age));
	}

	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return PlantType.NETHER;
	}

	public boolean isRandomlyTicking(BlockState p_149653_1_) {
		return p_149653_1_.getValue(AGE) < 5;
	}

	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		int i = state.getValue(AGE);
		if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, random.nextInt(10) == 0)) {
			state = state.setValue(AGE, Integer.valueOf(i + 1));
			world.setBlock(pos, state, 2);
			net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state);
		}
	}

	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
		return SHAPE_BY_AGE[p_220053_1_.getValue(AGE)];
	}

	@Override
    public boolean isBonemealSuccess(World worldIn, Random rand, BlockPos pos, BlockState state) {
    	if(FarmingConfig.COMMON.bonemealGrow.get()) {
    		return getAge(state) < getMaxAge();
    	} else {
    		return false;
    	}
    }

	protected int getBonemealAgeIncrease(World worldIn) {
		return MathHelper.nextInt(worldIn.getRandom(), 2, 5) / 2;
    }

	@Override
	public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}

	@Override
	public void performBonemeal(ServerWorld world, Random random, BlockPos pos, BlockState state) {
		int i;
		int j = this.getMaxAge();

		if (FarmingConfig.COMMON.instantGrow.get()) {
			i = getMaxAge();
		} else {
			i = this.getAge(state) + this.getBonemealAgeIncrease(world);
		}

		if (i > j) {
			i = j;
		}

		world.setBlock(pos, this.getStateForAge(i), 2);
	}

	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
		p_206840_1_.add(AGE);
	}
}
