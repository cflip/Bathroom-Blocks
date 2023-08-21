package su.bathroom.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.StewItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import su.bathroom.BathroomMod;
import su.bathroom.entity.BouncyBallEntity;
import su.bathroom.item.BouncyBallItem;
import su.bathroom.item.FertilizerBagItem;
import su.bathroom.item.MushspawnItem;

public class BathroomItems {
	public static final Item BATHROOM_CRITTER = new Item(new Item.Settings());
	public static final Item SPLENDOR_CRITTER = new Item(new Item.Settings());
	public static final Item YOPER = new Item(new Item.Settings());
	public static final Item GUMMIES = new Item(new FabricItemSettings().food(BathroomMod.GUMMIES_FOOD));
	public static final Item WORMS_IN_DIRT = new StewItem(new FabricItemSettings().food(BathroomMod.WORMS_IN_DIRT_FOOD));
	public static final Item MUSHSPAWN = new MushspawnItem(new Item.Settings());
	public static final Item MUSHLET_SPAWN_EGG = new SpawnEggItem(BathroomMod.MUSHLET_ENTITY, 0x00f15d, 0xffffff, new Item.Settings());
	public static final Item PIG_CREEPER_SPAWN_EGG = new SpawnEggItem(BathroomMod.PIG_CREEPER_ENTITY, 0xFF9B86, 0x503D39, new Item.Settings());
	public static final Item BOUNCY_BALL = new BouncyBallItem(new Item.Settings());
	public static final Item FERTILIZER_BAG = new FertilizerBagItem(new Item.Settings().maxCount(1).maxDamage(16));

	public static void registerItems() {
		Registry.register(Registries.ITEM, new Identifier("bathroom", "bathroom_critter"), BATHROOM_CRITTER);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "splendor_critter"), SPLENDOR_CRITTER);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "yoper"), YOPER);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "gummies"), GUMMIES);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "worms_in_dirt"), WORMS_IN_DIRT);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "mushspawn"), MUSHSPAWN);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "mushlet_spawn_egg"), MUSHLET_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "pig_creeper_spawn_egg"), PIG_CREEPER_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "bouncy_ball"), BOUNCY_BALL);
		Registry.register(Registries.ITEM, new Identifier("bathroom", "fertilizer_bag"), FERTILIZER_BAG);

		DispenserBlock.registerBehavior(BOUNCY_BALL, new ProjectileDispenserBehavior() {
			@Override
			protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
				return Util.make(new BouncyBallEntity(world, position.getX(), position.getY(), position.getZ(), true), bouncyBallEntity -> bouncyBallEntity.setItem(stack));
			}
		});
	}
}
