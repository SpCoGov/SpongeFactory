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

import appeng.api.upgrades.Upgrades;
import appeng.core.definitions.AEItems;
import appeng.core.localization.GuiText;
import top.spco.spongefactory.registries.SFItems;

import java.util.List;

public class CellUpgrades {
    public static void init() {
        String storageCellGroup = GuiText.StorageCells.getTranslationKey();

        var itemCells = List.of(
                SFItems.SPONGE_ITEM_STORAGE_CELL_256K);
        for (var itemCell : itemCells) {
            Upgrades.add(AEItems.FUZZY_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.INVERTER_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, itemCell, 1, storageCellGroup);
            Upgrades.add(AEItems.VOID_CARD, itemCell, 1, storageCellGroup);
        }
    }
}