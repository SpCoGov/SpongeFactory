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
package top.spco.spongefactory.client.jei;

import mekanism.client.jei.CatalystRegistryHelper;
import mekanism.client.jei.RecipeRegistryHelper;
import mekanism.client.jei.machine.GasToGasRecipeCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.registries.SFBlocks;
import top.spco.spongefactory.registries.SFRecipeType;

@JeiPlugin
public class SFJEI implements IModPlugin {
    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(SpongeFactory.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();

        registry.addRecipeCategories(new GasToGasRecipeCategory(guiHelper, SFJEIRecipeType.ME_CONVERTING, SFBlocks.MASS_ENERGY_CONVERTER.toMekRegistryObject()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registry) {
        RecipeRegistryHelper.register(registry, SFJEIRecipeType.ME_CONVERTING, SFRecipeType.ME_CONVERTING);
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registry) {
        CatalystRegistryHelper.register(registry, SFBlocks.MASS_ENERGY_CONVERTER.toMekRegistryObject());
    }
}