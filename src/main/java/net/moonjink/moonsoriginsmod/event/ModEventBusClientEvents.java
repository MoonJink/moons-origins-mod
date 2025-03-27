package net.moonjink.moonsoriginsmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.*;
import net.moonjink.moonsoriginsmod.entity.client.models.*;
import net.moonjink.moonsoriginsmod.entity.client.models.sigils.*;
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

        event.registerLayerDefinition(ModModelLayers.DELAYED_TELEPORT_SIGIL_LAYER, DelayedTeleportSigilModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.AOE_LEVITATE_LAYER, AOELevitateSigilModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.CAREGIVER_HEAL_SIGIL_LAYER, CaregiverHealSigilModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.WATER_SIGIL_LAYER, WaterSigilModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.HEAL_LAYER, HealSigilModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.PULL_LAYER, PullSigilModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.CUSTOM_PLAYER_ENTITY_LAYER, CustomPlayerEntityModel::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.HALLUCINATION_LAYER_WIDE, HallucinationModelWide::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.HALLUCINATION_LAYER_SLIM, HallucinationModelSlim::createBodyLayer);

        event.registerLayerDefinition(ModModelLayers.HALLUCINATION_SHADOW_PERSON_LAYER, HallucinationShadowPersonModel::createBodyLayer);
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

        event.registerSpriteSet(ModParticles.PULL_SIGIL.get(),
                pull_sigil.Provider::new);

        event.registerSpriteSet(ModParticles.SHROUD_SIGIL.get(),
                shroud_sigil.Provider::new);

        event.registerSpriteSet(ModParticles.WATER_AURA_PARTICLE.get(),
                water_aura_particle.Provider::new);
    }
}
