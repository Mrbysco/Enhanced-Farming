package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.datagen.data.recipe.PistonRecipeBuilder;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.init.conditions.CropToSeedCondition;
import com.mrbysco.enhancedfarming.init.conditions.RakeEnabledCondition;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
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
	public FarmingRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
		super(provider, recipeOutput);
	}

	private static final TagKey<Item> FLOUR_TAG = createCTag("flour/wheat");

	@Override
	protected void buildRecipes() {
		final ItemStackTemplate waterBottle = new ItemStackTemplate(Items.POTION);

		generateSapling(output, FarmingRegistry.APPLE_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/apple");
		generateSapling(output, FarmingRegistry.LEMON_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/lemon");
		generateSapling(output, FarmingRegistry.ORANGE_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/orange");
		generateSapling(output, FarmingRegistry.CHERRY_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/cherry");
		generateSapling(output, FarmingRegistry.PEAR_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/pear");
		generateSapling(output, FarmingRegistry.BANANA_SAPLING_ITEM, Items.JUNGLE_SAPLING, "foods/fruits/banana");
		generateSapling(output, FarmingRegistry.AVOCADO_SAPLING_ITEM, Items.ACACIA_SAPLING, "foods/fruits/avocado");
		generateSapling(output, FarmingRegistry.MANGO_SAPLING_ITEM, Items.OAK_SAPLING, "foods/fruits/mango");
		generateSapling(output, FarmingRegistry.OLIVE_SAPLING_ITEM, Items.ACACIA_SAPLING, "foods/vegetables/olive");

		generatePie(output, FarmingRegistry.APPLE_PIE, "sugar", "eggs");
		generatePie(output, FarmingRegistry.BANANA_PIE, "sugar", "eggs", "milk");
		generatePie(output, FarmingRegistry.CHERRY_PIE, "sugar", "eggs");
		generatePie(output, FarmingRegistry.GRAPE_PIE, "sugar", "eggs");
		generatePie(output, FarmingRegistry.LEMON_PIE, "sugar", "eggs");
		generatePie(output, FarmingRegistry.PEAR_PIE, "sugar", "eggs");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.BACON_AND_EGG_PIE.get())
				.requires(createTag("foods/raw_beef"))
				.requires(createTag("eggs"))
				.requires(createTag("dough/wheat"))
				.unlockedBy("has_beef", has(createTag("foods/raw_beef")))
				.unlockedBy("has_egg", has(createTag("eggs")))
				.unlockedBy("has_dough", has(createTag("dough/wheat")))
				.save(output, FarmingRegistry.BACON_AND_EGG_PIE.getId().withPrefix("pie/").toString());

		generateJuice(output, FarmingRegistry.APPLE_JUICE, "foods/fruits/apple");
		generateJuice(output, FarmingRegistry.LEMONADE, "foods/fruits/lemon");
		generateJuice(output, FarmingRegistry.ORANGE_JUICE, "foods/fruits/orange");
		generateJuice(output, FarmingRegistry.CHERRY_JUICE, "foods/fruits/cherry");
		generateJuice(output, FarmingRegistry.PEAR_JUICE, "foods/fruits/pear");
		generateJuice(output, FarmingRegistry.BANANA_JUICE, "foods/fruits/banana");
		generateJuice(output, FarmingRegistry.GRAPE_JUICE, "foods/fruits/grape");
		generateJuice(output, FarmingRegistry.MANGO_JUICE, "foods/fruits/mango");
		generateJuice(output, FarmingRegistry.PINEAPPLE_JUICE, "foods/fruits/pineapple");

		generateSmoothie(output, FarmingRegistry.SMOOTHIE_APPLE, "foods/fruits/apple");
		generateSmoothie(output, FarmingRegistry.SMOOTHIE_BANANA, "foods/fruits/banana");
		generateSmoothie(output, FarmingRegistry.SMOOTHIE_CHERRY, "foods/fruits/1cherry");
		generateSmoothie(output, FarmingRegistry.SMOOTHIE_CUCUMBER, "foods/vegetables/cucumber");
		generateSmoothie(output, FarmingRegistry.SMOOTHIE_GRAPE, "foods/fruits/grapes");
		generateSmoothie(output, FarmingRegistry.SMOOTHIE_LEMON, "foods/fruits/lemon");
		generateSmoothie(output, FarmingRegistry.SMOOTHIE_MANGO, "foods/fruits/mango");
		generateSmoothie(output, FarmingRegistry.SMOOTHIE_ORANGE, "foods/fruits/orange");
		generateSmoothie(output, FarmingRegistry.SMOOTHIE_PEAR, "foods/fruits/pear");
		generateSmoothie(output, FarmingRegistry.SMOOTHIE_PINEAPPLE, "foods/fruits/pineapple");

		generateSeed(output, FarmingRegistry.TOMATO_SEEDS, FarmingRegistry.TOMATO.get());
		generateSeed(output, FarmingRegistry.CUCUMBER_SEEDS, FarmingRegistry.CUCUMBER.get());
		generateSeed(output, FarmingRegistry.AUBERGINE_SEEDS, FarmingRegistry.AUBERGINE.get());
		generateSeed(output, FarmingRegistry.GRAPE_SEEDS, FarmingRegistry.GRAPES.get());
		generateSeed(output, FarmingRegistry.PINEAPPLE_SEEDS, FarmingRegistry.PINEAPPLE.get());
		generateSeed(output, FarmingRegistry.CORN_SEEDS, FarmingRegistry.CORN.get());
		generateSeed(output, FarmingRegistry.ONION_SEEDS, FarmingRegistry.ONION.get());
		generateSeed(output, FarmingRegistry.GARLIC_SEEDS, FarmingRegistry.GARLIC.get());
		generateSeed(output, FarmingRegistry.LETTUCE_SEEDS, FarmingRegistry.LETTUCE.get());

		//Furnace recipes
		generateFurnace(output, FarmingRegistry.BAKED_EGG.get(), "eggs");
		generateFurnace(output, Items.BREAD, FarmingRegistry.DOUGH.get());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(FarmingRegistry.COLD_CHOCOLATE_BOTTLE.get()), RecipeCategory.FOOD,
						CookingBookCategory.FOOD, FarmingRegistry.HOT_CHOCOLATE_BOTTLE.get(), 0.25F, 200)
				.unlockedBy("has_item", has(FarmingRegistry.COLD_CHOCOLATE_BOTTLE.get()))
				.save(output, FarmingRegistry.HOT_CHOCOLATE_BOTTLE.getId().withPrefix("cooking/").toString());
		SimpleCookingRecipeBuilder.smelting(DataComponentIngredient.of(true, waterBottle), RecipeCategory.FOOD,
						CookingBookCategory.FOOD, FarmingRegistry.HOT_WATER.get(), 0.25F, 200)
				.unlockedBy("has_item", has(Items.POTION))
				.save(output, FarmingRegistry.HOT_WATER.getId().withPrefix("cooking/").toString());

		//Mint Tea
		shapeless(RecipeCategory.FOOD, FarmingRegistry.MINT_TEA.get())
				.requires(FarmingRegistry.MINT.get())
				.requires(FarmingRegistry.HOT_WATER.get())
				.unlockedBy("has_mint", has(FarmingRegistry.MINT.get()))
				.unlockedBy("has_hot_water", has(FarmingRegistry.HOT_WATER.get()))
				.save(output);

		//Soup
		generateSoup(output, FarmingRegistry.CARROT_SOUP, "foods/vegetables/carrot");
		generateNoodleSoup(output, FarmingRegistry.CHICKEN_NOODLE_SOUP, "foods/vegetables/onion", "foods/vegetables/carrot", "foods/raw_chicken");
		generateSoup(output, FarmingRegistry.CORN_SOUP, "foods/vegetables/corn");
		generateSoup(output, FarmingRegistry.CUCUMBER_SOUP, "foods/vegetables/cucumber");
		generateSoup(output, FarmingRegistry.ONION_SOUP, "foods/vegetables/onion");
		generateSoup(output, FarmingRegistry.POTATO_SOUP, "foods/vegetables/potato");
		generateSoup(output, FarmingRegistry.TOMATO_SOUP, "foods/vegetables/tomato");

		//Salad
		generateSalad(output, FarmingRegistry.FRUIT_SALAD, "foods/fruits", "foods/fruits");
		generateSalad(output, FarmingRegistry.SALAD, "foods/vegetables/lettuce", "foods/vegetables/tomato", "foods/vegetables/onion");

		//Dough
		TagKey<Item> saltTag = createTag("foods/edible_salt");
		shapeless(RecipeCategory.MISC, FarmingRegistry.FLOUR.get())
				.requires(Tags.Items.CROPS_WHEAT)
				.requires(FarmingRegistry.MORTAR_AND_PESTLE.get())
				.unlockedBy("has_wheat", has(Tags.Items.CROPS_WHEAT))
				.unlockedBy("has_mortar_and_pestle", has(FarmingRegistry.MORTAR_AND_PESTLE.get()))
				.save(output);

		shapeless(RecipeCategory.MISC, FarmingRegistry.DOUGH.get())
				.requires(DataComponentIngredient.of(true, waterBottle))
				.requires(saltTag)
				.requires(FLOUR_TAG)
				.unlockedBy("has_water", has(Items.POTION))
				.unlockedBy("has_salt", has(saltTag))
				.unlockedBy("has_flour", has(FLOUR_TAG))
				.save(output);
		shapeless(RecipeCategory.MISC, FarmingRegistry.DOUGH.get())
				.requires(Items.WATER_BUCKET)
				.requires(saltTag)
				.requires(FLOUR_TAG)
				.unlockedBy("has_water", has(Items.WATER_BUCKET))
				.unlockedBy("has_salt", has(saltTag))
				.unlockedBy("has_flour", has(FLOUR_TAG))
				.save(output, FarmingRegistry.DOUGH.getId().withSuffix("_with_bucket").toString());

		//Salt
		shapeless(RecipeCategory.MISC, FarmingRegistry.SALT.get(), 3)
				.requires(FarmingRegistry.POT.get())
				.requires(Items.WATER_BUCKET)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water_bucket", has(Items.WATER_BUCKET))
				.save(output, FarmingRegistry.SALT.getId().withSuffix("_alt").toString());

		shapeless(RecipeCategory.MISC, FarmingRegistry.SALT.get())
				.requires(FarmingRegistry.POT.get())
				.requires(DataComponentIngredient.of(true, waterBottle))
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water_bottle", has(Items.GLASS_BOTTLE))
				.save(output);

		//Sliced bread
		shapeless(RecipeCategory.MISC, FarmingRegistry.SLICED_BREAD.get(), 2)
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.save(output);

		//Burger
		TagKey<Item> cookedBeefTag = createTag("foods/cooked_beef");
		TagKey<Item> lettuceTag = createTag("foods/vegetables/lettuce");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.HAMBURGER.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.requires(cookedBeefTag)
				.requires(lettuceTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.unlockedBy("has_cooked_beef", has(cookedBeefTag))
				.unlockedBy("has_lettuce", has(lettuceTag))
				.save(output);
		TagKey<Item> cheeseTag = createTag("foods/cheeses/normal");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.CHEESEBURGER.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.requires(cookedBeefTag)
				.requires(cheeseTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.unlockedBy("has_cooked_beef", has(cookedBeefTag))
				.unlockedBy("has_cheese", has(cheeseTag))
				.save(output);
		TagKey<Item> cookedChickenTag = createTag("foods/cooked_chicken");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.CHICKENBURGER.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.requires(cookedChickenTag)
				.requires(cheeseTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.unlockedBy("has_cooked_chicken", has(cookedChickenTag))
				.unlockedBy("has_cheese", has(cheeseTag))
				.save(output);

		//Cheese
		TagKey<Item> milkTag = createTag("milk");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.CHEESE.get())
				.requires(FarmingRegistry.POT.get())
				.requires(milkTag)
				.requires(saltTag)
				.unlockedBy("has_water", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_milk", has(milkTag))
				.unlockedBy("has_salt", has(saltTag))
				.save(output);

		//Egg
		TagKey<Item> waterTag = createTag("water");
		TagKey<Item> eggsTag = createTag("eggs");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.BOILED_EGG.get())
				.requires(FarmingRegistry.POT.get())
				.requires(waterTag)
				.requires(eggsTag)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water", has(waterTag))
				.unlockedBy("has_egg", has(eggsTag))
				.save(output);


		//Stock
		shapeless(RecipeCategory.MISC, FarmingRegistry.STOCK.get(), 2)
				.requires(FarmingRegistry.POT.get())
				.requires(waterTag)
				.requires(Items.BOWL)
				.requires(Tags.Items.FOODS_VEGETABLE)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water", has(waterTag))
				.unlockedBy("has_bowl", has(Items.BOWL))
				.unlockedBy("has_vegetables", has(Tags.Items.FOODS_VEGETABLE))
				.save(output);
		shapeless(RecipeCategory.MISC, FarmingRegistry.STOCK.get(), 2)
				.requires(FarmingRegistry.POT.get())
				.requires(waterTag)
				.requires(Items.BOWL)
				.requires(Tags.Items.FOODS_RAW_MEAT)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_water", has(waterTag))
				.unlockedBy("has_bowl", has(Items.BOWL))
				.unlockedBy("has_rawmeats", has(Tags.Items.FOODS_RAW_MEAT))
				.save(output, FarmingRegistry.STOCK.getId().withSuffix("_alt").toString());

		//Gold fruit
		generateGolden(output, FarmingRegistry.GOLDEN_LEMON, FarmingRegistry.LEMON);
		generateGolden(output, FarmingRegistry.GOLDEN_ORANGE, FarmingRegistry.ORANGE);

		//Pizza
		generatePizza(output, FarmingRegistry.PINEAPPLE_PIZZA, "foods/vegetables/tomato", "foods/fruits/pineapple");
		generatePizza(output, FarmingRegistry.CHEESE_PIZZA, "foods/vegetables/tomato", "foods/cheeses/normal");
		generatePizza(output, FarmingRegistry.BACON_PIZZA, "foods/vegetables/tomato", "foods/raw_beef");

		//Sandwich
		generateSandwich(output, FarmingRegistry.JC_SANDWICH, List.of("foods/cheeses/normal"), FarmingRegistry.JAM.get());
		generateSandwich(output, FarmingRegistry.EGG_SANDWICH, List.of(), FarmingRegistry.BAKED_EGG.get());
		generateSandwichAlt(output, FarmingRegistry.EGG_SANDWICH, List.of(), FarmingRegistry.BOILED_EGG.get());
		generateSandwich(output, FarmingRegistry.BACON_SANDWICH, List.of("foods/vegetables/tomato", "foods/cooked_beef"));
		generateSandwich(output, FarmingRegistry.CHICKEN_SANDWICH, List.of("foods/cooked_chicken"));

		//Chocolate
		shapeless(RecipeCategory.FOOD, FarmingRegistry.COLD_CHOCOLATE_BOTTLE.get())
				.requires(Items.COCOA_BEANS)
				.requires(FarmingRegistry.MILK_BOTTLE.get())
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_milk_bottle", has(FarmingRegistry.MILK_BOTTLE.get()))
				.save(output);

		TagKey<Item> sugarTag = createTag("sugar");
		shaped(RecipeCategory.FOOD, FarmingRegistry.CHOCOLATE_BAR.get())
				.pattern("CSC")
				.pattern("CSC")
				.pattern("CSC")
				.define('C', Items.COCOA_BEANS)
				.define('S', sugarTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_sugar", has(sugarTag))
				.save(output);

		TagKey<Item> mintTag = createTag("herbs/mint");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.MINT_CHOCOLATE_BAR.get())
				.requires(mintTag)
				.requires(FarmingRegistry.CHOCOLATE_BAR.get())
				.unlockedBy("has_mint", has(mintTag))
				.unlockedBy("has_chocolate_bar", has(FarmingRegistry.CHOCOLATE_BAR.get()))
				.save(output);
		shaped(RecipeCategory.TOOLS, FarmingRegistry.CHOCOLATE_CANDY.get(), 2)
				.pattern(" C ")
				.pattern("CSC")
				.pattern(" C ")
				.define('C', Items.COCOA_BEANS)
				.define('S', sugarTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_sugar", has(sugarTag))
				.save(output);
		TagKey<Item> bananaTag = createTag("foods/fruits/banana");
		shaped(RecipeCategory.FOOD, FarmingRegistry.CHOCOLATE_BANANA.get())
				.pattern(" C")
				.pattern("CF")
				.define('C', Items.COCOA_BEANS)
				.define('F', bananaTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_banana", has(bananaTag))
				.save(output);
		TagKey<Item> cherryTag = createTag("foods/fruits/cherry");
		shaped(RecipeCategory.FOOD, FarmingRegistry.CHOCOLATE_CHERRY.get())
				.pattern(" C")
				.pattern("CF")
				.define('C', Items.COCOA_BEANS)
				.define('F', cherryTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_cherry", has(cherryTag))
				.save(output);

		//Pasta
		shapeless(RecipeCategory.MISC, FarmingRegistry.PASTA.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.OLIVE_OIL.get())
				.requires(FarmingRegistry.DOUGH.get())
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_olive_oil", has(FarmingRegistry.OLIVE_OIL.get()))
				.unlockedBy("has_dough", has(FarmingRegistry.DOUGH.get()))
				.save(output);
		//Spaghetti
		TagKey<Item> tomatoTag = createTag("foods/vegetables/tomato");
		TagKey<Item> rawBeefTag = createTag("foods/raw_beef");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.SPAGHETTI.get())
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
				.save(output);

		//Fries
		TagKey<Item> potatoTag = createTag("foods/vegetables/potato");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.RAW_FRIES.get(), 2)
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(potatoTag)
				.requires(potatoTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_potato", has(potatoTag))
				.save(output);
		shapeless(RecipeCategory.FOOD, FarmingRegistry.FRIES.get())
				.requires(FarmingRegistry.POT.get())
				.requires(FarmingRegistry.OLIVE_OIL.get())
				.requires(FarmingRegistry.RAW_FRIES.get())
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_olive_oil", has(FarmingRegistry.OLIVE_OIL.get()))
				.unlockedBy("has_raw_fries", has(FarmingRegistry.RAW_FRIES.get()))
				.save(output);
		TagKey<Item> rawFishTag = createTag("foods/raw_fish");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.FISH_AND_CHIPS.get())
				.requires(FarmingRegistry.POT.get())
				.requires(FarmingRegistry.OLIVE_OIL.get())
				.requires(FarmingRegistry.RAW_FRIES.get())
				.requires(rawFishTag)
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_olive_oil", has(FarmingRegistry.OLIVE_OIL.get()))
				.unlockedBy("has_raw_fries", has(FarmingRegistry.RAW_FRIES.get()))
				.unlockedBy("has_raw_fish", has(rawFishTag))
				.save(output);
		TagKey<Item> cookedFishTag = createTag("foods/cooked_fish");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.FISH_AND_CHIPS.get())
				.requires(FarmingRegistry.FRIES.get())
				.requires(cookedFishTag)
				.unlockedBy("has_fries", has(FarmingRegistry.FRIES.get()))
				.unlockedBy("has_cooked_fish", has(cookedFishTag))
				.save(output, FarmingRegistry.FISH_AND_CHIPS.getId().withSuffix("_alt").toString());

		//Potato chips
		shapeless(RecipeCategory.FOOD, FarmingRegistry.POTATO_CHIPS.get())
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
				.save(output);
		shapeless(RecipeCategory.FOOD, FarmingRegistry.GUAC_AND_CHIPS.get())
				.requires(FarmingRegistry.POTATO_CHIPS.get())
				.requires(FarmingRegistry.GUACAMOLE.get())
				.unlockedBy("has_potato_chips", has(FarmingRegistry.POTATO_CHIPS.get()))
				.unlockedBy("has_guacamole", has(FarmingRegistry.GUACAMOLE.get()))
				.save(output);

		//Quac
		TagKey<Item> avocadoTag = createTag("foods/fruits/avocado");
		shapeless(RecipeCategory.FOOD, FarmingRegistry.GUACAMOLE.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(avocadoTag)
				.requires(Items.BOWL)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_avocado", has(avocadoTag))
				.unlockedBy("has_bowl", has(Items.BOWL))
				.save(output);

		//Jam
		TagKey<Item> fruitsTag = Tags.Items.FOODS_FRUIT;
		shapeless(RecipeCategory.FOOD, FarmingRegistry.JAM.get())
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
				.save(output);


		//Rake
		generateRake(output, FarmingRegistry.WOODEN_RAKE, ItemTags.PLANKS);
		generateRake(output, FarmingRegistry.STONE_RAKE, Tags.Items.COBBLESTONES);
		generateRake(output, FarmingRegistry.IRON_RAKE, Tags.Items.INGOTS_IRON);
		generateRake(output, FarmingRegistry.GOLD_RAKE, Tags.Items.INGOTS_GOLD);
		generateRake(output, FarmingRegistry.DIAMOND_RAKE, Tags.Items.GEMS_DIAMOND);

		//Utensils
		shaped(RecipeCategory.TOOLS, FarmingRegistry.POT.get())
				.pattern("ISI")
				.pattern(" I ")
				.define('I', Tags.Items.INGOTS_IRON)
				.define('S', Tags.Items.STONES)
				.unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_stone", has(Tags.Items.STONES))
				.save(output);
		shaped(RecipeCategory.TOOLS, FarmingRegistry.CUTTING_BOARD.get())
				.pattern(" I ")
				.pattern("SPP")
				.define('I', Tags.Items.INGOTS_IRON)
				.define('S', Tags.Items.RODS_WOODEN)
				.define('P', ItemTags.PLANKS)
				.unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_stick", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_planks", has(ItemTags.PLANKS))
				.save(output);
		shaped(RecipeCategory.TOOLS, FarmingRegistry.MORTAR_AND_PESTLE.get())
				.pattern(" S")
				.pattern("B ")
				.define('S', Tags.Items.INGOTS_IRON)
				.define('B', Tags.Items.STONES)
				.unlockedBy("has_stick", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_stone", has(Tags.Items.STONES))
				.save(output);

		//Misc
		shaped(RecipeCategory.MISC, FarmingRegistry.CROP_STICK.get())
				.pattern("SS")
				.pattern("SS")
				.define('S', Tags.Items.RODS_WOODEN)
				.unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN))
				.save(output);

		//Scarecrow
		shaped(RecipeCategory.MISC, FarmingRegistry.SCARECROW.get())
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
				.save(output);

		//Olive Oil
		TagKey<Item> oliveTag = createTag("foods/vegetables/olive");
		new PistonRecipeBuilder(FarmingRegistry.OLIVE_OIL.get(), 1, Ingredient.of(tagSet(oliveTag)))
				.unlockedBy("has_olive", has(FarmingRegistry.OLIVE.get()))
				.save(output, FarmingRegistry.OLIVE_OIL.getId().withPrefix("piston/").toString());
	}

	private void generateFurnace(RecipeOutput recipeOutput, Item output, String ingredientTag) {
		TagKey<Item> itemTag = createTag(ingredientTag);
		Identifier id = EnhancedFarming.modLoc(BuiltInRegistries.ITEM.getKey(output).getPath()).withPrefix("cooking/");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(tagSet(itemTag)), RecipeCategory.FOOD, CookingBookCategory.FOOD, output, 0.35F, 200)
				.unlockedBy("has_item", has(itemTag))
				.save(recipeOutput, id.toString());

		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(tagSet(itemTag)), RecipeCategory.FOOD, output, 0.35F, 600)
				.unlockedBy("has_item", has(itemTag))
				.save(recipeOutput, id.withSuffix("_from_campfire").toString());
	}

	private void generateFurnace(RecipeOutput recipeOutput, Item output, Item ingredient) {
		Identifier id = EnhancedFarming.modLoc(BuiltInRegistries.ITEM.getKey(output).getPath()).withPrefix("cooking/");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, CookingBookCategory.FOOD, output, 0.35F, 200)
				.unlockedBy("has_item", has(ingredient))
				.save(recipeOutput, id.toString());

		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, output, 0.35F, 600)
				.unlockedBy("has_item", has(ingredient))
				.save(recipeOutput, id.withSuffix("_from_campfire").toString());
	}

	private void generateJuice(RecipeOutput recipeOutput, DeferredItem<? extends Item> juice, String tag) {
		TagKey<Item> itemTag = createTag(tag);
		final ItemStackTemplate waterBottle = new ItemStackTemplate(Items.POTION);

		shapeless(RecipeCategory.FOOD, juice.get())
				.requires(DataComponentIngredient.of(true, waterBottle))
				.requires(itemTag)
				.unlockedBy("has_item", has(itemTag))
				.save(recipeOutput, juice.getId().withPrefix("juice/").toString());
	}

	private void generateSmoothie(RecipeOutput recipeOutput, DeferredItem<? extends Item> juice, String tag) {
		TagKey<Item> itemTag = createTag(tag);

		shapeless(RecipeCategory.FOOD, juice.get())
				.requires(FarmingRegistry.MILK_BOTTLE.get())
				.requires(itemTag)
				.requires(Items.SNOWBALL)
				.unlockedBy("has_milk_bottle", has(FarmingRegistry.MILK_BOTTLE.get()))
				.unlockedBy("has_item", has(itemTag))
				.unlockedBy("has_snowball", has(Items.SNOWBALL))
				.save(recipeOutput, juice.getId().withPrefix("smoothie/").toString());
	}

	private void generatePie(RecipeOutput recipeOutput, DeferredItem<? extends Item> juice, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = shapeless(RecipeCategory.FOOD, juice.get())
				.requires(FLOUR_TAG)
				.unlockedBy("has_flour", has(FLOUR_TAG));
		List<String> knownTags = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String replace = "has_" + itemTag.location().getPath().replace(":", "_");
			String hasTag = replace;
			if (!knownTags.contains(hasTag)) {
				builder = builder.unlockedBy(replace, has(itemTag));
				knownTags.add(hasTag);
			}
		}
		builder.save(recipeOutput, juice.getId().withPrefix("pie/").toString());
	}

	private void generateSoup(RecipeOutput recipeOutput, DeferredItem<? extends Item> soup, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = shapeless(RecipeCategory.FOOD, soup.get())
				.requires(FarmingRegistry.POT.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.STOCK.get())
				.unlockedBy("has_pot", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_stock", has(FarmingRegistry.STOCK.get()));
		List<String> knownTags = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String replace = itemTag.location().getPath().replace(":", "_");
			String hasTag = "has_" + replace;
			if (!knownTags.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + replace, has(itemTag));
				knownTags.add(hasTag);
			}
		}
		builder.save(recipeOutput, soup.getId().withPrefix("soup/").toString());
	}

	private void generateSalad(RecipeOutput recipeOutput, DeferredItem<? extends Item> salad, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = shapeless(RecipeCategory.FOOD, salad.get())
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
		builder.save(recipeOutput, salad.getId().withPrefix("salad/").toString());
	}

	private void generatePizza(RecipeOutput recipeOutput, DeferredItem<? extends Item> salad, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = shapeless(RecipeCategory.FOOD, salad.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.DOUGH.get())
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_dough", has(FarmingRegistry.DOUGH.get()));

		List<String> knownTags = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String replace = itemTag.location().getPath().replace(":", "_");
			String hasTag = "has_" + replace;
			if (!knownTags.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + replace, has(itemTag));
				knownTags.add(hasTag);
			}
		}
		builder.save(recipeOutput, salad.getId().withPrefix("pizza/").toString());
	}

	private void generateNoodleSoup(RecipeOutput recipeOutput, DeferredItem<? extends Item> juice, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = shapeless(RecipeCategory.FOOD, juice.get())
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
		builder.save(recipeOutput, juice.getId().withPrefix("soup/").toString());
	}

	private void generateSandwich(RecipeOutput recipeOutput, DeferredItem<? extends Item> sandwich, List<String> tags, Item... items) {
		List<TagKey<Item>> itemTags = tags.stream().map(this::createTag).toList();

		ShapelessRecipeBuilder builder = shapeless(RecipeCategory.FOOD, sandwich.get())
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
			Identifier itemLocation = BuiltInRegistries.ITEM.getKey(item);
			if (itemLocation != null) {
				builder = builder.requires(item);
				String hasTag = "has_" + itemLocation.getPath();
				if (!knownUnlocks.contains(hasTag)) {
					builder = builder.unlockedBy("has_" + itemLocation.getPath(), has(item));
					knownUnlocks.add(hasTag);
				}
			}
		}
		builder.save(recipeOutput, sandwich.getId().withPrefix("sandwich/").toString());
	}

	private void generateSandwichAlt(RecipeOutput recipeOutput, DeferredItem<? extends Item> sandwich, List<String> tags, Item... items) {
		List<TagKey<Item>> itemTags = tags.stream().map(this::createTag).toList();

		ShapelessRecipeBuilder builder = shapeless(RecipeCategory.FOOD, sandwich.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(FarmingRegistry.SLICED_BREAD.get())
				.requires(FarmingRegistry.SLICED_BREAD.get())
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_sliced_bread", has(FarmingRegistry.SLICED_BREAD.get()));
		List<String> knownUnlocks = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String replace = itemTag.location().getPath().replace(":", "_");
			String hasTag = "has_" + replace;
			if (!knownUnlocks.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + replace, has(itemTag));
				knownUnlocks.add(hasTag);
			}
		}
		for (Item item : items) {
			Identifier itemLocation = BuiltInRegistries.ITEM.getKey(item);
			if (itemLocation != null) {
				builder = builder.requires(item);
				String hasTag = "has_" + itemLocation.getPath();
				if (!knownUnlocks.contains(hasTag)) {
					builder = builder.unlockedBy("has_" + itemLocation.getPath(), has(item));
					knownUnlocks.add(hasTag);
				}
			}
		}
		builder.save(recipeOutput, sandwich.getId().withPrefix("sandwich/").withSuffix("_alt").toString());
	}

	private void generateSapling(RecipeOutput recipeOutput, DeferredItem<? extends Item> newSapling, ItemLike sapling, String tag) {
		TagKey<Item> itemTag = createTag(tag);
		RecipeOutput conditionOutput = recipeOutput.withConditions(CropToSeedCondition.INSTANCE);
		shapeless(RecipeCategory.MISC, newSapling.get())
				.requires(sapling)
				.requires(itemTag)
				.unlockedBy("has_sapling", has(sapling))
				.unlockedBy("has_item", has(itemTag))
				.save(conditionOutput, newSapling.getId().withPrefix("sapling/").toString());
	}

	private void generateSeed(RecipeOutput recipeOutput, DeferredItem<? extends Item> seed, ItemLike item) {
		RecipeOutput conditionOutput = recipeOutput.withConditions(CropToSeedCondition.INSTANCE);
		shapeless(RecipeCategory.MISC, seed.get())
				.requires(item)
				.unlockedBy("has_item", has(item))
				.save(conditionOutput, seed.getId().withPrefix("seed/").toString());
	}

	private void generateRake(RecipeOutput recipeOutput, DeferredItem<? extends Item> rake, TagKey<Item> material) {
		RecipeOutput conditionOutput = recipeOutput.withConditions(RakeEnabledCondition.INSTANCE);
		shaped(RecipeCategory.TOOLS, rake.get())
				.pattern("X X")
				.pattern("XSX")
				.pattern(" S ")
				.define('X', material)
				.define('S', Tags.Items.RODS_WOODEN)
				.unlockedBy("has_material", has(material))
				.unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN))
				.save(conditionOutput, rake.getId().withPrefix("rake/").toString());
	}

	private void generateGolden(RecipeOutput recipeOutput, DeferredItem<? extends Item> goldFruit, DeferredItem<? extends Item> fruit) {
		shaped(RecipeCategory.FOOD, goldFruit.get())
				.pattern("GGG")
				.pattern("GFG")
				.pattern("GGG")
				.define('G', Tags.Items.NUGGETS_GOLD)
				.define('F', fruit.get())
				.unlockedBy("has_gold_nugget", has(Tags.Items.NUGGETS_GOLD))
				.unlockedBy("has_fruit", has(fruit.get()))
				.save(recipeOutput);
	}

	private TagKey<Item> createTag(String path) {
		return ItemTags.create(Identifier.fromNamespaceAndPath("c", path));
	}

	private static TagKey<Item> createCTag(String path) {
		return ItemTags.create(Identifier.fromNamespaceAndPath("c", path));
	}

	private HolderSet<Item> tagSet(TagKey<Item> tagKey) {
		return this.registries.lookupOrThrow(Registries.ITEM).getOrThrow(tagKey);
	}

	public static class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<Provider> completableFuture) {
			super(output, completableFuture);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
			return new FarmingRecipeProvider(provider, recipeOutput);
		}

		@Override
		public String getName() {
			return "Enhanced Farmning Recipes";
		}
	}
}