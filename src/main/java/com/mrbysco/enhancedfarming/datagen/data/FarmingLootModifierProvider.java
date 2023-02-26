package com.mrbysco.enhancedfarming.datagen.data;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.init.FarmingLootModifiers;
import com.mrbysco.enhancedfarming.lootmodifiers.GrassDropModifier;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.AlternativeLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.InvertedLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class FarmingLootModifierProvider extends GlobalLootModifierProvider {
	public FarmingLootModifierProvider(DataGenerator generator) {
		super(generator, Reference.MOD_ID);
	}

	@Override
	protected void start() {
		this.add("grass_drops", FarmingLootModifiers.ENHANCED_SEED_DROPS.get(), new GrassDropModifier(
				new LootItemCondition[]{
						LootItemRandomChanceCondition.randomChance(0.1F).build(),
						InvertedLootItemCondition.invert(
								MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS))
						).build(),
						AlternativeLootItemCondition.alternative(
								LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS),
								LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS),
								LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FERN),
								LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.LARGE_FERN)
						).build()
				})
		);
	}
}