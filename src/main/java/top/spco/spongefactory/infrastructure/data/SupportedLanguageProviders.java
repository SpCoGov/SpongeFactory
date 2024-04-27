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
import net.minecraftforge.common.data.LanguageProvider;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.Translatable;
import top.spco.spongefactory.item.ModCreativeModTabs;
import top.spco.spongefactory.item.ModItems;

/**
 * Provides supported language providers for generating language files.
 * This class initializes separate language providers for {@link ChineseProvider Chinese} and {@link EnglishProvider English} .
 * Each provider generates language files for the respective language.
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class SupportedLanguageProviders {
    public final LanguageProvider chinese;
    public final LanguageProvider english;

    public SupportedLanguageProviders(DataGenerator generator) {
        chinese = new ChineseProvider(generator);
        english = new EnglishProvider(generator);
    }

    public static class ChineseProvider extends LanguageProvider {
        public ChineseProvider(DataGenerator gen) {
            super(gen, SpongeFactory.MOD_ID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            for (Translatable item : ModItems.ITEMS) {
                add(item.getTranslationKey(), item.getChineseName());
            }
            for (Translatable tabs : ModCreativeModTabs.TABS) {
                add(tabs.getTranslationKey(), tabs.getChineseName());
            }
        }
    }

    public static class EnglishProvider extends LanguageProvider {
        public EnglishProvider(DataGenerator gen) {
            super(gen, SpongeFactory.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            for (Translatable item : ModItems.ITEMS) {
                add(item.getTranslationKey(), item.getEnglishName());
            }
            for (Translatable tabs : ModCreativeModTabs.TABS) {
                add(tabs.getTranslationKey(), tabs.getEnglishName());
            }
        }
    }
}