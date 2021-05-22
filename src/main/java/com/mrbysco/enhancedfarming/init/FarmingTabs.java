package com.mrbysco.enhancedfarming.init;

import com.mrbysco.enhancedfarming.Reference;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FarmingTabs {
	public static final ItemGroup TAB_MAIN = new ItemGroup(Reference.MOD_ID) {
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(FarmingRegistry.SCARECROW_ITEM.get());
		}
	};
}
