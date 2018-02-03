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
		
	public static ItemRegularSeeds tomato_seeds;
	public static ItemRegularSeeds cucumber_seeds;
	public static ItemRegularSeeds aubergine_seeds;
	public static ItemRegularSeeds pineapple_seeds;
	public static ItemRegularSeeds corn_seeds;
	public static ItemRegularSeeds onion_seeds;
	public static ItemRegularSeeds garlic_seeds;
	public static ItemCropstickSeeds grape_seeds;
	
	public static Item stock;
	public static Item salt;
	public static Item flour;
	public static Item dough;
	public static Item olive_oil;
	//Actual food
	
	public static ItemFood corn_soup;
	public static ItemFood cucumber_soup;
	public static ItemFood tomato_soup;
	public static ItemFood potato_soup;
	public static ItemFood carrot_soup;
	public static ItemFood onion_soup;
	
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
	
	public static int cornSoup = FarmingConfigGen.general.foodsettings.soups.cornSoupHealAmount;
	public static int cucumberSoup = FarmingConfigGen.general.foodsettings.soups.cucumberSoupHealAmount;
	public static int tomatoSoup = FarmingConfigGen.general.foodsettings.soups.tomatoSoupHealAmount;
	public static int potatoSoup = FarmingConfigGen.general.foodsettings.soups.potatoSoupHealAmount;
	public static int carrotSoup = FarmingConfigGen.general.foodsettings.soups.carrotSoupHealAmount;
	public static int onionSoup = FarmingConfigGen.general.foodsettings.soups.onionSoupHealAmount;
	
	public static ArrayList<Item> ITEMS = new ArrayList<>();
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        mint_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.mint_crop, Blocks.FARMLAND, "mintseeds", "mint_seeds"));
		nether_flower_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.nether_flower_crop, Blocks.SOUL_SAND, "netherflowerseeds", "nether_flower_seeds"));
		
		apple_juice = registerItem(new ItemDrink(appleJuiceAmount, 0.3F, 64, 32, false, false, "applejuice", "apple_juice"));
		chocolate_bar = registerItem(new ItemCustomFood(chocolateAmount, 0.7F, 64, 32, "chocolatebar", "chocolate_bar"));
		chocolate_candy = registerItem(new ItemCustomFood(chocolateCandyAmount, 0.7F, 64, 1, "chocolatecandy", "chocolate_candy"));
		lemon = registerItem(new ItemCustomFood(lemonAmount, 0.5F, 64, 32, "lemon", "lemon"));
		lemonade = registerItem(new ItemDrink(lemonadeAmount, 0.4F, 64, 32, false, false, "lemonade", "lemonade"));
		mint_chocolate_bar = registerItem(new ItemDrink(chocolateBarAmount, 0.7F, 16, 32, true, false, "mintchocolatebar", "mint_chocolate_bar"));
		mint_tea = registerItem(new ItemDrink(mintteaAmount, 0.3F, 16, 32, true, false, "minttea", "mint_tea"));
		orange = registerItem(new ItemCustomFood(orangeAmount, 0.5F, 64, 32, "orange", "orange"));
		orange_juice = registerItem(new ItemDrink(orangeJuiceAmount, 0.3F, 64, 32, false, false, "orangejuice", "orange_juice"));

		golden_lemon = registerItem(new ItemCustomSpecialFood(goldenLemon, 0.5F, 64, 32, true, false, false, "goldenlemon", "golden_lemon").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 30*20, 0), 1F));
		golden_orange = registerItem(new ItemCustomSpecialFood(goldenOrange, 0.5F, 64, 32, true, false, false, "goldenorange", "golden_orange").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 30*20, 0), 1F));
		
		milk_bottle = registerItem(new ItemDrink(milkBottleAmount, 0.5F, 64, 32, false, true, "milkbottle", "milk_bottle").setAlwaysEdible());
		cold_chocolate_bottle = registerItem(new ItemDrink(coldchocolateAmount, 0.4F, 64, 32, false, false, "coldchocolatebottle", "cold_chocolate_bottle"));
		hot_chocolate_bottle = registerItem(new ItemDrink(hotchocolateAmount, 0.4F, 64, 32, false, false, "hotchocolatebottle", "hot_chocolate_bottle"));

		mint = registerItem(new ItemCustom("mint", "mint"));
		hot_water = registerItem(new ItemCustom("hotwater", "hot_water"));
				
		if(FarmingConfigGen.general.othersettings.enableRake)
		{
			wooden_rake = registerItem(new ItemRakeTool(ToolMaterial.WOOD, 1, "woodenrake", "wooden_rake"));
			stone_rake = registerItem(new ItemRakeTool(ToolMaterial.STONE, 2, "stonerake", "stone_rake"));
			iron_rake = registerItem(new ItemRakeTool(ToolMaterial.IRON, 3, "ironrake", "iron_rake"));
			gold_rake = registerItem(new ItemRakeTool(ToolMaterial.GOLD, 6, "goldrake", "gold_rake"));
			diamond_rake = registerItem(new ItemRakeTool(ToolMaterial.DIAMOND, 5, "diamondrake", "diamond_rake"));
		}

		//New Content
		pot = registerItem(new ItemCustomUtensil("pot", "pot"));
		cutting_board = registerItem(new ItemCustomUtensil("cuttingboard", "cutting_board"));
		mortal_and_pestle = registerItem(new ItemCustomUtensil("mortalandpestle", "mortal_and_pestle"));
		
		cherry = registerItem(new ItemCustomFood(cherryAmount, 0.3F, 64, 32, "cherry", "cherry"));
		pear = registerItem(new ItemCustomFood(pearAmount, 0.5F, 64, 32, "pear", "pear"));
		banana = registerItem(new ItemCustomFood(lemonAmount, 0.5F, 64, 32, "banana", "banana"));
		olive = registerItem(new ItemCustomFood(oliveAmount, 0.5F, 64, 32, "olive", "olive"));
		
		chocolate_cherry = registerItem(new ItemCustomFood(chocolateCherryAmount, 0.5F, 64, 32, "chocolatecherry", "chocolate_cherry"));
		chocolate_banana = registerItem(new ItemCustomFood(chocolateBananaAmount, 0.7F, 64, 32, "chocolatebanana", "chocolate_banana"));
		
		cherry_juice = registerItem(new ItemDrink(cherryJuiceAmount, 0.3F, 64, 32, false, false, "cherryjuice", "cherry_juice"));
		pear_juice = registerItem(new ItemDrink(pearJuiceAmount, 0.3F, 64, 32, false, false, "pearjuice", "pear_juice"));
		banana_juice = registerItem(new ItemDrink(bananaJuiceAmount, 0.3F, 64, 32, false, false, "bananajuice", "banana_juice"));
		grape_juice = registerItem(new ItemDrink(grapeJuiceAmount, 0.3F, 64, 32, false, false, "grapejuice", "grape_juice"));
		mango_juice = registerItem(new ItemDrink(mangoJuiceAmount, 0.3F, 64, 32, false, false, "mangojuice", "mango_juice"));
		pineapple_juice = registerItem(new ItemDrink(pineappleJuiceAmount, 0.3F, 64, 32, false, false, "pineapplejuice", "pineapple_juice"));

		smoothie_apple = registerItem(new ItemDrink(appleSmoothieAmount, 0.5F, 16, 32, false, false, "smoothieapple", "smoothie_apple"));
		smoothie_lemon = registerItem(new ItemDrink(lemonSmoothieAmount, 0.5F, 16, 32, false, false, "smoothielemon", "smoothie_lemon"));
		smoothie_orange = registerItem(new ItemDrink(orangeSmoothieAmount, 0.5F, 16, 32, false, false, "smoothieorange", "smoothie_orange"));
		smoothie_cherry = registerItem(new ItemDrink(cherrySmoothieAmount, 0.4F, 16, 32, false, false, "smoothiecherry", "smoothie_cherry"));
		smoothie_pear = registerItem(new ItemDrink(pearSmoothieAmount, 0.5F, 16, 32, false, false, "smoothiepear", "smoothie_pear"));
		smoothie_banana = registerItem(new ItemDrink(bananaSmoothieAmount, 0.5F, 16, 32, false, false, "smoothiebanana", "smoothie_banana"));
		
		smoothie_grape = registerItem(new ItemDrink(grapeSmoothieAmount, 0.4F, 16, 32, false, false, "smoothiegrape", "smoothie_grape"));
		smoothie_mango = registerItem(new ItemDrink(mangoSmoothieAmount, 0.5F, 16, 32, false, false, "smoothiemango", "smoothie_mango"));
		smoothie_pineapple = registerItem(new ItemDrink(pineappleSmoothieAmount, 0.5F, 16, 32, false, false, "smoothiepineapple", "smoothie_pineapple"));
		smoothie_cucumber = registerItem(new ItemDrink(cucumberSmoothieAmount, 0.5F, 16, 32, false, false, "smoothiecucumber", "smoothie_cucumber"));

		avocado = registerItem(new ItemCustomFood(avocadoAmount, 0.5F, 64, 32, "avocado", "avocado"));
		mango = registerItem(new ItemCustomFood(mangoAmount, 0.5F, 64, 32, "mango", "mango"));
		
		tomato = registerItem(new ItemCustomFood(tomatoAmount, 0.5F, 64, 32, "tomato", "tomato"));
		tomato_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.tomato_crop, Blocks.FARMLAND, "tomatoseeds", "tomato_seeds"));

		cucumber = registerItem(new ItemCustomFood(cucumberAmount, 0.5F, 64, 32, "cucumber", "cucumber"));
		cucumber_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.cucumber_crop, Blocks.FARMLAND, "cucumberseeds", "cucumber_seeds"));

		aubergine = registerItem(new ItemCustomFood(aubergineAmount, 0.5F, 64, 32, "aubergine", "aubergine"));
		aubergine_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.aubergine_crop, Blocks.FARMLAND, "aubergineseeds", "aubergine_seeds"));

		grapes = registerItem(new ItemCustomFood(grapesAmount, 0.5F, 64, 32, "grapes", "grapes"));
		grape_seeds = registerItem(new ItemCropstickSeeds(FarmingBlocks.grape_crop, "grapeseeds", "grape_seeds"));

		pineapple = registerItem(new ItemCustomFood(pineappleAmount, 0.5F, 64, 32, "pineapple", "pineapple"));
		pineapple_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.pineapple_crop, Blocks.FARMLAND, "pineappleseeds", "pineapple_seeds"));
		
		corn = registerItem(new ItemCustomFood(cornAmount, 0.5F, 64, 32, "corn", "corn"));
		corn_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.corn_crop, Blocks.FARMLAND, "cornseeds", "corn_seeds"));
		
		onion = registerItem(new ItemCustomFood(onionAmount, 0.5F, 64, 32, "onion", "onion"));
		onion_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.onion_crop, Blocks.FARMLAND, "onionseeds", "onion_seeds"));
		
		garlic = registerItem(new ItemCustomFood(garlicAmount, 0.5F, 64, 32, "garlic", "garlic"));
		garlic_seeds = registerItem(new ItemRegularSeeds(FarmingBlocks.garlic_crop, Blocks.FARMLAND, "garlicseeds", "garlic_seeds"));

		//Actual food stuff
		stock = registerItem(new ItemCustom("stock", "stock"));
		salt = registerItem(new ItemCustom("salt", "salt"));
		flour = registerItem(new ItemCustom("flour", "flour"));
		dough = registerItem(new ItemCustom("dough", "dough"));
		olive_oil = registerItem(new ItemCustom("oliveoil", "olive_oil"));
		
		corn_soup = registerItem(new ItemBowledFood(cornSoup, 0.8F, 16, 32, false, false, "cornsoup", "corn_soup"));
		cucumber_soup = registerItem(new ItemBowledFood(cucumberSoup, 0.6F, 16, 32, false, false, "cucumbersoup", "cucumber_soup"));
		tomato_soup = registerItem(new ItemBowledFood(tomatoSoup, 0.7F, 16, 32, false, false, "tomatosoup", "tomato_soup"));
		potato_soup = registerItem(new ItemBowledFood(potatoSoup, 0.8F, 16, 32, false, false, "potatosoup", "potato_soup"));
		carrot_soup = registerItem(new ItemBowledFood(carrotSoup, 0.8F, 16, 32, false, false, "carrotsoup", "carrot_soup"));
		onion_soup = registerItem(new ItemBowledFood(onionSoup, 0.7F, 16, 32, false, false, "onionsoup", "onion_soup"));
		//End new content

        registry.registerAll(ITEMS.toArray(new Item[0]));
    }
    
    public static <T extends Item> T registerItem(T item)
    {
        ITEMS.add(item);
        return item;
    }
}