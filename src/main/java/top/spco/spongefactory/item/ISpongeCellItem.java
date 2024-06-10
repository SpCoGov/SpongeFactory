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

import appeng.api.stacks.AEKey;
import appeng.api.stacks.AEKeyType;
import appeng.api.storage.cells.ICellWorkbenchItem;
import com.google.common.base.Preconditions;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import top.spco.spongefactory.cell.SpongeCellHandler;

import java.util.List;
import java.util.Optional;

public interface ISpongeCellItem extends ICellWorkbenchItem {
    /**
     * Basic cell items are limited to a single {@link AEKeyType}.
     */
    AEKeyType getKeyType();

    /**
     * The number of bytes that can be stored on this type of storage cell.
     * <p/>
     * It wont work if the return is not a multiple of 8. The limit is ({@link Integer#MAX_VALUE} + 1) / 8.
     *
     * @param cellItem item
     * @return number of bytes
     */
    int getBytes(ItemStack cellItem);

    /**
     * Determines the number of bytes used for any type included on the cell.
     *
     * @param cellItem item
     * @return number of bytes
     */
    int getBytesPerType(ItemStack cellItem);

    /**
     * Allows you to fine tune which items are allowed on a given cell, if you don't care, just return false; As the
     * handler for this type of cell is still the default cells, the normal AE black list is also applied.
     *
     * @param cellItem          item
     * @param requestedAddition requested addition
     * @return true to preventAdditionOfItem
     */
    default boolean isBlackListed(ItemStack cellItem, AEKey requestedAddition) {
        return false;
    }

    /**
     * Allows you to specify if this storage cell can be stored inside other storage cells, only set this for special
     * items like the matter cannon that are not general purpose storage.
     *
     * @return true if the storage cell can be stored inside other storage cells, this is generally false, except for
     *         certain situations such as the matter cannon.
     */
    default boolean storableInStorageCell() {
        return false;
    }

    /**
     * Allows an item to selectively enable or disable its status as a storage cell.
     *
     * @param i item
     * @return if the ItemStack should currently be usable as a storage cell.
     */
    default boolean isStorageCell(ItemStack i) {
        return true;
    }

    /**
     * @return drain in ae/t this storage cell will use.
     */
    double getIdleDrain();

    default void addCellInformationToTooltip(ItemStack is, List<Component> lines) {
        Preconditions.checkArgument(is.getItem() == this);
        SpongeCellHandler.INSTANCE.addCellInformationToTooltip(is, lines);
    }

    /**
     * Helper to get the additional tooltip image line showing the content/filter/upgrades.
     */
    default Optional<TooltipComponent> getCellTooltipImage(ItemStack is) {
        Preconditions.checkArgument(is.getItem() == this);
        return SpongeCellHandler.INSTANCE.getTooltipImage(is);
    }
}