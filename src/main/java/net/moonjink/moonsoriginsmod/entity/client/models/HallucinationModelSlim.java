package net.moonjink.moonsoriginsmod.entity.client.models;// Made with Blockbench 4.11.2

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class HallucinationModelSlim<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart hallucination_entity;
	private final ModelPart head;
	private final ModelPart skull;
	private final ModelPart headwear;
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart jacket;
	private final ModelPart leftArm;
	private final ModelPart left_arm;
	private final ModelPart left_sleeve;
	private final ModelPart rightArm;
	private final ModelPart right_arm;
	private final ModelPart right_sleeve;
	private final ModelPart leftLeg;
	private final ModelPart left_leg;
	private final ModelPart left_pants;
	private final ModelPart rightLeg;
	private final ModelPart right_leg;
	private final ModelPart right_pants;

	public HallucinationModelSlim(ModelPart root) {
		this.hallucination_entity = root.getChild("hallucination_entity");
		this.head = this.hallucination_entity.getChild("head");
		this.skull = this.head.getChild("skull");
		this.headwear = this.head.getChild("headwear");
		this.body = this.hallucination_entity.getChild("body");
		this.torso = this.body.getChild("torso");
		this.jacket = this.body.getChild("jacket");
		this.leftArm = this.hallucination_entity.getChild("leftArm");
		this.left_arm = this.leftArm.getChild("left_arm");
		this.left_sleeve = this.leftArm.getChild("left_sleeve");
		this.rightArm = this.hallucination_entity.getChild("rightArm");
		this.right_arm = this.rightArm.getChild("right_arm");
		this.right_sleeve = this.rightArm.getChild("right_sleeve");
		this.leftLeg = this.hallucination_entity.getChild("leftLeg");
		this.left_leg = this.leftLeg.getChild("left_leg");
		this.left_pants = this.leftLeg.getChild("left_pants");
		this.rightLeg = this.hallucination_entity.getChild("rightLeg");
		this.right_leg = this.rightLeg.getChild("right_leg");
		this.right_pants = this.rightLeg.getChild("right_pants");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hallucination_entity = partdefinition.addOrReplaceChild("hallucination_entity", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = hallucination_entity.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition skull = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition headwear = head.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body = hallucination_entity.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jacket = body.addOrReplaceChild("jacket", CubeListBuilder.create().texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftArm = hallucination_entity.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(5.0F, -22.0F, 0.0F));

		PartDefinition left_arm = leftArm.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_sleeve = leftArm.addOrReplaceChild("left_sleeve", CubeListBuilder.create().texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightArm = hallucination_entity.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(-5.0F, -22.0F, 0.0F));

		PartDefinition right_arm = rightArm.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_sleeve = rightArm.addOrReplaceChild("right_sleeve", CubeListBuilder.create().texOffs(41, 32).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftLeg = hallucination_entity.addOrReplaceChild("leftLeg", CubeListBuilder.create(), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition left_leg = leftLeg.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_pants = leftLeg.addOrReplaceChild("left_pants", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightLeg = hallucination_entity.addOrReplaceChild("rightLeg", CubeListBuilder.create(), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition right_leg = rightLeg.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_pants = rightLeg.addOrReplaceChild("right_pants", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		float walkSpeed = 0.7F, swingReduction = 0.9F;
		this.rightLeg.xRot = (float) (Math.cos(limbSwing * walkSpeed) * swingReduction * limbSwingAmount);
		this.leftLeg.xRot = (float) (Math.cos(limbSwing * walkSpeed + (float) Math.PI) * swingReduction * limbSwingAmount);
		this.rightArm.xRot = (float) (Math.cos(limbSwing * walkSpeed + (float) Math.PI) * swingReduction * limbSwingAmount);
		this.leftArm.xRot = (float) (Math.cos(limbSwing * walkSpeed) * swingReduction * limbSwingAmount);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}


	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hallucination_entity.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return hallucination_entity;
	}
}