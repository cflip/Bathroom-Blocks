package su.bathroom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import su.bathroom.BathroomMod;
import su.bathroom.registry.BathroomItems;

public class BouncyBallEntity extends ThrownItemEntity {
    private static final float RESTITUTION = 0.90f;    // How much velocity the ball retains when it bounces off a surface
    private static final float DEATH_VELOCITY = 0.01f; // The velocity at which this entity turns into an item
    private static final int IMPACT_FIRE_SECONDS = 8;  // How long entities hit by a burning ball will be set on fire for

    public BouncyBallEntity(EntityType<? extends BouncyBallEntity> entityType, World world) {
        super(entityType, world);
    }

    public BouncyBallEntity(World world, LivingEntity owner) {
        super(BathroomMod.BOUNCY_BALL_ENTITY, owner, world);
    }

    public BouncyBallEntity(World world, double x, double y, double z) {
        super(BathroomMod.BOUNCY_BALL_ENTITY, x, y, z, world);
    }

    @Override
    public void tick() {
        super.tick();
        World world = getWorld();
        if (getVelocity().length() < DEATH_VELOCITY && !world.isClient()) {
            ItemEntity itemEntity = new ItemEntity(world, getX(), getY(), getZ(), getDefaultItem().getDefaultStack());
            world.spawnEntity(itemEntity);
            world.sendEntityStatus(this, (byte)3);
            discard();
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);

        // Compute the reflection over the block face's plane
        // r = a - 2(a . n)n
        Vec3d a = getVelocity();
        Vec3d n = Vec3d.of(blockHitResult.getSide().getVector());
        Vec3d r = a.subtract(n.multiply(2 * a.dotProduct(n)));

        setVelocity(r.multiply(RESTITUTION));
        doCollisionFX();
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        // EntityHitResult contains no information on where on the entity the ball
        // hit, so we'll just simply invert the velocity
        setVelocity(getVelocity().multiply(-RESTITUTION));
        if (isOnFire())
            entityHitResult.getEntity().setOnFireFor(IMPACT_FIRE_SECONDS);
        doCollisionFX();
    }

    protected void doCollisionFX() {
        World world = getWorld();
        for (int i = 0; i < 8; i++) {
            float angle = this.random.nextFloat() * 2 * MathHelper.PI;
            float spread = 0.4f;
            float spreadX = MathHelper.sin(angle) * spread;
            float spreadZ = MathHelper.cos(angle) * spread;
            world.addParticle(getParticleEffect(), getX() + spreadX, getY(), getZ() + spreadZ, 0.0f, 0.0f, 0.0f);
        }
        world.playSound(null, getX(), getY(), getZ(), SoundEvents.ENTITY_SLIME_JUMP_SMALL, SoundCategory.NEUTRAL, 3.0f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
    }

    protected ParticleEffect getParticleEffect() {
        return ParticleTypes.ITEM_SLIME;
    }

    @Override
    protected Item getDefaultItem() {
        return BathroomItems.BOUNCY_BALL;
    }
}
