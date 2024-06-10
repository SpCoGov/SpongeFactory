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
package top.spco.spongefactory.item;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UnplaceableBlockItem extends BlockItem {
    public UnplaceableBlockItem(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Override
    public @NotNull InteractionResult place(@NotNull BlockPlaceContext p_40577_) {
        return InteractionResult.PASS;
    }

    @Nullable
    @Override
    protected BlockState getPlacementState(@NotNull BlockPlaceContext p_40613_) {
        return null;
    }

    @Override
    protected boolean placeBlock(@NotNull BlockPlaceContext p_40578_, @NotNull BlockState p_40579_) {
        return false;
    }
}