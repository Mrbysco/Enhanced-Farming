package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.init.FarmingLootTables;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaGiftLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

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
		private final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
		private final float[] JUNGLE_LEAVES_SAPLING_CHANGES = new float[]{0.025F, 0.027777778F, 0.03125F, 0.041666668F, 0.1F};

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

			this.add(FarmingRegistry.MINT_CROP.get(), (block) -> createCropDrops(FarmingRegistry.MINT_CROP.get(), FarmingRegistry.MINT.get(), FarmingRegistry.MINT_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.MINT_CROP.get())));
			LootItemCondition.Builder netherBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(FarmingRegistry.NETHER_FLOWER_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(NetherFlowerBlock.AGE, 5));
			this.add(FarmingRegistry.NETHER_FLOWER_CROP.get(), (block) -> createCropDrops(FarmingRegistry.NETHER_FLOWER_CROP.get(), Items.BLAZE_ROD, FarmingRegistry.NETHER_FLOWER_SEEDS.get(), netherBuilder));
			this.add(FarmingRegistry.TOMATO_CROP.get(), (block) -> createCropDrops(FarmingRegistry.TOMATO_CROP.get(), FarmingRegistry.TOMATO.get(), FarmingRegistry.TOMATO_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.TOMATO_CROP.get())));
			this.add(FarmingRegistry.CUCUMBER_CROP.get(), (block) -> createCropDrops(FarmingRegistry.CUCUMBER_CROP.get(), FarmingRegistry.CUCUMBER.get(), FarmingRegistry.CUCUMBER_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.CUCUMBER_CROP.get())));
			this.add(FarmingRegistry.AUBERGINE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.AUBERGINE_CROP.get(), FarmingRegistry.AUBERGINE.get(), FarmingRegistry.AUBERGINE_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.AUBERGINE_CROP.get())));
			this.add(FarmingRegistry.GRAPE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.GRAPE_CROP.get(), FarmingRegistry.GRAPES.get(), FarmingRegistry.GRAPE_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.GRAPE_CROP.get())));
			this.add(FarmingRegistry.PINEAPPLE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.PINEAPPLE_CROP.get(), FarmingRegistry.PINEAPPLE.get(), FarmingRegistry.PINEAPPLE_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.PINEAPPLE_CROP.get())));
			this.add(FarmingRegistry.CORN_CROP.get(), (block) -> createCropDrops(FarmingRegistry.CORN_CROP.get(), FarmingRegistry.CORN.get(), FarmingRegistry.CORN_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.CORN_CROP.get())));
			this.add(FarmingRegistry.ONION_CROP.get(), (block) -> createCropDrops(FarmingRegistry.ONION_CROP.get(), FarmingRegistry.ONION.get(), FarmingRegistry.ONION_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.ONION_CROP.get())));
			this.add(FarmingRegistry.GARLIC_CROP.get(), (block) -> createCropDrops(FarmingRegistry.GARLIC_CROP.get(), FarmingRegistry.GARLIC.get(), FarmingRegistry.GARLIC_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.GARLIC_CROP.get())));
			this.add(FarmingRegistry.LETTUCE_CROP.get(), (block) -> createCropDrops(FarmingRegistry.LETTUCE_CROP.get(), FarmingRegistry.LETTUCE.get(), FarmingRegistry.LETTUCE_SEEDS.get(), getBuilder((CropBlock) FarmingRegistry.LETTUCE_CROP.get())));

			this.dropSelf(FarmingRegistry.SCARECROW.get());
		}

		public LootItemCondition.Builder getBuilder(CropBlock block) {
			return LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(block.getAgeProperty(), block.getMaxAge()));
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) FarmingRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
		}
	}


	private static class FarmingRakeDrops extends VanillaGiftLoot {
		@Override
		public void generate(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
			consumer.accept(FarmingLootTables.GAMEPLAY_RAKE_DROPS,
					LootTable.lootTable()
							.withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
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
		map.forEach((name, table) -> LootTables.validate(validationtracker, name, table));
	}
}