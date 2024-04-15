package su.bathroom.entity;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.CreeperChargeFeatureRenderer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import su.bathroom.BathroomModClient;

public class ClangorEntityRenderer extends MobEntityRenderer<ClangorEntity, ClangorEntityModel> {
    private static final Identifier TEXTURE = new Identifier("bathroom", "textures/entity/clangor.png");

    public ClangorEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ClangorEntityModel(context.getPart(BathroomModClient.CLANGOR_MODEL_LAYER)), 0.5F);
    }

    public Identifier getTexture(ClangorEntity entity) {
        return TEXTURE;
    }
}
