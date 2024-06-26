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

import mekanism.api.recipes.GasToGasRecipe;
import mekanism.common.recipe.serializer.GasToGasRecipeSerializer;
import mekanism.common.registration.impl.RecipeSerializerDeferredRegister;
import mekanism.common.registration.impl.RecipeSerializerRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.recipe.impl.MEConvertingIRecipe;

public class SFRecipeSerializers {
    public static final RecipeSerializerDeferredRegister REGISTER = new RecipeSerializerDeferredRegister(SpongeFactory.MOD_ID);

    public static final RecipeSerializerRegistryObject<GasToGasRecipe> ME_CONVERTING = REGISTER.register("mass_energy_converting", () -> new GasToGasRecipeSerializer<>(MEConvertingIRecipe::new));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}