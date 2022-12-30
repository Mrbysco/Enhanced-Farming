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
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
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

		eventBus.addListener(this::registerCreativeTabs);
		eventBus.addListener(this::buildTabContents);

		FarmingRegistry.BLOCKS.register(eventBus);
		FarmingRegistry.ITEMS.register(eventBus);
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

	private static CreativeModeTab TAB_MAIN;

	private void registerCreativeTabs(final CreativeModeTabEvent.Register event) {
		TAB_MAIN = event.registerCreativeModeTab(new ResourceLocation(Reference.MOD_ID, "tab"), builder ->
				builder.icon(() -> new ItemStack(FarmingRegistry.SCARECROW_ITEM.get()))
						.title(Component.translatable("itemGroup.enhancedfarming.tab"))
						.displayItems((features, output, hasPermissions) -> {
							List<ItemStack> stacks = FarmingRegistry.ITEMS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
							output.acceptAll(stacks);
						}));
	}

	private void buildTabContents(final CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
			List<ItemStack> stacks = FarmingRegistry.ITEMS.getEntries().stream()
					.filter(reg -> reg.get().getFoodProperties() != null).map(reg -> new ItemStack(reg.get())).toList();
			event.acceptAll(stacks);
		}
	}
}
