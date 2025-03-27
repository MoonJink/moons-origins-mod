package net.moonjink.moonsoriginsmod.entity.client.renderers.sigils;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.sigils.HealSigilModel;
import net.moonjink.moonsoriginsmod.entity.custom.sigils.HealSigilEntity;
import org.jetbrains.annotations.NotNull;

public class HealSigilRenderer extends MobRenderer<HealSigilEntity, HealSigilModel<HealSigilEntity>> {
    public HealSigilRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new HealSigilModel<>(pContext.bakeLayer(ModModelLayers.HEAL_LAYER)), 0f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull HealSigilEntity aoeLevitateSigilEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/heal_sigil_wide.png");
    }

    @Override
    public void render(@NotNull HealSigilEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(1F, 1F, 1F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
