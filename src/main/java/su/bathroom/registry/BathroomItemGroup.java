package su.bathroom.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BathroomItemGroup {
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(BathroomBlocks.BATHROOM_TILES))
            .displayName(Text.translatable("itemGroup.bathroom")).entries((displayContext, entries) -> {
                // TODO Add your entries for blocks and items for the creative menu!
                entries.add(BathroomBlocks.BATHROOM_TILES);
            } )
            .build();

    public static void registerItemGroup() {
        ItemGroup register = Registry.register(Registries.ITEM_GROUP, new Identifier("castleblocks", "castleblocks_group"), ITEM_GROUP);
    }
}
