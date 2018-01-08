package com.Mrbysco.EnhancedFarming.render;

import com.Mrbysco.EnhancedFarming.block.BlockScarecrow;
import com.Mrbysco.EnhancedFarming.tileentity.TileEntityScarecrow;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class ScarecrowRenderer extends TileEntitySpecialRenderer<TileEntityScarecrow>{
	private ModelScarecrow model;
	
	private static final ResourceLocation texture = new ResourceLocation("bestfarming:textures/blocks/scarecrow.png");
	
	public ScarecrowRenderer() {
		this.model = new ModelScarecrow();	
	}
	
	@Override
	public void render(TileEntityScarecrow te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
    	EnumFacing enumfacing = EnumFacing.UP;
    	renderScarecrow(te, x, y, z, destroyStage, enumfacing);
	}
	
	public void renderScarecrow(TileEntityScarecrow te, double x, double y, double z, int destroyStage, EnumFacing enumfacing) 
	{
        float offset = -0.6f;

        if (te.hasWorld())
        {
            IBlockState iblockstate = this.getWorld().getBlockState(te.getPos());

            if (iblockstate.getBlock() instanceof BlockScarecrow)
            {
                enumfacing = (EnumFacing)iblockstate.getValue(BlockScarecrow.FACING);
            }
        }
        
        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
        else
        {
        	if (texture != null)
            {
            	this.bindTexture(texture);
    		}
        }
        
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();

        
        GlStateManager.enableAlpha();
        
        GlStateManager.translate((float)x + 0.5f, (float)y + 2.25f + offset, (float)z + 0.5f);
        
        switch (enumfacing)
        {
            case DOWN:
            case UP:
            default:
                break;
            case NORTH:
                break;
            case SOUTH:
                GlStateManager.rotate(-180.0F, 0.0F, 180.0F, 0.0F);
                break;
            case WEST:
                GlStateManager.rotate(-90.0F, 0.0F, -90.0F, 0.0F);
                break;
            case EAST:
                GlStateManager.rotate(-90.0F, 0.0F, 90.0F, 0.0F);
        }
        
        if (texture != null)
        {
        	this.bindTexture(texture);
        }
        
        GlStateManager.scale(-1f, -1f, -1.0f);
        this.model.renderModel(0.0625f);
        
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        
        if (destroyStage >= 0)
        {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
	}
}
