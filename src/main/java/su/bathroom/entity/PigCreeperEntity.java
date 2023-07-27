package su.bathroom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class PigCreeperEntity extends CreeperEntity {

	public PigCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
		super.dropEquipment(source, lootingMultiplier, allowDrops);
		dropStack(new ItemStack(Items.PORKCHOP, 12));
	}
}
