package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.block.crops.CropstickCropBlock;
import com.mrbysco.enhancedfarming.block.crops.FiveAgeCropBlock;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.block.crops.SevenAgeCropBlock;
import com.mrbysco.enhancedfarming.block.crops.SixAgeCropBlock;
import com.mrbysco.enhancedfarming.init.FarmingLootTables;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaGiftLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class FarmingLootProvider extends LootTableProvider {
	public FarmingLootProvider(PackOutput packOutput) {
		super(packOutput, Set.of(), List.of(
				new SubProviderEntry(FarmingBlocks::new, LootContextParamSets.BLOCK),
				new SubProviderEntry(FarmingRakeDrops::new, LootContextParamSets.GIFT)
		));
	}

	private static class FarmingBlocks extends BlockLootSubProvider {
		private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
		private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();
		private final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
		private final float[] JUNGLE_LEAVES_SAPLING_CHANGES = new float[]{0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F};
		private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};

		protected FarmingBlocks() {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags());
		}

		@Override
		protected void generate() {
			this.dropSelf(FarmingRegistry.APPLE_SAPLING.get());
			this.dropSelf(FarmingRegistry.LEMON_SAPLING.get());
			this.dropSelf(FarmingRegistry.ORANGE_SAPLING.get());
			this.dropSelf(FarmingRegistry.CHERRY_SAPLING.get());
			this.dropSelf(FarmingRegistry.PEAR_SAPLING.get());
			this.dropSelf(FarmingRegistry.BANANA_SAPLING.get());
			this.dropSelf(FarmingRegistry.AVOCADO_SAPLING.get());
			this.dropSelf(FarmingRegistry.MANGO_SAPLING.get());
			this.dropSelf(FarmingRegistry.OLIVE_SAPLING.get());

			this.add(FarmingRegistry.APPLE_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
			this.add(FarmingRegistry.APPLE_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.APPLE_LEAVES.get(), FarmingRegistry.APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
			this.add(FarmingRegistry.LEMON_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.LEMON_LEAVES.get(), FarmingRegistry.LEMON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
			this.add(FarmingRegistry.ORANGE_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.ORANGE_LEAVES.get(), FarmingRegistry.ORANGE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
			this.add(FarmingRegistry.CHERRY_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.CHERRY_LEAVES.get(), FarmingRegistry.CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
			this.add(FarmingRegistry.PEAR_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.PEAR_LEAVES.get(), FarmingRegistry.PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
			this.add(FarmingRegistry.BANANA_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.BANANA_LEAVES.get(), FarmingRegistry.BANANA_SAPLING.get(), JUNGLE_LEAVES_SAPLING_CHANGES));
			this.add(FarmingRegistry.AVOCADO_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.AVOCADO_LEAVES.get(), FarmingRegistry.AVOCADO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
			this.add(FarmingRegistry.MANGO_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.MANGO_LEAVES.get(), FarmingRegistry.MANGO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
			this.add(FarmingRegistry.OLIVE_LEAVES.get(), (block) -> createLeavesDrops(FarmingRegistry.OLIVE_LEAVES.get(), FarmingRegistry.OLIVE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

			this.add(FarmingRegistry.CROP_STICK.get(), (block) -> createSilkTouchDispatchTable(block, applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3))))));

			this.add(FarmingRegistry.MINT_CROP.get(), (block) -> createCropDrops(FarmingRegistry.MINT_CROP.get(), FarmingRegistry.MINT.get(), FarmingRegistry.MINT_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.MINT_CROP.get(), FiveAgeCropBlock.AGE)));
			LootItemCondition.Builder netherBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(FarmingRegistry.NETHER_FLOWER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NetherFlowerBlock.AGE, 5));
			this.add(FarmingRegistry.NETHER_FLOWER_CROP.get(), (block) -> createCropDrops(FarmingRegistry.NETHER_FLOWER_CROP.get(), Items.BLAZE_ROD, FarmingRegistry.NETHER_FLOWER_SEEDS.get(), netherBuilder));
			this.add(FarmingRegistry.TOMATO_CROP.get(), (block) -> createCropDrops(FarmingRegistry.TOMATO_CROP.get(), FarmingRegistry.TOMATO.get(), FarmingRegistry.TOMATO_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.TOMATO_CROP.get(), SixAgeCropBlock.AGE)));
			this.add(FarmingRegistry.CUCUMBER_CROP.get(), (block) -> createCropDrops(FarmingRegistry.CUCUMBER_CROP.get(), FarmingRegistry.CUCUMBER.get(), FarmingRegistry.CUCUMBER_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.CUCUMBER_CROP.get(), FiveAgeCropBlock.AGE)));
			this.add(FarmingRegistry.AUBERGINE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.AUBERGINE_CROP.get(), FarmingRegistry.AUBERGINE.get(), FarmingRegistry.AUBERGINE_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.AUBERGINE_CROP.get(), FiveAgeCropBlock.AGE)));
			this.add(FarmingRegistry.GRAPE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.GRAPE_CROP.get(), FarmingRegistry.GRAPES.get(), FarmingRegistry.GRAPE_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.GRAPE_CROP.get(), CropstickCropBlock.AGE)));
			this.add(FarmingRegistry.PINEAPPLE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.PINEAPPLE_CROP.get(), FarmingRegistry.PINEAPPLE.get(), FarmingRegistry.PINEAPPLE_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.PINEAPPLE_CROP.get(), FiveAgeCropBlock.AGE)));
			this.add(FarmingRegistry.CORN_CROP.get(), (block) -> createCropDrops(FarmingRegistry.CORN_CROP.get(), FarmingRegistry.CORN.get(), FarmingRegistry.CORN_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.CORN_CROP.get(), SevenAgeCropBlock.AGE)));
			this.add(FarmingRegistry.ONION_CROP.get(), (block) -> createCropDrops(FarmingRegistry.ONION_CROP.get(), FarmingRegistry.ONION.get(), FarmingRegistry.ONION_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.ONION_CROP.get(), FiveAgeCropBlock.AGE)));
			this.add(FarmingRegistry.GARLIC_CROP.get(), (block) -> createCropDrops(FarmingRegistry.GARLIC_CROP.get(), FarmingRegistry.GARLIC.get(), FarmingRegistry.GARLIC_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.GARLIC_CROP.get(), FiveAgeCropBlock.AGE)));
			this.add(FarmingRegistry.LETTUCE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.LETTUCE_CROP.get(), FarmingRegistry.LETTUCE.get(), FarmingRegistry.LETTUCE_SEEDS.get(), cropConditionBuilder((CropBlock) FarmingRegistry.LETTUCE_CROP.get(), FiveAgeCropBlock.AGE)));

			this.dropSelf(FarmingRegistry.SCARECROW.get());
		}

		protected void dropSelf(Block block) {
			this.dropOther(block, block);
		}

		protected void dropOther(Block block, ItemLike itemLike) {
			this.add(block, this.createSingleItemTable(itemLike));
		}

		public LootTable.Builder createSingleItemTable(ItemLike itemLike) {
			return LootTable.lootTable().withPool(this.applyExplosionCondition(itemLike, LootPool.lootPool().name("main")
					.setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(itemLike))));
		}

		protected LootTable.Builder createCropDrops(Block crop, Item cropItem, Item seeds, LootItemCondition.Builder builder) {
			return this.applyExplosionDecay(crop, LootTable.lootTable()
					.withPool(LootPool.lootPool().name("crop")
							.add(LootItem.lootTableItem(cropItem).when(builder).otherwise(LootItem.lootTableItem(seeds))))
					.withPool(LootPool.lootPool().name("seeds").when(builder)
							.add(LootItem.lootTableItem(seeds).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3)))));
		}

		protected static LootTable.Builder createSilkTouchDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
			return createSelfDropDispatchTable(block, HAS_SILK_TOUCH, builder);
		}

		protected static LootTable.Builder createSelfDropDispatchTable(Block block, LootItemCondition.Builder builder, LootPoolEntryContainer.Builder<?> builder1) {
			return LootTable.lootTable()
					.withPool(LootPool.lootPool().name("drops").setRolls(ConstantValue.exactly(1.0F))
							.add(LootItem.lootTableItem(block).when(builder).otherwise(builder1)));
		}

		protected static LootTable.Builder createSilkTouchOrShearsDispatchTable(Block block, LootPoolEntryContainer.Builder<?> builder) {
			return createSelfDropDispatchTable(block, HAS_SHEARS_OR_SILK_TOUCH, builder);
		}

		protected LootTable.Builder createLeavesDrops(Block leaves, Block sapling, float... chances) {
			return createSilkTouchOrShearsDispatchTable(leaves, this.applyExplosionCondition(leaves, LootItem.lootTableItem(sapling))
					.when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, chances)))
					.withPool(LootPool.lootPool().name("sticks").setRolls(ConstantValue.exactly(1.0F))
							.when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(this.applyExplosionDecay(leaves, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, NORMAL_LEAVES_STICK_CHANCES))));
		}

		public LootItemCondition.Builder cropConditionBuilder(CropBlock block, IntegerProperty ageProperty) {
			return LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ageProperty, block.getMaxAge()));
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) FarmingRegistry.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
		}
	}


	private static class FarmingRakeDrops extends VanillaGiftLoot {
		@Override
		public void generate(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
			consumer.accept(FarmingLootTables.GAMEPLAY_RAKE_DROPS,
					LootTable.lootTable()
							.withPool(LootPool.lootPool().name("drops").setRolls(ConstantValue.exactly(1.0F))
									.add(LootItem.lootTableItem(FarmingRegistry.APPLE_SAPLING.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.LEMON_SAPLING.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.ORANGE_SAPLING.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.MINT_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.NETHER_FLOWER_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.CHERRY_SAPLING.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.PEAR_SAPLING.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.BANANA_SAPLING.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.AVOCADO_SAPLING.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.MANGO_SAPLING.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.TOMATO_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.CUCUMBER_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.AUBERGINE_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.PINEAPPLE_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.GRAPE_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.CORN_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.ONION_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.GARLIC_SEEDS.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.OLIVE_SAPLING.get()))
									.add(LootItem.lootTableItem(FarmingRegistry.LETTUCE_SEEDS.get()))
							));
		}
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, @Nonnull ValidationContext validationtracker) {
		map.forEach((name, table) -> table.validate(validationtracker));
	}
}