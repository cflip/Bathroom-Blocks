package su.bathroom.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
    public static final Block INKY_COBBLESTONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(2F, 6.0F));
    public static final Block INKY_MOSS_STONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(2F, 6.0F));
    public static final Block YOPORE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool().strength(3F, 3.0F));

    public static final Block INSULATION = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOL).strength(1.2F, 3.0F));


    public static void registerBlocks() {

        // Blocks and block item register
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "bathroom_tiles"), BATHROOM_TILES);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "bathroom_tiles"), new BlockItem(BATHROOM_TILES, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "raw_bathroom"), RAW_BATHROOM);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "raw_bathroom"), new BlockItem(RAW_BATHROOM, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "sliptiles"), SLIPTILES);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "sliptiles"), new BlockItem(SLIPTILES, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "dark_sliptiles"), DARK_SLIPTILES);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "dark_sliptiles"), new BlockItem(DARK_SLIPTILES, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "mixed_sliptiles"), MIXED_SLIPTILES);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "mixed_sliptiles"), new BlockItem(MIXED_SLIPTILES, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "slipbricks"), SLIPBRICKS);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "slipbricks"), new BlockItem(SLIPBRICKS, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "dark_slipbricks"), DARK_SLIPBRICKS);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "dark_slipbricks"), new BlockItem(DARK_SLIPBRICKS, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "mixed_bricks"), MIXED_BRICKS);
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "yopore"), YOPORE);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "yopore"), new BlockItem(YOPORE, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier("bathroom", "mixed_bricks"), new BlockItem(MIXED_BRICKS, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "inky_cobblestone"), INKY_COBBLESTONE);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "inky_cobblestone"), new BlockItem(INKY_COBBLESTONE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "inky_moss_stone"), INKY_MOSS_STONE);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "inky_moss_stone"), new BlockItem(INKY_MOSS_STONE, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("bathroom", "insulation"), INSULATION);
        FlammableBlockRegistry.getDefaultInstance().add(INSULATION, 5, 5);
        Registry.register(Registries.ITEM, new Identifier("bathroom", "insulation"), new BlockItem(INSULATION, new Item.Settings()));
    }
}
