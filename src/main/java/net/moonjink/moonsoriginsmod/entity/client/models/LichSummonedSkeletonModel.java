package net.moonjink.moonsoriginsmod.entity.client.models;// Made with Blockbench 4.11.2

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.moonjink.moonsoriginsmod.entity.animations.ModAnimationDefinitions;
import net.moonjink.moonsoriginsmod.entity.custom.lich_summons.LichSummonedSkeletonEntity;
import org.jetbrains.annotations.NotNull;

public class LichSummonedSkeletonModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart lichsummonedskeleton;
	private final ModelPart torso;
	private final ModelPart upper_torso;
	private final ModelPart upper_torso_main;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart left_arm;
	private final ModelPart lower_left_arm;
	private final ModelPart right_arm;
	private final ModelPart lower_right_arm;
	private final ModelPart lower_torso;
	private final ModelPart lower_torso_main;
	private final ModelPart left_leg;
	private final ModelPart lower_left_leg;
	private final ModelPart right_leg;
	private final ModelPart lower_right_leg;

	public LichSummonedSkeletonModel(ModelPart root) {
		this.lichsummonedskeleton = root.getChild("lichsummonedskeleton");
		this.torso = this.lichsummonedskeleton.getChild("torso");
		this.upper_torso = this.torso.getChild("upper_torso");
		this.upper_torso_main = this.upper_torso.getChild("upper_torso_main");
		this.neck = this.upper_torso.getChild("neck");
		this.head = this.neck.getChild("head");
		this.left_arm = this.upper_torso.getChild("left_arm");
		this.lower_left_arm = this.left_arm.getChild("lower_left_arm");
		this.right_arm = this.upper_torso.getChild("right_arm");
		this.lower_right_arm = this.right_arm.getChild("lower_right_arm");
		this.lower_torso = this.torso.getChild("lower_torso");
		this.lower_torso_main = this.lower_torso.getChild("lower_torso_main");
		this.left_leg = this.lower_torso.getChild("left_leg");
		this.lower_left_leg = this.left_leg.getChild("lower_left_leg");
		this.right_leg = this.lower_torso.getChild("right_leg");
		this.lower_right_leg = this.right_leg.getChild("lower_right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition lichsummonedskeleton = partdefinition.addOrReplaceChild("lichsummonedskeleton", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 22.975F, 0.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition torso = lichsummonedskeleton.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, -17.5F, 0.0F));

		PartDefinition upper_torso = torso.addOrReplaceChild("upper_torso", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition upper_torso_main = upper_torso.addOrReplaceChild("upper_torso_main", CubeListBuilder.create().texOffs(16, 16).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.125F));

		PartDefinition neck = upper_torso.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(54, 0).addBox(-1.0F, -3.6125F, -1.475F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -0.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(1, 1).addBox(-4.0F, -4.25F, -2.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(32, 38).addBox(-4.0F, 1.75F, -2.5F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(33, 1).addBox(-4.0F, -5.25F, -2.475F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.5F))
				.texOffs(24, 4).addBox(-1.0F, -1.125F, -3.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.75F, -2.25F, -0.0436F, 0.0F, 0.0F));

		PartDefinition left_arm = upper_torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).addBox(0.0F, 1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -6.0F, 0.0F, -0.336F, -0.1251F, -0.4202F));

		PartDefinition lower_left_arm = left_arm.addOrReplaceChild("lower_left_arm", CubeListBuilder.create().texOffs(40, 24).addBox(-1.0F, 1.25F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(-0.5F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 6.25F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition right_arm = upper_torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, 1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -6.0F, 0.0F, -0.2953F, 0.1171F, 0.405F));

		PartDefinition lower_right_arm = right_arm.addOrReplaceChild("lower_right_arm", CubeListBuilder.create().texOffs(40, 24).addBox(-1.0F, 1.25F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(-0.5F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 6.25F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition lower_torso = torso.addOrReplaceChild("lower_torso", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.75F, 0.6F, 0.0436F, 0.0F, 0.0F));

		PartDefinition lower_torso_main = lower_torso.addOrReplaceChild("lower_torso_main", CubeListBuilder.create().texOffs(16, 34).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(16, 28).addBox(-3.0F, 5.0F, -2.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.75F, 0.0F));

		PartDefinition left_leg = lower_torso.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.25F, 0.0F));

		PartDefinition lower_left_leg = left_leg.addOrReplaceChild("lower_left_leg", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, 1.25F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(-0.5F, 0.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.25F, 0.0F));

		PartDefinition right_leg = lower_torso.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.25F, 0.0F));

		PartDefinition lower_right_leg = right_leg.addOrReplaceChild("lower_right_leg", CubeListBuilder.create().texOffs(0, 25).addBox(-1.0F, 1.25F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(-0.5F, 0.25F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.25F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animate(((LichSummonedSkeletonEntity) entity).idleAnimationState, ModAnimationDefinitions.smallIdle, ageInTicks, 1f);
		this.animateWalk(ModAnimationDefinitions.smallRun, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((LichSummonedSkeletonEntity) entity).attackAnimationState, ModAnimationDefinitions.smallAttack, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		lichsummonedskeleton.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public @NotNull ModelPart root() {
		return lichsummonedskeleton;
	}
}