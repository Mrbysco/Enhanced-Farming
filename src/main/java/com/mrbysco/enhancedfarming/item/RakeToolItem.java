package com.mrbysco.enhancedfarming.item;

import com.mrbysco.enhancedfarming.init.FarmingActions;
import com.mrbysco.enhancedfarming.init.FarmingLootTables;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ItemAbility;

public class RakeToolItem extends DiggerItem {
	private final int dropModifier;

	public RakeToolItem(Tier itemTier, int dropModifier, Item.Properties properties) {
		super(itemTier, BlockTags.MINEABLE_WITH_SHOVEL, properties);
		this.dropModifier = dropModifier;
	}

	public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed) {
		return ItemAttributeModifiers.builder()
				.add(
						Attributes.ATTACK_DAMAGE,
						new AttributeModifier(
								ResourceLocation.fromNamespaceAndPath("enhancedfarming", "rake_attack_damage"), (double) (attackDamage + tier.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE
						),
						EquipmentSlotGroup.MAINHAND
				)
				.add(
						Attributes.ATTACK_SPEED,
						new AttributeModifier(ResourceLocation.fromNamespaceAndPath("enhancedfarming", "rake_attack_speed"), (double) attackSpeed, AttributeModifier.Operation.ADD_VALUE),
						EquipmentSlotGroup.MAINHAND
				)
				.build();
	}

	public void dropSeedsWithChance(ItemStack toolStack, Level level, BlockPos pos) {
		if (this.dropModifier == 0) {
			return;
		}
		final int rand = level.random.nextInt(30 / this.dropModifier);
		if (!level.isClientSide && rand == 0 && level.getServer() != null) {
			LootTable table = level.getServer().reloadableRegistries().getLootTable(FarmingLootTables.GAMEPLAY_RAKE_DROPS);
			LootParams.Builder lootParams = (new LootParams.Builder((ServerLevel) level))
					.withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
					.withParameter(LootContextParams.TOOL, toolStack);
			table.getRandomItems(lootParams.create(LootContextParamSets.EMPTY)).forEach(stack ->
					level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY() + 0.2, pos.getZ(), stack)));
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
					context.getItemInHand().hurtAndBreak(1, player, Player.getSlotForHand(context.getHand()));
					this.dropSeedsWithChance(context.getItemInHand(), level, blockpos);
				}
			}

			return InteractionResult.sidedSuccess(level.isClientSide);
		} else {
			return InteractionResult.PASS;
		}
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ItemAbility toolAction) {
		return FarmingActions.DEFAULT_RAKE_ACTIONS.contains(toolAction);
	}
}