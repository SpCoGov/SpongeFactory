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

import cofh.thermal.lib.util.recipes.MachineRecipeSerializer;
import mekanism.api.recipes.GasToGasRecipe;
import mekanism.common.recipe.serializer.GasToGasRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.recipe.MagnetizerRecipe;
import top.spco.spongefactory.recipe.impl.MEConvertingIRecipe;
import top.spco.spongefactory.recipe.manager.MagnetizerRecipeManager;

public class SFRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SpongeFactory.MOD_ID);

    public static final RegistryObject<GasToGasRecipeSerializer<GasToGasRecipe>> ME_CONVERTING = REGISTER.register("mass_energy_converting", () -> new GasToGasRecipeSerializer<>(MEConvertingIRecipe::new));
    public static final RegistryObject<MachineRecipeSerializer<MagnetizerRecipe>> MAGNETIZER = REGISTER.register("magnetizer", () -> new MachineRecipeSerializer<>(MagnetizerRecipe::new, MagnetizerRecipeManager.instance().getDefaultEnergy()));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}