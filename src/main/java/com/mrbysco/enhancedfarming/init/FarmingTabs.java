package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.Reference;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class FarmingTabs {
	public static final CreativeModeTab TAB_MAIN = new CreativeModeTab(Reference.MOD_ID) {
		public ItemStack makeIcon() {
			return new ItemStack(FarmingRegistry.SCARECROW_ITEM.get());
		}
	};
}
