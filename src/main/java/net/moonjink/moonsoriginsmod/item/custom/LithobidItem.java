package net.moonjink.moonsoriginsmod.item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.moonjink.moonsoriginsmod.effect.ModEffects;

public class LithobidItem extends MedicationItem {
    public LithobidItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected void applyPotionEffect(LivingEntity pEntityLiving) {
        MobEffect effect = ModEffects.LITHOBID_MEDICATED.get();
        int duration = 6000;
        int amplifier = 0;

        pEntityLiving.addEffect(new net.minecraft.world.effect.MobEffectInstance(effect, duration, amplifier));
    }
}
