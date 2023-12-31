package com.mrbysco.enhancedfarming.compat.rei.category;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.compat.rei.REIPlugin;
import com.mrbysco.enhancedfarming.compat.rei.display.PistonDisplay;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.List;

public class PistonCategory implements DisplayCategory<PistonDisplay> {
	private static final ResourceLocation ICON_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/jei/piston_icon.png");
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/jei/piston.png");

	@Override
	public CategoryIdentifier<? extends PistonDisplay> getCategoryIdentifier() {
		return REIPlugin.PISTON;
	}

	@Override
	public Component getTitle() {
		return Component.translatable("enhancedfarming.gui.jei.category.piston");
	}

	@Override
	public Renderer getIcon() {
		return EntryStacks.of(Items.PISTON);
	}

	@Override
	public List<Widget> setupDisplay(PistonDisplay display, Rectangle bounds) {
		Point centerPoint = new Point(bounds.getCenterX(), bounds.getCenterY());
		List<Widget> widgets = new ArrayList<>();
		widgets.add(Widgets.createRecipeBase(bounds));
		widgets.add(Widgets.createTexturedWidget(TEXTURE, centerPoint.x - 24, centerPoint.y - 24, 18, 7, 48, 48));

		widgets.add(Widgets.createSlot(new Point(bounds.getMinX() + 5, centerPoint.y - 8)).entries(display.getInputEntries().get(0)).markInput());
		widgets.add(Widgets.createSlot(new Point(bounds.getMaxX() - 21, centerPoint.y - 8)).entries(display.getOutputEntries().get(0)).markOutput());

		return widgets;
	}

	@Override
	public int getDisplayWidth(PistonDisplay display) {
		return 94;
	}

	@Override
	public int getDisplayHeight() {
		return 62;
	}
}
