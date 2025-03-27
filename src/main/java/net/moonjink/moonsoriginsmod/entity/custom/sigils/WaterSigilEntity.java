package net.moonjink.moonsoriginsmod.entity.custom.sigils;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class WaterSigilEntity extends SpinningSigilEntity {
    public WaterSigilEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.lifespanSigil = 210;
    }
}
