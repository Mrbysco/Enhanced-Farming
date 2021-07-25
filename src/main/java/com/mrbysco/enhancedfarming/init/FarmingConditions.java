package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.init.conditions.CropToSeedCondition;
import com.mrbysco.enhancedfarming.init.conditions.RakeEnabledCondition;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class FarmingConditions {
	@SubscribeEvent
	public void onRegisterSerializers(RegistryEvent.Register<RecipeSerializer<?>> event) {
		CraftingHelper.register(CropToSeedCondition.Serializer.INSTANCE);
		CraftingHelper.register(RakeEnabledCondition.Serializer.INSTANCE);
	}
}
