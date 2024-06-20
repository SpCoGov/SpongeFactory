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
package top.spco.spongefactory.client.jei.category;

import com.mojang.blaze3d.vertex.PoseStack;
import mekanism.api.chemical.gas.GasStack;
import mekanism.client.gui.element.gauge.GaugeType;
import mekanism.client.gui.element.gauge.GuiGasGauge;
import mekanism.client.gui.element.gauge.GuiGauge;
import mekanism.client.gui.element.progress.ProgressType;
import mekanism.client.gui.element.slot.GuiSlot;
import mekanism.client.gui.element.slot.SlotType;
import mekanism.client.jei.BaseRecipeCategory;
import mekanism.client.jei.MekanismJEI;
import mekanism.client.jei.MekanismJEIRecipeType;
import mekanism.common.inventory.container.slot.SlotOverlay;
import mekanism.common.tile.component.config.DataType;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.recipe.FluidizedBedRecipe;
import top.spco.spongefactory.registries.SFBlocks;

import java.util.ArrayList;
import java.util.List;

public class FluidizedBedReactorCategory extends BaseRecipeCategory<FluidizedBedRecipe> {
    private static final String OUTPUT_GAS = "outputGas";
    private final GuiGauge<?> inputGas;
    private final GuiSlot outputItem;
    private final GuiGauge<?> outputGas;

    public FluidizedBedReactorCategory(IGuiHelper helper, MekanismJEIRecipeType<FluidizedBedRecipe> recipeType) {
        super(helper, recipeType, SFBlocks.FLUIDIZED_BED_REACTOR.toMekRegistryObject(), 6, 13, 168, 60);
        addSlot(SlotType.INPUT, 8, 56).with(SlotOverlay.MINUS);
        addSlot(SlotType.OUTPUT, 155, 56).with(SlotOverlay.PLUS);
        outputItem = addSlot(SlotType.OUTPUT, 110, 35);
        inputGas = addElement(GuiGasGauge.getDummy(GaugeType.STANDARD.with(DataType.INPUT), this, 28, 13));
        outputGas = addElement(GuiGasGauge.getDummy(GaugeType.STANDARD.with(DataType.OUTPUT), this, 133, 13));
        addConstantProgress(ProgressType.RIGHT, 62, 38);
    }

    @Override
    public void draw(@NotNull FluidizedBedRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull PoseStack matrix, double mouseX, double mouseY) {
        super.draw(recipe, recipeSlotsView, matrix, mouseX, mouseY);
        if (recipeSlotsView.findSlotByName(OUTPUT_GAS).isEmpty()) {
            //If we don't have an output gas at all for this recipe, draw the bar overlay manually
            outputGas.drawBarOverlay(matrix);
        }
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull FluidizedBedRecipe recipe, @NotNull IFocusGroup focusGroup) {
        initChemical(builder, MekanismJEI.TYPE_GAS, RecipeIngredientRole.INPUT, inputGas, recipe.getInputGas().getRepresentations());
        List<ItemStack> itemOutputs = new ArrayList<>();
        List<GasStack> gasOutputs = new ArrayList<>();
        for (var output : recipe.getOutputDefinition()) {
            itemOutputs.add(output.item());
            gasOutputs.add(output.gas());
        }
        if (!itemOutputs.stream().allMatch(ItemStack::isEmpty)) {
            initItem(builder, RecipeIngredientRole.OUTPUT, outputItem, itemOutputs);
        }
        if (!gasOutputs.stream().allMatch(GasStack::isEmpty)) {
            initChemical(builder, MekanismJEI.TYPE_GAS, RecipeIngredientRole.OUTPUT, outputGas, gasOutputs)
                    .setSlotName(OUTPUT_GAS);
        }
    }
}