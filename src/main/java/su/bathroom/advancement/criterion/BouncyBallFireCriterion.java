package su.bathroom.advancement.criterion;

import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class BouncyBallFireCriterion extends AbstractCriterion<BouncyBallFireCriterion.Conditions> {
    public static final Identifier ID = new Identifier("bathroom", "bouncy_ball_fire");

    @Override
    protected Conditions conditionsFromJson(JsonObject obj, LootContextPredicate playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        return new Conditions(playerPredicate);
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player) {
        trigger(player, conditions -> true);
    }

    public static class Conditions extends AbstractCriterionConditions {
        public Conditions(LootContextPredicate entity) {
            super(ID, entity);
        }

        @Override
        public Identifier getId() {
            return ID;
        }
    }
}
