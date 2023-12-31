package com.mrbysco.enhancedfarming.compat.rei.display;

import com.mrbysco.enhancedfarming.compat.rei.REIPlugin;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.core.RegistryAccess;

import java.util.List;

public final class PistonDisplay implements Display {
	private final PistonRecipe recipe;

	private final List<EntryIngredient> inputEntries;
	private final List<EntryIngredient> outputEntries;

	public PistonDisplay(PistonRecipe recipe, RegistryAccess registryAccess) {
		this.recipe = recipe;

		this.inputEntries = EntryIngredients.ofIngredients(recipe.getIngredients());
		this.outputEntries = List.of(EntryIngredients.of(recipe.getResultItem(registryAccess).copy()));
	}

	@Override
	public List<EntryIngredient> getInputEntries() {
		return inputEntries;
	}

	@Override
	public List<EntryIngredient> getOutputEntries() {
		return outputEntries;
	}

	@Override
	public CategoryIdentifier<?> getCategoryIdentifier() {
		return REIPlugin.PISTON;
	}

	public PistonRecipe recipe() {
		return recipe;
	}
}
