package net.moonjink.moonsoriginsmod.item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.moonjink.moonsoriginsmod.effect.ModEffects;

public class AntiDepressantItem extends MedicationItem {
    public AntiDepressantItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected void applyPotionEffect(LivingEntity pEntityLiving) {
        MobEffect effect = ModEffects.MANIC.get();
        int duration = 9000;
        int amplifier = 0;

        pEntityLiving.addEffect(new net.minecraft.world.effect.MobEffectInstance(effect, duration, amplifier));
    }
    @Override
    protected void removeIncompatibleEffect(LivingEntity pEntityLiving) {
        if (pEntityLiving.hasEffect(ModEffects.DEPRESSED.get())) {
            pEntityLiving.removeEffect(ModEffects.DEPRESSED.get());
        }
    }
}
