package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FarmingItemTagProvider extends ItemTagsProvider {

	public FarmingItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
								  CompletableFuture<TagLookup<Block>> blockTagProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, blockTagProvider, Reference.MOD_ID, existingFileHelper);
	}

	private final String VEGETABLES = "vegetables";
	private final String HERBS = "herbs";
	private final String RAWMEATS = "rawmeats";
	private final String RAW_BEEF = "raw_beef";
	private final String RAW_CHICKEN = "raw_chicken";
	private final String COOKED_BEEF = "cooked_beef";
	private final String COOKED_CHICKEN = "cooked_chicken";
	private final String COOKED_FISH = "cooked_fish";
	private final String FRUITS = "fruits";
	private final String FISH = "fish";
	private final String SUGAR = "sugar";
	private final String WATER = "water";
	private final String MILK = "milk";
	private final String SEEDS = "seeds";
	private final String DOUGH = "dough";
	private final String CHEESES = "cheeses";
	private final String SALAD_INGREDIENTS = "salad_ingredients";
	private final String SALT = "edible_salt";
	private final String FLOUR = "flour";

	@Override
	public void addTags(HolderLookup.Provider lookupProvider) {
		this.tag(FarmingTags.HOT_ITEMS).add(FarmingRegistry.HOT_WATER.get(), FarmingRegistry.HOT_CHOCOLATE_BOTTLE.get(), FarmingRegistry.MINT_TEA.get());

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
		addCategory(FISH, "rawfish", Items.COD, Items.SALMON);
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
	}

	private void addRegular(String category, Item... items) {
		TagKey<Item> mainTag = createForgeTag(category);
		this.tag(mainTag).add(items);
	}

	private void addCategory(String category, Item... items) {
		TagKey<Item> mainTag = createForgeTag(category);
		for (Item item : items) {
			String path = ForgeRegistries.ITEMS.getKey(item).getPath();
			TagKey<Item> categoryTag = createForgeTag(category + "/" + path);
			this.tag(categoryTag).add(item);
			this.tag(mainTag).addTag(categoryTag);
		}
	}

	private void addCategory(String category, String mainCategory, Item... items) {
		TagKey<Item> mainTag = createForgeTag(mainCategory);
		for (Item item : items) {
			String path = ForgeRegistries.ITEMS.getKey(item).getPath();
			TagKey<Item> categoryTag = createForgeTag(category + "/" + path);
			this.tag(categoryTag).add(item);
			this.tag(mainTag).addTag(categoryTag);
		}
	}

	private void addCategoryWithType(String category, String type, Item... items) {
		TagKey<Item> mainTag = createForgeTag(category);
		for (Item item : items) {
			TagKey<Item> categoryTag = createForgeTag(category + "/" + type);
			this.tag(categoryTag).add(item);
			this.tag(mainTag).addTag(categoryTag);
		}
	}

	private void addCrop(RegistryObject<Item> crop, @Nullable RegistryObject<Item> seed, String foodType) {
		String cropName = crop.getId().getPath();
		TagKey<Item> cropTag = createForgeTag("crops/" + cropName);
		TagKey<Item> mainFoodTag = createForgeTag(foodType);
		TagKey<Item> foodTypeTag = createForgeTag(foodType + "/" + cropName);
		this.tag(cropTag).add(crop.get());
		this.tag(foodTypeTag).add(crop.get());
		this.tag(mainFoodTag).addTag(foodTypeTag);
		this.tag(Tags.Items.CROPS).addTag(cropTag);
		if (seed != null) {
			TagKey<Item> seedTag = createForgeTag("seeds/" + cropName);
			this.tag(seedTag).add(seed.get());
			this.tag(Tags.Items.SEEDS).addTag(seedTag);
		}
	}

	private TagKey<Item> createForgeTag(String name) {
		return ItemTags.create(new ResourceLocation("forge", name));
	}
}
