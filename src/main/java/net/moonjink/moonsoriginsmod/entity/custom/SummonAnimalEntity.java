package net.moonjink.moonsoriginsmod.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import net.moonjink.moonsoriginsmod.entity.ai.LichSummonWaterAvoidingRandomStrollGoal;
import net.moonjink.moonsoriginsmod.entity.ai.SummonsFollowGoal;
import org.jetbrains.annotations.Nullable;

public class SummonAnimalEntity extends TamableAnimal {
    @Override
    // Controls all data that MUST be synced
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SITTING, true);
    }

    // Super class
    public SummonAnimalEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    /*      GOALS      */
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal((this)));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new SummonsFollowGoal(this,1.4,10.0F,3.0F, false));
        this.goalSelector.addGoal(4, new LichSummonWaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Mob.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
    }

    /*      ATTRIBUTES      */
    public static AttributeSupplier.Builder createAttributes() {
        return TamableAnimal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,25)
                .add(Attributes.FOLLOW_RANGE,35)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.ATTACK_KNOCKBACK, 0.4D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0D)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.ARMOR_TOUGHNESS, 0)
                .add(Attributes.MOVEMENT_SPEED,0.3D);
    }


    /*      ANIMATIONS      */
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    // Override of the tick function, allows you to do something every tick
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setupAnimationStates(); // Makes animations client-side only
        }
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 60; // Length in ticks of idle anim
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }


    /*      REPRODUCTION      */
    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }


    /*      SOUNDS      */
    protected SoundEvent getAmbientSound() {
        return SoundEvents.FOX_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.FOX_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.FOX_DEATH;
    }


    /*      SITTING & TAMING      */
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Sitting", this.isSitting()); // Save state
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setSitting(tag.getBoolean("Sitting")); // Load saved state
    }

    // Makes the mob get up if it's hurt while sitting
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.isInvulnerableTo(pSource)) {
            return false;
        } else {
            Entity entity = pSource.getEntity();
            if (!this.level().isClientSide) {
                this.setOrderedToSit(false);
                this.setSitting(false);
            }

            if (entity != null && !(entity instanceof Player) && !(entity instanceof AbstractArrow)) {
                pAmount = (pAmount + 1.0F) / 2.0F;
            }

            return super.hurt(pSource, pAmount);
        }
    }

    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(SummonAnimalEntity.class, EntityDataSerializers.BOOLEAN);

    // Variable that checks if sitting -> only used here-ish
    private boolean isSitting;

    // Makes class that checks if the mob is sitting -> used for most things
    public boolean isSitting() {
        return this.entityData.get(SITTING);
    }

    // Creates class that allows isSitting to be changed
    public void setSitting(boolean sitting) {
        this.entityData.set(SITTING, sitting);
    }

    @Override
    // Events on mob use
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        // Establishes Item and the current item the player is holding
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();

        // Creates flags
        if (this.level().isClientSide) {
            boolean flag = this.isOwnedBy(pPlayer) || this.isTame() || itemstack.is(Items.BONE) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        }
        // If tamed and used it will sit
        else if (this.isTame()) {
            InteractionResult interactionresult = super.mobInteract(pPlayer, pHand);
            if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(pPlayer)) {
                // Controls sitting animation
                this.setSitting(!this.isSitting());

                // Sets the actual sit value to 1
                this.setOrderedToSit(!this.isOrderedToSit());

                // Stops movement
                this.jumping = false;
                this.navigation.stop();

                return InteractionResult.SUCCESS;
            } else {
                return interactionresult;
            }
        }
        else if (itemstack.is(Items.BONE) && !this.isOwnedBy(pPlayer)) {
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            // Taming event
            if (this.random.nextInt(1) == 0 && !ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                // Tames animal
                this.tame(pPlayer);

                // Stops movement
                this.navigation.stop();
                this.setTarget((LivingEntity)null);
                this.setOrderedToSit(true);

                // Sets the sitting animation to true otherwise it inverts the animation -> it is doing animation when not sitting and vice versa
                this.setSitting(true);

                // Entity event
                this.level().broadcastEntityEvent(this, (byte)7);
            } else {

                // Entity event
                this.level().broadcastEntityEvent(this, (byte)6);
            }

            return InteractionResult.SUCCESS;
        } else {
            // If no condition is fulfilled it does nothing
            return super.mobInteract(pPlayer, pHand);
        }
    }


    /*      ENTITY LIMIT       */
    public static int oneSummonLimit;

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        if (!this.level().isClientSide) {
            // Count entities of this type currently in the world
            long count = this.level().getEntitiesOfClass(this.getClass(), this.getBoundingBox().inflate(10000)).size();

            if (count > 1) {
                this.kill(); // Kill this entity if there's already one
            } else {
                oneSummonLimit++;
            }
        }
    }

    @Override
    public void remove(RemovalReason reason) {
        super.remove(reason);
        if (!this.level().isClientSide && oneSummonLimit > 0) {
            oneSummonLimit = Math.max(0, oneSummonLimit - 1);
        }
    }
}
