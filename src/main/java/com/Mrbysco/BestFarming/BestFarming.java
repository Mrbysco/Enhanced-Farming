package com.Mrbysco.BestFarming;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Mrbysco.BestFarming.config.FarmingConfigGen;
import com.Mrbysco.BestFarming.handler.FarmingHandlers;
import com.Mrbysco.BestFarming.init.FarmingRecipes;
import com.Mrbysco.BestFarming.init.FarmingTab;
import com.Mrbysco.BestFarming.proxy.CommonProxy;
import com.Mrbysco.BestFarming.tileentity.TileEntityScarecrow;
import com.Mrbysco.BestFarming.world.NetherWorldGen;
import com.Mrbysco.BestFarming.world.TreeWorldGen;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, 
name = Reference.MOD_NAME, 
version = Reference.VERSION, 
acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)

public class BestFarming {

	@Instance(Reference.MOD_ID)
	public static BestFarming instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
	
	public static FarmingTab tabFarming = new FarmingTab();
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{	
		logger.debug("Registering Config");
		MinecraftForge.EVENT_BUS.register(new FarmingConfigGen());
		
		GameRegistry.registerTileEntity(TileEntityScarecrow.class, Reference.MOD_ID + "_scarecrow");
		
		logger.debug("Initializing Furnace Recipe");
		FarmingRecipes.init();
		
		proxy.Preinit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		logger.debug("Registering the bottle handler");
		MinecraftForge.EVENT_BUS.register(new FarmingHandlers());

		if(FarmingConfigGen.general.othersettings.treeGen) {
			logger.debug("Initializing Tree Generator");
			GameRegistry.registerWorldGenerator(new TreeWorldGen(), 0);
		}
		
		if(FarmingConfigGen.general.othersettings.netherGen) {
			logger.debug("Initializing Nether Generator");
			GameRegistry.registerWorldGenerator(new NetherWorldGen(), 0);
	    }
		
		proxy.Init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
