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

import cofh.lib.fluid.FluidIngredient;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fluids.FluidStack;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.recipe.manager.MagnetizerRecipeManager;
import top.spco.spongefactory.registries.SFRecipeSerializers;
import top.spco.spongefactory.registries.SFRecipeTypes;

import java.util.List;

public class MagnetizerRecipe extends ThermalRecipe {
    public MagnetizerRecipe(ResourceLocation recipeId, int energy, float xp, List<Ingredient> inputItems, List<FluidIngredient> inputFluids, List<ItemStack> outputItems, List<Float> outputItemChances, List<FluidStack> outputFluids) {
        super(recipeId, energy, xp, inputItems, inputFluids, outputItems, outputItemChances, outputFluids);
        if (this.energy <= 0) {
            int defaultEnergy = MagnetizerRecipeManager.instance().getDefaultEnergy();
            SpongeFactory.LOGGER.warn("Energy value for {} was out of allowable range and has been set to a default value of {}.", recipeId, defaultEnergy);
            this.energy = defaultEnergy;
        }
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SFRecipeSerializers.MAGNETIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return SFRecipeTypes.MAGNETIZER.get();
    }
}