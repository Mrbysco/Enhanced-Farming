package com.Mrbysco.EnhancedFarming.init;

import java.util.ArrayList;

import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.item.ItemCustom;
import com.Mrbysco.EnhancedFarming.item.ItemCustomFood;
import com.Mrbysco.EnhancedFarming.item.ItemCustomSeeds;
import com.Mrbysco.EnhancedFarming.item.ItemCustomSpecialFood;
import com.Mrbysco.EnhancedFarming.item.ItemRakeTool;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
	
	public static ItemCustomSeeds mint_seeds;
	public static ItemCustomSeeds nether_flower_seeds;

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
	
	public static ItemFood smoothie_apple;
	public static ItemFood smoothie_lemon;
	public static ItemFood smoothie_orange;
	public static ItemFood smoothie_cherry;
	public static ItemFood smoothie_pear;
	public static ItemFood smoothie_banana;
	
	
	//HealAmounts
	private static int appleJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.appleJuiceHealAmount;
	private static int lemonadeAmount = FarmingConfigGen.general.foodsettings.drinks.lemonadeHealAmount;
	private static int orangeJuiceAmount = FarmingConfigGen.general.foodsettings.drinks.orangeJuiceHealAmount;

	
	private static int chocolateAmount = FarmingConfigGen.general.foodsettings.food.chocolateBarHealAmount;
	private static int chocolateCandyAmount = FarmingConfigGen.general.foodsettings.food.chocolateCandyHealAmount;
	private static int lemonAmount = FarmingConfigGen.general.foodsettings.food.lemonHealAmount;
	private static int chocolateBarAmount = FarmingConfigGen.general.foodsettings.food.mintChocolateBarHealAmount;
	private static int mintteaAmount = FarmingConfigGen.general.foodsettings.food.mintTeaHealAmount;
	private static int orangeAmount = FarmingConfigGen.general.foodsettings.food.orangeHealAmount;
	
	private static int goldenLemon = FarmingConfigGen.general.foodsettings.food.goldenLemonHealAmount;
	private static int goldenOrange = FarmingConfigGen.general.foodsettings.food.goldenOrangeHealAmount;
	
	private static int milkBottleAmount = FarmingConfigGen.general.foodsettings.drinks.milkBottleHealAmount;
	private static int coldchocolateAmount = FarmingConfigGen.general.foodsettings.drinks.coldChocolateBottleHealAmount;
	private static int hotchocolateAmount = FarmingConfigGen.general.foodsettings.drinks.hotChocolateBottleHealAmount;

	//New Content
	private static int cherryAmount = FarmingConfigGen.general.foodsettings.food.cherryHealAmount;
	private static int pearAmount = FarmingConfigGen.general.foodsettings.food.pearHealAmount;
	private static int bananaAmount = FarmingConfigGen.general.foodsettings.food.bananaHealAmount;
	
	private static int chocolateCherryAmount = FarmingConfigGen.general.foodsettings.food.chocolateCherryHealAmount;
	private static int chocolateBananaAmount = FarmingConfigGen.general.foodsettings.food.chocolateBananaHealAmount;
	
	private static int appleSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.appleJuiceHealAmount;
	private static int lemonSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.lemonadeHealAmount;
	private static int orangeSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.orangeJuiceHealAmount;
	private static int cherrySmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.appleJuiceHealAmount;
	private static int pearSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.lemonadeHealAmount;
	private static int bananaSmoothieAmount = FarmingConfigGen.general.foodsettings.drinks.orangeJuiceHealAmount;

	public static ArrayList<Item> ITEMS = new ArrayList<>();
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        mint_seeds = registerItem(new ItemCustomSeeds(FarmingBlocks.mint_crop, Blocks.FARMLAND, "mintseeds", "mint_seeds"));
		nether_flower_seeds = registerItem(new ItemCustomSeeds(FarmingBlocks.nether_flower_crop, Blocks.SOUL_SAND, "netherflowerseeds", "nether_flower_seeds"));
		
		apple_juice = registerItem(new ItemCustomFood(appleJuiceAmount, 0.3F, false, 64, 32, "applejuice", "apple_juice").setDrinkable().setContaining(Items.GLASS_BOTTLE));
		chocolate_bar = registerItem(new ItemCustomFood(chocolateAmount, 0.7F, false, 64, 32, "chocolatebar", "chocolate_bar"));
		chocolate_candy = registerItem(new ItemCustomFood(chocolateCandyAmount, 0.7F, false, 64, 1, "chocolatecandy", "chocolate_candy"));
		lemon = registerItem(new ItemCustomFood(lemonAmount, 0.5F, false, 64, 32, "lemon", "lemon"));
		lemonade = registerItem(new ItemCustomFood(lemonadeAmount, 0.4F, false, 64, 32, "lemonade", "lemonade").setDrinkable().setContaining(Items.GLASS_BOTTLE));
		mint_chocolate_bar = registerItem(new ItemCustomSpecialFood(chocolateBarAmount, 0.7F, false, 16, 32, false, true, false, "mintchocolatebar", "mint_chocolate_bar"));
		mint_tea = registerItem(new ItemCustomSpecialFood(mintteaAmount, 0.3F, false, 16, 32, false, true, false, "minttea", "mint_tea").setDrinkable().setContaining(Items.GLASS_BOTTLE));
		orange = registerItem(new ItemCustomFood(orangeAmount, 0.5F, false, 64, 32, "orange", "orange"));
		orange_juice = registerItem(new ItemCustomFood(orangeJuiceAmount, 0.3F, false, 64, 32, "orangejuice", "orange_juice").setDrinkable().setContaining(Items.GLASS_BOTTLE));

		golden_lemon = registerItem(new ItemCustomSpecialFood(goldenLemon, 0.5F, false, 64, 32, true, false, false, "goldenlemon", "golden_lemon").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 30*20, 0), 1F));
		golden_orange = registerItem(new ItemCustomSpecialFood(goldenOrange, 0.5F, false, 64, 32, true, false, false, "goldenorange", "golden_orange").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 30*20, 0), 1F));
		
		milk_bottle = registerItem(new ItemCustomSpecialFood(milkBottleAmount, 0.5f, false, 64, 32, false, false, true, "milkbottle", "milk_bottle").setDrinkable().setContaining(Items.GLASS_BOTTLE).setAlwaysEdible());
		cold_chocolate_bottle = registerItem(new ItemCustomFood(coldchocolateAmount, 0.4f, false, 64, 32, "coldchocolatebottle", "cold_chocolate_bottle").setDrinkable().setContaining(Items.GLASS_BOTTLE));
		hot_chocolate_bottle = registerItem(new ItemCustomFood(hotchocolateAmount, 0.4f, false, 64, 32, "hotchocolatebottle", "hot_chocolate_bottle").setDrinkable().setContaining(Items.GLASS_BOTTLE));

		mint = registerItem(new ItemCustom("mint", "mint"));
		hot_water = registerItem(new ItemCustom("hotwater", "hot_water"));

		//New Content
		cherry = registerItem(new ItemCustomFood(cherryAmount, 0.5F, false, 64, 32, "cherry", "cherry"));
		pear = registerItem(new ItemCustomFood(pearAmount, 0.5F, false, 64, 32, "pear", "pear"));
		banana = registerItem(new ItemCustomFood(lemonAmount, 0.5F, false, 64, 32, "banana", "banana"));
		
		chocolate_cherry = registerItem(new ItemCustomFood(chocolateCherryAmount, 0.6F, false, 64, 32, "chocolatecherry", "chocolate_cherry"));
		chocolate_banana = registerItem(new ItemCustomFood(chocolateBananaAmount, 0.8F, false, 64, 32, "chocolatebanana", "chocolate_banana"));
		
		smoothie_apple = registerItem(new ItemCustomFood(appleSmoothieAmount, 0.6F, false, 16, 32, "smoothieapple", "smoothie_apple").setDrinkable().setContaining(Items.GLASS_BOTTLE).setAlwaysEdible());
		smoothie_lemon = registerItem(new ItemCustomFood(lemonSmoothieAmount, 0.6F, false, 16, 32, "smoothielemon", "smoothie_lemon").setDrinkable().setContaining(Items.GLASS_BOTTLE).setAlwaysEdible());
		smoothie_orange = registerItem(new ItemCustomFood(orangeSmoothieAmount, 0.6F, false, 16, 32, "smoothieorange", "smoothie_orange").setDrinkable().setContaining(Items.GLASS_BOTTLE).setAlwaysEdible());
		
		smoothie_cherry = registerItem(new ItemCustomFood(cherrySmoothieAmount, 0.6F, false, 16, 32, "smoothiecherry", "smoothie_cherry").setDrinkable().setContaining(Items.GLASS_BOTTLE).setAlwaysEdible());
		smoothie_pear = registerItem(new ItemCustomFood(pearSmoothieAmount, 0.6F, false, 16, 32, "smoothiepear", "smoothie_pear").setDrinkable().setContaining(Items.GLASS_BOTTLE).setAlwaysEdible());
		smoothie_banana = registerItem(new ItemCustomFood(bananaSmoothieAmount, 0.6F, false, 16, 32, "smoothiebanana", "smoothie_banana").setDrinkable().setContaining(Items.GLASS_BOTTLE).setAlwaysEdible());
		//End new content
				
		if(FarmingConfigGen.general.othersettings.enableRake)
		{
			wooden_rake = registerItem(new ItemRakeTool(ToolMaterial.WOOD, 1, "woodenrake", "wooden_rake"));
			stone_rake = registerItem(new ItemRakeTool(ToolMaterial.STONE, 2, "stonerake", "stone_rake"));
			iron_rake = registerItem(new ItemRakeTool(ToolMaterial.IRON, 3, "ironrake", "iron_rake"));
			gold_rake = registerItem(new ItemRakeTool(ToolMaterial.GOLD, 6, "goldrake", "gold_rake"));
			diamond_rake = registerItem(new ItemRakeTool(ToolMaterial.DIAMOND, 5, "diamondrake", "diamond_rake"));
		}

        registry.registerAll(ITEMS.toArray(new Item[0]));
    }
    
    public static <T extends Item> T registerItem(T item)
    {
        ITEMS.add(item);
        return item;
    }
}