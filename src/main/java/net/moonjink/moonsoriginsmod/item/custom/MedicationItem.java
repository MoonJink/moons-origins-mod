package net.moonjink.moonsoriginsmod.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.moonjink.moonsoriginsmod.effect.ModEffects;
import net.moonjink.moonsoriginsmod.item.ModItems;

public class MedicationItem extends Item {
    public MedicationItem(Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        super.finishUsingItem(pStack, pLevel, pEntityLiving);

        if (pEntityLiving instanceof ServerPlayer $$3) {
            CriteriaTriggers.CONSUME_ITEM.trigger($$3, pStack);
            $$3.awardStat(Stats.ITEM_USED.get(this));
            applyPotionEffect(pEntityLiving);
        }

        if (pStack.isEmpty()) {
            return new ItemStack(ModItems.EMPTY_PILL_BOTTLE.get());
        } else {
            if (pEntityLiving instanceof Player && !((Player)pEntityLiving).getAbilities().instabuild) {
                ItemStack $$4 = new ItemStack(ModItems.EMPTY_PILL_BOTTLE.get());
                Player $$5 = (Player)pEntityLiving;
                if (!$$5.getInventory().add($$4)) {
                    $$5.drop($$4, false);
                }
            }

            return pStack;
        }
    }


    private void applyPotionEffect(LivingEntity entity) {
        MobEffect effect = ModEffects.MEDICATED.get();
        int duration = 12000;
        int amplifier = 0;

        entity.addEffect(new net.minecraft.world.effect.MobEffectInstance(effect, duration, amplifier));
    }

    public int getUseDuration(ItemStack pStack) {
        return 40;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }
}
