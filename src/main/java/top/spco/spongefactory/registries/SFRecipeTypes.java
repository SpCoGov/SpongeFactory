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

import cofh.lib.util.recipes.SerializableRecipeType;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.recipe.MagnetizerRecipe;

public class SFRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, SpongeFactory.MOD_ID);

    public static final RegistryObject<SerializableRecipeType<MagnetizerRecipe>> MAGNETIZER = REGISTER.register("magnetizer", () -> new SerializableRecipeType<>(SpongeFactory.MOD_ID, "magnetizer"));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}