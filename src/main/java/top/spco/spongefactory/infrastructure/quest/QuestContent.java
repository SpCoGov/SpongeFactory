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
package top.spco.spongefactory.infrastructure.quest;

import top.spco.spongefactory.infrastructure.Translatable;

public abstract class QuestContent implements Translatable {
    protected final String translationKey;
    protected final String chinese;
    protected final String english;

    protected QuestContent(String translationKey, String chinese, String english) {
        this.translationKey = translationKey;
        this.chinese = chinese;
        this.english = english;
    }

    @Override
    public String getChineseName() {
        return chinese;
    }

    @Override
    public String getEnglishName() {
        return english;
    }

    @Override
    public String getTranslationKey() {
        return translationKey;
    }
}