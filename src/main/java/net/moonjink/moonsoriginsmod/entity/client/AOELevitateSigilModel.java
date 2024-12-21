package net.moonjink.moonsoriginsmod.entity.client;// Made with Blockbench 4.11.2

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.moonjink.moonsoriginsmod.entity.animations.ModAnimationDefinitions;
import net.moonjink.moonsoriginsmod.entity.custom.AOELevitateSigilEntity;
import net.moonjink.moonsoriginsmod.entity.custom.DelayedTeleportSigilEntity;

public class AOELevitateSigilModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart main_particle;
	private final ModelPart rotate;
	private final ModelPart head;

	public AOELevitateSigilModel(ModelPart root) {
		this.main_particle = root.getChild("main_particle");
		this.rotate = this.main_particle.getChild("rotate");
		this.head = this.main_particle.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main_particle = partdefinition.addOrReplaceChild("main_particle", CubeListBuilder.create(), PartPose.offset(0.0F, 23.7F, 0.0F));

		PartDefinition rotate = main_particle.addOrReplaceChild("rotate", CubeListBuilder.create().texOffs(-64, 0).addBox(-32.0F, 4.5F, -32.0F, 64.0F, 0.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.5F, 0.0F));

		PartDefinition head = main_particle.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -4.5F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animate(((AOELevitateSigilEntity) entity).idleAnimationState, ModAnimationDefinitions.sigil_idle, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		main_particle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public  ModelPart root() {
		return main_particle;
	}
}