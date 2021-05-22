package com.mrbysco.enhancedfarming.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class SpecialCustomFoodItem extends CustomFoodItem {
	
	private boolean enchanted;
	public boolean directheal;
	public boolean cure;

	public SpecialCustomFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects, UseAction action) {
		super(properties, useTime, action);

		this.enchanted = enchanted;
		this.directheal = directHeal;
		this.cure = cureEffects;
	}

	public SpecialCustomFoodItem(Item.Properties properties, int useTime, boolean enchanted, UseAction action) {
		this(properties, useTime, enchanted, false, false, action);
	}

	public SpecialCustomFoodItem(Item.Properties properties, int useTime, boolean enchanted, boolean directHeal, boolean cureEffects) {
		this(properties, useTime, enchanted, directHeal, cureEffects, UseAction.EAT);
	}

	public SpecialCustomFoodItem(Item.Properties properties, int useTime, boolean enchanted) {
		this(properties, useTime, enchanted, false, false, UseAction.EAT);
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
			shrinkStack(livingEntity, stack);
		}
        return stack;
    }

	public ItemStack shrinkStack(LivingEntity livingEntity, ItemStack stack) {
		if (!(livingEntity instanceof PlayerEntity) || !((PlayerEntity)livingEntity).abilities.instabuild) {
			stack.shrink(1);
		}
		return stack;
	}

    public ItemStack eatStack(LivingEntity livingEntity, World worldIn, ItemStack stack, boolean useFood) {
		if(livingEntity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) livingEntity;
			if(useFood) {
				player.getFoodData().eat(stack.getItem(), stack);
			}
			player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
			worldIn.playSound((PlayerEntity)null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, random.nextFloat() * 0.1F + 0.9F);
			if (player instanceof ServerPlayerEntity) {
				CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)player, stack);
			}
		} else {
			worldIn.playSound((PlayerEntity)null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), livingEntity.getEatingSound(stack), SoundCategory.NEUTRAL, 1.0F, 1.0F + (random.nextFloat() - random.nextFloat()) * 0.4F);
			livingEntity.addEatEffect(stack, worldIn, livingEntity);
		}
		return stack;
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return this.enchanted;
	}
}
