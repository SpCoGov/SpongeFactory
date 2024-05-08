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
package top.spco.spongefactory.infrastructure;

import mekanism.api.chemical.gas.Gas;
import mekanism.common.registration.impl.GasRegistryObject;
import top.spco.spongefactory.SpongeFactory;

/**
 * A class representing the mapping of an {@link Gas}.
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class GasMapping implements Translatable {
    private final String englishName;
    private final String chineseName;
    private final String id;
    private final String translationKey;

    public GasMapping(String englishName, String chineseName, String id) {
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.id = id;
        this.translationKey = "gas." + SpongeFactory.MOD_ID + "." + id;
    }


    @Override
    public String getChineseName() {
        return chineseName;
    }

    @Override
    public String getEnglishName() {
        return englishName;
    }

    @Override
    public String getTranslationKey() {
        return translationKey;
    }
}