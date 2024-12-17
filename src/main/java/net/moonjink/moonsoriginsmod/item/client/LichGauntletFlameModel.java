package net.moonjink.moonsoriginsmod.item.client;

import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.item.custom.LichGauntletFlameItem;
import software.bernie.geckolib.model.GeoModel;

public class LichGauntletFlameModel extends GeoModel<LichGauntletFlameItem> {
    @Override
    public ResourceLocation getModelResource(LichGauntletFlameItem lichGauntletFlameItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "geo/lich_gauntlet_flame.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LichGauntletFlameItem lichGauntletFlameItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/item/lich_gauntlet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LichGauntletFlameItem lichGauntletFlameItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "animations/lich_gauntlet.animation.json");
    }
}
