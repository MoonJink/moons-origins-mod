package net.moonjink.moonsoriginsmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.*;
import net.moonjink.moonsoriginsmod.particle.ModParticles;
import net.moonjink.moonsoriginsmod.particle.custom.*;

@Mod.EventBusSubscriber(modid = Moonsoriginsmod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.LICH_SUMMONED_SKELETON_LAYER, LichSummonedSkeletonModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.LICH_LARGE_SUMMONED_SKELETON_LAYER, LichLargeSummonedSkeletonModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.PERMANENT_LICH_SUMMONED_SKELETON_LAYER, PermanentLichSummonedSkeletonModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.SUMMON_WOLF_LAYER, SummonWolfModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.SUMMON_ANIMAL_LAYER, SummonAnimalModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.CURSE_SIGIL.get(),
                curse_sigil.Provider::new);
        event.registerSpriteSet(ModParticles.HEAl_SIGIL.get(),
                heal_sigil.Provider::new);
        event.registerSpriteSet(ModParticles.SUMMON_SIGIL.get(),
                summon_sigil.Provider::new);
        event.registerSpriteSet(ModParticles.AOE_LEVITATE_SIGIL.get(),
                aoe_levitate_sigil.Provider::new);
        event.registerSpriteSet(ModParticles.DELAYED_TELEPORT_SIGIL.get(),
                delayed_teleport_sigil.Provider::new);
    }
}
