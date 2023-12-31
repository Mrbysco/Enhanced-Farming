package com.mrbysco.enhancedfarming.datagen.data.recipe;

import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PistonRecipeBuilder implements RecipeBuilder {
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
		PistonRecipe recipe = new PistonRecipe(this.group == null ? "" : this.group, this.ingredient, new ItemStack(this.result, this.count));
		recipeConsumer.accept(id, recipe, advancement$builder.build(id.withPrefix("recipes/")));
	}

	private void ensureValid(ResourceLocation id) {
		if (this.criteria.isEmpty()) {
			throw new IllegalStateException("No way of obtaining recipe " + id);
		}
	}
}