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
package top.spco.spongefactory.block.entity;

import cofh.lib.inventory.ItemStorageCoFH;
import cofh.thermal.core.config.ThermalCoreConfig;
import cofh.thermal.lib.block.entity.MachineBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.client.gui.MachineMagnetizerContainer;
import top.spco.spongefactory.recipe.manager.MagnetizerRecipeManager;
import top.spco.spongefactory.registries.SFBlockEntities;

import javax.annotation.Nullable;

import static cofh.lib.api.StorageGroup.*;

public class MachineMagnetizerTile extends MachineBlockEntity {
    protected ItemStorageCoFH inputSlot = new ItemStorageCoFH(item -> filter.valid(item) && MagnetizerRecipeManager.instance().validItem(item));
    protected ItemStorageCoFH outputSlot = new ItemStorageCoFH();

    public MachineMagnetizerTile(BlockPos pos, BlockState state) {
        super(SFBlockEntities.MAGNETIZER.get(), pos, state);
        inventory.addSlot(inputSlot, INPUT);
        inventory.addSlot(outputSlot, OUTPUT);
        inventory.addSlot(chargeSlot, INTERNAL);

        addAugmentSlots(ThermalCoreConfig.machineAugments);
        initHandlers();
    }

    @Override
    protected int getBaseProcessTick() {
        return MagnetizerRecipeManager.instance().getBasePower();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player) {
        return new MachineMagnetizerContainer(i, level, worldPosition, inventory, player);
    }

    @Override
    protected boolean cacheRecipe() {
        curRecipe = MagnetizerRecipeManager.instance().getRecipe(this);
        if (curRecipe != null) {
            itemInputCounts = curRecipe.getInputItemCounts(this);
        }
        return curRecipe != null;
    }
}