package cx.rain.mc.vanillacream.block;

import com.mojang.serialization.MapCodec;
import cx.rain.mc.vanillacream.registry.ModBlocks;
import cx.rain.mc.vanillacream.util.HitHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class RedstonePumpkinLanternBlock extends CarvedPumpkinBlock {
    public static final MapCodec<RedstonePumpkinLanternBlock> CODEC = simpleCodec(RedstonePumpkinLanternBlock::new);
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public static final double MAX_DISTANCE = 20;   // Same as Debug screen.
    public static final double MAX_DISTANCE_SQUARED = MAX_DISTANCE * MAX_DISTANCE;

    public RedstonePumpkinLanternBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, false));
    }

    @Override
    public MapCodec<? extends RedstonePumpkinLanternBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(POWERED, false);
    }

    @Override
    protected boolean isSignalSource(BlockState state) {
        return true;
    }

    @Override
    protected int getSignal(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);

        var players = level.getEntities(EntityType.PLAYER, e -> e.distanceToSqr(pos.getCenter()) < MAX_DISTANCE_SQUARED);
        var someoneStillLooking = false;
        for (var player : players) {
            var blockHitResult = HitHelper.pickBlockFromSight(level, player, MAX_DISTANCE);
            if (blockHitResult == null) {
                continue;
            }

            if (!blockHitResult.getBlockPos().equals(pos)) {
                continue;
            }

            var facing = state.getValue(FACING);
            if (blockHitResult.getDirection() != facing) {
                continue;
            }

            someoneStillLooking = true;
        }

        if (someoneStillLooking) {
            scheduleNextTick(level, pos);
        } else {
            onLostSight(level, state, pos);
        }
    }

    private static void scheduleNextTick(ServerLevel level, BlockPos pos) {
        if (!level.getBlockTicks().willTickThisTick(pos, ModBlocks.REDSTONE_JACK_O_LANTERN.get())) {
            level.scheduleTick(pos, ModBlocks.REDSTONE_JACK_O_LANTERN.get(), 1);
        }
    }

    private static void onGotSight(ServerLevel level, BlockState state, BlockPos pos) {
        if (!state.getValue(POWERED)) {
            level.setBlock(pos, state.setValue(POWERED, true), Block.UPDATE_ALL);
        }
        scheduleNextTick(level, pos);
    }

    private static void onLostSight(ServerLevel level, BlockState state, BlockPos pos) {
        if (state.getValue(POWERED)) {
            level.setBlock(pos, state.setValue(POWERED, false), Block.UPDATE_ALL);
        }
    }

    public static void playerTick(ServerPlayer player, ServerLevel level) {
        var blockHitResult = HitHelper.pickBlockFromSight(level, player, MAX_DISTANCE);
        if (blockHitResult == null) {
            return;
        }

        var pos = blockHitResult.getBlockPos();
        var state = level.getBlockState(pos);
        if (state.getBlock() != ModBlocks.REDSTONE_JACK_O_LANTERN.get()) {
            return;
        }

        var blockFacing = state.getValue(FACING);
        if (blockFacing == blockHitResult.getDirection()) {
            RedstonePumpkinLanternBlock.onGotSight(level, state, pos);
        }
    }
}
