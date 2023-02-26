package com.mrbysco.enhancedfarming.datagen;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import com.mrbysco.enhancedfarming.datagen.assets.FarmingBlockStateProvider;
import com.mrbysco.enhancedfarming.datagen.assets.FarmingItemModelProvider;
import com.mrbysco.enhancedfarming.datagen.assets.FarmingLanguageProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingBlockTagProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingItemTagProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingLootModifierProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingLootProvider;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarmingDataGen {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		final RegistryOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.builtinCopy());
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(new FarmingLootProvider(generator));
			generator.addProvider(new FarmingLootModifierProvider(generator));
//			generator.addProvider(new FarmingRecipes(generator));
			FarmingBlockTagProvider blockTagProvider;
			generator.addProvider(blockTagProvider = new FarmingBlockTagProvider(generator, existingFileHelper));
			generator.addProvider(new FarmingItemTagProvider(generator, blockTagProvider, existingFileHelper));
		}

		if (event.includeClient()) {
			generator.addProvider(new FarmingLanguageProvider(generator));
			generator.addProvider(new FarmingBlockStateProvider(generator, existingFileHelper));
			generator.addProvider(new FarmingItemModelProvider(generator, existingFileHelper));
		}
	}
}
