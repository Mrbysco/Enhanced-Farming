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
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod(Reference.MOD_ID)
public class EnhancedFarming {
	public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

	public EnhancedFarming() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, FarmingConfig.commonSpec);
		FMLJavaModLoadingContext.get().getModEventBus().register(FarmingConfig.class);

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


		if (FMLEnvironment.dist.isClient()) {
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
					.filter(reg -> reg.get().isEdible()).map(reg -> new ItemStack(reg.get())).toList();
			event.acceptAll(stacks);
		}
	}
}
