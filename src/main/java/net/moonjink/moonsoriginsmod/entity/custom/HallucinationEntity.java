package net.moonjink.moonsoriginsmod.entity.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.moonjink.moonsoriginsmod.entity.ai.HallucinationWaterAvoidingRandomStrollGoal;
import org.jetbrains.annotations.NotNull;

public class HallucinationEntity extends PathfinderMob {

    public HallucinationEntity(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.lifespan = 20 * 25;
    }
    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,20)
                .add(Attributes.FOLLOW_RANGE,35)
                .add(Attributes.ATTACK_DAMAGE, 4)
                .add(Attributes.ATTACK_KNOCKBACK, 0.4D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.ARMOR_TOUGHNESS, 0)
                .add(Attributes.MOVEMENT_SPEED,0.3D);
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 50.0F, 100F));
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new HallucinationWaterAvoidingRandomStrollGoal(this, 1.0, 100.0F));
    }

    /*      ANIMATIONS & LIFESPAN       */
    private int lifespan; // Creates lifespan -> look at super class for setting the value

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    // Override of the tick function, allows you to do something every tick
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            setupAnimationStates(); // Makes animations client-side only
        }

        // Lowers lifespan every tick
        if(!this.level().isClientSide) {
            lifespan--;

            if(lifespan <= 0) {
                this.discard();
            }
        }
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 60; // Length in ticks of anim;
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

    /*      ENTITY LIMIT       */
    public static int summonLimit;

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();

        if (!this.level().isClientSide) {
            // Count entities of this type currently in the world
            long count = this.level().getEntitiesOfClass(HallucinationEntity.class, this.getBoundingBox().inflate(50)).size();

            if (count > 5) {
                this.discard(); // Discard this entity if there's already one
            } else {
                summonLimit++;
            }
        }
    }

    @Override
    public void remove(@NotNull RemovalReason reason) {
        super.remove(reason);
        if (!this.level().isClientSide && summonLimit > 0) {
            summonLimit = Math.max(0, summonLimit - 1);
        }
    }
}
