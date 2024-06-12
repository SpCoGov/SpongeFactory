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
import top.spco.spongefactory.infrastructure.data.loot.cofh.SFCoFHItemModelProvider;

/**
 * Data generator
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class SFDataGen {
    public static void gatherData(GatherDataEvent event) {
        System.out.println("Data gen " +StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass().getName());
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        SupportedLanguageProviders languageProviders = new SupportedLanguageProviders(generator);
        generator.addProvider(event.includeClient(), languageProviders.chinese);
        generator.addProvider(event.includeClient(), languageProviders.english);

        SFBlockStateProvider blockStateProvider = new SFBlockStateProvider(generator, existingFileHelper);
        generator.addProvider(event.includeClient(), blockStateProvider);

        SFItemModelProvider itemModelProvider = new SFItemModelProvider(generator, existingFileHelper);
        generator.addProvider(event.includeClient(), itemModelProvider);

        SFRecipeProvider recipeProvider = new SFRecipeProvider(generator);
        generator.addProvider(event.includeServer(), recipeProvider);

        SFLootTableProvider lootTableProvider = new SFLootTableProvider(generator);
        generator.addProvider(event.includeServer(), lootTableProvider);

        SFBlockTagsGenerator blockTagGenerator = new SFBlockTagsGenerator(generator, existingFileHelper);
        SFItemTagsGenerator itemTagGenerator = new SFItemTagsGenerator(generator, blockTagGenerator, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagGenerator);
        generator.addProvider(event.includeServer(), itemTagGenerator);

        // CoFH providers
        generator.addProvider(event.includeClient(), new SFCoFHItemModelProvider(generator, existingFileHelper));
    }
}