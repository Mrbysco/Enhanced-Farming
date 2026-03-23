package com.mrbysco.enhancedfarming.item;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class ContainerFoodItem extends SpecialCustomFoodItem {

	public ContainerFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects, ItemUseAnimation action) {
		super(properties, useTime, enchanted, directHeal, cureEffects, action);
	}

	public ContainerFoodItem(Item.Properties properties, int useTime, ItemUseAnimation action) {
		this(properties, useTime, false, false, false, action);
	}

	public ContainerFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects) {
		this(properties, useTime, enchanted, directHeal, cureEffects, ItemUseAnimation.EAT);
	}

	public ContainerFoodItem(Item.Properties properties, int useTime) {
		this(properties, useTime, false, false, false, ItemUseAnimation.EAT);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (!level.isClientSide() && cure) ClearAllStatusEffectsConsumeEffect.INSTANCE.apply(level, stack, livingEntity);
		if (stack.has(DataComponents.FOOD)) {
			if (directheal) {
				livingEntity.heal(stack.get(DataComponents.FOOD).nutrition());
				stack = eatStack(livingEntity, level, stack, false);
			} else {
				stack = eatStack(livingEntity, level, stack, true);
			}
			stack = shrinkStack(livingEntity, stack);
		}
		return stack;
	}

	@Override
	public ItemStack shrinkStack(LivingEntity livingEntity, ItemStack stack) {
		if (livingEntity instanceof Player player) {
			Inventory inventory = player.getInventory();
			ItemStack bowl = stack.getCraftingRemainder().copy();

			if (!inventory.add(bowl) && livingEntity.level() instanceof ServerLevel serverLevel) {
				player.spawnAtLocation(serverLevel, bowl, 0F);
			}
		}
		return super.shrinkStack(livingEntity, stack);
	}

	@Override
	public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
		super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, flag);
		if (this == FarmingRegistry.BANANA_JUICE.get()) {
			tooltipAdder.accept(Component.translatable("enhancedfarming.item.banana_juice.tooltip"));
		}
	}
}