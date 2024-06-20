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
package top.spco.spongefactory.recipe.manager;

import cofh.lib.api.inventory.IItemStackHolder;
import cofh.lib.util.crafting.ComparableItemStack;
import cofh.thermal.lib.util.managers.AbstractManager;
import cofh.thermal.lib.util.managers.IRecipeManager;
import cofh.thermal.lib.util.recipes.IThermalInventory;
import cofh.thermal.lib.util.recipes.ThermalRecipe;
import cofh.thermal.lib.util.recipes.internal.IMachineRecipe;
import cofh.thermal.lib.util.recipes.internal.SimpleMachineRecipe;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import top.spco.spongefactory.recipe.MagnetizerRecipe;
import top.spco.spongefactory.registries.SFRecipeTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.singletonList;

public class MagnetizerRecipeManager extends AbstractManager implements IRecipeManager {
    private static final MagnetizerRecipeManager INSTANCE = new MagnetizerRecipeManager();
    protected static final int DEFAULT_ENERGY = 5000;

    protected Map<List<Integer>, IMachineRecipe> recipeMap = new Object2ObjectOpenHashMap<>();
    protected Set<ComparableItemStack> validItems = new ObjectOpenHashSet<>();
    protected int maxOutputItems;

    public static MagnetizerRecipeManager instance() {
        return INSTANCE;
    }

    private MagnetizerRecipeManager() {
        super(DEFAULT_ENERGY);
        this.maxOutputItems = 1;
    }

    public boolean validItem(ItemStack item) {
        return validItems.contains(makeComparable(item));
    }

    @Override
    public IMachineRecipe getRecipe(IThermalInventory inventory) {
        return getRecipe(inventory.inputSlots());
    }

    protected IMachineRecipe getRecipe(List<? extends IItemStackHolder> inputSlots) {
        if (inputSlots.isEmpty() || inputSlots.get(0).isEmpty()) {
            return null;
        }
        ItemStack inputItem = inputSlots.get(0).getItemStack();
        return recipeMap.get(List.of(makeComparable(inputItem).hashCode()));
    }

    @Override
    public List<IMachineRecipe> getRecipeList() {
        return new ArrayList<>(recipeMap.values());
    }

    protected void clear() {
        recipeMap.clear();
        validItems.clear();
    }

    @Override
    public void refresh(RecipeManager recipeManager) {
        clear();
        Map<ResourceLocation, MagnetizerRecipe> recipes = recipeManager.byType(SFRecipeTypes.MAGNETIZER.get());
        for (var entry : recipes.entrySet()) {
            addRecipe(entry.getValue());
        }
    }

    protected IMachineRecipe addRecipe(int energy, float experience, List<ItemStack> inputItems, List<ItemStack> outputItems, List<Float> chance) {
        ItemStack inputItem = inputItems.get(0);
        if (inputItem.isEmpty()) {
            return null;
        }
        for (ItemStack stack : outputItems) {
            if (stack.isEmpty()) {
                return null;
            }
        }
        validItems.add(makeComparable(inputItem));
        energy = (int) (energy * getDefaultScale());

        SimpleMachineRecipe recipe = new SimpleMachineRecipe(energy, experience, inputItems, null, outputItems, chance, null);
        recipeMap.put(List.of(makeComparable(inputItem).hashCode()), recipe);
        return recipe;
    }

    public void addRecipe(ThermalRecipe recipe) {

        if (!recipe.getInputItems().isEmpty()) {
            for (ItemStack recipeInput : recipe.getInputItems().get(0).getItems()) {
                addRecipe(recipe.getEnergy(), recipe.getXp(), singletonList(recipeInput), recipe.getOutputItems(), recipe.getOutputItemChances());
            }
        }
    }

    protected IMachineRecipe addRecipe(IMachineRecipe recipe) {
        ItemStack inputItem = recipe.getInputItems().get(0);
        if (inputItem.isEmpty()) {
            return null;
        }
        validItems.add(makeComparable(inputItem));
        recipeMap.put(List.of(makeComparable(inputItem).hashCode()), recipe);
        return recipe;
    }
}