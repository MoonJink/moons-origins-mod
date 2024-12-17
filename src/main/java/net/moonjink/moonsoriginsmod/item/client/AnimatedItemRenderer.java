package net.moonjink.moonsoriginsmod.item.client;

import net.moonjink.moonsoriginsmod.item.custom.AnimatedItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class AnimatedItemRenderer extends GeoItemRenderer<AnimatedItem> {
    public AnimatedItemRenderer() {
        super(new AnimatedItemModel());
    }
}
