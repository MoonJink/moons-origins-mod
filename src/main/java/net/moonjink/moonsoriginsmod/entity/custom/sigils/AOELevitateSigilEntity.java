package net.moonjink.moonsoriginsmod.entity.custom.sigils;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class AOELevitateSigilEntity extends SpinningFadedSigilEntity {
    public AOELevitateSigilEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.lifespanSigil = 20;
    }
}
