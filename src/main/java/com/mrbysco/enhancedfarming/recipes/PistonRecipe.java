package com.mrbysco.enhancedfarming.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class PistonRecipe implements IRecipe<IInventory> {
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
	public IRecipeType<?> getType() {
		return FarmingRecipes.PISTON_CRAFTING_TYPE;
	}

	@Override
	public boolean matches(IInventory inv, World worldIn) {
		return this.ingredient.test(inv.getItem(0));
	}

	public ItemStack assemble(IInventory inventory) {
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
	public IRecipeSerializer<?> getSerializer() {
		return FarmingRecipes.PISTON_CRAFTING_SERIALIZER.get();
	}

	public static class SerializerPistonRecipe extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<PistonRecipe> {
		@Override
		public PistonRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject) {
			String s = JSONUtils.getAsString(jsonObject, "group", "");
			JsonElement jsonelement = (JsonElement)(JSONUtils.isArrayNode(jsonObject, "ingredient") ? JSONUtils.getAsJsonArray(jsonObject, "ingredient") : JSONUtils.getAsJsonObject(jsonObject, "ingredient"));
			Ingredient ingredient = Ingredient.fromJson(jsonelement);
			//Forge: Check if primitive string to keep vanilla or a object which can contain a count field.
			if (!jsonObject.has("result")) throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
			ItemStack itemstack;
			if (jsonObject.get("result").isJsonObject()) itemstack = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(jsonObject, "result"));
			else {
				String s1 = JSONUtils.getAsString(jsonObject, "result");
				ResourceLocation resourcelocation = new ResourceLocation(s1);
				itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
					return new IllegalStateException("Item: " + s1 + " does not exist");
				}));
			}
			return new PistonRecipe(recipeId, s, ingredient, itemstack);
		}

		@Nullable
		@Override
		public PistonRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
			String s = buffer.readUtf(32767);
			Ingredient ingredient = Ingredient.fromNetwork(buffer);
			ItemStack itemstack = buffer.readItem();
			return new PistonRecipe(recipeId, s, ingredient, itemstack);
		}

		@Override
		public void toNetwork(PacketBuffer buffer, PistonRecipe recipe) {
			buffer.writeUtf(recipe.group);
			recipe.ingredient.toNetwork(buffer);
			buffer.writeItem(recipe.result);
		}
	}
}
