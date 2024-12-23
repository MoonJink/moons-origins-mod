package net.moonjink.moonsoriginsmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.PullSigilEntity;
import org.jetbrains.annotations.NotNull;

public class PullSigilRenderer extends MobRenderer<PullSigilEntity, PullSigilModel<PullSigilEntity>> {
    public PullSigilRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PullSigilModel<>(pContext.bakeLayer(ModModelLayers.PULL_LAYER)), 0f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PullSigilEntity pullSigilEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/pull_sigil_wide.png");
    }

    @Override
    public void render(@NotNull PullSigilEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(3F, 3F, 3F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
