package net.hotdoguy90.colorblocks.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random; // <-- Use Mojang's Random
import net.minecraft.world.World;

public class ColorBlockBehavior extends Block {
    public static final IntProperty COLOR = IntProperty.of("color", 0, 15);

    public ColorBlockBehavior(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(COLOR, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (!world.isClient()) {
            world.scheduleBlockTick(pos, this, 1);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int receivedPower = world.getReceivedRedstonePower(pos);
        if (state.get(COLOR) != receivedPower) {
            world.setBlockState(pos, state.with(COLOR, receivedPower), Block.NOTIFY_ALL);
        }
    }
}