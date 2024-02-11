package su.bathroom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;
import su.bathroom.BathroomMod;
import su.bathroom.registry.BathroomItems;

public class BasketballEntity extends BouncyBallEntity {
    public BasketballEntity(EntityType<? extends BouncyBallEntity> entityType, World world) {
        super(entityType, world);
    }

    public BasketballEntity(World world, LivingEntity owner, boolean dropItem) {
        super(BathroomMod.BASKETBALL_ENTITY, world, owner, dropItem);
    }

    public BasketballEntity(World world, double x, double y, double z, boolean dropItem) {
        super(BathroomMod.BASKETBALL_ENTITY, world, x, y, z, dropItem);
    }

    @Override
    protected Item getDefaultItem() {
        return BathroomItems.BASKETBALL;
    }

    @Override
    protected ParticleEffect getParticleEffect() {
        return null;
    }

    @Override
    protected SoundEvent getSound() {
        return BathroomMod.BASKETBALL_BOUNCE_SOUND;
    }
}
