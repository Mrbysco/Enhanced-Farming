package com.mrbysco.enhancedfarming.item;

import com.google.common.collect.Sets;
import com.mrbysco.enhancedfarming.init.FarmingLootTables;
import com.mrbysco.enhancedfarming.init.FarmingTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Set;

public class RakeToolItem extends ToolItem {
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.MYCELIUM, Blocks.PODZOL, Blocks.COARSE_DIRT);
	private final int dropModifier;

	public RakeToolItem(IItemTier itemTier, int attackDamage, float attackSpeed, int dropModifier, Item.Properties properties) {
		super((float)attackDamage, attackSpeed, itemTier, EFFECTIVE_ON, properties.addToolType(net.minecraftforge.common.ToolType.get("rake"), itemTier.getLevel()));
		this.dropModifier = dropModifier;
	}

    public void dropSeedsWithChance(ItemStack itemstack, World worldIn, BlockPos pos) {
		if (!worldIn.isClientSide && worldIn.random.nextInt(30 / this.dropModifier) == 0) {
			LootTable table = worldIn.getServer().getLootTables().get(FarmingLootTables.GAMEPLAY_RAKE_DROPS);
			LootContext.Builder context = (new LootContext.Builder((ServerWorld)worldIn)).withParameter(LootParameters.ORIGIN, new Vector3d(pos.getX(), pos.getY(), pos.getZ()))
					.withParameter(LootParameters.TOOL, itemstack).withRandom(worldIn.random);
			table.getRandomItems(context.create(LootParameterSets.EMPTY)).forEach(stack -> worldIn.addFreshEntity(new ItemEntity(worldIn, pos.getX(), pos.getY() + 0.2, pos.getZ(),stack)));
		}
    }

	@Override
	public ActionResultType useOn(ItemUseContext context) {
		World world = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		if (context.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockpos.above())) {
			if(world.getBlockState(blockpos).is(FarmingTags.RAKE_BLOCKS)) {
				BlockState dirtState = Blocks.DIRT.defaultBlockState();
				PlayerEntity playerentity = context.getPlayer();
				world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
				if (!world.isClientSide) {
					world.setBlock(blockpos, dirtState, 11);
					if (playerentity != null) {
						context.getItemInHand().hurtAndBreak(1, playerentity, (playerEntity) -> playerEntity.broadcastBreakEvent(context.getHand()));
						this.dropSeedsWithChance(context.getItemInHand(), world, blockpos);
					}
				}
			}
			return ActionResultType.sidedSuccess(world.isClientSide);
		}

		return ActionResultType.PASS;
	}
}