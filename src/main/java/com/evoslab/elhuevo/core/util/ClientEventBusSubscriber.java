package com.evoslab.elhuevo.core.util;

import com.evoslab.elhuevo.client.renderer.EgdogEntityRenderer;
import com.evoslab.elhuevo.core.ElHuevo;
import com.evoslab.elhuevo.core.registry.EHEntities;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ElHuevo.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EHEntities.EGDOG.get(), EgdogEntityRenderer::new);
	}
	
}
