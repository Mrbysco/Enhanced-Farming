package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.init.conditions.CropToSeedCondition;
import com.mrbysco.enhancedfarming.init.conditions.RakeEnabledCondition;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

public class FarmingConditions {
	@SubscribeEvent
	public void onRegisterSerializers(RegisterEvent event) {
		if (event.getRegistryKey().equals(ForgeRegistries.Keys.RECIPE_SERIALIZERS)) {
			CraftingHelper.register(CropToSeedCondition.Serializer.INSTANCE);
			CraftingHelper.register(RakeEnabledCondition.Serializer.INSTANCE);
		}
	}
}
