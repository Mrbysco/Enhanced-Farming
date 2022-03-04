package com.mrbysco.enhancedfarming.recipes;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe.SerializerPistonRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FarmingRecipes {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Reference.MOD_ID);

	public static final RegistryObject<SerializerPistonRecipe> PISTON_CRAFTING_SERIALIZER = RECIPE_SERIALIZERS.register("piston_crafting", SerializerPistonRecipe::new);
}
