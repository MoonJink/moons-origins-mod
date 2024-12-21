package net.moonjink.moonsoriginsmod.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class DelayedTeleportSigilEntity extends Animal {
    public DelayedTeleportSigilEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.lifespan = 20 * 2; // Second number is the duration in seconds, * 20 converts to ticks
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,1)
                .add(Attributes.FOLLOW_RANGE,1)
                .add(Attributes.MOVEMENT_SPEED,0D);
    }
    @Override
    public boolean canBeCollidedWith() {
        return false; // No collision
    }

    @Override
    public boolean isPushable() {
        return false; // Not pushable
    }
    @Override
    public boolean skipAttackInteraction(Entity entity) {
        return true; // No interactions
    }
    @Override
    public void playerTouch(Player player) {
        // Do nothing
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }
    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }
    @Override
    public void move(MoverType type, Vec3 pos) {
        if (type == MoverType.PISTON || type == MoverType.SELF) {
            super.move(type, pos);
        }
    }
    /*      ANIMATIONS      */
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
            this.idleAnimationTimeout = 20; // Length in ticks of idle anim
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
}
