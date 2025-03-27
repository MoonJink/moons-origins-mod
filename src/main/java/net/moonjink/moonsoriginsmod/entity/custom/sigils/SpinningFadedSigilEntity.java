package net.moonjink.moonsoriginsmod.entity.custom.sigils;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SpinningFadedSigilEntity extends Animal {
    public SpinningFadedSigilEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.FOLLOW_RANGE, 1)
                .add(Attributes.MOVEMENT_SPEED, 0D);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }


    /*      ANIMATIONS AND LIFESPAN      */
    protected int lifespanSigil; // Creates lifespan -> look at super class for setting the value

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    @Override
    // Override of the tick function, allows you to do something every tick
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates(); // Makes animations client-side only
        }
        // Lowers lifespan every tick
        if (!this.level().isClientSide) {
            lifespanSigil--;

            if (lifespanSigil <= 0) {
                this.discard();
            }
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 19; // Length in ticks of idle anim
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }


    /*      COLLISION, INTERACTION AND DAMAGE      */
    @Override
    public boolean canBeCollidedWith() {
        return false; // No collision (not sure if works)
    }

    @Override
    public boolean isPushable() {
        return false; // Not pushable (not sure if works)
    }

    @Override
    public boolean isPickable() {
        return false; // Prevents anything from interacting with the entity
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource == this.level().damageSources().genericKill()) {
            this.discard();
        }
        if (!this.level().isClientSide) {
            return false;
        }
        return super.hurt(pSource, pAmount);
    }
}
