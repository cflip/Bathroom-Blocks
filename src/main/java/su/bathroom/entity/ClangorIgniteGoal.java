//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package su.bathroom.entity;

import java.util.EnumSet;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.Goal.Control;
import net.minecraft.entity.mob.CreeperEntity;
import org.jetbrains.annotations.Nullable;
import su.bathroom.entity.ClangorEntity;

public class ClangorIgniteGoal extends Goal {
    private final ClangorEntity clangor;
    @Nullable
    private LivingEntity target;

    public ClangorIgniteGoal(ClangorEntity clangor) {
        this.clangor = clangor;
        this.setControls(EnumSet.of(Control.MOVE));
    }

    public boolean canStart() {
        LivingEntity livingEntity = this.clangor.getTarget();
        return this.clangor.getFuseSpeed() > 0 || livingEntity != null && this.clangor.squaredDistanceTo(livingEntity) < 9.0;
    }

    public void start() {
        this.clangor.getNavigation().stop();
        this.target = this.clangor.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean shouldRunEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.clangor.setFuseSpeed(-1);
        } else if (this.clangor.squaredDistanceTo(this.target) > 49.0) {
            this.clangor.setFuseSpeed(-1);
        } else if (!this.clangor.getVisibilityCache().canSee(this.target)) {
            this.clangor.setFuseSpeed(-1);
        } else {
            this.clangor.setFuseSpeed(1);
        }
    }
}
