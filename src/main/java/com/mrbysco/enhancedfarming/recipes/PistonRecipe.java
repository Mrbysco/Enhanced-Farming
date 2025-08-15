package com.mrbysco.enhancedfarming.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
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
	protected final String group;
	protected final Ingredient ingredient;
	protected final ItemStack result;

	public PistonRecipe(String group, Ingredient ingredient, ItemStack stack) {
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
	public ItemStack assemble(RecipeInput input, HolderLookup.Provider registries) {
		return result();
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	public ItemStack result() {
		return this.result.copy();
	}

	public String getGroup() {
		return this.group;
	}

	@Override
	public RecipeSerializer<PistonRecipe> getSerializer() {
		return FarmingRecipes.PISTON_CRAFTING_SERIALIZER.get();
	}

	public static class Serializer implements RecipeSerializer<PistonRecipe> {
		private static final MapCodec<PistonRecipe> CODEC = RecordCodecBuilder.mapCodec(
				instance -> instance.group(
								Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group),
								Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
								ItemStack.STRICT_CODEC.fieldOf("result").forGetter(hardcoreRecipe -> hardcoreRecipe.result)
						)
						.apply(instance, PistonRecipe::new)
		);
		public static final StreamCodec<RegistryFriendlyByteBuf, PistonRecipe> STREAM_CODEC = StreamCodec.of(
				PistonRecipe.Serializer::toNetwork, PistonRecipe.Serializer::fromNetwork
		);

		@Override
		public MapCodec<PistonRecipe> codec() {
			return CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, PistonRecipe> streamCodec() {
			return STREAM_CODEC;
		}

		public static PistonRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
			String s = buffer.readUtf();

			Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
			ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
			return new PistonRecipe(s, ingredient, itemstack);
		}

		public static void toNetwork(RegistryFriendlyByteBuf buffer, PistonRecipe recipe) {
			buffer.writeUtf(recipe.group);
			Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.ingredient);
			ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
		}
	}
}
