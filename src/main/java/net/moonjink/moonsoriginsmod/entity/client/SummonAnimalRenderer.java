package net.moonjink.moonsoriginsmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.custom.SummonAnimalEntity;
import org.jetbrains.annotations.Nullable;

public class SummonAnimalRenderer extends MobRenderer<SummonAnimalEntity, SummonAnimalModel<SummonAnimalEntity>> {
    private static final ResourceLocation summon_animal_texture = new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/summon_animal.png");

    public SummonAnimalRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SummonAnimalModel<>(pContext.bakeLayer(ModModelLayers.SUMMON_ANIMAL_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SummonAnimalEntity summonAnimalEntity) {
        return summon_animal_texture;
    }

    @Override
    protected RenderType getRenderType(SummonAnimalEntity summonAnimalEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(summon_animal_texture);
    }
}
