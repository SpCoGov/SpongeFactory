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

import java.util.ArrayList;

public class QuestChapter {
    private final String keyPrefix;
    private final QuestContent title;
    private QuestContent subtitle = null;

    public QuestChapter(QuestGroup group, String id, String chineseTitle, String englishTitle) {
        String keyPrefix = "";
        if (group != null) {
            keyPrefix += group.getId() + ".";
        }
        keyPrefix += "chapter." + SpongeFactory.MOD_ID + "." + id + ".";
        this.keyPrefix = keyPrefix;
        title = new QuestContent(this.keyPrefix + "title", chineseTitle, englishTitle) {
        };
    }

    public QuestChapter subtitle(String chineseSubtitle, String englishSubtitle) {
        subtitle = new QuestContent(this.keyPrefix + "subtitle", chineseSubtitle, englishSubtitle) {
        };
        return this;
    }

    public ArrayList<QuestContent> contents() {
        ArrayList<QuestContent> contents = new ArrayList<>(2);
        contents.add(title);
        if (subtitle != null) {
            contents.add(subtitle);
        }
        return contents;
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }
}