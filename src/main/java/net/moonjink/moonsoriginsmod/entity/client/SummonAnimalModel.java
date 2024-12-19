package net.moonjink.moonsoriginsmod.entity.client;// Made with Blockbench 4.11.2

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.moonjink.moonsoriginsmod.entity.custom.SummonAnimalEntity;

public class SummonAnimalModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart ghost_animal;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart tail;

	public SummonAnimalModel(ModelPart root) {
		this.ghost_animal = root.getChild("ghost_animal");
		this.head = this.ghost_animal.getChild("head");
		this.body = this.ghost_animal.getChild("body");
		this.leg1 = this.ghost_animal.getChild("leg1");
		this.leg2 = this.ghost_animal.getChild("leg2");
		this.leg3 = this.ghost_animal.getChild("leg3");
		this.leg4 = this.ghost_animal.getChild("leg4");
		this.tail = this.ghost_animal.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ghost_animal = partdefinition.addOrReplaceChild("ghost_animal", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = ghost_animal.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 5).addBox(-3.0F, -2.0F, -5.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(15, 1).addBox(3.0F, -4.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(8, 1).addBox(-3.0F, -4.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(6, 18).addBox(-1.0F, 2.0F, -8.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -7.5F, -3.0F));

		PartDefinition body = ghost_animal.addOrReplaceChild("body", CubeListBuilder.create().texOffs(24, 15).addBox(-3.0F, 4.0F, -3.5F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -6.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leg1 = ghost_animal.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(13, 24).addBox(1.999F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -6.5F, 7.0F));

		PartDefinition leg2 = ghost_animal.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(4, 24).addBox(2.001F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -6.5F, 7.0F));

		PartDefinition leg3 = ghost_animal.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(13, 24).addBox(1.999F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -6.5F, 0.0F));

		PartDefinition leg4 = ghost_animal.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(4, 24).addBox(2.001F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -6.5F, 0.0F));

		PartDefinition tail = ghost_animal.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(30, 0).addBox(2.0F, 0.0F, -1.0F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -7.0F, 9.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 48, 32);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		if (entity instanceof SummonAnimalEntity summonAnimalEntity && summonAnimalEntity.isSitting()) {
			this.ghost_animal.setPos(0F, 16.0F, 0F);
		} else {
			this.ghost_animal.setPos(0F, 24.0F, 0F);
		}

		this.leg1.xRot = (float) (Math.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount);
		this.leg2.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.leg3.xRot = (float) (Math.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount);
		this.leg4.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		ghost_animal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return ghost_animal;
	}
}