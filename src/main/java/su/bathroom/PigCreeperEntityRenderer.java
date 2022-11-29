package su.bathroom;

import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

public class PigCreeperEntityRenderer extends CreeperEntityRenderer {
    private static final Identifier TEXTURE = new Identifier("bathroom",  "textures/entity/pig_creeper.png");

    public PigCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(CreeperEntity creeperEntity) {
        return TEXTURE;
    }
}
