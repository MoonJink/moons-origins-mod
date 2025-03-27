package net.moonjink.moonsoriginsmod.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Moonsoriginsmod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> CURSE_SIGIL = PARTICLE_TYPES.register("curse_sigil",
            () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> HEAl_SIGIL = PARTICLE_TYPES.register("heal_sigil",
            () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SUMMON_SIGIL = PARTICLE_TYPES.register("summon_sigil",
            () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> AOE_LEVITATE_SIGIL = PARTICLE_TYPES.register("aoe_levitate_sigil",
            () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DELAYED_TELEPORT_SIGIL = PARTICLE_TYPES.register("delayed_teleport_sigil",
            () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> PULL_SIGIL = PARTICLE_TYPES.register("pull_sigil",
            () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> SHROUD_SIGIL = PARTICLE_TYPES.register("shroud_sigil",
            () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> WATER_AURA_PARTICLE = PARTICLE_TYPES.register("water_aura_particle",
            () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
