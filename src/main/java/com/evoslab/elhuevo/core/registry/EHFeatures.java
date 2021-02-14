package com.evoslab.elhuevo.core.registry;

import com.evoslab.elhuevo.core.ElHuevo;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElHuevo.MOD_ID)
public class EHFeatures {
	
	@SubscribeEvent
	public static void addFeatures(BiomeLoadingEvent event) {
		
		if (event.getCategory() == Category.ICY) {
			event.getSpawns().withSpawner(EntityClassification.CREATURE, new MobSpawnInfo.Spawners(EHEntities.EGDOG.get(), 30, 2, 4));
		}
		
	}
	
}
