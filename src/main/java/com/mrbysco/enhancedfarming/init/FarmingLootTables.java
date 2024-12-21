package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.EnhancedFarming;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class FarmingLootTables {
	public static final ResourceKey<LootTable> GAMEPLAY_RAKE_DROPS = ResourceKey.create(Registries.LOOT_TABLE, EnhancedFarming.modLoc("gameplay/rake_drops"));
}
