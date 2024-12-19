package net.moonjink.moonsoriginsmod.item.client;

import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.item.custom.LichGauntletShadowItem;
import software.bernie.geckolib.model.GeoModel;

public class LichGauntletShadowModel extends GeoModel<LichGauntletShadowItem> {
    @Override
    public ResourceLocation getModelResource(LichGauntletShadowItem lichGauntletShadowItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "geo/lich_gauntlet_shadow.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LichGauntletShadowItem lichGauntletShadowItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/item/lich_gauntlet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LichGauntletShadowItem lichGauntletShadowItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "animations/lich_gauntlet.animation.json");
    }
}
