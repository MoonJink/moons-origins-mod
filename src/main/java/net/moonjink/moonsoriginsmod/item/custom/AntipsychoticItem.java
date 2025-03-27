package net.moonjink.moonsoriginsmod.item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.moonjink.moonsoriginsmod.effect.ModEffects;

public class AntipsychoticItem extends MedicationItem {
    public AntipsychoticItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    protected void applyPotionEffect(LivingEntity pEntityLiving) {
        MobEffect effect = ModEffects.ANTIPSYCHOTIC_MEDICATED.get();
        int duration = 9000;
        int amplifier = 0;

        pEntityLiving.addEffect(new net.minecraft.world.effect.MobEffectInstance(effect, duration, amplifier));
    }
}
