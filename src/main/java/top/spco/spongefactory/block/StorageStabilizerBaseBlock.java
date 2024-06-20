/*
 * Copyright 2024 SpCo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package top.spco.spongefactory.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class StorageStabilizerBaseBlock extends Block {
    private static final Map<Direction, VoxelShape> SHAPES = Maps.newEnumMap(
            ImmutableMap.<Direction, VoxelShape>builder()
                    .put(Direction.EAST, Shapes.create(new AABB(0, 0, 0, 0.3, 1, 1)))
                    .put(Direction.WEST, Shapes.create(new AABB(0.7, 0, 0, 1, 1, 1)))
                    .put(Direction.NORTH, Shapes.create(new AABB(0, 0, 0.7, 1, 1, 1)))
                    .put(Direction.SOUTH, Shapes.create(new AABB(0, 0, 0, 1, 1, 0.3)))
                    .put(Direction.UP, Shapes.create(new AABB(0, 0, 0, 1, 0.3, 1)))
                    .put(Direction.DOWN, Shapes.create(new AABB(0, 0.7, 0, 1, 1, 1))).build());

    public StorageStabilizerBaseBlock(Properties properties) {
        super(properties);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isPathfindable(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull PathComputationType pType) {
        return super.isPathfindable(pState, pLevel, pPos, pType);
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPES.get(state.getValue(BlockStateProperties.FACING));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(BlockStateProperties.FACING, context.getClickedFace());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
        super.createBlockStateDefinition(builder);
    }
}