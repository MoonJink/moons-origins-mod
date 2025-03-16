package net.moonjink.moonsoriginsmod.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.CustomPlayerEntityModel;
import net.moonjink.moonsoriginsmod.entity.custom.CustomPlayerEntity;
import org.jetbrains.annotations.NotNull;

public class CustomPlayerEntityRenderer extends MobRenderer<CustomPlayerEntity, CustomPlayerEntityModel<CustomPlayerEntity>> {
    public CustomPlayerEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CustomPlayerEntityModel<>(pContext.bakeLayer(ModModelLayers.CUSTOM_PLAYER_ENTITY_LAYER)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull CustomPlayerEntity customPlayerEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/custom_player_entity.png");
    }

    @Override
    public void render(@NotNull CustomPlayerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(0.5F, 0.5F, 0.5F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
