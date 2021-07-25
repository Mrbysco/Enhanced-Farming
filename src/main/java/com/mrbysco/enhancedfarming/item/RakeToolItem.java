package com.mrbysco.enhancedfarming.item;

import com.mrbysco.enhancedfarming.init.FarmingLootTables;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

public class RakeToolItem extends DiggerItem {
	private final int dropModifier;

	public RakeToolItem(Tier itemTier, int attackDamage, float attackSpeed, int dropModifier, Item.Properties properties) {
		super((float)attackDamage, attackSpeed, itemTier, BlockTags.MINEABLE_WITH_SHOVEL, properties.addToolType(net.minecraftforge.common.ToolType.get("rake"), itemTier.getLevel()));
		this.dropModifier = dropModifier;
	}

    public void dropSeedsWithChance(ItemStack itemstack, Level worldIn, BlockPos pos) {
		if (!worldIn.isClientSide && worldIn.random.nextInt(30 / this.dropModifier) == 0 && worldIn.getServer() != null) {
			LootTable table = worldIn.getServer().getLootTables().get(FarmingLootTables.GAMEPLAY_RAKE_DROPS);
			LootContext.Builder context = (new LootContext.Builder((ServerLevel)worldIn)).withParameter(LootContextParams.ORIGIN, new Vec3(pos.getX(), pos.getY(), pos.getZ()))
					.withParameter(LootContextParams.TOOL, itemstack).withRandom(worldIn.random);
			table.getRandomItems(context.create(LootContextParamSets.EMPTY)).forEach(stack -> worldIn.addFreshEntity(new ItemEntity(worldIn, pos.getX(), pos.getY() + 0.2, pos.getZ(),stack)));
		}
    }

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		if (context.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockpos.above())) {
			if(world.getBlockState(blockpos).is(FarmingTags.RAKE_BLOCKS)) {
				BlockState dirtState = Blocks.DIRT.defaultBlockState();
				Player playerentity = context.getPlayer();
				world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
				if (!world.isClientSide) {
					world.setBlock(blockpos, dirtState, 11);
					if (playerentity != null) {
						context.getItemInHand().hurtAndBreak(1, playerentity, (playerEntity) -> playerEntity.broadcastBreakEvent(context.getHand()));
						this.dropSeedsWithChance(context.getItemInHand(), world, blockpos);
					}
				}
			}
			return InteractionResult.sidedSuccess(world.isClientSide);
		}

		return InteractionResult.PASS;
	}
}