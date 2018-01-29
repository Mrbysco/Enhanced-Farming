package com.Mrbysco.EnhancedFarming.config;

import com.Mrbysco.EnhancedFarming.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
@Config.LangKey("enhancedfarming.config.title")
public class FarmingConfigGen {

	@Config.Comment({"General Configuration"})
	public static General general = new General();
	
	public static class General{
		public FoodSettings foodsettings = new FoodSettings();
		
		public OtherSettings othersettings = new OtherSettings();
		
		public class FoodSettings{
			@Config.Comment({"Food Stats"})
			public final Food food = new Food();
			
			@Config.Comment({"Drinks Stats"})
			public final Bottles drinks = new Bottles();
			
			public class Food{
				@Config.Comment("Chocolate Bar Stats")
				public int chocolateBarHealAmount = 4;
				
				@Config.Comment("Chocolate Candy Stats")
				public int chocolateCandyHealAmount = 2;
				
				@Config.Comment("Golden Orange Stats")
				public int goldenOrangeHealAmount = 2;
				
				@Config.Comment("Golden Lemon Stats")
				public int goldenLemonHealAmount = 2;
				
				@Config.Comment("Lemon Stats")
				public int lemonHealAmount = 2;
				
				@Config.Comment("Mint Chocolate Bar Stats")
				public int mintChocolateBarHealAmount = 4;
				
				@Config.Comment("Mint Tea Stats")
				public int mintTeaHealAmount = 8;
				
				@Config.Comment("Orange Heal Stats")
				public int orangeHealAmount = 2;

				@Config.Comment("Cherry Stats")
				public int cherryHealAmount = 2;
				
				@Config.Comment("Pear Stats")
				public int pearHealAmount = 2;
				
				@Config.Comment("Banana Stats")
				public int bananaHealAmount = 2;
				
				@Config.Comment("Chocolate Cherry Stats")
				public int chocolateCherryHealAmount = 3;
				
				@Config.Comment("Chocolate Banana Stats")
				public int chocolateBananaHealAmount = 4;
			}
			
			public class Bottles{
				@Config.Comment("Milk Bottle Stats")
				public int milkBottleHealAmount = 0;
				
				@Config.Comment("Cold Chocolate Stats")
				public int coldChocolateBottleHealAmount = 4;
				
				@Config.Comment("Hot Chocolate Stats")
				public int hotChocolateBottleHealAmount = 6;
				
				//Juices
				@Config.Comment("Apple Juice Stats")
				public int appleJuiceHealAmount = 4;
				
				@Config.Comment("Lemonade Stats")
				public int lemonadeHealAmount = 6;
				
				@Config.Comment("Orange Juice Stats")
				public int orangeJuiceHealAmount = 4;
				
				//Smoothies
				@Config.Comment("Apple Smoothie Stats")
				public int smoothieAppleHealAmount = 6;
				
				@Config.Comment("Lemon Smoothie Stats")
				public int smoothieLemonHealAmount = 6;
				
				@Config.Comment("Orange Smoothie Stats")
				public int smoothieOrangeHealAmount = 6;
				
				@Config.Comment("Cherry Smoothie Stats")
				public int smoothieCherryHealAmount = 6;
				
				@Config.Comment("Pear Smoothie Stats")
				public int smoothiePearHealAmount = 6;
				
				@Config.Comment("Banana Smoothie Stats")
				public int smoothieBananaHealAmount = 6;
			}
		}
		
		public class OtherSettings{
			@Config.Comment("Enables rakes")
			public boolean enableRake = true;

			@Config.Comment("Rake Drops")
			public String[] rakeDrops = new String[] {
				"minecraft:wheat_seeds",
				"minecraft:pumpkin_seeds",
				"minecraft:melon_seeds",
				"minecraft:beetroot_seeds",
                "enhancedfarming:apple_sapling",
                "enhancedfarming:lemon_sapling",
                "enhancedfarming:orange_sapling",
                "enhancedfarming:mint_seeds",
                "enhancedfarming:nether_flower_seeds",
                "enhancedfarming:cherry_sapling",
                "enhancedfarming:pear_sapling",
                "enhancedfarming:banana_sapling"
			};
			
			@Config.Comment("Makes it so if you hold hot drinks for too long that you begin taking fire damage")
			public boolean tooHot = false;
			
			@Config.Comment("Enables the old leave behavior. [leaves having a 1/3 chance of becoming a normal leave upon dropping fruit]")
			public boolean oldLeaveDecay = true;
			
			@Config.Comment("Enables bonemeal to work on the mods plants")
			public boolean bonemealGrow = true;
			
			@Config.Comment("Instant grow from bonemeal")
			public boolean instantGrow = false;
			
			@Config.Comment("Enables fruit to seed recipe")
			public boolean fruitToSeeds = true;
			
			@Config.Comment("Enables Fruit Tree Generation")
			public boolean treeGen = true;
			
			@Config.Comment("Fruit Drop Rate")
			public int treeDropRate = 20;
			
			@Config.Comment("Enables Nether Generation")
			public boolean netherGen = true;
		}
		
	}
	
	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	private static class EventHandler {
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Reference.MOD_ID)) {
				ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}
}
