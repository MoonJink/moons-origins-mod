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
import net.moonjink.moonsoriginsmod.entity.custom.SummonAnimalEntity;

public class SummonAnimalModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart ghost_animal;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart WhiskerLeft;
	private final ModelPart WhiskerRight;
	private final ModelPart collar;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart tail;
	private final ModelPart lowertail;

	public SummonAnimalModel(ModelPart root) {
		this.ghost_animal = root.getChild("ghost_animal");
		this.body = this.ghost_animal.getChild("body");
		this.head = this.body.getChild("head");
		this.WhiskerLeft = this.head.getChild("WhiskerLeft");
		this.WhiskerRight = this.head.getChild("WhiskerRight");
		this.collar = this.body.getChild("collar");
		this.leg1 = this.body.getChild("leg1");
		this.leg2 = this.body.getChild("leg2");
		this.leg3 = this.body.getChild("leg3");
		this.leg4 = this.body.getChild("leg4");
		this.tail = this.body.getChild("tail");
		this.lowertail = this.tail.getChild("lowertail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ghost_animal = partdefinition.addOrReplaceChild("ghost_animal", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = ghost_animal.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, 2.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -9.025F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -2.975F, -4.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(20, 29).addBox(1.0F, -5.975F, -3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(42, 33).addBox(-4.0F, -5.975F, -3.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 38).addBox(-2.0F, 1.025F, -7.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -6.0F));

		PartDefinition WhiskerLeft = head.addOrReplaceChild("WhiskerLeft", CubeListBuilder.create().texOffs(30, 43).addBox(-3.0F, -1.5F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 1.525F, -3.0F));

		PartDefinition WhiskerRight = head.addOrReplaceChild("WhiskerRight", CubeListBuilder.create().texOffs(24, 43).addBox(0.0F, -1.5F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 1.525F, -3.0F));

		PartDefinition collar = body.addOrReplaceChild("collar", CubeListBuilder.create().texOffs(28, 18).addBox(-3.51F, 2.795F, -1.99F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(28, 13).addBox(-3.51F, -3.38F, -1.99F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.06F, 0.28F, -2.035F));

		PartDefinition cube_r1 = collar.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 29).addBox(4.0F, 0.0F, -3.0F, 3.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.515F, -4.155F, -2.04F, -1.5708F, 0.0F, 1.5708F));

		PartDefinition cube_r2 = collar.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(20, 33).addBox(1.0F, 0.0F, -1.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.485F, -4.355F, -0.99F, 0.0F, 0.0F, 1.5708F));

		PartDefinition cube_r3 = collar.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 38).addBox(1.0F, 0.0F, -1.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.49F, -4.405F, -0.99F, 0.0F, 0.0F, 1.5708F));

		PartDefinition leg1 = body.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(36, 38).addBox(-0.9F, 0.05F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 3.0F, 5.0F));

		PartDefinition leg2 = body.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 43).addBox(-1.1F, 0.05F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, 5.0F));

		PartDefinition leg3 = body.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(8, 43).addBox(-0.9F, 0.05F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 3.0F, -2.0F));

		PartDefinition leg4 = body.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(16, 43).addBox(-1.1F, 0.05F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 3.0F, -2.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -0.75F, 7.0F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(24, 0).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition lowertail = tail.addOrReplaceChild("lowertail", CubeListBuilder.create(), PartPose.offset(0.0F, -1.25F, 6.0F));

		PartDefinition tail_r2 = lowertail.addOrReplaceChild("tail_r2", CubeListBuilder.create().texOffs(28, 23).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6F, 2.4F, 3.1416F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		if (entity instanceof SummonAnimalEntity summonAnimalEntity && summonAnimalEntity.isSitting()) {
			this.animate(((SummonAnimalEntity) entity).idleAnimationState, ModAnimationDefinitions.summon_animal_lay_idle, ageInTicks, 1f);
		} else {
			this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
			this.animate(((SummonAnimalEntity) entity).idleAnimationState, ModAnimationDefinitions.summon_animal_idle, ageInTicks, 1f);
			this.animateWalk(ModAnimationDefinitions.summon_animal_walk, limbSwing, limbSwingAmount, 2f, 1f);
		}
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