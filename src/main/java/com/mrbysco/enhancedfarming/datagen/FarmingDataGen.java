package com.mrbysco.enhancedfarming.datagen;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.block.FruitLeavesBlock;
import com.mrbysco.enhancedfarming.block.GrowableSaplingBlock;
import com.mrbysco.enhancedfarming.block.crops.CropstickCropBlock;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.init.FarmingLootTables;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.GiftLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.mrbysco.enhancedfarming.init.FarmingRegistry.APPLE_JUICE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.APPLE_LEAVES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.APPLE_PIE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.APPLE_SAPLING;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.AUBERGINE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.AUBERGINE_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.AUBERGINE_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.AVOCADO;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.AVOCADO_LEAVES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.AVOCADO_SAPLING;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BACON_AND_EGG_PIE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BACON_PIZZA;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BACON_SANDWICH;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BAKED_EGG;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BANANA;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BANANA_JUICE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BANANA_LEAVES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BANANA_PIE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BANANA_SAPLING;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.BOILED_EGG;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CARROT_SOUP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHEESE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHEESEBURGER;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHEESE_PIZZA;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHERRY;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHERRY_JUICE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHERRY_LEAVES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHERRY_PIE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHERRY_SAPLING;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHICKENBURGER;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHICKEN_NOODLE_SOUP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHICKEN_SANDWICH;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHOCOLATE_BANANA;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHOCOLATE_BAR;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHOCOLATE_CANDY;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CHOCOLATE_CHERRY;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.COLD_CHOCOLATE_BOTTLE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CORN;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CORN_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CORN_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CORN_SOUP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CROP_STICK;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CUCUMBER;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CUCUMBER_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CUCUMBER_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CUCUMBER_SOUP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.CUTTING_BOARD;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.DIAMOND_RAKE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.DOUGH;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.EGG_SANDWICH;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.FISH_AND_CHIPS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.FLOUR;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.FRIES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.FRUIT_SALAD;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GARLIC;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GARLIC_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GARLIC_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GOLDEN_LEMON;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GOLDEN_ORANGE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GOLD_RAKE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GRAPES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GRAPE_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GRAPE_JUICE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GRAPE_PIE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GRAPE_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GUACAMOLE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.GUAC_AND_CHIPS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.HAMBURGER;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.HOT_CHOCOLATE_BOTTLE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.HOT_WATER;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.IRON_RAKE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.ITEMS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.JAM;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.JC_SANDWICH;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.LEMON;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.LEMONADE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.LEMON_LEAVES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.LEMON_PIE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.LEMON_SAPLING;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.LETTUCE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.LETTUCE_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.LETTUCE_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MANGO;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MANGO_JUICE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MANGO_LEAVES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MANGO_SAPLING;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MILK_BOTTLE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MINT;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MINT_CHOCOLATE_BAR;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MINT_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MINT_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MINT_TEA;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.MORTAR_AND_PESTLE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.NETHER_FLOWER_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.NETHER_FLOWER_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.OLIVE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.OLIVE_LEAVES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.OLIVE_OIL;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.OLIVE_SAPLING;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.ONION;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.ONION_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.ONION_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.ONION_SOUP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.ORANGE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.ORANGE_JUICE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.ORANGE_LEAVES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.ORANGE_SAPLING;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PASTA;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PEAR;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PEAR_JUICE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PEAR_LEAVES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PEAR_PIE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PEAR_SAPLING;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PINEAPPLE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PINEAPPLE_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PINEAPPLE_JUICE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PINEAPPLE_PIZZA;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.PINEAPPLE_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.POT;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.POTATO_CHIPS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.POTATO_SOUP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.RAW_FRIES;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SALAD;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SALT;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SCARECROW;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SLICED_BREAD;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_APPLE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_BANANA;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_CHERRY;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_CUCUMBER;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_GRAPE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_LEMON;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_MANGO;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_ORANGE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_PEAR;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SMOOTHIE_PINEAPPLE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.SPAGHETTI;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.STOCK;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.STONE_RAKE;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.TOMATO;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.TOMATO_CROP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.TOMATO_SEEDS;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.TOMATO_SOUP;
import static com.mrbysco.enhancedfarming.init.FarmingRegistry.WOODEN_RAKE;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FarmingDataGen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(new FarmingLoot(generator));
//			generator.addProvider(new FarmingRecipes(generator));
		}
		if (event.includeClient()) {
			generator.addProvider(new Language(generator));
			generator.addProvider(new FarmingBlockStates(generator, helper));
			generator.addProvider(new FarmingItemModels(generator, helper));
		}
	}

	private static class FarmingLoot extends LootTableProvider {
		public FarmingLoot(DataGenerator gen) {
			super(gen);
		}

		@Override
		protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
			return ImmutableList.of(Pair.of(FarmingBlocks::new, LootContextParamSets.BLOCK), Pair.of(FarmingRakeDrops::new, LootContextParamSets.GIFT));
		}

		private static class FarmingBlocks extends BlockLoot {
			private final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
			private final float[] JUNGLE_LEAVES_SAPLING_CHANGES = new float[]{0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F};

			@Override
			protected void addTables() {
				this.dropSelf(APPLE_SAPLING.get());
				this.dropSelf(LEMON_SAPLING.get());
				this.dropSelf(ORANGE_SAPLING.get());
				this.dropSelf(CHERRY_SAPLING.get());
				this.dropSelf(PEAR_SAPLING.get());
				this.dropSelf(BANANA_SAPLING.get());
				this.dropSelf(AVOCADO_SAPLING.get());
				this.dropSelf(MANGO_SAPLING.get());
				this.dropSelf(OLIVE_SAPLING.get());

				this.add(APPLE_LEAVES.get(), (block) -> createLeavesDrops(APPLE_LEAVES.get(), APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(APPLE_LEAVES.get(), (block) -> createLeavesDrops(APPLE_LEAVES.get(), APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(LEMON_LEAVES.get(), (block) -> createLeavesDrops(LEMON_LEAVES.get(), LEMON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(ORANGE_LEAVES.get(), (block) -> createLeavesDrops(ORANGE_LEAVES.get(), ORANGE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(CHERRY_LEAVES.get(), (block) -> createLeavesDrops(CHERRY_LEAVES.get(), CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(PEAR_LEAVES.get(), (block) -> createLeavesDrops(PEAR_LEAVES.get(), PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(BANANA_LEAVES.get(), (block) -> createLeavesDrops(BANANA_LEAVES.get(), BANANA_SAPLING.get(), JUNGLE_LEAVES_SAPLING_CHANGES));
				this.add(AVOCADO_LEAVES.get(), (block) -> createLeavesDrops(AVOCADO_LEAVES.get(), AVOCADO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(MANGO_LEAVES.get(), (block) -> createLeavesDrops(MANGO_LEAVES.get(), MANGO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
				this.add(OLIVE_LEAVES.get(), (block) -> createLeavesDrops(OLIVE_LEAVES.get(), OLIVE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

				this.add(CROP_STICK.get(), (block) -> createSilkTouchDispatchTable(block, applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3))))));

				this.add(MINT_CROP.get(), (block) -> createCropDrops(MINT_CROP.get(), MINT.get(), MINT_SEEDS.get(), getBuilder((CropBlock) MINT_CROP.get())));
				LootItemCondition.Builder netherBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(NETHER_FLOWER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NetherFlowerBlock.AGE, 5));
				this.add(NETHER_FLOWER_CROP.get(), (block) -> createCropDrops(NETHER_FLOWER_CROP.get(), Items.BLAZE_ROD, NETHER_FLOWER_SEEDS.get(), netherBuilder));
				this.add(TOMATO_CROP.get(), (block) -> createCropDrops(TOMATO_CROP.get(), TOMATO.get(), TOMATO_SEEDS.get(), getBuilder((CropBlock) TOMATO_CROP.get())));
				this.add(CUCUMBER_CROP.get(), (block) -> createCropDrops(CUCUMBER_CROP.get(), CUCUMBER.get(), CUCUMBER_SEEDS.get(), getBuilder((CropBlock) CUCUMBER_CROP.get())));
				this.add(AUBERGINE_CROP.get(), (block) -> createCropDrops(AUBERGINE_CROP.get(), AUBERGINE.get(), AUBERGINE_SEEDS.get(), getBuilder((CropBlock) AUBERGINE_CROP.get())));
				this.add(GRAPE_CROP.get(), (block) -> createCropDrops(GRAPE_CROP.get(), GRAPES.get(), GRAPE_SEEDS.get(), getBuilder((CropBlock) GRAPE_CROP.get())));
				this.add(PINEAPPLE_CROP.get(), (block) -> createCropDrops(PINEAPPLE_CROP.get(), PINEAPPLE.get(), PINEAPPLE_SEEDS.get(), getBuilder((CropBlock) PINEAPPLE_CROP.get())));
				this.add(CORN_CROP.get(), (block) -> createCropDrops(CORN_CROP.get(), CORN.get(), CORN_SEEDS.get(), getBuilder((CropBlock) CORN_CROP.get())));
				this.add(ONION_CROP.get(), (block) -> createCropDrops(ONION_CROP.get(), ONION.get(), ONION_SEEDS.get(), getBuilder((CropBlock) ONION_CROP.get())));
				this.add(GARLIC_CROP.get(), (block) -> createCropDrops(GARLIC_CROP.get(), GARLIC.get(), GARLIC_SEEDS.get(), getBuilder((CropBlock) GARLIC_CROP.get())));
				this.add(LETTUCE_CROP.get(), (block) -> createCropDrops(LETTUCE_CROP.get(), LETTUCE.get(), LETTUCE_SEEDS.get(), getBuilder((CropBlock) LETTUCE_CROP.get())));

				this.dropSelf(SCARECROW.get());
			}

			public LootItemCondition.Builder getBuilder(CropBlock block) {
				return LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(block.getAgeProperty(), block.getMaxAge()));
			}

			@Override
			protected Iterable<Block> getKnownBlocks() {
				return (Iterable<Block>) FarmingRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
			}
		}


		private static class FarmingRakeDrops extends GiftLoot {
			@Override
			public void accept(BiConsumer<ResourceLocation, Builder> consumer) {
				consumer.accept(FarmingLootTables.GAMEPLAY_RAKE_DROPS,
						LootTable.lootTable()
								.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
										.add(LootItem.lootTableItem(APPLE_SAPLING.get()))
										.add(LootItem.lootTableItem(LEMON_SAPLING.get()))
										.add(LootItem.lootTableItem(ORANGE_SAPLING.get()))
										.add(LootItem.lootTableItem(MINT_SEEDS.get()))
										.add(LootItem.lootTableItem(NETHER_FLOWER_SEEDS.get()))
										.add(LootItem.lootTableItem(CHERRY_SAPLING.get()))
										.add(LootItem.lootTableItem(PEAR_SAPLING.get()))
										.add(LootItem.lootTableItem(BANANA_SAPLING.get()))
										.add(LootItem.lootTableItem(AVOCADO_SAPLING.get()))
										.add(LootItem.lootTableItem(MANGO_SAPLING.get()))
										.add(LootItem.lootTableItem(TOMATO_SEEDS.get()))
										.add(LootItem.lootTableItem(CUCUMBER_SEEDS.get()))
										.add(LootItem.lootTableItem(AUBERGINE_SEEDS.get()))
										.add(LootItem.lootTableItem(PINEAPPLE_SEEDS.get()))
										.add(LootItem.lootTableItem(GRAPE_SEEDS.get()))
										.add(LootItem.lootTableItem(CORN_SEEDS.get()))
										.add(LootItem.lootTableItem(ONION_SEEDS.get()))
										.add(LootItem.lootTableItem(GARLIC_SEEDS.get()))
										.add(LootItem.lootTableItem(OLIVE_SAPLING.get()))
										.add(LootItem.lootTableItem(LETTUCE_SEEDS.get()))
								));
			}
		}

		@Override
		protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext validationtracker) {
			map.forEach((name, table) -> LootTables.validate(validationtracker, name, table));
		}
	}


	private static class FarmingRecipes extends RecipeProvider {
		public FarmingRecipes(DataGenerator gen) {
			super(gen);
		}

		@Override
		protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

		}

		@Override
		protected void saveAdvancement(HashCache cache, JsonObject advancementJson, Path path) {
			// Nope
		}
	}

	private static class FarmingLanguage extends LanguageProvider {
		public FarmingLanguage(DataGenerator gen) {
			super(gen, Reference.MOD_ID, "en_us");
		}

		@Override
		protected void addTranslations() {
			//
		}
	}

	private static class FarmingItemModels extends ItemModelProvider {
		public FarmingItemModels(DataGenerator gen, ExistingFileHelper helper) {
			super(gen, Reference.MOD_ID, helper);
		}

		@Override
		protected void registerModels() {
			ITEMS.getEntries().stream()
					.map(RegistryObject::get)
					.forEach(item -> {
						String path = Objects.requireNonNull(item.getRegistryName()).getPath();
						if (!path.equals("scarecrow")) {
							if (path.endsWith("_sapling")) {
								singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("block/saplings/" + path));
							} else if (path.endsWith("_leaves")) {
								withExistingParent(path, modLoc("block/" + path + "_fruity"));
							} else if (path.endsWith("_rake")) {
								singleTexture(path, mcLoc("item/handheld"), "layer0", modLoc("item/" + path));
							} else {
								singleTexture(path, mcLoc("item/generated"), "layer0", modLoc("item/" + path));
							}
						} else {
							withExistingParent(path, modLoc("block/scarecrow"));
						}
					});
		}

		@Override
		public String getName() {
			return "Item Models";
		}
	}

	private static class Language extends LanguageProvider {
		public Language(DataGenerator gen) {
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
			addBlock(MINT_CROP, "Mint Crop");
			addBlock(NETHER_FLOWER_CROP, "Nether Flower Crop");
			addBlock(TOMATO_CROP, "Tomato Crop");
			addBlock(CUCUMBER_CROP, "Cucumber Crop");
			addBlock(AUBERGINE_CROP, "Aubergine Crop");
			addBlock(GRAPE_CROP, "Grape Crop");
			addBlock(PINEAPPLE_CROP, "Pineapple Crop");
			addBlock(CORN_CROP, "Corn Crop");
			addBlock(ONION_CROP, "Onion Crop");
			addBlock(GARLIC_CROP, "Garlic Crop");
			addBlock(LETTUCE_CROP, "Lettuce Crop");

			addBlock(APPLE_LEAVES, "Apple Leaves");
			addBlock(LEMON_LEAVES, "Lemon Leaves");
			addBlock(ORANGE_LEAVES, "Orange Leaves");
			addBlock(CHERRY_LEAVES, "Cherry Leaves");
			addBlock(PEAR_LEAVES, "Pear Leaves");
			addBlock(BANANA_LEAVES, "Banana Leaves");
			addBlock(AVOCADO_LEAVES, "Avocado Leaves");
			addBlock(MANGO_LEAVES, "Mango Leaves");
			addBlock(OLIVE_LEAVES, "Olive Leaves");

			addBlock(APPLE_SAPLING, "Apple Seeds");
			addBlock(LEMON_SAPLING, "Lemon Seeds");
			addBlock(ORANGE_SAPLING, "Orange Seeds");
			addBlock(CHERRY_SAPLING, "Cherry Seeds");
			addBlock(PEAR_SAPLING, "Pear Seeds");
			addBlock(BANANA_SAPLING, "Banana Seeds");
			addBlock(AVOCADO_SAPLING, "Avocado Seed");
			addBlock(MANGO_SAPLING, "Mango Seed");
			addBlock(OLIVE_SAPLING, "Olive Seeds");

			addBlock(CROP_STICK, "Crop Sticks");
			addBlock(SCARECROW, "Scarecrow");
		}

		private void addItems() {
			addItem(MINT_SEEDS, "Mint Seeds");
			addItem(NETHER_FLOWER_SEEDS, "Nether Flower Seeds");
			addItem(TOMATO_SEEDS, "Tomato Seeds");
			addItem(CUCUMBER_SEEDS, "Cucumber Seeds");
			addItem(AUBERGINE_SEEDS, "Aubergine Seeds");
			addItem(GRAPE_SEEDS, "Grape Seeds");
			addItem(CORN_SEEDS, "Corn Seeds");
			addItem(PINEAPPLE_SEEDS, "Pineapple Seeds");
			addItem(ONION_SEEDS, "Onion Seeds");
			addItem(GARLIC_SEEDS, "Garlic Seeds");
			addItem(LETTUCE_SEEDS, "Lettuce Seeds");
			addItem(POT, "Pot");
			addItem(CUTTING_BOARD, "Cutting Board");
			addItem(MORTAR_AND_PESTLE, "Mortar And Pestle");
			addItem(MINT, "Mint");
			addItem(LEMON, "Lemon");
			addItem(ORANGE, "Orange");
			addItem(CHERRY, "Cherry");
			addItem(PEAR, "Pear");
			addItem(BANANA, "Banana");
			addItem(OLIVE, "Olive");
			addItem(AVOCADO, "Avocado");
			addItem(MANGO, "Mango");
			addItem(TOMATO, "Tomato");
			addItem(CUCUMBER, "Cucumber");
			addItem(AUBERGINE, "Aubergine");
			addItem(GRAPES, "Grapes");
			addItem(PINEAPPLE, "Pineapple");
			addItem(CORN, "Corn");
			addItem(ONION, "Onion");
			addItem(GARLIC, "Garlic");
			addItem(LETTUCE, "Lettuce");
			addItem(GOLDEN_LEMON, "Golden lemon");
			addItem(GOLDEN_ORANGE, "Golden Orange");
			addItem(CHOCOLATE_BAR, "Chocolate Bar");
			addItem(CHOCOLATE_CANDY, "Chocolate Candy");
			addItem(CHOCOLATE_CHERRY, "Chocolate Cherry");
			addItem(CHOCOLATE_BANANA, "Chocolate Banana");
			addItem(MINT_CHOCOLATE_BAR, "Mint Chocolate Bar");
			addItem(MINT_TEA, "Mint Tea");
			addItem(APPLE_JUICE, "Apple Juice");
			addItem(LEMONADE, "Lemonade");
			addItem(ORANGE_JUICE, "Orange Juice");
			addItem(CHERRY_JUICE, "Cherry Juice");
			addItem(PEAR_JUICE, "Pear Juice");
			addItem(BANANA_JUICE, "Banana Juice");
			addItem(GRAPE_JUICE, "Grape Juice");
			addItem(MANGO_JUICE, "Mango Juice");
			addItem(PINEAPPLE_JUICE, "Pineapple Juice");
			addItem(MILK_BOTTLE, "Milk Bottle");
			addItem(COLD_CHOCOLATE_BOTTLE, "Cold Chocolate Bottle");
			addItem(HOT_CHOCOLATE_BOTTLE, "Hot Chocolate Bottle");
			addItem(HOT_WATER, "Boiled Water");
			addItem(SMOOTHIE_APPLE, "Apple Smoothie");
			addItem(SMOOTHIE_LEMON, "Lemon Smoothie");
			addItem(SMOOTHIE_ORANGE, "Orange Smoothie");
			addItem(SMOOTHIE_CHERRY, "Cherry Smoothie");
			addItem(SMOOTHIE_PEAR, "Pear Smoothie");
			addItem(SMOOTHIE_BANANA, "Banana Smoothie");
			addItem(SMOOTHIE_GRAPE, "Grape Smoothie");
			addItem(SMOOTHIE_MANGO, "Mango Smoothie");
			addItem(SMOOTHIE_PINEAPPLE, "Pineapple Smoothie");
			addItem(SMOOTHIE_CUCUMBER, "Cucumber Smoothie");
			addItem(STOCK, "Stock");
			addItem(SALT, "Salt");
			addItem(FLOUR, "Flour");
			addItem(DOUGH, "Dough");
			addItem(OLIVE_OIL, "Olive Oil");
			addItem(PASTA, "Pasta");
			addItem(RAW_FRIES, "Raw Fries");
			addItem(FRUIT_SALAD, "Fruit Salad");
			addItem(SALAD, "Salad");
			addItem(CORN_SOUP, "Corn Soup");
			addItem(CUCUMBER_SOUP, "Cucumber Soup");
			addItem(TOMATO_SOUP, "Tomato Soup");
			addItem(POTATO_SOUP, "Potato Soup");
			addItem(CARROT_SOUP, "Carrot Soup");
			addItem(ONION_SOUP, "Onion Soup");
			addItem(CHICKEN_NOODLE_SOUP, "Chicken Noodle Soup");
			addItem(HAMBURGER, "Hamburger");
			addItem(CHICKENBURGER, "Chicken Burger");
			addItem(CHEESEBURGER, "Cheese Burger");
			addItem(BOILED_EGG, "Boiled Egg");
			addItem(BAKED_EGG, "Baked Egg");
			addItem(SLICED_BREAD, "Sliced Bread");
			addItem(CHEESE, "Cheese");
			addItem(SPAGHETTI, "Spaghetti");
			addItem(JAM, "Fruit Jam");
			addItem(FRIES, "Fries");
			addItem(FISH_AND_CHIPS, "Fish And Chips");
			addItem(POTATO_CHIPS, "Potato Chips");
			addItem(GUACAMOLE, "Guacamole");
			addItem(GUAC_AND_CHIPS, "Guac and Chips");
			addItem(EGG_SANDWICH, "Egg Sandwich");
			addItem(BACON_SANDWICH, "Bacon Sandwich");
			addItem(CHICKEN_SANDWICH, "Chicken Sandwich");
			addItem(JC_SANDWICH, "Jam And Cheese Sandwich");
			addItem(PINEAPPLE_PIZZA, "Pineapple Pizza");
			addItem(CHEESE_PIZZA, "Cheese Pizza");
			addItem(BACON_PIZZA, "Bacon Pizza");
			addItem(APPLE_PIE, "Apple Pie");
			addItem(BANANA_PIE, "Banana Cream Pie");
			addItem(BACON_AND_EGG_PIE, "Bacon And Egg Pie");
			addItem(CHERRY_PIE, "Cherry Pie");
			addItem(GRAPE_PIE, "Grape Pie");
			addItem(LEMON_PIE, "Lemon Meringue Pie");
			addItem(PEAR_PIE, "Pear Pie");
			addItem(WOODEN_RAKE, "Wooden Rake");
			addItem(STONE_RAKE, "Stone Rake");
			addItem(IRON_RAKE, "Iron Rake");
			addItem(GOLD_RAKE, "Gold Rake");
			addItem(DIAMOND_RAKE, "Diamond Rake");
		}
	}

	private static class FarmingBlockStates extends BlockStateProvider {

		public FarmingBlockStates(DataGenerator gen, ExistingFileHelper helper) {
			super(gen, Reference.MOD_ID, helper);
		}

		@Override
		protected void registerStatesAndModels() {
			buildCrops((CropBlock) MINT_CROP.get());
			buildNetherCrops((NetherFlowerBlock) NETHER_FLOWER_CROP.get());
			buildCrops((CropBlock) TOMATO_CROP.get());
			buildCrops((CropBlock) CUCUMBER_CROP.get());
			buildCrops((CropBlock) AUBERGINE_CROP.get());
			buildStickCropCrops((CropstickCropBlock) GRAPE_CROP.get());
			buildCrops((CropBlock) PINEAPPLE_CROP.get());
			buildCrops((CropBlock) CORN_CROP.get());
			buildCrops((CropBlock) ONION_CROP.get());
			buildCrops((CropBlock) GARLIC_CROP.get());
			buildCrops((CropBlock) LETTUCE_CROP.get());

			buildSaplings((GrowableSaplingBlock) APPLE_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) LEMON_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) ORANGE_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) CHERRY_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) PEAR_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) BANANA_SAPLING.get(), "jungle_sapling");
			buildSaplings((GrowableSaplingBlock) AVOCADO_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) MANGO_SAPLING.get(), "oak_sapling");
			buildSaplings((GrowableSaplingBlock) OLIVE_SAPLING.get(), "acacia_sapling");

			buildLeaves((FruitLeavesBlock) APPLE_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) LEMON_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) ORANGE_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) CHERRY_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) PEAR_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) BANANA_LEAVES.get(), "jungle_leaves");
			buildLeaves((FruitLeavesBlock) AVOCADO_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) MANGO_LEAVES.get(), "oak_leaves");
			buildLeaves((FruitLeavesBlock) OLIVE_LEAVES.get(), "acacia_leaves");

			model(CROP_STICK.get());

			horizontalBlock(SCARECROW.get(), models().getExistingFile(modLoc("block/scarecrow")));
		}

		protected void model(Block block) {
			ModelFile file = models().getExistingFile(block.getRegistryName());
			getVariantBuilder(block).forAllStates(state -> ConfiguredModel.builder().modelFile(file).build());
		}

		protected void buildNetherCrops(NetherFlowerBlock block) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				ModelFile file = models().crop(block.getRegistryName().getPath() + "_" + (i),
						new ResourceLocation(Reference.MOD_ID, "block/crops/" + block.getRegistryName().getPath() + "_" + (i)));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}

		protected void buildCrops(CropBlock block) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				ModelFile file = models().crop(block.getRegistryName().getPath() + "_" + (i),
						new ResourceLocation(Reference.MOD_ID, "block/crops/" + block.getRegistryName().getPath() + "_" + (i)));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}

		protected void buildStickCropCrops(CropstickCropBlock block) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				ModelFile file = models().singleTexture(block.getRegistryName().getPath() + "_" + (i), modLoc("block/stick_crops"), "crop",
						new ResourceLocation(Reference.MOD_ID, "block/crops/" + block.getRegistryName().getPath() + "_" + (i)));
				builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
			}
		}

		protected void buildSaplings(GrowableSaplingBlock block, String base) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMatureStage(); i++) {
				if (i == block.getMatureStage()) {
					ModelFile file = models().crop(block.getRegistryName().getPath() + "_" + (i),
							new ResourceLocation(Reference.MOD_ID, "block/saplings/" + block.getRegistryName().getPath()));
					builder.partialState().with(block.getStageProperty(), i).modelForState().modelFile(file).addModel();
				} else {
					ModelFile file = models().crop(block.getRegistryName().getPath() + "_" + (i),
							new ResourceLocation(Reference.MOD_ID, "block/saplings/" + base + "_" + (i)));
					builder.partialState().with(block.getStageProperty(), i).modelForState().modelFile(file).addModel();
				}
			}
		}

		protected void buildLeaves(FruitLeavesBlock block, String originalLeaves) {
			VariantBlockStateBuilder builder = getVariantBuilder(block);
			for (int i = 0; i <= block.getMaxAge(); i++) {
				if (i != block.getMaxAge()) {
					ModelFile file = models().singleTexture(block.getRegistryName().getPath() + "_blooming", modLoc("block/leave_overlay"), "layer1",
							new ResourceLocation(Reference.MOD_ID, "block/leaves/" + block.getRegistryName().getPath() + "_blooming")).texture("layer0", mcLoc("block/" + originalLeaves));
					builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
				} else {
					ModelFile file = models().singleTexture(block.getRegistryName().getPath() + "_fruity", modLoc("block/leave_overlay"), "layer1",
							new ResourceLocation(Reference.MOD_ID, "block/leaves/" + block.getRegistryName().getPath() + "_fruity")).texture("layer0", mcLoc("block/" + originalLeaves));
					builder.partialState().with(block.getAgeProperty(), i).modelForState().modelFile(file).addModel();
				}
			}
		}
	}
}
