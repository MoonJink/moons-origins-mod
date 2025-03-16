package net.moonjink.moonsoriginsmod.entity.client.models;// Made with Blockbench 4.11.2

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.moonjink.moonsoriginsmod.entity.animations.ModAnimationDefinitions;
import net.moonjink.moonsoriginsmod.entity.custom.LichLargeSummonedSkeletonEntity;
import org.jetbrains.annotations.NotNull;

public class LichLargeSummonedSkeletonModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart LichLargeSummonedSkeleton;
	private final ModelPart body;
	private final ModelPart rotation;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart horns;
	private final ModelPart left_horn;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart neck;

	public LichLargeSummonedSkeletonModel(ModelPart root) {
		this.LichLargeSummonedSkeleton = root.getChild("LichLargeSummonedSkeleton");
		this.body = this.LichLargeSummonedSkeleton.getChild("body");
		this.rotation = this.body.getChild("rotation");
		this.head = this.body.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.horns = this.head.getChild("horns");
		this.left_horn = this.horns.getChild("left_horn");
		this.leg1 = this.body.getChild("leg1");
		this.leg2 = this.body.getChild("leg2");
		this.leg3 = this.body.getChild("leg3");
		this.leg4 = this.body.getChild("leg4");
		this.neck = this.body.getChild("neck");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LichLargeSummonedSkeleton = partdefinition.addOrReplaceChild("LichLargeSummonedSkeleton", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = LichLargeSummonedSkeleton.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -23.0F, 3.5F));

		PartDefinition rotation = body.addOrReplaceChild("rotation", CubeListBuilder.create().texOffs(0, 55).addBox(-7.0F, -10.0F, -7.0F, 14.0F, 16.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(0, 91).addBox(-6.0F, 6.0F, -7.0F, 12.0F, 13.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -20.0F, -14.0F, 16.0F, 20.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -6.0F, -18.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(92, 105).addBox(-8.925F, -20.975F, -14.25F, 18.0F, 23.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(82, 118).addBox(-1.0F, -14.0F, -15.0875F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(82, 121).addBox(-1.0F, -11.0F, -15.0875F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(80, 124).addBox(-2.0F, -13.0F, -15.0875F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, -13.5F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 36).addBox(-8.0F, 0.0F, -16.0F, 16.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 2.0F));

		PartDefinition horns = head.addOrReplaceChild("horns", CubeListBuilder.create().texOffs(74, 55).addBox(-5.0F, -14.0F, -1.0F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -13.0F, -9.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition left_horn = horns.addOrReplaceChild("left_horn", CubeListBuilder.create().texOffs(74, 55).mirror().addBox(8.0F, -41.0F, -20.0F, 2.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 27.0F, 19.0F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(96, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -14.0F, 17.5F));

		PartDefinition leg2 = body.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(96, 0).mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, -14.0F, 17.5F));

		PartDefinition leg3 = body.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(64, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -14.0F, -7.0F));

		PartDefinition leg4 = body.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-4.0F, 0.0F, -4.0F, 8.0F, 37.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(8.0F, -14.0F, -7.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(68, 73).addBox(-5.0F, -1.0F, -18.0F, 10.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 4.5F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		this.head.xRot = headPitch * ((float) Math.PI / 180F);

		float walkSpeed = 0.5F, swingReduction = 0.5F;
		this.leg1.xRot = (float) (Math.cos(limbSwing * walkSpeed) * swingReduction * limbSwingAmount);
		this.leg2.xRot = (float) (Math.cos(limbSwing * walkSpeed + (float) Math.PI) * swingReduction * limbSwingAmount);
		this.leg3.xRot = (float) (Math.cos(limbSwing * walkSpeed + (float) Math.PI) * swingReduction * limbSwingAmount);
		this.leg4.xRot = (float) (Math.cos(limbSwing * walkSpeed) * swingReduction * limbSwingAmount);

		this.animate(((LichLargeSummonedSkeletonEntity) entity).idleAnimationState, ModAnimationDefinitions.ravagerIdle, ageInTicks, 1f);
		this.animate(((LichLargeSummonedSkeletonEntity) entity).attackAnimationState, ModAnimationDefinitions.ravager_attack, ageInTicks, 1f);
	}
	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LichLargeSummonedSkeleton.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public @NotNull ModelPart root() {
		return LichLargeSummonedSkeleton;
	}
}