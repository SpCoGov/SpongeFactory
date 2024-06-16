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
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.client.gui.MachineMagnetizerScreen;
import top.spco.spongefactory.recipe.MagnetizerRecipe;
import top.spco.spongefactory.registries.SFBlocks;
import top.spco.spongefactory.registries.SFMekRecipeType;
import top.spco.spongefactory.registries.SFRecipeTypes;

import static top.spco.spongefactory.SpongeFactory.makeId;

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
        registry.addRecipeCategories(new MagnetizerRecipeCategory(guiHelper, new ItemStack(SFBlocks.MAGNETIZER), MAGNETIZER));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registry) {
        RecipeRegistryHelper.register(registry, SFJEIRecipeType.ME_CONVERTING, SFMekRecipeType.ME_CONVERTING);

        RecipeManager recipeManager = getRecipeManager();
        registry.addRecipes(MAGNETIZER, recipeManager.getAllRecipesFor(SFRecipeTypes.MAGNETIZER.get()));
    }

    private RecipeManager getRecipeManager() {

        RecipeManager recipeManager = null;
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null) {
            recipeManager = level.getRecipeManager();
        }
        return recipeManager;
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registry) {
        int progressY = 35;
        int progressW = 24;
        int progressH = 16;

        registry.addRecipeClickArea(MachineMagnetizerScreen.class, 88, progressY, progressW, progressH, MAGNETIZER);
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registry) {
        CatalystRegistryHelper.register(registry, SFBlocks.MASS_ENERGY_CONVERTER.toMekRegistryObject());

        registry.addRecipeCatalyst(new ItemStack(SFBlocks.MAGNETIZER), MAGNETIZER);
    }

    public static final RecipeType<MagnetizerRecipe> MAGNETIZER = new RecipeType<>(makeId("magnetizer"), MagnetizerRecipe.class);
}