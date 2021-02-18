package com.evoslab.elhuevo.common.entity.egdog;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.evoslab.elhuevo.core.registry.EHEntities;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.SitGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class EgdogEntity extends TameableEntity {
	
	private static final DataParameter<Integer> CLOTHING_COLOR = EntityDataManager.createKey(EgdogEntity.class, DataSerializers.VARINT);
	
	public EgdogEntity(EntityType<? extends TameableEntity> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(CLOTHING_COLOR, -1);
	}
	
	@Override
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		return EHEntities.EGDOG.get().create(world);
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("ClothingColor", this.getClothingColor());
	}
	
	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		setClothingColor(compound.getInt("ClothingColor"));
	}
	
	@Nonnull
	@Override
	public ActionResultType func_230254_b_(PlayerEntity player, @Nonnull Hand hand) {
		ItemStack itemStack = player.getHeldItem(hand);
		
		if (!this.world.isRemote) {
			if (this.isTamed()) {
				if (itemStack.getItem() instanceof DyeItem) {
					DyeColor color = ((DyeItem)itemStack.getItem()).getDyeColor();
					if (color != this.getClothingColorAsDye()) {
						if (!player.isCreative()) itemStack.shrink(1);
						this.setClothingColorFromDye(color);
						return ActionResultType.SUCCESS;
					}
					
					return ActionResultType.FAIL;
				} else if (itemStack.getItem() == Items.STICK) {
	                this.func_233687_w_(!this.isSitting());
	                this.setJumping(false);
	                return ActionResultType.SUCCESS;
				}
			} else if (itemStack.getItem() == Items.EGG) {
				if (!player.isCreative()) itemStack.shrink(1);
				
				if (this.rand.nextInt(3) == 0) {
					this.setTamedBy(player);
					this.navigator.clearPath();
					this.setAttackTarget(null);
					this.func_233687_w_(true);
					this.world.setEntityState(this, (byte)7);
				} else this.world.setEntityState(this, (byte)6);
				
				return ActionResultType.SUCCESS;
			}
		}
		
		return super.func_230254_b_(player, hand);
	}
	
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new SitGoal(this));
		this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0, 6.0F, 2.0F, true));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.16));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}
	
	@Override
	public void livingTick() {
		super.livingTick();
	}
	
	public static AttributeModifierMap.MutableAttribute registerAttributes() {
		return MobEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MAX_HEALTH, 20.0)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 1.0)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0);
	}
	
	public boolean hasClothing() {
		return getClothingColor() >= 0 && getClothingColor() < 16;
	}
	
	public int getClothingColor() {
		return dataManager.get(CLOTHING_COLOR);
	}
	
	@Nullable
	public DyeColor getClothingColorAsDye() {
		int clothingColor = this.getClothingColor();
		if (!hasClothing()) return null;
		return DyeColor.byId(clothingColor);
	}
	
	public void setClothingColor(int clothingColor) {
		dataManager.set(CLOTHING_COLOR, clothingColor);
	}
	
	public void setClothingColorFromDye(DyeColor clothingColor) {
		this.setClothingColor((byte)clothingColor.getId());
	}
	
}
