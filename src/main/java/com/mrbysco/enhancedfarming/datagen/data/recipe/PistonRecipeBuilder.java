package com.mrbysco.enhancedfarming.datagen.data.recipe;

import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PistonRecipeBuilder implements RecipeBuilder {
	private final ItemStackTemplate result;
	private final Ingredient ingredient;
	private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
	@Nullable
	private String group;

	public PistonRecipeBuilder(ItemLike like, int count, Ingredient ingredient) {
		this.result = new ItemStackTemplate(like.asItem(), count);
		this.ingredient = ingredient;
	}

	@Override
	public PistonRecipeBuilder unlockedBy(String id, Criterion<?> criterion) {
		this.criteria.put(id, criterion);
		return this;
	}

	@Override
	public PistonRecipeBuilder group(@Nullable String group) {
		this.group = group;
		return this;
	}

	@Override
	public ResourceKey<Recipe<?>> defaultId() {
		return RecipeBuilder.getDefaultRecipeId(this.result);
	}

	@Override
	public void save(RecipeOutput output, ResourceKey<Recipe<?>> id) {
		Advancement.Builder advancement$builder = output.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id)).rewards(AdvancementRewards.Builder.recipe(id)).requirements(AdvancementRequirements.Strategy.OR);
		Objects.requireNonNull(advancement$builder);
		this.criteria.forEach(advancement$builder::addCriterion);
		PistonRecipe recipe = new PistonRecipe(this.group == null ? "" : this.group, this.ingredient, this.result);
		output.accept(id, recipe, advancement$builder.build(id.identifier().withPrefix("recipes/")));
	}
}