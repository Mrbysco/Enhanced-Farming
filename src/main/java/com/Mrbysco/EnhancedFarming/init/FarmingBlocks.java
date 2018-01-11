package com.Mrbysco.EnhancedFarming.init;

import java.util.ArrayList;

import com.Mrbysco.EnhancedFarming.block.BlockFruitLeaves;
import com.Mrbysco.EnhancedFarming.block.BlockGrowableSapling;
import com.Mrbysco.EnhancedFarming.block.BlockMint;
import com.Mrbysco.EnhancedFarming.block.BlockNetherFlower;
import com.Mrbysco.EnhancedFarming.block.BlockNonFruitLeaves;
import com.Mrbysco.EnhancedFarming.block.BlockScarecrow;
import com.Mrbysco.EnhancedFarming.block.EnumSaplingType;

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
	
    public static ArrayList<Block> BLOCKS = new ArrayList<>();
    
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();
        
        mint_crop = registerBlock(new BlockMint("mintcrop", "mint_crop"));
		nether_flower_crop = registerBlock(new BlockNetherFlower("netherflowercrop", "nether_flower_crop"));
		
		apple_leaves = registerBlock(new BlockFruitLeaves("appleleaves", "apple_leaves", EnumSaplingType.Apple));
		blooming_apple_leaves = registerBlock(new BlockNonFruitLeaves("bloomingappleleaves", "blooming_apple_leaves", EnumSaplingType.Apple));
		lemon_leaves = registerBlock(new BlockFruitLeaves("lemonleaves", "lemon_leaves", EnumSaplingType.Lemon));
		blooming_lemon_leaves = registerBlock(new BlockNonFruitLeaves("bloominglemonleaves", "blooming_lemon_leaves", EnumSaplingType.Lemon));
		orange_leaves = registerBlock(new BlockFruitLeaves("orangeleaves", "orange_leaves", EnumSaplingType.Orange));
		blooming_orange_leaves = registerBlock(new BlockNonFruitLeaves("bloomingorangeleaves", "blooming_orange_leaves", EnumSaplingType.Orange));
		
		scarecrow = registerBlock(new BlockScarecrow("scarecrow", "scarecrow"));
		
		apple_sapling = registerBlock(new BlockGrowableSapling("applesapling", "apple_sapling", EnumSaplingType.Apple));
		lemon_sapling = registerBlock(new BlockGrowableSapling("lemonsapling", "lemon_sapling", EnumSaplingType.Lemon));
		orange_sapling = registerBlock(new BlockGrowableSapling("orangesapling", "orange_sapling", EnumSaplingType.Orange));
        
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
