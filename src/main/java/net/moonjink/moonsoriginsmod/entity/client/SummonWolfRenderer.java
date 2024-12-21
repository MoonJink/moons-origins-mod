package net.moonjink.moonsoriginsmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.SummonWolfEntity;
import org.jetbrains.annotations.NotNull;

public class SummonWolfRenderer extends MobRenderer<SummonWolfEntity, SummonWolfModel<SummonWolfEntity>> {
    public SummonWolfRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SummonWolfModel<>(pContext.bakeLayer(ModModelLayers.SUMMON_WOLF_LAYER)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SummonWolfEntity summonWolfEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/summon_wolf.png");
    }

    @Override
    public void render(@NotNull SummonWolfEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(1F, 1F, 1F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
