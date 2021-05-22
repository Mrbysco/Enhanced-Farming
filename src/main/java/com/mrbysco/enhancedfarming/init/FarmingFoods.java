package com.mrbysco.enhancedfarming.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FarmingFoods {
	public static final Food AUBERGINE = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food AVOCADO = (new Food.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final Food BANANA = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food CHERRY = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final Food CUCUMBER = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food GRAPES = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final Food LEMON = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food MANGO = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food OLIVE = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food ORANGE = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food PEAR = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food PINEAPPLE = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food TOMATO = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();

	public static final Food CORN = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food GARLIC = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food LETTUCE = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final Food ONION = (new Food.Builder()).nutrition(2).saturationMod(0.3F).build();

	public static final Food GOLD_LEMON = (new Food.Builder()).nutrition(2).saturationMod(0.3F).effect(() -> new EffectInstance(Effects.WATER_BREATHING, 30*20, 0), 1.0F).alwaysEat().build();
	public static final Food GOLD_ORANGE = (new Food.Builder()).nutrition(2).saturationMod(0.3F).effect(() -> new EffectInstance(Effects.DAMAGE_BOOST, 30*20, 0), 1.0F).alwaysEat().build();

	//Chocolate
	public static final Food CHOCOLATE_BAR = (new Food.Builder()).nutrition(4).saturationMod(0.7F).build();
	public static final Food CHOCOLATE_BANANA = (new Food.Builder()).nutrition(4).saturationMod(0.7F).build();
	public static final Food CHOCOLATE_CANDY = (new Food.Builder()).nutrition(2).saturationMod(0.7F).build();
	public static final Food CHOCOLATE_CHERRY = (new Food.Builder()).nutrition(3).saturationMod(0.5F).build();

	public static final Food CHOCOLATE_BAR_MINT = (new Food.Builder()).nutrition(5).saturationMod(0.6F).build();
	public static final Food MINT_TEA = (new Food.Builder()).nutrition(8).saturationMod(0.3F).build();

	//Dairy
	public static final Food MILK_BOTTLE = (new Food.Builder()).nutrition(0).saturationMod(0.0F).alwaysEat().build();
	public static final Food COLD_CHOCOLATE_BOTTLE = (new Food.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final Food HOT_CHOCOLATE_BOTTLE = (new Food.Builder()).nutrition(6).saturationMod(0.4F).build();

	//Juices
	public static final Food APPLE_JUICE = (new Food.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final Food BANANA_JUICE = (new Food.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final Food CHERRY_JUICE = (new Food.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final Food GRAPE_JUICE = (new Food.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final Food LEMONADE = (new Food.Builder()).nutrition(6).saturationMod(0.4F).build();
	public static final Food MANGO_JUICE = (new Food.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final Food ORANGE_JUICE = (new Food.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final Food PEAR_JUICE = (new Food.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final Food PINEAPPLE_JUICE = (new Food.Builder()).nutrition(4).saturationMod(0.3F).build();

	//Smoothies
	public static final Food APPLE_SMOOTHIE = (new Food.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final Food BANANA_SMOOTHIE = (new Food.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final Food CHERRY_SMOOTHIE = (new Food.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final Food CUCUMBER_SMOOTHIE = (new Food.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final Food GRAPE_SMOOTHIE = (new Food.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final Food LEMON_SMOOTHIE = (new Food.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final Food MANGO_SMOOTHIE = (new Food.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final Food ORANGE_SMOOTHIE = (new Food.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final Food PEAR_SMOOTHIE = (new Food.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final Food PINEAPPLE_SMOOTHIE = (new Food.Builder()).nutrition(5).saturationMod(0.5F).build();

	//Salads
	public static final Food FRUIT_SALAD = (new Food.Builder()).nutrition(5).saturationMod(0.4F).build();
	public static final Food SALAD = (new Food.Builder()).nutrition(6).saturationMod(0.2F).build();
	//Soups
	public static final Food CARROT_SOUP = (new Food.Builder()).nutrition(6).saturationMod(0.8F).build();
	public static final Food CHICKEN_NOODLE_SOUP = (new Food.Builder()).nutrition(11).saturationMod(0.5F).build();
	public static final Food CORN_SOUP = (new Food.Builder()).nutrition(5).saturationMod(0.8F).build();
	public static final Food CUCUMBER_SOUP = (new Food.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final Food ONION_SOUP = (new Food.Builder()).nutrition(7).saturationMod(0.7F).build();
	public static final Food POTATO_SOUP = (new Food.Builder()).nutrition(6).saturationMod(0.8F).build();
	public static final Food TOMATO_SOUP = (new Food.Builder()).nutrition(7).saturationMod(0.7F).build();

	public static final Food BOILED_EGG = (new Food.Builder()).nutrition(3).saturationMod(0.2F).build();
	public static final Food CHEESE = (new Food.Builder()).nutrition(4).saturationMod(0.2F).build();
	public static final Food CHEESE_BURGER = (new Food.Builder()).nutrition(9).saturationMod(0.5F).build();
	public static final Food CHICKEN_BURGER = (new Food.Builder()).nutrition(12).saturationMod(0.6F).build();
	public static final Food FISH_AND_CHIPS = (new Food.Builder()).nutrition(14).saturationMod(0.6F).build();
	public static final Food FRIES = (new Food.Builder()).nutrition(8).saturationMod(0.4F).build();
	public static final Food GUACAMOLE = (new Food.Builder()).nutrition(3).saturationMod(0.1F).build();
	public static final Food GUAC_AND_CHIPS = (new Food.Builder()).nutrition(9).saturationMod(0.4F).build();
	public static final Food HAMBURGER = (new Food.Builder()).nutrition(14).saturationMod(0.6F).build();
	public static final Food JAM = (new Food.Builder()).nutrition(6).saturationMod(0.1F).build();
	public static final Food OMELET = (new Food.Builder()).nutrition(3).saturationMod(0.2F).build();
	public static final Food POTATO_CHIPS = (new Food.Builder()).nutrition(6).saturationMod(0.2F).build();
	public static final Food SLICED_BREAD = (new Food.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final Food SPAGHETTI = (new Food.Builder()).nutrition(9).saturationMod(0.2F).build();

	//Sandwiches
	public static final Food BACON_SANDWICH = (new Food.Builder()).nutrition(12).saturationMod(0.5F).build();
	public static final Food CHICKEN_SANDWICH = (new Food.Builder()).nutrition(11).saturationMod(0.6F).build();
	public static final Food EGG_SANDWICH = (new Food.Builder()).nutrition(8).saturationMod(0.5F).build();
	public static final Food JC_SANDWICH = (new Food.Builder()).nutrition(8).saturationMod(0.4F).build();

	//Pizzas
	public static final Food BACON_PIZZA = (new Food.Builder()).nutrition(11).saturationMod(0.5F).build();
	public static final Food CHEESE_PIZZA = (new Food.Builder()).nutrition(9).saturationMod(0.4F).build();
	public static final Food PINEAPPLE_PIZZA = (new Food.Builder()).nutrition(7).saturationMod(0.4F).build();

	//Pies
	public static final Food APPLE_PIE = (new Food.Builder()).nutrition(8).saturationMod(0.3F).build();
	public static final Food BACON_AND_EGG_PIE = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final Food BANANA_PIE = (new Food.Builder()).nutrition(8).saturationMod(0.3F).build();
	public static final Food CHERRY_PIE = (new Food.Builder()).nutrition(6).saturationMod(0.3F).build();
	public static final Food GRAPE_PIE = (new Food.Builder()).nutrition(6).saturationMod(0.3F).build();
	public static final Food LEMON_PIE = (new Food.Builder()).nutrition(8).saturationMod(0.3F).build();
	public static final Food PEAR_PIE = (new Food.Builder()).nutrition(8).saturationMod(0.3F).build();
}