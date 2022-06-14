package com.mrbysco.enhancedfarming.config;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

public class FarmingConfig {

	public static class Common {
		public final BooleanValue hotBurnsPlayer;
		public final IntValue hotTime;
		public final BooleanValue rightClickFruitHarvest;
		public final BooleanValue relocationAllowed;
		public final IntValue treeDropChance;
		public final BooleanValue bonemealGrow;
		public final BooleanValue instantGrow;
		public final BooleanValue cropToSeeds;
		public final BooleanValue enableRake;
		public final BooleanValue seedsFromGrass;
		public final BooleanValue saplingsFromGrass;

		public final BooleanValue generateAppleTree;
		public final BooleanValue generateAvocadoTree;
		public final BooleanValue generateBananaTree;
		public final BooleanValue generateCherryTree;
		public final BooleanValue generateLemonTree;
		public final BooleanValue generateMangoTree;
		public final BooleanValue generateOliveTree;
		public final BooleanValue generateOrangeTree;
		public final BooleanValue generatePearTree;

		public final IntValue appleTreeRarity;
		public final IntValue avocadoTreeRarity;
		public final IntValue bananaTreeRarity;
		public final IntValue cherryTreeRarity;
		public final IntValue lemonTreeRarity;
		public final IntValue mangoTreeRarity;
		public final IntValue oliveTreeRarity;
		public final IntValue orangeTreeRarity;
		public final IntValue pearTreeRarity;

		public final BooleanValue generateNetherFlower;

