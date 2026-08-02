package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FarmingItemTagProvider extends ItemTagsProvider {

	public FarmingItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider, EnhancedFarming.MOD_ID);
	}

	private final String VEGETABLES = "foods/vegetables";
	private final String HERBS = "herbs";
	private final String RAWMEATS = "foods/raw_meats";
	private final String RAW_BEEF = "foods/raw_beef";
	private final String RAW_CHICKEN = "foods/raw_chicken";
	private final String COOKED_BEEF = "foods/cooked_beef";
	private final String COOKED_CHICKEN = "foods/cooked_chicken";
	private final String COOKED_FISH = "foods/cooked_fish";
	private final String FRUITS = "foods/fruits";
	private final String FISH = "foods/fish";
	private final String SUGAR = "sugar";
	private final String WATER = "water";
	private final String MILK = "milk";
	private final String SEEDS = "seeds";
	private final String DOUGH = "dough";
	private final String CHEESES = "foods/cheeses";
	private final String SALAD_INGREDIENTS = "salad_ingredients";
	private final String SALT = "foods/edible_salt";
	private final String FLOUR = "flour";

	@Override
	public void addTags(HolderLookup.Provider lookupProvider) {
		this.tag(FarmingTags.HOT_ITEMS).add(FarmingRegistry.HOT_WATER.getKey(), FarmingRegistry.HOT_CHOCOLATE_BOTTLE.getKey(), FarmingRegistry.MINT_TEA.getKey());

		addCrop(FarmingRegistry.AUBERGINE, FarmingRegistry.AUBERGINE_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.CORN, FarmingRegistry.CORN_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.CUCUMBER, FarmingRegistry.CUCUMBER_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.GARLIC, FarmingRegistry.GARLIC_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.LETTUCE, FarmingRegistry.LETTUCE_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.MINT, FarmingRegistry.MINT_SEEDS, HERBS);
		addCrop(FarmingRegistry.OLIVE, null, VEGETABLES);
		addCrop(FarmingRegistry.ONION, FarmingRegistry.ONION_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.TOMATO, FarmingRegistry.TOMATO_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.PINEAPPLE, FarmingRegistry.PINEAPPLE_SEEDS, FRUITS);
		addCrop(FarmingRegistry.GRAPES, FarmingRegistry.GRAPE_SEEDS, FRUITS);

		addCategory(VEGETABLES, Items.POTATO, Items.CARROT, Items.BEETROOT);
		addCategory(RAWMEATS, Items.BEEF, Items.CHICKEN, Items.MUTTON, Items.PORKCHOP, Items.RABBIT);
		addCategory(FRUITS, Items.APPLE, FarmingRegistry.BANANA.get(), FarmingRegistry.CHERRY.get(),
				FarmingRegistry.LEMON.get(), FarmingRegistry.MANGO.get(), FarmingRegistry.ORANGE.get(),
				FarmingRegistry.PEAR.get(), FarmingRegistry.AVOCADO.get());
		addCategory(FISH, "foods/raw_fish", Items.COD, Items.SALMON);
		addCategory(SUGAR, Items.SUGAR);
		addCategory(WATER, Items.WATER_BUCKET);
		addCategory(MILK, Items.MILK_BUCKET);
		addCategory(SEEDS, FarmingRegistry.NETHER_FLOWER_SEEDS.get());

		addCategoryWithType(DOUGH, "wheat", FarmingRegistry.DOUGH.get());
		addCategoryWithType(FLOUR, "wheat", FarmingRegistry.FLOUR.get());
		addCategoryWithType(CHEESES, "normal", FarmingRegistry.CHEESE.get());
		addCategory(SALAD_INGREDIENTS, FarmingRegistry.ONION.get(), FarmingRegistry.OLIVE.get());

		addRegular(RAW_BEEF, Items.BEEF);
		addRegular(RAW_CHICKEN, Items.CHICKEN);
		addRegular(COOKED_BEEF, Items.COOKED_BEEF);
		addRegular(COOKED_CHICKEN, Items.COOKED_CHICKEN);
		addRegular(SALT, FarmingRegistry.SALT.get());

		this.tag(Tags.Items.FOODS_SOUP).add(
				FarmingRegistry.CARROT_SOUP.getKey(), FarmingRegistry.CHICKEN_NOODLE_SOUP.getKey(),
				FarmingRegistry.CORN_SOUP.getKey(), FarmingRegistry.CUCUMBER_SOUP.getKey(), FarmingRegistry.ONION_SOUP.getKey(),
				FarmingRegistry.POTATO_SOUP.getKey(), FarmingRegistry.TOMATO_SOUP.getKey());

	}

	private void addRegular(String category, Item... items) {
		TagKey<Item> mainTag = createCommonTag(category);
		for (Item item : items) {
			this.tag(mainTag).add(item.builtInRegistryHolder().key());
		}
	}

	private void addCategory(String category, Item... items) {
		TagKey<Item> mainTag = createCommonTag(category);
		for (Item item : items) {
			String path = BuiltInRegistries.ITEM.getKey(item).getPath();
			TagKey<Item> categoryTag = createCommonTag(category + "/" + path);
			this.tag(categoryTag).add(item.builtInRegistryHolder().key());
			this.tag(mainTag).addTag(categoryTag);
		}
	}

	private void addCategory(String category, String mainCategory, Item... items) {
		TagKey<Item> mainTag = createCommonTag(mainCategory);
		for (Item item : items) {
			String path = BuiltInRegistries.ITEM.getKey(item).getPath();
			TagKey<Item> categoryTag = createCommonTag(category + "/" + path);
			this.tag(categoryTag).add(item.builtInRegistryHolder().key());
			this.tag(mainTag).addTag(categoryTag);
		}
	}

	private void addCategoryWithType(String category, String type, Item... items) {
		TagKey<Item> mainTag = createCommonTag(category);
		for (Item item : items) {
			TagKey<Item> categoryTag = createCommonTag(category + "/" + type);
			this.tag(categoryTag).add(item.builtInRegistryHolder().key());
			this.tag(mainTag).addTag(categoryTag);
		}
	}

	private void addCrop(DeferredItem<? extends Item> crop, @Nullable DeferredItem<? extends Item> seed, String foodType) {
		String cropName = crop.getId().getPath();
		TagKey<Item> cropTag = createCommonTag("crops/" + cropName);
		TagKey<Item> mainFoodTag = createCommonTag(foodType);
		TagKey<Item> foodTypeTag = createCommonTag(foodType + "/" + cropName);
		this.tag(cropTag).add(crop.get().builtInRegistryHolder().key());
		this.tag(foodTypeTag).add(crop.getKey());
		this.tag(mainFoodTag).addTag(foodTypeTag);
		this.tag(Tags.Items.CROPS).addTag(cropTag);
		if (seed != null) {
			TagKey<Item> seedTag = createCommonTag("seeds/" + cropName);
			this.tag(seedTag).add(seed.getKey());
			this.tag(Tags.Items.SEEDS).addTag(seedTag);
		}
	}

	private TagKey<Item> createCommonTag(String name) {
		return ItemTags.create(Identifier.fromNamespaceAndPath("c", name));
	}
}
