package net.moonjink.moonsoriginsmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.PermanentLichSummonedSkeletonEntity;

public class PermanentLichSummonedSkeletonRenderer extends MobRenderer<PermanentLichSummonedSkeletonEntity, PermanentLichSummonedSkeletonModel<PermanentLichSummonedSkeletonEntity>> {
    public PermanentLichSummonedSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PermanentLichSummonedSkeletonModel<>(pContext.bakeLayer(ModModelLayers.PERMANENT_LICH_SUMMONED_SKELETON_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(PermanentLichSummonedSkeletonEntity permanentLichSummonedSkeletonEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/lich_summoned_skeleton.png");
    }

    @Override
    public void render(PermanentLichSummonedSkeletonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.scale(1.2F, 1.2F, 1.2F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
