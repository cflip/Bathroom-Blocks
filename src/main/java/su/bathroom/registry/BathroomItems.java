package su.bathroom.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.StewItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import su.bathroom.BathroomMod;

public class BathroomItems {


    public static final Item BATHROOM_CRITTER = new Item(new Item.Settings());
    public static final Item SPLENDOR_CRITTER = new Item(new Item.Settings());
    public static final Item YOPER = new Item(new Item.Settings());
    public static final Item GUMMIES = new Item(new FabricItemSettings().food(BathroomMod.GUMMIES_FOOD));
    public static final Item WORMS_IN_DIRT = new StewItem(new FabricItemSettings().food(BathroomMod.WORMS_IN_DIRT_FOOD));


    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier("bathroom", "bathroom_critter"), BATHROOM_CRITTER);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "splendor_critter"), SPLENDOR_CRITTER);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "yoper"), YOPER);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "gummies"), GUMMIES);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "worms_in_dirt"), WORMS_IN_DIRT);
    }
}
