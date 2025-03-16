package net.moonjink.moonsoriginsmod.entity.client.renderers;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.entity.client.ModModelLayers;
import net.moonjink.moonsoriginsmod.entity.client.models.SummonAnimalModel;
import net.moonjink.moonsoriginsmod.entity.custom.SummonAnimalEntity;
import org.jetbrains.annotations.NotNull;

public class SummonAnimalRenderer extends MobRenderer<SummonAnimalEntity, SummonAnimalModel<SummonAnimalEntity>> {
    private static final ResourceLocation summon_animal_texture = new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/summon_animal.png");

    public SummonAnimalRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SummonAnimalModel<>(pContext.bakeLayer(ModModelLayers.SUMMON_ANIMAL_LAYER)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull SummonAnimalEntity summonAnimalEntity) {
        return summon_animal_texture;
    }

    @Override
    protected RenderType getRenderType(@NotNull SummonAnimalEntity summonAnimalEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(summon_animal_texture);
    }
}
