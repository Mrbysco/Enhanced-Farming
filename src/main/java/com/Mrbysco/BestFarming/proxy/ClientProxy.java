package com.Mrbysco.BestFarming.proxy;

import java.util.List;

import com.Mrbysco.BestFarming.block.BlockFruitLeaves;
import com.Mrbysco.BestFarming.init.FarmingBlocks;
import com.Mrbysco.BestFarming.render.ScarecrowRenderer;
import com.Mrbysco.BestFarming.tileentity.TileEntityScarecrow;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy{
	
	public void Preinit() {
		
	}

	public void Init() {
		this.addLeaves();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScarecrow.class, new ScarecrowRenderer());
	}
	
	private static List<Block> coloredBlocks = Lists.newArrayList();
	
	public void addLeaves() {
		coloredBlocks.add(FarmingBlocks.apple_leaves);
		coloredBlocks.add(FarmingBlocks.lemon_leaves);
		coloredBlocks.add(FarmingBlocks.orange_leaves);
		
		this.registerColouring();
	}
	
    public void registerColouring()
    {
		
        for (Block block : coloredBlocks)
        {
            BlockFruitLeaves fruitLeaves = (BlockFruitLeaves)block;
            if (fruitLeaves.getBlockColor() != null) Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(fruitLeaves.getBlockColor(), block);
            if (fruitLeaves.getItemColor() != null) Minecraft.getMinecraft().getItemColors().registerItemColorHandler(fruitLeaves.getItemColor(), block);
        }
    }
}
