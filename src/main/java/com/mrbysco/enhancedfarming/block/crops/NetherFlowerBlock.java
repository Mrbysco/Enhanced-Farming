package com.mrbysco.enhancedfarming.block.crops;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class NetherFlowerBlock extends BushBlock implements BonemealableBlock{

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
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }
	
	public boolean isMaxAge(BlockState state) {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }

	public BlockState getStateForAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), Integer.valueOf(age));
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.NETHER;
	}

	public boolean isRandomlyTicking(BlockState p_149653_1_) {
		return p_149653_1_.getValue(AGE) < 5;
	}

	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
		int i = state.getValue(AGE);
		if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(world, pos, state, random.nextInt(10) == 0)) {
			state = state.setValue(AGE, Integer.valueOf(i + 1));
			world.setBlock(pos, state, 2);
			net.minecraftforge.common.ForgeHooks.onCropsGrowPost(world, pos, state);
		}
	}

	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[state.getValue(AGE)];
	}

	@Override
    public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
    	if(FarmingConfig.COMMON.bonemealGrow.get()) {
    		return getAge(state) < getMaxAge();
    	} else {
    		return false;
    	}
    }

	protected int getBonemealAgeIncrease(Level worldIn) {
		return Mth.nextInt(worldIn.getRandom(), 2, 5) / 2;
    }

	@Override
	public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return !this.isMaxAge(state);
	}

	@Override
	public void performBonemeal(ServerLevel world, Random random, BlockPos pos, BlockState state) {
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

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_206840_1_) {
		p_206840_1_.add(AGE);
	}
}
