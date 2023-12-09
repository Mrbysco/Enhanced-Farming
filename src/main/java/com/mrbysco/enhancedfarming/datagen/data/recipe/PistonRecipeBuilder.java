package com.mrbysco.enhancedfarming.datagen.data.recipe;

import com.google.gson.JsonObject;
import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.CraftingRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PistonRecipeBuilder extends CraftingRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final int count;
	private final Ingredient ingredient;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap();
	@Nullable
	private String group;

	public PistonRecipeBuilder(ItemLike like, int count, Ingredient ingredient) {
		this.result = like.asItem();
		this.count = count;
		this.ingredient = ingredient;
	}

	public PistonRecipeBuilder unlockedBy(String id, Criterion<?> criterion) {
		this.criteria.put(id, criterion);
		return this;
	}

	public PistonRecipeBuilder group(@Nullable String group) {
		this.group = group;
		return this;
	}

	public Item getResult() {
		return this.result;
	}

	public void save(RecipeOutput recipeConsumer, ResourceLocation id) {
		this.ensureValid(id);
		Advancement.Builder advancement$builder = recipeConsumer.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
		Objects.requireNonNull(advancement$builder);
		this.criteria.forEach(advancement$builder::addCriterion);
		recipeConsumer.accept(new PistonRecipeBuilder.Result(id, this.result, this.count, this.group == null ? "" : this.group, this.ingredient,
				advancement$builder.build(id.withPrefix("recipes/"))));
	}

	private void ensureValid(ResourceLocation id) {
		if (this.criteria.isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + id);
		}
	}

	public static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final Item result;
		private final int count;
		private final String group;
		private final Ingredient ingredient;
		private final AdvancementHolder advancement;

		public Result(ResourceLocation id, Item result, int count, String group, Ingredient ingredient, AdvancementHolder advancement) {
			this.id = id;
			this.result = result;
			this.count = count;
			this.group = group;
			this.ingredient = ingredient;
			this.advancement = advancement;
		}

		public void serializeRecipeData(JsonObject jsonObject) {
			if (!this.group.isEmpty()) {
				jsonObject.addProperty("group", this.group);
			}

			jsonObject.add("ingredient", this.ingredient.toJson(false));
			JsonObject resultObject = new JsonObject();
			resultObject.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result).toString());
			if (this.count > 1) {
				resultObject.addProperty("count", this.count);
			}

			jsonObject.add("result", resultObject);
		}

		@Override
		public RecipeSerializer<?> type() {
			return FarmingRecipes.PISTON_CRAFTING_SERIALIZER.get();
		}

		public ResourceLocation id() {
			return this.id;
		}

		public AdvancementHolder advancement() {
			return this.advancement;
		}
	}
}