package net.moonjink.moonsoriginsmod.item.client;

import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.item.custom.LichGauntletSoulItem;
import software.bernie.geckolib.model.GeoModel;

public class LichGauntletSoulModel extends GeoModel<LichGauntletSoulItem> {
    @Override
    public ResourceLocation getModelResource(LichGauntletSoulItem lichGauntletSoulItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "geo/lich_gauntlet_soul.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LichGauntletSoulItem lichGauntletSoulItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/item/lich_gauntlet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LichGauntletSoulItem lichGauntletSoulItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "animations/lich_gauntlet.animation.json");
    }
}
