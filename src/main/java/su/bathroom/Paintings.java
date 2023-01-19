package su.bathroom;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Paintings implements ModInitializer {

    @Override
    public void onInitialize () {

        this.createPainting("damp", 16, 32);
        this.createPainting("eel", 16, 16);
        this.createPainting("market", 16, 16);
        this.createPainting("hellpipe", 32, 16);

    }

    private PaintingVariant createPainting (String id, int width, int height) {

        final PaintingVariant type = new PaintingVariant(width, height);
        Registry.register(Registry.PAINTING_VARIANT, new Identifier("bathroom", id), type);
        return type;
    }
}