		Common(ForgeConfigSpec.Builder builder) {
			builder.comment("General settings")
					.push("general");

			hotBurnsPlayer = builder
					.comment("Makes it so if you hold hot drinks for too long that you begin taking fire damage [Default: false]")
					.define("hotBurnsPlayer", false);

			hotTime = builder
					.comment("Amount of seconds before you start taking fire damage when 'hotBurnsPlayer' is enabled [Default: 15]")
					.defineInRange("hotTime", 15, 1, Integer.MAX_VALUE);

			rightClickFruitHarvest = builder
					.comment("When enabled the fruity leaves have to be right-clicked to be harvested [Default: true]")
					.define("rightClickFruitHarvest", true);

			relocationAllowed = builder
					.comment("When enabled makes you able to get fruit from leaves that were placed after shearing [Default: false]")
					.define("relocationAllowed", false);

			treeDropChance = builder
					.comment("The chance in which fruit drop from tree when \"rightClickFruitHarvest\" isn't enabled (1 in X chance) [Default: 20]")
					.defineInRange("treeDropChance", 20, 1, Integer.MAX_VALUE);

			bonemealGrow = builder
					.comment("When enabled allows the usage of bonemeal on the mods plants [Default: true]")
					.define("bonemealGrow", true);

			instantGrow = builder
					.comment("When enabled allows instant-growth using bonemeal on the mods plants [Default: false]")
					.define("instantGrow", false);

			cropToSeeds = builder
					.comment("Enables Crop to Seeds recipes [Default: true]")
					.define("crop_to_seeds", true);

			enableRake = builder
					.comment("Enables rakes [Default: true]")
					.define("enableRake", true);

			seedsFromGrass = builder
					.comment("When enabled makes seeds drop from grass [Default: false]")
					.define("seedsFromGrass", false);

			saplingsFromGrass = builder
					.comment("When enabled makes seeds drop from grass [Default: false]")
					.define("saplingsFromGrass", false);

			builder.pop();

			builder.comment("Tree settings")
					.push("tree");

			generateAppleTree = builder
					.comment("Enable generation of Apple trees [Default: true]")
					.define("generateAppleTree", true);

			generateAvocadoTree = builder
					.comment("Enable generation of Avocado trees [Default: true]")
					.define("generateAvocadoTree", true);

			generateBananaTree = builder
					.comment("Enable generation of Banana trees [Default: true]")
					.define("generateBananaTree", true);

			generateCherryTree = builder
					.comment("Enable generation of Cherry trees [Default: true]")
					.define("generateCherryTree", true);

			generateLemonTree = builder
					.comment("Enable generation of Lemon trees [Default: true]")
					.define("generateLemonTree", true);

			generateMangoTree = builder
					.comment("Enable generation of Mango trees [Default: true]")
					.define("generateMangoTree", true);

			generateOliveTree = builder
					.comment("Enable generation of Olive trees [Default: true]")
					.define("generateOliveTree", true);

			generateOrangeTree = builder
					.comment("Enable generation of Orange trees [Default: true]")
					.define("generateOrangeTree", true);

			generatePearTree = builder
					.comment("Enable generation of Pear trees [Default: true]")
					.define("generatePearTree", true);

			builder.pop();

			builder.comment("Tree Rarity")
					.push("rarity");

			appleTreeRarity = builder
					.comment("Rarity of Apple Trees. Makes the tree generate 1 every X times (Requires restart for changes to effect) [Default: 4]")
					.defineInRange("appleTreeRarity", 4, 1, Integer.MAX_VALUE);

			avocadoTreeRarity = builder
					.comment("Rarity of Avocado Trees. Makes the tree generate 1 every X times (Requires restart for changes to effect) [Default: 4]")
					.defineInRange("avocadoTreeRarity", 4, 1, Integer.MAX_VALUE);

			bananaTreeRarity = builder
					.comment("Rarity of Banana Trees. Makes the tree generate 1 every X times (Requires restart for changes to effect) [Default: 4]")
					.defineInRange("bananaTreeRarity", 4, 1, Integer.MAX_VALUE);

			cherryTreeRarity = builder
					.comment("Rarity of Cherry Trees. Makes the tree generate 1 every X times (Requires restart for changes to effect) [Default: 4]")
					.defineInRange("cherryTreeRarity", 4, 1, Integer.MAX_VALUE);

			lemonTreeRarity = builder
					.comment("Rarity of Lemon Trees. Makes the tree generate 1 every X times (Requires restart for changes to effect) [Default: 4]")
					.defineInRange("lemonTreeRarity", 4, 1, Integer.MAX_VALUE);

			mangoTreeRarity = builder
					.comment("Rarity of Mango Trees. Makes the tree generate 1 every X times (Requires restart for changes to effect) [Default: 4]")
					.defineInRange("mangoTreeRarity", 4, 1, Integer.MAX_VALUE);

			oliveTreeRarity = builder
					.comment("Rarity of Olive Trees. Makes the tree generate 1 every X times (Requires restart for changes to effect) [Default: 4]")
					.defineInRange("oliveTreeRarity", 4, 1, Integer.MAX_VALUE);

			orangeTreeRarity = builder
					.comment("Rarity of Orange Trees. Makes the tree generate 1 every X times (Requires restart for changes to effect) [Default: 4]")
					.defineInRange("orangeTreeRarity", 4, 1, Integer.MAX_VALUE);

			pearTreeRarity = builder
					.comment("Rarity of Pear Trees. Makes the tree generate 1 every X times (Requires restart for changes to effect) [Default: 4]")
					.defineInRange("pearTreeRarity", 4, 1, Integer.MAX_VALUE);

			builder.pop();

			builder.comment("Crop settings")
					.push("crop");

			generateNetherFlower = builder
					.comment("Enable generation of wild Nether Flower crops in the nether [Default: true]")
					.define("generateNetherFlower", true);

			builder.pop();
		}
	}


	public static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}

	@SubscribeEvent
	public static void onLoad(final ModConfigEvent.Loading configEvent) {
		EnhancedFarming.LOGGER.debug("Loaded Enhanced Farming's config file {}", configEvent.getConfig().getFileName());
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfigEvent.Reloading configEvent) {
		EnhancedFarming.LOGGER.fatal("Enhanced Farming's config just got changed on the file system!");
	}
}
