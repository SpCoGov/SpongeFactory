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

import top.spco.spongefactory.SpongeFactory;

public class QuestGroup extends QuestContent {
    private final String id;

    public QuestGroup(String id, String chineseTitle, String englishTitle) {
        super("questGroup." + SpongeFactory.MOD_ID + "." + id, chineseTitle, englishTitle);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}