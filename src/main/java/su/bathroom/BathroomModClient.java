package su.bathroom;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import su.bathroom.entity.*;

@Environment(EnvType.CLIENT)
public class BathroomModClient implements ClientModInitializer {
	public static final EntityModelLayer MUSHLET_MODEL_LAYER = new EntityModelLayer(new Identifier("bathroom", "mushlet"), "main");
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(BathroomMod.MUSHLET_ENTITY, MushletRenderer::new);
		EntityRendererRegistry.register(BathroomMod.PIG_CREEPER_ENTITY, PigCreeperEntityRenderer::new);
		EntityRendererRegistry.register(BathroomMod.BOUNCY_BALL_ENTITY, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(BathroomMod.BASKETBALL_ENTITY, FlyingItemEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(MUSHLET_MODEL_LAYER, MushletModel::getTexturedModelData);
		EntityRendererRegistry.register(BathroomMod.BALL_GOLEM_ENTITY, BallGolemEntityRenderer::new);
		EntityRendererRegistry.register(BathroomMod.VIDEO_GAMER_ENTITY, VideoGamerEntityRenderer::new);
	}
}
