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
package top.spco.spongefactory.client.gui;

import com.mojang.blaze3d.vertex.PoseStack;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.client.gui.GuiConfigurableTile;
import mekanism.client.gui.element.bar.GuiHorizontalPowerBar;
import mekanism.client.gui.element.gauge.GaugeType;
import mekanism.client.gui.element.gauge.GuiGasGauge;
import mekanism.client.gui.element.progress.GuiProgress;
import mekanism.client.gui.element.progress.ProgressType;
import mekanism.client.gui.element.tab.GuiEnergyTab;
import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.inventory.warning.WarningTracker;
import mekanism.common.tile.machine.TileEntityPressurizedReactionChamber;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.block.entity.TileEntityFluidizedBedReactor;

public class FluidizedBedReactorGui extends GuiConfigurableTile<TileEntityFluidizedBedReactor, MekanismTileContainer<TileEntityFluidizedBedReactor>> {
    public FluidizedBedReactorGui(MekanismTileContainer<TileEntityFluidizedBedReactor> container, Inventory inv, Component title) {
        super(container, inv, title);
        inventoryLabelY += 2;
        titleLabelY = 4;
        dynamicSlots = true;
    }

    @Override
    protected void addGuiElements() {
        super.addGuiElements();
        addRenderableWidget(new GuiEnergyTab(this, tile.getEnergyContainer(), tile::getActive));
        addRenderableWidget(new GuiGasGauge(() -> tile.inputGasTank, () -> tile.getGasTanks(null), GaugeType.STANDARD, this, 28, 13)
                .warning(WarningTracker.WarningType.NO_MATCHING_RECIPE, tile.getWarningCheck(TileEntityPressurizedReactionChamber.NOT_ENOUGH_GAS_INPUT_ERROR)));
        addRenderableWidget(new GuiGasGauge(() -> tile.outputGasTank, () -> tile.getGasTanks(null), GaugeType.STANDARD, this, 130, 13)
                .warning(WarningTracker.WarningType.NO_SPACE_IN_OUTPUT, tile.getWarningCheck(TileEntityPressurizedReactionChamber.NOT_ENOUGH_SPACE_GAS_OUTPUT_ERROR)));
        addRenderableWidget(new GuiHorizontalPowerBar(this,  tile.getEnergyContainer(), 115, 75)
                .warning(WarningTracker.WarningType.NOT_ENOUGH_ENERGY, tile.getWarningCheck(CachedRecipe.OperationTracker.RecipeError.NOT_ENOUGH_ENERGY)));
        addRenderableWidget(new GuiProgress(tile::getScaledProgress, ProgressType.RIGHT, this, 60, 38).jeiCategory(tile))
                .warning(WarningTracker.WarningType.INPUT_DOESNT_PRODUCE_OUTPUT, tile.getWarningCheck(CachedRecipe.OperationTracker.RecipeError.INPUT_DOESNT_PRODUCE_OUTPUT));
    }

    @Override
    protected void drawForegroundText(@NotNull PoseStack matrix, int mouseX, int mouseY) {
        renderTitleText(matrix);
        drawString(matrix, playerInventoryTitle, inventoryLabelX, inventoryLabelY, titleTextColor());
        super.drawForegroundText(matrix, mouseX, mouseY);
    }
}