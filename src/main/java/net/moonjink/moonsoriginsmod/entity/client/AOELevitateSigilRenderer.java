package net.moonjink.moonsoriginsmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.AOELevitateSigilEntity;
import org.jetbrains.annotations.NotNull;

public class AOELevitateSigilRenderer extends MobRenderer<AOELevitateSigilEntity, AOELevitateSigilModel<AOELevitateSigilEntity>> {
    public AOELevitateSigilRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AOELevitateSigilModel<>(pContext.bakeLayer(ModModelLayers.AOE_LEVITATE_LAYER)), 0f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AOELevitateSigilEntity aoeLevitateSigilEntity) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/aoe_levitate_sigil_wide.png");
    }

    @Override
    public void render(@NotNull AOELevitateSigilEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight) {
        // Scale of creature, effects hitbox size too
        pPoseStack.scale(3F, 3F, 3F);
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
