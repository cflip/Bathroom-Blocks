package su.bathroom.entity;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BallGolemEntity extends GolemEntity implements RangedAttackMob {
    public BallGolemEntity(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new ProjectileAttackGoal(this, 1.25, 20, 10.0F));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0, 1.0000001E-5F));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, MobEntity.class, 10, true, false, (entity) -> entity instanceof Monster));
    }

    public void attack(LivingEntity target, float pullProgress) {
        BouncyBallEntity bouncyBall = new BouncyBallEntity(this.getWorld(), this, false);
        double d = target.getEyeY() - 1.1;
        double e = target.getX() - this.getX();
        double f = d - bouncyBall.getY();
        double g = target.getZ() - this.getZ();
        double h = Math.sqrt(e * e + g * g) * 0.2;
        bouncyBall.setVelocity(e, f + h, g, 1.6F, 12.0F);
        this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.getWorld().spawnEntity(bouncyBall);
    }

    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 1.7F;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.BLOCK_GLASS_BREAK;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRON_GOLEM_DEATH;
    }
}
