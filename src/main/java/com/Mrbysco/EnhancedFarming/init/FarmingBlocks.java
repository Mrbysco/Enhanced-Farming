package com.Mrbysco.EnhancedFarming.init;

import java.util.ArrayList;

import com.Mrbysco.EnhancedFarming.block.BlockCropStick;
import com.Mrbysco.EnhancedFarming.block.BlockFruitLeaves;
import com.Mrbysco.EnhancedFarming.block.BlockGrowableSapling;
import com.Mrbysco.EnhancedFarming.block.BlockNonFruitLeaves;
import com.Mrbysco.EnhancedFarming.block.BlockScarecrow;
import com.Mrbysco.EnhancedFarming.block.EnumCropType;
import com.Mrbysco.EnhancedFarming.block.EnumSaplingType;
import com.Mrbysco.EnhancedFarming.block.crops.BlockCropstickCrop;
import com.Mrbysco.EnhancedFarming.block.crops.BlockFiveAgeCrop;
import com.Mrbysco.EnhancedFarming.block.crops.BlockNetherFlower;
import com.Mrbysco.EnhancedFarming.block.crops.BlockSevenAgeCrop;
import com.Mrbysco.EnhancedFarming.block.crops.BlockSixAgeCrop;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockLeaves;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class FarmingBlocks {
	public static BlockCrops mint_crop;
	public static BlockBush nether_flower_crop;
	
	public static BlockLeaves apple_leaves;
	public static BlockLeaves blooming_apple_leaves;
	public static BlockLeaves lemon_leaves;
	public static BlockLeaves blooming_lemon_leaves;
	public static BlockLeaves orange_leaves;
	public static BlockLeaves blooming_orange_leaves;
	
	public static BlockGrowableSapling apple_sapling;
	public static BlockGrowableSapling lemon_sapling;
	public static BlockGrowableSapling orange_sapling;
	
	public static Block scarecrow;
	
	//New Content
	public static Block crop_stick;
	
	public static BlockCrops tomato_crop;
	public static BlockCrops cucumber_crop;
	public static BlockCrops aubergine_crop;
	public static BlockCrops pineapple_crop;
	public static BlockCrops corn_crop;
	public static BlockCrops onion_crop;
	public static BlockCrops garlic_crop;
	public static BlockCrops lettuce_crop;
	
	//cropstick crops
	public static BlockCrops grape_crop;

	public static BlockLeaves cherry_leaves;
	public static BlockLeaves blooming_cherry_leaves;
	public static BlockLeaves pear_leaves;
	public static BlockLeaves blooming_pear_leaves;
	public static BlockLeaves banana_leaves;
	public static BlockLeaves blooming_banana_leaves;
	public static BlockLeaves avocado_leaves;
	public static BlockLeaves blooming_avocado_leaves;
	public static BlockLeaves mango_leaves;
	public static BlockLeaves blooming_mango_leaves;
	public static BlockLeaves olive_leaves;
	public static BlockLeaves blooming_olive_leaves;
	
	public static BlockGrowableSapling cherry_sapling;
	public static BlockGrowableSapling pear_sapling;
	public static BlockGrowableSapling banana_sapling;
	public static BlockGrowableSapling avocado_sapling;
	public static BlockGrowableSapling mango_sapling;
	public static BlockGrowableSapling olive_sapling;
	
    public static ArrayList<Block> BLOCKS = new ArrayList<>();
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();
        
        mint_crop = registerBlock(new BlockFiveAgeCrop("mint_crop", EnumCropType.MINT));
		nether_flower_crop = registerBlock(new BlockNetherFlower("nether_flower_crop"));
		tomato_crop = registerBlock(new BlockSixAgeCrop("tomato_crop", EnumCropType.TOMATO));
		cucumber_crop = registerBlock(new BlockFiveAgeCrop("cucumber_crop", EnumCropType.CUCUMBER));
		aubergine_crop = registerBlock(new BlockFiveAgeCrop("aubergine_crop",  EnumCropType.AUBERGINE));
		grape_crop = registerBlock(new BlockCropstickCrop("grape_crop", EnumCropType.GRAPE)); //cropstick
		pineapple_crop = registerBlock(new BlockFiveAgeCrop("pineapple_crop",  EnumCropType.PINEAPPLE));
		corn_crop = registerBlock(new BlockSevenAgeCrop("corn_crop",  EnumCropType.CORN));
		onion_crop = registerBlock(new BlockFiveAgeCrop("onion_crop",  EnumCropType.ONION));
		garlic_crop = registerBlock(new BlockFiveAgeCrop("garlic_crop",  EnumCropType.GARLIC));
		lettuce_crop = registerBlock(new BlockFiveAgeCrop("lettuce_crop",  EnumCropType.LETTUCE));
		
		apple_leaves = registerBlock(new BlockFruitLeaves("apple_leaves", EnumSaplingType.APPLE));
		blooming_apple_leaves = registerBlock(new BlockNonFruitLeaves("blooming_apple_leaves", EnumSaplingType.APPLE));
		
		lemon_leaves = registerBlock(new BlockFruitLeaves("lemon_leaves", EnumSaplingType.LEMON));
		blooming_lemon_leaves = registerBlock(new BlockNonFruitLeaves("blooming_lemon_leaves", EnumSaplingType.LEMON));
		
		orange_leaves = registerBlock(new BlockFruitLeaves("orange_leaves", EnumSaplingType.ORANGE));
		blooming_orange_leaves = registerBlock(new BlockNonFruitLeaves("blooming_orange_leaves", EnumSaplingType.ORANGE));

		cherry_leaves = registerBlock(new BlockFruitLeaves("cherry_leaves", EnumSaplingType.CHERRY));
		blooming_cherry_leaves = registerBlock(new BlockNonFruitLeaves("blooming_cherry_leaves", EnumSaplingType.CHERRY));
		
		pear_leaves = registerBlock(new BlockFruitLeaves("pear_leaves", EnumSaplingType.PEAR));
		blooming_pear_leaves = registerBlock(new BlockNonFruitLeaves("blooming_pear_leaves", EnumSaplingType.PEAR));
		
		banana_leaves = registerBlock(new BlockFruitLeaves("banana_leaves", EnumSaplingType.BANANA));
		blooming_banana_leaves = registerBlock(new BlockNonFruitLeaves("blooming_banana_leaves", EnumSaplingType.BANANA));
		
		avocado_leaves = registerBlock(new BlockFruitLeaves("avocado_leaves", EnumSaplingType.AVOCADO));
		blooming_avocado_leaves = registerBlock(new BlockNonFruitLeaves("blooming_avocado_leaves", EnumSaplingType.AVOCADO));
		
		mango_leaves = registerBlock(new BlockFruitLeaves("mango_leaves", EnumSaplingType.MANGO));
		blooming_mango_leaves = registerBlock(new BlockNonFruitLeaves("blooming_mango_leaves", EnumSaplingType.MANGO));
		
		olive_leaves = registerBlock(new BlockFruitLeaves("olive_leaves", EnumSaplingType.OLIVE));
		blooming_olive_leaves = registerBlock(new BlockNonFruitLeaves("blooming_olive_leaves", EnumSaplingType.OLIVE));
		
		apple_sapling = registerBlock(new BlockGrowableSapling("apple_sapling", EnumSaplingType.APPLE));
		lemon_sapling = registerBlock(new BlockGrowableSapling("lemon_sapling", EnumSaplingType.LEMON));
		orange_sapling = registerBlock(new BlockGrowableSapling("orange_sapling", EnumSaplingType.ORANGE));
		cherry_sapling = registerBlock(new BlockGrowableSapling("cherry_sapling", EnumSaplingType.CHERRY));
		pear_sapling = registerBlock(new BlockGrowableSapling("pear_sapling", EnumSaplingType.PEAR));
		banana_sapling = registerBlock(new BlockGrowableSapling("banana_sapling", EnumSaplingType.BANANA));
		avocado_sapling = registerBlock(new BlockGrowableSapling("avocado_sapling", EnumSaplingType.AVOCADO));
		mango_sapling = registerBlock(new BlockGrowableSapling("mango_sapling", EnumSaplingType.MANGO));
		olive_sapling = registerBlock(new BlockGrowableSapling("olive_sapling", EnumSaplingType.OLIVE));
		
		crop_stick = registerBlock(new BlockCropStick("crop_stick"));
		scarecrow = registerBlock(new BlockScarecrow("scarecrow"));
		
		registry.registerAll(BLOCKS.toArray(new Block[0]));
    }
    
    public static <T extends Block> T registerBlock(T block)
    {
        return registerBlock(block, new ItemBlock(block));
    }
    
    public static <T extends Block> T registerBlock(T block, ItemBlock item)
    {
    	item.setRegistryName(block.getRegistryName());
    	FarmingItems.ITEMS.add(item);
        BLOCKS.add(block);
        return block;
    }
}
