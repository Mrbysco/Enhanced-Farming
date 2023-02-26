package com.mrbysco.enhancedfarming.datagen.assets;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class FarmingItemModelProvider extends ItemModelProvider {
	public FarmingItemModelProvider(PackOutput packOutput, ExistingFileHelper helper) {
		super(packOutput, Reference.MOD_ID, helper);
	}

	@Override
	protected void registerModels() {
		FarmingRegistry.ITEMS.getEntries().stream()
				.map(RegistryObject::get)
				.forEach(item -> {
					String path = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
					if (!path.equals("scarecrow")) {
						if (path.endsWith("_sapling")) {
							singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("block/saplings/" + path));
						} else if (path.endsWith("_leaves")) {
							withExistingParent(path, modLoc("block/" + path + "_fruity"));
						} else if (path.endsWith("_rake")) {
							singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("item/" + path));
						} else {
							singleTexture(path, mcLoc("item/generated"), "layer0", modLoc("item/" + path));
						}
					} else {
						withExistingParent(path, modLoc("block/scarecrow"));
					}
				});
	}

	@Override
	public String getName() {
		return "Item Models";
	}
}