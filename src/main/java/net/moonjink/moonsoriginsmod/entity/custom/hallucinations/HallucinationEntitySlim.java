package net.moonjink.moonsoriginsmod.entity.custom.hallucinations;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.moonjink.moonsoriginsmod.Moonsoriginsmod;

import java.util.List;
import java.util.Random;

public class HallucinationEntitySlim extends HallucinationEntity {
    private final ResourceLocation texture;

    public HallucinationEntitySlim(EntityType<? extends HallucinationEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.texture = selectSkin();
    }

    public ResourceLocation getSkinTexture() {
        return texture;
    }

    private static final List<ResourceLocation> SKIN_TEXTURES = List.of(
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_lady_fleur.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_vengeful_spirit_rage.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_vengeful_spirit.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_alchemist.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_druid.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_misfaris.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_crypt_vampire.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_egg_vampire.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_mercreature.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_undead.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_pirate.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_gorgon.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_drowned.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_host.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_protector.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_caregiver.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_persecutor.png"),
            new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_schizophrenic_person.png")
    );

    private ResourceLocation selectSkin() {
        int test = random.nextInt(3);

        if(test == 1) {
            return SKIN_TEXTURES.get(new Random().nextInt(SKIN_TEXTURES.size()));
        }
        else if (test == 0) {
            return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/shadow.png");
        }
        else if (test == 2) {
            return new ResourceLocation(Moonsoriginsmod.MOD_ID, "textures/entity/hallucinations/slim/hallucinated_doctor.png");
        }
        return null;
    }
}
