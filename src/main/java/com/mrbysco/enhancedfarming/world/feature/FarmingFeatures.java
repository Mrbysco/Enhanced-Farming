package com.mrbysco.enhancedfarming.world.feature;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FarmingFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, EnhancedFarming.MOD_ID);

	public static final Supplier<Feature<TreeConfiguration>> FRUIT_TREE = FEATURES.register("fruit_tree", () -> new TreeFeature(TreeConfiguration.CODEC));
}
