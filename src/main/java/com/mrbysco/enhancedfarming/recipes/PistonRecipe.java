package com.mrbysco.enhancedfarming.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class PistonRecipe implements Recipe<Container> {
	protected final String group;
	protected final Ingredient ingredient;
	protected final ItemStack result;

	public PistonRecipe(String group, Ingredient ingredient, ItemStack stack) {
		this.group = group;
		this.ingredient = ingredient;
		this.result = stack;
	}

	@Override
	public RecipeType<?> getType() {
		return FarmingRecipes.PISTON_CRAFTING_TYPE.get();
	}

	@Override
	public boolean matches(Container inv, Level level) {
		return this.ingredient.test(inv.getItem(0));
	}

	public ItemStack assemble(Container inventory, RegistryAccess registryAccess) {
		return getResultItem(registryAccess);
	}

	public boolean canCraftInDimensions(int x, int y) {
		return true;
	}

	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> nonnulllist = NonNullList.create();
		nonnulllist.add(this.ingredient);
		return nonnulllist;
	}

	public ItemStack getResultItem(RegistryAccess registryAccess) {
		return this.result;
	}

	public String getGroup() {
		return this.group;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return FarmingRecipes.PISTON_CRAFTING_SERIALIZER.get();
	}

	public static class Serializer implements RecipeSerializer<PistonRecipe> {
		private static final Codec<PistonRecipe> CODEC = RecordCodecBuilder.create(
				instance -> instance.group(
								ExtraCodecs.strictOptionalField(Codec.STRING, "group", "").forGetter(recipe -> recipe.group),
								Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
								ItemStack.ITEM_WITH_COUNT_CODEC.fieldOf("result").forGetter(hardcoreRecipe -> hardcoreRecipe.result)
						)
						.apply(instance, PistonRecipe::new)
		);

		@Override
		public Codec<PistonRecipe> codec() {
			return CODEC;
		}

		@Nullable
		@Override
		public PistonRecipe fromNetwork(FriendlyByteBuf buffer) {
			String s = buffer.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(buffer);
			ItemStack itemstack = buffer.readItem();
			return new PistonRecipe(s, ingredient, itemstack);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, PistonRecipe recipe) {
			buffer.writeUtf(recipe.group);
			recipe.ingredient.toNetwork(buffer);
			buffer.writeItem(recipe.result);
		}
	}
}
