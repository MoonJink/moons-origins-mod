package net.moonjink.moonsoriginsmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.DelayedTeleportSigilEntity;
import org.jetbrains.annotations.NotNull;

public class DelayedTeleportSigilRenderer extends MobRenderer<DelayedTeleportSigilEntity, DelayedTeleportSigilModel<DelayedTeleportSigilEntity>> {
    public DelayedTeleportSigilRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DelayedTeleportSigilModel<>(pContext.bakeLayer(ModModelLayers.DELAYED_TELEPORT_SIGIL_LAYER)), 0f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull DelayedTeleportSigilEntity delayedTeleportSigilEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/delayed_teleport_sigil_wide.png");
    }

    @Override
    public void render(@NotNull DelayedTeleportSigilEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(0.5F, 0.5F, 0.5F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
