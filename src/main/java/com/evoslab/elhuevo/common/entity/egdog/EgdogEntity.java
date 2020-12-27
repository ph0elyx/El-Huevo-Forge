package com.evoslab.elhuevo.common.entity.egdog;

import com.evoslab.elhuevo.core.registry.EHEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class EgdogEntity extends TameableEntity {

	public EgdogEntity(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		return EHEntities.EGDOG.get().create(world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new WaterAvoidingRandomWalkingGoal(this, 0.16));
		this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(2, new SitGoal(this));
		this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}
	
	@Override
	public void livingTick() {
		super.livingTick();
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 20.0)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.2)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0);
	}
	
}
