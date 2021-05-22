package com.mrbysco.enhancedfarming.tiles;

import com.mrbysco.enhancedfarming.init.FarmingRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;

import java.util.List;

public class ScarecrowTile extends TileEntity implements ITickableTileEntity {

    public ScarecrowTile() {
    	super(FarmingRegistry.SCARECROW_TILE.get());
    }
    
    @Override
    public void tick() {
    	AxisAlignedBB hitbox = new AxisAlignedBB(this.worldPosition.getX() - 0.5f, this.worldPosition.getY() - 0.5f, this.worldPosition.getZ() - 0.5f,
				this.worldPosition.getX() + 0.5f, this.worldPosition.getY() + 0.5f, this.worldPosition.getZ() + 0.5f)
    			.inflate(-5, -5, -5).inflate(5, 5, 5);

    	if(this.level != null) {
			List<Entity> entityList = this.level.getEntitiesOfClass(Entity.class, hitbox);
			if(!entityList.isEmpty() && !level.isClientSide) {
				for(Entity animal : entityList) {
					if(animal instanceof AnimalEntity || animal instanceof WaterMobEntity) {
						Vector3i animalPos = getInvertedDirection(this.worldPosition, animal);

						animal.moveRelative(0.25F, new Vector3d(animalPos.getX(), animalPos.getY(), animalPos.getZ()));
					}
				}
			}
		}
    }
	
	public Vector3i getInvertedDirection(BlockPos scarecrow, Entity animal) {
	    double x = (animal.getX() < scarecrow.getX() ? 1 : 0);
	    double z = (animal.getZ() < scarecrow.getZ() ? 1 : 0);
	    
	    return new Vector3i(animal.getX() + x, 0, animal.getZ() + z);
	}
}
