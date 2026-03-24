package com.mrbysco.enhancedfarming.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class PistonRecipe implements Recipe<RecipeInput> {
	private static final MapCodec<PistonRecipe> CODEC = RecordCodecBuilder.mapCodec(
			instance -> instance.group(
							Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
							Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
							ItemStackTemplate.CODEC.fieldOf("result").forGetter(hardcoreRecipe -> hardcoreRecipe.result)
					)
					.apply(instance, PistonRecipe::new)
	);
	public static final StreamCodec<RegistryFriendlyByteBuf, PistonRecipe> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.STRING_UTF8,
			o -> o.group,
			Ingredient.CONTENTS_STREAM_CODEC,
			o -> o.ingredient,
			ItemStackTemplate.STREAM_CODEC,
			o -> o.result,
			PistonRecipe::new
	);
	public static final RecipeSerializer<PistonRecipe> SERIALIZER = new RecipeSerializer<>(CODEC, STREAM_CODEC);

	protected final String group;
	protected final Ingredient ingredient;
	protected final ItemStackTemplate result;

	public PistonRecipe(String group, Ingredient ingredient, ItemStackTemplate stack) {
		this.group = group;
		this.ingredient = ingredient;
		this.result = stack;
	}

	@Override
	public RecipeType<PistonRecipe> getType() {
		return FarmingRecipes.PISTON_CRAFTING_TYPE.get();
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.NOT_PLACEABLE;
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return RecipeBookCategories.CRAFTING_MISC;
	}

	@Override
	public boolean matches(RecipeInput input, Level level) {
		return this.ingredient.test(input.getItem(0));
	}

	@Override
	public ItemStack assemble(RecipeInput input) {
		return result();
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	public ItemStack result() {
		return this.result.create();
	}

	@Override
	public boolean showNotification() {
		return false;
	}

	@Override
	public String group() {
		return this.group;
	}

	@Override
	public RecipeSerializer<PistonRecipe> getSerializer() {
		return FarmingRecipes.PISTON_CRAFTING_SERIALIZER.get();
	}
}
