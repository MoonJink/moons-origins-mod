package net.moonjink.moonsoriginsmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Moonsoriginsmod.MOD_ID);

    public static final RegistryObject<MobEffect> ANTIPSYCHOTIC_MEDICATED = MOB_EFFECTS.register("antipsychotic_medicated",
            () -> new AntipsychoticMedicatedEffect(MobEffectCategory.NEUTRAL, 0));

    public static final RegistryObject<MobEffect> LITHOBID_MEDICATED = MOB_EFFECTS.register("lithobid_medicated",
            () -> new LithobidMedicatedEffect(MobEffectCategory.NEUTRAL, 0));

    public static final RegistryObject<MobEffect> MANIC = MOB_EFFECTS.register("manic",
            () -> new ManicEffect(MobEffectCategory.NEUTRAL, 0));

    public static final RegistryObject<MobEffect> DEPRESSED = MOB_EFFECTS.register("depressed",
            () -> new DepressedEffect(MobEffectCategory.NEUTRAL, 3100384));

    public static final RegistryObject<MobEffect> SANITY_GAIN = MOB_EFFECTS.register("sanity_gain",
            () -> new SanityGainEffect(MobEffectCategory.NEUTRAL, 0));

    public static final RegistryObject<MobEffect> SANITY_LOSS = MOB_EFFECTS.register("sanity_loss",
            () -> new SanityLossEffect(MobEffectCategory.NEUTRAL, 0));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
