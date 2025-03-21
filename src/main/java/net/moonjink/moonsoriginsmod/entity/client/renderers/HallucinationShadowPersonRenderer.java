package net.moonjink.moonsoriginsmod.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.HallucinationShadowPersonModel;
import net.moonjink.moonsoriginsmod.entity.client.models.LichSummonedSkeletonModel;
import net.moonjink.moonsoriginsmod.entity.custom.HallucinationShadowPerson;
import net.moonjink.moonsoriginsmod.entity.custom.LichSummonedSkeletonEntity;
import org.jetbrains.annotations.NotNull;

public class HallucinationShadowPersonRenderer extends MobRenderer<HallucinationShadowPerson, HallucinationShadowPersonModel<HallucinationShadowPerson>> {
    public HallucinationShadowPersonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HallucinationShadowPersonModel<>(pContext.bakeLayer(ModModelLayers.HALLUCINATION_SHADOW_PERSON_LAYER)), 0.25f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull HallucinationShadowPerson lichSummonedSkeletonEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/shadow_person.png");
    }

    @Override
    public void render(@NotNull HallucinationShadowPerson pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(2F, 2F, 2F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
