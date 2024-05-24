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
import top.spco.spongefactory.infrastructure.*;
import top.spco.spongefactory.infrastructure.quest.QuestContent;
import top.spco.spongefactory.quest.SpongeFactoryQuests;
import top.spco.spongefactory.registries.*;

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
        SpongeFactoryQuests.init();
        chinese = new ChineseProvider(generator);
        english = new EnglishProvider(generator);
    }

    public static class ChineseProvider extends LanguageProvider {
        public ChineseProvider(DataGenerator gen) {
            super(gen, SpongeFactory.MOD_ID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            for (ItemMapping<?> item : SpongeFactoryItems.ITEMS) {
                if (item.isBlockItem()) {
                    continue;
                }
                add(item.getTranslationKey(), item.getChineseName());
            }
            for (BlockMapping<?> block : SpongeFactoryBlocks.BLOCKS) {
                add(block.getTranslationKey(), block.getChineseName());
            }
            for (CreativeModeTabMapping tabs : SpongeFactoryCreativeModTabs.TABS) {
                add(tabs.getTranslationKey(), tabs.getChineseName());
            }
            for (QuestContent questContents : SpongeFactoryQuests.QUESTS) {
                add(questContents.getTranslationKey(), questContents.getChineseName());
            }
            for (GasMapping gas : SpongeFactoryGases.GASES) {
                add(gas.getTranslationKey(), gas.getChineseName());
            }
            for (ContainerMapping<?> container : SpongeFactoryContainerTypes.CONTAINERS) {
                add(container.getTranslationKey(), container.getChineseName());
            }
            for (SpongeFactoryMachineDescription description : SpongeFactoryMachineDescription.DESCRIPTIONS) {
                add(description.getTranslationKey(), description.getChineseName());
            }
            for (FluidMapping fluid : SpongeFactoryFluids.FLUIDS) {
                add(fluid.getTranslationKey(), fluid.getChineseName());
            }
            for (InfuseTypeMapping infuseType : SpongeFactoryInfuseTypes.INFUSE_TYPES) {
                add(infuseType.getTranslationKey(), infuseType.getChineseName());
            }
        }
    }

    public static class EnglishProvider extends LanguageProvider {
        public EnglishProvider(DataGenerator gen) {
            super(gen, SpongeFactory.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            for (ItemMapping<?> item : SpongeFactoryItems.ITEMS) {
                if (item.isBlockItem()) {
                    continue;
                }
                add(item.getTranslationKey(), item.getEnglishName());
            }
            for (BlockMapping<?> block : SpongeFactoryBlocks.BLOCKS) {
                add(block.getTranslationKey(), block.getEnglishName());
            }
            for (CreativeModeTabMapping tab : SpongeFactoryCreativeModTabs.TABS) {
                add(tab.getTranslationKey(), tab.getEnglishName());
            }
            for (QuestContent questContent : SpongeFactoryQuests.QUESTS) {
                add(questContent.getTranslationKey(), questContent.getEnglishName());
            }
            for (GasMapping gas : SpongeFactoryGases.GASES) {
                add(gas.getTranslationKey(), gas.getEnglishName());
            }
            for (ContainerMapping<?> container : SpongeFactoryContainerTypes.CONTAINERS) {
                add(container.getTranslationKey(), container.getEnglishName());
            }
            for (SpongeFactoryMachineDescription description : SpongeFactoryMachineDescription.DESCRIPTIONS) {
                add(description.getTranslationKey(), description.getEnglishName());
            }
            for (FluidMapping fluid : SpongeFactoryFluids.FLUIDS) {
                add(fluid.getTranslationKey(), fluid.getEnglishName());
            }
            for (InfuseTypeMapping infuseType : SpongeFactoryInfuseTypes.INFUSE_TYPES) {
                add(infuseType.getTranslationKey(), infuseType.getEnglishName());
            }
        }
    }
}