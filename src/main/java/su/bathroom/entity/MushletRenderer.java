package su.bathroom.entity;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import su.bathroom.BathroomModClient;

public class MushletRenderer extends MobEntityRenderer<MushletEntity, MushletModel> {
	private static final Identifier TEXTURE = new Identifier("bathroom", "textures/entity/mushlet.png");

	public MushletRenderer(EntityRendererFactory.Context context) {
		super(context, new MushletModel(context.getPart(BathroomModClient.MUSHLET_MODEL_LAYER)), 0.4f);
	}

	@Override
	protected void scale(MushletEntity entity, MatrixStack matrices, float amount) {
		super.scale(entity, matrices, amount);
		if (entity.isBaby()) {
			matrices.scale(0.5F, 0.5F, 0.5F);
		}
	}

	@Nullable
	@Override
	protected RenderLayer getRenderLayer(MushletEntity entity, boolean showBody, boolean translucent, boolean showOutline) {
		return RenderLayer.getEntityTranslucent(this.getTexture(entity));
	}

	@Override
	public Identifier getTexture(MushletEntity entity) {
		return TEXTURE;
	}
}
