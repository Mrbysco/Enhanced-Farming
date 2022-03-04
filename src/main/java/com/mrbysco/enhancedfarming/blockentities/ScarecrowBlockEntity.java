package com.mrbysco.enhancedfarming.blockentities;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class ScarecrowBlockEntity extends BlockEntity {

	protected ScarecrowBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state) {
		super(blockEntityType, pos, state);
	}

	public ScarecrowBlockEntity(BlockPos pos, BlockState p_155332_) {
		this(FarmingRegistry.SCARECROW_TILE.get(), pos, p_155332_);
	}

	public static void serverTick(Level level, BlockPos pos, BlockState state, ScarecrowBlockEntity blockEntity) {
		AABB hitbox = new AABB(pos.getX() - 0.5f, pos.getY() - 0.5f, pos.getZ() - 0.5f,
				pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f)
				.inflate(-5, -5, -5).inflate(5, 5, 5);

		if (level != null) {
			List<Entity> entityList = level.getEntitiesOfClass(Entity.class, hitbox);
			if (!entityList.isEmpty()) {
				for (Entity animal : entityList) {
					if (animal instanceof Animal || animal instanceof WaterAnimal) {
						Vec3i animalPos = getInvertedDirection(pos, animal);

						animal.moveRelative(0.25F, new Vec3(animalPos.getX(), animalPos.getY(), animalPos.getZ()));
					}
				}
			}
		}
	}

	public static Vec3i getInvertedDirection(BlockPos scarecrow, Entity animal) {
		double x = (animal.getX() < scarecrow.getX() ? 1 : 0);
		double z = (animal.getZ() < scarecrow.getZ() ? 1 : 0);

		return new Vec3i(animal.getX() + x, 0, animal.getZ() + z);
	}
}
