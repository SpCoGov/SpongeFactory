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
package top.spco.spongefactory.infrastructure.init;

import appeng.api.client.StorageCellModels;
import appeng.api.storage.StorageCells;
import net.minecraft.resources.ResourceLocation;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.cell.SpongeCellHandler;
import top.spco.spongefactory.registries.SFItems;

public class CellModels {
    private static final ResourceLocation MODEL_CELL_SPONGE = new ResourceLocation(SpongeFactory.MOD_ID,
            "block/drive/cells/sponge_item_cell");

    public static void init() {
        StorageCells.addCellHandler(SpongeCellHandler.INSTANCE);
        StorageCellModels.registerModel(SFItems.SPONGE_ITEM_STORAGE_CELL, MODEL_CELL_SPONGE);
    }
}