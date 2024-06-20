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
package top.spco.spongefactory.recipe.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import mekanism.api.JsonConstants;
import mekanism.api.SerializerHelper;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.math.FloatingLong;
import mekanism.api.recipes.ingredients.ChemicalStackIngredient;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.recipe.FluidizedBedRecipe;

public class FluidizedBedSerializer<T extends FluidizedBedRecipe> implements RecipeSerializer<T> {
    private final IFactory<T> factory;

    public FluidizedBedSerializer(IFactory<T> factory) {
        this.factory = factory;
    }

    @Override
    public @NotNull T fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject json) {
        JsonElement gasInput = GsonHelper.isArrayNode(json, JsonConstants.GAS_INPUT) ? GsonHelper.getAsJsonArray(json, JsonConstants.GAS_INPUT) :
                GsonHelper.getAsJsonObject(json, JsonConstants.GAS_INPUT);
        ChemicalStackIngredient.GasStackIngredient gasIngredient = IngredientCreatorAccess.gas().deserialize(gasInput);
        FloatingLong energyRequired = FloatingLong.ZERO;
        if (json.has(JsonConstants.ENERGY_REQUIRED)) {
            energyRequired = SerializerHelper.getFloatingLong(json, JsonConstants.ENERGY_REQUIRED);
        }
        JsonElement ticks = json.get(JsonConstants.DURATION);
        if (!GsonHelper.isNumberValue(ticks)) {
            throw new JsonSyntaxException("Expected duration to be a number greater than zero.");
        }
        int duration = ticks.getAsJsonPrimitive().getAsInt();
        if (duration <= 0) {
            throw new JsonSyntaxException("Expected duration to be a number greater than zero.");
        }
        ItemStack itemOutput = ItemStack.EMPTY;
        GasStack gasOutput = GasStack.EMPTY;
        if (json.has(JsonConstants.ITEM_OUTPUT)) {
            itemOutput = SerializerHelper.getItemStack(json, JsonConstants.ITEM_OUTPUT);
            if (itemOutput.isEmpty()) {
                throw new JsonSyntaxException("Fluidized Bed Reactor item output must not be empty, if it is defined.");
            }
            if (json.has(JsonConstants.GAS_OUTPUT)) {
                //The gas is optional given we have an output item
                gasOutput = SerializerHelper.getGasStack(json, JsonConstants.GAS_OUTPUT);
                if (gasOutput.isEmpty()) {
                    throw new JsonSyntaxException("Fluidized Bed Reactor gas output must not be empty, if it is defined.");
                }
            }
        } else {
            gasOutput = SerializerHelper.getGasStack(json, JsonConstants.GAS_OUTPUT);
            if (gasOutput.isEmpty()) {
                throw new JsonSyntaxException("Fluidized Bed Reactor gas output must not be empty, if there is no item output.");
            }
        }
        return this.factory.create(recipeId, gasIngredient, energyRequired, duration, itemOutput, gasOutput);
    }

    @Override
    public T fromNetwork(@NotNull ResourceLocation recipeId, @NotNull FriendlyByteBuf buffer) {
        try {
            ChemicalStackIngredient.GasStackIngredient inputGas = IngredientCreatorAccess.gas().read(buffer);
            FloatingLong energyRequired = FloatingLong.readFromBuffer(buffer);
            int duration = buffer.readVarInt();
            ItemStack outputItem = buffer.readItem();
            GasStack outputGas = GasStack.readFromPacket(buffer);
            return this.factory.create(recipeId, inputGas, energyRequired, duration, outputItem, outputGas);
        } catch (Exception e) {
            SpongeFactory.LOGGER.error("Error reading Fluidized Bed Reactor recipe from packet.", e);
            throw e;
        }
    }

    @Override
    public void toNetwork(@NotNull FriendlyByteBuf buffer, @NotNull T recipe) {
        try {
            recipe.write(buffer);
        } catch (Exception e) {
            SpongeFactory.LOGGER.error("Error reading Fluidized Bed Reactor recipe from packet.", e);
            throw e;
        }
    }

    @FunctionalInterface
    public interface IFactory<T extends FluidizedBedRecipe> {
        T create(ResourceLocation resourceLocation, ChemicalStackIngredient.GasStackIngredient gasInput, FloatingLong energyRequired, int duration, ItemStack outputItem, GasStack outputGas);
    }
}