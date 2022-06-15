package com.mrbysco.enhancedfarming.init.conditions;

import com.google.gson.JsonObject;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class CropToSeedCondition implements ICondition {
	private static final ResourceLocation ID = new ResourceLocation(Reference.MOD_ID, "crop_to_seeds");

	@Override
	public ResourceLocation getID() {
		return ID;
	}

	@Override
	public boolean test(IContext context) {
		return FarmingConfig.COMMON.cropToSeeds.get();
	}

	public static class Serializer implements IConditionSerializer<CropToSeedCondition> {
		public static final CropToSeedCondition.Serializer INSTANCE = new CropToSeedCondition.Serializer();

		public void write(JsonObject json, CropToSeedCondition value) {

		}

		public CropToSeedCondition read(JsonObject json) {
			return new CropToSeedCondition();
		}

		public ResourceLocation getID() {
			return CropToSeedCondition.ID;
		}
	}
}