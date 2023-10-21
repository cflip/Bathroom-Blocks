package su.bathroom.registry;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class BathroomPaintings {
	public static void registerPaintings() {
		createPainting("damp", 16, 32);
		createPainting("eel", 16, 16);
		createPainting("market", 16, 16);
		createPainting("hellpipe", 32, 16);
		createPainting("fish_curtain", 16, 16);
	}

	private static void createPainting(String id, int width, int height) {
		Registry.register(Registries.PAINTING_VARIANT, new Identifier("bathroom", id), new PaintingVariant(width, height));
	}
}