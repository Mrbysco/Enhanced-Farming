package com.Mrbysco.EnhancedFarming.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelScarecrow extends ModelBase {
		ModelRenderer head;
		ModelRenderer body;
		ModelRenderer rightarm;
		ModelRenderer leftarm;
		ModelRenderer rightleg;
		ModelRenderer leftleg;
		ModelRenderer Stick;
		ModelRenderer Stick2;
		ModelRenderer Shape1;
		ModelRenderer Shape2;
		ModelRenderer Shape3;
		ModelRenderer Shape4;

	   public ModelScarecrow() {
	      super.textureWidth = 64;
	      super.textureHeight = 64;
	      this.head = new ModelRenderer(this, 0, 0);
	      this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
	      this.head.setRotationPoint(0.0F, 4.0F, 0.0F);
	      this.head.setTextureSize(64, 64);
	      this.head.mirror = true;
	      this.setRotation(this.head, -0.2443461F, 0.0F, 0.0F);
	      this.body = new ModelRenderer(this, 16, 16);
	      this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
	      this.body.setRotationPoint(0.0F, 4.0F, 0.0F);
	      this.body.setTextureSize(64, 64);
	      this.body.mirror = true;
	      this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
	      this.rightarm = new ModelRenderer(this, 40, 16);
	      this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
	      this.rightarm.setRotationPoint(-6.0F, 8.0F, 0.0F);
	      this.rightarm.setTextureSize(64, 64);
	      this.rightarm.mirror = true;
	      this.setRotation(this.rightarm, 0.0F, 0.0F, 1.518436F);
	      this.leftarm = new ModelRenderer(this, 40, 16);
	      this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
	      this.leftarm.setRotationPoint(6.0F, 8.0F, 0.0F);
	      this.leftarm.setTextureSize(64, 64);
	      this.leftarm.mirror = true;
	      this.setRotation(this.leftarm, 0.0F, 0.0F, -1.518436F);
	      this.rightleg = new ModelRenderer(this, 0, 16);
	      this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
	      this.rightleg.setRotationPoint(-2.0F, 16.0F, 0.0F);
	      this.rightleg.setTextureSize(64, 64);
	      this.rightleg.mirror = true;
	      this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0872665F);
	      this.leftleg = new ModelRenderer(this, 0, 16);
	      this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
	      this.leftleg.setRotationPoint(2.0F, 16.0F, 0.0F);
	      this.leftleg.setTextureSize(64, 64);
	      this.leftleg.mirror = true;
	      this.setRotation(this.leftleg, 0.0F, 0.0F, -0.0872665F);
	      this.Stick = new ModelRenderer(this, 56, 0);
	      this.Stick.addBox(0.0F, 0.0F, 0.0F, 2, 32, 1);
	      this.Stick.setRotationPoint(-1.0F, -2.0F, -3.0F);
	      this.Stick.setTextureSize(64, 64);
	      this.Stick.mirror = true;
	      this.setRotation(this.Stick, 0.0F, 0.0F, 0.0F);
	      this.Stick2 = new ModelRenderer(this, 56, 0);
	      this.Stick2.addBox(0.0F, 0.0F, 0.0F, 2, 32, 1);
	      this.Stick2.setRotationPoint(-16.0F, 8.0F, -3.0F);
	      this.Stick2.setTextureSize(64, 64);
	      this.Stick2.mirror = true;
	      this.setRotation(this.Stick2, 0.0F, 0.0F, -1.5707964F);
	      this.Shape1 = new ModelRenderer(this, 24, 0);
	      this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 4);
	      this.Shape1.setRotationPoint(9.0F, 5.0F, -2.0F);
	      this.Shape1.setTextureSize(64, 64);
	      this.Shape1.mirror = true;
	      this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
	      this.Shape2 = new ModelRenderer(this, 24, 0);
	      this.Shape2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 4);
	      this.Shape2.setRotationPoint(-10.0F, 5.0F, -2.0F);
	      this.Shape2.setTextureSize(64, 64);
	      this.Shape2.mirror = true;
	      this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
	      this.Shape3 = new ModelRenderer(this, 32, 11);
	      this.Shape3.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
	      this.Shape3.setRotationPoint(0.0F, 20.0F, -2.0F);
	      this.Shape3.setTextureSize(64, 64);
	      this.Shape3.mirror = true;
	      this.setRotation(this.Shape3, 0.0F, 0.0F, -0.0872665F);
	      this.Shape4 = new ModelRenderer(this, 32, 11);
	      this.Shape4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 4);
	      this.Shape4.setRotationPoint(-4.0F, 20.0F, -2.0F);
	      this.Shape4.setTextureSize(64, 64);
	      this.Shape4.mirror = true;
	      this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0872665F);
	   }

	   public void render(Entity entityIn, float f, float f1, float f2, float f3, float f4, float f5) {
	      super.render(entityIn, f, f1, f2, f3, f4, f5);
	      setRotationAngles(f, f1, f2, f3, f4, f5, entityIn);
	      this.head.render(f5);
	      this.body.render(f5);
	      this.rightarm.render(f5);
	      this.leftarm.render(f5);
	      this.rightleg.render(f5);
	      this.leftleg.render(f5);
	      this.Stick.render(f5);
	      this.Stick2.render(f5);
	      this.Shape1.render(f5);
	      this.Shape2.render(f5);
	      this.Shape3.render(f5);
	      this.Shape4.render(f5);
	   }

	   private void setRotation(ModelRenderer model, float x, float y, float z) {
	      model.rotateAngleX = x;
	      model.rotateAngleY = y;
	      model.rotateAngleZ = z;
	   }

	   public void renderModel(float f5) {
	      this.head.render(f5);
	      this.body.render(f5);
	      this.rightarm.render(f5);
	      this.leftarm.render(f5);
	      this.rightleg.render(f5);
	      this.leftleg.render(f5);
	      this.Stick.render(f5);
	      this.Stick2.render(f5);
	      this.Shape1.render(f5);
	      this.Shape2.render(f5);
	      this.Shape3.render(f5);
	      this.Shape4.render(f5);
	   }
	}