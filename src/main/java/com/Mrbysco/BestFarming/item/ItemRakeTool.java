package com.Mrbysco.BestFarming.item;

import java.util.Random;
import java.util.Set;

import com.Mrbysco.BestFarming.BestFarming;
import com.Mrbysco.BestFarming.Reference;
import com.Mrbysco.BestFarming.config.FarmingConfigGen;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemRakeTool extends ItemTool{

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.CONCRETE_POWDER);
	private int dropModifier;
	
    private static final float[] ATTACK_DAMAGES = new float[] {5.0F, 7.0F, 7.0F, 7.0F, 5.0F};
    private static final float[] ATTACK_SPEEDS = new float[] { -3.2F, -3.2F, -3.1F, -3.0F, -3.0F};
    
    public ItemRakeTool(Item.ToolMaterial material, int dropModifier, String unlocalizedName, String registryName)
    {
        super(material, EFFECTIVE_ON);
        this.dropModifier = dropModifier;
        
        this.attackDamage = ATTACK_DAMAGES[material.ordinal()];
        this.attackSpeed = ATTACK_SPEEDS[material.ordinal()];
        
        setCreativeTab(BestFarming.tabFarming);
		this.setUnlocalizedName(Reference.MOD_PREFIX + unlocalizedName);
		this.setRegistryName(registryName);
    }
    
    public void dropSeedsWithChance(World worldIn, BlockPos pos) {
    	final Random rand = new Random();
    	
    	String[] rakeDrops = FarmingConfigGen.general.othersettings.rakeDrops;
    	
    	int rDrop = new Random().nextInt(rakeDrops.length);
    	String randomDrop = (rakeDrops[rDrop]);
    	
    	if (rand.nextInt(30 / this.dropModifier) == 0) {    	
    		worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY() + 0.2, pos.getZ(), new ItemStack(Item.getByNameOrId(randomDrop))));
    	}
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (facing != EnumFacing.DOWN && worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR && block == Blocks.GRASS)
            {
                IBlockState iblockstate1 = Blocks.DIRT.getDefaultState();
                worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (!worldIn.isRemote)
                {
                    worldIn.setBlockState(pos, iblockstate1, 11);
                    itemstack.damageItem(1, player);
                    
                    this.dropSeedsWithChance(worldIn, pos);
                }

                return EnumActionResult.SUCCESS;
            }
            else
            {
                return EnumActionResult.PASS;
            }
        }
    }
}