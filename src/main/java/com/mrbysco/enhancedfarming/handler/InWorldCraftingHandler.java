package com.mrbysco.enhancedfarming.handler;

import com.mrbysco.enhancedfarming.recipes.FarmingRecipes;
import com.mrbysco.enhancedfarming.recipes.PistonRecipe;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.PistonEvent;
import net.minecraftforge.event.world.PistonEvent.PistonMoveType;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class InWorldCraftingHandler {
	@SubscribeEvent
	public void InWorldCrafting(PistonEvent.Post event) {
		if(!event.getWorld().isClientSide() && event.getPistonMoveType() == PistonMoveType.EXTEND) {
			final ServerWorld world = (ServerWorld)event.getWorld();
			final BlockPos pos = event.getFaceOffsetPos();
			final float range = 1F;
			List<ItemEntity> itemEntities = world.getEntitiesOfClass(ItemEntity.class,
					new AxisAlignedBB(pos.getX() - 1, pos.getY() - range, pos.getZ() - range,
							pos.getX() + range, pos.getY() + range, pos.getZ() + range));

			if(!itemEntities.isEmpty()) {
				for(ItemEntity itemEntity : itemEntities) {
					BlockPos itemPos = itemEntity.blockPosition();
					IInventory inventory = createInventory(itemEntity);
					PistonRecipe recipe = world.getRecipeManager().getRecipeFor(FarmingRecipes.PISTON_CRAFTING_TYPE, inventory, world).orElse(null);
					if (recipe != null) {
						ItemStack stack = itemEntity.getItem();
						int craftPer = 0;
						int craftCount = 0;
						if(!recipe.getIngredients().get(0).isEmpty()) {
							ItemStack[] ingredients = recipe.getIngredients().get(0).getItems();
							for(ItemStack ingredient : ingredients) {
								if(ingredient.getItem() == stack.getItem()) {
									craftPer = ingredient.getCount();
									craftCount = (int)Math.ceil((double)stack.getCount() / ingredient.getCount());
									break;
								}
							}
						}
						if(craftCount > 0) {
							int total = (craftCount * craftPer);
							ItemStack result = recipe.getResultItem().copy();
							int maxResultSize = result.getMaxStackSize();
							if(total <= maxResultSize) {
								stack.shrink(total);
								if(stack.isEmpty()) {
									itemEntity.remove();
								} else {
									itemEntity.setItem(stack);
								}

								result.setCount(total);
								ItemEntity newItemEntity = new ItemEntity(world, itemPos.getX(), itemPos.getY(), itemPos.getZ(), result);
								world.addFreshEntity(newItemEntity);
							} else {
								int totalStacks = (int) Math.floor((double)total / maxResultSize);

								int currentTotal = total;
								for(int i = 0; i < totalStacks; i++) {
									ItemStack newStack = recipe.getResultItem().copy();
									if(currentTotal > maxResultSize) {
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

	public static class SingularInventory implements IInventory {
		private final NonNullList<ItemStack> itemStacks = NonNullList.withSize(1, ItemStack.EMPTY);

		public int getContainerSize() {
			return 1;
		}

		public boolean isEmpty() {
			for(ItemStack itemstack : this.itemStacks) {
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
			return ItemStackHelper.takeItem(this.itemStacks, 0);
		}

		public ItemStack removeItemNoUpdate(int slot) {
			return ItemStackHelper.takeItem(this.itemStacks, 0);
		}

		public void setItem(int slot, ItemStack stack) {
			this.itemStacks.set(0, stack);
		}

		public void setChanged() {
		}

		public boolean stillValid(PlayerEntity player) {
			return true;
		}

		public void clearContent() {
			this.itemStacks.clear();
		}
	}
}
