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
import net.moonjink.moonsoriginsmod.entity.ModEntities;
import net.moonjink.moonsoriginsmod.entity.client.*;
import net.moonjink.moonsoriginsmod.item.ModItems;
import net.moonjink.moonsoriginsmod.particle.ModParticles;
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
        }
    }
}
