package net.moonjink.moonsoriginsmod.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.HallucinationModelWide;
import net.moonjink.moonsoriginsmod.entity.custom.hallucinations.HallucinationEntityWide;
import org.jetbrains.annotations.NotNull;

public class HallucinationRendererWide extends MobRenderer<HallucinationEntityWide, HallucinationModelWide<HallucinationEntityWide>> {

    public HallucinationRendererWide(EntityRendererProvider.Context pContext) {
        super(pContext, new HallucinationModelWide<>(pContext.bakeLayer(ModModelLayers.HALLUCINATION_LAYER_WIDE)), 0.5f);
    }

    public @NotNull ResourceLocation getTextureLocation(HallucinationEntityWide pEntity) {
        return pEntity.getSkinTexture();
    }

    protected RenderType getRenderType(@NotNull HallucinationEntityWide pEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(pEntity.getSkinTexture());
    }

    public void render(@NotNull HallucinationEntityWide pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(0.94F, 0.94F, 0.94F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

}
