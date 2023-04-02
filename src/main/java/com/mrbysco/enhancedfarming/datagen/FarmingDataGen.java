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
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

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
			generator.addProvider(event.includeServer(), new FarmingLootProvider(packOutput));
			generator.addProvider(event.includeServer(), new FarmingLootModifierProvider(packOutput));
//			generator.addProvider(new FarmingRecipes(packOutput));
			FarmingBlockTagProvider blockTagProvider;
			generator.addProvider(event.includeServer(), blockTagProvider = new FarmingBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
			generator.addProvider(event.includeServer(), new FarmingItemTagProvider(packOutput, lookupProvider, blockTagProvider.contentsGetter(), existingFileHelper));

			generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(
					packOutput, CompletableFuture.supplyAsync(FarmingDataGen::getProvider), Set.of(Reference.MOD_ID)));
		}

		if (event.includeClient()) {
			generator.addProvider(event.includeClient(), new FarmingLanguageProvider(packOutput));
			generator.addProvider(event.includeClient(), new FarmingBlockStateProvider(packOutput, existingFileHelper));
			generator.addProvider(event.includeClient(), new FarmingItemModelProvider(packOutput, existingFileHelper));
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
		registryBuilder.add(ForgeRegistries.Keys.BIOME_MODIFIERS, FarmingBiomeModifiers::bootstrap);
		// We need the BIOME registry to be present so we can use a biome tag, doesn't matter that it's empty
		registryBuilder.add(Registries.BIOME, context -> {
		});
		RegistryAccess.Frozen regAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
		return registryBuilder.buildPatch(regAccess, VanillaRegistries.createLookup());
	}
}
