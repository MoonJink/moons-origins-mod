package net.moonjink.moonsoriginsmod.item.client;

import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.item.custom.LichGauntletFullItem;
import software.bernie.geckolib.model.GeoModel;

public class LichGauntletFullModel extends GeoModel<LichGauntletFullItem> {
    @Override
    public ResourceLocation getModelResource(LichGauntletFullItem lichGauntletFullItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "geo/lich_gauntlet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LichGauntletFullItem lichGauntletFullItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/item/lich_gauntlet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LichGauntletFullItem lichGauntletFullItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "animations/lich_gauntlet.animation.json");
    }
}
