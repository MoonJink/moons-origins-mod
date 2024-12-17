package net.moonjink.moonsoriginsmod.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.ModEntities;
import net.moonjink.moonsoriginsmod.entity.custom.LichLargeSummonedSkeletonEntity;
import net.moonjink.moonsoriginsmod.entity.custom.LichSummonedSkeletonEntity;
import net.moonjink.moonsoriginsmod.entity.custom.PermanentLichSummonedSkeletonEntity;

@Mod.EventBusSubscriber(modid = Moonsoriginsmod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.LICH_SUMMONED_SKELETON.get(), LichSummonedSkeletonEntity.createAttributes().build());
        event.put(ModEntities.LICH_LARGE_SUMMONED_SKELETON.get(), LichLargeSummonedSkeletonEntity.createAttributes().build());
        event.put(ModEntities.PERMANENT_LICH_SUMMONED_SKELETON.get(), PermanentLichSummonedSkeletonEntity.createAttributes().build());
    }
}
