package com.evoslab.elhuevo.core.registry;

import com.evoslab.elhuevo.core.ElHuevo;
import com.minecraftabnormals.abnormals_core.common.items.AbnormalsSpawnEggItem;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ElHuevo.MOD_ID, bus = Bus.MOD)
public class EHItems {

	public static final ItemSubRegistryHelper HELPER = ElHuevo.REGISTRY_HELPER.getItemSubHelper();
	
	public static final RegistryObject<AbnormalsSpawnEggItem> EGG_DOG_SPAWN_EGG = HELPER.createSpawnEggItem("elhueve", () -> EHEntities.EGDOG.get(), 0xFFFFF5, 0x1D2635);
	
}
