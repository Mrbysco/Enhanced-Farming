package com.Mrbysco.EnhancedFarming.world;

import java.util.Random;

import com.Mrbysco.EnhancedFarming.init.FarmingBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class NetherWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == -1) {
        	int blockX = chunkX * 16;
    		int blockZ = chunkZ * 16;
    		BlockPos position = new BlockPos(blockX, 0, blockZ);
    		
    		int y = getAboveGround(world, position);
    		
    		if (y < 10)
    		{
    			return;
    		}
    		
    		BlockPos acceptedPosition = position.add(0, y, 0);
    		
    		boolean canGenerate = true;
    		if (random.nextInt(20) > 14) 
    		{
        		System.out.println("generating");

    			double distance = acceptedPosition.getDistance(acceptedPosition.getX(), acceptedPosition.getY(), acceptedPosition.getZ());
    			if (distance < 15)
    				canGenerate = false;
    		}
    		if (canGenerate)
    			GenerateNetherFlower(world, random, acceptedPosition);
        }
	}
	
	public static int getAboveGround(World worldIn, BlockPos pos){
		int y = 100;
		boolean foundSand = false;
		while(!foundSand && y-- >= 10)
		{
			Block foundBlock = worldIn.getBlockState(pos.add(0, y, 0)).getBlock();
			Block aboveBlock = worldIn.getBlockState(pos.add(0, y + 1, 0)).getBlock();
			foundSand = (foundBlock == Blocks.SOUL_SAND) && aboveBlock == Blocks.AIR;
		}

		return y;
	}
	
	public static void GenerateNetherFlower(World worldIn, Random random, BlockPos pos) {
		BlockPos north = pos.north();
		BlockPos south = pos.south();
		BlockPos west = pos.west();
		
		if(worldIn.getBlockState(north).getBlock() == Blocks.SOUL_SAND && 
		   worldIn.getBlockState(north.up()).getBlock() == Blocks.AIR)
		{
			PlaceCrop(worldIn, north, FarmingBlocks.nether_flower_crop.getDefaultState());
		}
		
		if(worldIn.getBlockState(south).getBlock() == Blocks.SOUL_SAND && 
		   worldIn.getBlockState(south.up()).getBlock() == Blocks.AIR)
		{
			PlaceCrop(worldIn, south, FarmingBlocks.nether_flower_crop.getDefaultState());
		}
		
		if(worldIn.getBlockState(west).getBlock() == Blocks.SOUL_SAND && 
		   worldIn.getBlockState(west.up()).getBlock() == Blocks.AIR)
		{
			PlaceCrop(worldIn, west, FarmingBlocks.nether_flower_crop.getDefaultState());
		}
		
		PlaceCrop(worldIn, pos, FarmingBlocks.nether_flower_crop.getDefaultState());
	}
	
	public static void PlaceCrop(World worldIn, BlockPos pos, IBlockState state)
	{
		worldIn.setBlockState(pos.up(), state);
	}
	
}
