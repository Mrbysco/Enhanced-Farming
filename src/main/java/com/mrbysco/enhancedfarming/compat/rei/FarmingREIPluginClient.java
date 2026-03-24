//package com.mrbysco.enhancedfarming.compat.rei;
//
//import com.mrbysco.enhancedfarming.EnhancedFarming;
//import com.mrbysco.enhancedfarming.compat.rei.category.PistonCategory;
//import com.mrbysco.enhancedfarming.compat.rei.display.PistonDisplay;
//import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
//import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
//import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
//import me.shedaniel.rei.api.common.category.CategoryIdentifier;
//import me.shedaniel.rei.api.common.util.EntryStacks;
//import me.shedaniel.rei.forge.REIPluginClient;
//import net.minecraft.world.item.Items;
//
//@REIPluginClient
//public class FarmingREIPluginClient implements REIClientPlugin {
//	public static final CategoryIdentifier<PistonDisplay> PISTON = CategoryIdentifier.of(EnhancedFarming.MOD_ID, "plugins/piston");
//
//	@Override
//	public void registerCategories(CategoryRegistry registry) {
//		registry.add(new PistonCategory());
//
//		registry.addWorkstations(PISTON, EntryStacks.of(Items.PISTON), EntryStacks.of(Items.STICKY_PISTON));
//	}
//
//	@Override
//	public void registerDisplays(DisplayRegistry registry) {
//		REIClientPlugin.super.registerDisplays(registry);
//	}
//}
