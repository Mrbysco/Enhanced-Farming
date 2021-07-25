package com.mrbysco.enhancedfarming.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class ContainerFoodItem extends SpecialCustomFoodItem{

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

	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity livingEntity) {
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
		if(livingEntity instanceof Player player) {
			Inventory inventory = player.getInventory();
			ItemStack bowl = stack.getContainerItem().copy();

			if(!inventory.add(bowl)) {
				player.spawnAtLocation(bowl, 0F);
			}
		}
		return super.shrinkStack(livingEntity, stack);
	}
}