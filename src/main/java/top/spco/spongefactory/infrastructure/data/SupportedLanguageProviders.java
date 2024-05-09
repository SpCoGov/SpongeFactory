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
import top.spco.spongefactory.infrastructure.BlockMapping;
import top.spco.spongefactory.infrastructure.CreativeModeTabMapping;
import top.spco.spongefactory.infrastructure.GasMapping;
import top.spco.spongefactory.infrastructure.ItemMapping;
import top.spco.spongefactory.infrastructure.quest.QuestContent;
import top.spco.spongefactory.quest.ModQuests;
import top.spco.spongefactory.registries.ModBlocks;
import top.spco.spongefactory.registries.ModCreativeModTabs;
import top.spco.spongefactory.registries.ModGases;
import top.spco.spongefactory.registries.ModItems;

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
        ModQuests.init();
        chinese = new ChineseProvider(generator);
        english = new EnglishProvider(generator);
    }

    public static class ChineseProvider extends LanguageProvider {
        public ChineseProvider(DataGenerator gen) {
            super(gen, SpongeFactory.MOD_ID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            for (ItemMapping<?> item : ModItems.ITEMS) {
                if (item.isBlockItem()) {
                    continue;
                }
                add(item.getTranslationKey(), item.getChineseName());
            }
            for (BlockMapping<?> block : ModBlocks.BLOCKS) {
                add(block.getTranslationKey(), block.getChineseName());
            }
            for (CreativeModeTabMapping tabs : ModCreativeModTabs.TABS) {
                add(tabs.getTranslationKey(), tabs.getChineseName());
            }
            for (QuestContent questContents : ModQuests.QUESTS) {
                add(questContents.getTranslationKey(), questContents.getChineseName());
            }
            for (GasMapping gas : ModGases.GASES) {
                add(gas.getTranslationKey(), gas.getChineseName());
            }
        }
    }

    public static class EnglishProvider extends LanguageProvider {
        public EnglishProvider(DataGenerator gen) {
            super(gen, SpongeFactory.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            for (ItemMapping<?> item : ModItems.ITEMS) {
                if (item.isBlockItem()) {
                    continue;
                }
                add(item.getTranslationKey(), item.getEnglishName());
            }
            for (BlockMapping<?> block : ModBlocks.BLOCKS) {
                add(block.getTranslationKey(), block.getEnglishName());
            }
            for (CreativeModeTabMapping tabs : ModCreativeModTabs.TABS) {
                add(tabs.getTranslationKey(), tabs.getEnglishName());
            }
            for (QuestContent questContents : ModQuests.QUESTS) {
                add(questContents.getTranslationKey(), questContents.getEnglishName());
            }
            for (GasMapping gas : ModGases.GASES) {
                add(gas.getTranslationKey(), gas.getEnglishName());
            }
        }
    }
}