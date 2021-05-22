package com.mrbysco.enhancedfarming.init.conditions;

import com.google.gson.JsonObject;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class RakeEnabledCondition implements ICondition {
	private static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "rake_enabled");

	@Override
	public ResourceLocation getID() {
		return ID;
	}

	@Override
	public boolean test() {
		return FarmingConfig.COMMON.enableRake.get();
	}

	public static class Serializer implements IConditionSerializer<RakeEnabledCondition> {
		public static final RakeEnabledCondition.Serializer INSTANCE = new RakeEnabledCondition.Serializer();

		public void write(JsonObject json, RakeEnabledCondition value) {

		}

		public RakeEnabledCondition read(JsonObject json) {
			return new RakeEnabledCondition();
		}

		public ResourceLocation getID() {
			return RakeEnabledCondition.ID;
		}
	}
}