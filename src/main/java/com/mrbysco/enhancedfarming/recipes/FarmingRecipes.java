package com.mrbysco.enhancedfarming.recipes;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe.Serializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FarmingRecipes {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, EnhancedFarming.MOD_ID);
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, EnhancedFarming.MOD_ID);

	public static final Supplier<RecipeType<PistonRecipe>> PISTON_CRAFTING_TYPE = RECIPE_TYPES.register("piston_crafting", () -> new RecipeType<>() {
	});

	public static final Supplier<Serializer> PISTON_CRAFTING_SERIALIZER = RECIPE_SERIALIZERS.register("piston_crafting", Serializer::new);
}
