package com.Mrbysco.EnhancedFarming.world;

import java.util.Random;

import com.Mrbysco.EnhancedFarming.block.EnumSaplingType;

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
        
        boolean coldFlag = !BiomeDictionary.hasType(currentBiome, BiomeDictionary.Type.COLD);
        boolean spookyFlag = !BiomeDictionary.hasType(currentBiome, BiomeDictionary.Type.SPOOKY);
        
        if (BiomeDictionary.hasType(currentBiome, BiomeDictionary.Type.FOREST) && coldFlag && spookyFlag)
		{
        	int randomValue = random.nextInt(8);
        	
        	switch (randomValue) {
        	default:
        		break;
            case 0:
            	fruitTree = new WorldGenFruitTree(EnumSaplingType.APPLE, 5);
            	fruitTree.generate(world, random, new BlockPos(x, y, z));
            	break;
            case 1:
            	fruitTree = new WorldGenFruitTree(EnumSaplingType.LEMON, 5);
            	fruitTree.generate(world, random, new BlockPos(x, y, z));
            	break;
            case 2:
            	fruitTree = new WorldGenFruitTree(EnumSaplingType.ORANGE, 5);
            	fruitTree.generate(world, random, new BlockPos(x, y, z));
            	break;
            case 3:
            	fruitTree = new WorldGenFruitTree(EnumSaplingType.CHERRY, 5);
            	fruitTree.generate(world, random, new BlockPos(x, y, z));
            	break;
            case 4:
            	fruitTree = new WorldGenFruitTree(EnumSaplingType.PEAR, 5);
            	fruitTree.generate(world, random, new BlockPos(x, y, z));
            	break;
            }
		}
        
        if (BiomeDictionary.hasType(currentBiome, BiomeDictionary.Type.JUNGLE) && coldFlag && spookyFlag)
        {
        	int randomValue = random.nextInt(4);
        	
        	switch (randomValue) {
        	default:
        		break;
        	case 0:
            	fruitTree = new WorldGenFruitTree(EnumSaplingType.BANANA, 3 + random.nextInt(7));
            	fruitTree.generate(world, random, new BlockPos(x, y, z));
            	break;
        	}
        }
	}
}
