package com.Mrbysco.EnhancedFarming.block;

public enum EnumCropType {
	MINT(false),
	TOMATO(false),
	CUCUMBER(false),
	AUBERGINE(false),
	GRAPE(false),
	PINEAPPLE(false);
	
	private final boolean dropMultiple;
	
	private EnumCropType(boolean dropMultiple) {
		this.dropMultiple = dropMultiple;
	}
	
	public boolean CanDropMultiple() {
		return dropMultiple;
	}
}
