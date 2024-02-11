package su.bathroom.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import su.bathroom.BathroomMod;
import su.bathroom.registry.BathroomItems;

public class BasketballEntity extends BouncyBallEntity {
    public BasketballEntity(World world, double x, double y, double z, boolean dropItem) {
        super(BathroomMod.BASKETBALL_ENTITY, world, x, y, z, dropItem);
    }
    public BasketballEntity(EntityType<? extends BouncyBallEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected Item getDefaultItem() {
        return BathroomItems.BASKETBALL;
    }

}
