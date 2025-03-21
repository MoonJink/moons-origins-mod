package net.moonjink.moonsoriginsmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StaticBlock extends Block {
    private static final int lifespan = 20;
    public StaticBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void onPlace(BlockState pBlockState, Level pLevel, BlockPos pPos, BlockState pOldBlockState, boolean isMoving) {
        super.onPlace(pBlockState, pLevel, pPos, pOldBlockState, isMoving);

        if (!pLevel.isClientSide) {
            pLevel.scheduleTick(pPos, this, lifespan);
        }
    }

    public void tick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pPos, RandomSource random) {
        pServerLevel.setBlockAndUpdate(pPos, net.minecraft.world.level.block.Blocks.AIR.defaultBlockState());
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.INVISIBLE;
    }
}
