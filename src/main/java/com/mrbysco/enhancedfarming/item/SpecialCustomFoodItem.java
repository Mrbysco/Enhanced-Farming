package com.mrbysco.enhancedfarming.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import net.minecraft.world.level.Level;

public class SpecialCustomFoodItem extends CustomFoodItem {

	private final boolean enchanted;
	public final boolean directheal;
	public final boolean cure;

	public SpecialCustomFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects, ItemUseAnimation action) {
		super(properties, useTime, action);

		this.enchanted = enchanted;
		this.directheal = directHeal;
		this.cure = cureEffects;
	}

	public SpecialCustomFoodItem(Item.Properties properties, int useTime, boolean enchanted, ItemUseAnimation action) {
		this(properties, useTime, enchanted, false, false, action);
	}

	public SpecialCustomFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects) {
		this(properties, useTime, enchanted, directHeal, cureEffects, ItemUseAnimation.EAT);
	}

	public SpecialCustomFoodItem(Item.Properties properties, int useTime, boolean enchanted) {
		this(properties, useTime, enchanted, false, false, ItemUseAnimation.EAT);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (!level.isClientSide && cure) ClearAllStatusEffectsConsumeEffect.INSTANCE.apply(level, stack, livingEntity);
		if (stack.has(DataComponents.FOOD)) {
			if (directheal) {
				livingEntity.heal(stack.get(DataComponents.FOOD).nutrition());
				stack = eatStack(livingEntity, level, stack, false);
			} else {
				stack = eatStack(livingEntity, level, stack, true);
			}
			shrinkStack(livingEntity, stack);
		}
		return stack;
	}

	public ItemStack shrinkStack(LivingEntity livingEntity, ItemStack stack) {
		if (!(livingEntity instanceof Player) || !((Player) livingEntity).getAbilities().instabuild) {
			stack.shrink(1);
		}
		return stack;
	}

	public ItemStack eatStack(LivingEntity livingEntity, Level level, ItemStack stack, boolean useFood) {
		if (livingEntity instanceof Player player) {
			if (useFood) {
				player.getFoodData().eat(stack.get(DataComponents.FOOD));
			}
			player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
			level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
			if (player instanceof ServerPlayer) {
				CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer) player, stack);
			}
		} else {
			Consumable consumable = stack.get(DataComponents.CONSUMABLE);
			if (consumable != null) {
				level.playSound((Player) null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), consumable.sound(), SoundSource.NEUTRAL, 1.0F, 1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.4F);
				consumable.onConsume(level, livingEntity, stack);
			}
		}
		return stack;
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return this.enchanted;
	}
}
