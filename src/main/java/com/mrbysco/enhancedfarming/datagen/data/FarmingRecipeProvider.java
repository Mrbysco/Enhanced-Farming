package com.mrbysco.enhancedfarming.datagen.data;

import com.google.gson.JsonObject;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.init.conditions.CropToSeedCondition;
import com.mrbysco.enhancedfarming.init.conditions.RakeEnabledCondition;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
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
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class FarmingRecipeProvider extends RecipeProvider {
	public FarmingRecipeProvider(PackOutput packOutput) {
		super(packOutput);
	}

	private static final TagKey<Item> FLOUR_TAG = createForgeTag("flour/wheat");

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
		final ItemStack waterBottle = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);

		generateSapling(consumer, FarmingRegistry.APPLE_SAPLING_ITEM, Items.OAK_SAPLING, "fruits/apple");
		generateSapling(consumer, FarmingRegistry.LEMON_SAPLING_ITEM, Items.OAK_SAPLING, "fruits/lemon");
		generateSapling(consumer, FarmingRegistry.ORANGE_SAPLING_ITEM, Items.OAK_SAPLING, "fruits/orange");
		generateSapling(consumer, FarmingRegistry.CHERRY_SAPLING_ITEM, Items.OAK_SAPLING, "fruits/cherry");
		generateSapling(consumer, FarmingRegistry.PEAR_SAPLING_ITEM, Items.OAK_SAPLING, "fruits/pear");
		generateSapling(consumer, FarmingRegistry.BANANA_SAPLING_ITEM, Items.JUNGLE_SAPLING, "fruits/banana");
		generateSapling(consumer, FarmingRegistry.AVOCADO_SAPLING_ITEM, Items.ACACIA_SAPLING, "fruits/avocado");
		generateSapling(consumer, FarmingRegistry.MANGO_SAPLING_ITEM, Items.OAK_SAPLING, "fruits/mango");
		generateSapling(consumer, FarmingRegistry.OLIVE_SAPLING_ITEM, Items.ACACIA_SAPLING, "vegetables/olive");

		generatePie(consumer, FarmingRegistry.APPLE_PIE, "sugar", "eggs");
		generatePie(consumer, FarmingRegistry.BANANA_PIE, "sugar", "eggs", "milk");
		generatePie(consumer, FarmingRegistry.CHERRY_PIE, "sugar", "eggs");
		generatePie(consumer, FarmingRegistry.GRAPE_PIE, "sugar", "eggs");
		generatePie(consumer, FarmingRegistry.LEMON_PIE, "sugar", "eggs");
		generatePie(consumer, FarmingRegistry.PEAR_PIE, "sugar", "eggs");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.BACON_AND_EGG_PIE.get())
				.requires(createTag("raw_beef"))
				.requires(createTag("eggs"))
				.requires(createTag("dough/wheat"))
				.unlockedBy("has_beef", has(createTag("raw_beef")))
				.unlockedBy("has_egg", has(createTag("eggs")))
				.unlockedBy("has_dough", has(createTag("dough/wheat")))
				.save(consumer, FarmingRegistry.BACON_AND_EGG_PIE.getId().withPrefix("pie/"));

		generateJuice(consumer, FarmingRegistry.APPLE_JUICE, "fruits/apple");
		generateJuice(consumer, FarmingRegistry.LEMONADE, "fruits/lemon");
		generateJuice(consumer, FarmingRegistry.ORANGE_JUICE, "fruits/orange");
		generateJuice(consumer, FarmingRegistry.CHERRY_JUICE, "fruits/cherry");
		generateJuice(consumer, FarmingRegistry.PEAR_JUICE, "fruits/pear");
		generateJuice(consumer, FarmingRegistry.BANANA_JUICE, "fruits/banana");
		generateJuice(consumer, FarmingRegistry.GRAPE_JUICE, "fruits/grape");
		generateJuice(consumer, FarmingRegistry.MANGO_JUICE, "fruits/mango");
		generateJuice(consumer, FarmingRegistry.PINEAPPLE_JUICE, "fruits/pineapple");

		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_APPLE, "fruits/apple");
		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_BANANA, "fruits/banana");
		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_CHERRY, "fruits/1cherry");
		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_CUCUMBER, "vegetables/cucumber");
		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_GRAPE, "fruits/grapes");
		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_LEMON, "fruits/lemon");
		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_MANGO, "fruits/mango");
		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_ORANGE, "fruits/orange");
		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_PEAR, "fruits/pear");
		generateSmoothie(consumer, FarmingRegistry.SMOOTHIE_PINEAPPLE, "fruits/pineapple");

		generateSeed(consumer, FarmingRegistry.TOMATO_SEEDS, FarmingRegistry.TOMATO.get());
		generateSeed(consumer, FarmingRegistry.CUCUMBER_SEEDS, FarmingRegistry.CUCUMBER.get());
		generateSeed(consumer, FarmingRegistry.AUBERGINE_SEEDS, FarmingRegistry.AUBERGINE.get());
		generateSeed(consumer, FarmingRegistry.GRAPE_SEEDS, FarmingRegistry.GRAPES.get());
		generateSeed(consumer, FarmingRegistry.PINEAPPLE_SEEDS, FarmingRegistry.PINEAPPLE.get());
		generateSeed(consumer, FarmingRegistry.CORN_SEEDS, FarmingRegistry.CORN.get());
		generateSeed(consumer, FarmingRegistry.ONION_SEEDS, FarmingRegistry.ONION.get());
		generateSeed(consumer, FarmingRegistry.GARLIC_SEEDS, FarmingRegistry.GARLIC.get());
		generateSeed(consumer, FarmingRegistry.LETTUCE_SEEDS, FarmingRegistry.LETTUCE.get());

		//Furnace recipes
		generateFurnace(consumer, FarmingRegistry.BAKED_EGG.get(), "eggs");
		generateFurnace(consumer, Items.BREAD, FarmingRegistry.DOUGH.get());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(FarmingRegistry.COLD_CHOCOLATE_BOTTLE.get()), RecipeCategory.FOOD,
						FarmingRegistry.HOT_CHOCOLATE_BOTTLE.get(), 0.25F, 200)
				.unlockedBy("has_item", has(FarmingRegistry.COLD_CHOCOLATE_BOTTLE.get()))
				.save(consumer, FarmingRegistry.HOT_CHOCOLATE_BOTTLE.getId().withPrefix("cooking/"));
		SimpleCookingRecipeBuilder.smelting(StrictNBTIngredient.of(waterBottle), RecipeCategory.FOOD,
						FarmingRegistry.HOT_WATER.get(), 0.25F, 200)
				.unlockedBy("has_item", has(Items.POTION))
				.save(consumer, FarmingRegistry.HOT_WATER.getId().withPrefix("cooking/"));

		//Soup
		generateSoup(consumer, FarmingRegistry.CARROT_SOUP, "vegetables/carrot");
		generateNoodleSoup(consumer, FarmingRegistry.CHICKEN_NOODLE_SOUP, "vegetables/onion", "vegetables/carrot", "raw_chicken");
		generateSoup(consumer, FarmingRegistry.CORN_SOUP, "vegetables/corn");
		generateSoup(consumer, FarmingRegistry.CUCUMBER_SOUP, "vegetables/cucumber");
		generateSoup(consumer, FarmingRegistry.ONION_SOUP, "vegetables/onion");
		generateSoup(consumer, FarmingRegistry.POTATO_SOUP, "vegetables/potato");
		generateSoup(consumer, FarmingRegistry.TOMATO_SOUP, "vegetables/tomato");

		//Salad
		generateSalad(consumer, FarmingRegistry.FRUIT_SALAD, "fruits", "fruits");
		generateSalad(consumer, FarmingRegistry.SALAD, "vegetables/lettuce", "vegetables/tomato", "vegetables/onion");

		//Dough
		TagKey<Item> saltTag = createTag("edible_salt");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.FLOUR.get())
				.requires(Tags.Items.CROPS_WHEAT)
				.requires(FarmingRegistry.MORTAR_AND_PESTLE.get())
				.unlockedBy("has_wheat", has(Tags.Items.CROPS_WHEAT))
				.unlockedBy("has_mortar_and_pestle", has(FarmingRegistry.MORTAR_AND_PESTLE.get()))
				.save(consumer);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.DOUGH.get())
				.requires(StrictNBTIngredient.of(waterBottle))
				.requires(saltTag)
				.requires(FLOUR_TAG)
				.unlockedBy("has_water", has(Items.POTION))
				.unlockedBy("has_salt", has(saltTag))
				.unlockedBy("has_flour", has(FLOUR_TAG))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.DOUGH.get())
				.requires(Items.WATER_BUCKET)
				.requires(saltTag)
				.requires(FLOUR_TAG)
				.unlockedBy("has_water", has(Items.WATER_BUCKET))
				.unlockedBy("has_salt", has(saltTag))
				.unlockedBy("has_flour", has(FLOUR_TAG))
				.save(consumer, FarmingRegistry.DOUGH.getId().withSuffix("_with_bucket"));

		//Sliced bread
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, FarmingRegistry.SLICED_BREAD.get(), 2)
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.save(consumer);

		//Burger
		TagKey<Item> cookedBeefTag = createTag("cooked_beef");
		TagKey<Item> lettuceTag = createTag("vegetables/lettuce");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.HAMBURGER.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.requires(cookedBeefTag)
				.requires(lettuceTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.unlockedBy("has_cooked_beef", has(cookedBeefTag))
				.unlockedBy("has_lettuce", has(lettuceTag))
				.save(consumer);
		TagKey<Item> cheeseTag = createTag("cheeses/normal");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.CHEESEBURGER.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.requires(cookedBeefTag)
				.requires(cheeseTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.unlockedBy("has_cooked_beef", has(cookedBeefTag))
				.unlockedBy("has_cheese", has(cheeseTag))
				.save(consumer);
		TagKey<Item> cookedChickenTag = createTag("cooked_chicken");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.CHICKENBURGER.get())
				.requires(FarmingRegistry.CUTTING_BOARD.get())
				.requires(Items.BREAD)
				.requires(cookedChickenTag)
				.requires(cheeseTag)
				.unlockedBy("has_cutting_board", has(FarmingRegistry.CUTTING_BOARD.get()))
				.unlockedBy("has_bread", has(Items.BREAD))
				.unlockedBy("has_cooked_chicken", has(cookedChickenTag))
				.unlockedBy("has_cheese", has(cheeseTag))
				.save(consumer);

		//Cheese
		TagKey<Item> milkTag = createTag("milk");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.CHEESE.get())
				.requires(FarmingRegistry.POT.get())
				.requires(milkTag)
				.requires(saltTag)
				.unlockedBy("has_water", has(FarmingRegistry.POT.get()))
				.unlockedBy("has_milk", has(milkTag))
				.unlockedBy("has_salt", has(saltTag))
				.save(consumer);

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
				.save(consumer);

		//Gold fruit
		generateGolden(consumer, FarmingRegistry.GOLDEN_LEMON, FarmingRegistry.LEMON);
		generateGolden(consumer, FarmingRegistry.GOLDEN_ORANGE, FarmingRegistry.ORANGE);

		//Pizza
		generatePizza(consumer, FarmingRegistry.PINEAPPLE_PIZZA, "vegetables/tomato", "fruits/pineapple");
		generatePizza(consumer, FarmingRegistry.CHEESE_PIZZA, "vegetables/tomato", "cheeses/normal");
		generatePizza(consumer, FarmingRegistry.BACON_PIZZA, "vegetables/tomato", "raw_beef");

		//Sandwich
		generateSandwich(consumer, FarmingRegistry.JC_SANDWICH, List.of("cheeses/normal"), FarmingRegistry.JAM.get());
		generateSandwich(consumer, FarmingRegistry.EGG_SANDWICH, List.of(), FarmingRegistry.BAKED_EGG.get());
		generateSandwichAlt(consumer, FarmingRegistry.EGG_SANDWICH, List.of(), FarmingRegistry.BOILED_EGG.get());
		generateSandwich(consumer, FarmingRegistry.BACON_SANDWICH, List.of("vegetables/tomato", "cooked_beef"));
		generateSandwich(consumer, FarmingRegistry.CHICKEN_SANDWICH, List.of("cooked_chicken"));

		//Chocolate
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.COLD_CHOCOLATE_BOTTLE.get())
				.requires(Items.COCOA_BEANS)
				.requires(FarmingRegistry.MILK_BOTTLE.get())
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_milk_bottle", has(FarmingRegistry.MILK_BOTTLE.get()))
				.save(consumer);

		TagKey<Item> sugarTag = createTag("sugar");
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FarmingRegistry.CHOCOLATE_BAR.get())
				.pattern("CSC")
				.pattern("CSC")
				.pattern("CSC")
				.define('C', Items.COCOA_BEANS)
				.define('S', sugarTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_sugar", has(sugarTag))
				.save(consumer);

		TagKey<Item> mintTag = createTag("herbs/mint");
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FarmingRegistry.MINT_CHOCOLATE_BAR.get())
				.requires(mintTag)
				.requires(FarmingRegistry.CHOCOLATE_BAR.get())
				.unlockedBy("has_mint", has(mintTag))
				.unlockedBy("has_chocolate_bar", has(FarmingRegistry.CHOCOLATE_BAR.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FarmingRegistry.CHOCOLATE_CANDY.get(), 2)
				.pattern(" C ")
				.pattern("CSC")
				.pattern(" C ")
				.define('C', Items.COCOA_BEANS)
				.define('S', sugarTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_sugar", has(sugarTag))
				.save(consumer);
		TagKey<Item> bananaTag = createTag("fruits/banana");
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FarmingRegistry.CHOCOLATE_BANANA.get())
				.pattern(" C")
				.pattern("CF")
				.define('C', Items.COCOA_BEANS)
				.define('F', bananaTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_banana", has(bananaTag))
				.save(consumer);
		TagKey<Item> cherryTag = createTag("fruits/cherry");
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FarmingRegistry.CHOCOLATE_CHERRY.get())
				.pattern(" C")
				.pattern("CF")
				.define('C', Items.COCOA_BEANS)
				.define('F', cherryTag)
				.unlockedBy("has_cocoa_beans", has(Items.COCOA_BEANS))
				.unlockedBy("has_cherry", has(cherryTag))
				.save(consumer);

		//Rake
		generateRake(consumer, FarmingRegistry.WOODEN_RAKE, ItemTags.PLANKS);
		generateRake(consumer, FarmingRegistry.STONE_RAKE, Tags.Items.COBBLESTONE);
		generateRake(consumer, FarmingRegistry.IRON_RAKE, Tags.Items.INGOTS_IRON);
		generateRake(consumer, FarmingRegistry.GOLD_RAKE, Tags.Items.INGOTS_GOLD);
		generateRake(consumer, FarmingRegistry.DIAMOND_RAKE, Tags.Items.GEMS_DIAMOND);

		//Utensils
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FarmingRegistry.POT.get())
				.pattern("ISI")
				.pattern(" I ")
				.define('I', Tags.Items.INGOTS_IRON)
				.define('S', Tags.Items.STONE)
				.unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_stone", has(Tags.Items.STONE))
				.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FarmingRegistry.CUTTING_BOARD.get())
				.pattern(" I ")
				.pattern("SPP")
				.define('I', Tags.Items.INGOTS_IRON)
				.define('S', Tags.Items.RODS_WOODEN)
				.define('P', ItemTags.PLANKS)
				.unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_stick", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_planks", has(ItemTags.PLANKS))
				.save(consumer);
		ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, FarmingRegistry.MORTAR_AND_PESTLE.get())
				.pattern(" S")
				.pattern("B ")
				.define('S', Tags.Items.INGOTS_IRON)
				.define('B', Tags.Items.STONE)
				.unlockedBy("has_stick", has(Tags.Items.INGOTS_IRON))
				.unlockedBy("has_stone", has(Tags.Items.STONE))
				.save(consumer);
	}

	private void generateFurnace(Consumer<FinishedRecipe> consumer, Item output, String ingredientTag) {
		TagKey<Item> itemTag = createTag(ingredientTag);
		ResourceLocation id = new ResourceLocation(Reference.MOD_ID, ForgeRegistries.ITEMS.getKey(output).getPath()).withPrefix("cooking/");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemTag), RecipeCategory.FOOD, output, 0.35F, 200)
				.unlockedBy("has_item", has(itemTag))
				.save(consumer, id);

		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(itemTag), RecipeCategory.FOOD, output, 0.35F, 600)
				.unlockedBy("has_item", has(itemTag))
				.save(consumer, id.withSuffix("_from_campfire"));
	}

	private void generateFurnace(Consumer<FinishedRecipe> consumer, Item output, Item ingredient) {
		ResourceLocation id = new ResourceLocation(Reference.MOD_ID, ForgeRegistries.ITEMS.getKey(output).getPath()).withPrefix("cooking/");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, output, 0.35F, 200)
				.unlockedBy("has_item", has(ingredient))
				.save(consumer, id);

		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, output, 0.35F, 600)
				.unlockedBy("has_item", has(ingredient))
				.save(consumer, id.withSuffix("_from_campfire"));
	}

	private void generateJuice(Consumer<FinishedRecipe> consumer, RegistryObject<Item> juice, String tag) {
		TagKey<Item> itemTag = createTag(tag);
		ItemStack waterBottle = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, juice.get())
				.requires(StrictNBTIngredient.of(waterBottle))
				.requires(itemTag)
				.unlockedBy("has_item", has(itemTag))
				.save(consumer, juice.getId().withPrefix("juice/"));
	}

	private void generateSmoothie(Consumer<FinishedRecipe> consumer, RegistryObject<Item> juice, String tag) {
		TagKey<Item> itemTag = createTag(tag);

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, juice.get())
				.requires(FarmingRegistry.MILK_BOTTLE.get())
				.requires(itemTag)
				.requires(Items.SNOWBALL)
				.unlockedBy("has_milk_bottle", has(FarmingRegistry.MILK_BOTTLE.get()))
				.unlockedBy("has_item", has(itemTag))
				.unlockedBy("has_snowball", has(Items.SNOWBALL))
				.save(consumer, juice.getId().withPrefix("smoothie/"));
	}

	private void generatePie(Consumer<FinishedRecipe> consumer, RegistryObject<Item> juice, String... tags) {
		List<TagKey<Item>> itemTags = Arrays.stream(tags).map(this::createTag).toList();

		ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, juice.get())
				.requires(FLOUR_TAG)
				.unlockedBy("has_flour", has(FLOUR_TAG));
		List<String> knownTags = new ArrayList<>();
		for (TagKey<Item> itemTag : itemTags) {
			builder = builder.requires(itemTag);
			String hasTag = "has_" + itemTag.location().getPath().replace(":", "_");
			if (!knownTags.contains(hasTag)) {
				builder = builder.unlockedBy("has_" + itemTag.location().getPath().replace(":", "_"), has(itemTag));
				knownTags.add(hasTag);
			}
		}
		builder.save(consumer, juice.getId().withPrefix("pie/"));
	}

	private void generateSoup(Consumer<FinishedRecipe> consumer, RegistryObject<Item> soup, String... tags) {
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
		builder.save(consumer, soup.getId().withPrefix("soup/"));
	}

	private void generateSalad(Consumer<FinishedRecipe> consumer, RegistryObject<Item> salad, String... tags) {
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
		builder.save(consumer, salad.getId().withPrefix("salad/"));
	}

	private void generatePizza(Consumer<FinishedRecipe> consumer, RegistryObject<Item> salad, String... tags) {
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
		builder.save(consumer, salad.getId().withPrefix("pizza/"));
	}

	private void generateNoodleSoup(Consumer<FinishedRecipe> consumer, RegistryObject<Item> juice, String... tags) {
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
		builder.save(consumer, juice.getId().withPrefix("soup/"));
	}

	private void generateSandwich(Consumer<FinishedRecipe> consumer, RegistryObject<Item> sandwich, List<String> tags, Item... items) {
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
			ResourceLocation itemLocation = ForgeRegistries.ITEMS.getKey(item);
			if (itemLocation != null) {
				builder = builder.requires(item);
				String hasTag = "has_" + itemLocation.getPath();
				if (!knownUnlocks.contains(hasTag)) {
					builder = builder.unlockedBy("has_" + itemLocation.getPath(), has(item));
					knownUnlocks.add(hasTag);
				}
			}
		}
		builder.save(consumer, sandwich.getId().withPrefix("sandwich/"));
	}

	private void generateSandwichAlt(Consumer<FinishedRecipe> consumer, RegistryObject<Item> sandwich, List<String> tags, Item... items) {
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
			ResourceLocation itemLocation = ForgeRegistries.ITEMS.getKey(item);
			if (itemLocation != null) {
				builder = builder.requires(item);
				String hasTag = "has_" + itemLocation.getPath();
				if (!knownUnlocks.contains(hasTag)) {
					builder = builder.unlockedBy("has_" + itemLocation.getPath(), has(item));
					knownUnlocks.add(hasTag);
				}
			}
		}
		builder.save(consumer, sandwich.getId().withPrefix("sandwich/").withSuffix("_alt"));
	}

	private void generateSapling(Consumer<FinishedRecipe> consumer, RegistryObject<Item> newSapling, ItemLike sapling, String tag) {
		TagKey<Item> itemTag = createTag(tag);
		ConditionalRecipe.builder()
				.addCondition(new CropToSeedCondition())
				.addRecipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, newSapling.get())
						.requires(sapling)
						.requires(itemTag)
						.unlockedBy("has_sapling", has(sapling))
						.unlockedBy("has_item", has(itemTag))::save
				).build(consumer, newSapling.getId().withPrefix("sapling/"));
	}

	private void generateSeed(Consumer<FinishedRecipe> consumer, RegistryObject<Item> seed, ItemLike item) {
		ConditionalRecipe.builder()
				.addCondition(new CropToSeedCondition())
				.addRecipe(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, seed.get())
						.requires(item)
						.unlockedBy("has_item", has(item))::save
				).build(consumer, seed.getId().withPrefix("seed/"));
	}

	private void generateRake(Consumer<FinishedRecipe> consumer, RegistryObject<Item> rake, TagKey<Item> material) {
		ConditionalRecipe.builder()
				.addCondition(new RakeEnabledCondition())
				.addRecipe(
						ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, rake.get())
								.pattern("X X")
								.pattern("XSX")
								.pattern(" S ")
								.define('X', material)
								.define('S', Tags.Items.RODS_WOODEN)
								.unlockedBy("has_material", has(material))
								.unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN))
								::save
				).build(consumer, rake.getId().withPrefix("rake/"));
	}

	private void generateGolden(Consumer<FinishedRecipe> consumer, RegistryObject<Item> goldFruit, RegistryObject<Item> fruit) {
		ConditionalRecipe.builder()
				.addCondition(new RakeEnabledCondition())
				.addRecipe(
						ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, goldFruit.get())
								.pattern("GGG")
								.pattern("GFG")
								.pattern("GGG")
								.define('G', Tags.Items.NUGGETS_GOLD)
								.define('F', fruit.get())
								.unlockedBy("has_gold_nugget", has(Tags.Items.NUGGETS_GOLD))
								.unlockedBy("has_fruit", has(fruit.get()))
								::save
				).build(consumer, goldFruit.getId());
	}

	private TagKey<Item> createTag(String name) {
		return ItemTags.create(new ResourceLocation("forge", name));
	}

	private static TagKey<Item> createForgeTag(String name) {
		return ItemTags.create(new ResourceLocation("forge", name));
	}

	@Override
	protected @Nullable CompletableFuture<?> saveAdvancement(CachedOutput output, FinishedRecipe finishedRecipe, JsonObject advancementJson) {
		return null;
	}
}