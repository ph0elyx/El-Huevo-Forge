package com.evoslab.elhuevo.common.entity.egdog;

import com.evoslab.elhuevo.core.registry.EHEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class EgdogEntity extends AnimalEntity {

	public EgdogEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		return EHEntities.EGDOG.get().create(world);
	}

	
	
}
