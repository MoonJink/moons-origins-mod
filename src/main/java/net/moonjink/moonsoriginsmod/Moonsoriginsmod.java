package net.moonjink.moonsoriginsmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.moonjink.moonsoriginsmod.effect.ModEffects;
import net.moonjink.moonsoriginsmod.entity.ModEntities;
import net.moonjink.moonsoriginsmod.entity.client.renderers.*;
import net.moonjink.moonsoriginsmod.item.ModItems;
import net.moonjink.moonsoriginsmod.particle.ModParticles;
import net.moonjink.moonsoriginsmod.sound.ModSounds;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Moonsoriginsmod.MOD_ID)
public class Moonsoriginsmod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "moonsoriginsmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public Moonsoriginsmod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModParticles.register(modEventBus);

        ModEntities.register(modEventBus);

        ModEffects.register(modEventBus);

        ModSounds.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        GeckoLib.initialize();
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.LICH_GAUNTLET);
            event.accept(ModItems.LICH_GAUNTLET_EMPTY);
            event.accept(ModItems.LICH_GAUNTLET_SHADOW);
            event.accept(ModItems.LICH_GAUNTLET_SOUL);
            event.accept(ModItems.VAMPIRE_DAGGER);
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.EMPTY_BLOOD_VIAL);
            event.accept(ModItems.LESSER_BLOOD_VIAL);
            event.accept(ModItems.GREATER_BLOOD_VIAL);
            event.accept(ModItems.ANTIPSYCHOTICS);
            event.accept(ModItems.ANTIDEPRESSANTS);
            event.accept(ModItems.LITHOBID);
            event.accept(ModItems.EMPTY_PILL_BOTTLE);
        }
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ARCANE_CRYSTAL);
            event.accept(ModItems.SHADOW_CRYSTAL);
            event.accept(ModItems.SOUL_CRYSTAL);
            event.accept(ModItems.WATER_CRYSTAL);
            event.accept(ModItems.LICH_BORNE_IRON);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.LICH_SUMMONED_SKELETON.get(), LichSummonedSkeletonRenderer::new);
            EntityRenderers.register(ModEntities.LICH_LARGE_SUMMONED_SKELETON.get(), LichLargeSummonedSkeletonRenderer::new);
            EntityRenderers.register(ModEntities.PERMANENT_LICH_SUMMONED_SKELETON.get(), PermanentLichSummonedSkeletonRenderer::new);
            EntityRenderers.register(ModEntities.SUMMON_WOLF.get(), SummonWolfRenderer::new);
            EntityRenderers.register(ModEntities.SUMMON_ANIMAL.get(), SummonAnimalRenderer::new);
            EntityRenderers.register(ModEntities.DELAYED_TELEPORT_SIGIL.get(), DelayedTeleportSigilRenderer::new);
            EntityRenderers.register(ModEntities.AOE_LEVITATE_SIGIL.get(), AOELevitateSigilRenderer::new);
            EntityRenderers.register(ModEntities.HEAL_SIGIL.get(), HealSigilRenderer::new);
            EntityRenderers.register(ModEntities.PULL_SIGIL.get(), PullSigilRenderer::new);
            EntityRenderers.register(ModEntities.CUSTOM_PLAYER_ENTITY.get(), CustomPlayerEntityRenderer::new);
            EntityRenderers.register(ModEntities.HALLUCINATION_ENTITY_WIDE.get(), HallucinationRendererWide::new);
            EntityRenderers.register(ModEntities.HALLUCINATION_ENTITY_SLIM.get(), HallucinationRendererSlim::new);
        }
    }
}
