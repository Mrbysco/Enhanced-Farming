package com.mrbysco.enhancedfarming.datagen;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.datagen.assets.FarmingBlockStateProvider;
import com.mrbysco.enhancedfarming.datagen.assets.FarmingItemModelProvider;
import com.mrbysco.enhancedfarming.datagen.assets.FarmingLanguageProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingBiomeModifiers;
import com.mrbysco.enhancedfarming.datagen.data.FarmingBlockTagProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingItemTagProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingLootModifierProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingLootProvider;
import com.mrbysco.enhancedfarming.datagen.data.FarmingRecipeProvider;
import com.mrbysco.enhancedfarming.world.feature.FarmingFeatureConfigs;
import com.mrbysco.enhancedfarming.world.feature.FarmingTreePlacements;
import com.mrbysco.enhancedfarming.world.feature.FarmingVegetation;
import com.mrbysco.enhancedfarming.world.feature.FarmingVegetationPlacements;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.VanillaRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarmingDataGen {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(true, new FarmingLootProvider(packOutput));
			generator.addProvider(true, new FarmingLootModifierProvider(packOutput));
			generator.addProvider(true, new FarmingRecipeProvider(packOutput, lookupProvider));
			FarmingBlockTagProvider blockTagProvider;
			generator.addProvider(true, blockTagProvider = new FarmingBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
			generator.addProvider(true, new FarmingItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));

			generator.addProvider(true, new DatapackBuiltinEntriesProvider(
					packOutput, CompletableFuture.supplyAsync(FarmingDataGen::getProvider), Set.of(Reference.MOD_ID)));
		}

		if (event.includeClient()) {
			generator.addProvider(true, new FarmingLanguageProvider(packOutput));
			generator.addProvider(true, new FarmingBlockStateProvider(packOutput, existingFileHelper));
			generator.addProvider(true, new FarmingItemModelProvider(packOutput, existingFileHelper));
		}
	}

	private static HolderLookup.Provider getProvider() {
		final RegistrySetBuilder registryBuilder = new RegistrySetBuilder();
		registryBuilder.add(Registries.CONFIGURED_FEATURE, (context) -> {
			FarmingFeatureConfigs.bootstrap(context);
			FarmingVegetation.bootstrap(context);
		});
		registryBuilder.add(Registries.PLACED_FEATURE, (context) -> {
			FarmingTreePlacements.bootstrap(context);
			FarmingVegetationPlacements.bootstrap(context);
		});
		registryBuilder.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, FarmingBiomeModifiers::bootstrap);
		// We need the BIOME registry to be present so we can use a biome tag, doesn't matter that it's empty
		registryBuilder.add(Registries.BIOME, context -> {
		});
		RegistryAccess.Frozen regAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
		return registryBuilder.buildPatch(regAccess, VanillaRegistries.createLookup());
	}
}
