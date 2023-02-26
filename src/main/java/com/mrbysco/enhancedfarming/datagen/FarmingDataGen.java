package com.mrbysco.enhancedfarming.datagen;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.datagen.assets.FarmingBlockStateProvider;
import com.mrbysco.enhancedfarming.datagen.assets.FarmingItemModelProvider;
import com.mrbysco.enhancedfarming.datagen.assets.FarmingLanguageProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingBiomeModifierProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingLootProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingLootModifierProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.RegistryOps;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarmingDataGen {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		final RegistryOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, RegistryAccess.builtinCopy());
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		if(event.includeServer()) {
			generator.addProvider(event.includeServer(), new FarmingLootProvider(generator));
			generator.addProvider(event.includeServer(), new FarmingLootModifierProvider(generator));
//			generator.addProvider(new FarmingRecipes(generator));

			generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(
					generator, existingFileHelper, Reference.MOD_ID, ops, Registry.PLACED_FEATURE_REGISTRY, FarmingBiomeModifierProvider.getConfiguredFeatures(ops)));

			generator.addProvider(event.includeServer(), JsonCodecProvider.forDatapackRegistry(
					generator, existingFileHelper, Reference.MOD_ID, ops, ForgeRegistries.Keys.BIOME_MODIFIERS, FarmingBiomeModifierProvider.getBiomeModifiers(ops)));
		}

		if(event.includeClient()) {
			generator.addProvider(event.includeClient(), new FarmingLanguageProvider(generator));
			generator.addProvider(event.includeClient(), new FarmingBlockStateProvider(generator, existingFileHelper));
			generator.addProvider(event.includeClient(), new FarmingItemModelProvider(generator, existingFileHelper));
		}
	}
}
