package su.bathroom.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BathroomBlocks {
	public static final Block BATHROOM_TILES = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F));
	public static final Block RAW_BATHROOM = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F));
	public static final Block SLIPTILES = new Block(FabricBlockSettings.create().slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.METAL));
	public static final Block DARK_SLIPTILES = new Block(FabricBlockSettings.create().slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.METAL));
	public static final Block MIXED_SLIPTILES = new Block(FabricBlockSettings.create().slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.METAL));
	public static final Block SLIPBRICKS = new Block(FabricBlockSettings.create().slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.METAL));
	public static final Block DARK_SLIPBRICKS = new Block(FabricBlockSettings.create().slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F).sounds(BlockSoundGroup.METAL));
	public static final Block MIXED_BRICKS = new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).requiresTool().strength(2F, 6.0F));
	public static final SlabBlock MIXED_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).requiresTool().strength(2F, 6.0F));
	public static final Block INKY_COBBLESTONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(2F, 6.0F));
	public static final SlabBlock INKY_COBBLESTONE_SLAB = new SlabBlock(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(2F, 6.0F));
	public static final Block INKY_MOSS_STONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(2F, 6.0F));
	public static final Block YOPORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(3F, 3.0F));
	public static final Block INSULATION = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOL).strength(1.2F, 3.0F));

	public static void registerBlocks() {
		registerBlockWithItem("bathroom_tiles", BATHROOM_TILES);
		registerBlockWithItem("raw_bathroom", RAW_BATHROOM);
		registerBlockWithItem("sliptiles", SLIPTILES);
		registerBlockWithItem("dark_sliptiles", DARK_SLIPTILES);
		registerBlockWithItem("mixed_sliptiles", MIXED_SLIPTILES);
		registerBlockWithItem("slipbricks", SLIPBRICKS);
		registerBlockWithItem("dark_slipbricks", DARK_SLIPBRICKS);
		registerBlockWithItem("mixed_bricks", MIXED_BRICKS);
		registerBlockWithItem("mixed_bricks_slab", MIXED_BRICKS_SLAB);
		registerBlockWithItem("inky_cobblestone", INKY_COBBLESTONE);
		registerBlockWithItem("inky_cobblestone_slab", INKY_COBBLESTONE_SLAB);
		registerBlockWithItem("inky_moss_stone", INKY_MOSS_STONE);
		registerBlockWithItem("yopore", YOPORE);
		registerBlockWithItem("insulation", INSULATION);

		FlammableBlockRegistry.getDefaultInstance().add(INSULATION, 5, 5);
	}

	public static void registerBlockWithItem(String id, Block block) {
		Registry.register(Registries.BLOCK, new Identifier("bathroom", id), block);
		Registry.register(Registries.ITEM, new Identifier("bathroom", id), new BlockItem(block, new Item.Settings()));
	}
}
