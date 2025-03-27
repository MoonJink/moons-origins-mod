package net.moonjink.moonsoriginsmod.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.PermanentLichSummonedSkeletonModel;
import net.moonjink.moonsoriginsmod.entity.custom.lich_summons.PermanentLichSummonedSkeletonEntity;
import org.jetbrains.annotations.NotNull;

public class PermanentLichSummonedSkeletonRenderer extends MobRenderer<PermanentLichSummonedSkeletonEntity, PermanentLichSummonedSkeletonModel<PermanentLichSummonedSkeletonEntity>> {
    public PermanentLichSummonedSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PermanentLichSummonedSkeletonModel<>(pContext.bakeLayer(ModModelLayers.PERMANENT_LICH_SUMMONED_SKELETON_LAYER)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PermanentLichSummonedSkeletonEntity permanentLichSummonedSkeletonEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/permanent_lich_summoned_skeleton.png");
    }

    @Override
    public void render(@NotNull PermanentLichSummonedSkeletonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(1.25F, 1.25F, 1.25F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
