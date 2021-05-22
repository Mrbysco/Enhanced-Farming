package com.mrbysco.enhancedfarming.block.crops;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.PlantType;

import javax.annotation.Nullable;
import java.util.Random;
import java.util.function.Supplier;

public class CropstickCropBlock extends CropsBlock {
	protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

	private final Supplier<Item> baseSeedSupplier;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public CropstickCropBlock(AbstractBlock.Properties properties, Supplier<Item> baseSeedSupplier) {
    	super(properties.strength(0.5F));
        this.baseSeedSupplier = baseSeedSupplier;
		this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), Integer.valueOf(0)));
	}

	@Override
	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
		return SHAPE;
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
		return 5;
	}

	@Override
	public void playerDestroy(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity tileEntity, ItemStack stack) {
    	if(!world.isClientSide) {
    		world.setBlock(pos, FarmingRegistry.CROP_STICK.get().defaultBlockState(), 6);
		}
		super.playerDestroy(world, player, pos, state, tileEntity, stack);
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