package su.bathroom.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SnowGolemEntityModel;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BallGolemEntityRenderer extends MobEntityRenderer<BallGolemEntity, SnowGolemEntityModel<BallGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier("bathroom", "textures/entity/ball_golem.png");

    public BallGolemEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new SnowGolemEntityModel<>(context.getPart(EntityModelLayers.SNOW_GOLEM)), 0.5f);
    }

    @Override
    public Identifier getTexture(BallGolemEntity entity) {
        return TEXTURE;
    }
}
