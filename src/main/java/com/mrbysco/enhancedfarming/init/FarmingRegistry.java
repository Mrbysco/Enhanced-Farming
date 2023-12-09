package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.Reference;
import com.mrbysco.enhancedfarming.block.CropStickBlock;
import com.mrbysco.enhancedfarming.block.FruitLeavesBlock;
import com.mrbysco.enhancedfarming.block.GrowableSaplingBlock;
import com.mrbysco.enhancedfarming.block.ScarecrowBlock;
import com.mrbysco.enhancedfarming.block.crops.CropstickCropBlock;
import com.mrbysco.enhancedfarming.block.crops.FiveAgeCropBlock;
import com.mrbysco.enhancedfarming.block.crops.NetherFlowerBlock;
import com.mrbysco.enhancedfarming.block.crops.SevenAgeCropBlock;
import com.mrbysco.enhancedfarming.block.crops.SixAgeCropBlock;
import com.mrbysco.enhancedfarming.blockentity.ScarecrowBlockEntity;
import com.mrbysco.enhancedfarming.item.ContainerFoodItem;
import com.mrbysco.enhancedfarming.item.CropsticksSeedsBlock;
import com.mrbysco.enhancedfarming.item.CustomFoodItem;
import com.mrbysco.enhancedfarming.item.CustomUtensilItem;
import com.mrbysco.enhancedfarming.item.RakeToolItem;
import com.mrbysco.enhancedfarming.item.SpecialCustomFoodItem;
import com.mrbysco.enhancedfarming.world.tree.AppleTree;
import com.mrbysco.enhancedfarming.world.tree.AvocadoTree;
import com.mrbysco.enhancedfarming.world.tree.BananaTree;
import com.mrbysco.enhancedfarming.world.tree.CherryTree;
import com.mrbysco.enhancedfarming.world.tree.LemonTree;
import com.mrbysco.enhancedfarming.world.tree.MangoTree;
import com.mrbysco.enhancedfarming.world.tree.OliveTree;
import com.mrbysco.enhancedfarming.world.tree.OrangeTree;
import com.mrbysco.enhancedfarming.world.tree.PearTree;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

