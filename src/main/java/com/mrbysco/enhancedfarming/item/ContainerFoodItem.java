package com.mrbysco.enhancedfarming.item;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.EffectCures;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ContainerFoodItem extends SpecialCustomFoodItem {

	public ContainerFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects, UseAnim action) {
		super(properties, useTime, enchanted, directHeal, cureEffects, action);
	}

	public ContainerFoodItem(Item.Properties properties, int useTime, UseAnim action) {
		this(properties, useTime, false, false, false, action);
	}

	public ContainerFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects) {
		this(properties, useTime, enchanted, directHeal, cureEffects, UseAnim.EAT);
	}

	public ContainerFoodItem(Item.Properties properties, int useTime) {
		this(properties, useTime, false, false, false, UseAnim.EAT);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (!level.isClientSide && cure) livingEntity.removeEffectsCuredBy(EffectCures.MILK);
		if (this.isEdible()) {
			if (directheal) {
				livingEntity.heal(this.getFoodProperties().getNutrition());
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
			ItemStack bowl = stack.getCraftingRemainingItem().copy();

			if (!inventory.add(bowl)) {
				player.spawnAtLocation(bowl, 0F);
			}
		}
		return super.shrinkStack(livingEntity, stack);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
		super.appendHoverText(stack, level, components, flag);
		if (this == FarmingRegistry.BANANA_JUICE.get()) {
			components.add(Component.translatable("enhancedfarming.item.banana_juice.tooltip"));
		}
	}
}