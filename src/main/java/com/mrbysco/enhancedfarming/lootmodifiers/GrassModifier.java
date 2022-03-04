package com.mrbysco.enhancedfarming.lootmodifiers;

import com.google.gson.JsonObject;
import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.config.FarmingConfig;
import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = Bus.MOD)
public class GrassModifier {
	@SubscribeEvent
	public static void registerModifiers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
		event.getRegistry().register(
				new GrassDropSerializer().setRegistryName(Reference.MOD_ID, "enhanced_seed_drops")
		);
	}

	public static class GrassDropSerializer extends GlobalLootModifierSerializer<GrassDropModifier> {

		@Override
		public GrassDropModifier read(ResourceLocation location, JsonObject jsonObject, LootItemCondition[] lootConditions) {
			return new GrassDropModifier(lootConditions);
		}

		@Override
		public JsonObject write(GrassDropModifier instance) {
			return new JsonObject();
		}
	}

	private static class GrassDropModifier extends LootModifier {
		protected GrassDropModifier(LootItemCondition[] lootConditions) {
			super(lootConditions);
		}

		@Nonnull
		@Override
		protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
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

			Random random = context.getRandom();
			if (generatedLoot.isEmpty() && !extraLoot.isEmpty()) {
				generatedLoot.add(extraLoot.get(random.nextInt(extraLoot.size())));
			}

			return generatedLoot;
		}
	}
}
