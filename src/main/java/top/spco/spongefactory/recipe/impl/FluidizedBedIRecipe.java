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
package top.spco.spongefactory.recipe.impl;

import mekanism.api.chemical.gas.GasStack;
import mekanism.api.math.FloatingLong;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.recipe.FluidizedBedRecipe;
import top.spco.spongefactory.registries.SFBlocks;
import top.spco.spongefactory.registries.SFMekRecipeType;
import top.spco.spongefactory.registries.SFRecipeSerializers;

public class FluidizedBedIRecipe extends FluidizedBedRecipe {
    public FluidizedBedIRecipe(ResourceLocation id, ChemicalStackIngredient.GasStackIngredient inputGas, FloatingLong energyRequired, int duration, ItemStack output, GasStack outputGas) {
        super(id, inputGas, energyRequired, duration, output, outputGas);
    }

    @Override
    public @NotNull RecipeSerializer<FluidizedBedRecipe> getSerializer() {
        return SFRecipeSerializers.FLUIDIZED_BED.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return SFMekRecipeType.FLUIDIZED_BED_REACTOR.get();
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return SFBlocks.FLUIDIZED_BED_REACTOR.toMekRegistryObject().getItemStack();
    }

    @Override
    public @NotNull String getGroup() {
        return SFBlocks.FLUIDIZED_BED_REACTOR.toMekRegistryObject().getName();
    }
}