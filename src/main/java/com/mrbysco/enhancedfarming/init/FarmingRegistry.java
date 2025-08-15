package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.EnhancedFarming;
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
import com.mrbysco.enhancedfarming.world.tree.FarmingTrees;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
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
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EnhancedFarming.MOD_ID);
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EnhancedFarming.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnhancedFarming.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, EnhancedFarming.MOD_ID);

	//Blocks
	public static final DeferredBlock<GrowableSaplingBlock> APPLE_SAPLING = BLOCKS.registerBlock("apple_sapling", (properties) -> new GrowableSaplingBlock(FarmingTrees.APPLE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	public static final DeferredBlock<GrowableSaplingBlock> LEMON_SAPLING = BLOCKS.registerBlock("lemon_sapling", (properties) -> new GrowableSaplingBlock(FarmingTrees.LEMON, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	public static final DeferredBlock<GrowableSaplingBlock> ORANGE_SAPLING = BLOCKS.registerBlock("orange_sapling", (properties) -> new GrowableSaplingBlock(FarmingTrees.ORANGE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	public static final DeferredBlock<GrowableSaplingBlock> CHERRY_SAPLING = BLOCKS.registerBlock("cherry_sapling", (properties) -> new GrowableSaplingBlock(FarmingTrees.CHERRY, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	public static final DeferredBlock<GrowableSaplingBlock> PEAR_SAPLING = BLOCKS.registerBlock("pear_sapling", (properties) -> new GrowableSaplingBlock(FarmingTrees.PEAR, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	public static final DeferredBlock<GrowableSaplingBlock> BANANA_SAPLING = BLOCKS.registerBlock("banana_sapling", (properties) -> new GrowableSaplingBlock(FarmingTrees.BANANA, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	public static final DeferredBlock<GrowableSaplingBlock> AVOCADO_SAPLING = BLOCKS.registerBlock("avocado_sapling", (properties) -> new GrowableSaplingBlock(FarmingTrees.AVOCADO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	public static final DeferredBlock<GrowableSaplingBlock> MANGO_SAPLING = BLOCKS.registerBlock("mango_sapling", (properties) -> new GrowableSaplingBlock(FarmingTrees.MANGO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
	public static final DeferredBlock<GrowableSaplingBlock> OLIVE_SAPLING = BLOCKS.registerBlock("olive_sapling", (properties) -> new GrowableSaplingBlock(FarmingTrees.OLIVE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));

	public static final DeferredBlock<FruitLeavesBlock> APPLE_LEAVES = BLOCKS.registerBlock("apple_leaves", (properties) -> new FruitLeavesBlock(properties, () -> Items.APPLE), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
	public static final DeferredBlock<FruitLeavesBlock> LEMON_LEAVES = BLOCKS.registerBlock("lemon_leaves", (properties) -> new FruitLeavesBlock(properties, FarmingRegistry.LEMON), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
	public static final DeferredBlock<FruitLeavesBlock> ORANGE_LEAVES = BLOCKS.registerBlock("orange_leaves", (properties) -> new FruitLeavesBlock(properties, FarmingRegistry.ORANGE), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
	public static final DeferredBlock<FruitLeavesBlock> CHERRY_LEAVES = BLOCKS.registerBlock("cherry_leaves", (properties) -> new FruitLeavesBlock(properties, FarmingRegistry.CHERRY), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
	public static final DeferredBlock<FruitLeavesBlock> PEAR_LEAVES = BLOCKS.registerBlock("pear_leaves", (properties) -> new FruitLeavesBlock(properties, FarmingRegistry.PEAR), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
	public static final DeferredBlock<FruitLeavesBlock> BANANA_LEAVES = BLOCKS.registerBlock("banana_leaves", (properties) -> new FruitLeavesBlock(properties, FarmingRegistry.BANANA), BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_LEAVES));
	public static final DeferredBlock<FruitLeavesBlock> AVOCADO_LEAVES = BLOCKS.registerBlock("avocado_leaves", (properties) -> new FruitLeavesBlock(properties, FarmingRegistry.AVOCADO), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
	public static final DeferredBlock<FruitLeavesBlock> MANGO_LEAVES = BLOCKS.registerBlock("mango_leaves", (properties) -> new FruitLeavesBlock(properties, FarmingRegistry.MANGO), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));
	public static final DeferredBlock<FruitLeavesBlock> OLIVE_LEAVES = BLOCKS.registerBlock("olive_leaves", (properties) -> new FruitLeavesBlock(properties, FarmingRegistry.OLIVE), BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES));

	public static final DeferredBlock<FiveAgeCropBlock> MINT_CROP = BLOCKS.registerBlock("mint_crop", (properties) -> new FiveAgeCropBlock(properties, FarmingRegistry.MINT), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<NetherFlowerBlock> NETHER_FLOWER_CROP = BLOCKS.registerBlock("nether_flower_crop", NetherFlowerBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<SixAgeCropBlock> TOMATO_CROP = BLOCKS.registerBlock("tomato_crop", (properties) -> new SixAgeCropBlock(properties, FarmingRegistry.TOMATO), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<FiveAgeCropBlock> CUCUMBER_CROP = BLOCKS.registerBlock("cucumber_crop", (properties) -> new FiveAgeCropBlock(properties, FarmingRegistry.CUCUMBER), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<FiveAgeCropBlock> AUBERGINE_CROP = BLOCKS.registerBlock("aubergine_crop", (properties) -> new FiveAgeCropBlock(properties, FarmingRegistry.AUBERGINE), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<CropstickCropBlock> GRAPE_CROP = BLOCKS.registerBlock("grape_crop", (properties) -> new CropstickCropBlock(properties, FarmingRegistry.GRAPES), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<FiveAgeCropBlock> PINEAPPLE_CROP = BLOCKS.registerBlock("pineapple_crop", (properties) -> new FiveAgeCropBlock(properties, FarmingRegistry.PINEAPPLE), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<SevenAgeCropBlock> CORN_CROP = BLOCKS.registerBlock("corn_crop", (properties) -> new SevenAgeCropBlock(properties, FarmingRegistry.CORN), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<FiveAgeCropBlock> ONION_CROP = BLOCKS.registerBlock("onion_crop", (properties) -> new FiveAgeCropBlock(properties, FarmingRegistry.ONION), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<FiveAgeCropBlock> GARLIC_CROP = BLOCKS.registerBlock("garlic_crop", (properties) -> new FiveAgeCropBlock(properties, FarmingRegistry.GARLIC), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));
	public static final DeferredBlock<FiveAgeCropBlock> LETTUCE_CROP = BLOCKS.registerBlock("lettuce_crop", (properties) -> new FiveAgeCropBlock(properties, FarmingRegistry.LETTUCE), BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP));

	public static final DeferredBlock<CropStickBlock> CROP_STICK = BLOCKS.registerBlock("crop_stick", CropStickBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
	public static final DeferredBlock<ScarecrowBlock> SCARECROW = BLOCKS.registerBlock("scarecrow", ScarecrowBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL));

	//Items
	public static final DeferredItem<CustomUtensilItem> POT = ITEMS.registerItem("pot", (properties) -> new CustomUtensilItem(properties.stacksTo(1)));
	public static final DeferredItem<CustomUtensilItem> CUTTING_BOARD = ITEMS.registerItem("cutting_board", (properties) -> new CustomUtensilItem(properties.stacksTo(1)));
	public static final DeferredItem<CustomUtensilItem> MORTAR_AND_PESTLE = ITEMS.registerItem("mortar_and_pestle", (properties) -> new CustomUtensilItem(properties.stacksTo(1)));

	public static final DeferredItem<CustomFoodItem> AUBERGINE = ITEMS.registerItem("aubergine", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.AUBERGINE), 32));
	public static final DeferredItem<CustomFoodItem> AVOCADO = ITEMS.registerItem("avocado", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.AVOCADO), 32));
	public static final DeferredItem<CustomFoodItem> BANANA = ITEMS.registerItem("banana", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.BANANA), 32));
	public static final DeferredItem<CustomFoodItem> CHERRY = ITEMS.registerItem("cherry", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHERRY), 32));
	public static final DeferredItem<CustomFoodItem> CUCUMBER = ITEMS.registerItem("cucumber", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CUCUMBER), 32));
	public static final DeferredItem<CustomFoodItem> GRAPES = ITEMS.registerItem("grapes", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.GRAPES), 32));
	public static final DeferredItem<CustomFoodItem> LEMON = ITEMS.registerItem("lemon", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.LEMON), 32));
	public static final DeferredItem<CustomFoodItem> MANGO = ITEMS.registerItem("mango", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.MANGO), 32));
	public static final DeferredItem<Item> MINT = ITEMS.registerSimpleItem("mint");
	public static final DeferredItem<CustomFoodItem> OLIVE = ITEMS.registerItem("olive", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.OLIVE), 32));
	public static final DeferredItem<CustomFoodItem> ORANGE = ITEMS.registerItem("orange", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.ORANGE), 32));
	public static final DeferredItem<CustomFoodItem> PEAR = ITEMS.registerItem("pear", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.PEAR), 32));
	public static final DeferredItem<CustomFoodItem> PINEAPPLE = ITEMS.registerItem("pineapple", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.PINEAPPLE), 32));
	public static final DeferredItem<CustomFoodItem> TOMATO = ITEMS.registerItem("tomato", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.TOMATO), 32));

	public static final DeferredItem<CustomFoodItem> CORN = ITEMS.registerItem("corn", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CORN), 32));
	public static final DeferredItem<CustomFoodItem> GARLIC = ITEMS.registerItem("garlic", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.GARLIC), 32));
	public static final DeferredItem<CustomFoodItem> LETTUCE = ITEMS.registerItem("lettuce", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.LETTUCE), 32));
	public static final DeferredItem<CustomFoodItem> ONION = ITEMS.registerItem("onion", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.ONION), 32));

	public static final DeferredItem<SpecialCustomFoodItem> GOLDEN_LEMON = ITEMS.registerItem("golden_lemon", (properties) -> new SpecialCustomFoodItem(properties
			.food(FarmingFoods.GOLD_LEMON, FarmingConsumables.GOLD_LEMON), 32, true));
	public static final DeferredItem<SpecialCustomFoodItem> GOLDEN_ORANGE = ITEMS.registerItem("golden_orange", (properties) -> new SpecialCustomFoodItem(properties
			.food(FarmingFoods.GOLD_ORANGE, FarmingConsumables.GOLD_ORANGE), 32, true));

	public static final DeferredItem<CustomFoodItem> CHOCOLATE_BAR = ITEMS.registerItem("chocolate_bar", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHOCOLATE_BAR), 32));
	public static final DeferredItem<CustomFoodItem> CHOCOLATE_BANANA = ITEMS.registerItem("chocolate_banana", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHOCOLATE_BANANA), 32));
	public static final DeferredItem<CustomFoodItem> CHOCOLATE_CANDY = ITEMS.registerItem("chocolate_candy", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHOCOLATE_CANDY), 2));
	public static final DeferredItem<CustomFoodItem> CHOCOLATE_CHERRY = ITEMS.registerItem("chocolate_cherry", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHOCOLATE_CHERRY), 32));

	public static final DeferredItem<SpecialCustomFoodItem> MINT_CHOCOLATE_BAR = ITEMS.registerItem("mint_chocolate_bar", (properties) -> new SpecialCustomFoodItem(properties.food(FarmingFoods.CHOCOLATE_BAR_MINT).stacksTo(16), 32, false, true, false));
	public static final DeferredItem<ContainerFoodItem> MINT_TEA = ITEMS.registerItem("mint_tea", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.MINT_TEA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, false, true, false, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> MILK_BOTTLE = ITEMS.registerItem("milk_bottle", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.MILK_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, false, false, true, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> COLD_CHOCOLATE_BOTTLE = ITEMS.registerItem("cold_chocolate_bottle", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.COLD_CHOCOLATE_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> HOT_CHOCOLATE_BOTTLE = ITEMS.registerItem("hot_chocolate_bottle", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.HOT_CHOCOLATE_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<Item> HOT_WATER = ITEMS.registerSimpleItem("hot_water");

	//Juices
	public static final DeferredItem<ContainerFoodItem> APPLE_JUICE = ITEMS.registerItem("apple_juice", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.APPLE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> LEMONADE = ITEMS.registerItem("lemonade", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.LEMONADE).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> ORANGE_JUICE = ITEMS.registerItem("orange_juice", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.ORANGE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> CHERRY_JUICE = ITEMS.registerItem("cherry_juice", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.CHERRY_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> PEAR_JUICE = ITEMS.registerItem("pear_juice", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.PEAR_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> BANANA_JUICE = ITEMS.registerItem("banana_juice", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.BANANA_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> GRAPE_JUICE = ITEMS.registerItem("grape_juice", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.GRAPE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> MANGO_JUICE = ITEMS.registerItem("mango_juice", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.MANGO_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> PINEAPPLE_JUICE = ITEMS.registerItem("pineapple_juice", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.PINEAPPLE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));

	//Smoothies
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_APPLE = ITEMS.registerItem("smoothie_apple", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.APPLE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_BANANA = ITEMS.registerItem("smoothie_banana", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.BANANA_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_CHERRY = ITEMS.registerItem("smoothie_cherry", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.CHERRY_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_CUCUMBER = ITEMS.registerItem("smoothie_cucumber", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.CUCUMBER_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_GRAPE = ITEMS.registerItem("smoothie_grape", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.GRAPE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_LEMON = ITEMS.registerItem("smoothie_lemon", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.LEMON_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_MANGO = ITEMS.registerItem("smoothie_mango", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.MANGO_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_ORANGE = ITEMS.registerItem("smoothie_orange", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.ORANGE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_PEAR = ITEMS.registerItem("smoothie_pear", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.PEAR_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> SMOOTHIE_PINEAPPLE = ITEMS.registerItem("smoothie_pineapple", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.PINEAPPLE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, ItemUseAnimation.DRINK));

	//Actual food
	public static final DeferredItem<Item> DOUGH = ITEMS.registerSimpleItem("dough");
	public static final DeferredItem<Item> FLOUR = ITEMS.registerSimpleItem("flour");
	public static final DeferredItem<Item> OLIVE_OIL = ITEMS.registerSimpleItem("olive_oil", new Properties().craftRemainder(Items.GLASS_BOTTLE));
	public static final DeferredItem<Item> PASTA = ITEMS.registerSimpleItem("pasta");
	public static final DeferredItem<Item> RAW_FRIES = ITEMS.registerSimpleItem("raw_fries");
	public static final DeferredItem<Item> SALT = ITEMS.registerSimpleItem("salt");
	public static final DeferredItem<Item> STOCK = ITEMS.registerSimpleItem("stock");

	public static final DeferredItem<ContainerFoodItem> FRUIT_SALAD = ITEMS.registerItem("fruit_salad", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.FRUIT_SALAD).stacksTo(16).craftRemainder(Items.BOWL), 24, ItemUseAnimation.EAT));
	public static final DeferredItem<ContainerFoodItem> SALAD = ITEMS.registerItem("salad", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.SALAD).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 24, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> CARROT_SOUP = ITEMS.registerItem("carrot_soup", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.CARROT_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> CHICKEN_NOODLE_SOUP = ITEMS.registerItem("chicken_noodle_soup", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.CHICKEN_NOODLE_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> CORN_SOUP = ITEMS.registerItem("corn_soup", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.CORN_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> CUCUMBER_SOUP = ITEMS.registerItem("cucumber_soup", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.CUCUMBER_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> ONION_SOUP = ITEMS.registerItem("onion_soup", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.ONION_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> POTATO_SOUP = ITEMS.registerItem("potato_soup", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.POTATO_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, ItemUseAnimation.DRINK));
	public static final DeferredItem<ContainerFoodItem> TOMATO_SOUP = ITEMS.registerItem("tomato_soup", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.TOMATO_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, ItemUseAnimation.DRINK));

	public static final DeferredItem<CustomFoodItem> BAKED_EGG = ITEMS.registerItem("baked_egg", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.OMELET), 32));
	public static final DeferredItem<CustomFoodItem> BOILED_EGG = ITEMS.registerItem("boiled_egg", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.BOILED_EGG), 32));
	public static final DeferredItem<CustomFoodItem> CHEESE = ITEMS.registerItem("cheese", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHEESE), 32));
	public static final DeferredItem<CustomFoodItem> CHEESEBURGER = ITEMS.registerItem("cheeseburger", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHEESE_BURGER), 32));
	public static final DeferredItem<CustomFoodItem> CHICKENBURGER = ITEMS.registerItem("chickenburger", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHICKEN_BURGER), 32));
	public static final DeferredItem<CustomFoodItem> FISH_AND_CHIPS = ITEMS.registerItem("fish_and_chips", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.FISH_AND_CHIPS), 32));
	public static final DeferredItem<CustomFoodItem> FRIES = ITEMS.registerItem("fries", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.FRIES), 32));
	public static final DeferredItem<CustomFoodItem> GUACAMOLE = ITEMS.registerItem("guacamole", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.GUACAMOLE), 32));
	public static final DeferredItem<CustomFoodItem> GUAC_AND_CHIPS = ITEMS.registerItem("guac_and_chips", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.GUAC_AND_CHIPS), 28));
	public static final DeferredItem<CustomFoodItem> HAMBURGER = ITEMS.registerItem("hamburger", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.HAMBURGER), 32));
	public static final DeferredItem<CustomFoodItem> JAM = ITEMS.registerItem("jam", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.JAM).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32));
	public static final DeferredItem<CustomFoodItem> POTATO_CHIPS = ITEMS.registerItem("potato_chips", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.POTATO_CHIPS), 24));
	public static final DeferredItem<CustomFoodItem> SLICED_BREAD = ITEMS.registerItem("sliced_bread", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.SLICED_BREAD), 32));
	public static final DeferredItem<CustomFoodItem> SPAGHETTI = ITEMS.registerItem("spaghetti", (properties) -> new ContainerFoodItem(properties.food(FarmingFoods.SPAGHETTI).stacksTo(16).craftRemainder(Items.BOWL), 40));

	//Sandwiches
	public static final DeferredItem<CustomFoodItem> BACON_SANDWICH = ITEMS.registerItem("bacon_sandwich", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.BACON_SANDWICH), 32));
	public static final DeferredItem<CustomFoodItem> CHICKEN_SANDWICH = ITEMS.registerItem("chicken_sandwich", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHICKEN_SANDWICH), 32));
	public static final DeferredItem<CustomFoodItem> EGG_SANDWICH = ITEMS.registerItem("egg_sandwich", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.EGG_SANDWICH), 32));
	public static final DeferredItem<CustomFoodItem> JC_SANDWICH = ITEMS.registerItem("jc_sandwich", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.JC_SANDWICH), 32));

	//Pizza
	public static final DeferredItem<CustomFoodItem> BACON_PIZZA = ITEMS.registerItem("bacon_pizza", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.BACON_PIZZA), 40));
	public static final DeferredItem<CustomFoodItem> CHEESE_PIZZA = ITEMS.registerItem("cheese_pizza", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHEESE_PIZZA), 40));
	public static final DeferredItem<CustomFoodItem> PINEAPPLE_PIZZA = ITEMS.registerItem("pineapple_pizza", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.PINEAPPLE_PIZZA), 40));

	//Pies
	public static final DeferredItem<CustomFoodItem> APPLE_PIE = ITEMS.registerItem("apple_pie", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.APPLE_PIE), 32));
	public static final DeferredItem<CustomFoodItem> BACON_AND_EGG_PIE = ITEMS.registerItem("bacon_and_egg_pie", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.BACON_AND_EGG_PIE), 32));
	public static final DeferredItem<CustomFoodItem> BANANA_PIE = ITEMS.registerItem("banana_pie", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.BANANA_PIE), 32));
	public static final DeferredItem<CustomFoodItem> CHERRY_PIE = ITEMS.registerItem("cherry_pie", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.CHERRY_PIE), 32));
	public static final DeferredItem<CustomFoodItem> GRAPE_PIE = ITEMS.registerItem("grape_pie", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.GRAPE_PIE), 32));
	public static final DeferredItem<CustomFoodItem> LEMON_PIE = ITEMS.registerItem("lemon_pie", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.LEMON_PIE), 32));
	public static final DeferredItem<CustomFoodItem> PEAR_PIE = ITEMS.registerItem("pear_pie", (properties) -> new CustomFoodItem(properties.food(FarmingFoods.PEAR_PIE), 32));

	//Rakes
	public static final DeferredItem<RakeToolItem> WOODEN_RAKE = ITEMS.registerItem("wooden_rake", (properties) -> new RakeToolItem(ToolMaterial.WOOD, 0, -3.0F, 1, properties));
	public static final DeferredItem<RakeToolItem> STONE_RAKE = ITEMS.registerItem("stone_rake", (properties) -> new RakeToolItem(ToolMaterial.STONE, 1, -2.0F, 2, properties));
	public static final DeferredItem<RakeToolItem> IRON_RAKE = ITEMS.registerItem("iron_rake", (properties) -> new RakeToolItem(ToolMaterial.IRON, 2, -1.0F, 3, properties));
	public static final DeferredItem<RakeToolItem> GOLD_RAKE = ITEMS.registerItem("gold_rake", (properties) -> new RakeToolItem(ToolMaterial.GOLD, 0, -3.0F, 6, properties));
	public static final DeferredItem<RakeToolItem> DIAMOND_RAKE = ITEMS.registerItem("diamond_rake", (properties) -> new RakeToolItem(ToolMaterial.DIAMOND, 3, 0.0F, 5, properties));

	//Seeds
	public static final DeferredItem<BlockItem> MINT_SEEDS = ITEMS.registerSimpleBlockItem("mint_seeds", FarmingRegistry.MINT_CROP, new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> NETHER_FLOWER_SEEDS = ITEMS.registerSimpleBlockItem("nether_flower_seeds", FarmingRegistry.NETHER_FLOWER_CROP, new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> TOMATO_SEEDS = ITEMS.registerSimpleBlockItem("tomato_seeds", FarmingRegistry.TOMATO_CROP, new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> CUCUMBER_SEEDS = ITEMS.registerSimpleBlockItem("cucumber_seeds", FarmingRegistry.CUCUMBER_CROP, new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> AUBERGINE_SEEDS = ITEMS.registerSimpleBlockItem("aubergine_seeds", FarmingRegistry.AUBERGINE_CROP, new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> GRAPE_SEEDS = ITEMS.registerItem("grape_seeds", (properties) -> new CropsticksSeedsBlock(FarmingRegistry.GRAPE_CROP.get(), properties), new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> PINEAPPLE_SEEDS = ITEMS.registerSimpleBlockItem("pineapple_seeds", FarmingRegistry.PINEAPPLE_CROP, new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> CORN_SEEDS = ITEMS.registerSimpleBlockItem("corn_seeds", FarmingRegistry.CORN_CROP, new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> ONION_SEEDS = ITEMS.registerSimpleBlockItem("onion_seeds", FarmingRegistry.ONION_CROP, new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> GARLIC_SEEDS = ITEMS.registerSimpleBlockItem("garlic_seeds", FarmingRegistry.GARLIC_CROP, new Properties().useItemDescriptionPrefix());
	public static final DeferredItem<BlockItem> LETTUCE_SEEDS = ITEMS.registerSimpleBlockItem("lettuce_seeds", FarmingRegistry.LETTUCE_CROP, new Properties().useItemDescriptionPrefix());

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
			new BlockEntityType<>(ScarecrowBlockEntity::new, FarmingRegistry.SCARECROW.get()));

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
