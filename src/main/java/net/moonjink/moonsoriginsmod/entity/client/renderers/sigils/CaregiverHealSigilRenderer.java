package net.moonjink.moonsoriginsmod.entity.client.renderers.sigils;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.sigils.CaregiverHealSigilModel;
import net.moonjink.moonsoriginsmod.entity.custom.sigils.CaregiverHealSigilEntity;
import org.jetbrains.annotations.NotNull;

public class CaregiverHealSigilRenderer extends MobRenderer<CaregiverHealSigilEntity, CaregiverHealSigilModel<CaregiverHealSigilEntity>> {
    public CaregiverHealSigilRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CaregiverHealSigilModel<>(pContext.bakeLayer(ModModelLayers.CAREGIVER_HEAL_SIGIL_LAYER)), 0f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull CaregiverHealSigilEntity pEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/caregiver_heal_sigil.png");
    }

    @Override
    public void render(@NotNull CaregiverHealSigilEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(7.5F, 7.5F, 7.5F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
