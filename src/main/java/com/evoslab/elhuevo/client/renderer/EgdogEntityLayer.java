package com.evoslab.elhuevo.client.renderer;

import com.evoslab.elhuevo.client.model.EgdogEntityModel;
import com.evoslab.elhuevo.common.entity.egdog.EgdogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EgdogEntityLayer<T extends EgdogEntity> extends LayerRenderer<T, EgdogEntityModel<T>> {
	
	public static final ResourceLocation[] SKINS = {
			new ResourceLocation("elhuevo", "textures/entity/elhueve/white.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/orange.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/magenta.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/light_blue.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/yellow.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/lime.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/pink.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/gray.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/light_gray.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/cyan.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/purple.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/blue.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/brown.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/green.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/red.png"),
			new ResourceLocation("elhuevo", "textures/entity/elhueve/black.png")
    };
	
    public EgdogEntityLayer(IEntityRenderer<T, EgdogEntityModel<T>> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {
		if (entitylivingbaseIn.hasClothing()) {
			ResourceLocation skin = SKINS[(int)entitylivingbaseIn.getClothingColor()];
			float[] colors = entitylivingbaseIn.getClothingColorAsDye().getColorComponentValues();
			IVertexBuilder builder = bufferIn.getBuffer(RenderType.getEntityCutoutNoCull(skin));
			this.getEntityModel().setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			this.getEntityModel().render(matrixStackIn, builder, packedLightIn, OverlayTexture.NO_OVERLAY, colors[0], colors[1], colors[2], 1.0F);
		}
	}
}