public class FarmingRegistry {
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Reference.MOD_ID);
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Reference.MOD_ID);

	//Blocks
	public static final DeferredBlock<GrowableSaplingBlock> APPLE_SAPLING = BLOCKS.register("apple_sapling", () -> new GrowableSaplingBlock(new AppleTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final DeferredBlock<GrowableSaplingBlock> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new GrowableSaplingBlock(new LemonTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final DeferredBlock<GrowableSaplingBlock> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new GrowableSaplingBlock(new OrangeTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final DeferredBlock<GrowableSaplingBlock> CHERRY_SAPLING = BLOCKS.register("cherry_sapling", () -> new GrowableSaplingBlock(new CherryTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final DeferredBlock<GrowableSaplingBlock> PEAR_SAPLING = BLOCKS.register("pear_sapling", () -> new GrowableSaplingBlock(new PearTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final DeferredBlock<GrowableSaplingBlock> BANANA_SAPLING = BLOCKS.register("banana_sapling", () -> new GrowableSaplingBlock(new BananaTree(), BlockBehaviour.Properties.copy(Blocks.JUNGLE_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final DeferredBlock<GrowableSaplingBlock> AVOCADO_SAPLING = BLOCKS.register("avocado_sapling", () -> new GrowableSaplingBlock(new AvocadoTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final DeferredBlock<GrowableSaplingBlock> MANGO_SAPLING = BLOCKS.register("mango_sapling", () -> new GrowableSaplingBlock(new MangoTree(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final DeferredBlock<GrowableSaplingBlock> OLIVE_SAPLING = BLOCKS.register("olive_sapling", () -> new GrowableSaplingBlock(new OliveTree(), BlockBehaviour.Properties.copy(Blocks.ACACIA_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

	public static final DeferredBlock<FruitLeavesBlock> APPLE_LEAVES = BLOCKS.register("apple_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), () -> Items.APPLE));
	public static final DeferredBlock<FruitLeavesBlock> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), FarmingRegistry.LEMON));
	public static final DeferredBlock<FruitLeavesBlock> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), FarmingRegistry.ORANGE));
	public static final DeferredBlock<FruitLeavesBlock> CHERRY_LEAVES = BLOCKS.register("cherry_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), FarmingRegistry.CHERRY));
	public static final DeferredBlock<FruitLeavesBlock> PEAR_LEAVES = BLOCKS.register("pear_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), FarmingRegistry.PEAR));
	public static final DeferredBlock<FruitLeavesBlock> BANANA_LEAVES = BLOCKS.register("banana_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LEAVES), FarmingRegistry.BANANA));
	public static final DeferredBlock<FruitLeavesBlock> AVOCADO_LEAVES = BLOCKS.register("avocado_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), FarmingRegistry.AVOCADO));
	public static final DeferredBlock<FruitLeavesBlock> MANGO_LEAVES = BLOCKS.register("mango_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES), FarmingRegistry.MANGO));
	public static final DeferredBlock<FruitLeavesBlock> OLIVE_LEAVES = BLOCKS.register("olive_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_LEAVES), FarmingRegistry.OLIVE));

	public static final DeferredBlock<FiveAgeCropBlock> MINT_CROP = BLOCKS.register("mint_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.MINT));
	public static final DeferredBlock<NetherFlowerBlock> NETHER_FLOWER_CROP = BLOCKS.register("nether_flower_crop", () -> new NetherFlowerBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
	public static final DeferredBlock<SixAgeCropBlock> TOMATO_CROP = BLOCKS.register("tomato_crop", () -> new SixAgeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.TOMATO));
	public static final DeferredBlock<FiveAgeCropBlock> CUCUMBER_CROP = BLOCKS.register("cucumber_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.CUCUMBER));
	public static final DeferredBlock<FiveAgeCropBlock> AUBERGINE_CROP = BLOCKS.register("aubergine_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.AUBERGINE));
	public static final DeferredBlock<CropstickCropBlock> GRAPE_CROP = BLOCKS.register("grape_crop", () -> new CropstickCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.GRAPES));
	public static final DeferredBlock<FiveAgeCropBlock> PINEAPPLE_CROP = BLOCKS.register("pineapple_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.PINEAPPLE));
	public static final DeferredBlock<SevenAgeCropBlock> CORN_CROP = BLOCKS.register("corn_crop", () -> new SevenAgeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.CORN));
	public static final DeferredBlock<FiveAgeCropBlock> ONION_CROP = BLOCKS.register("onion_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.ONION));
	public static final DeferredBlock<FiveAgeCropBlock> GARLIC_CROP = BLOCKS.register("garlic_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.GARLIC));
	public static final DeferredBlock<FiveAgeCropBlock> LETTUCE_CROP = BLOCKS.register("lettuce_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.LETTUCE));

	public static final DeferredBlock<CropStickBlock> CROP_STICK = BLOCKS.register("crop_stick", () -> new CropStickBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
	public static final DeferredBlock<ScarecrowBlock> SCARECROW = BLOCKS.register("scarecrow", () -> new ScarecrowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL)));

	//Items
	public static final DeferredItem<CustomUtensilItem> POT = ITEMS.register("pot", () -> new CustomUtensilItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CustomUtensilItem> CUTTING_BOARD = ITEMS.register("cutting_board", () -> new CustomUtensilItem(new Item.Properties().stacksTo(1)));
	public static final DeferredItem<CustomUtensilItem> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle", () -> new CustomUtensilItem(new Item.Properties().stacksTo(1)));

	public static final DeferredItem<CustomFoodItem> AUBERGINE = ITEMS.register("aubergine", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.AUBERGINE), 32));
	public static final DeferredItem<CustomFoodItem> AVOCADO = ITEMS.register("avocado", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.AVOCADO), 32));
	public static final DeferredItem<CustomFoodItem> BANANA = ITEMS.register("banana", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BANANA), 32));
	public static final DeferredItem<CustomFoodItem> CHERRY = ITEMS.register("cherry", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHERRY), 32));
	public static final DeferredItem<CustomFoodItem> CUCUMBER = ITEMS.register("cucumber", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CUCUMBER), 32));
	public static final DeferredItem<CustomFoodItem> GRAPES = ITEMS.register("grapes", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GRAPES), 32));
	public static final DeferredItem<CustomFoodItem> LEMON = ITEMS.register("lemon", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.LEMON), 32));
	public static final DeferredItem<CustomFoodItem> MANGO = ITEMS.register("mango", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.MANGO), 32));
	public static final DeferredItem<Item> MINT = ITEMS.registerSimpleItem("mint");
	public static final DeferredItem<CustomFoodItem> OLIVE = ITEMS.register("olive", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.OLIVE), 32));
	public static final DeferredItem<CustomFoodItem> ORANGE = ITEMS.register("orange", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.ORANGE), 32));
	public static final DeferredItem<CustomFoodItem> PEAR = ITEMS.register("pear", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.PEAR), 32));
	public static final DeferredItem<CustomFoodItem> PINEAPPLE = ITEMS.register("pineapple", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.PINEAPPLE), 32));
	public static final DeferredItem<CustomFoodItem> TOMATO = ITEMS.register("tomato", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.TOMATO), 32));

	public static final DeferredItem<CustomFoodItem> CORN = ITEMS.register("corn", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CORN), 32));
	public static final DeferredItem<CustomFoodItem> GARLIC = ITEMS.register("garlic", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GARLIC), 32));
	public static final DeferredItem<CustomFoodItem> LETTUCE = ITEMS.register("lettuce", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.LETTUCE), 32));
	public static final DeferredItem<CustomFoodItem> ONION = ITEMS.register("onion", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.ONION), 32));

	public static final DeferredItem<SpecialCustomFoodItem> GOLDEN_LEMON = ITEMS.register("golden_lemon", () -> new SpecialCustomFoodItem(new Item.Properties().food(FarmingFoods.GOLD_LEMON), 32, true));
	public static final DeferredItem<SpecialCustomFoodItem> GOLDEN_ORANGE = ITEMS.register("golden_orange", () -> new SpecialCustomFoodItem(new Item.Properties().food(FarmingFoods.GOLD_ORANGE), 32, true));

	public static final DeferredItem<CustomFoodItem> CHOCOLATE_BAR = ITEMS.register("chocolate_bar", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_BAR), 32));
	public static final DeferredItem<CustomFoodItem> CHOCOLATE_BANANA = ITEMS.register("chocolate_banana", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_BANANA), 32));
	public static final DeferredItem<CustomFoodItem> CHOCOLATE_CANDY = ITEMS.register("chocolate_candy", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_CANDY), 2));
	public static final DeferredItem<CustomFoodItem> CHOCOLATE_CHERRY = ITEMS.register("chocolate_cherry", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_CHERRY), 32));

	public static final DeferredItem<SpecialCustomFoodItem> MINT_CHOCOLATE_BAR = ITEMS.register("mint_chocolate_bar", () -> new SpecialCustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_BAR_MINT).stacksTo(16), 32, false, true, false));
	public static final DeferredItem<ContainerFoodItem> MINT_TEA = ITEMS.register("mint_tea", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.MINT_TEA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, false, true, false, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> MILK_BOTTLE = ITEMS.register("milk_bottle", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.MILK_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, false, false, true, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> COLD_CHOCOLATE_BOTTLE = ITEMS.register("cold_chocolate_bottle", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.COLD_CHOCOLATE_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> HOT_CHOCOLATE_BOTTLE = ITEMS.register("hot_chocolate_bottle", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.HOT_CHOCOLATE_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<Item> HOT_WATER = ITEMS.registerSimpleItem("hot_water");

	//Juices
	public static final DeferredItem<ContainerFoodItem> APPLE_JUICE = ITEMS.register("apple_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.APPLE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> LEMONADE = ITEMS.register("lemonade", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.LEMONADE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> ORANGE_JUICE = ITEMS.register("orange_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.ORANGE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> CHERRY_JUICE = ITEMS.register("cherry_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CHERRY_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> PEAR_JUICE = ITEMS.register("pear_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.PEAR_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> BANANA_JUICE = ITEMS.register("banana_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.BANANA_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> GRAPE_JUICE = ITEMS.register("grape_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.GRAPE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> MANGO_JUICE = ITEMS.register("mango_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.MANGO_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> PINEAPPLE_JUICE = ITEMS.register("pineapple_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.PINEAPPLE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));

	//Smoothies
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_APPLE = ITEMS.register("smoothie_apple", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.APPLE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_BANANA = ITEMS.register("smoothie_banana", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.BANANA_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_CHERRY = ITEMS.register("smoothie_cherry", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CHERRY_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_CUCUMBER = ITEMS.register("smoothie_cucumber", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CUCUMBER_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_GRAPE = ITEMS.register("smoothie_grape", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.GRAPE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_LEMON = ITEMS.register("smoothie_lemon", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.LEMON_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_MANGO = ITEMS.register("smoothie_mango", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.MANGO_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_ORANGE = ITEMS.register("smoothie_orange", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.ORANGE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_PEAR = ITEMS.register("smoothie_pear", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.PEAR_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_PINEAPPLE = ITEMS.register("smoothie_pineapple", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.PINEAPPLE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));

	//Actual food
	public static final DeferredItem<Item> DOUGH = ITEMS.registerSimpleItem("dough");
	public static final DeferredItem<Item> FLOUR = ITEMS.registerSimpleItem("flour");
	public static final DeferredItem<Item> OLIVE_OIL = ITEMS.registerSimpleItem("olive_oil", new Item.Properties().craftRemainder(Items.GLASS_BOTTLE));
	public static final DeferredItem<Item> PASTA = ITEMS.registerSimpleItem("pasta");
	public static final DeferredItem<Item> RAW_FRIES = ITEMS.registerSimpleItem("raw_fries");
	public static final DeferredItem<Item> SALT = ITEMS.registerSimpleItem("salt");
	public static final DeferredItem<Item> STOCK = ITEMS.registerSimpleItem("stock");

	public static final DeferredItem<ContainerFoodItem> FRUIT_SALAD = ITEMS.register("fruit_salad", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.FRUIT_SALAD).stacksTo(16).craftRemainder(Items.BOWL), 24, UseAnim.EAT));
	public static final DeferredItem<ContainerFoodItem> SALAD = ITEMS.register("salad", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.SALAD).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 24, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> CARROT_SOUP = ITEMS.register("carrot_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CARROT_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> CHICKEN_NOODLE_SOUP = ITEMS.register("chicken_noodle_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CHICKEN_NOODLE_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> CORN_SOUP = ITEMS.register("corn_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CORN_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> CUCUMBER_SOUP = ITEMS.register("cucumber_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CUCUMBER_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> ONION_SOUP = ITEMS.register("onion_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.ONION_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> POTATO_SOUP = ITEMS.register("potato_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.POTATO_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final DeferredItem<ContainerFoodItem> TOMATO_SOUP = ITEMS.register("tomato_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.TOMATO_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));

	public static final DeferredItem<CustomFoodItem> BAKED_EGG = ITEMS.register("baked_egg", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.OMELET), 32));
	public static final DeferredItem<CustomFoodItem> BOILED_EGG = ITEMS.register("boiled_egg", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BOILED_EGG), 32));
	public static final DeferredItem<CustomFoodItem> CHEESE = ITEMS.register("cheese", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHEESE), 32));
	public static final DeferredItem<CustomFoodItem> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHEESE_BURGER), 32));
	public static final DeferredItem<CustomFoodItem> CHICKENBURGER = ITEMS.register("chickenburger", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHICKEN_BURGER), 32));
	public static final DeferredItem<CustomFoodItem> FISH_AND_CHIPS = ITEMS.register("fish_and_chips", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.FISH_AND_CHIPS), 32));
	public static final DeferredItem<CustomFoodItem> FRIES = ITEMS.register("fries", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.FRIES), 32));
	public static final DeferredItem<CustomFoodItem> GUACAMOLE = ITEMS.register("guacamole", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GUACAMOLE), 32));
	public static final DeferredItem<CustomFoodItem> GUAC_AND_CHIPS = ITEMS.register("guac_and_chips", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GUAC_AND_CHIPS), 28));
	public static final DeferredItem<CustomFoodItem> HAMBURGER = ITEMS.register("hamburger", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.HAMBURGER), 32));
	public static final DeferredItem<CustomFoodItem> JAM = ITEMS.register("jam", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.JAM).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32));
	public static final DeferredItem<CustomFoodItem> POTATO_CHIPS = ITEMS.register("potato_chips", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.POTATO_CHIPS), 24));
	public static final DeferredItem<CustomFoodItem> SLICED_BREAD = ITEMS.register("sliced_bread", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.SLICED_BREAD), 32));
	public static final DeferredItem<CustomFoodItem> SPAGHETTI = ITEMS.register("spaghetti", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.SPAGHETTI).stacksTo(16).craftRemainder(Items.BOWL), 40));

	//Sandwiches
	public static final DeferredItem<CustomFoodItem> BACON_SANDWICH = ITEMS.register("bacon_sandwich", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BACON_SANDWICH), 32));
	public static final DeferredItem<CustomFoodItem> CHICKEN_SANDWICH = ITEMS.register("chicken_sandwich", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHICKEN_SANDWICH), 32));
	public static final DeferredItem<CustomFoodItem> EGG_SANDWICH = ITEMS.register("egg_sandwich", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.EGG_SANDWICH), 32));
	public static final DeferredItem<CustomFoodItem> JC_SANDWICH = ITEMS.register("jc_sandwich", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.JC_SANDWICH), 32));

	//Pizza
	public static final DeferredItem<CustomFoodItem> BACON_PIZZA = ITEMS.register("bacon_pizza", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BACON_PIZZA), 40));
	public static final DeferredItem<CustomFoodItem> CHEESE_PIZZA = ITEMS.register("cheese_pizza", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHEESE_PIZZA), 40));
	public static final DeferredItem<CustomFoodItem> PINEAPPLE_PIZZA = ITEMS.register("pineapple_pizza", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.PINEAPPLE_PIZZA), 40));

	//Pies
	public static final DeferredItem<CustomFoodItem> APPLE_PIE = ITEMS.register("apple_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.APPLE_PIE), 32));
	public static final DeferredItem<CustomFoodItem> BACON_AND_EGG_PIE = ITEMS.register("bacon_and_egg_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BACON_AND_EGG_PIE), 32));
	public static final DeferredItem<CustomFoodItem> BANANA_PIE = ITEMS.register("banana_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BANANA_PIE), 32));
	public static final DeferredItem<CustomFoodItem> CHERRY_PIE = ITEMS.register("cherry_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHERRY_PIE), 32));
	public static final DeferredItem<CustomFoodItem> GRAPE_PIE = ITEMS.register("grape_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GRAPE_PIE), 32));
	public static final DeferredItem<CustomFoodItem> LEMON_PIE = ITEMS.register("lemon_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.LEMON_PIE), 32));
	public static final DeferredItem<CustomFoodItem> PEAR_PIE = ITEMS.register("pear_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.PEAR_PIE), 32));

	//Rakes
	public static final DeferredItem<RakeToolItem> WOODEN_RAKE = ITEMS.register("wooden_rake", () -> new RakeToolItem(Tiers.WOOD, 0, -3.0F, 1, new Item.Properties()));
	public static final DeferredItem<RakeToolItem> STONE_RAKE = ITEMS.register("stone_rake", () -> new RakeToolItem(Tiers.STONE, -1, -2.0F, 2, new Item.Properties()));
	public static final DeferredItem<RakeToolItem> IRON_RAKE = ITEMS.register("iron_rake", () -> new RakeToolItem(Tiers.IRON, -2, -1.0F, 3, new Item.Properties()));
	public static final DeferredItem<RakeToolItem> GOLD_RAKE = ITEMS.register("gold_rake", () -> new RakeToolItem(Tiers.GOLD, 0, -3.0F, 6, new Item.Properties()));
	public static final DeferredItem<RakeToolItem> DIAMOND_RAKE = ITEMS.register("diamond_rake", () -> new RakeToolItem(Tiers.DIAMOND, -3, 0.0F, 5, new Item.Properties()));

	//Seeds
	public static final DeferredItem<ItemNameBlockItem> MINT_SEEDS = ITEMS.register("mint_seeds", () -> new ItemNameBlockItem(FarmingRegistry.MINT_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> NETHER_FLOWER_SEEDS = ITEMS.register("nether_flower_seeds", () -> new ItemNameBlockItem(FarmingRegistry.NETHER_FLOWER_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new ItemNameBlockItem(FarmingRegistry.TOMATO_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds", () -> new ItemNameBlockItem(FarmingRegistry.CUCUMBER_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> AUBERGINE_SEEDS = ITEMS.register("aubergine_seeds", () -> new ItemNameBlockItem(FarmingRegistry.AUBERGINE_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> GRAPE_SEEDS = ITEMS.register("grape_seeds", () -> new CropsticksSeedsBlock(FarmingRegistry.GRAPE_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> PINEAPPLE_SEEDS = ITEMS.register("pineapple_seeds", () -> new ItemNameBlockItem(FarmingRegistry.PINEAPPLE_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> CORN_SEEDS = ITEMS.register("corn_seeds", () -> new ItemNameBlockItem(FarmingRegistry.CORN_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> ONION_SEEDS = ITEMS.register("onion_seeds", () -> new ItemNameBlockItem(FarmingRegistry.ONION_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> GARLIC_SEEDS = ITEMS.register("garlic_seeds", () -> new ItemNameBlockItem(FarmingRegistry.GARLIC_CROP.get(), new Item.Properties()));
	public static final DeferredItem<ItemNameBlockItem> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds", () -> new ItemNameBlockItem(FarmingRegistry.LETTUCE_CROP.get(), new Item.Properties()));

	public static final DeferredItem<BlockItem> APPLE_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("apple_sapling", FarmingRegistry.APPLE_SAPLING);
	public static final DeferredItem<BlockItem> LEMON_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("lemon_sapling", FarmingRegistry.LEMON_SAPLING);
	public static final DeferredItem<BlockItem> ORANGE_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("orange_sapling", FarmingRegistry.ORANGE_SAPLING);
	public static final DeferredItem<BlockItem> CHERRY_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("cherry_sapling", FarmingRegistry.CHERRY_SAPLING);
	public static final DeferredItem<BlockItem> PEAR_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("pear_sapling", FarmingRegistry.PEAR_SAPLING);
	public static final DeferredItem<BlockItem> BANANA_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("banana_sapling", FarmingRegistry.BANANA_SAPLING);
	public static final DeferredItem<BlockItem> AVOCADO_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("avocado_sapling", FarmingRegistry.AVOCADO_SAPLING);
	public static final DeferredItem<BlockItem> MANGO_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("mango_sapling", FarmingRegistry.MANGO_SAPLING);
	public static final DeferredItem<BlockItem> OLIVE_SAPLING_ITEM = ITEMS.registerSimpleBlockItem("olive_sapling", FarmingRegistry.OLIVE_SAPLING);

	public static final DeferredItem<BlockItem> APPLE_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("apple_leaves", FarmingRegistry.APPLE_LEAVES);
	public static final DeferredItem<BlockItem> LEMON_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("lemon_leaves", FarmingRegistry.LEMON_LEAVES);
	public static final DeferredItem<BlockItem> ORANGE_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("orange_leaves", FarmingRegistry.ORANGE_LEAVES);
	public static final DeferredItem<BlockItem> CHERRY_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("cherry_leaves", FarmingRegistry.CHERRY_LEAVES);
	public static final DeferredItem<BlockItem> PEAR_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("pear_leaves", FarmingRegistry.PEAR_LEAVES);
	public static final DeferredItem<BlockItem> BANANA_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("banana_leaves", FarmingRegistry.BANANA_LEAVES);
	public static final DeferredItem<BlockItem> AVOCADO_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("avocado_leaves", FarmingRegistry.AVOCADO_LEAVES);
	public static final DeferredItem<BlockItem> MANGO_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("mango_leaves", FarmingRegistry.MANGO_LEAVES);
	public static final DeferredItem<BlockItem> OLIVE_LEAVES_ITEM = ITEMS.registerSimpleBlockItem("olive_leaves", FarmingRegistry.OLIVE_LEAVES);

	public static final DeferredItem<BlockItem> CROP_STICK_ITEM = ITEMS.registerSimpleBlockItem("crop_stick", FarmingRegistry.CROP_STICK);
	public static final DeferredItem<BlockItem> SCARECROW_ITEM = ITEMS.registerSimpleBlockItem("scarecrow", FarmingRegistry.SCARECROW);

	public static final Supplier<CreativeModeTab> TAB_MAIN = CREATIVE_MODE_TABS.register("tab", () -> CreativeModeTab.builder()
			.icon(() -> new ItemStack(FarmingRegistry.SCARECROW_ITEM.get()))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
			.title(Component.translatable("itemGroup.enhancedfarming.tab"))
			.displayItems((displayParameters, output) -> {
				List<ItemStack> stacks = FarmingRegistry.ITEMS.getEntries().stream().map(reg -> new ItemStack(reg.get())).toList();
				output.acceptAll(stacks);
			}).build());

	public static final Supplier<BlockEntityType<ScarecrowBlockEntity>> SCARECROW_TILE = BLOCK_ENTITY_TYPES.register("scarecrow", () ->
			BlockEntityType.Builder.of(ScarecrowBlockEntity::new, FarmingRegistry.SCARECROW.get()).build(null));

	public static void registerCompostable() {
		for (DeferredHolder<Item, ? extends Item> item : FarmingRegistry.ITEMS.getEntries()) {
			if (item.get() instanceof BlockItem blockItem) {
				Block block = blockItem.getBlock();
				if (block instanceof FruitLeavesBlock || block instanceof BushBlock)
					ComposterBlock.COMPOSTABLES.put(item.get(), 0.3F);
			}
		}
		ComposterBlock.COMPOSTABLES.put(AUBERGINE.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(AVOCADO.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(BANANA.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CHERRY.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CUCUMBER.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(GRAPES.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(LEMON.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(MANGO.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(MINT.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(OLIVE.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(ORANGE.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(PEAR.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(PINEAPPLE.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(TOMATO.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(CORN.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(GARLIC.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(LETTUCE.get(), 0.65F);
		ComposterBlock.COMPOSTABLES.put(ONION.get(), 0.65F);
	}
}
