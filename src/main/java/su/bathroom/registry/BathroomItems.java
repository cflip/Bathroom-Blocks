package su.bathroom.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Util;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import su.bathroom.BathroomMod;
import su.bathroom.entity.BasketballEntity;
import su.bathroom.entity.BouncyBallEntity;
import su.bathroom.item.*;

public class BathroomItems {
	public static final Item BATHROOM_CRITTER = new Item(new Item.Settings());
	public static final Item SPLENDOR_CRITTER = new Item(new Item.Settings());
	public static final Item GREASE_CRITTER = new Item(new Item.Settings());
	public static final Item GAMING = new Item(new Item.Settings());
	public static final Item YOPER = new Item(new Item.Settings());
	public static final Item SCRAN = new Item(new FabricItemSettings().food(BathroomMod.SCRAN_FOOD));
	public static final Item GUMMIES = new Item(new FabricItemSettings().food(BathroomMod.GUMMIES_FOOD));
	public static final Item GAMER_GOOP = new Item(new FabricItemSettings().food(BathroomMod.GAMER_GOOP_FOOD));
	public static final Item WORMS_IN_DIRT = new StewItem(new FabricItemSettings().food(BathroomMod.WORMS_IN_DIRT_FOOD));
	public static final Item RICKY_NOODLES = new StewItem(new FabricItemSettings().food(BathroomMod.RICKY_NOODLES_FOOD));
	public static final Item MUSHSPAWN = new MushspawnItem(new Item.Settings());
	public static final Item MUSHLET_SPAWN_EGG = new SpawnEggItem(BathroomMod.MUSHLET_ENTITY, 0x00f15d, 0xffffff, new Item.Settings());
	public static final Item PIG_CREEPER_SPAWN_EGG = new SpawnEggItem(BathroomMod.PIG_CREEPER_ENTITY, 0xFF9B86, 0x503D39, new Item.Settings());
	public static final Item BALL_GOLEM_SPAWN_EGG = new SpawnEggItem(BathroomMod.BALL_GOLEM_ENTITY, 0xCD82D7, 0x894F91, new Item.Settings());
	public static final Item VIDEO_GAMER_SPAWN_EGG = new SpawnEggItem(BathroomMod.VIDEO_GAMER_ENTITY, 0xD7D3E1, 0x454152, new Item.Settings());

	public static final Item BOUNCY_BALL = new BouncyBallItem(new Item.Settings());
	public static final Item BASKETBALL = new BasketballItem(new Item.Settings());
	public static final Item FERTILIZER_BAG = new FertilizerBagItem(new Item.Settings().maxCount(1).maxDamage(16));
	public static final Item COMPACT_BALL_GOLEM = new CompactBallGolemItem(new Item.Settings());
	public static final Item GAMER_GRUB = new GamerGrubItem(new Item.Settings());

	public static final Identifier YOPERSONG_IDENTIFIER = new Identifier("bathroom", "yopersong");
	public static SoundEvent YOPERSONG = SoundEvent.of(YOPERSONG_IDENTIFIER);
	public static final Item MUSIC_DISC_YOPERSONG = new MusicDiscItem(3,YOPERSONG, (new Item.Settings()).maxCount(1).rarity(Rarity.RARE), 116);

	public static void registerItems() {
		Registry.register(Registries.ITEM, new Identifier("bathroom", "bathroom_critter"), BATHROOM_CRITTER);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "splendor_critter"), SPLENDOR_CRITTER);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "grease_critter"), GREASE_CRITTER);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "gaming"), GAMING);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "yoper"), YOPER);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "scran"), SCRAN);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "gummies"), GUMMIES);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "gamer_goop"), GAMER_GOOP);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "worms_in_dirt"), WORMS_IN_DIRT);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "ricky_noodles"), RICKY_NOODLES);

		Registry.register(Registries.ITEM, new Identifier("bathroom", "mushspawn"), MUSHSPAWN);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "mushlet_spawn_egg"), MUSHLET_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "pig_creeper_spawn_egg"), PIG_CREEPER_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "ball_golem_spawn_egg"), BALL_GOLEM_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "video_gamer_spawn_egg"), VIDEO_GAMER_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "bouncy_ball"), BOUNCY_BALL);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "basketball"), BASKETBALL);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "fertilizer_bag"), FERTILIZER_BAG);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "compact_ball_golem"), COMPACT_BALL_GOLEM);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "gamer_grub"), GAMER_GRUB);

		YOPERSONG = Registry.register(Registries.SOUND_EVENT, YOPERSONG_IDENTIFIER, YOPERSONG);
		Registry.register(Registries.ITEM, new Identifier("bathroom","music_disc_yopersong"),MUSIC_DISC_YOPERSONG);

		DispenserBlock.registerBehavior(BOUNCY_BALL, new ProjectileDispenserBehavior() {
			@Override
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				return Util.make(new BouncyBallEntity(BathroomMod.BOUNCY_BALL_ENTITY, world, position.getX(), position.getY(), position.getZ(), true), bouncyBallEntity -> bouncyBallEntity.setItem(stack));
			}
		});
		DispenserBlock.registerBehavior(BASKETBALL, new ProjectileDispenserBehavior() {
			@Override
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				return Util.make(new BasketballEntity(world, position.getX(), position.getY(), position.getZ(), true), basketballEntity -> basketballEntity.setItem(stack));
			}
		});
	}
}
