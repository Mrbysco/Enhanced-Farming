package com.mrbysco.enhancedfarming.world.feature;

import com.mrbysco.enhancedfarming.Reference;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FarmingFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Reference.MOD_ID);

	public static final RegistryObject<Feature<BaseTreeFeatureConfig>> FRUIT_TREE = FEATURES.register("fruit_tree", () -> new TreeFeature(BaseTreeFeatureConfig.CODEC));
}
