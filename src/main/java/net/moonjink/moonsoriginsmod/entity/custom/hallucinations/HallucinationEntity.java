package net.moonjink.moonsoriginsmod.entity.custom.hallucinations;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;
import net.moonjink.moonsoriginsmod.entity.ai.HallucinationFollowGoal;
import net.moonjink.moonsoriginsmod.entity.ai.HallucinationWaterAvoidingRandomStrollGoal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HallucinationEntity extends TamableAnimal {
    private int playerNearbyTicks = 0;

    public HallucinationEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        ((GroundPathNavigation)this.getNavigation()).canOpenDoors();
        this.lifespan = 20 * 25;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return TamableAnimal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.FOLLOW_RANGE, 50)
                .add(Attributes.ATTACK_DAMAGE, 0)
                .add(Attributes.ATTACK_KNOCKBACK, 0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100)
                .add(Attributes.ARMOR, 0)
                .add(Attributes.ARMOR_TOUGHNESS, 0)
                .add(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 50, 100));
        this.goalSelector.addGoal(0, new HallucinationFollowGoal(this, 1.2, 15, 0, false));
        this.goalSelector.addGoal(1, new HallucinationWaterAvoidingRandomStrollGoal(this, 1.0, 100));
        this.goalSelector.addGoal(3, new FloatGoal(this));
    }

    /*      ANIMATIONS & LIFESPAN       */
    private int lifespan; // Creates lifespan -> look at super class for setting the value

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
            lifespan--;

            if (lifespan <= 0) {
                this.discard();
            }
        }

        // Removes entity when colliding
        boolean playerNearby = false;
        for (Player player : this.level().players()) {
            if (player.distanceTo(this) < 1.5) { // Distance from a player
                playerNearby = true;
                break;
            }
        }

        if (playerNearby) {
            playerNearbyTicks++; // Increment counter if a player is close
        } else {
            playerNearbyTicks = 0; // Reset if no player is within range
        }
        if (playerNearbyTicks >= 5 /* Ticks for total time before discard*/ && !this.level().isClientSide) {
            this.discard();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 60; // Length in ticks of anim;
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

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();
        if (itemstack.is(Items.BONE)) {
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            if (this.random.nextInt(1) == 0 && !ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                this.tame(pPlayer);
                this.setTarget((LivingEntity)null);
            }
            return InteractionResult.SUCCESS;
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }


    /*      DAMAGE IMMUNITIES & ENTITY REMOVAL       */
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
    @Override
    public boolean isPickable() {
        return false; // Prevents anything from interacting with the entity
    }
}
