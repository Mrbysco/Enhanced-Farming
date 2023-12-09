package com.mrbysco.enhancedfarming.handler;

import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.event.level.PistonEvent;
import net.neoforged.bus.api.SubscribeEvent;

import java.util.List;

public class InWorldCraftingHandler {
	@SubscribeEvent
	public void InWorldCrafting(PistonEvent.Post event) {
		final LevelAccessor levelAccessor = event.getLevel();
		if (!levelAccessor.isClientSide() && event.getPistonMoveType() == PistonEvent.PistonMoveType.EXTEND) {
			final ServerLevel serverLevel = (ServerLevel) levelAccessor;
			final BlockPos pos = event.getFaceOffsetPos();
			final float range = 1F;
			List<ItemEntity> itemEntities = serverLevel.getEntitiesOfClass(ItemEntity.class,
					new AABB(pos.getX() - 1, pos.getY() - range, pos.getZ() - range,
							pos.getX() + range, pos.getY() + range, pos.getZ() + range));

			if (!itemEntities.isEmpty()) {
				for (ItemEntity itemEntity : itemEntities) {
					BlockPos itemPos = itemEntity.blockPosition();
					Container inventory = new SimpleContainer(itemEntity.getItem().copy());
					RecipeHolder<PistonRecipe> recipeHolder = serverLevel.getRecipeManager().getRecipeFor(FarmingRecipes.PISTON_CRAFTING_TYPE.get(), inventory, serverLevel).orElse(null);
					if (recipeHolder != null) {
						ItemStack stack = itemEntity.getItem();
						int craftPer = 0;
						int craftCount = 0;
						PistonRecipe recipe = recipeHolder.value();
						if (!recipe.getIngredients().get(0).isEmpty()) {
							ItemStack[] ingredients = recipe.getIngredients().get(0).getItems();
							for (ItemStack ingredient : ingredients) {
								if (ingredient.getItem() == stack.getItem()) {
									craftPer = ingredient.getCount();
									craftCount = (int) Math.ceil((double) stack.getCount() / ingredient.getCount());
									break;
								}
							}
						}
						if (craftCount > 0) {
							int total = (craftCount * craftPer);
							ItemStack result = recipe.getResultItem(levelAccessor.registryAccess()).copy();
							int maxResultSize = result.getMaxStackSize();
							if (total <= maxResultSize) {
								stack.shrink(total);
								if (stack.isEmpty()) {
									itemEntity.remove(RemovalReason.DISCARDED);
								} else {
									itemEntity.setItem(stack);
								}

								result.setCount(total);
								ItemEntity newItemEntity = new ItemEntity(serverLevel, itemPos.getX(), itemPos.getY(), itemPos.getZ(), result);
								serverLevel.addFreshEntity(newItemEntity);
							} else {
								int totalStacks = (int) Math.floor((double) total / maxResultSize);

								int currentTotal = total;
								for (int i = 0; i < totalStacks; i++) {
									ItemStack newStack = recipe.getResultItem(levelAccessor.registryAccess()).copy();
									if (currentTotal > maxResultSize) {
										newStack.setCount(maxResultSize);
										currentTotal -= maxResultSize;
									} else {
										newStack.setCount(currentTotal);
									}

									ItemEntity newItemEntity = new ItemEntity(serverLevel, itemPos.getX(), itemPos.getY(), itemPos.getZ(), newStack);
									serverLevel.addFreshEntity(newItemEntity);
								}
							}
						}
					}
				}
			}
		}
	}
}
