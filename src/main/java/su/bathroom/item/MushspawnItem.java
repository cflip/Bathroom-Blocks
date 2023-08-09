package su.bathroom.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import su.bathroom.BathroomMod;

public class MushspawnItem extends Item {

    public MushspawnItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(Blocks.MYCELIUM)) {
            if (!world.isClient()) {
                BathroomMod.MUSHLET_ENTITY.spawnFromItemStack((ServerWorld) world, context.getStack(), context.getPlayer(), blockPos, SpawnReason.SPAWN_EGG, true, false);
                world.emitGameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockPos);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
