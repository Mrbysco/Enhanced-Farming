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
import com.mrbysco.enhancedfarming.blockentities.ScarecrowBlockEntity;
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
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FarmingRegistry {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Reference.MOD_ID);

	//Blocks
	public static final RegistryObject<Block> APPLE_SAPLING = BLOCKS.register("apple_sapling", () -> new GrowableSaplingBlock(new AppleTree(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new GrowableSaplingBlock(new LemonTree(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new GrowableSaplingBlock(new OrangeTree(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> CHERRY_SAPLING = BLOCKS.register("cherry_sapling", () -> new GrowableSaplingBlock(new CherryTree(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> PEAR_SAPLING = BLOCKS.register("pear_sapling", () -> new GrowableSaplingBlock(new PearTree(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling", () -> new GrowableSaplingBlock(new BananaTree(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> AVOCADO_SAPLING = BLOCKS.register("avocado_sapling", () -> new GrowableSaplingBlock(new AvocadoTree(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> MANGO_SAPLING = BLOCKS.register("mango_sapling", () -> new GrowableSaplingBlock(new MangoTree(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
	public static final RegistryObject<Block> OLIVE_SAPLING = BLOCKS.register("olive_sapling", () -> new GrowableSaplingBlock(new OliveTree(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));

	public static final RegistryObject<Block> APPLE_LEAVES = BLOCKS.register("apple_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES), () -> Items.APPLE));
	public static final RegistryObject<Block> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES), FarmingRegistry.LEMON));
	public static final RegistryObject<Block> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES), FarmingRegistry.ORANGE));
	public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES), FarmingRegistry.CHERRY));
	public static final RegistryObject<Block> PEAR_LEAVES = BLOCKS.register("pear_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES), FarmingRegistry.PEAR));
	public static final RegistryObject<Block> BANANA_LEAVES = BLOCKS.register("banana_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES), FarmingRegistry.BANANA));
	public static final RegistryObject<Block> AVOCADO_LEAVES = BLOCKS.register("avocado_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES), FarmingRegistry.AVOCADO));
	public static final RegistryObject<Block> MANGO_LEAVES = BLOCKS.register("mango_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES), FarmingRegistry.MANGO));
	public static final RegistryObject<Block> OLIVE_LEAVES = BLOCKS.register("olive_leaves", () -> new FruitLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES), FarmingRegistry.OLIVE));

	public static final RegistryObject<Block> MINT_CROP = BLOCKS.register("mint_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.MINT));
	public static final RegistryObject<Block> NETHER_FLOWER_CROP = BLOCKS.register("nether_flower_crop", () -> new NetherFlowerBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
	public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop", () -> new SixAgeCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.TOMATO));
	public static final RegistryObject<Block> CUCUMBER_CROP = BLOCKS.register("cucumber_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.CUCUMBER));
	public static final RegistryObject<Block> AUBERGINE_CROP = BLOCKS.register("aubergine_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.AUBERGINE));
	public static final RegistryObject<Block> GRAPE_CROP = BLOCKS.register("grape_crop", () -> new CropstickCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.GRAPES));
	public static final RegistryObject<Block> PINEAPPLE_CROP = BLOCKS.register("pineapple_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.PINEAPPLE));
	public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop", () -> new SevenAgeCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.CORN));
	public static final RegistryObject<Block> ONION_CROP = BLOCKS.register("onion_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.ONION));
	public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.GARLIC));
	public static final RegistryObject<Block> LETTUCE_CROP = BLOCKS.register("lettuce_crop", () -> new FiveAgeCropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP), FarmingRegistry.LETTUCE));

	public static final RegistryObject<Block> CROP_STICK = BLOCKS.register("crop_stick", () -> new CropStickBlock(BlockBehaviour.Properties.of(Material.PLANT)));
	public static final RegistryObject<Block> SCARECROW = BLOCKS.register("scarecrow", () -> new ScarecrowBlock(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).sound(SoundType.WOOL)));

	//Items
	public static final RegistryObject<Item> POT = ITEMS.register("pot", () -> new CustomUtensilItem(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> CUTTING_BOARD = ITEMS.register("cutting_board", () -> new CustomUtensilItem(new Item.Properties().stacksTo(1)));
	public static final RegistryObject<Item> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle", () -> new CustomUtensilItem(new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> AUBERGINE = ITEMS.register("aubergine", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.AUBERGINE), 32));
	public static final RegistryObject<Item> AVOCADO = ITEMS.register("avocado", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.AVOCADO), 32));
	public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BANANA), 32));
	public static final RegistryObject<Item> CHERRY = ITEMS.register("cherry", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHERRY), 32));
	public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CUCUMBER), 32));
	public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GRAPES), 32));
	public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.LEMON), 32));
	public static final RegistryObject<Item> MANGO = ITEMS.register("mango", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.MANGO), 32));
	public static final RegistryObject<Item> MINT = ITEMS.register("mint", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> OLIVE = ITEMS.register("olive", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.OLIVE), 32));
	public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.ORANGE), 32));
	public static final RegistryObject<Item> PEAR = ITEMS.register("pear", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.PEAR), 32));
	public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.PINEAPPLE), 32));
	public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.TOMATO), 32));

	public static final RegistryObject<Item> CORN = ITEMS.register("corn", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CORN), 32));
	public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GARLIC), 32));
	public static final RegistryObject<Item> LETTUCE = ITEMS.register("lettuce", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.LETTUCE), 32));
	public static final RegistryObject<Item> ONION = ITEMS.register("onion", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.ONION), 32));

	public static final RegistryObject<Item> GOLDEN_LEMON = ITEMS.register("golden_lemon", () -> new SpecialCustomFoodItem(new Item.Properties().food(FarmingFoods.GOLD_LEMON), 32, true));
	public static final RegistryObject<Item> GOLDEN_ORANGE = ITEMS.register("golden_orange", () -> new SpecialCustomFoodItem(new Item.Properties().food(FarmingFoods.GOLD_ORANGE), 32, true));

	public static final RegistryObject<Item> CHOCOLATE_BAR = ITEMS.register("chocolate_bar", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_BAR), 32));
	public static final RegistryObject<Item> CHOCOLATE_BANANA = ITEMS.register("chocolate_banana", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_BANANA), 32));
	public static final RegistryObject<Item> CHOCOLATE_CANDY = ITEMS.register("chocolate_candy", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_CANDY), 2));
	public static final RegistryObject<Item> CHOCOLATE_CHERRY = ITEMS.register("chocolate_cherry", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_CHERRY), 32));

	public static final RegistryObject<Item> MINT_CHOCOLATE_BAR = ITEMS.register("mint_chocolate_bar", () -> new SpecialCustomFoodItem(new Item.Properties().food(FarmingFoods.CHOCOLATE_BAR_MINT).stacksTo(16), 32, false, true, false));
	public static final RegistryObject<Item> MINT_TEA = ITEMS.register("mint_tea", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.MINT_TEA).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, false, true, false, UseAnim.DRINK));
	public static final RegistryObject<Item> MILK_BOTTLE = ITEMS.register("milk_bottle", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.MILK_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, false, false, true, UseAnim.DRINK));
	public static final RegistryObject<Item> COLD_CHOCOLATE_BOTTLE = ITEMS.register("cold_chocolate_bottle", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.COLD_CHOCOLATE_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> HOT_CHOCOLATE_BOTTLE = ITEMS.register("hot_chocolate_bottle", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.HOT_CHOCOLATE_BOTTLE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> HOT_WATER = ITEMS.register("hot_water", () -> new Item(new Item.Properties()));

	//Juices
	public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.APPLE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> LEMONADE = ITEMS.register("lemonade", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.LEMONADE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> ORANGE_JUICE = ITEMS.register("orange_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.ORANGE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> CHERRY_JUICE = ITEMS.register("cherry_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CHERRY_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> PEAR_JUICE = ITEMS.register("pear_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.PEAR_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> BANANA_JUICE = ITEMS.register("banana_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.BANANA_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> GRAPE_JUICE = ITEMS.register("grape_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.GRAPE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> MANGO_JUICE = ITEMS.register("mango_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.MANGO_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> PINEAPPLE_JUICE = ITEMS.register("pineapple_juice", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.PINEAPPLE_JUICE).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));

	//Smoothies
	public static final RegistryObject<Item> SMOOTHIE_APPLE = ITEMS.register("smoothie_apple", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.APPLE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> SMOOTHIE_BANANA = ITEMS.register("smoothie_banana", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.BANANA_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> SMOOTHIE_CHERRY = ITEMS.register("smoothie_cherry", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CHERRY_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> SMOOTHIE_CUCUMBER = ITEMS.register("smoothie_cucumber", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CUCUMBER_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> SMOOTHIE_GRAPE = ITEMS.register("smoothie_grape", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.GRAPE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> SMOOTHIE_LEMON = ITEMS.register("smoothie_lemon", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.LEMON_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> SMOOTHIE_MANGO = ITEMS.register("smoothie_mango", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.MANGO_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> SMOOTHIE_ORANGE = ITEMS.register("smoothie_orange", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.ORANGE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> SMOOTHIE_PEAR = ITEMS.register("smoothie_pear", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.PEAR_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> SMOOTHIE_PINEAPPLE = ITEMS.register("smoothie_pineapple", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.PINEAPPLE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32, UseAnim.DRINK));

	//Actual food
	public static final RegistryObject<Item> DOUGH = ITEMS.register("dough", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> FLOUR = ITEMS.register("flour", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> OLIVE_OIL = ITEMS.register("olive_oil", () -> new Item(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));
	public static final RegistryObject<Item> PASTA = ITEMS.register("pasta", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> RAW_FRIES = ITEMS.register("raw_fries", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> STOCK = ITEMS.register("stock", () -> new Item(new Item.Properties()));

	public static final RegistryObject<Item> FRUIT_SALAD = ITEMS.register("fruit_salad", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.FRUIT_SALAD).stacksTo(16).craftRemainder(Items.BOWL), 24, UseAnim.EAT));
	public static final RegistryObject<Item> SALAD = ITEMS.register("salad", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.SALAD).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 24, UseAnim.DRINK));
	public static final RegistryObject<Item> CARROT_SOUP = ITEMS.register("carrot_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CARROT_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> CHICKEN_NOODLE_SOUP = ITEMS.register("chicken_noodle_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CHICKEN_NOODLE_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> CORN_SOUP = ITEMS.register("corn_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CORN_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> CUCUMBER_SOUP = ITEMS.register("cucumber_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.CUCUMBER_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> ONION_SOUP = ITEMS.register("onion_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.ONION_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> POTATO_SOUP = ITEMS.register("potato_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.POTATO_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));
	public static final RegistryObject<Item> TOMATO_SOUP = ITEMS.register("tomato_soup", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.TOMATO_SOUP).stacksTo(16).craftRemainder(Items.BOWL), 32, UseAnim.DRINK));

	public static final RegistryObject<Item> BAKED_EGG = ITEMS.register("baked_egg", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.OMELET), 32));
	public static final RegistryObject<Item> BOILED_EGG = ITEMS.register("boiled_egg", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BOILED_EGG), 32));
	public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHEESE), 32));
	public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHEESE_BURGER), 32));
	public static final RegistryObject<Item> CHICKENBURGER = ITEMS.register("chickenburger", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHICKEN_BURGER), 32));
	public static final RegistryObject<Item> FISH_AND_CHIPS = ITEMS.register("fish_and_chips", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.FISH_AND_CHIPS), 32));
	public static final RegistryObject<Item> FRIES = ITEMS.register("fries", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.FRIES), 32));
	public static final RegistryObject<Item> GUACAMOLE = ITEMS.register("guacamole", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GUACAMOLE), 32));
	public static final RegistryObject<Item> GUAC_AND_CHIPS = ITEMS.register("guac_and_chips", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GUAC_AND_CHIPS), 28));
	public static final RegistryObject<Item> HAMBURGER = ITEMS.register("hamburger", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.HAMBURGER), 32));
	public static final RegistryObject<Item> JAM = ITEMS.register("jam", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.JAM).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), 32));
	public static final RegistryObject<Item> POTATO_CHIPS = ITEMS.register("potato_chips", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.POTATO_CHIPS), 24));
	public static final RegistryObject<Item> SLICED_BREAD = ITEMS.register("sliced_bread", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.SLICED_BREAD), 32));
	public static final RegistryObject<Item> SPAGHETTI = ITEMS.register("spaghetti", () -> new ContainerFoodItem(new Item.Properties().food(FarmingFoods.SPAGHETTI).stacksTo(16).craftRemainder(Items.BOWL), 40));

	//Sandwiches
	public static final RegistryObject<Item> BACON_SANDWICH = ITEMS.register("bacon_sandwich", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BACON_SANDWICH), 32));
	public static final RegistryObject<Item> CHICKEN_SANDWICH = ITEMS.register("chicken_sandwich", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHICKEN_SANDWICH), 32));
	public static final RegistryObject<Item> EGG_SANDWICH = ITEMS.register("egg_sandwich", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.EGG_SANDWICH), 32));
	public static final RegistryObject<Item> JC_SANDWICH = ITEMS.register("jc_sandwich", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.JC_SANDWICH), 32));

	//Pizza
	public static final RegistryObject<Item> BACON_PIZZA = ITEMS.register("bacon_pizza", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BACON_PIZZA), 40));
	public static final RegistryObject<Item> CHEESE_PIZZA = ITEMS.register("cheese_pizza", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHEESE_PIZZA), 40));
	public static final RegistryObject<Item> PINEAPPLE_PIZZA = ITEMS.register("pineapple_pizza", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.PINEAPPLE_PIZZA), 40));

	//Pies
	public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.APPLE_PIE), 32));
	public static final RegistryObject<Item> BACON_AND_EGG_PIE = ITEMS.register("bacon_and_egg_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BACON_AND_EGG_PIE), 32));
	public static final RegistryObject<Item> BANANA_PIE = ITEMS.register("banana_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.BANANA_PIE), 32));
	public static final RegistryObject<Item> CHERRY_PIE = ITEMS.register("cherry_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.CHERRY_PIE), 32));
	public static final RegistryObject<Item> GRAPE_PIE = ITEMS.register("grape_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.GRAPE_PIE), 32));
	public static final RegistryObject<Item> LEMON_PIE = ITEMS.register("lemon_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.LEMON_PIE), 32));
	public static final RegistryObject<Item> PEAR_PIE = ITEMS.register("pear_pie", () -> new CustomFoodItem(new Item.Properties().food(FarmingFoods.PEAR_PIE), 32));

	//Rakes
	public static final RegistryObject<Item> WOODEN_RAKE = ITEMS.register("wooden_rake", () -> new RakeToolItem(Tiers.WOOD, 0, -3.0F, 1, new Item.Properties()));
	public static final RegistryObject<Item> STONE_RAKE = ITEMS.register("stone_rake", () -> new RakeToolItem(Tiers.STONE, -1, -2.0F, 2, new Item.Properties()));
	public static final RegistryObject<Item> IRON_RAKE = ITEMS.register("iron_rake", () -> new RakeToolItem(Tiers.IRON, -2, -1.0F, 3, new Item.Properties()));
	public static final RegistryObject<Item> GOLD_RAKE = ITEMS.register("gold_rake", () -> new RakeToolItem(Tiers.GOLD, 0, -3.0F, 6, new Item.Properties()));
	public static final RegistryObject<Item> DIAMOND_RAKE = ITEMS.register("diamond_rake", () -> new RakeToolItem(Tiers.DIAMOND, -3, 0.0F, 5, new Item.Properties()));

	//Seeds
	public static final RegistryObject<Item> MINT_SEEDS = ITEMS.register("mint_seeds", () -> new ItemNameBlockItem(FarmingRegistry.MINT_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> NETHER_FLOWER_SEEDS = ITEMS.register("nether_flower_seeds", () -> new ItemNameBlockItem(FarmingRegistry.NETHER_FLOWER_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new ItemNameBlockItem(FarmingRegistry.TOMATO_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds", () -> new ItemNameBlockItem(FarmingRegistry.CUCUMBER_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> AUBERGINE_SEEDS = ITEMS.register("aubergine_seeds", () -> new ItemNameBlockItem(FarmingRegistry.AUBERGINE_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds", () -> new CropsticksSeedsBlock(FarmingRegistry.GRAPE_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> PINEAPPLE_SEEDS = ITEMS.register("pineapple_seeds", () -> new ItemNameBlockItem(FarmingRegistry.PINEAPPLE_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds", () -> new ItemNameBlockItem(FarmingRegistry.CORN_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> ONION_SEEDS = ITEMS.register("onion_seeds", () -> new ItemNameBlockItem(FarmingRegistry.ONION_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> GARLIC_SEEDS = ITEMS.register("garlic_seeds", () -> new ItemNameBlockItem(FarmingRegistry.GARLIC_CROP.get(), new Item.Properties()));
	public static final RegistryObject<Item> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds", () -> new ItemNameBlockItem(FarmingRegistry.LETTUCE_CROP.get(), new Item.Properties()));

	public static final RegistryObject<Item> APPLE_SAPLING_ITEM = ITEMS.register("apple_sapling", () -> new BlockItem(FarmingRegistry.APPLE_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> LEMON_SAPLING_ITEM = ITEMS.register("lemon_sapling", () -> new BlockItem(FarmingRegistry.LEMON_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> ORANGE_SAPLING_ITEM = ITEMS.register("orange_sapling", () -> new BlockItem(FarmingRegistry.ORANGE_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHERRY_SAPLING_ITEM = ITEMS.register("cherry_sapling", () -> new BlockItem(FarmingRegistry.CHERRY_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> PEAR_SAPLING_ITEM = ITEMS.register("pear_sapling", () -> new BlockItem(FarmingRegistry.PEAR_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> BANANA_SAPLING_ITEM = ITEMS.register("banana_sapling", () -> new BlockItem(FarmingRegistry.BANANA_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> AVOCADO_SAPLING_ITEM = ITEMS.register("avocado_sapling", () -> new BlockItem(FarmingRegistry.AVOCADO_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> MANGO_SAPLING_ITEM = ITEMS.register("mango_sapling", () -> new BlockItem(FarmingRegistry.MANGO_SAPLING.get(), new Item.Properties()));
	public static final RegistryObject<Item> OLIVE_SAPLING_ITEM = ITEMS.register("olive_sapling", () -> new BlockItem(FarmingRegistry.OLIVE_SAPLING.get(), new Item.Properties()));

	public static final RegistryObject<Item> APPLE_LEAVES_ITEM = ITEMS.register("apple_leaves", () -> new BlockItem(FarmingRegistry.APPLE_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> LEMON_LEAVES_ITEM = ITEMS.register("lemon_leaves", () -> new BlockItem(FarmingRegistry.LEMON_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> ORANGE_LEAVES_ITEM = ITEMS.register("orange_leaves", () -> new BlockItem(FarmingRegistry.ORANGE_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> CHERRY_LEAVES_ITEM = ITEMS.register("cherry_leaves", () -> new BlockItem(FarmingRegistry.CHERRY_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> PEAR_LEAVES_ITEM = ITEMS.register("pear_leaves", () -> new BlockItem(FarmingRegistry.PEAR_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> BANANA_LEAVES_ITEM = ITEMS.register("banana_leaves", () -> new BlockItem(FarmingRegistry.BANANA_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> AVOCADO_LEAVES_ITEM = ITEMS.register("avocado_leaves", () -> new BlockItem(FarmingRegistry.AVOCADO_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> MANGO_LEAVES_ITEM = ITEMS.register("mango_leaves", () -> new BlockItem(FarmingRegistry.MANGO_LEAVES.get(), new Item.Properties()));
	public static final RegistryObject<Item> OLIVE_LEAVES_ITEM = ITEMS.register("olive_leaves", () -> new BlockItem(FarmingRegistry.OLIVE_LEAVES.get(), new Item.Properties()));

	public static final RegistryObject<Item> CROP_STICK_ITEM = ITEMS.register("crop_stick", () -> new BlockItem(FarmingRegistry.CROP_STICK.get(), new Item.Properties()));
	public static final RegistryObject<Item> SCARECROW_ITEM = ITEMS.register("scarecrow", () -> new BlockItem(FarmingRegistry.SCARECROW.get(), new Item.Properties()));

	public static final RegistryObject<BlockEntityType<ScarecrowBlockEntity>> SCARECROW_TILE = BLOCK_ENTITY_TYPES.register("scarecrow", () ->
			BlockEntityType.Builder.of(ScarecrowBlockEntity::new, FarmingRegistry.SCARECROW.get()).build(null));
}
