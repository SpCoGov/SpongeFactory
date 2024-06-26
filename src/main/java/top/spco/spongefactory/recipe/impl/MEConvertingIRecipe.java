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
import mekanism.api.recipes.GasToGasRecipe;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.registries.SFBlocks;
import top.spco.spongefactory.registries.SFRecipeSerializers;
import top.spco.spongefactory.registries.SFRecipeType;

public class MEConvertingIRecipe extends GasToGasRecipe {

    public MEConvertingIRecipe(ResourceLocation id, ChemicalStackIngredient.GasStackIngredient input, GasStack output) {
        super(id, input, output);
    }

    @Override
    public @NotNull RecipeType<GasToGasRecipe> getType() {
        return SFRecipeType.ME_CONVERTING.get();
    }

    @Override
    public @NotNull RecipeSerializer<GasToGasRecipe> getSerializer() {
        return SFRecipeSerializers.ME_CONVERTING.get();
    }

    @Override
    public @NotNull String getGroup() {
        return SFBlocks.MASS_ENERGY_CONVERTER.toMekRegistryObject().getName();
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return SFBlocks.MASS_ENERGY_CONVERTER.toMekRegistryObject().getItemStack();
    }
}