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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class QuestItem {
    private final @NotNull QuestContent title;
    private QuestContent subtitle = null;
    private QuestContent desc = null;
    private final String keyPrefix;

    public QuestItem(QuestChapter chapter, String id, String chineseTitle, String englishTitle) {
        this.keyPrefix = chapter.getKeyPrefix() + id + ".";
        this.title = new QuestContent(keyPrefix + "title", chineseTitle, englishTitle) {
        };
    }

    public QuestItem subtitle(String chineseSubtitle, String englishSubtitle) {
        this.subtitle = new QuestContent(keyPrefix + "subtitle", chineseSubtitle, englishSubtitle) {
        };
        return this;
    }

    public QuestItem describe(String chineseDescribe, String englishDescribe) {
        this.desc = new QuestContent(keyPrefix + "desc", chineseDescribe, englishDescribe) {
        };
        return this;
    }

    public ArrayList<QuestContent> contents() {
        ArrayList<QuestContent> contents = new ArrayList<>(3);
        contents.add(title);
        if (subtitle != null) {
            contents.add(subtitle);
        }
        if (desc != null) {
            contents.add(desc);
        }
        return contents;
    }
}