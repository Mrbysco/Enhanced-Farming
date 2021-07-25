package com.mrbysco.enhancedfarming.world;

import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.world.feature.FarmingFeatureConfigs;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class WorldGenHandler {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public void biomeLoadingEvent(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder builder = event.getGeneration();
		Biome.BiomeCategory category = event.getCategory();
		if(category == BiomeCategory.NETHER){
			if(FarmingConfig.COMMON.generateNetherFlower.get() && event.getName().getPath().equals("soul_sand_valley")) {
				builder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, FarmingFeatureConfigs.PATCH_NETHER_FLOWER);
			}
		} else if(category != BiomeCategory.THEEND) {
			if(category == BiomeCategory.SAVANNA) {
				if(FarmingConfig.COMMON.generateOliveTree.get()) {
					builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FarmingFeatureConfigs.OLIVE_FRUIT_VEGETATION.rarity(2).count(1));
				}
			} else if(category == BiomeCategory.JUNGLE) {
				if(FarmingConfig.COMMON.generateBananaTree.get()) {
					builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FarmingFeatureConfigs.BANANA_FRUIT_VEGETATION.rarity(2).count(1));
				}
			} else if(category == BiomeCategory.FOREST) {
				if(FarmingConfig.COMMON.generateAppleTree.get()) {
					builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FarmingFeatureConfigs.APPLE_FRUIT_VEGETATION.rarity(2).count(1));
				}
				if(FarmingConfig.COMMON.generateLemonTree.get()) {
					builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FarmingFeatureConfigs.LEMON_FRUIT_VEGETATION.rarity(2).count(1));
				}
				if(FarmingConfig.COMMON.generateOrangeTree.get()) {
					builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FarmingFeatureConfigs.ORANGE_FRUIT_VEGETATION.rarity(2).count(1));
				}
				if(FarmingConfig.COMMON.generateCherryTree.get()) {
					builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FarmingFeatureConfigs.CHERRY_FRUIT_VEGETATION.rarity(2).count(1));
				}
				if(FarmingConfig.COMMON.generatePearTree.get()) {
					builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FarmingFeatureConfigs.PEAR_FRUIT_VEGETATION.rarity(2).count(1));
				}
				if(FarmingConfig.COMMON.generateAvocadoTree.get()) {
					builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FarmingFeatureConfigs.AVOCADO_FRUIT_VEGETATION.rarity(2).count(1));
				}
				if(FarmingConfig.COMMON.generateMangoTree.get()) {
					builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FarmingFeatureConfigs.MANGO_FRUIT_VEGETATION.rarity(2).count(1));
				}
			}
		}
	}
}
