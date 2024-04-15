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
				entries.add(BathroomBlocks.BATHROOM_TILES);
				entries.add(BathroomBlocks.RAW_BATHROOM);
				entries.add(BathroomBlocks.SLIPTILES);
				entries.add(BathroomBlocks.DARK_SLIPTILES);
				entries.add(BathroomBlocks.MIXED_SLIPTILES);
				entries.add(BathroomBlocks.SLIPBRICKS);
				entries.add(BathroomBlocks.DARK_SLIPBRICKS);
				entries.add(BathroomBlocks.FRUITY_TILES);
				entries.add(BathroomBlocks.BERRY_TILES);
				entries.add(BathroomBlocks.MELON_TILES);
				entries.add(BathroomBlocks.PUMPKIN_TILES);
				entries.add(BathroomBlocks.SOUR_TILES);
				entries.add(BathroomBlocks.TURTLE_TILES);
				entries.add(BathroomBlocks.TORTOISE_TILES);
				entries.add(BathroomBlocks.SHOWER_CURTAIN);
				entries.add(BathroomBlocks.MIXED_BRICKS);
				entries.add(BathroomBlocks.MIXED_BRICKS_SLAB);
				entries.add(BathroomBlocks.MIXED_BRICK_STAIRS);
				entries.add(BathroomBlocks.INSULATION);
				entries.add(BathroomBlocks.INKY_COBBLESTONE);
				entries.add(BathroomBlocks.INKY_COBBLESTONE_SLAB);
				entries.add(BathroomBlocks.INKY_COBBLESTONE_STAIRS);
				entries.add(BathroomBlocks.INKY_MOSS_STONE);
				entries.add(BathroomBlocks.BLOCK_OF_GAMING);
				entries.add(BathroomBlocks.LAN_PARTY);
				entries.add(BathroomBlocks.YOPORE);
				entries.add(BathroomItems.YOPER);
				entries.add(BathroomItems.BOUNCY_BALL);
				entries.add(BathroomItems.BASKETBALL);
				entries.add(BathroomItems.FERTILIZER_BAG);
				entries.add(BathroomItems.GAMING);
				entries.add(BathroomItems.GAMER_GOOP);
				entries.add(BathroomItems.GAMERS_DELIGHT);
				entries.add(BathroomItems.SCRAN);
				entries.add(BathroomItems.RICKY_NOODLES);
				entries.add(BathroomItems.GUMMIES);
				entries.add(BathroomItems.WORMS_IN_DIRT);
				entries.add(BathroomItems.BATHROOM_CRITTER);
				entries.add(BathroomItems.SPLENDOR_CRITTER);
				entries.add(BathroomItems.GREASE_CRITTER);
				entries.add(BathroomItems.MUSHSPAWN);
				entries.add(BathroomItems.COMPACT_BALL_GOLEM);
				entries.add(BathroomItems.GAMER_GRUB);
				entries.add(BathroomItems.MUSHLET_SPAWN_EGG);
				entries.add(BathroomItems.PIG_CREEPER_SPAWN_EGG);
				entries.add(BathroomItems.CLANGOR_SPAWN_EGG);
				entries.add(BathroomItems.BALL_GOLEM_SPAWN_EGG);
				entries.add(BathroomItems.VIDEO_GAMER_SPAWN_EGG);
				entries.add(BathroomItems.MUSIC_DISC_YOPERSONG);
			})
			.build();

	public static void registerItemGroup() {
		Registry.register(Registries.ITEM_GROUP, new Identifier("bathroom", "bathroom_group"), ITEM_GROUP);
	}
}
