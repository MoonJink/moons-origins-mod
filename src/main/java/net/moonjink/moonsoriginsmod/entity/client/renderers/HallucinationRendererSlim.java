package net.moonjink.moonsoriginsmod.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.HallucinationModelSlim;
import net.moonjink.moonsoriginsmod.entity.custom.hallucinations.HallucinationEntitySlim;
import org.jetbrains.annotations.NotNull;

public class HallucinationRendererSlim extends MobRenderer<HallucinationEntitySlim, HallucinationModelSlim<HallucinationEntitySlim>> {

    public HallucinationRendererSlim(EntityRendererProvider.Context pContext) {
        super(pContext, new HallucinationModelSlim<>(pContext.bakeLayer(ModModelLayers.HALLUCINATION_LAYER_SLIM)), 0.5f);
    }

    public ResourceLocation getTextureLocation(HallucinationEntitySlim pEntity) {
        return pEntity.getSkinTexture();
    }

    protected RenderType getRenderType(@NotNull HallucinationEntitySlim pEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(pEntity.getSkinTexture());
    }

    public void render(@NotNull HallucinationEntitySlim pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(0.94F, 0.94F, 0.94F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
