package net.moonjink.moonsoriginsmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.*;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Moonsoriginsmod.MOD_ID);

    public static final RegistryObject<EntityType<LichSummonedSkeletonEntity>> LICH_SUMMONED_SKELETON =
            ENTITY_TYPES.register("lich_summoned_skeleton", () -> EntityType.Builder.of(LichSummonedSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.5f, 2f).build("lich_summoned_skeleton"));

    public static final RegistryObject<EntityType<LichLargeSummonedSkeletonEntity>> LICH_LARGE_SUMMONED_SKELETON =
            ENTITY_TYPES.register("lich_large_summoned_skeleton", () -> EntityType.Builder.of(LichLargeSummonedSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(1.9f, 1.9f).build("lich_large_summoned_skeleton"));

    public static final RegistryObject<EntityType<PermanentLichSummonedSkeletonEntity>> PERMANENT_LICH_SUMMONED_SKELETON =
            ENTITY_TYPES.register("permanent_lich_summoned_skeleton", () -> EntityType.Builder.of(PermanentLichSummonedSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.5f, 2f).build("permanent_lich_summoned_skeleton"));

    public static final RegistryObject<EntityType<SummonWolfEntity>> SUMMON_WOLF =
            ENTITY_TYPES.register("summon_wolf", () -> EntityType.Builder.of(SummonWolfEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 0.85f).build("summon_wolf"));

    public static final RegistryObject<EntityType<SummonAnimalEntity>> SUMMON_ANIMAL =
            ENTITY_TYPES.register("summon_animal", () -> EntityType.Builder.of(SummonAnimalEntity::new, MobCategory.MONSTER)
                    .sized(0.7f, 0.6f).build("summon_animal"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
