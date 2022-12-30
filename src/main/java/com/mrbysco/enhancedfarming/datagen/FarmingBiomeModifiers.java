package com.mrbysco.enhancedfarming.datagen;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.world.feature.FarmingVegetationPlacements;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class FarmingBiomeModifiers {
	public static final ResourceKey<BiomeModifier> NETHER_FLOWER_PATCH = createKey("add_nether_flower_patch");
	public static final ResourceKey<BiomeModifier> APPLE = createKey("add_apple_tree");
	public static final ResourceKey<BiomeModifier> LEMON = createKey("add_lemon_tree");
	public static final ResourceKey<BiomeModifier> ORANGE = createKey("add_orange_tree");
	public static final ResourceKey<BiomeModifier> CHERRY = createKey("add_cherry_tree");
	public static final ResourceKey<BiomeModifier> PEAR = createKey("add_pear_tree");
	public static final ResourceKey<BiomeModifier> AVOCADO = createKey("add_avocado_tree");
	public static final ResourceKey<BiomeModifier> MANGO = createKey("add_mango_tree");
	public static final ResourceKey<BiomeModifier> BANANA = createKey("add_banana_tree");
	public static final ResourceKey<BiomeModifier> OLIVE = createKey("add_olive_tree");

	public static void bootstrap(BootstapContext<BiomeModifier> context) {
		final HolderGetter<Biome> biomeHolderGetter = context.lookup(Registries.BIOME);
		final HolderGetter<PlacedFeature> placedHolderGetter = context.lookup(Registries.PLACED_FEATURE);

		context.register(NETHER_FLOWER_PATCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_NETHER),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.PATCH_NETHER_FLOWER)),
				GenerationStep.Decoration.UNDERGROUND_DECORATION));

		context.register(OLIVE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_SAVANNA),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.OLIVE)),
				GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(BANANA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_JUNGLE),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.BANANA)),
				GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(APPLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_FOREST),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.APPLE)),
				GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(LEMON, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_FOREST),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.LEMON)),
				GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(ORANGE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_FOREST),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.ORANGE)),
				GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(CHERRY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_FOREST),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.CHERRY)),
				GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(PEAR, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_FOREST),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.PEAR)),
				GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(AVOCADO, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_FOREST),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.AVOCADO)),
				GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(MANGO, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
				biomeHolderGetter.getOrThrow(BiomeTags.IS_FOREST),
				HolderSet.direct(placedHolderGetter.getOrThrow(FarmingVegetationPlacements.MANGO)),
				GenerationStep.Decoration.VEGETAL_DECORATION));
	}

	private static ResourceKey<BiomeModifier> createKey(String name) {
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(Reference.MOD_ID, name));
	}
}
