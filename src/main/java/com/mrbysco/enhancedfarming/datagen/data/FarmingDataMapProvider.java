package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.block.FruitLeavesBlock;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class FarmingDataMapProvider extends DataMapProvider {

	public FarmingDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void gather(HolderLookup.Provider provider) {
		for (DeferredHolder<Item, ? extends Item> item : FarmingRegistry.ITEMS.getEntries()) {
			if (item.get() instanceof BlockItem blockItem) {
				Block block = blockItem.getBlock();
				if (block instanceof FruitLeavesBlock || block instanceof BushBlock)
					compostables(item.get(), 0.3F);
			}
		}
		compostables(FarmingRegistry.AUBERGINE.get(), 0.65F);
		compostables(FarmingRegistry.AVOCADO.get(), 0.65F);
		compostables(FarmingRegistry.BANANA.get(), 0.65F);
		compostables(FarmingRegistry.CHERRY.get(), 0.65F);
		compostables(FarmingRegistry.CUCUMBER.get(), 0.65F);
		compostables(FarmingRegistry.GRAPES.get(), 0.65F);
		compostables(FarmingRegistry.LEMON.get(), 0.65F);
		compostables(FarmingRegistry.MANGO.get(), 0.65F);
		compostables(FarmingRegistry.MINT.get(), 0.65F);
		compostables(FarmingRegistry.OLIVE.get(), 0.65F);
		compostables(FarmingRegistry.ORANGE.get(), 0.65F);
		compostables(FarmingRegistry.PEAR.get(), 0.65F);
		compostables(FarmingRegistry.PINEAPPLE.get(), 0.65F);
		compostables(FarmingRegistry.TOMATO.get(), 0.65F);
		compostables(FarmingRegistry.CORN.get(), 0.65F);
		compostables(FarmingRegistry.GARLIC.get(), 0.65F);
		compostables(FarmingRegistry.LETTUCE.get(), 0.65F);
		compostables(FarmingRegistry.ONION.get(), 0.65F);
	}

	public void compostables(Item item, float chance) {
		this.builder(NeoForgeDataMaps.COMPOSTABLES).add(BuiltInRegistries.ITEM.getKey(item), new Compostable(chance), false);
	}
}
