package com.Mrbysco.EnhancedFarming.tileentity;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;

public class TileEntityScarecrow extends TileEntity implements ITickable{

	public Random rand = new Random();
    
    public TileEntityScarecrow() {
    	
    }
    
    @Override
    public void update() {
    	AxisAlignedBB hitbox = new AxisAlignedBB(this.pos.getX() - 0.5f, this.pos.getY() - 0.5f, this.pos.getZ() - 0.5f, this.pos.getX() + 0.5f, this.pos.getY() + 0.5f, this.pos.getZ() + 0.5f)
    			.expand(-5, -5, -5).expand(5, 5, 5);
    	
    	if(world.getEntitiesWithinAABB(Entity.class, hitbox) != null && !world.isRemote)
    	{
    		for(Entity animal : world.getEntitiesWithinAABB(Entity.class, hitbox)) {
                if(animal instanceof EntityAnimal || animal instanceof EntityWaterMob) {
                	Vec3i animalPos = getInvertedDirection(this.pos, animal);
                	
                	animal.moveRelative(animalPos.getX(), animalPos.getY(), animalPos.getZ(), 0.25F);
                }
            }
    	}
    }
	
	public Vec3i getInvertedDirection(BlockPos scarecrow, Entity animal)
	{
	    double x = (animal.posX > scarecrow.getX() ? -1 : 0);
	    x = (animal.posX < scarecrow.getX() ? 1 : 0);
	    double z = (animal.posZ > scarecrow.getZ() ? -1 : 0);
	    z = (animal.posZ < scarecrow.getZ() ? 1 : 0);
	    
	    return new Vec3i(animal.posX + x, 0, animal.posZ + z);
	}
	
}
