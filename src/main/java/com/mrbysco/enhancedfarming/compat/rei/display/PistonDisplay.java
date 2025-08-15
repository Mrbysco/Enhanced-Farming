package com.mrbysco.enhancedfarming.compat.rei.display;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrbysco.enhancedfarming.compat.rei.FarmingREIPlugin;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public final class PistonDisplay implements Display {
	public static final DisplaySerializer<PistonDisplay> SERIALIZER = DisplaySerializer.of(
			RecordCodecBuilder.mapCodec(instance -> instance.group(
					EntryIngredient.codec().fieldOf("input").forGetter(d -> d.input),
					EntryIngredient.codec().fieldOf("output").forGetter(d -> d.output)
			).apply(instance, PistonDisplay::new)),
			StreamCodec.composite(
					EntryIngredient.streamCodec(),
					d -> d.input,
					EntryIngredient.streamCodec(),
					d -> d.output,
					PistonDisplay::new
			));

	private final EntryIngredient input;
	private final EntryIngredient output;

	public PistonDisplay(EntryIngredient input, EntryIngredient output) {
		this.input = input;
		this.output = output;
	}

	public PistonDisplay(RecipeHolder<PistonRecipe> recipeHolder) {
		this(
				EntryIngredients.ofIngredient(recipeHolder.value().ingredient()),
				EntryIngredients.of(recipeHolder.value().result())
		);
	}

	@Override
	public List<EntryIngredient> getInputEntries() {
		return List.of(input);
	}

	@Override
	public List<EntryIngredient> getOutputEntries() {
		return List.of(output);
	}

	@Override
	public CategoryIdentifier<?> getCategoryIdentifier() {
		return FarmingREIPlugin.PISTON;
	}

	@Override
	public Optional<ResourceLocation> getDisplayLocation() {
		return Optional.empty();
	}

	@Nullable
	@Override
	public DisplaySerializer<? extends Display> getSerializer() {
		return SERIALIZER;
	}
}
