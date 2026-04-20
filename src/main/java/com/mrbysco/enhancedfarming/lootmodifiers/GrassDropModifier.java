package com.mrbysco.enhancedfarming.lootmodifiers;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.Tags.Items;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GrassDropModifier extends LootModifier {
	public static final Supplier<MapCodec<GrassDropModifier>> CODEC = Suppliers.memoize(() ->
			RecordCodecBuilder.mapCodec(inst -> codecStart(inst).apply(inst, GrassDropModifier::new)));

	public GrassDropModifier() {
		super(new LootItemCondition[0], 1000);
	}

	public GrassDropModifier(LootItemCondition[] lootConditions, int priority) {
		super(lootConditions, priority);
	}

	@NotNull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		ServerLevel level = context.getLevel();
		BlockState state = context.getOptionalParameter(LootContextParams.BLOCK_STATE);
		ItemInstance tool = context.getOptionalParameter(LootContextParams.TOOL);
		if (state != null && tool != null && context.getRandom().nextDouble() <= 0.1) {
			if (state.getBlock() instanceof TallGrassBlock && !tool.is(Items.TOOLS_SHEAR) &&
					EnchantmentHelper.getTagEnchantmentLevel(level.holderOrThrow(Enchantments.SILK_TOUCH), tool) <= 0) {
				List<ItemStack> extraLoot = new ArrayList<>();
				if (FarmingConfig.COMMON.seedsFromGrass.get()) {
					extraLoot.add(new ItemStack(FarmingRegistry.MINT_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.NETHER_FLOWER_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.TOMATO_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.CUCUMBER_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.AUBERGINE_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.GRAPE_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.PINEAPPLE_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.CORN_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.ONION_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.GARLIC_SEEDS.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.LETTUCE_SEEDS.get()));
				}
				if (FarmingConfig.COMMON.saplingsFromGrass.get()) {
					extraLoot.add(new ItemStack(FarmingRegistry.APPLE_SAPLING.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.LEMON_SAPLING.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.ORANGE_SAPLING.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.CHERRY_SAPLING.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.PEAR_SAPLING.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.BANANA_SAPLING.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.AVOCADO_SAPLING.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.MANGO_SAPLING.get()));
					extraLoot.add(new ItemStack(FarmingRegistry.OLIVE_SAPLING.get()));
				}

				RandomSource random = context.getRandom();
				if (generatedLoot.isEmpty() && !extraLoot.isEmpty()) {
					generatedLoot.add(extraLoot.get(random.nextInt(extraLoot.size())));
				}
			}
		}

		return generatedLoot;
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}