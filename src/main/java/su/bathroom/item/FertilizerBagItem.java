package su.bathroom.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DeadCoralWallFanBlock;
import net.minecraft.block.Fertilizable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nullable;

public class FertilizerBagItem extends Item {
    public FertilizerBagItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        if (this.useOnFertilizable(context.getStack(), world, pos, player)) {
            if (world.isClient())
                world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, pos, 0);
            return ActionResult.SUCCESS;
        } else {
            BlockState blockState = world.getBlockState(pos);
            Direction side = context.getSide();

            boolean isSquareFace = blockState.isSideSolidFullSquare(world, pos, side);
            BlockPos nextPos = pos.offset(side);
            if (isSquareFace && useOnGround(context.getStack(), world, nextPos, player, side)) {
                if (!world.isClient())
                    world.syncWorldEvent(WorldEvents.BONE_MEAL_USED, pos, 0);
                return ActionResult.success(world.isClient());
            }
        }
        return ActionResult.PASS;
    }

    private boolean useOnFertilizable(ItemStack stack, World world, BlockPos pos, PlayerEntity player) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.getBlock() instanceof Fertilizable fertilizable && fertilizable.isFertilizable(world, pos, blockState, world.isClient())) {
            if (world instanceof ServerWorld) {
                fertilizable.grow((ServerWorld) world, world.random, pos, blockState);
                stack.damage(1, player, player1 -> stack.decrement(1));
            }
            return true;
        }
        return false;
    }

    // Copy+pasted from bone meal code, but cleaned up and damages the item instead of using it up
    private boolean useOnGround(ItemStack stack, World world, BlockPos blockPos, PlayerEntity player, @Nullable Direction facing) {
        if (world.getBlockState(blockPos).isOf(Blocks.WATER) && world.getFluidState(blockPos).getLevel() == 8) {
            if (world instanceof ServerWorld) {
                Random random = world.getRandom();

                outerLoop:
                for (int i = 0; i < 128; ++i) {
                    BlockPos blockPos2 = blockPos;
                    BlockState blockState = Blocks.SEAGRASS.getDefaultState();

                    for (int j = 0; j < i / 16; ++j) {
                        blockPos2 = blockPos2.add(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                        if (world.getBlockState(blockPos2).isFullCube(world, blockPos2)) {
                            continue outerLoop;
                        }
                    }

                    RegistryEntry<Biome> registryEntry = world.getBiome(blockPos2);
                    if (registryEntry.isIn(BiomeTags.PRODUCES_CORALS_FROM_BONEMEAL)) {
                        if (i == 0 && facing != null && facing.getAxis().isHorizontal()) {
                            blockState = Registries.BLOCK.getEntryList(BlockTags.WALL_CORALS)
                                    .flatMap((blocks) -> blocks.getRandom(world.random))
                                    .map((blockEntry) -> blockEntry.value().getDefaultState())
                                    .orElse(blockState);
                            if (blockState.contains(DeadCoralWallFanBlock.FACING))
                                blockState = blockState.with(DeadCoralWallFanBlock.FACING, facing);
                        } else if (random.nextInt(4) == 0) {
                            blockState = Registries.BLOCK.getEntryList(BlockTags.UNDERWATER_BONEMEALS)
                                    .flatMap((blocks) -> blocks.getRandom(world.random))
                                    .map((blockEntry) -> blockEntry.value().getDefaultState())
                                    .orElse(blockState);
                        }
                    }

                    if (blockState.isIn(BlockTags.WALL_CORALS, (state) -> state.contains(DeadCoralWallFanBlock.FACING))) {
                        for (int k = 0; !blockState.canPlaceAt(world, blockPos2) && k < 4; ++k) {
                            blockState = blockState.with(DeadCoralWallFanBlock.FACING, Direction.Type.HORIZONTAL.random(random));
                        }
                    }

                    if (blockState.canPlaceAt(world, blockPos2)) {
                        BlockState blockState2 = world.getBlockState(blockPos2);
                        if (blockState2.isOf(Blocks.WATER) && world.getFluidState(blockPos2).getLevel() == 8) {
                            world.setBlockState(blockPos2, blockState, 3);
                        } else if (blockState2.isOf(Blocks.SEAGRASS) && random.nextInt(10) == 0) {
                            ((Fertilizable) Blocks.SEAGRASS).grow((ServerWorld) world, random, blockPos2, blockState2);
                        }
                    }
                }
                stack.damage(1, player, playerEntity -> stack.decrement(1));
            }
            return true;
        }
        return false;
    }
}
