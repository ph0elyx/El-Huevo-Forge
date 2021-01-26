package com.evoslab.elhuevo.client.renderer;

import com.evoslab.elhuevo.client.model.EgdogEntityModel;
import com.evoslab.elhuevo.common.entity.egdog.EgdogEntity;
import com.evoslab.elhuevo.core.ElHuevo;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class EgdogEntityRenderer extends MobRenderer<EgdogEntity, EgdogEntityModel<EgdogEntity>> {

	public EgdogEntityRenderer(EntityRendererManager rendererManagerIn) {
		super(rendererManagerIn, new EgdogEntityModel<EgdogEntity>(), 0.3f);
		this.addLayer(new EgdogEntityLayer<>(this));
	}
	
	@Override
	public ResourceLocation getEntityTexture(EgdogEntity entity) {
		return new ResourceLocation(ElHuevo.MOD_ID, "textures/entity/elhueve/elhueve.png");
	}
}
