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
import net.moonjink.moonsoriginsmod.entity.custom.HallucinationShadowPerson;
import net.moonjink.moonsoriginsmod.entity.custom.LichSummonedSkeletonEntity;
import org.jetbrains.annotations.NotNull;

public class HallucinationShadowPersonModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart shadow_entity_one;
	private final ModelPart torso;
	private final ModelPart stomach;
	private final ModelPart chest;
	private final ModelPart neck;
	private final ModelPart head;
	private final ModelPart left_arm;
	private final ModelPart left_elbow_arm;
	private final ModelPart left_lower_arm;
	private final ModelPart left_hand;
	private final ModelPart left_pinkie_base;
	private final ModelPart left_pinkie_end;
	private final ModelPart left_index_base;
	private final ModelPart left_index_end;
	private final ModelPart left_thumb_base;
	private final ModelPart left_thumb_end;
	private final ModelPart right_arm;
	private final ModelPart right_elbow_arm;
	private final ModelPart right_lower_arm;
	private final ModelPart right_hand;
	private final ModelPart right_pinkie_base;
	private final ModelPart right_pinkie_end;
	private final ModelPart right_index_base;
	private final ModelPart right_index_end;
	private final ModelPart right_thumb_base;
	private final ModelPart right_thumb_end;
	private final ModelPart pelvis;
	private final ModelPart legs;
	private final ModelPart right_leg;
	private final ModelPart right_lower_leg;
	private final ModelPart left_leg;
	private final ModelPart left_lower_leg;

	public HallucinationShadowPersonModel(ModelPart root) {
		this.shadow_entity_one = root.getChild("shadow_entity_one");
		this.torso = this.shadow_entity_one.getChild("torso");
		this.stomach = this.torso.getChild("stomach");
		this.chest = this.torso.getChild("chest");
		this.neck = this.chest.getChild("neck");
		this.head = this.neck.getChild("head");
		this.left_arm = this.chest.getChild("left_arm");
		this.left_elbow_arm = this.left_arm.getChild("left_elbow_arm");
		this.left_lower_arm = this.left_elbow_arm.getChild("left_lower_arm");
		this.left_hand = this.left_lower_arm.getChild("left_hand");
		this.left_pinkie_base = this.left_hand.getChild("left_pinkie_base");
		this.left_pinkie_end = this.left_pinkie_base.getChild("left_pinkie_end");
		this.left_index_base = this.left_hand.getChild("left_index_base");
		this.left_index_end = this.left_index_base.getChild("left_index_end");
		this.left_thumb_base = this.left_hand.getChild("left_thumb_base");
		this.left_thumb_end = this.left_thumb_base.getChild("left_thumb_end");
		this.right_arm = this.chest.getChild("right_arm");
		this.right_elbow_arm = this.right_arm.getChild("right_elbow_arm");
		this.right_lower_arm = this.right_elbow_arm.getChild("right_lower_arm");
		this.right_hand = this.right_lower_arm.getChild("right_hand");
		this.right_pinkie_base = this.right_hand.getChild("right_pinkie_base");
		this.right_pinkie_end = this.right_pinkie_base.getChild("right_pinkie_end");
		this.right_index_base = this.right_hand.getChild("right_index_base");
		this.right_index_end = this.right_index_base.getChild("right_index_end");
		this.right_thumb_base = this.right_hand.getChild("right_thumb_base");
		this.right_thumb_end = this.right_thumb_base.getChild("right_thumb_end");
		this.pelvis = this.shadow_entity_one.getChild("pelvis");
		this.legs = this.pelvis.getChild("legs");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_lower_leg = this.right_leg.getChild("right_lower_leg");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_lower_leg = this.left_leg.getChild("left_lower_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition shadow_entity_one = partdefinition.addOrReplaceChild("shadow_entity_one", CubeListBuilder.create(), PartPose.offset(-0.5F, 6.0F, 0.0F));

		PartDefinition torso = shadow_entity_one.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.025F, 2.0F, -0.025F));

		PartDefinition stomach = torso.addOrReplaceChild("stomach", CubeListBuilder.create().texOffs(20, 22).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.1F, 0.0F));

		PartDefinition chest = torso.addOrReplaceChild("chest", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.2F, 0.0F, 0.1933F, -0.0997F, -0.1651F));

		PartDefinition chest_r1 = chest.addOrReplaceChild("chest_r1", CubeListBuilder.create().texOffs(0, 9).addBox(0.0F, -4.0F, -2.0F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.15F, 0.5F, 0.1309F, 0.0F, 0.0F));

		PartDefinition neck = chest.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(12, 28).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.1F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.075F, -1.2F, -0.375F, -0.0873F, 0.0F, -0.0873F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -3.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.9F, 1.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition left_arm = chest.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(2.7F, -4.1F, 0.525F, -0.3706F, 0.2909F, 0.4418F));

		PartDefinition left_upper_r1 = left_arm.addOrReplaceChild("left_upper_r1", CubeListBuilder.create().texOffs(36, 13).addBox(-0.5166F, -10.1604F, -0.45F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.524F, 8.6865F, -0.075F, 1.5708F, -1.5533F, -2.0944F));

		PartDefinition left_elbow_arm = left_arm.addOrReplaceChild("left_elbow_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0439F, 6.2228F, -0.1019F, -0.5777F, -0.5678F, 0.145F));

		PartDefinition left_elbow_r1 = left_elbow_arm.addOrReplaceChild("left_elbow_r1", CubeListBuilder.create().texOffs(14, 25).addBox(-0.9768F, -3.3737F, -0.95F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4801F, 2.4637F, 0.0269F, 1.5708F, -1.5533F, -2.0944F));

		PartDefinition left_lower_arm = left_elbow_arm.addOrReplaceChild("left_lower_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2561F, 0.4772F, 0.1019F, 0.0602F, -0.1639F, -0.354F));

		PartDefinition left_lower_r1 = left_lower_arm.addOrReplaceChild("left_lower_r1", CubeListBuilder.create().texOffs(32, 3).addBox(-0.5166F, -3.1604F, -0.45F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.224F, 1.9865F, -0.075F, 1.5708F, -1.5533F, -2.0944F));

		PartDefinition left_hand = left_lower_arm.addOrReplaceChild("left_hand", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 6.9F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition left_main_r1 = left_hand.addOrReplaceChild("left_main_r1", CubeListBuilder.create().texOffs(24, 13).addBox(-1.0339F, 5.6267F, -0.95F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.776F, -4.9135F, -0.075F, 1.5708F, -1.5533F, -2.0944F));

		PartDefinition left_pinkie_base = left_hand.addOrReplaceChild("left_pinkie_base", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7F, 1.4F, 0.9F, 0.0F, 0.0F, -0.2182F));

		PartDefinition left_pinkie_base_r1 = left_pinkie_base.addOrReplaceChild("left_pinkie_base_r1", CubeListBuilder.create().texOffs(4, 23).addBox(0.1835F, 7.5835F, -0.9055F, 1.0F, 3.8865F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.476F, -6.3135F, -0.975F, 2.9662F, -1.4387F, 2.7509F));

		PartDefinition left_pinkie_end = left_pinkie_base.addOrReplaceChild("left_pinkie_end", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 3.05F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition left_pinkie_end_r1 = left_pinkie_end.addOrReplaceChild("left_pinkie_end_r1", CubeListBuilder.create().texOffs(34, 21).addBox(0.2419F, 11.1444F, -3.4062F, 1.0F, 5.1135F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.476F, -9.3635F, -0.975F, -3.0989F, -1.4387F, 2.7509F));

		PartDefinition left_index_base = left_hand.addOrReplaceChild("left_index_base", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7F, 1.4F, -0.85F, 0.0F, 0.0F, -0.0873F));

		PartDefinition left_index_base_r1 = left_index_base.addOrReplaceChild("left_index_base_r1", CubeListBuilder.create().texOffs(0, 23).addBox(-1.1159F, 7.5603F, -0.8937F, 1.0F, 3.8865F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.476F, -6.3135F, 0.775F, 0.0349F, -1.3519F, -0.6041F));

		PartDefinition left_index_end = left_index_base.addOrReplaceChild("left_index_end", CubeListBuilder.create(), PartPose.offsetAndRotation(1.95F, 3.225F, 0.175F, 0.0F, 0.3491F, -0.3927F));

		PartDefinition left_index_end_r1 = left_index_end.addOrReplaceChild("left_index_end_r1", CubeListBuilder.create().texOffs(30, 21).addBox(-1.2143F, 11.1229F, -3.382F, 1.0F, 5.1135F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.426F, -9.5385F, 0.7F, 0.2531F, -1.3519F, -0.6041F));

		PartDefinition left_thumb_base = left_hand.addOrReplaceChild("left_thumb_base", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3614F, 1.8548F, -1.3217F, 0.5397F, 0.3249F, 0.4059F));

		PartDefinition left_thumb_base_r1 = left_thumb_base.addOrReplaceChild("left_thumb_base_r1", CubeListBuilder.create().texOffs(24, 2).addBox(-1.1572F, 7.4696F, -1.4833F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1374F, -6.7683F, 1.2467F, -0.0453F, 0.096F, -0.5411F));

		PartDefinition left_thumb_end = left_thumb_base.addOrReplaceChild("left_thumb_end", CubeListBuilder.create(), PartPose.offset(0.985F, 1.7636F, -0.1324F));

		PartDefinition left_thumb_end_r1 = left_thumb_end.addOrReplaceChild("left_thumb_end_r1", CubeListBuilder.create().texOffs(24, 5).addBox(-0.5834F, 9.0759F, -3.5472F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1225F, -8.5319F, 1.3791F, 0.179F, 0.0838F, -0.4721F));

		PartDefinition right_arm = chest.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.025F, -4.3F, -0.075F, -3.0754F, 0.1764F, -2.2105F));

		PartDefinition right_upper_r1 = right_arm.addOrReplaceChild("right_upper_r1", CubeListBuilder.create().texOffs(32, 13).addBox(-0.8933F, -13.8293F, -0.4184F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.3444F, 11.8483F, -0.1343F, -1.5708F, 1.5533F, -1.0472F));

		PartDefinition right_elbow_arm = right_arm.addOrReplaceChild("right_elbow_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.006F, 6.2292F, 0.3333F, 0.1043F, -0.1985F, -0.0882F));

		PartDefinition right_elbow_r1 = right_elbow_arm.addOrReplaceChild("right_elbow_r1", CubeListBuilder.create().texOffs(12, 22).addBox(-1.3535F, -7.0426F, -0.9184F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3384F, 5.619F, -0.4676F, -1.5708F, 1.5533F, -1.0472F));

		PartDefinition right_lower_arm = right_elbow_arm.addOrReplaceChild("right_lower_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.294F, 0.4708F, 0.4667F, 0.0117F, 0.2615F, -0.173F));

		PartDefinition right_lower_r1 = right_lower_arm.addOrReplaceChild("right_lower_r1", CubeListBuilder.create().texOffs(36, 3).addBox(-0.8933F, -6.8293F, -0.4184F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0444F, 5.1483F, -0.9343F, -1.5708F, 1.5533F, -1.0472F));

		PartDefinition right_hand = right_lower_arm.addOrReplaceChild("right_hand", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, 6.9F, -0.5755F, -0.4855F, 0.4928F, -0.1831F));

		PartDefinition right_main_r1 = right_hand.addOrReplaceChild("right_main_r1", CubeListBuilder.create().texOffs(22, 9).addBox(-1.4106F, 1.9578F, -0.9184F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9556F, -1.7517F, -0.3589F, -1.5708F, 1.5533F, -1.0472F));

		PartDefinition right_pinkie_base = right_hand.addOrReplaceChild("right_pinkie_base", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7F, 1.4F, 0.8755F, 0.0F, 0.0F, -0.1745F));

		PartDefinition right_pinkie_base_r1 = right_pinkie_base.addOrReplaceChild("right_pinkie_base_r1", CubeListBuilder.create().texOffs(4, 23).addBox(-1.489F, 3.8978F, -1.1182F, 1.0F, 3.8865F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6556F, -3.1517F, -1.2343F, -3.1067F, 1.3519F, -2.5375F));

		PartDefinition right_pinkie_end = right_pinkie_base.addOrReplaceChild("right_pinkie_end", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7F, 3.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition right_pinkie_end_r1 = right_pinkie_end.addOrReplaceChild("right_pinkie_end_r1", CubeListBuilder.create().texOffs(34, 21).addBox(-1.5874F, 7.4986F, -2.8084F, 1.0F, 5.1135F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3556F, -6.1517F, -1.2343F, -2.8885F, 1.3519F, -2.5375F));

		PartDefinition right_index_base = right_hand.addOrReplaceChild("right_index_base", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7F, 1.4F, -0.9245F, 0.0F, 0.0F, -0.1745F));

		PartDefinition right_index_base_r1 = right_index_base.addOrReplaceChild("right_index_base_r1", CubeListBuilder.create().texOffs(0, 23).addBox(-0.1853F, 3.9144F, -0.9767F, 1.0F, 3.8865F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6556F, -3.1517F, 0.5657F, -0.1754F, 1.4387F, 0.3907F));

		PartDefinition right_index_end = right_index_base.addOrReplaceChild("right_index_end", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7F, 3.0F, -0.1F, 0.0F, 0.0F, -0.2182F));

		PartDefinition right_index_end_r1 = right_index_end.addOrReplaceChild("right_index_end_r1", CubeListBuilder.create().texOffs(30, 21).addBox(-0.1269F, 7.5469F, -2.6816F, 1.0F, 5.1135F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3556F, -6.1517F, 0.6657F, 0.0427F, 1.4387F, 0.3907F));

		PartDefinition right_thumb_base = right_hand.addOrReplaceChild("right_thumb_base", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3614F, 1.8548F, -1.2462F, 0.0433F, -0.0057F, -0.131F));

		PartDefinition right_thumb_base_r1 = right_thumb_base.addOrReplaceChild("right_thumb_base_r1", CubeListBuilder.create().texOffs(24, 2).addBox(0.1894F, 3.6185F, -1.2854F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.317F, -3.6066F, 0.8874F, -0.0453F, 0.096F, 0.5061F));

		PartDefinition right_thumb_end = right_thumb_base.addOrReplaceChild("right_thumb_end", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.9601F, 1.5386F, -0.2574F, 0.1309F, 0.0F, 0.0F));

		PartDefinition right_thumb_end_r1 = right_thumb_end.addOrReplaceChild("right_thumb_end_r1", CubeListBuilder.create().texOffs(24, 5).addBox(0.1127F, 5.33F, -2.5204F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2771F, -5.1451F, 1.1448F, 0.1729F, 0.096F, 0.5061F));

		PartDefinition pelvis = shadow_entity_one.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.025F, 1.9F, -0.025F, 0.0F, -0.1309F, 0.0F));

		PartDefinition legs = pelvis.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(-0.025F, 4.1F, 0.025F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(8, 28).addBox(-0.55F, 0.15F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.125F, -0.5F, 0.0F, -0.6109F, 0.3491F, 0.0F));

		PartDefinition right_lower_leg = right_leg.addOrReplaceChild("right_lower_leg", CubeListBuilder.create().texOffs(16, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.075F, 4.15F, 0.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(24, 17).addBox(-0.55F, 0.15F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.375F, -0.5F, 0.0F, -0.5672F, -0.3491F, 0.0F));

		PartDefinition left_lower_leg = left_leg.addOrReplaceChild("left_lower_leg", CubeListBuilder.create().texOffs(16, 11).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.075F, 4.15F, 0.0F, 0.5236F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}


	@Override
	public void setupAnim(@NotNull T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animate(((HallucinationShadowPerson) entity).idleAnimationState, ModAnimationDefinitions.shadow_person_idle, ageInTicks, 1f);
		this.animateWalk(ModAnimationDefinitions.shadow_person_run, limbSwing, limbSwingAmount, 1f, 1f);
		this.animate(((HallucinationShadowPerson) entity).attackAnimationState, ModAnimationDefinitions.shadow_person_attack, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}


	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		shadow_entity_one.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return shadow_entity_one;
	}
}