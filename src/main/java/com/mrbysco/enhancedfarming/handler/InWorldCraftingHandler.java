package com.mrbysco.enhancedfarming.handler;

import com.mrbysco.enhancedfarming.recipes.FarmingRecipeTypes;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.world.PistonEvent;
import net.minecraftforge.event.world.PistonEvent.PistonMoveType;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class InWorldCraftingHandler {
	@SubscribeEvent
	public void InWorldCrafting(PistonEvent.Post event) {
		if (!event.getWorld().isClientSide() && event.getPistonMoveType() == PistonMoveType.EXTEND) {
			final ServerLevel world = (ServerLevel) event.getWorld();
			final BlockPos pos = event.getFaceOffsetPos();
			final float range = 1F;
			List<ItemEntity> itemEntities = world.getEntitiesOfClass(ItemEntity.class,
					new AABB(pos.getX() - 1, pos.getY() - range, pos.getZ() - range,
							pos.getX() + range, pos.getY() + range, pos.getZ() + range));

			if (!itemEntities.isEmpty()) {
				for (ItemEntity itemEntity : itemEntities) {
					BlockPos itemPos = itemEntity.blockPosition();
					Container inventory = createInventory(itemEntity);
					PistonRecipe recipe = world.getRecipeManager().getRecipeFor(FarmingRecipeTypes.PISTON_CRAFTING_TYPE, inventory, world).orElse(null);
					if (recipe != null) {
						ItemStack stack = itemEntity.getItem();
						int craftPer = 0;
						int craftCount = 0;
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
							ItemStack result = recipe.getResultItem().copy();
							int maxResultSize = result.getMaxStackSize();
							if (total <= maxResultSize) {
								stack.shrink(total);
								if (stack.isEmpty()) {
									itemEntity.remove(RemovalReason.DISCARDED);
								} else {
									itemEntity.setItem(stack);
								}

								result.setCount(total);
								ItemEntity newItemEntity = new ItemEntity(world, itemPos.getX(), itemPos.getY(), itemPos.getZ(), result);
								world.addFreshEntity(newItemEntity);
							} else {
								int totalStacks = (int) Math.floor((double) total / maxResultSize);

								int currentTotal = total;
								for (int i = 0; i < totalStacks; i++) {
									ItemStack newStack = recipe.getResultItem().copy();
									if (currentTotal > maxResultSize) {
										newStack.setCount(maxResultSize);
										currentTotal -= maxResultSize;
									} else {
										newStack.setCount(currentTotal);
									}

									ItemEntity newItemEntity = new ItemEntity(world, itemPos.getX(), itemPos.getY(), itemPos.getZ(), newStack);
									world.addFreshEntity(newItemEntity);
								}
							}
						}
					}
				}
			}
		}
	}

	public SingularInventory createInventory(ItemEntity itemEntity) {
		SingularInventory inventory = new SingularInventory();
		inventory.setItem(0, itemEntity.getItem().copy());
		return inventory;
	}

	public static class SingularInventory implements Container {
		private final NonNullList<ItemStack> itemStacks = NonNullList.withSize(1, ItemStack.EMPTY);

		public int getContainerSize() {
			return 1;
		}

		public boolean isEmpty() {
			for (ItemStack itemstack : this.itemStacks) {
				if (!itemstack.isEmpty()) {
					return false;
				}
			}

			return true;
		}

		public ItemStack getItem(int slot) {
			return this.itemStacks.get(0);
		}

		public ItemStack removeItem(int slot, int p_70298_2_) {
			return ContainerHelper.takeItem(this.itemStacks, 0);
		}

		public ItemStack removeItemNoUpdate(int slot) {
			return ContainerHelper.takeItem(this.itemStacks, 0);
		}

		public void setItem(int slot, ItemStack stack) {
			this.itemStacks.set(0, stack);
		}

		public void setChanged() {
		}

		public boolean stillValid(Player player) {
			return true;
		}

		public void clearContent() {
			this.itemStacks.clear();
		}
	}
}
