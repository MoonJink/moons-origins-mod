package net.moonjink.moonsoriginsmod.entity.custom.hallucinations;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;

import java.util.List;
import java.util.Random;

public class HallucinationEntityWide extends HallucinationEntity {
    private final ResourceLocation texture;

    public HallucinationEntityWide(EntityType<? extends HallucinationEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.texture = selectSkin();
    }

    public ResourceLocation getSkinTexture() {
        return texture;
    }

    private static final List<ResourceLocation> SKIN_TEXTURES = List.of(
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/wide/hallucinated_lich_arcane_form.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/wide/hallucinated_lich_ghost_form.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/wide/hallucinated_hag.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/wide/hallucinated_scientist.png")
    );
    private ResourceLocation selectSkin() {
        int test = random.nextInt(2);

        if(test == 1) {
            return SKIN_TEXTURES.get(new Random().nextInt(SKIN_TEXTURES.size()));
        }
        else if (test == 0) {
            return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/shadow.png");
        }
        return null;
    }
}
