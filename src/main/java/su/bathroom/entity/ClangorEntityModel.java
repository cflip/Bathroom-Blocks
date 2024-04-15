package su.bathroom.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import su.bathroom.entity.ClangorEntity;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ClangorEntityModel extends EntityModel<ClangorEntity> {
	private final ModelPart bone;
	private final ModelPart Rlegback;
	private final ModelPart Llegback;
	private final ModelPart Rleg;
	private final ModelPart Lleg;
	private final ModelPart head;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	public ClangorEntityModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.Rlegback = this.bone.getChild("Rlegback");
		this.Llegback = this.bone.getChild("Llegback");
		this.Rleg = this.bone.getChild("Rleg");
		this.Lleg = this.bone.getChild("Lleg");
		this.head = this.bone.getChild("head");
		this.cube_r1 = this.head.getChild("cube_r1");
		this.cube_r2 = this.head.getChild("cube_r2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(16, 16).cuboid(-3.0F, -24.0F, -2.0F, 6.0F, 12.0F, 4.0F, new Dilation(0.0F))
		.uv(36, 14).cuboid(-4.0F, -24.0F, -3.0F, 8.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Rlegback = bone.addChild("Rlegback", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, 0.0F, 0.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 2.0F));

		ModelPartData Llegback = bone.addChild("Llegback", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, 0.0F, 0.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 2.0F));

		ModelPartData Rleg = bone.addChild("Rleg", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, -2.0F));

		ModelPartData Lleg = bone.addChild("Lleg", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, 0.0F, -4.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, -2.0F));

		ModelPartData head = bone.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData cube_r1 = head.addChild("cube_r1", ModelPartBuilder.create().uv(32, -8).cuboid(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		ModelPartData cube_r2 = head.addChild("cube_r2", ModelPartBuilder.create().uv(32, -8).cuboid(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.2618F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(ClangorEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
		this.Llegback.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
		this.Rlegback.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
		this.Lleg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
		this.Rleg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}