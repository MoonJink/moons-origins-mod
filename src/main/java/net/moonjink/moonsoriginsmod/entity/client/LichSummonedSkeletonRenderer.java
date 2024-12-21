package net.moonjink.moonsoriginsmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.LichSummonedSkeletonEntity;
import org.jetbrains.annotations.NotNull;

public class LichSummonedSkeletonRenderer extends MobRenderer<LichSummonedSkeletonEntity, LichSummonedSkeletonModel<LichSummonedSkeletonEntity>> {
    public LichSummonedSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LichSummonedSkeletonModel<>(pContext.bakeLayer(ModModelLayers.LICH_SUMMONED_SKELETON_LAYER)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LichSummonedSkeletonEntity lichSummonedSkeletonEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/lich_summoned_skeleton.png");
    }

    @Override
    public void render(@NotNull LichSummonedSkeletonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(1.2F, 1.2F, 1.2F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
