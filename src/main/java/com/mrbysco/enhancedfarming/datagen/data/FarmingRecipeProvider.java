package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.datagen.data.recipe.PistonRecipeBuilder;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.init.conditions.CropToSeedCondition;
import com.mrbysco.enhancedfarming.init.conditions.RakeEnabledCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FarmingRecipeProvider extends RecipeProvider {
	public FarmingRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	private static final TagKey<Item> FLOUR_TAG = createCTag("flour/wheat");

	@Override
	protected void buildRecipes(RecipeOutput recipeOutput) {
		final ItemStack waterBottle = Items.POTION.getDefaultInstance();

		generateSapling(recipeOutput, FarmingRegistry.APPLE_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/apple");
		generateSapling(recipeOutput, FarmingRegistry.LEMON_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/lemon");
		generateSapling(recipeOutput, FarmingRegistry.ORANGE_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/orange");
		generateSapling(recipeOutput, FarmingRegistry.CHERRY_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/cherry");
		generateSapling(recipeOutput, FarmingRegistry.PEAR_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/pear");
		generateSapling(recipeOutput, FarmingRegistry.BANANA_SAPLING_ITEM, Items.JUNGLE_SAPLING, "foods/fruits/banana");
		generateSapling(recipeOutput, FarmingRegistry.AVOCADO_SAPLING_ITEM, Items.ACACIA_SAPLING, "foods/fruits/avocado");
		generateSapling(recipeOutput, FarmingRegistry.MANGO_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/mango");
		generateSapling(recipeOutput, FarmingRegistry.OLIVE_SAPLING_ITEM, Items.ACACIA_SAPLING, "foods/vegetables/olive");

		generatePie(recipeOutput, FarmingRegistry.APPLE_PIE, "foods/fruits/apple", "sugar", "eggs");
		generatePie(recipeOutput, FarmingRegistry.BANANA_PIE, "foods/fruits/banana", "sugar", "eggs", "milk");
		generatePie(recipeOutput, FarmingRegistry.CHERRY_PIE, "foods/fruits/cherry", "sugar", "eggs");
		generatePie(recipeOutput, FarmingRegistry.GRAPE_PIE, "foods/fruits/grapes", "sugar", "eggs");
		generatePie(recipeOutput, FarmingRegistry.LEMON_PIE, "foods/fruits/lemon", "sugar", "eggs");
		generatePie(recipeOutput, FarmingRegistry.PEAR_PIE, "foods/fruits/pear", "sugar", "eggs");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.BACON_AND_EGG_PIE.get())
				.requires(createTag("foods/raw_beef"))
				.requires(createTag("eggs"))
				.requires(createTag("dough/wheat"))
				.unlockedBy("has_beef", has(createTag("foods/raw_beef")))
				.unlockedBy("has_egg", has(createTag("eggs")))
				.unlockedBy("has_dough", has(createTag("dough/wheat")))
				.save(recipeOutput, FarmingRegistry.BACON_AND_EGG_PIE.getId().withPrefix("pie/"));

		generateJuice(recipeOutput, FarmingRegistry.APPLE_JUICE, "foods/fruits/apple");
		generateJuice(recipeOutput, FarmingRegistry.LEMONADE, "foods/fruits/lemon");
		generateJuice(recipeOutput, FarmingRegistry.ORANGE_JUICE, "foods/fruits/orange");
		generateJuice(recipeOutput, FarmingRegistry.CHERRY_JUICE, "foods/fruits/cherry");
		generateJuice(recipeOutput, FarmingRegistry.PEAR_JUICE, "foods/fruits/pear");
		generateJuice(recipeOutput, FarmingRegistry.BANANA_JUICE, "foods/fruits/banana");
		generateJuice(recipeOutput, FarmingRegistry.GRAPE_JUICE, "foods/fruits/grape");
		generateJuice(recipeOutput, FarmingRegistry.MANGO_JUICE, "foods/fruits/mango");
		generateJuice(recipeOutput, FarmingRegistry.PINEAPPLE_JUICE, "foods/fruits/pineapple");

		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_APPLE, "foods/fruits/apple");
		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_BANANA, "foods/fruits/banana");
		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_CHERRY, "foods/fruits/1cherry");
		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_CUCUMBER, "foods/vegetables/cucumber");
		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_GRAPE, "foods/fruits/grapes");
		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_LEMON, "foods/fruits/lemon");
		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_MANGO, "foods/fruits/mango");
		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_ORANGE, "foods/fruits/orange");
		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_PEAR, "foods/fruits/pear");
		generateSmoothie(recipeOutput, FarmingRegistry.SMOOTHIE_PINEAPPLE, "foods/fruits/pineapple");

		generateSeed(recipeOutput, FarmingRegistry.TOMATO_SEEDS, FarmingRegistry.TOMATO.get());
		generateSeed(recipeOutput, FarmingRegistry.CUCUMBER_SEEDS, FarmingRegistry.CUCUMBER.get());
		generateSeed(recipeOutput, FarmingRegistry.AUBERGINE_SEEDS, FarmingRegistry.AUBERGINE.get());
		generateSeed(recipeOutput, FarmingRegistry.GRAPE_SEEDS, FarmingRegistry.GRAPES.get());
		generateSeed(recipeOutput, FarmingRegistry.PINEAPPLE_SEEDS, FarmingRegistry.PINEAPPLE.get());
		generateSeed(recipeOutput, FarmingRegistry.CORN_SEEDS, FarmingRegistry.CORN.get());
		generateSeed(recipeOutput, FarmingRegistry.ONION_SEEDS, FarmingRegistry.ONION.get());
		generateSeed(recipeOutput, FarmingRegistry.GARLIC_SEEDS, FarmingRegistry.GARLIC.get());
		generateSeed(recipeOutput, FarmingRegistry.LETTUCE_SEEDS, FarmingRegistry.LETTUCE.get());

		//Furnace recipes
		generateFurnace(recipeOutput, FarmingRegistry.BAKED_EGG.get(), "eggs");
		generateFurnace(recipeOutput, Items.BREAD, FarmingRegistry.DOUGH.get());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(FarmingRegistry.COLD_CHOCOLATE_BOTTLE.get()), RecipeCategory.FOOD,
						FarmingRegistry.HOT_CHOCOLATE_BOTTLE.get(), 0.25F, 200)
				.unlockedBy("has_item", has(FarmingRegistry.COLD_CHOCOLATE_BOTTLE.get()))
				.save(recipeOutput, FarmingRegistry.HOT_CHOCOLATE_BOTTLE.getId().withPrefix("cooking/"));
		SimpleCookingRecipeBuilder.smelting(DataComponentIngredient.of(true, waterBottle), RecipeCategory.FOOD,
						FarmingRegistry.HOT_WATER.get(), 0.25F, 200)
				.unlockedBy("has_item", has(Items.POTION))
				.save(recipeOutput, FarmingRegistry.HOT_WATER.getId().withPrefix("cooking/"));

		//Mint Tea
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.MINT_TEA.get())
				.requires(FarmingRegistry.MINT.get())
				.requires(FarmingRegistry.HOT_WATER.get())
				.unlockedBy("has_mint", has(FarmingRegistry.MINT.get()))
				.unlockedBy("has_hot_water", has(FarmingRegistry.HOT_WATER.get()))
				.save(recipeOutput);

		//Soup
		generateSoup(recipeOutput, FarmingRegistry.CARROT_SOUP, "foods/vegetables/carrot");
		generateNoodleSoup(recipeOutput, FarmingRegistry.CHICKEN_NOODLE_SOUP, "foods/vegetables/onion", "foods/vegetables/carrot", "foods/raw_chicken");
		generateSoup(recipeOutput, FarmingRegistry.CORN_SOUP, "foods/vegetables/corn");
		generateSoup(recipeOutput, FarmingRegistry.CUCUMBER_SOUP, "foods/vegetables/cucumber");
		generateSoup(recipeOutput, FarmingRegistry.ONION_SOUP, "foods/vegetables/onion");
		generateSoup(recipeOutput, FarmingRegistry.POTATO_SOUP, "foods/vegetables/potato");
		generateSoup(recipeOutput, FarmingRegistry.TOMATO_SOUP, "foods/vegetables/tomato");

		//Salad
		generateSalad(recipeOutput, FarmingRegistry.FRUIT_SALAD, "foods/fruits", "foods/fruits");
		generateSalad(recipeOutput, FarmingRegistry.SALAD, "foods/vegetables/lettuce", "foods/vegetables/tomato", "foods/vegetables/onion");

		//Dough
		TagKey<Item> saltTag = createTag("foods/edible_salt");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.FLOUR.get())
				.requires(Tags.Items.CROPS_WHEAT)
				.requires(FarmingRegistry.MORTAR_AND_PESTLE.get())
				.unlockedBy("has_wheat", has(Tags.Items.CROPS_WHEAT))
				.unlockedBy("has_mortar_and_pestle", has(FarmingRegistry.MORTAR_AND_PESTLE.get()))
				.save(recipeOutput);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.DOUGH.get())
				.requires(DataComponentIngredient.of(true, waterBottle))
				.requires(saltTag)
				.requires(FLOUR_TAG)
				.unlockedBy("has_water", has(Items.POTION))
				.unlockedBy("has_salt", has(saltTag))
				.unlockedBy("has_flour", has(FLOUR_TAG))
				.save(recipeOutput);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.DOUGH.get())
				.requires(Items.WATER_BUCKET)
				.requires(saltTag)
				.requires(FLOUR_TAG)
				.unlockedBy("has_water", has(Items.WATER_BUCKET))
				.unlockedBy("has_salt", has(saltTag))
				.unlockedBy("has_flour", has(FLOUR_TAG))
				.save(recipeOutput, FarmingRegistry.DOUGH.getId().withSuffix("_with_bucket"));

		//Salt
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.SALT.get(), 3)
				.requires(FarmingRegistry.POT.get())
				.requires(Items.WATER_BUCKET)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
				.save(recipeOutput, FarmingRegistry.SALT.getId().withSuffix("_alt"));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.SALT.get())
				.requires(FarmingRegistry.POT.get())
				.requires(DataComponentIngredient.of(true, waterBottle))
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water_bottle", has(Items.GLASS_BOTTLE))
				.save(recipeOutput);

		//Sliced bread
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.SLICED_BREAD.get(), 2)
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.save(recipeOutput);

		//Burger
		TagKey<Item> cookedBeefTag = createTag("foods/cooked_beef");
		TagKey<Item> lettuceTag = createTag("foods/vegetables/lettuce");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.HAMBURGER.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.requires(cookedBeefTag)
				.requires(lettuceTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.unlockedBy("has_cooked_beef", has(cookedBeefTag))
				.unlockedBy("has_lettuce", has(lettuceTag))
				.save(recipeOutput);
		TagKey<Item> cheeseTag = createTag("foods/cheeses/normal");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.CHEESEBURGER.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.requires(cookedBeefTag)
				.requires(cheeseTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.unlockedBy("has_cooked_beef", has(cookedBeefTag))
				.unlockedBy("has_cheese", has(cheeseTag))
				.save(recipeOutput);
		TagKey<Item> cookedChickenTag = createTag("foods/cooked_chicken");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.CHICKENBURGER.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.requires(cookedChickenTag)
				.requires(cheeseTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.unlockedBy("has_cooked_chicken", has(cookedChickenTag))
				.unlockedBy("has_cheese", has(cheeseTag))
				.save(recipeOutput);

		//Cheese
		TagKey<Item> milkTag = createTag("milk");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.CHEESE.get())
				.requires(FarmingRegistry.POT.get())
				.requires(milkTag)
				.requires(saltTag)
				.unlockedBy("has_water", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_milk", has(milkTag))
				.unlockedBy("has_salt", has(saltTag))
				.save(recipeOutput);

		//Egg
		TagKey<Item> waterTag = createTag("water");
		TagKey<Item> eggsTag = createTag("eggs");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.BOILED_EGG.get())
				.requires(FarmingRegistry.POT.get())
				.requires(waterTag)
				.requires(eggsTag)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water", has(waterTag))
				.unlockedBy("has_egg", has(eggsTag))
				.save(recipeOutput);


		//Stock
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.STOCK.get(), 2)
				.requires(FarmingRegistry.POT.get())
				.requires(waterTag)
				.requires(Items.BOWL)
				.requires(Tags.Items.FOODS_VEGETABLE)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water", has(waterTag))
				.unlockedBy("has_bowl", has(Items.BOWL))
				.unlockedBy("has_vegetables", has(Tags.Items.FOODS_VEGETABLE))
				.save(recipeOutput);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.STOCK.get(), 2)
				.requires(FarmingRegistry.POT.get())
				.requires(waterTag)
				.requires(Items.BOWL)
				.requires(Tags.Items.FOODS_RAW_MEAT)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water", has(waterTag))
				.unlockedBy("has_bowl", has(Items.BOWL))
				.unlockedBy("has_rawmeats", has(Tags.Items.FOODS_RAW_MEAT))
				.save(recipeOutput, FarmingRegistry.STOCK.getId().withSuffix("_alt"));

		//Gold fruit
		generateGolden(recipeOutput, FarmingRegistry.GOLDEN_LEMON, FarmingRegistry.LEMON);
		generateGolden(recipeOutput, FarmingRegistry.GOLDEN_ORANGE, FarmingRegistry.ORANGE);

		//Pizza
		generatePizza(recipeOutput, FarmingRegistry.PINEAPPLE_PIZZA, "foods/vegetables/tomato", "foods/fruits/pineapple");
		generatePizza(recipeOutput, FarmingRegistry.CHEESE_PIZZA, "foods/vegetables/tomato", "foods/cheeses/normal");
		generatePizza(recipeOutput, FarmingRegistry.BACON_PIZZA, "foods/vegetables/tomato", "foods/raw_beef");

		//Sandwich
		generateSandwich(recipeOutput, FarmingRegistry.JC_SANDWICH, List.of("foods/cheeses/normal"), FarmingRegistry.JAM.get());
		generateSandwich(recipeOutput, FarmingRegistry.EGG_SANDWICH, List.of(), FarmingRegistry.BAKED_EGG.get());
		generateSandwichAlt(recipeOutput, FarmingRegistry.EGG_SANDWICH, List.of(), FarmingRegistry.BOILED_EGG.get());
		generateSandwich(recipeOutput, FarmingRegistry.BACON_SANDWICH, List.of("foods/vegetables/tomato", "foods/cooked_beef"));
		generateSandwich(recipeOutput, FarmingRegistry.CHICKEN_SANDWICH, List.of("foods/cooked_chicken"));

		//Chocolate
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.COLD_CHOCOLATE_BOTTLE.get())
				.requires(Items.COCOA_BEANS)
				.requires(FarmingRegistry.MILK_BOTTLE.get())
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_milk_bottle", has(FarmingRegistry.MILK_BOTTLE.get()))
				.save(recipeOutput);

		TagKey<Item> sugarTag = createTag("sugar");
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FarmingRegistry.CHOCOLATE_BAR.get())
				.pattern("CSC")
				.pattern("CSC")
				.pattern("CSC")
				.define('C', Items.COCOA_BEANS)
				.define('S', sugarTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_sugar", has(sugarTag))
				.save(recipeOutput);

		TagKey<Item> mintTag = createTag("herbs/mint");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.MINT_CHOCOLATE_BAR.get())
				.requires(mintTag)
				.requires(FarmingRegistry.CHOCOLATE_BAR.get())
				.unlockedBy("has_mint", has(mintTag))
				.unlockedBy("has_chocolate_bar", has(FarmingRegistry.CHOCOLATE_BAR.get()))
				.save(recipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FarmingRegistry.CHOCOLATE_CANDY.get(), 2)
				.pattern(" C ")
				.pattern("CSC")
				.pattern(" C ")
				.define('C', Items.COCOA_BEANS)
				.define('S', sugarTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_sugar", has(sugarTag))
				.save(recipeOutput);
		TagKey<Item> bananaTag = createTag("foods/fruits/banana");
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FarmingRegistry.CHOCOLATE_BANANA.get())
				.pattern(" C")
				.pattern("CF")
				.define('C', Items.COCOA_BEANS)
				.define('F', bananaTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_banana", has(bananaTag))
				.save(recipeOutput);
		TagKey<Item> cherryTag = createTag("foods/fruits/cherry");
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FarmingRegistry.CHOCOLATE_CHERRY.get())
				.pattern(" C")
				.pattern("CF")
				.define('C', Items.COCOA_BEANS)
				.define('F', cherryTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_cherry", has(cherryTag))
				.save(recipeOutput);

		//Pasta
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.PASTA.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.OLIVE_OIL.get())
				.requires(FarmingRegistry.DOUGH.get())
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_olive_oil", has(FarmingRegistry.OLIVE_OIL.get()))
				.unlockedBy("has_dough", has(FarmingRegistry.DOUGH.get()))
				.save(recipeOutput);
		//Spaghetti
		TagKey<Item> tomatoTag = createTag("foods/vegetables/tomato");
		TagKey<Item> rawBeefTag = createTag("foods/raw_beef");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.SPAGHETTI.get())
				.requires(FarmingRegistry.POT.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.PASTA.get())
				.requires(tomatoTag)
				.requires(rawBeefTag)
				.requires(Items.BOWL)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_pasta", has(FarmingRegistry.PASTA.get()))
				.unlockedBy("has_tomato", has(tomatoTag))
				.unlockedBy("has_raw_beef", has(rawBeefTag))
				.unlockedBy("has_bowl", has(Items.BOWL))
				.save(recipeOutput);

		//Fries
		TagKey<Item> potatoTag = createTag("foods/vegetables/potato");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.RAW_FRIES.get(), 2)
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(potatoTag)
				.requires(potatoTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_potato", has(potatoTag))
				.save(recipeOutput);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.FRIES.get())
				.requires(FarmingRegistry.POT.get())
				.requires(FarmingRegistry.OLIVE_OIL.get())
				.requires(FarmingRegistry.RAW_FRIES.get())
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_olive_oil", has(FarmingRegistry.OLIVE_OIL.get()))
				.unlockedBy("has_raw_fries", has(FarmingRegistry.RAW_FRIES.get()))
				.save(recipeOutput);
		TagKey<Item> rawFishTag = createTag("foods/raw_fish");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.FISH_AND_CHIPS.get())
				.requires(FarmingRegistry.POT.get())
				.requires(FarmingRegistry.OLIVE_OIL.get())
				.requires(FarmingRegistry.RAW_FRIES.get())
				.requires(rawFishTag)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_olive_oil", has(FarmingRegistry.OLIVE_OIL.get()))
				.unlockedBy("has_raw_fries", has(FarmingRegistry.RAW_FRIES.get()))
				.unlockedBy("has_raw_fish", has(rawFishTag))
				.save(recipeOutput);
		TagKey<Item> cookedFishTag = createTag("foods/cooked_fish");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.FISH_AND_CHIPS.get())
				.requires(FarmingRegistry.FRIES.get())
				.requires(cookedFishTag)
				.unlockedBy("has_fries", has(FarmingRegistry.FRIES.get()))
				.unlockedBy("has_cooked_fish", has(cookedFishTag))
				.save(recipeOutput, FarmingRegistry.FISH_AND_CHIPS.getId().withSuffix("_alt"));

		//Potato chips
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.POTATO_CHIPS.get())
				.requires(FarmingRegistry.POT.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(potatoTag)
				.requires(FarmingRegistry.OLIVE_OIL.get())
				.requires(saltTag)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_potato", has(potatoTag))
				.unlockedBy("has_olive_oil", has(FarmingRegistry.OLIVE_OIL.get()))
				.unlockedBy("has_salt", has(saltTag))
				.save(recipeOutput);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.GUAC_AND_CHIPS.get())
				.requires(FarmingRegistry.POTATO_CHIPS.get())
				.requires(FarmingRegistry.GUACAMOLE.get())
				.unlockedBy("has_potato_chips", has(FarmingRegistry.POTATO_CHIPS.get()))
				.unlockedBy("has_guacamole", has(FarmingRegistry.GUACAMOLE.get()))
				.save(recipeOutput);

		//Quac
		TagKey<Item> avocadoTag = createTag("foods/fruits/avocado");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.GUACAMOLE.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(avocadoTag)
				.requires(Items.BOWL)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_avocado", has(avocadoTag))
				.unlockedBy("has_bowl", has(Items.BOWL))
				.save(recipeOutput);

		//Jam
		TagKey<Item> fruitsTag = Tags.Items.FOODS_FRUIT;
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.JAM.get())
				.requires(FarmingRegistry.POT.get())
				.requires(fruitsTag)
				.requires(fruitsTag)
				.requires(sugarTag)
				.requires(sugarTag)
				.requires(Items.GLASS_BOTTLE)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_fruits", has(fruitsTag))
				.unlockedBy("has_sugar", has(sugarTag))
				.unlockedBy("has_bottle", has(Items.GLASS_BOTTLE))
				.save(recipeOutput);


		//Rake
		generateRake(recipeOutput, FarmingRegistry.WOODEN_RAKE, ItemTags.PLANKS);
		generateRake(recipeOutput, FarmingRegistry.STONE_RAKE, Tags.Items.COBBLESTONES);
		generateRake(recipeOutput, FarmingRegistry.IRON_RAKE, Tags.Items.INGOTS_IRON);
		generateRake(recipeOutput, FarmingRegistry.GOLD_RAKE, Tags.Items.INGOTS_GOLD);
		generateRake(recipeOutput, FarmingRegistry.DIAMOND_RAKE, Tags.Items.GEMS_DIAMOND);

		//Utensils
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FarmingRegistry.POT.get())
				.pattern("ISI")
				.pattern(" I ")
				.define('I', Tags.Items.INGOTS_IRON)
				.define('S', Tags.Items.STONES)
				.unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_stone", has(Tags.Items.STONES))
				.save(recipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FarmingRegistry.CUTTING_BOARD.get())
				.pattern(" I ")
				.pattern("SPP")
				.define('I', Tags.Items.INGOTS_IRON)
				.define('S', Tags.Items.RODS_WOODEN)
				.define('P', ItemTags.PLANKS)
				.unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_stick", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_planks", has(ItemTags.PLANKS))
				.save(recipeOutput);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FarmingRegistry.MORTAR_AND_PESTLE.get())
				.pattern(" S")
				.pattern("B ")
				.define('S', Tags.Items.INGOTS_IRON)
				.define('B', Tags.Items.STONES)
				.unlockedBy("has_stick", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_stone", has(Tags.Items.STONES))
				.save(recipeOutput);

		//Misc
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FarmingRegistry.CROP_STICK.get())
				.pattern("SS")
				.pattern("SS")
				.define('S', Tags.Items.RODS_WOODEN)
				.unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN))
				.save(recipeOutput);

		//Scarecrow
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, FarmingRegistry.SCARECROW.get())
				.pattern(" P ")
				.pattern("WXW")
				.pattern(" S ")
				.define('P', Items.CARVED_PUMPKIN)
				.define('W', Tags.Items.CROPS_WHEAT)
				.define('X', ItemTags.WOOL)
				.define('S', Tags.Items.RODS_WOODEN)
				.unlockedBy("has_pumpkin", has(Items.CARVED_PUMPKIN))
				.unlockedBy("has_wheat", has(Tags.Items.CROPS_WHEAT))
				.unlockedBy("has_wool", has(ItemTags.WOOL))
				.unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN))
				.save(recipeOutput);

		//Olive Oil
		TagKey<Item> oliveTag = createTag("foods/vegetables/olive");
		new PistonRecipeBuilder(FarmingRegistry.OLIVE_OIL.get(), 1, Ingredient.of(oliveTag))
				.unlockedBy("has_olive", has(FarmingRegistry.OLIVE.get()))
				.save(recipeOutput, FarmingRegistry.OLIVE_OIL.getId().withPrefix("piston/"));
	}

	private void generateFurnace(RecipeOutput recipeOutput, Item output, String ingredientTag) {
		TagKey<Item> itemTag = createTag(ingredientTag);
		ResourceLocation id = EnhancedFarming.modLoc(BuiltInRegistries.ITEM.getKey(output).getPath()).withPrefix("cooking/");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemTag), RecipeCategory.FOOD, output, 0.35F, 200)
				.unlockedBy("has_item", has(itemTag))
				.save(recipeOutput, id);

		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(itemTag), RecipeCategory.FOOD, output, 0.35F, 600)
				.unlockedBy("has_item", has(itemTag))
				.save(recipeOutput, id.withSuffix("_from_campfire"));
	}

	private void generateFurnace(RecipeOutput recipeOutput, Item output, Item ingredient) {
		ResourceLocation id = EnhancedFarming.modLoc(BuiltInRegistries.ITEM.getKey(output).getPath()).withPrefix("cooking/");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, output, 0.35F, 200)
				.unlockedBy("has_item", has(ingredient))
				.save(recipeOutput, id);

		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, output, 0.35F, 600)
				.unlockedBy("has_item", has(ingredient))
				.save(recipeOutput, id.withSuffix("_from_campfire"));
	}

	private void generateJuice(RecipeOutput recipeOutput, DeferredItem<? extends Item> juice, String tag) {
		TagKey<Item> itemTag = createTag(tag);
		final ItemStack waterBottle = Items.POTION.getDefaultInstance();

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, juice.get())
				.requires(DataComponentIngredient.of(true, waterBottle))
				.requires(itemTag)
				.unlockedBy("has_item", has(itemTag))
				.save(recipeOutput, juice.getId().withPrefix("juice/"));
	}

	private void generateSmoothie(RecipeOutput recipeOutput, DeferredItem<? extends Item> juice, String tag) {
		TagKey<Item> itemTag = createTag(tag);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, juice.get())
				.requires(FarmingRegistry.MILK_BOTTLE.get())
				.requires(itemTag)
				.requires(Items.SNOWBALL)
				.unlockedBy("has_milk_bottle", has(FarmingRegistry.MILK_BOTTLE.get()))
				.unlockedBy("has_item", has(itemTag))
				.unlockedBy("has_snowball", has(Items.SNOWBALL))
				.save(recipeOutput, juice.getId().withPrefix("smoothie/"));
	}

	private void generatePie(RecipeOutput recipeOutput, DeferredItem<? extends Item> pie, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, pie.get())
				.requires(FLOUR_TAG)
				.unlockedBy("has_flour", has(FLOUR_TAG));
		List<String> knownTags = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String hasTag = "has_" + itemTag.location().getPath().replace(":", "_");
			if (!knownTags.contains(hasTag)) {
				builder = builder.unlockedBy(hasTag, has(itemTag));
				knownTags.add(hasTag);
			}
		}
		builder.save(recipeOutput, pie.getId().withPrefix("pie/"));
	}

	private void generateSoup(RecipeOutput recipeOutput, DeferredItem<? extends Item> soup, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, soup.get())
				.requires(FarmingRegistry.POT.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.STOCK.get())
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_stock", has(FarmingRegistry.STOCK.get()));
		List<String> knownTags = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String hasTag = "has_" + itemTag.location().getPath().replace(":", "_");
			if (!knownTags.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + itemTag.location().getPath().replace(":", "_"), has(itemTag));
				knownTags.add(hasTag);
			}
		}
		builder.save(recipeOutput, soup.getId().withPrefix("soup/"));
	}

	private void generateSalad(RecipeOutput recipeOutput, DeferredItem<? extends Item> salad, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, salad.get())
				.requires(Items.BOWL)
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.unlockedBy("has_bowl", has(Items.BOWL))
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()));

		List<String> knownTags = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String hasTag = "has_" + itemTag.location().getPath().replace(":", "_");
			if (!knownTags.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + itemTag.location().getPath().replace(":", "_"), has(itemTag));
				knownTags.add(hasTag);
			}
		}
		builder.save(recipeOutput, salad.getId().withPrefix("salad/"));
	}

	private void generatePizza(RecipeOutput recipeOutput, DeferredItem<? extends Item> salad, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, salad.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.DOUGH.get())
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_dough", has(FarmingRegistry.DOUGH.get()));

		List<String> knownTags = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String hasTag = "has_" + itemTag.location().getPath().replace(":", "_");
			if (!knownTags.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + itemTag.location().getPath().replace(":", "_"), has(itemTag));
				knownTags.add(hasTag);
			}
		}
		builder.save(recipeOutput, salad.getId().withPrefix("pizza/"));
	}

	private void generateNoodleSoup(RecipeOutput recipeOutput, DeferredItem<? extends Item> juice, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, juice.get())
				.requires(FarmingRegistry.POT.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.STOCK.get())
				.requires(FarmingRegistry.PASTA.get())
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_stock", has(FarmingRegistry.STOCK.get()))
				.unlockedBy("has_pasta", has(FarmingRegistry.PASTA.get()));
		List<String> knownTags = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String hasTag = "has_" + itemTag.location().getPath().replace(":", "_");
			if (!knownTags.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + itemTag.location().getPath().replace(":", "_"), has(itemTag));
				knownTags.add(hasTag);
			}
		}
		builder.save(recipeOutput, juice.getId().withPrefix("soup/"));
	}

	private void generateSandwich(RecipeOutput recipeOutput, DeferredItem<? extends Item> sandwich, List<String> tags, Item... items) {
		List<TagKey<Item>> itemTags = tags.stream().map(this::createTag).toList();

		ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, sandwich.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.SLICED_BREAD.get())
				.requires(FarmingRegistry.SLICED_BREAD.get())
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_sliced_bread", has(FarmingRegistry.SLICED_BREAD.get()));
		List<String> knownUnlocks = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String hasTag = "has_" + itemTag.location().getPath().replace(":", "_");
			if (!knownUnlocks.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + itemTag.location().getPath().replace(":", "_"), has(itemTag));
				knownUnlocks.add(hasTag);
			}
		}
		for (Item item : items) {
			ResourceLocation itemLocation = BuiltInRegistries.ITEM.getKey(item);
			if (itemLocation != null) {
				builder = builder.requires(item);
				String hasTag = "has_" + itemLocation.getPath();
				if (!knownUnlocks.contains(hasTag)) {
					builder = builder.unlockedBy("has_" + itemLocation.getPath(), has(item));
					knownUnlocks.add(hasTag);
				}
			}
		}
		builder.save(recipeOutput, sandwich.getId().withPrefix("sandwich/"));
	}

	private void generateSandwichAlt(RecipeOutput recipeOutput, DeferredItem<? extends Item> sandwich, List<String> tags, Item... items) {
		List<TagKey<Item>> itemTags = tags.stream().map(this::createTag).toList();

		ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, sandwich.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.SLICED_BREAD.get())
				.requires(FarmingRegistry.SLICED_BREAD.get())
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_sliced_bread", has(FarmingRegistry.SLICED_BREAD.get()));
		List<String> knownUnlocks = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String hasTag = "has_" + itemTag.location().getPath().replace(":", "_");
			if (!knownUnlocks.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + itemTag.location().getPath().replace(":", "_"), has(itemTag));
				knownUnlocks.add(hasTag);
			}
		}
		for (Item item : items) {
			ResourceLocation itemLocation = BuiltInRegistries.ITEM.getKey(item);
			if (itemLocation != null) {
				builder = builder.requires(item);
				String hasTag = "has_" + itemLocation.getPath();
				if (!knownUnlocks.contains(hasTag)) {
					builder = builder.unlockedBy("has_" + itemLocation.getPath(), has(item));
					knownUnlocks.add(hasTag);
				}
			}
		}
		builder.save(recipeOutput, sandwich.getId().withPrefix("sandwich/").withSuffix("_alt"));
	}

	private void generateSapling(RecipeOutput recipeOutput, DeferredItem<? extends Item> newSapling, ItemLike sapling, String tag) {
		TagKey<Item> itemTag = createTag(tag);
		RecipeOutput conditionOutput = recipeOutput.withConditions(CropToSeedCondition.INSTANCE);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, newSapling.get())
				.requires(sapling)
				.requires(itemTag)
				.unlockedBy("has_sapling", has(sapling))
				.unlockedBy("has_item", has(itemTag))
				.save(conditionOutput, newSapling.getId().withPrefix("sapling/"));
	}

	private void generateSeed(RecipeOutput recipeOutput, DeferredItem<? extends Item> seed, ItemLike item) {
		RecipeOutput conditionOutput = recipeOutput.withConditions(CropToSeedCondition.INSTANCE);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, seed.get())
				.requires(item)
				.unlockedBy("has_item", has(item))
				.save(conditionOutput, seed.getId().withPrefix("seed/"));
	}

	private void generateRake(RecipeOutput recipeOutput, DeferredItem<? extends Item> rake, TagKey<Item> material) {
		RecipeOutput conditionOutput = recipeOutput.withConditions(RakeEnabledCondition.INSTANCE);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, rake.get())
				.pattern("X X")
				.pattern("XSX")
				.pattern(" S ")
				.define('X', material)
				.define('S', Tags.Items.RODS_WOODEN)
				.unlockedBy("has_material", has(material))
				.unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN))
				.save(conditionOutput, rake.getId().withPrefix("rake/"));
	}

	private void generateGolden(RecipeOutput recipeOutput, DeferredItem<? extends Item> goldFruit, DeferredItem<? extends Item> fruit) {
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, goldFruit.get())
				.pattern("GGG")
				.pattern("GFG")
				.pattern("GGG")
				.define('G', Tags.Items.NUGGETS_GOLD)
				.define('F', fruit.get())
				.unlockedBy("has_gold_nugget", has(Tags.Items.NUGGETS_GOLD))
				.unlockedBy("has_fruit", has(fruit.get()))
				.save(recipeOutput, goldFruit.getId());
	}

	private TagKey<Item> createTag(String name) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
	}

	private static TagKey<Item> createCTag(String name) {
		return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
	}

	//TODO: Disable advancement generation? I guess the overriding the buildAdvancement and returning null doesn't work anymore
}