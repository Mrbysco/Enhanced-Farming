package com.Mrbysco.EnhancedFarming.world;

import java.util.Random;

import com.Mrbysco.EnhancedFarming.block.BlockGrowableSapling;
import com.Mrbysco.EnhancedFarming.block.EnumSaplingType;
import com.Mrbysco.EnhancedFarming.util.TreeHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenFruitTree extends WorldGenAbstractTree {

	private IBlockState woodType;
    private IBlockState leaveType;
    private BlockGrowableSapling saplingBlock;
    
	public WorldGenFruitTree(EnumSaplingType type) {
		super(true);
		
		this.woodType = type.getWoodType();
		this.leaveType = TreeHelper.getLeaveFromEnum(type);
		this.saplingBlock = TreeHelper.getSaplingFromEnum(type);
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		
		int treeSize = rand.nextInt(3) + 5;
		treeSize += rand.nextInt(6);
		
        boolean flag = true;

		if (position.getY() >= 1 && position.getY() + treeSize + 1 <= 256)
        {
            for (int j = position.getY(); j <= position.getY() + 1 + treeSize; ++j)
            {
                int k = 1;

                if (j == position.getY())
                {
                    k = 0;
                }

                if (j >= position.getY() + 1 + treeSize - 2)
                {
                    k = 2;
                }

                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l)
                {
                    for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1)
                    {
                        if (j >= 0 && j < worldIn.getHeight())
                        {
                            if (!this.isReplaceable(worldIn, blockpos$mutableblockpos.setPos(l, j, i1)))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                BlockPos down = position.down();
                IBlockState state = worldIn.getBlockState(down);
                
                boolean isSoil = state.getBlock().canSustainPlant(state, worldIn, down, EnumFacing.UP, this.saplingBlock);

                if (isSoil && position.getY() < worldIn.getHeight() - treeSize - 1)
                {
                    state.getBlock().onPlantGrow(state, worldIn, down, position);

                    for (int i2 = position.getY() - 3 + treeSize; i2 <= position.getY() + treeSize; ++i2)
                    {
                        int k2 = i2 - (position.getY() + treeSize);
                        int l2 = 1 - k2 / 2;

                        for (int i3 = position.getX() - l2; i3 <= position.getX() + l2; ++i3)
                        {
                            int j1 = i3 - position.getX();

                            for (int k1 = position.getZ() - l2; k1 <= position.getZ() + l2; ++k1)
                            {
                                int l1 = k1 - position.getZ();

                                if (Math.abs(j1) != l2 || Math.abs(l1) != l2 || rand.nextInt(2) != 0 && k2 != 0)
                                {
                                    BlockPos blockpos = new BlockPos(i3, i2, k1);
                                    IBlockState state2 = worldIn.getBlockState(blockpos);

                                    if (state2.getBlock().isAir(state2, worldIn, blockpos) || state2.getBlock().isAir(state2, worldIn, blockpos))
                                    {
                                        this.setBlockAndNotifyAdequately(worldIn, blockpos, this.leaveType);
                                    }
                                }
                            }
                        }
                    }

                    for (int j2 = 0; j2 < treeSize; ++j2)
                    {
                        BlockPos upN = position.up(j2);
                        IBlockState state2 = worldIn.getBlockState(upN);

                        if (state2.getBlock().isAir(state2, worldIn, upN) || state2.getBlock().isLeaves(state2, worldIn, upN))
                        {
                            this.setBlockAndNotifyAdequately(worldIn, position.up(j2), this.woodType);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
	}
}
