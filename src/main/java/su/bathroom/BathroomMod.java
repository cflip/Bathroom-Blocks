package su.bathroom;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import java.util.Arrays;


public class BathroomMod implements ModInitializer {
	public static final FoodComponent GUMMIES_FOOD = new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build();
	public static final FoodComponent WORMS_IN_DIRT_FOOD = new FoodComponent.Builder().hunger(7).saturationModifier(0.4f).build();

	public static final Block BATHROOM_TILES = new Block(FabricBlockSettings.of(Material.METAL).slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F));
	public static final Block RAW_BATHROOM = new Block(FabricBlockSettings.of(Material.METAL).slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F));
	public static final Block SLIPTILES = new Block(FabricBlockSettings.of(Material.METAL).slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F));
	public static final Block DARK_SLIPTILES = new Block(FabricBlockSettings.of(Material.METAL).slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F));
	public static final Block MIXED_SLIPTILES = new Block(FabricBlockSettings.of(Material.METAL).slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F));
	public static final Block SLIPBRICKS = new Block(FabricBlockSettings.of(Material.METAL).slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F));
	public static final Block DARK_SLIPBRICKS = new Block(FabricBlockSettings.of(Material.METAL).slipperiness(0.7f).requiresTool().strength(1.5F, 6.0F));
	public static final Block MIXED_BRICKS = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().strength(2F, 6.0F));
	public static final Block INKY_COBBLESTONE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(2F, 6.0F));
	public static final Block INKY_MOSS_STONE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().strength(2F, 6.0F));
	public static final Block INSULATION = new Block(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOL).strength(1.2F, 3.0F));

	public static final Item BATHROOM_CRITTER = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item SPLENDOR_CRITTER = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item GUMMIES = new Item(new FabricItemSettings().group(ItemGroup.FOOD).food(GUMMIES_FOOD));
	public static final Item WORMS_IN_DIRT = new StewItem(new FabricItemSettings().group(ItemGroup.FOOD).food(WORMS_IN_DIRT_FOOD));

	private static final ConfiguredFeature<?, ?> RAW_BATHROOM_FEATURE = new ConfiguredFeature(
			Feature.ORE,
			new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, RAW_BATHROOM.getDefaultState(), 32)
	);

	public static PlacedFeature RAW_BATHROOM_PLACED_FEATURE = new PlacedFeature(
			RegistryEntry.of(RAW_BATHROOM_FEATURE),
			Arrays.asList(
					CountPlacementModifier.of(1),
					HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))
			));

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "bathroom_tiles"), BATHROOM_TILES);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "bathroom_tiles"), new BlockItem(BATHROOM_TILES, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "raw_bathroom"), RAW_BATHROOM);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "raw_bathroom"), new BlockItem(RAW_BATHROOM, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "sliptiles"), SLIPTILES);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "sliptiles"), new BlockItem(SLIPTILES, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "dark_sliptiles"), DARK_SLIPTILES);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "dark_sliptiles"), new BlockItem(DARK_SLIPTILES, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "mixed_sliptiles"), MIXED_SLIPTILES);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "mixed_sliptiles"), new BlockItem(MIXED_SLIPTILES, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "slipbricks"), SLIPBRICKS);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "slipbricks"), new BlockItem(SLIPBRICKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "dark_slipbricks"), DARK_SLIPBRICKS);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "dark_slipbricks"), new BlockItem(DARK_SLIPBRICKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "mixed_bricks"), MIXED_BRICKS);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "mixed_bricks"), new BlockItem(MIXED_BRICKS, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "inky_cobblestone"), INKY_COBBLESTONE);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "inky_cobblestone"), new BlockItem(INKY_COBBLESTONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "inky_moss_stone"), INKY_MOSS_STONE);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "inky_moss_stone"), new BlockItem(INKY_MOSS_STONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
		Registry.register(Registry.BLOCK, new Identifier("bathroom", "insulation"), INSULATION);
		FlammableBlockRegistry.getDefaultInstance().add(INSULATION, 5, 5);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "insulation"), new BlockItem(INSULATION, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("bathroom", "bathroom_critter"), BATHROOM_CRITTER);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "splendor_critter"), SPLENDOR_CRITTER);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "gummies"), GUMMIES);
		Registry.register(Registry.ITEM, new Identifier("bathroom", "worms_in_dirt"), WORMS_IN_DIRT);


		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("bathroom", "raw_bathroom_gen"), RAW_BATHROOM_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("bathroom", "raw_bathroom_gen"), RAW_BATHROOM_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("bathroom", "raw_bathroom_gen")));
	}
}
