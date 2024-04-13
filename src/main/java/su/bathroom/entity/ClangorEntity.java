package su.bathroom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ClangorEntity extends CreeperEntity {
    public ClangorEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
}
