package su.bathroom;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.FoodComponent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import su.bathroom.entity.PigCreeperEntity;
import su.bathroom.registry.BathroomBlocks;
import su.bathroom.registry.BathroomItemGroup;
import su.bathroom.registry.BathroomItems;
import su.bathroom.registry.BathroomPaintings;

public class BathroomMod implements ModInitializer {
	public static final FoodComponent GUMMIES_FOOD = new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build();
	public static final FoodComponent WORMS_IN_DIRT_FOOD = new FoodComponent.Builder().hunger(7).saturationModifier(0.4f).build();

	public static EntityType<PigCreeperEntity> PIG_CREEPER_ENTITY;

	// LEAVE IT THE FUCK ALONE

	//private static final ConfiguredFeature<?, ?> RAW_BATHROOM_FEATURE = new ConfiguredFeature(
	//		Feature.ORE,
	//		new OreFeatureConfig(OreConfiguredFeatures.ORE_GRAVEL, BathroomBlocks.RAW_BATHROOM.getDefaultState(), 32)
	//);

	//public static PlacedFeature RAW_BATHROOM_PLACED_FEATURE = new PlacedFeature(
	//		RegistryEntry.of(RAW_BATHROOM_FEATURE),
	//		Arrays.asList(
	//				CountPlacementModifier.of(1),
	//				HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))
	//		));
	//private static final ConfiguredFeature<?, ?> YOPORE_FEATURE = new ConfiguredFeature(
	//		Feature.ORE,
	//		new OreFeatureConfig(OreConfiguredFeatures.ORE_GRAVEL_NETHER, 4, 6)
	//);
	//public static PlacedFeature YOPORE_PLACED_FEATURE = new PlacedFeature(
	//		RegistryEntry.of(YOPORE_FEATURE),
	//		Arrays.asList(
	//				CountPlacementModifier.of(1),
	//				HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(64))
	//		));

	@Override
	public void onInitialize() {
		PIG_CREEPER_ENTITY = Registry.register(Registries.ENTITY_TYPE, new Identifier("bathroom", "pig_creeper"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PigCreeperEntity::new).dimensions(new EntityDimensions(0.6F, 1.7F, true)).build());
		FabricDefaultAttributeRegistry.register(PIG_CREEPER_ENTITY, PigCreeperEntity.createCreeperAttributes());
		BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH), SpawnGroup.MONSTER, PIG_CREEPER_ENTITY, 1, 12, 20);

		BathroomBlocks.registerBlocks();
		BathroomItems.registerItems();
		BathroomItemGroup.registerItemGroup();
		BathroomPaintings.registerPaintings();
	}
}
