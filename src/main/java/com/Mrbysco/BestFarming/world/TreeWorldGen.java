package com.Mrbysco.BestFarming.world;

import java.util.Random;

import com.Mrbysco.BestFarming.block.EnumSaplingType;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TreeWorldGen implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		final int x = chunkX * 16 + 8 + random.nextInt(16);
        final int z = chunkZ * 16 + 8 + random.nextInt(16);
    	final int y = world.getHeight(x, z);

        final Biome currentBiome = world.getBiomeForCoordsBody(new BlockPos(x, 64, z));
        
        WorldGenFruitTree fruitTree;
        
        if (BiomeDictionary.hasType(currentBiome, BiomeDictionary.Type.DEAD)) {
            return;
        }

        if (BiomeDictionary.hasType(currentBiome, BiomeDictionary.Type.FOREST) && 
        		!BiomeDictionary.hasType(currentBiome, BiomeDictionary.Type.COLD))
		{
        	int randomValue = random.nextInt(6);
        	
        	switch (randomValue) {
        	default:
        		break;
            case 0:
            	fruitTree = new WorldGenFruitTree(EnumSaplingType.Apple);
            	fruitTree.generate(world, random, new BlockPos(x, y, z));
            	break;
            case 1:
            	fruitTree = new WorldGenFruitTree(EnumSaplingType.Lemon);
            	fruitTree.generate(world, random, new BlockPos(x, y, z));
            	break;
            case 2:
            	fruitTree = new WorldGenFruitTree(EnumSaplingType.Orange);
            	fruitTree.generate(world, random, new BlockPos(x, y, z));
            	break;
            }
		}
	}
}
