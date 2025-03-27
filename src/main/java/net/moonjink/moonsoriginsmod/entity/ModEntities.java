package net.moonjink.moonsoriginsmod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.*;
import net.moonjink.moonsoriginsmod.entity.custom.hallucinations.HallucinationEntitySlim;
import net.moonjink.moonsoriginsmod.entity.custom.hallucinations.HallucinationEntityWide;
import net.moonjink.moonsoriginsmod.entity.custom.hallucinations.HallucinationShadowPerson;
import net.moonjink.moonsoriginsmod.entity.custom.lich_summons.LichLargeSummonedSkeletonEntity;
import net.moonjink.moonsoriginsmod.entity.custom.lich_summons.LichSummonedSkeletonEntity;
import net.moonjink.moonsoriginsmod.entity.custom.lich_summons.PermanentLichSummonedSkeletonEntity;
import net.moonjink.moonsoriginsmod.entity.custom.sigils.*;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Moonsoriginsmod.MOD_ID);

    public static final RegistryObject<EntityType<LichSummonedSkeletonEntity>> LICH_SUMMONED_SKELETON =
            ENTITY_TYPES.register("lich_summoned_skeleton", () -> EntityType.Builder.of(LichSummonedSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 2.4f).build("lich_summoned_skeleton"));

    public static final RegistryObject<EntityType<LichLargeSummonedSkeletonEntity>> LICH_LARGE_SUMMONED_SKELETON =
            ENTITY_TYPES.register("lich_large_summoned_skeleton", () -> EntityType.Builder.of(LichLargeSummonedSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(1.9f, 1.9f).build("lich_large_summoned_skeleton"));

    public static final RegistryObject<EntityType<PermanentLichSummonedSkeletonEntity>> PERMANENT_LICH_SUMMONED_SKELETON =
            ENTITY_TYPES.register("permanent_lich_summoned_skeleton", () -> EntityType.Builder.of(PermanentLichSummonedSkeletonEntity::new, MobCategory.MONSTER)
                    .sized(0.625f, 2.5f).build("permanent_lich_summoned_skeleton"));

    public static final RegistryObject<EntityType<SummonWolfEntity>> SUMMON_WOLF =
            ENTITY_TYPES.register("summon_wolf", () -> EntityType.Builder.of(SummonWolfEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 0.85f).build("summon_wolf"));

    public static final RegistryObject<EntityType<SummonAnimalEntity>> SUMMON_ANIMAL =
            ENTITY_TYPES.register("summon_animal", () -> EntityType.Builder.of(SummonAnimalEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 1f).build("summon_animal"));

    public static final RegistryObject<EntityType<DelayedTeleportSigilEntity>> DELAYED_TELEPORT_SIGIL =
            ENTITY_TYPES.register("delayed_teleport_sigil", () -> EntityType.Builder.of(DelayedTeleportSigilEntity::new, MobCategory.MISC)
                    .sized(2f, 0.1f).build("delayed_teleport_sigil"));

    public static final RegistryObject<EntityType<AOELevitateSigilEntity>> AOE_LEVITATE_SIGIL =
            ENTITY_TYPES.register("aoe_levitate_sigil", () -> EntityType.Builder.of(AOELevitateSigilEntity::new, MobCategory.MISC)
                    .sized(12f, 0.05f).build("aoe_levitate_sigil"));

    public static final RegistryObject<EntityType<CaregiverHealSigilEntity>> CAREGIVER_HEAL_SIGIL =
            ENTITY_TYPES.register("caregiver_heal_sigil", () -> EntityType.Builder.of(CaregiverHealSigilEntity::new, MobCategory.MISC)
                    .sized(30f, 0.05f).build("caregiver_heal_sigil"));

    public static final RegistryObject<EntityType<HealSigilEntity>> HEAL_SIGIL =
            ENTITY_TYPES.register("heal_sigil", () -> EntityType.Builder.of(HealSigilEntity::new, MobCategory.MISC)
                    .sized(2f, 0.01f).build("heal_sigil"));

    public static final RegistryObject<EntityType<PullSigilEntity>> PULL_SIGIL =
            ENTITY_TYPES.register("pull_sigil", () -> EntityType.Builder.of(PullSigilEntity::new, MobCategory.MISC)
                    .sized(2f, 0.01f).build("pull_sigil"));

    public static final RegistryObject<EntityType<CustomPlayerEntity>> CUSTOM_PLAYER_ENTITY =
            ENTITY_TYPES.register("custom_player_entity", () -> EntityType.Builder.of(CustomPlayerEntity::new, MobCategory.MISC)
                    .sized(0.25f, 1f).build("custom_player_entity"));

    public static final RegistryObject<EntityType<HallucinationEntityWide>> HALLUCINATION_ENTITY_WIDE =
            ENTITY_TYPES.register("hallucination_entity_wide", () -> EntityType.Builder.of(HallucinationEntityWide::new, MobCategory.MISC)
                    .sized(0.6f, 1.9f).build("hallucination_entity_wide"));

    public static final RegistryObject<EntityType<HallucinationEntitySlim>> HALLUCINATION_ENTITY_SLIM =
            ENTITY_TYPES.register("hallucination_entity_slim", () -> EntityType.Builder.of(HallucinationEntitySlim::new, MobCategory.MISC)
                    .sized(0.6f, 1.9f).build("hallucination_entity_slim"));

    public static final RegistryObject<EntityType<HallucinationShadowPerson>> HALLUCINATION_SHADOW_PERSON =
            ENTITY_TYPES.register("hallucination_shadow_person", () -> EntityType.Builder.of(HallucinationShadowPerson::new, MobCategory.MISC)
                    .sized(0.6f, 4f).build("hallucination_shadow_person"));

    public static final RegistryObject<EntityType<WaterSigilEntity>> WATER_SIGIl_ENTITY =
            ENTITY_TYPES.register("water_sigil_entity", () -> EntityType.Builder.of(WaterSigilEntity::new, MobCategory.MISC)
                    .sized(20f, 0.05f).build("water_sigil_entity"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
