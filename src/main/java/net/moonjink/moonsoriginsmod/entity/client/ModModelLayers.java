package net.moonjink.moonsoriginsmod.entity.client;

import net.moonjink.moonsoriginsmod.Moonsoriginsmod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation LICH_SUMMONED_SKELETON_LAYER = new ModelLayerLocation(
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "lich_summoned_skeleton_layer"), "main");
    public static final ModelLayerLocation LICH_LARGE_SUMMONED_SKELETON_LAYER = new ModelLayerLocation(
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "lich_large_summoned_skeleton_layer"), "main");
    public static final ModelLayerLocation PERMANENT_LICH_SUMMONED_SKELETON_LAYER = new ModelLayerLocation(
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "permanent_lich_summoned_skeleton_layer"), "main");
}
