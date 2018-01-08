package com.Mrbysco.EnhancedFarming.init.conditions;

import java.util.function.BooleanSupplier;

import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class RakeRecipeCondition implements IConditionFactory{

	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) {
		return () -> FarmingConfigGen.general.othersettings.enableRake;
	}
}