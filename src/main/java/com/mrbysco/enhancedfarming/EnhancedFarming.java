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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod(Reference.MOD_ID)
public class EnhancedFarming {
	public static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);

	public EnhancedFarming() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(Type.COMMON, FarmingConfig.commonSpec);
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

		MinecraftForge.EVENT_BUS.register(new InteractionHandler());
		MinecraftForge.EVENT_BUS.register(new InWorldCraftingHandler());
		MinecraftForge.EVENT_BUS.register(new HotHandler());
		MinecraftForge.EVENT_BUS.register(new RakeHandler());

		eventBus.register(new FarmingConditions());

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			eventBus.addListener(ClientHandler::registerBlockColors);
			eventBus.addListener(ClientHandler::registerItemColors);
		});
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
