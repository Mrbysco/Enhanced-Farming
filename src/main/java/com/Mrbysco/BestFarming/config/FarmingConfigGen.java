package com.Mrbysco.BestFarming.config;

import com.Mrbysco.BestFarming.Reference;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Reference.MOD_ID)
@Config.LangKey("bestfarming.config.title")
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
				@Config.Comment("Apple Juice Stats")
				public int appleJuiceHealAmount = 4;
				
				@Config.Comment("Chocolate Bar Stats")
				public int chocolateBarHealAmount = 4;
				
				@Config.Comment("Chocolate Candy Stats")
				public int chocolateCandyHealAmount = 2;
				
				@Config.Comment("Golden Orange Stats")
				public int goldenOrangeHealAmount = 2;
				
				@Config.Comment("Golden Lemon Stats")
				public int goldenLemonHealAmount = 2;
				
				@Config.Comment("Lemonade Stats")
				public int lemonadeHealAmount = 6;
				
				@Config.Comment("Lemon Stats")
				public int lemonHealAmount = 2;
				
				@Config.Comment("Mint Chocolate Bar Stats")
				public int mintChocolateBarHealAmount = 4;
				
				@Config.Comment("Mint Tea Stats")
				public int mintTeaHealAmount = 8;
				
				@Config.Comment("Orange Heal Stats")
				public int orangeHealAmount = 2;
				
				@Config.Comment("Orange Juice Stats")
				public int orangeJuiceHealAmount = 4;
			}
			
			public class Bottles{
				@Config.Comment("Milk Bottle Stats")
				public int milkBottleHealAmount = 0;
				
				@Config.Comment("Cold Chocolate Stats")
				public int coldChocolateBottleHealAmount = 4;
				
				@Config.Comment("Hot Chocolate Stats")
				public int hotChocolateBottleHealAmount = 6;
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
                "bestfarming:applesapling",
                "bestfarming:lemonsapling",
                "bestfarming:orangesapling",
                "bestfarming:mintseeds",
                "bestfarming:netherflowerseeds"
			};
			
			@Config.Comment("Enables rakes")
			public boolean tooHot = true;
			
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
