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
package top.spco.spongefactory.recipe;

import mekanism.api.chemical.gas.GasStack;
import mekanism.api.math.FloatingLong;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class FluidizedBedRecipe extends MekanismRecipe implements Predicate<@NotNull GasStack> {
    private final ChemicalStackIngredient.GasStackIngredient inputGas;
    private final FloatingLong energyRequired;
    private final int duration;
    private final ItemStack outputItem;
    private final GasStack outputGas;

    protected FluidizedBedRecipe(ResourceLocation id, ChemicalStackIngredient.GasStackIngredient inputGas, FloatingLong energyRequired, int duration, ItemStack output, GasStack outputGas) {
        super(id);
        this.inputGas = Objects.requireNonNull(inputGas, "Gas input cannot be null.");
        this.energyRequired = Objects.requireNonNull(energyRequired, "Required energy cannot be null.").copyAsConst();
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive.");
        }
        this.duration = duration;
        Objects.requireNonNull(output, "Item output cannot be null.");
        Objects.requireNonNull(outputGas, "Gas output cannot be null.");
        if (output.isEmpty() && outputGas.isEmpty()) {
            throw new IllegalArgumentException("At least one output must not be empty.");
        }
        this.outputItem = output.copy();
        this.outputGas = outputGas.copy();
    }

    public ChemicalStackIngredient.GasStackIngredient getInputGas() {
        return inputGas;
    }

    @Override
    public void write(FriendlyByteBuf buffer) {
        inputGas.write(buffer);
        energyRequired.writeToBuffer(buffer);
        buffer.writeVarInt(duration);
        buffer.writeItem(outputItem);
        outputGas.writeToPacket(buffer);
    }

    /**
     * Gets the amount of "extra" energy this recipe requires, compared to the base energy requirements of the machine performing the recipe.
     */
    public FloatingLong getEnergyRequired() {
        return energyRequired;
    }

    /**
     * Gets the base duration in ticks that this recipe takes to complete.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * For JEI, gets the output representations to display.
     *
     * @return Representation of the output, <strong>MUST NOT</strong> be modified.
     */
    public List<FluidizedBedRecipeOutput> getOutputDefinition() {
        return Collections.singletonList(new FluidizedBedRecipeOutput(outputItem, outputGas));
    }

    /**
     * Gets a new output based on the given inputs.
     *
     * @param gas Specific gas input.
     * @return New output.
     * @apiNote While Mekanism does not currently make use of the inputs, it is important to support it and pass the proper value in case any addons define input based
     * outputs where things like NBT may be different.
     * @implNote The passed in inputs should <strong>NOT</strong> be modified.
     */
    @Contract(value = "_ -> new", pure = true)
    public FluidizedBedRecipeOutput getOutput(GasStack gas) {
        return new FluidizedBedRecipeOutput(this.outputItem.copy(), this.outputGas.copy());
    }

    @Override
    public boolean isIncomplete() {
        return inputGas.hasNoMatchingInstances();
    }

    @Override
    public boolean test(@NotNull GasStack gasStack) {
        return this.inputGas.test(gasStack);
    }

    public record FluidizedBedRecipeOutput(@NotNull ItemStack item, @NotNull GasStack gas) {
        public FluidizedBedRecipeOutput {
            Objects.requireNonNull(item, "Item output cannot be null.");
            Objects.requireNonNull(gas, "Gas output cannot be null.");
            if (item.isEmpty() && gas.isEmpty()) {
                throw new IllegalArgumentException("At least one output must be present.");
            }
        }
    }
}