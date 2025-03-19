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

    public static final RegistryObject<MobEffect> MEDICATED = MOB_EFFECTS.register("medicated",
            () -> new MedicatedEffect(MobEffectCategory.NEUTRAL, 0));

    public static final RegistryObject<MobEffect> MANIC = MOB_EFFECTS.register("manic",
            () -> new ManicEffect(MobEffectCategory.NEUTRAL, 0));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
