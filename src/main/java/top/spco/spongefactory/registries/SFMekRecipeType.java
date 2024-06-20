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
package top.spco.spongefactory.registries;

import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.recipes.GasToGasRecipe;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.chemical.ChemicalToChemicalRecipe;
import mekanism.common.recipe.MekanismRecipeType;
import mekanism.common.recipe.lookup.cache.IInputRecipeCache;
import mekanism.common.recipe.lookup.cache.InputRecipeCache;
import mekanism.common.registration.impl.RecipeTypeDeferredRegister;
import mekanism.common.registration.impl.RecipeTypeRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.recipe.FluidizedBedRecipe;

import java.lang.reflect.Constructor;
import java.util.function.Function;

public class SFMekRecipeType {
    public static final RecipeTypeDeferredRegister REGISTER = new RecipeTypeDeferredRegister(SpongeFactory.MOD_ID);

    public static final RecipeTypeRegistryObject<GasToGasRecipe, InputRecipeCache.SingleChemical<Gas, GasStack, GasToGasRecipe>> ME_CONVERTING =
            register("mass_energy_converting", recipeType -> new InputRecipeCache.SingleChemical<>(recipeType, ChemicalToChemicalRecipe::getInput));
    public static final RecipeTypeRegistryObject<FluidizedBedRecipe, InputRecipeCache.SingleChemical<Gas, GasStack, FluidizedBedRecipe>> FLUIDIZED_BED_REACTOR =
            register("fluidized_bed_reactor", recipeType -> new InputRecipeCache.SingleChemical<>(recipeType, FluidizedBedRecipe::getInputGas));

    @SuppressWarnings(value = {"rawtypes", "unchecked"})
    private static <RECIPE extends MekanismRecipe, INPUT_CACHE extends IInputRecipeCache> RecipeTypeRegistryObject<RECIPE, INPUT_CACHE> register(String name,
                                                                                                                                                 Function<MekanismRecipeType<RECIPE, INPUT_CACHE>, INPUT_CACHE> inputCacheCreator) {
        try {
            Constructor<MekanismRecipeType> constructor = MekanismRecipeType.class.getDeclaredConstructor(String.class, Function.class);
            constructor.setAccessible(true);
            MekanismRecipeType<RECIPE, INPUT_CACHE> parentInstance = constructor.newInstance(name, inputCacheCreator);
            return REGISTER.register(name, () -> parentInstance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to register recipe type: " + name, e);
        }
    }


    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}