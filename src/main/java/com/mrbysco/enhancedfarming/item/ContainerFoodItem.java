package com.mrbysco.enhancedfarming.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;

public class ContainerFoodItem extends SpecialCustomFoodItem{

	public ContainerFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects, UseAction action) {
		super(properties, useTime, enchanted, directHeal, cureEffects, action);
	}

	public ContainerFoodItem(Item.Properties properties, int useTime, UseAction action) {
		this(properties, useTime, false, false, false, action);
	}

	public ContainerFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects) {
		this(properties, useTime, enchanted, directHeal, cureEffects, UseAction.EAT);
	}

	public ContainerFoodItem(Item.Properties properties, int useTime) {
		this(properties, useTime, false, false, false, UseAction.EAT);
	}

	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity livingEntity) {
		if (!worldIn.isClientSide && cure) livingEntity.curePotionEffects(stack);
		if(this.isEdible()) {
			if(directheal) {
				livingEntity.heal(this.getFoodProperties().getNutrition());
				stack = eatStack(livingEntity, worldIn, stack, false);
			} else {
				stack = eatStack(livingEntity, worldIn, stack, true);
			}
			stack = shrinkStack(livingEntity, stack);
		}
		return stack;
	}

	@Override
	public ItemStack shrinkStack(LivingEntity livingEntity, ItemStack stack) {
		if(livingEntity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) livingEntity;
			PlayerInventory inventory = player.inventory;
			ItemStack bowl = stack.getContainerItem().copy();

			if(!inventory.add(bowl)) {
				player.spawnAtLocation(bowl, 0F);
			}
		}
		return super.shrinkStack(livingEntity, stack);
	}
}