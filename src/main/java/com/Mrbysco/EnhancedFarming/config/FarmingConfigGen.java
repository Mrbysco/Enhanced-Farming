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
			
			@Config.Comment({"Pizza Stats"})
			public final Pizza pizza = new Pizza();
			
			@Config.Comment({"Pie Stats"})
			public final Pies pies = new Pies();
			
			@Config.Comment({"Sandwich Stats"})
			public final Sandwich sandwiches = new Sandwich();
			
			@Config.Comment({"Fruit Stats"})
			public final Fruits fruits = new Fruits();
			
			@Config.Comment({"Vegetable Stats"})
			public final Vegetables vegetables = new Vegetables();
			
			@Config.Comment({"Drinks Stats"})
			public final Bottles drinks = new Bottles();
			
			@Config.Comment({"Soup Stats"})
			public final Soups soups = new Soups();
			
			public class Food{
				@Config.Comment("Chocolate Bar Stats")
				public int chocolateBarHealAmount = 4;
				
				@Config.Comment("Chocolate Candy Stats")
				public int chocolateCandyHealAmount = 2;
				
				@Config.Comment("Golden Orange Stats")
				public int goldenOrangeHealAmount = 2;
				
				@Config.Comment("Golden Lemon Stats")
				public int goldenLemonHealAmount = 2;
				
				@Config.Comment("Mint Chocolate Bar Stats")
				public int mintChocolateBarHealAmount = 4;

				@Config.Comment("Chocolate Cherry Stats")
				public int chocolateCherryHealAmount = 3;
				
				@Config.Comment("Chocolate Banana Stats")
				public int chocolateBananaHealAmount = 4;
				
				@Config.Comment("Garlic Stats")
				public int garlicHealAmount = 1;
				
				@Config.Comment("Fruit Salad Stats")
				public int fruitSaladHealAmount = 5;
				
				@Config.Comment("Hamburger Stats")
				public int hamburgerHealAmount = 15;
				
				@Config.Comment("Chicken Burger Stats")
				public int chickenburgerHealAmount = 13;
				
				@Config.Comment("Cheese Burger Stats")
				public int cheeseburgerHealAmount = 9;
				
				@Config.Comment("Boiled Egg Stats")
				public int boiledEggHealAmount = 3;
				
				@Config.Comment("Omelet Stats")
				public int omeletHealAmount = 3;
				
				@Config.Comment("Sliced Bread Stats")
				public int slicedBreadHealAmount = 3;
				
				@Config.Comment("Cheese Stats")
				public int cheeseHealAmount = 4;
				
				@Config.Comment("Spaghetti Stats")
				public int spaghettiHealAmount = 9;
				
				@Config.Comment("Fruit Jam Stats")
				public int jamHealAmount = 6;
				
				@Config.Comment("Fries Stats")
				public int friesHealAmount = 8;
				
				@Config.Comment("Fish And Chips Stats")
				public int fishAndChipsHealAmount = 14;
				
				@Config.Comment("Potato Chips Stats")
				public int potatoChipsHealAmount = 6;
				
				@Config.Comment("Guacamole Stats")
				public int guacamoleHealAmount = 3;
				
				@Config.Comment("Guac And Chips Stats")
				public int guacAndChipsHealAmount = 9;
			}
			
			public class Pizza{
				@Config.Comment("Pineapple Pizza Stats")
				public int pineapplePizzaHealAmount = 7;
				
				@Config.Comment("Cheese Pizza Stats")
				public int cheesePizzaHealAmount = 9;
				
				@Config.Comment("Bacon Pizza Stats")
				public int baconPizzaHealAmount = 11;
			}
			public class Sandwich{
				@Config.Comment("Egg Sandwich Stats")
				public int eggSandwichHealAmount = 8;
				
				@Config.Comment("Bacon Sandwich Stats")
				public int baconSandwichHealAmount = 13;
				
				@Config.Comment("Sandwich Sandwich Stats")
				public int chickenSandwichHealAmount = 13;
				
				@Config.Comment("Jam And Cheese Sandwich Stats")
				public int jcSandwichHealAmount = 8;
			}
			
			public class Pies{
				@Config.Comment("Apple Pie Stats")
				public int applePieHealAmount = 8;
				
				@Config.Comment("Banana Cream Pie Stats")
				public int bananaPieHealAmount = 8;
				
				@Config.Comment("Bacon And Egg Pie Stats")
				public int baconAndEggPieHealAmount = 11;
				
				@Config.Comment("Cherry Pie Stats")
				public int cherryPieHealAmount = 6;
				
				@Config.Comment("Grape Pie Stats")
				public int grapePieHealAmount = 6;
				
				@Config.Comment("Lemon Meringue Pie Stats")
				public int lemonPieHealAmount = 8;
				
				@Config.Comment("Pear Pie Stats")
				public int pearPieHealAmount = 8;
			}
			
			public class Fruits{
				@Config.Comment("Lemon Stats")
				public int lemonHealAmount = 2;
				
				@Config.Comment("Orange Heal Stats")
				public int orangeHealAmount = 2;

				@Config.Comment("Cherry Stats")
				public int cherryHealAmount = 1;
				
				@Config.Comment("Avocado Stats")
				public int avocadoHealAmount = 3;
				
				@Config.Comment("Pear Stats")
				public int pearHealAmount = 2;
				
				@Config.Comment("Banana Stats")
				public int bananaHealAmount = 2;
				
				@Config.Comment("Tomato Stats")
				public int tomatoHealAmount = 2;
				
				@Config.Comment("Grape Stats")
				public int grapesHealAmount = 1;
				
				@Config.Comment("Pineapple Stats")
				public int pineappleHealAmount = 2;
				
				@Config.Comment("Mango Stats")
				public int mangoHealAmount = 2;
			}
			
			public class Vegetables{
				@Config.Comment("Cucumber Stats")
				public int cucumberHealAmount = 2;
				
				@Config.Comment("Aubergine Stats")
				public int aubergineHealAmount = 2;
				
				@Config.Comment("Corn Stats")
				public int cornHealAmount = 2;
				
				@Config.Comment("Onion Stats")
				public int onionHealAmount = 2;
				
				@Config.Comment("Olive Stats")
				public int oliveHealAmount = 2;
				
				@Config.Comment("Lettuce Stats")
				public int lettuceHealAmount = 2;
			}
			
			public class Bottles{
				@Config.Comment("Milk Bottle Stats")
				public int milkBottleHealAmount = 0;
				
				@Config.Comment("Cold Chocolate Stats")
				public int coldChocolateBottleHealAmount = 4;
				
				@Config.Comment("Hot Chocolate Stats")
				public int hotChocolateBottleHealAmount = 6;
				
				@Config.Comment("Mint Tea Stats")
				public int mintTeaHealAmount = 8;
				
				//Juices
				@Config.Comment("Apple Juice Stats")
				public int appleJuiceHealAmount = 4;
				
				@Config.Comment("Lemonade Stats")
				public int lemonadeHealAmount = 6;
				
				@Config.Comment("Orange Juice Stats")
				public int orangeJuiceHealAmount = 4;
				
				@Config.Comment("Cherry Juice Stats")
				public int cherryJuiceHealAmount = 3;
				
				@Config.Comment("Pear Juice Stats")
				public int pearJuiceHealAmount = 4;
				
				@Config.Comment("Banana Juice Stats")
				public int bananaJuiceHealAmount = 4;
				
				@Config.Comment("Grape Juice Stats")
				public int grapeJuiceHealAmount = 3;
				
				@Config.Comment("Mango Juice Stats")
				public int mangoJuiceHealAmount = 4;

				@Config.Comment("Pineapple Juice Stats")
				public int pineappleJuiceHealAmount = 4;
				
				//Smoothies
				@Config.Comment("Apple Smoothie Stats")
				public int smoothieAppleHealAmount = 5;
				
				@Config.Comment("Lemon Smoothie Stats")
				public int smoothieLemonHealAmount = 5;
				
				@Config.Comment("Orange Smoothie Stats")
				public int smoothieOrangeHealAmount = 5;
				
				@Config.Comment("Cherry Smoothie Stats")
				public int smoothieCherryHealAmount = 4;
				
				@Config.Comment("Pear Smoothie Stats")
				public int smoothiePearHealAmount = 5;
				
				@Config.Comment("Banana Smoothie Stats")
				public int smoothieBananaHealAmount = 5;
				
				@Config.Comment("Grape Smoothie Stats")
				public int smoothieGrapeHealAmount = 4;
				
				@Config.Comment("Mango Smoothie Stats")
				public int smoothieMangoHealAmount = 5;
				
				@Config.Comment("Pineapple Smoothie Stats")
				public int smoothiePineappleHealAmount = 5;
				
				@Config.Comment("Cucumber Smoothie Stats")
				public int smoothieCucumberHealAmount = 5;
			}
			
			public class Soups{
				@Config.Comment("Corn Soup Stats")
				public int cornSoupHealAmount = 6;
				
				@Config.Comment("Cucumber Soup Stats")
				public int cucumberSoupHealAmount = 7;
				
				@Config.Comment("Tomato Soup Stats")
				public int tomatoSoupHealAmount = 6;
				
				@Config.Comment("Potato Soup Stats")
				public int potatoSoupHealAmount = 6;
				
				@Config.Comment("Carrot Soup Stats")
				public int carrotSoupHealAmount = 7;
				
				@Config.Comment("Onion Soup Stats")
				public int onionSoupHealAmount = 6;
				
				@Config.Comment("Chicken Noodle Soup Stats")
				public int chickenNoodleSoupHealAmount = 11;
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
                "enhancedfarming:banana_sapling",
                "enhancedfarming:avocado_sapling",
                "enhancedfarming:mango_sapling",
                "enhancedfarming:tomato_seeds",
                "enhancedfarming:cucumber_seeds",
                "enhancedfarming:aubergine_seeds",
                "enhancedfarming:pineapple_seeds",
                "enhancedfarming:grape_seeds",
                "enhancedfarming:corn_seeds",
                "enhancedfarming:onion_seeds",
                "enhancedfarming:garlic_seeds",
                "enhancedfarming:olive_sapling",
                "enhancedfarming:lettuce_seeds"
			};
			
			@Config.Comment("Makes it so if you hold hot drinks for too long that you begin taking fire damage")
			public boolean tooHot = false;
			
			@Config.Comment("Enables the old leave behavior. [leaves having a 1/3 chance of becoming a normal leave upon dropping fruit]")
			public boolean oldLeaveDecay = true;
			
			@Config.Comment("Enables bonemeal to work on the mods plants")
			public boolean bonemealGrow = true;
			
			@Config.Comment("Instant grow from bonemeal")
			public boolean instantGrow = false;
			
			@Config.Comment("Enables crops to seed recipe")
			public boolean cropToSeeds = true;
			
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
