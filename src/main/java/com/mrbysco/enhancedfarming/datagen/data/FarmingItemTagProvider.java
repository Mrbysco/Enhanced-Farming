package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class FarmingItemTagProvider extends ItemTagsProvider {

	public FarmingItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(dataGenerator, blockTagsProvider, Reference.MOD_ID, existingFileHelper);
	}

	private final String VEGETABLES = "vegetables";
	private final String RAWMEATS = "rawmeats";
	private final String FRUITS = "fruits";
	private final String FISH = "fish";
	private final String SUGAR = "sugar";
	private final String WATER = "water";
	private final String MILK = "milk";
	private final String SEEDS = "seeds";

	@Override
	protected void addTags() {
		this.tag(FarmingTags.HOT_ITEMS).add(FarmingRegistry.HOT_WATER.get(), FarmingRegistry.HOT_CHOCOLATE_BOTTLE.get(), FarmingRegistry.MINT_TEA.get());

		addCrop(FarmingRegistry.AUBERGINE, FarmingRegistry.AUBERGINE_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.CORN, FarmingRegistry.CORN_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.CUCUMBER, FarmingRegistry.CUCUMBER_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.GARLIC, FarmingRegistry.GARLIC_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.LETTUCE, FarmingRegistry.LETTUCE_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.MINT, FarmingRegistry.MINT_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.OLIVE, null, VEGETABLES);
		addCrop(FarmingRegistry.ONION, FarmingRegistry.ONION_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.TOMATO, FarmingRegistry.TOMATO_SEEDS, VEGETABLES);
		addCrop(FarmingRegistry.PINEAPPLE, FarmingRegistry.PINEAPPLE_SEEDS, FRUITS);
		addCrop(FarmingRegistry.GRAPES, FarmingRegistry.GRAPE_SEEDS, FRUITS);

		addCategory(VEGETABLES, Items.POTATO, Items.CARROT, Items.BEETROOT);
		addCategory(RAWMEATS, Items.BEEF, Items.CHICKEN, Items.MUTTON, Items.PORKCHOP, Items.RABBIT);
		addCategory(FRUITS, Items.APPLE, FarmingRegistry.BANANA.get(), FarmingRegistry.CHERRY.get(),
				FarmingRegistry.LEMON.get(), FarmingRegistry.MANGO.get(), FarmingRegistry.ORANGE.get(),
				FarmingRegistry.PEAR.get());
		addCategory(FISH, "rawfish", Items.COD, Items.SALMON);
		addCategory(SUGAR, Items.SUGAR);
		addCategory(WATER, Items.WATER_BUCKET);
		addCategory(MILK, Items.MILK_BUCKET);
		addCategory(SEEDS, FarmingRegistry.NETHER_FLOWER_SEEDS.get());
	}
	private void addCategory(String category, Item... items) {
		TagKey<Item> mainTag = ItemTags.create(new ResourceLocation("forge", category));
		for(Item item : items) {
			String path = ForgeRegistries.ITEMS.getKey(item).getPath();
			TagKey<Item> categoryTag = ItemTags.create(new ResourceLocation("forge",  category + "/" + path));
			this.tag(categoryTag).add(item);
			this.tag(mainTag).addTag(categoryTag);
		}
	}

	private void addCategory(String category, String mainCategory, Item... items) {
		TagKey<Item> mainTag = ItemTags.create(new ResourceLocation("forge", mainCategory));
		for(Item item : items) {
			String path = ForgeRegistries.ITEMS.getKey(item).getPath();
			TagKey<Item> categoryTag = ItemTags.create(new ResourceLocation("forge",  category + "/" + path));
			this.tag(categoryTag).add(item);
			this.tag(mainTag).addTag(categoryTag);
		}
	}

	private void addCrop(RegistryObject<Item> crop, @Nullable RegistryObject<Item> seed, String foodType) {
		String cropName = crop.getId().getPath();
		TagKey<Item> croptag = ItemTags.create(new ResourceLocation("forge", "crops/" + cropName));
		TagKey<Item> mainFoodTag = ItemTags.create(new ResourceLocation("forge", foodType));
		TagKey<Item> foodTypeTag = ItemTags.create(new ResourceLocation("forge", foodType + "/" + cropName));
		this.tag(croptag).add(crop.get());
		this.tag(foodTypeTag).add(crop.get());
		this.tag(mainFoodTag).addTag(foodTypeTag);
		this.tag(Tags.Items.CROPS).addTag(croptag);
		if (seed != null) {
			TagKey<Item> seedTag = ItemTags.create(new ResourceLocation("forge", "seeds/" + cropName));
			this.tag(seedTag).add(seed.get());
			this.tag(Tags.Items.SEEDS).addTag(seedTag);
		}
	}
}
