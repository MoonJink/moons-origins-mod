package net.moonjink.moonsoriginsmod.item.client;

import net.minecraft.resources.ResourceLocation;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.moonjink.moonsoriginsmod.item.custom.AnimatedItem;
import software.bernie.geckolib.model.GeoModel;

public class AnimatedItemModel extends GeoModel<AnimatedItem> {
    @Override
    public ResourceLocation getModelResource(AnimatedItem animatedItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "geo/lich_gauntlet.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AnimatedItem animatedItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/item/lich_gauntlet.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AnimatedItem animatedItem) {
        return new ResourceLocation(Moonsoriginsmod.MOD_ID, "animations/lich_gauntlet.animation.json");
    }
}
