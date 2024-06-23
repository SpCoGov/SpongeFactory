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
package top.spco.spongefactory.blocktype;

import mekanism.common.util.EnumUtils;
import mekanism.common.util.VoxelShapeUtils;
import net.minecraft.world.phys.shapes.VoxelShape;

import static mekanism.common.util.VoxelShapeUtils.setShape;
import static net.minecraft.world.level.block.Block.box;

public class SFBlockShapes {
    public static final VoxelShape[] FLUIDIZED_BED_REACTOR = new VoxelShape[EnumUtils.HORIZONTAL_DIRECTIONS.length];

    static {
        setShape(VoxelShapeUtils.combine(
                box(0, 0, 0, 16, 4, 16),
                box(12, 12, 3, 13, 13, 4),
                box(3, 12, 3, 4, 13, 4),
                box(7, 12, 7, 8, 13, 8),
                box(8, 12, 7, 9, 13, 8),
                box(0, 4, 8, 16, 16, 16),
                box(0, 4, 0, 16, 11, 7),
                box(4, 11, 0, 12, 16, 7),
                box(0, 11, 0, 3, 15, 7),
                box(13, 11, 0, 16, 15, 7),
                box(0, 4, 4, 1, 12, 12),
                box(15, 4, 4, 16, 12, 12)
        ), FLUIDIZED_BED_REACTOR);
    }
}