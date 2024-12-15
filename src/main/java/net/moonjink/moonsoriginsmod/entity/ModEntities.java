package net.moonjink.moonsoriginsmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.LichLargeSummonedSkeletonEntity;
import net.moonjink.moonsoriginsmod.entity.custom.LichSummonedSkeletonEntity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Moonsoriginsmod.MOD_ID);

    public static final RegistryObject<EntityType<LichSummonedSkeletonEntity>> LICH_SUMMONED_SKELETON =
            ENTITY_TYPES.register("lich_summoned_skeleton", () -> EntityType.Builder.of(LichSummonedSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.5f, 2f).build("lich_summoned_skeleton"));

    public static final RegistryObject<EntityType<LichLargeSummonedSkeletonEntity>> LICH_LARGE_SUMMONED_SKELETON =
            ENTITY_TYPES.register("lich_large_summoned_skeleton", () -> EntityType.Builder.of(LichLargeSummonedSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(2f, 2f).build("lich_large_summoned_skeleton"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
