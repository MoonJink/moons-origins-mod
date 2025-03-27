package net.moonjink.moonsoriginsmod.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.moonjink.moonsoriginsmod.effect.ModEffects;
import net.moonjink.moonsoriginsmod.item.ModItems;

public class MakeshiftAntipsychoticItem extends MedicationItem {
    public MakeshiftAntipsychoticItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    protected void applyPotionEffect(LivingEntity pEntityLiving) {
        MobEffect effect = ModEffects.ANTIPSYCHOTIC_MEDICATED.get();
        int duration = 1200;
        int amplifier = 0;

        pEntityLiving.addEffect(new net.minecraft.world.effect.MobEffectInstance(effect, duration, amplifier));
    }
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        super.finishUsingItem(pStack, pLevel, pEntityLiving);
        if (pStack.isEmpty()) {
            return new ItemStack(Items.BOWL);
        } else {
            if (pEntityLiving instanceof Player && !((Player)pEntityLiving).getAbilities().instabuild) {
                ItemStack $$4 = new ItemStack(Items.BOWL);
                Player $$5 = (Player)pEntityLiving;
                if (!$$5.getInventory().add($$4)) {
                    $$5.drop($$4, false);
                }
            }

            return pStack;
        }
    }

    public int getUseDuration(ItemStack pStack) {
        return 60;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }
}
