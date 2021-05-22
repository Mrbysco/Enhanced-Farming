package com.mrbysco.enhancedfarming.recipes;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe.SerializerPistonRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FarmingRecipes {
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Reference.MOD_ID);

	public static final IRecipeType<PistonRecipe> PISTON_CRAFTING_TYPE = IRecipeType.register(new ResourceLocation(Reference.MOD_ID, "piston_crafting").toString());

	public static final RegistryObject<SerializerPistonRecipe> PISTON_CRAFTING_SERIALIZER = RECIPE_SERIALIZERS.register("piston_crafting", SerializerPistonRecipe::new);
}
