package net.moonjink.moonsoriginsmod.entity.custom.sigils;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class CaregiverHealSigilEntity extends SpinningFadedSigilEntity {
    public CaregiverHealSigilEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.lifespanSigil = 20;
    }
}
