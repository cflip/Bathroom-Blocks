package su.bathroom.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import su.bathroom.BathroomMod;
import su.bathroom.entity.BallGolemEntity;
import su.bathroom.entity.VideoGamerEntity;

public class GamerGrubItem extends Item {

    public GamerGrubItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (!world.isClient()) {
            ServerWorld serverWorld = (ServerWorld) world;
            ItemStack stack = context.getStack();
            PlayerEntity player = context.getPlayer();

            VideoGamerEntity video_gamer = BathroomMod.VIDEO_GAMER_ENTITY.create(serverWorld, stack.getNbt(), EntityType.copier(serverWorld, stack, player), blockPos, SpawnReason.SPAWN_EGG, true, false);
            if (video_gamer != null) {
                world.spawnEntity(video_gamer);
                if (player != null && !player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}