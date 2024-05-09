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
package top.spco.spongefactory.infrastructure.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

/**
 * Data generator
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class Datagen {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        SupportedLanguageProviders languageProviders = new SupportedLanguageProviders(generator);
        generator.addProvider(true, languageProviders.chinese);
        generator.addProvider(true, languageProviders.english);

        ModBlockStateProvider blockStateProvider = new ModBlockStateProvider(generator, existingFileHelper);
        generator.addProvider(true, blockStateProvider);

        ModItemModelProvider itemModelProvider = new ModItemModelProvider(generator, existingFileHelper);
        generator.addProvider(true, itemModelProvider);

        ModRecipeProvider recipeProvider = new ModRecipeProvider(generator);
        generator.addProvider(true, recipeProvider);

        ModLootTableProvider lootTableProvider = new ModLootTableProvider(generator);
        generator.addProvider(true, lootTableProvider);
    }
}