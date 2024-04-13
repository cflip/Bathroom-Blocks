package su.bathroom.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EndermiteEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class VideoGamerEntityRenderer extends MobEntityRenderer<VideoGamerEntity, EndermiteEntityModel<VideoGamerEntity>> {
    private static final Identifier TEXTURE = new Identifier("bathroom", "textures/entity/video_gamer.png");

    public VideoGamerEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new EndermiteEntityModel<>(context.getPart(EntityModelLayers.ENDERMITE)), 0.5f);
    }

    @Override
    public Identifier getTexture(VideoGamerEntity entity) {
        return TEXTURE;
    }
}
