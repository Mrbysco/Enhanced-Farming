package com.mrbysco.enhancedfarming.datagen.data.recipe;

import com.google.gson.JsonObject;
import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.CraftingRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class PistonRecipeBuilder extends CraftingRecipeBuilder implements RecipeBuilder {
	private final Item result;
	private final int count;
	private final Ingredient ingredient;
	private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
	@Nullable
	private String group;

	public PistonRecipeBuilder(ItemLike like, int count, Ingredient ingredient) {
		this.result = like.asItem();
		this.count = count;
		this.ingredient = ingredient;
	}

	public PistonRecipeBuilder unlockedBy(String id, CriterionTriggerInstance triggerInstance) {
		this.advancement.addCriterion(id, triggerInstance);
		return this;
	}

	public PistonRecipeBuilder group(@Nullable String group) {
		this.group = group;
		return this;
	}

	public Item getResult() {
		return this.result;
	}

	public void save(Consumer<FinishedRecipe> recipeConsumer, ResourceLocation id) {
		this.ensureValid(id);
		this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(id)).requirements(RequirementsStrategy.OR);
		recipeConsumer.accept(new PistonRecipeBuilder.Result(id, this.result, this.count, this.group == null ? "" : this.group, this.ingredient, this.advancement, id.withPrefix("recipes/")));
	}

	private void ensureValid(ResourceLocation id) {
		if (this.advancement.getCriteria().isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + id);
		}
	}

	public static class Result implements FinishedRecipe {
		private final ResourceLocation id;
		private final Item result;
		private final int count;
		private final String group;
		private final Ingredient ingredient;
		private final Advancement.Builder advancement;
		private final ResourceLocation advancementId;

		public Result(ResourceLocation id, Item result, int count, String group, Ingredient ingredient, Advancement.Builder advancement, ResourceLocation advancementID) {
			this.id = id;
			this.result = result;
			this.count = count;
			this.group = group;
			this.ingredient = ingredient;
			this.advancement = advancement;
			this.advancementId = advancementID;
		}

		public void serializeRecipeData(JsonObject jsonObject) {
			if (!this.group.isEmpty()) {
				jsonObject.addProperty("group", this.group);
			}

			jsonObject.add("ingredient", this.ingredient.toJson());
			JsonObject resultObject = new JsonObject();
			resultObject.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result).toString());
			if (this.count > 1) {
				resultObject.addProperty("count", this.count);
			}

			jsonObject.add("result", resultObject);
		}

		public RecipeSerializer<?> getType() {
			return FarmingRecipes.PISTON_CRAFTING_SERIALIZER.get();
		}

		public ResourceLocation getId() {
			return this.id;
		}

		@Nullable
		public JsonObject serializeAdvancement() {
			return this.advancement.serializeToJson();
		}

		@Nullable
		public ResourceLocation getAdvancementId() {
			return this.advancementId;
		}
	}
}