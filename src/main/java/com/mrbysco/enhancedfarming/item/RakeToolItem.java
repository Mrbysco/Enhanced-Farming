package com.mrbysco.enhancedfarming.item;

import com.mrbysco.enhancedfarming.init.FarmingActions;
import com.mrbysco.enhancedfarming.init.FarmingLootTables;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ToolAction;

public class RakeToolItem extends DiggerItem {
	private final int dropModifier;

	public RakeToolItem(Tier itemTier, int attackDamage, float attackSpeed, int dropModifier, Item.Properties properties) {
		super((float) attackDamage, attackSpeed, itemTier, BlockTags.MINEABLE_WITH_SHOVEL, properties);
		this.dropModifier = dropModifier;
	}

	public void dropSeedsWithChance(ItemStack itemstack, Level level, BlockPos pos) {
		final int rand = level.random.nextInt(30 / this.dropModifier);
		if (!level.isClientSide && rand == 0 && level.getServer() != null) {
			LootTable table = level.getServer().getLootTables().get(FarmingLootTables.GAMEPLAY_RAKE_DROPS);
			LootContext.Builder context = (new LootContext.Builder((ServerLevel) level)).withParameter(LootContextParams.ORIGIN, new Vec3(pos.getX(), pos.getY(), pos.getZ()))
					.withParameter(LootContextParams.TOOL, itemstack).withRandom(level.random);
			table.getRandomItems(context.create(LootContextParamSets.EMPTY)).forEach(stack -> level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 0.2, pos.getZ(), stack)));
		}
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Player player = context.getPlayer();
		Level level = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		BlockState blockstate = level.getBlockState(blockpos);
		BlockState modifiedState = blockstate.getToolModifiedState(context, FarmingActions.RAKE_GATHER, false);
		BlockState finalState = null;
		if (modifiedState != null && level.isEmptyBlock(blockpos.above())) {
			level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
			finalState = modifiedState;
		}

		if (finalState != null) {
			if (!level.isClientSide) {
				level.setBlock(blockpos, finalState, 11);
				if (player != null) {
					context.getItemInHand().hurtAndBreak(1, player, (thePlayer) -> {
						thePlayer.broadcastBreakEvent(context.getHand());
					});
					this.dropSeedsWithChance(context.getItemInHand(), level, blockpos);
				}
			}

			return InteractionResult.sidedSuccess(level.isClientSide);
		} else {
			return InteractionResult.PASS;
		}
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
		return FarmingActions.DEFAULT_RAKE_ACTIONS.contains(toolAction);
	}
}