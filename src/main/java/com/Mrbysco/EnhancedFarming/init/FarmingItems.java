package com.Mrbysco.EnhancedFarming.init;

import java.util.ArrayList;

import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.item.ItemBowledFood;
import com.Mrbysco.EnhancedFarming.item.ItemCropstickSeeds;
import com.Mrbysco.EnhancedFarming.item.ItemCustom;
import com.Mrbysco.EnhancedFarming.item.ItemCustomFood;
import com.Mrbysco.EnhancedFarming.item.ItemCustomSpecialFood;
import com.Mrbysco.EnhancedFarming.item.ItemCustomUtensil;
import com.Mrbysco.EnhancedFarming.item.ItemDrink;
import com.Mrbysco.EnhancedFarming.item.ItemRakeTool;
import com.Mrbysco.EnhancedFarming.item.ItemRegularSeeds;

import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class FarmingItems {
	
	public static ItemRegularSeeds mint_seeds;
	public static ItemRegularSeeds nether_flower_seeds;

	public static ItemFood milk_bottle;
	public static ItemFood cold_chocolate_bottle;
	public static ItemFood hot_chocolate_bottle;
	
	public static ItemFood apple_juice;
	public static ItemFood chocolate_bar;
	public static ItemFood chocolate_candy;
	public static ItemFood lemon;
	public static ItemFood lemonade;
	public static ItemFood mint_chocolate_bar;
	public static ItemFood mint_tea;
	public static ItemFood orange;
	public static ItemFood orange_juice;
	
	public static ItemFood golden_lemon;
	public static ItemFood golden_orange;
	
	public static Item mint;
	public static Item hot_water;
	
	public static ItemCustomUtensil pot;
	public static ItemCustomUtensil cutting_board;
	public static ItemCustomUtensil mortal_and_pestle;
	
	public static ItemTool wooden_rake;
	public static ItemTool stone_rake;
	public static ItemTool iron_rake;
	public static ItemTool gold_rake;
	public static ItemTool diamond_rake;
	
	//New Content
	public static ItemFood cherry;
	public static ItemFood pear;
	public static ItemFood banana;
	
	public static ItemFood chocolate_cherry;
	public static ItemFood chocolate_banana;

	public static ItemFood cherry_juice;
	public static ItemFood pear_juice;
	public static ItemFood banana_juice;
	public static ItemFood grape_juice;
	public static ItemFood mango_juice;
	public static ItemFood pineapple_juice;
	
	public static ItemFood smoothie_apple;
	public static ItemFood smoothie_lemon;
	public static ItemFood smoothie_orange;
	public static ItemFood smoothie_cherry;
	public static ItemFood smoothie_pear;
	public static ItemFood smoothie_banana;
	public static ItemFood smoothie_grape;
	public static ItemFood smoothie_mango;
	public static ItemFood smoothie_pineapple;
	public static ItemFood smoothie_cucumber;
	
	public static ItemFood avocado;
	public static ItemFood tomato;
	public static ItemFood cucumber;
	public static ItemFood aubergine;
	public static ItemFood grapes;
	public static ItemFood mango;
	public static ItemFood pineapple;
	public static ItemFood corn;
	public static ItemFood onion;
	public static ItemFood garlic;
	public static ItemFood olive;
	public static ItemFood lettuce;
		
	public static ItemRegularSeeds tomato_seeds;
	public static ItemRegularSeeds cucumber_seeds;
	public static ItemRegularSeeds aubergine_seeds;
	public static ItemRegularSeeds pineapple_seeds;
	public static ItemRegularSeeds corn_seeds;
	public static ItemRegularSeeds onion_seeds;
	public static ItemRegularSeeds garlic_seeds;
	public static ItemRegularSeeds lettuce_seeds;
	public static ItemCropstickSeeds grape_seeds;
	
	public static Item stock;
	public static Item salt;
	public static Item flour;
	public static Item dough;
	public static Item olive_oil;
	public static Item pasta;
	//Actual food
	
	public static ItemFood fruit_salad;
	public static ItemFood corn_soup;
	public static ItemFood cucumber_soup;
	public static ItemFood tomato_soup;
	public static ItemFood potato_soup;
	public static ItemFood carrot_soup;
	public static ItemFood onion_soup;

	public static ItemFood hamburger;
	public static ItemFood chickenburger;
	public static ItemFood cheeseburger;
	
	public static ItemFood boiled_egg;
	public static ItemFood baked_egg;
	public static ItemFood sliced_bread;
	public static ItemFood cheese;
	public static ItemFood spaghetti;
	
	public static ItemFood egg_sandwich;
	public static ItemFood bacon_sandwich;
	public static ItemFood chicken_sandwich;
	
	public static ItemFood pineapple_pizza;
	public static ItemFood cheese_pizza;
	public static ItemFood bacon_pizza;
	
	public static ItemFood apple_pie;
	public static ItemFood lemon_pie;
	public static ItemFood cherry_pie;
	public static ItemFood pear_pie;
	public static ItemFood grape_pie;
	public static ItemFood banana_pie;
	public static ItemFood bacon_and_egg_pie;
	
	//HealAmounts
	private static int appleJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.appleJuiceHealAmount;
	private static int lemonadeAmount = FarmingConfigGen.general.foodsettings.drinks.lemonadeHealAmount;
	private static int orangeJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.orangeJuiceHealAmount;
	
	private static int chocolateAmount = FarmingConfigGen.general.foodsettings.food.chocolateBarHealAmount;
	private static int chocolateCandyAmount = FarmingConfigGen.general.foodsettings.food.chocolateCandyHealAmount;
	private static int lemonAmount = FarmingConfigGen.general.foodsettings.fruits.lemonHealAmount;
	private static int chocolateBarAmount = FarmingConfigGen.general.foodsettings.food.mintChocolateBarHealAmount;
	private static int mintteaAmount = FarmingConfigGen.general.foodsettings.food.mintTeaHealAmount;
	private static int orangeAmount = FarmingConfigGen.general.foodsettings.fruits.orangeHealAmount;
	
	private static int goldenLemon = FarmingConfigGen.general.foodsettings.food.goldenLemonHealAmount;
	private static int goldenOrange = FarmingConfigGen.general.foodsettings.food.goldenOrangeHealAmount;
	
	private static int milkBottleAmount = FarmingConfigGen.general.foodsettings.drinks.milkBottleHealAmount;
	private static int coldchocolateAmount = FarmingConfigGen.general.foodsettings.drinks.coldChocolateBottleHealAmount;
	private static int hotchocolateAmount = FarmingConfigGen.general.foodsettings.drinks.hotChocolateBottleHealAmount;

	//New Content HealAmounts
	private static int cherryAmount = FarmingConfigGen.general.foodsettings.fruits.cherryHealAmount;
	private static int pearAmount = FarmingConfigGen.general.foodsettings.fruits.pearHealAmount;
	private static int bananaAmount = FarmingConfigGen.general.foodsettings.fruits.bananaHealAmount;
	
	private static int chocolateCherryAmount = FarmingConfigGen.general.foodsettings.food.chocolateCherryHealAmount;
	private static int chocolateBananaAmount = FarmingConfigGen.general.foodsettings.food.chocolateBananaHealAmount;
	
	private static int cherryJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.cherryJuiceHealAmount;
	private static int pearJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.pearJuiceHealAmount;
	private static int bananaJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.bananaJuiceHealAmount;
	private static int grapeJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.grapeJuiceHealAmount;
	private static int mangoJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.mangoJuiceHealAmount;
	private static int pineappleJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.pineappleJuiceHealAmount;
	
	private static int appleSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothieAppleHealAmount;
	private static int lemonSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothieLemonHealAmount;
	private static int orangeSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothieOrangeHealAmount;
	private static int cherrySmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothieCherryHealAmount;
	private static int pearSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothiePearHealAmount;
	private static int bananaSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothieBananaHealAmount;
	private static int grapeSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothieGrapeHealAmount;
	private static int mangoSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothieMangoHealAmount;
	private static int pineappleSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothiePineappleHealAmount;
	private static int cucumberSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.smoothieCucumberHealAmount;
	
	private static int avocadoAmount = FarmingConfigGen.general.foodsettings.fruits.avocadoHealAmount;
	private static int tomatoAmount = FarmingConfigGen.general.foodsettings.fruits.tomatoHealAmount;
	private static int cucumberAmount = FarmingConfigGen.general.foodsettings.vegetables.cucumberHealAmount;
	private static int aubergineAmount = FarmingConfigGen.general.foodsettings.vegetables.aubergineHealAmount;
	private static int grapesAmount = FarmingConfigGen.general.foodsettings.fruits.grapesHealAmount;
	private static int mangoAmount = FarmingConfigGen.general.foodsettings.fruits.mangoHealAmount;
	private static int pineappleAmount = FarmingConfigGen.general.foodsettings.fruits.pineappleHealAmount;
	private static int cornAmount = FarmingConfigGen.general.foodsettings.vegetables.cornHealAmount;
	private static int oliveAmount = FarmingConfigGen.general.foodsettings.vegetables.oliveHealAmount;
	private static int garlicAmount = FarmingConfigGen.general.foodsettings.food.garlicHealAmount;
	private static int onionAmount = FarmingConfigGen.general.foodsettings.vegetables.onionHealAmount;
	private static int lettuceAmount = FarmingConfigGen.general.foodsettings.vegetables.lettuceHealAmount;
	
	private static int hamburgerAmount = FarmingConfigGen.general.foodsettings.food.hamburgerHealAmount;
	private static int chickenburgerAmount = FarmingConfigGen.general.foodsettings.food.chickenburgerHealAmount;
	private static int cheeseburgerAmount = FarmingConfigGen.general.foodsettings.food.cheeseburgerHealAmount;
	
	private static int boiledEggAmount = FarmingConfigGen.general.foodsettings.food.boiledEggHealAmount;
	private static int omeletAmount = FarmingConfigGen.general.foodsettings.food.omeletHealAmount;
	private static int slicedBreadAmount = FarmingConfigGen.general.foodsettings.food.slicedBreadHealAmount;
	private static int cheeseAmount = FarmingConfigGen.general.foodsettings.food.cheeseHealAmount;
	private static int spaghettiAmount = FarmingConfigGen.general.foodsettings.food.spaghetti;
	
	private static int eggSandwichAmount = FarmingConfigGen.general.foodsettings.sandwiches.eggSandwichHealAmount;
	private static int baconSandwichAmount = FarmingConfigGen.general.foodsettings.sandwiches.baconSandwichHealAmount;
	private static int chickenSandwichAmount = FarmingConfigGen.general.foodsettings.sandwiches.chickenSandwichHealAmount;
	
	private static int pineapplePizzaAmount = FarmingConfigGen.general.foodsettings.pizza.pineapplePizzaHealAmount;
	private static int cheesePizzaAmount = FarmingConfigGen.general.foodsettings.pizza.cheesePizzaHealAmount;
	private static int baconPizzaAmount = FarmingConfigGen.general.foodsettings.pizza.baconPizzaHealAmount;
	
	private static int applePieAmount = FarmingConfigGen.general.foodsettings.pies.applePieHealAmount;
	private static int bananaPieAmount = FarmingConfigGen.general.foodsettings.pies.bananaPieHealAmount;
	private static int baconAndEggPieAmount = FarmingConfigGen.general.foodsettings.pies.baconAndEggPieHealAmount;
	private static int cherryPieAmount = FarmingConfigGen.general.foodsettings.pies.cherryPieHealAmount;
	private static int grapePieAmount = FarmingConfigGen.general.foodsettings.pies.grapePieHealAmount;
	private static int lemonPieAmount = FarmingConfigGen.general.foodsettings.pies.lemonPieHealAmount;
	private static int pearPieAmount = FarmingConfigGen.general.foodsettings.pies.pearPieHealAmount;
	
	public static int fruitSaladAmount = FarmingConfigGen.general.foodsettings.food.fruitSaladHealAmount;
	public static int cornSoupAmount = FarmingConfigGen.general.foodsettings.soups.cornSoupHealAmount;
	public static int cucumberSoupAmount = FarmingConfigGen.general.foodsettings.soups.cucumberSoupHealAmount;
	public static int tomatoSoupAmount = FarmingConfigGen.general.foodsettings.soups.tomatoSoupHealAmount;
	public static int potatoSoupAmount = FarmingConfigGen.general.foodsettings.soups.potatoSoupHealAmount;
	public static int carrotSoupAmount = FarmingConfigGen.general.foodsettings.soups.carrotSoupHealAmount;
	public static int onionSoupAmount = FarmingConfigGen.general.foodsettings.soups.onionSoupHealAmount;
	
	public static ArrayList<Item> ITEMS = new ArrayList<>();
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        mint_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.mint_crop, Blocks.FARMLAND,"mint_seeds"));
		nether_flower_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.nether_flower_crop, Blocks.SOUL_SAND,"nether_flower_seeds"));
		tomato_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.tomato_crop, Blocks.FARMLAND, "tomato_seeds"));
		cucumber_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.cucumber_crop, Blocks.FARMLAND, "cucumber_seeds"));
		aubergine_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.aubergine_crop, Blocks.FARMLAND, "aubergine_seeds"));
		grape_seeds = registerItem(new ItemCropstickSeeds(FarmingBlocks.grape_crop, "grape_seeds"));
		pineapple_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.pineapple_crop, Blocks.FARMLAND, "pineapple_seeds"));
		corn_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.corn_crop, Blocks.FARMLAND, "corn_seeds"));
		onion_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.onion_crop, Blocks.FARMLAND, "onion_seeds"));
		garlic_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.garlic_crop, Blocks.FARMLAND, "garlic_seeds"));
		lettuce_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.lettuce_crop, Blocks.FARMLAND, "lettuce_seeds"));
		
		pot = registerItem(new ItemCustomUtensil("pot"));
		cutting_board = registerItem(new ItemCustomUtensil("cutting_board"));
		mortal_and_pestle = registerItem(new ItemCustomUtensil("mortal_and_pestle"));
		
		mint = registerItem(new ItemCustom("mint"));
		lemon = registerItem(new ItemCustomFood(lemonAmount, 0.5F, 64, 32, "lemon"));
		orange = registerItem(new ItemCustomFood(orangeAmount, 0.5F, 64, 32, "orange"));
		cherry = registerItem(new ItemCustomFood(cherryAmount, 0.3F, 64, 32, "cherry"));
		pear = registerItem(new ItemCustomFood(pearAmount, 0.5F, 64, 32, "pear"));
		banana = registerItem(new ItemCustomFood(lemonAmount, 0.5F, 64, 32, "banana"));
		olive = registerItem(new ItemCustomFood(oliveAmount, 0.5F, 64, 32, "olive"));
		avocado = registerItem(new ItemCustomFood(avocadoAmount, 0.5F, 64, 32, "avocado"));
		mango = registerItem(new ItemCustomFood(mangoAmount, 0.5F, 64, 32, "mango"));
		tomato = registerItem(new ItemCustomFood(tomatoAmount, 0.5F, 64, 32, "tomato"));
		cucumber = registerItem(new ItemCustomFood(cucumberAmount, 0.5F, 64, 32, "cucumber"));
		aubergine = registerItem(new ItemCustomFood(aubergineAmount, 0.5F, 64, 32, "aubergine"));
		grapes = registerItem(new ItemCustomFood(grapesAmount, 0.5F, 64, 32, "grapes"));
		pineapple = registerItem(new ItemCustomFood(pineappleAmount, 0.5F, 64, 32, "pineapple"));
		corn = registerItem(new ItemCustomFood(cornAmount, 0.5F, 64, 32, "corn"));
		onion = registerItem(new ItemCustomFood(onionAmount, 0.5F, 64, 32, "onion"));
		garlic = registerItem(new ItemCustomFood(garlicAmount, 0.5F, 64, 32, "garlic"));
		lettuce = registerItem(new ItemCustomFood(lettuceAmount, 0.5F, 64, 32, "lettuce"));

		golden_lemon = registerItem(new ItemCustomSpecialFood(goldenLemon, 0.5F, 64, 32, true, false, false, "golden_lemon").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 30*20, 0), 1F));
		golden_orange = registerItem(new ItemCustomSpecialFood(goldenOrange, 0.5F, 64, 32, true, false, false, "golden_orange").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 30*20, 0), 1F));
		
		chocolate_bar = registerItem(new ItemCustomFood(chocolateAmount, 0.7F, 64, 32, "chocolate_bar"));
		chocolate_candy = registerItem(new ItemCustomFood(chocolateCandyAmount, 0.7F, 64, 1, "chocolate_candy"));
		chocolate_cherry = registerItem(new ItemCustomFood(chocolateCherryAmount, 0.5F, 64, 32, "chocolate_cherry"));
		chocolate_banana = registerItem(new ItemCustomFood(chocolateBananaAmount, 0.7F, 64, 32, "chocolate_banana"));
		
		mint_chocolate_bar = registerItem(new ItemDrink(chocolateBarAmount, 0.7F, 16, 32, true, false, "mint_chocolate_bar"));
		mint_tea = registerItem(new ItemDrink(mintteaAmount, 0.3F, 16, 32, true, false, "mint_tea"));

		milk_bottle = registerItem(new ItemDrink(milkBottleAmount, 0.5F, 64, 32, false, true, "milk_bottle").setAlwaysEdible());
		cold_chocolate_bottle = registerItem(new ItemDrink(coldchocolateAmount, 0.4F, 64, 32, false, false, "cold_chocolate_bottle"));
		hot_chocolate_bottle = registerItem(new ItemDrink(hotchocolateAmount, 0.4F, 64, 32, false, false, "hot_chocolate_bottle"));

		hot_water = registerItem(new ItemCustom("hot_water"));
		
		//juices
		apple_juice = registerItem(new ItemDrink(appleJuiceAmount, 0.3F, 64, 32, false, false, "apple_juice"));
		lemonade = registerItem(new ItemDrink(lemonadeAmount, 0.4F, 64, 32, false, false, "lemonade"));
		orange_juice = registerItem(new ItemDrink(orangeJuiceAmount, 0.3F, 64, 32, false, false, "orange_juice"));
		cherry_juice = registerItem(new ItemDrink(cherryJuiceAmount, 0.3F, 64, 32, false, false, "cherry_juice"));
		pear_juice = registerItem(new ItemDrink(pearJuiceAmount, 0.3F, 64, 32, false, false, "pear_juice"));
		banana_juice = registerItem(new ItemDrink(bananaJuiceAmount, 0.3F, 64, 32, false, false, "banana_juice"));
		grape_juice = registerItem(new ItemDrink(grapeJuiceAmount, 0.3F, 64, 32, false, false, "grape_juice"));
		mango_juice = registerItem(new ItemDrink(mangoJuiceAmount, 0.3F, 64, 32, false, false, "mango_juice"));
		pineapple_juice = registerItem(new ItemDrink(pineappleJuiceAmount, 0.3F, 64, 32, false, false, "pineapple_juice"));

		//Smoothies
		smoothie_apple = registerItem(new ItemDrink(appleSmoothieAmount, 0.5F, 16, 32, false, false, "smoothie_apple"));
		smoothie_lemon = registerItem(new ItemDrink(lemonSmoothieAmount, 0.5F, 16, 32, false, false, "smoothie_lemon"));
		smoothie_orange = registerItem(new ItemDrink(orangeSmoothieAmount, 0.5F, 16, 32, false, false, "smoothie_orange"));
		smoothie_cherry = registerItem(new ItemDrink(cherrySmoothieAmount, 0.4F, 16, 32, false, false, "smoothie_cherry"));
		smoothie_pear = registerItem(new ItemDrink(pearSmoothieAmount, 0.5F, 16, 32, false, false, "smoothie_pear"));
		smoothie_banana = registerItem(new ItemDrink(bananaSmoothieAmount, 0.5F, 16, 32, false, false, "smoothie_banana"));
		smoothie_grape = registerItem(new ItemDrink(grapeSmoothieAmount, 0.4F, 16, 32, false, false, "smoothie_grape"));
		smoothie_mango = registerItem(new ItemDrink(mangoSmoothieAmount, 0.5F, 16, 32, false, false, "smoothie_mango"));
		smoothie_pineapple = registerItem(new ItemDrink(pineappleSmoothieAmount, 0.5F, 16, 32, false, false, "smoothie_pineapple"));
		smoothie_cucumber = registerItem(new ItemDrink(cucumberSmoothieAmount, 0.5F, 16, 32, false, false, "smoothie_cucumber"));

		//Actual food stuff
		stock = registerItem(new ItemCustom("stock"));
		salt = registerItem(new ItemCustom("salt"));
		flour = registerItem(new ItemCustom("flour"));
		dough = registerItem(new ItemCustom("dough"));
		olive_oil = registerItem(new ItemCustom("olive_oil"));
		pasta = registerItem(new ItemCustom("pasta"));
		
		fruit_salad = registerItem(new ItemBowledFood(fruitSaladAmount, 0.7F, 16, 24, false, false, "fruit_salad").setEatAction());
		corn_soup = registerItem(new ItemBowledFood(cornSoupAmount, 0.8F, 16, 32, false, false, "corn_soup"));
		cucumber_soup = registerItem(new ItemBowledFood(cucumberSoupAmount, 0.6F, 16, 32, false, false, "cucumber_soup"));
		tomato_soup = registerItem(new ItemBowledFood(tomatoSoupAmount, 0.7F, 16, 32, false, false, "tomato_soup"));
		potato_soup = registerItem(new ItemBowledFood(potatoSoupAmount, 0.8F, 16, 32, false, false, "potato_soup"));
		carrot_soup = registerItem(new ItemBowledFood(carrotSoupAmount, 0.8F, 16, 32, false, false, "carrot_soup"));
		onion_soup = registerItem(new ItemBowledFood(onionSoupAmount, 0.7F, 16, 32, false, false, "onion_soup"));
		
		hamburger = registerItem(new ItemCustomFood(hamburgerAmount, 0.6F, 64, 32, "hamburger"));
		chickenburger = registerItem(new ItemCustomFood(chickenburgerAmount, 0.6F, 64, 32, "chickenburger"));
		cheeseburger = registerItem(new ItemCustomFood(cheeseburgerAmount, 0.5F, 64, 32, "cheeseburger"));
		boiled_egg = registerItem(new ItemCustomFood(boiledEggAmount, 0.2F, 64, 32, "boiled_egg"));
		baked_egg = registerItem(new ItemCustomFood(omeletAmount, 0.2F, 64, 32, "baked_egg"));
		sliced_bread = registerItem(new ItemCustomFood(slicedBreadAmount, 0.3F, 64, 32, "sliced_bread"));
		cheese = registerItem(new ItemCustomFood(cheeseAmount, 0.2F, 64, 32, "cheese"));
		spaghetti = registerItem(new ItemBowledFood(spaghettiAmount, 0.2F, 16, 24, false, false, "spaghetti").setEatAction());

		//sandwiches
		egg_sandwich = registerItem(new ItemCustomFood(eggSandwichAmount, 0.5F, 64, 32, "egg_sandwich"));
		bacon_sandwich = registerItem(new ItemCustomFood(baconSandwichAmount, 0.5F, 64, 32, "bacon_sandwich"));
		chicken_sandwich = registerItem(new ItemCustomFood(chickenSandwichAmount, 0.6F, 64, 32, "chicken_sandwich"));
		
		pineapple_pizza = registerItem(new ItemCustomFood(pineapplePizzaAmount, 0.4F, 64, 32, "pineapple_pizza"));
		cheese_pizza = registerItem(new ItemCustomFood(cheesePizzaAmount, 0.4F, 64, 32, "cheese_pizza"));
		bacon_pizza = registerItem(new ItemCustomFood(baconPizzaAmount, 0.5F, 64, 32, "bacon_pizza"));

		//pies
		apple_pie = registerItem(new ItemCustomFood(applePieAmount, 0.3F, 64, 32, "apple_pie"));
		banana_pie = registerItem(new ItemCustomFood(bananaPieAmount, 0.3F, 64, 32, "banana_pie"));
		bacon_and_egg_pie = registerItem(new ItemCustomFood(baconAndEggPieAmount, 0.3F, 64, 32, "bacon_and_egg_pie"));
		cherry_pie = registerItem(new ItemCustomFood(cherryPieAmount, 0.3F, 64, 32, "cherry_pie"));
		grape_pie = registerItem(new ItemCustomFood(grapePieAmount, 0.3F, 64, 32, "grape_pie"));
		lemon_pie = registerItem(new ItemCustomFood(lemonPieAmount, 0.3F, 64, 32, "lemon_pie"));
		pear_pie = registerItem(new ItemCustomFood(pearPieAmount, 0.3F, 64, 32, "pear_pie"));
		
		if(FarmingConfigGen.general.othersettings.enableRake)
		{
			wooden_rake = registerItem(new ItemRakeTool(ToolMaterial.WOOD, 1, "wooden_rake"));
			stone_rake = registerItem(new ItemRakeTool(ToolMaterial.STONE, 2, "stone_rake"));
			iron_rake = registerItem(new ItemRakeTool(ToolMaterial.IRON, 3, "iron_rake"));
			gold_rake = registerItem(new ItemRakeTool(ToolMaterial.GOLD, 6, "gold_rake"));
			diamond_rake = registerItem(new ItemRakeTool(ToolMaterial.DIAMOND, 5, "diamond_rake"));
		}

        registry.registerAll(ITEMS.toArray(new Item[0]));
    }
    
    public static <T extends Item> T registerItem(T item)
    {
        ITEMS.add(item);
        return item;
    }
}