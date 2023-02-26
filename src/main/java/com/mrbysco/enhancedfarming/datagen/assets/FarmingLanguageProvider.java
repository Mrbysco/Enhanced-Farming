package com.mrbysco.enhancedfarming.datagen.assets;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class FarmingLanguageProvider extends LanguageProvider {
	public FarmingLanguageProvider(DataGenerator gen) {
		super(gen, Reference.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		add("enhancedfarming.config.title", "Enhanced Farming Config");
		add("itemGroup.enhancedfarming", "Enhanced Farming");

		addBlocks();
		addItems();

		add("enhancedfarming.gui.jei.category.piston", "Piston crafting");
	}

	private void addBlocks() {
		addBlock(FarmingRegistry.MINT_CROP, "Mint Crop");
		addBlock(FarmingRegistry.NETHER_FLOWER_CROP, "Nether Flower Crop");
		addBlock(FarmingRegistry.TOMATO_CROP, "Tomato Crop");
		addBlock(FarmingRegistry.CUCUMBER_CROP, "Cucumber Crop");
		addBlock(FarmingRegistry.AUBERGINE_CROP, "Aubergine Crop");
		addBlock(FarmingRegistry.GRAPE_CROP, "Grape Crop");
		addBlock(FarmingRegistry.PINEAPPLE_CROP, "Pineapple Crop");
		addBlock(FarmingRegistry.CORN_CROP, "Corn Crop");
		addBlock(FarmingRegistry.ONION_CROP, "Onion Crop");
		addBlock(FarmingRegistry.GARLIC_CROP, "Garlic Crop");
		addBlock(FarmingRegistry.LETTUCE_CROP, "Lettuce Crop");

		addBlock(FarmingRegistry.APPLE_LEAVES, "Apple Leaves");
		addBlock(FarmingRegistry.LEMON_LEAVES, "Lemon Leaves");
		addBlock(FarmingRegistry.ORANGE_LEAVES, "Orange Leaves");
		addBlock(FarmingRegistry.CHERRY_LEAVES, "Cherry Leaves");
		addBlock(FarmingRegistry.PEAR_LEAVES, "Pear Leaves");
		addBlock(FarmingRegistry.BANANA_LEAVES, "Banana Leaves");
		addBlock(FarmingRegistry.AVOCADO_LEAVES, "Avocado Leaves");
		addBlock(FarmingRegistry.MANGO_LEAVES, "Mango Leaves");
		addBlock(FarmingRegistry.OLIVE_LEAVES, "Olive Leaves");

		addBlock(FarmingRegistry.APPLE_SAPLING, "Apple Seeds");
		addBlock(FarmingRegistry.LEMON_SAPLING, "Lemon Seeds");
		addBlock(FarmingRegistry.ORANGE_SAPLING, "Orange Seeds");
		addBlock(FarmingRegistry.CHERRY_SAPLING, "Cherry Seeds");
		addBlock(FarmingRegistry.PEAR_SAPLING, "Pear Seeds");
		addBlock(FarmingRegistry.BANANA_SAPLING, "Banana Seeds");
		addBlock(FarmingRegistry.AVOCADO_SAPLING, "Avocado Seed");
		addBlock(FarmingRegistry.MANGO_SAPLING, "Mango Seed");
		addBlock(FarmingRegistry.OLIVE_SAPLING, "Olive Seeds");

		addBlock(FarmingRegistry.CROP_STICK, "Crop Sticks");
		addBlock(FarmingRegistry.SCARECROW, "Scarecrow");
	}

	private void addItems() {
		addItem(FarmingRegistry.MINT_SEEDS, "Mint Seeds");
		addItem(FarmingRegistry.NETHER_FLOWER_SEEDS, "Nether Flower Seeds");
		addItem(FarmingRegistry.TOMATO_SEEDS, "Tomato Seeds");
		addItem(FarmingRegistry.CUCUMBER_SEEDS, "Cucumber Seeds");
		addItem(FarmingRegistry.AUBERGINE_SEEDS, "Aubergine Seeds");
		addItem(FarmingRegistry.GRAPE_SEEDS, "Grape Seeds");
		addItem(FarmingRegistry.CORN_SEEDS, "Corn Seeds");
		addItem(FarmingRegistry.PINEAPPLE_SEEDS, "Pineapple Seeds");
		addItem(FarmingRegistry.ONION_SEEDS, "Onion Seeds");
		addItem(FarmingRegistry.GARLIC_SEEDS, "Garlic Seeds");
		addItem(FarmingRegistry.LETTUCE_SEEDS, "Lettuce Seeds");
		addItem(FarmingRegistry.POT, "Pot");
		addItem(FarmingRegistry.CUTTING_BOARD, "Cutting Board");
		addItem(FarmingRegistry.MORTAR_AND_PESTLE, "Mortar And Pestle");
		addItem(FarmingRegistry.MINT, "Mint");
		addItem(FarmingRegistry.LEMON, "Lemon");
		addItem(FarmingRegistry.ORANGE, "Orange");
		addItem(FarmingRegistry.CHERRY, "Cherry");
		addItem(FarmingRegistry.PEAR, "Pear");
		addItem(FarmingRegistry.BANANA, "Banana");
		addItem(FarmingRegistry.OLIVE, "Olive");
		addItem(FarmingRegistry.AVOCADO, "Avocado");
		addItem(FarmingRegistry.MANGO, "Mango");
		addItem(FarmingRegistry.TOMATO, "Tomato");
		addItem(FarmingRegistry.CUCUMBER, "Cucumber");
		addItem(FarmingRegistry.AUBERGINE, "Aubergine");
		addItem(FarmingRegistry.GRAPES, "Grapes");
		addItem(FarmingRegistry.PINEAPPLE, "Pineapple");
		addItem(FarmingRegistry.CORN, "Corn");
		addItem(FarmingRegistry.ONION, "Onion");
		addItem(FarmingRegistry.GARLIC, "Garlic");
		addItem(FarmingRegistry.LETTUCE, "Lettuce");
		addItem(FarmingRegistry.GOLDEN_LEMON, "Golden lemon");
		addItem(FarmingRegistry.GOLDEN_ORANGE, "Golden Orange");
		addItem(FarmingRegistry.CHOCOLATE_BAR, "Chocolate Bar");
		addItem(FarmingRegistry.CHOCOLATE_CANDY, "Chocolate Candy");
		addItem(FarmingRegistry.CHOCOLATE_CHERRY, "Chocolate Cherry");
		addItem(FarmingRegistry.CHOCOLATE_BANANA, "Chocolate Banana");
		addItem(FarmingRegistry.MINT_CHOCOLATE_BAR, "Mint Chocolate Bar");
		addItem(FarmingRegistry.MINT_TEA, "Mint Tea");
		addItem(FarmingRegistry.APPLE_JUICE, "Apple Juice");
		addItem(FarmingRegistry.LEMONADE, "Lemonade");
		addItem(FarmingRegistry.ORANGE_JUICE, "Orange Juice");
		addItem(FarmingRegistry.CHERRY_JUICE, "Cherry Juice");
		addItem(FarmingRegistry.PEAR_JUICE, "Pear Juice");
		addItem(FarmingRegistry.BANANA_JUICE, "Banana Juice");
		addItem(FarmingRegistry.GRAPE_JUICE, "Grape Juice");
		addItem(FarmingRegistry.MANGO_JUICE, "Mango Juice");
		addItem(FarmingRegistry.PINEAPPLE_JUICE, "Pineapple Juice");
		addItem(FarmingRegistry.MILK_BOTTLE, "Milk Bottle");
		addItem(FarmingRegistry.COLD_CHOCOLATE_BOTTLE, "Cold Chocolate Bottle");
		addItem(FarmingRegistry.HOT_CHOCOLATE_BOTTLE, "Hot Chocolate Bottle");
		addItem(FarmingRegistry.HOT_WATER, "Boiled Water");
		addItem(FarmingRegistry.SMOOTHIE_APPLE, "Apple Smoothie");
		addItem(FarmingRegistry.SMOOTHIE_LEMON, "Lemon Smoothie");
		addItem(FarmingRegistry.SMOOTHIE_ORANGE, "Orange Smoothie");
		addItem(FarmingRegistry.SMOOTHIE_CHERRY, "Cherry Smoothie");
		addItem(FarmingRegistry.SMOOTHIE_PEAR, "Pear Smoothie");
		addItem(FarmingRegistry.SMOOTHIE_BANANA, "Banana Smoothie");
		addItem(FarmingRegistry.SMOOTHIE_GRAPE, "Grape Smoothie");
		addItem(FarmingRegistry.SMOOTHIE_MANGO, "Mango Smoothie");
		addItem(FarmingRegistry.SMOOTHIE_PINEAPPLE, "Pineapple Smoothie");
		addItem(FarmingRegistry.SMOOTHIE_CUCUMBER, "Cucumber Smoothie");
		addItem(FarmingRegistry.STOCK, "Stock");
		addItem(FarmingRegistry.SALT, "Salt");
		addItem(FarmingRegistry.FLOUR, "Flour");
		addItem(FarmingRegistry.DOUGH, "Dough");
		addItem(FarmingRegistry.OLIVE_OIL, "Olive Oil");
		addItem(FarmingRegistry.PASTA, "Pasta");
		addItem(FarmingRegistry.RAW_FRIES, "Raw Fries");
		addItem(FarmingRegistry.FRUIT_SALAD, "Fruit Salad");
		addItem(FarmingRegistry.SALAD, "Salad");
		addItem(FarmingRegistry.CORN_SOUP, "Corn Soup");
		addItem(FarmingRegistry.CUCUMBER_SOUP, "Cucumber Soup");
		addItem(FarmingRegistry.TOMATO_SOUP, "Tomato Soup");
		addItem(FarmingRegistry.POTATO_SOUP, "Potato Soup");
		addItem(FarmingRegistry.CARROT_SOUP, "Carrot Soup");
		addItem(FarmingRegistry.ONION_SOUP, "Onion Soup");
		addItem(FarmingRegistry.CHICKEN_NOODLE_SOUP, "Chicken Noodle Soup");
		addItem(FarmingRegistry.HAMBURGER, "Hamburger");
		addItem(FarmingRegistry.CHICKENBURGER, "Chicken Burger");
		addItem(FarmingRegistry.CHEESEBURGER, "Cheese Burger");
		addItem(FarmingRegistry.BOILED_EGG, "Boiled Egg");
		addItem(FarmingRegistry.BAKED_EGG, "Baked Egg");
		addItem(FarmingRegistry.SLICED_BREAD, "Sliced Bread");
		addItem(FarmingRegistry.CHEESE, "Cheese");
		addItem(FarmingRegistry.SPAGHETTI, "Spaghetti");
		addItem(FarmingRegistry.JAM, "Fruit Jam");
		addItem(FarmingRegistry.FRIES, "Fries");
		addItem(FarmingRegistry.FISH_AND_CHIPS, "Fish And Chips");
		addItem(FarmingRegistry.POTATO_CHIPS, "Potato Chips");
		addItem(FarmingRegistry.GUACAMOLE, "Guacamole");
		addItem(FarmingRegistry.GUAC_AND_CHIPS, "Guac and Chips");
		addItem(FarmingRegistry.EGG_SANDWICH, "Egg Sandwich");
		addItem(FarmingRegistry.BACON_SANDWICH, "Bacon Sandwich");
		addItem(FarmingRegistry.CHICKEN_SANDWICH, "Chicken Sandwich");
		addItem(FarmingRegistry.JC_SANDWICH, "Jam And Cheese Sandwich");
		addItem(FarmingRegistry.PINEAPPLE_PIZZA, "Pineapple Pizza");
		addItem(FarmingRegistry.CHEESE_PIZZA, "Cheese Pizza");
		addItem(FarmingRegistry.BACON_PIZZA, "Bacon Pizza");
		addItem(FarmingRegistry.APPLE_PIE, "Apple Pie");
		addItem(FarmingRegistry.BANANA_PIE, "Banana Cream Pie");
		addItem(FarmingRegistry.BACON_AND_EGG_PIE, "Bacon And Egg Pie");
		addItem(FarmingRegistry.CHERRY_PIE, "Cherry Pie");
		addItem(FarmingRegistry.GRAPE_PIE, "Grape Pie");
		addItem(FarmingRegistry.LEMON_PIE, "Lemon Meringue Pie");
		addItem(FarmingRegistry.PEAR_PIE, "Pear Pie");
		addItem(FarmingRegistry.WOODEN_RAKE, "Wooden Rake");
		addItem(FarmingRegistry.STONE_RAKE, "Stone Rake");
		addItem(FarmingRegistry.IRON_RAKE, "Iron Rake");
		addItem(FarmingRegistry.GOLD_RAKE, "Gold Rake");
		addItem(FarmingRegistry.DIAMOND_RAKE, "Diamond Rake");
	}
}