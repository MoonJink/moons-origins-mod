package net.moonjink.moonsoriginsmod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.*;

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


}
