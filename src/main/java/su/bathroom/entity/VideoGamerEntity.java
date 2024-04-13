package su.bathroom.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.TimeHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import su.bathroom.registry.BathroomBlocks;
import su.bathroom.registry.BathroomItems;

import java.util.UUID;

public class VideoGamerEntity extends PassiveEntity {
    public int GoopLayTime;
    public VideoGamerEntity(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
    public EntityGroup getGroup() {
        return EntityGroup.ARTHROPOD;
    }
    public static DefaultAttributeContainer.Builder createVideoGamerAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.32).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0);
    }
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SILVERFISH_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SILVERFISH_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }
    public boolean hurtByWater() {
        return true;
    }
    protected void initGoals() {
        this.goalSelector.add(2, new AvoidSunlightGoal(this));
        this.goalSelector.add(3, new EscapeSunlightGoal(this, 1.0));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.add(3, new PounceAtTargetGoal(this, 0.5F));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(8, new LookAroundGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal(this, CowEntity.class, false));
    }
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos.down()).isOf(BathroomBlocks.LAN_PARTY) ? 10.0F : world.getPhototaxisFavor(pos);
    }
    public void tickMovement() {
        boolean bl = this.isAffectedByDaylight();
            if (bl) {
                this.setOnFireFor(8);
            }
        super.tickMovement();
        if (!this.getWorld().isClient && this.isAlive() && --this.GoopLayTime <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(BathroomItems.GAMER_GOOP);
            this.emitGameEvent(GameEvent.ENTITY_PLACE);
            this.GoopLayTime = this.random.nextInt(6000) + 6000;
        }
    }
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("GoopLayTime")) {
            this.GoopLayTime = nbt.getInt("GoopLayTime");
        }
    }
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("GoopLayTime", this.GoopLayTime);
    }

}
