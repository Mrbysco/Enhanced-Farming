package com.Mrbysco.EnhancedFarming.init;

import java.util.ArrayList;

import com.Mrbysco.EnhancedFarming.config.FarmingConfigGen;
import com.Mrbysco.EnhancedFarming.item.ItemCustom;
import com.Mrbysco.EnhancedFarming.item.ItemCustomFood;
import com.Mrbysco.EnhancedFarming.item.ItemCustomSeeds;
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
	
	public static ItemCustomSeeds apple_seeds;
	public static ItemCustomSeeds lemon_seeds;
	public static ItemCustomSeeds mint_seeds;
	public static ItemCustomSeeds nether_flower_seeds;
	public static ItemCustomSeeds orange_seeds;

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
	
	//HealAmounts
	private static int applejuiceamount = FarmingConfigGen.general.foodsettings.food.appleJuiceHealAmount;
	private static int chocolateamount = FarmingConfigGen.general.foodsettings.food.chocolateBarHealAmount;
	private static int chocolatecandyamount = FarmingConfigGen.general.foodsettings.food.chocolateCandyHealAmount;
	private static int lemonamount = FarmingConfigGen.general.foodsettings.food.lemonHealAmount;
	private static int lemonadeamount = FarmingConfigGen.general.foodsettings.food.lemonadeHealAmount;
	private static int chocolatebaramount = FarmingConfigGen.general.foodsettings.food.mintChocolateBarHealAmount;
	private static int mintteaamount = FarmingConfigGen.general.foodsettings.food.mintTeaHealAmount;
	private static int orangeamount = FarmingConfigGen.general.foodsettings.food.orangeHealAmount;
	private static int orangejuiceamount = FarmingConfigGen.general.foodsettings.food.orangeJuiceHealAmount;
	
	private static int goldenlemon = FarmingConfigGen.general.foodsettings.food.goldenLemonHealAmount;
	private static int goldenorange = FarmingConfigGen.general.foodsettings.food.goldenOrangeHealAmount;
	
	private static int milkbottleamount = FarmingConfigGen.general.foodsettings.drinks.milkBottleHealAmount;
	private static int coldchocolateamount = FarmingConfigGen.general.foodsettings.drinks.coldChocolateBottleHealAmount;
	private static int hotchocolateamount = FarmingConfigGen.general.foodsettings.drinks.hotChocolateBottleHealAmount;

	public static ArrayList<Item> ITEMS = new ArrayList<>();
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        mint_seeds = registerItem(new ItemCustomSeeds(FarmingBlocks.mint_crop, Blocks.FARMLAND, "mintseeds", "mint_seeds"));
		nether_flower_seeds = registerItem(new ItemCustomSeeds(FarmingBlocks.nether_flower_crop, Blocks.SOUL_SAND, "netherflowerseeds", "nether_flower_seeds"));
		
		apple_juice = registerItem(new ItemCustomFood(applejuiceamount, 0.3F, false, 64, 32, false, "applejuice", "apple_juice").setDrinkable().setContaining(Items.GLASS_BOTTLE));
		chocolate_bar = registerItem(new ItemCustomFood(chocolateamount, 0.7F, false, 64, 32, false, "chocolatebar", "chocolate_bar"));
		chocolate_candy = registerItem(new ItemCustomFood(chocolatecandyamount, 0.7F, false, 64, 4, false, "chocolatecandy", "chocolate_candy"));
		lemon = registerItem(new ItemCustomFood(lemonamount, 0.5F, false, 64, 32, false, "lemon", "lemon"));
		lemonade = registerItem(new ItemCustomFood(lemonadeamount, 0.4F, false, 64, 32, false, "lemonade", "lemonade").setDrinkable().setContaining(Items.GLASS_BOTTLE));
		mint_chocolate_bar = registerItem(new ItemCustomFood(chocolatebaramount, 0.7F, false, 64, 32, false, "mintchocolatebar", "mint_chocolate_bar"));
		mint_tea = registerItem(new ItemCustomFood(mintteaamount, 0.3F, false, 64, 32, false, "minttea", "mint_tea").setDrinkable().setContaining(Items.GLASS_BOTTLE));
		orange = registerItem(new ItemCustomFood(orangeamount, 0.5F, false, 64, 32, false, "orange", "orange"));
		orange_juice = registerItem(new ItemCustomFood(orangejuiceamount, 0.3F, false, 64, 32, false, "orangejuice", "orange_juice").setDrinkable().setContaining(Items.GLASS_BOTTLE));

		golden_lemon = registerItem(new ItemCustomFood(goldenlemon, 0.5F, false, 64, 32, true, "goldenlemon", "golden_lemon").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 30*20, 0), 1F));
		golden_orange = registerItem(new ItemCustomFood(goldenorange, 0.5F, false, 64, 32, true, "goldenorange", "golden_orange").setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.STRENGTH, 30*20, 0), 1F));
		
		milk_bottle = registerItem(new ItemCustomFood(milkbottleamount, 0.5f, false, 64, 32, false, "milkbottle", "milk_bottle").setDrinkable().setContaining(Items.GLASS_BOTTLE).setAlwaysEdible());
		cold_chocolate_bottle = registerItem(new ItemCustomFood(coldchocolateamount, 0.4f, false, 64, 32, false, "coldchocolatebottle", "cold_chocolate_bottle"));
		hot_chocolate_bottle = registerItem(new ItemCustomFood(hotchocolateamount, 0.4f, false, 64, 32, false, "hotchocolatebottle", "hot_chocolate_bottle").setDrinkable().setContaining(Items.GLASS_BOTTLE));

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
        
        registry.registerAll(ITEMS.toArray(new Item[0]));
    }
    
    public static <T extends Item> T registerItem(T item)
    {
        ITEMS.add(item);
        return item;
    }
}