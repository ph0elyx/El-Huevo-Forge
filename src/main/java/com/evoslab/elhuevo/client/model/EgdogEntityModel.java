package com.evoslab.elhuevo.client.model;

import com.evoslab.elhuevo.common.entity.egdog.EgdogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class EgdogEntityModel<T extends EgdogEntity> extends EntityModel<T> {
	
	protected T entity;
	
	private ModelRenderer body;
	private ModelRenderer leftleg;
	private ModelRenderer rightleg;
	private ModelRenderer bodyhead;
	private ModelRenderer tail;
	private ModelRenderer cube_r2;
    private ModelRenderer cube_r1;

	public EgdogEntityModel() {
		textureWidth = 32;
		textureHeight = 32;

		this.body = new ModelRenderer(this);
		this.body.setRotationPoint(0.0F, 24.0F, 0.0F);
		this.body.setTextureOffset(0, 18).addBox(-3.0F, -9.0F, -2.0F, 6.0F, 8.0F, 5.0F, 0.1F, false);

		this.leftleg = new ModelRenderer(this);
		this.leftleg.setRotationPoint(-1.5F, -1.5F, 0.5F);
		this.body.addChild(leftleg);
		this.leftleg.setTextureOffset(22, 6).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		this.rightleg = new ModelRenderer(this);
		this.rightleg.setRotationPoint(1.5F, -1.5F, 0.5F);
		this.body.addChild(rightleg);
		this.rightleg.setTextureOffset(22, 9).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		this.bodyhead = new ModelRenderer(this);
		this.bodyhead.setRotationPoint(0.0F, -5.6F, -0.2F);
		this.body.addChild(bodyhead);
		this.bodyhead.setTextureOffset(26, 3).addBox(2.0F, -4.4F, 0.2F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		this.bodyhead.setTextureOffset(26, 0).addBox(-4.0F, -4.4F, 0.2F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		this.bodyhead.setTextureOffset(0, 13).addBox(-2.0F, -0.4F, -2.8F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		this.bodyhead.setTextureOffset(0, 0).addBox(-3.0F, -3.4F, -1.8F, 6.0F, 8.0F, 5.0F, 0.0F, false);

		this.tail = new ModelRenderer(this);
		this.tail.setRotationPoint(0.0F, 3.6F, 2.7F);
		this.bodyhead.addChild(tail);
		this.tail.setTextureOffset(17, 0).addBox(-1.0F, -1.0F, 0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.entity = entity;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		
		if (entityIn.isSitting()) {
			this.leftleg.setTextureOffset(22, 6).addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, false);
		} else 
			this.leftleg.setTextureOffset(22, 6).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
	}
}
