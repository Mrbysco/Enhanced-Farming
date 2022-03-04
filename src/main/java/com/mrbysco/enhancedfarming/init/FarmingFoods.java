package com.mrbysco.enhancedfarming.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FarmingFoods {
	public static final FoodProperties AUBERGINE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties AVOCADO = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final FoodProperties BANANA = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties CHERRY = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final FoodProperties CUCUMBER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties GRAPES = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final FoodProperties LEMON = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties MANGO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties OLIVE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties ORANGE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties PEAR = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties PINEAPPLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties TOMATO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();

	public static final FoodProperties CORN = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties GARLIC = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties LETTUCE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();
	public static final FoodProperties ONION = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).build();

	public static final FoodProperties GOLD_LEMON = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 30 * 20, 0), 1.0F).alwaysEat().build();
	public static final FoodProperties GOLD_ORANGE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 30 * 20, 0), 1.0F).alwaysEat().build();

	//Chocolate
	public static final FoodProperties CHOCOLATE_BAR = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.7F).build();
	public static final FoodProperties CHOCOLATE_BANANA = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.7F).build();
	public static final FoodProperties CHOCOLATE_CANDY = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.7F).build();
	public static final FoodProperties CHOCOLATE_CHERRY = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).build();

	public static final FoodProperties CHOCOLATE_BAR_MINT = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
	public static final FoodProperties MINT_TEA = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.3F).build();

	//Dairy
	public static final FoodProperties MILK_BOTTLE = (new FoodProperties.Builder()).nutrition(0).saturationMod(0.0F).alwaysEat().build();
	public static final FoodProperties COLD_CHOCOLATE_BOTTLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties HOT_CHOCOLATE_BOTTLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).build();

	//Juices
	public static final FoodProperties APPLE_JUICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final FoodProperties BANANA_JUICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final FoodProperties CHERRY_JUICE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final FoodProperties GRAPE_JUICE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final FoodProperties LEMONADE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.4F).build();
	public static final FoodProperties MANGO_JUICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final FoodProperties ORANGE_JUICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final FoodProperties PEAR_JUICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
	public static final FoodProperties PINEAPPLE_JUICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();

	//Smoothies
	public static final FoodProperties APPLE_SMOOTHIE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final FoodProperties BANANA_SMOOTHIE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final FoodProperties CHERRY_SMOOTHIE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties CUCUMBER_SMOOTHIE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final FoodProperties GRAPE_SMOOTHIE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
	public static final FoodProperties LEMON_SMOOTHIE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final FoodProperties MANGO_SMOOTHIE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final FoodProperties ORANGE_SMOOTHIE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final FoodProperties PEAR_SMOOTHIE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
	public static final FoodProperties PINEAPPLE_SMOOTHIE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();

	//Salads
	public static final FoodProperties FRUIT_SALAD = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F).build();
	public static final FoodProperties SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).build();
	//Soups
	public static final FoodProperties CARROT_SOUP = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).build();
	public static final FoodProperties CHICKEN_NOODLE_SOUP = (new FoodProperties.Builder()).nutrition(11).saturationMod(0.5F).build();
	public static final FoodProperties CORN_SOUP = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.8F).build();
	public static final FoodProperties CUCUMBER_SOUP = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
	public static final FoodProperties ONION_SOUP = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.7F).build();
	public static final FoodProperties POTATO_SOUP = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).build();
	public static final FoodProperties TOMATO_SOUP = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.7F).build();

	public static final FoodProperties BOILED_EGG = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();
	public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).build();
	public static final FoodProperties CHEESE_BURGER = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.5F).build();
	public static final FoodProperties CHICKEN_BURGER = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.6F).build();
	public static final FoodProperties FISH_AND_CHIPS = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.6F).build();
	public static final FoodProperties FRIES = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F).build();
	public static final FoodProperties GUACAMOLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).build();
	public static final FoodProperties GUAC_AND_CHIPS = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.4F).build();
	public static final FoodProperties HAMBURGER = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.6F).build();
	public static final FoodProperties JAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.1F).build();
	public static final FoodProperties OMELET = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();
	public static final FoodProperties POTATO_CHIPS = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.2F).build();
	public static final FoodProperties SLICED_BREAD = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
	public static final FoodProperties SPAGHETTI = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.2F).build();

	//Sandwiches
	public static final FoodProperties BACON_SANDWICH = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.5F).build();
	public static final FoodProperties CHICKEN_SANDWICH = (new FoodProperties.Builder()).nutrition(11).saturationMod(0.6F).build();
	public static final FoodProperties EGG_SANDWICH = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.5F).build();
	public static final FoodProperties JC_SANDWICH = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F).build();

	//Pizzas
	public static final FoodProperties BACON_PIZZA = (new FoodProperties.Builder()).nutrition(11).saturationMod(0.5F).build();
	public static final FoodProperties CHEESE_PIZZA = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.4F).build();
	public static final FoodProperties PINEAPPLE_PIZZA = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.4F).build();

	//Pies
	public static final FoodProperties APPLE_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.3F).build();
	public static final FoodProperties BACON_AND_EGG_PIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).build();
	public static final FoodProperties BANANA_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.3F).build();
	public static final FoodProperties CHERRY_PIE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build();
	public static final FoodProperties GRAPE_PIE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F).build();
	public static final FoodProperties LEMON_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.3F).build();
	public static final FoodProperties PEAR_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.3F).build();
}