package net.moonjink.moonsoriginsmod.entity.client;// Made with Blockbench 4.11.2

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.moonjink.moonsoriginsmod.entity.animations.ModAnimationDefinitions;
import net.moonjink.moonsoriginsmod.entity.custom.PermanentLichSummonedSkeletonEntity;
import net.moonjink.moonsoriginsmod.entity.custom.SummonWolfEntity;

public class SummonWolfModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart summon_wolf;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart ears;
	private final ModelPart mane;
	private final ModelPart body;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart tail;

	public SummonWolfModel(ModelPart root) {
		this.summon_wolf = root.getChild("summon_wolf");
		this.head = this.summon_wolf.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.ears = this.head.getChild("ears");
		this.mane = this.summon_wolf.getChild("mane");
		this.body = this.summon_wolf.getChild("body");
		this.leg1 = this.summon_wolf.getChild("leg1");
		this.leg2 = this.summon_wolf.getChild("leg2");
		this.leg3 = this.summon_wolf.getChild("leg3");
		this.leg4 = this.summon_wolf.getChild("leg4");
		this.tail = this.summon_wolf.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition summon_wolf = partdefinition.addOrReplaceChild("summon_wolf", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = summon_wolf.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -3.0F, -3.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 10).addBox(-0.5F, -0.02F, -6.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -10.5F, -6.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(37, 15).addBox(-1.5F, -0.5F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.48F, -2.0F));

		PartDefinition ears = head.addOrReplaceChild("ears", CubeListBuilder.create().texOffs(16, 14).addBox(1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(16, 14).addBox(-3.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -4.0F, -0.5F));

		PartDefinition mane = summon_wolf.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(21, 0).addBox(-3.0F, -3.0F, -3.0F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -10.0F, -3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition body = summon_wolf.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 14).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition leg1 = summon_wolf.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -8.0F, 7.0F));

		PartDefinition leg2 = summon_wolf.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -8.0F, 7.0F));

		PartDefinition leg3 = summon_wolf.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -8.0F, -4.0F));

		PartDefinition leg4 = summon_wolf.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -8.0F, -4.0F));

		PartDefinition tail = summon_wolf.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(9, 18).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -12.0F, 10.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.leg1.xRot = (float) (Math.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount);
		this.leg2.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
		this.leg3.xRot = (float) (Math.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount);
		this.leg4.xRot = (float) (Math.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);

		this.animate(((SummonWolfEntity) entity).idleAnimationState, ModAnimationDefinitions.summon_wolf_idle, ageInTicks, 1f);
		this.animate(((SummonWolfEntity) entity).attackAnimationState, ModAnimationDefinitions.summon_wolf_attack, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		summon_wolf.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return summon_wolf;
	}
}