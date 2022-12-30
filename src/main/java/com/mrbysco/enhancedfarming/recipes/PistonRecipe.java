package com.mrbysco.enhancedfarming.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class PistonRecipe implements Recipe<Container> {
	protected final ResourceLocation id;
	protected final String group;
	protected final Ingredient ingredient;
	protected final ItemStack result;

	public PistonRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack stack) {
		this.id = id;
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

	public ItemStack assemble(Container inventory) {
		return this.result.copy();
	}

	public boolean canCraftInDimensions(int x, int y) {
		return true;
	}

	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> nonnulllist = NonNullList.create();
		nonnulllist.add(this.ingredient);
		return nonnulllist;
	}

	public ItemStack getResultItem() {
		return this.result;
	}

	public String getGroup() {
		return this.group;
	}

	public ResourceLocation getId() {
		return this.id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return FarmingRecipes.PISTON_CRAFTING_SERIALIZER.get();
	}

	public static class SerializerPistonRecipe implements RecipeSerializer<PistonRecipe> {
		@Override
		public PistonRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject) {
			String s = GsonHelper.getAsString(jsonObject, "group", "");
			JsonElement jsonelement = (JsonElement) (GsonHelper.isArrayNode(jsonObject, "ingredient") ? GsonHelper.getAsJsonArray(jsonObject, "ingredient") : GsonHelper.getAsJsonObject(jsonObject, "ingredient"));
			Ingredient ingredient = Ingredient.fromJson(jsonelement);
			//Forge: Check if primitive string to keep vanilla or a object which can contain a count field.
			if (!jsonObject.has("result"))
				throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
			ItemStack itemstack;
			if (jsonObject.get("result").isJsonObject())
				itemstack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(jsonObject, "result"));
			else {
				String s1 = GsonHelper.getAsString(jsonObject, "result");
				ResourceLocation resourcelocation = new ResourceLocation(s1);
				itemstack = new ItemStack(BuiltInRegistries.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
					return new IllegalStateException("Item: " + s1 + " does not exist");
				}));
			}
			return new PistonRecipe(recipeId, s, ingredient, itemstack);
		}

		@Nullable
		@Override
		public PistonRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
			String s = buffer.readUtf();
			Ingredient ingredient = Ingredient.fromNetwork(buffer);
			ItemStack itemstack = buffer.readItem();
			return new PistonRecipe(recipeId, s, ingredient, itemstack);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, PistonRecipe recipe) {
			buffer.writeUtf(recipe.group);
			recipe.ingredient.toNetwork(buffer);
			buffer.writeItem(recipe.result);
		}
	}
}
