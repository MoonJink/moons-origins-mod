package net.moonjink.moonsoriginsmod.entity.ai;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class HallucinationWaterAvoidingRandomStrollGoal extends WaterAvoidingRandomStrollGoal {
    public static final float PROBABILITY = 100F;
    protected final float probability;

    public HallucinationWaterAvoidingRandomStrollGoal(PathfinderMob pMob, double pSpeedModifier) {
        this(pMob, pSpeedModifier, 100F);
    }

    public HallucinationWaterAvoidingRandomStrollGoal(PathfinderMob pMob, double pSpeedModifier, float pProbability) {
        super(pMob, pSpeedModifier);
        this.probability = pProbability;
    }

    @Nullable
    protected Vec3 getPosition() {
        if (this.mob.isInWaterOrBubble()) {
            Vec3 $$0 = LandRandomPos.getPos(this.mob, 20, 5);
            return $$0 == null ? super.getPosition() : $$0;
        } else {
            return this.mob.getRandom().nextFloat() >= this.probability ? LandRandomPos.getPos(this.mob, 6, 3) : super.getPosition();
        }
    }
}
