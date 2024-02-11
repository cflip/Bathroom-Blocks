package su.bathroom.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import su.bathroom.entity.BasketballEntity;
import su.bathroom.entity.BouncyBallEntity;

public class BasketballItem extends BouncyBallItem {
	public BasketballItem(Settings settings) {
		super(settings);
	}

	@Override
	protected float getThrowSpeed() {
		return 0.8f;
	}

	@Override
	protected BouncyBallEntity getThrownItem(World world, PlayerEntity user) {
		return new BasketballEntity(world, user, true);
	}
}
