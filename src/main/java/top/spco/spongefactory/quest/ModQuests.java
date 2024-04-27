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
package top.spco.spongefactory.quest;

import top.spco.spongefactory.infrastructure.quest.QuestChapter;
import top.spco.spongefactory.infrastructure.quest.QuestContent;
import top.spco.spongefactory.infrastructure.quest.QuestGroup;
import top.spco.spongefactory.infrastructure.quest.QuestItem;

import java.util.HashSet;
import java.util.Set;

public class ModQuests {
    public static final Set<QuestContent> QUESTS = new HashSet<>();

    public static final QuestChapter WELCOME = new QuestChapter(null, "welcome", "欢迎", "Welcome");
    public static final QuestItem WELCOME_ITEM = new QuestItem(WELCOME, "welcome", "欢迎来到海绵工厂！", "Welcome to Sponge Factory!");
    public static final QuestGroup GETTING_START = new QuestGroup("getting_start", "入门","Getting Start");
    public static final QuestChapter CHAPTER_1 = new QuestChapter(null, "chapter_1", "第一章", "Chapter 1");
    public static final QuestItem CUT_LOGS_FIRST = new QuestItem(CHAPTER_1, "cut_logs_first", "先撸树", "Cut logs first").subtitle("经典开局","Classic Start");

    private static void add(QuestChapter chapter) {
        QUESTS.addAll(chapter.contents());
    }

    private static void add(QuestGroup group) {
        QUESTS.add(group);
    }

    private static void add(QuestItem item) {
        QUESTS.addAll(item.contents());
    }

    public static void init() {
        add(WELCOME);
        add(WELCOME_ITEM);
        add(GETTING_START);
        add(CHAPTER_1);
        add(CUT_LOGS_FIRST);
    }
}