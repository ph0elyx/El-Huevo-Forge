package com.evoslab.elhuevo.core.registry;

import com.evoslab.elhuevo.common.entity.egdog.EgdogEntity;
import com.evoslab.elhuevo.core.ElHuevo;
import com.minecraftabnormals.abnormals_core.core.util.registry.EntitySubRegistryHelper;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class EHEntities {

	public static final EntitySubRegistryHelper HELPER = ElHuevo.REGISTRY_HELPER.getEntitySubHelper();
	
	public static final RegistryObject<EntityType<EgdogEntity>> EGDOG = HELPER.createLivingEntity("egdog", EgdogEntity::new, EntityClassification.CREATURE, 0.9f, 1.3f);
	
}
