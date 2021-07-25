package com.mrbysco.enhancedfarming.world.feature;

import com.mrbysco.enhancedfarming.Reference;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FarmingFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Reference.MOD_ID);

	public static final RegistryObject<Feature<TreeConfiguration>> FRUIT_TREE = FEATURES.register("fruit_tree", () -> new TreeFeature(TreeConfiguration.CODEC));
}
