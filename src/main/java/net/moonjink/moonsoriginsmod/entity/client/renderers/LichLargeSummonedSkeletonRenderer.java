package net.moonjink.moonsoriginsmod.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.LichLargeSummonedSkeletonModel;
import net.moonjink.moonsoriginsmod.entity.custom.lich_summons.LichLargeSummonedSkeletonEntity;
import org.jetbrains.annotations.NotNull;

public class LichLargeSummonedSkeletonRenderer extends MobRenderer<LichLargeSummonedSkeletonEntity, LichLargeSummonedSkeletonModel<LichLargeSummonedSkeletonEntity>> {
    public LichLargeSummonedSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new LichLargeSummonedSkeletonModel<>(pContext.bakeLayer(ModModelLayers.LICH_LARGE_SUMMONED_SKELETON_LAYER)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LichLargeSummonedSkeletonEntity lichLargeSummonedSkeletonEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/lich_large_summoned_skeleton.png");
    }

    @Override
    public void render(@NotNull LichLargeSummonedSkeletonEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(1F, 1F, 1F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
