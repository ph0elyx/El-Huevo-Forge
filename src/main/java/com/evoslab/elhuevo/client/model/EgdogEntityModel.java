package com.evoslab.elhuevo.client.model;

import com.evoslab.elhuevo.common.entity.egdog.EgdogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class EgdogEntityModel<T extends EgdogEntity> extends EntityModel<T> {
	
	private final ModelRenderer body;
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer bodyhead;
	private final ModelRenderer tail;

	public EgdogEntityModel() {
		textureWidth = 32;
		textureHeight = 32;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 18).addBox(-3.0F, -9.0F, -2.0F, 6.0F, 8.0F, 5.0F, 0.1F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-1.5F, -1.5F, 0.5F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(22, 6).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(1.5F, -1.5F, 0.5F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(22, 9).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bodyhead = new ModelRenderer(this);
		bodyhead.setRotationPoint(0.0F, -5.6F, -0.2F);
		body.addChild(bodyhead);
		bodyhead.setTextureOffset(26, 3).addBox(2.0F, -4.4F, 0.2F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bodyhead.setTextureOffset(26, 0).addBox(-4.0F, -4.4F, 0.2F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bodyhead.setTextureOffset(0, 13).addBox(-2.0F, -0.4F, -2.8F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		bodyhead.setTextureOffset(0, 0).addBox(-3.0F, -3.4F, -1.8F, 6.0F, 8.0F, 5.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 3.6F, 2.7F);
		bodyhead.addChild(tail);
		tail.setTextureOffset(17, 0).addBox(-1.0F, -1.0F, 0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
	
}
