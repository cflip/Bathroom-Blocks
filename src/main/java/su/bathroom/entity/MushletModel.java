package su.bathroom.entity;// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import su.bathroom.registry.BathroomAnimations;

public class MushletModel extends SinglePartEntityModel<MushletEntity> {
    private final ModelPart root;
    private final ModelPart head;

    public MushletModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = this.root.getChild("bone");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData bone = root.addChild("bone", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, -5.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-3.0F, -5.0F, -3.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).uv(0, 16).cuboid(-2.0F, -6.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)).uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

        ModelPartData bone2 = root.addChild("bone2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, 2.0F, -4.0F, 8.0F, 2.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

        ModelPartData bone3 = root.addChild("bone3", ModelPartBuilder.create().uv(16, 18).cuboid(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(MushletEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.head.yaw = netHeadYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
        this.animateMovement(BathroomAnimations.MUSHLET_SQUASH, limbSwing, limbSwingAmount, 2.5F, 100.0F);
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }
}