package com.evoslab.elhuevo.core.registry;

import com.evoslab.elhuevo.core.ElHuevo;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElHuevo.MOD_ID)
public class EHFeatures {
	
	@SubscribeEvent
	public static void addFeatures(BiomeLoadingEvent event) {
		ResourceLocation biome = event.getName();
		
	}
	
}
