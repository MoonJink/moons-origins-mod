package net.moonjink.moonsoriginsmod.entity.client.renderers.sigils;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.sigils.DelayedTeleportSigilModel;
import net.moonjink.moonsoriginsmod.entity.client.models.sigils.WaterSigilModel;
import net.moonjink.moonsoriginsmod.entity.custom.SummonAnimalEntity;
import net.moonjink.moonsoriginsmod.entity.custom.sigils.DelayedTeleportSigilEntity;
import net.moonjink.moonsoriginsmod.entity.custom.sigils.PullSigilEntity;
import net.moonjink.moonsoriginsmod.entity.custom.sigils.WaterSigilEntity;
import org.jetbrains.annotations.NotNull;

public class WaterSigilRenderer extends MobRenderer<WaterSigilEntity, WaterSigilModel<WaterSigilEntity>> {
    public WaterSigilRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WaterSigilModel<>(pContext.bakeLayer(ModModelLayers.WATER_SIGIL_LAYER)), 0f);
    }

    private static final ResourceLocation texture = new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/water_sigil_wide.png");
    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull WaterSigilEntity pEntity) {
        return texture;
    }

    @Override
    protected RenderType getRenderType(@NotNull WaterSigilEntity pEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(texture);
    }
    public void render(@NotNull WaterSigilEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(2.5F, 2.5F, 2.5F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
