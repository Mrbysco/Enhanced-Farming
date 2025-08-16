package com.mrbysco.enhancedfarming;

import com.mrbysco.enhancedfarming.client.ClientHandler;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.handler.HotHandler;
import com.mrbysco.enhancedfarming.handler.InWorldCraftingHandler;
import com.mrbysco.enhancedfarming.handler.InteractionHandler;
import com.mrbysco.enhancedfarming.handler.RakeHandler;
import com.mrbysco.enhancedfarming.init.FarmingConditions;
import com.mrbysco.enhancedfarming.init.FarmingGLM;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import com.mrbysco.enhancedfarming.world.feature.FarmingFeatures;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod(EnhancedFarming.MOD_ID)
public class EnhancedFarming {
	public static final String MOD_ID = "enhancedfarming";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public EnhancedFarming(IEventBus eventBus, ModContainer container, Dist dist) {
		container.registerConfig(ModConfig.Type.COMMON, FarmingConfig.commonSpec);
		eventBus.register(FarmingConfig.class);

		eventBus.addListener(this::setup);
		eventBus.addListener(this::buildTabContents);

		FarmingRegistry.BLOCKS.register(eventBus);
		FarmingRegistry.ITEMS.register(eventBus);
		FarmingRegistry.CREATIVE_MODE_TABS.register(eventBus);
		FarmingRegistry.BLOCK_ENTITY_TYPES.register(eventBus);
		FarmingFeatures.FEATURES.register(eventBus);
		FarmingRecipes.RECIPE_TYPES.register(eventBus);
		FarmingRecipes.RECIPE_SERIALIZERS.register(eventBus);
		FarmingGLM.GLM.register(eventBus);
		FarmingConditions.CONDITION_CODECS.register(eventBus);

		NeoForge.EVENT_BUS.register(new InteractionHandler());
		NeoForge.EVENT_BUS.register(new InWorldCraftingHandler());
		NeoForge.EVENT_BUS.register(new HotHandler());
		NeoForge.EVENT_BUS.register(new RakeHandler());

		if (dist.isClient()) {
			container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
			eventBus.addListener(ClientHandler::registerBlockColors);
			eventBus.addListener(ClientHandler::registerItemColors);
		}
	}

	private void setup(final FMLCommonSetupEvent event) {
		FarmingRegistry.registerCompostable();
	}

	private void buildTabContents(final BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			List<ItemStack> stacks = FarmingRegistry.ITEMS.getEntries().stream()
					.filter(reg -> reg.get().getDefaultInstance().has(DataComponents.FOOD)).map(reg -> new ItemStack(reg.get())).toList();
			event.acceptAll(stacks);
		}
	}

	public static ResourceLocation modLoc(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
