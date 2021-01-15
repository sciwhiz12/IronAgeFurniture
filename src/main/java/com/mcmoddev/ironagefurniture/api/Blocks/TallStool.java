package com.mcmoddev.ironagefurniture.api.Blocks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mcmoddev.ironagefurniture.api.entity.Seat;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.World;

public class TallStool extends Chair {

	public TallStool(float hardness, float blastResistance, SoundType sound, String name) {
		super(hardness, blastResistance, sound, name);
	}
	
	 @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult)
    {
        return Seat.create(world, pos, 0.6, player);
    }
	
	@Override
	protected void generateShapes(ImmutableList<BlockState> states)
    {
        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
        	VoxelShape shapes = VoxelShapes.empty();
        
    		// tall stool body
        	shapes = VoxelShapes.combine(shapes, getShapes(rotate(Block.makeCuboidShape(3, 12, 3, 13, 13, 13), Direction.SOUTH))[state.get(DIRECTION).getHorizontalIndex()], IBooleanFunction.OR); // chair base
        	
        	//tall stool legs
        	shapes = VoxelShapes.combine(shapes, getShapes(rotate(Block.makeCuboidShape(7, 0, 11, 9, 12, 12), Direction.SOUTH))[state.get(DIRECTION).getHorizontalIndex()], IBooleanFunction.OR); 
            shapes = VoxelShapes.combine(shapes, getShapes(rotate(Block.makeCuboidShape(10, 0, 5, 13, 12, 8), Direction.SOUTH))[state.get(DIRECTION).getHorizontalIndex()], IBooleanFunction.OR); 
            shapes = VoxelShapes.combine(shapes, getShapes(rotate(Block.makeCuboidShape(4, 0, 5,6, 12, 8), Direction.SOUTH))[state.get(DIRECTION).getHorizontalIndex()], IBooleanFunction.OR); 
        	
            builder.put(state, shapes.simplify());
        }
        
        _shapes = builder.build();
    }
}
