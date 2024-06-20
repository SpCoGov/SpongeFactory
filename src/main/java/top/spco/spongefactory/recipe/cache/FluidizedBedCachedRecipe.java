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
package top.spco.spongefactory.recipe.cache;

import mekanism.api.chemical.gas.GasStack;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.api.recipes.inputs.IInputHandler;
import mekanism.api.recipes.outputs.IOutputHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.spco.spongefactory.recipe.FluidizedBedRecipe;
import top.spco.spongefactory.recipe.FluidizedBedRecipe.FluidizedBedRecipeOutput;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class FluidizedBedCachedRecipe extends CachedRecipe<FluidizedBedRecipe> {
    private final IOutputHandler<@NotNull FluidizedBedRecipeOutput> outputHandler;
    private final IInputHandler<@NotNull GasStack> gasInputHandler;

    private GasStack recipeGas = GasStack.EMPTY;
    @Nullable
    private FluidizedBedRecipeOutput output;

    /**
     * @param recipe           Recipe.
     * @param recheckAllErrors Returns {@code true} if processing should be continued even if an error is hit in order to gather all the errors. It is recommended to not
     *                         do this every tick or if there is no one viewing recipes.
     */
    public FluidizedBedCachedRecipe(FluidizedBedRecipe recipe, BooleanSupplier recheckAllErrors, IInputHandler<@NotNull GasStack> gasInputHandler,
                                    IOutputHandler<@NotNull FluidizedBedRecipeOutput> outputHandler) {
        super(recipe, recheckAllErrors);
        this.gasInputHandler = Objects.requireNonNull(gasInputHandler, "Gas input handler cannot be null.");
        this.outputHandler = Objects.requireNonNull(outputHandler, "Output handler cannot be null.");
    }

    @Override
    protected void calculateOperationsThisTick(@NotNull OperationTracker tracker) {
        super.calculateOperationsThisTick(tracker);
        if (tracker.shouldContinueChecking()) {
            recipeGas = gasInputHandler.getRecipeInput(recipe.getInputGas());
            if (recipeGas.isEmpty()) {
                //No input, we don't know if the recipe matches or not so treat it as not matching
                tracker.mismatchedRecipe();
            } else {
                gasInputHandler.calculateOperationsCanSupport(tracker, recipeGas);
                if (tracker.shouldContinueChecking()) {
                    output = recipe.getOutput(recipeGas);
                    //Calculate the max based on the space in the output
                    outputHandler.calculateOperationsCanSupport(tracker, output);
                }
            }
        }
    }

    @Override
    public boolean isInputValid() {
        GasStack gas = gasInputHandler.getInput();
        if (gas.isEmpty()) {
            return false;
        }
        return recipe.test(gas);
    }

    @Override
    protected void finishProcessing(int operations) {
        if (output != null && !recipeGas.isEmpty()) {
            gasInputHandler.use(recipeGas, operations);
            outputHandler.handleOutput(output, operations);
        }
    }
}