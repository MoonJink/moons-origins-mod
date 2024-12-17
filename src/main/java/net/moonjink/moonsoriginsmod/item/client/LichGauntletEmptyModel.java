package net.moonjink.moonsoriginsmod.item.client;

import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.item.custom.LichGauntletEmptyItem;
import software.bernie.geckolib.model.GeoModel;

public class LichGauntletEmptyModel extends GeoModel<LichGauntletEmptyItem> {
    @Override
    public ResourceLocation getModelResource(LichGauntletEmptyItem lichGauntletEmptyItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "geo/lich_gauntlet_empty.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LichGauntletEmptyItem lichGauntletEmptyItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/item/lich_gauntlet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LichGauntletEmptyItem lichGauntletEmptyItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "animations/lich_gauntlet.animation.json");
    }
}
