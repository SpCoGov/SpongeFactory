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
    public static final QuestGroup MECHANICAL_AGE = new QuestGroup("mechanical_age", "机械时代", "Mechanical Age");
    public static final QuestChapter CHAPTER_1 = new QuestChapter(MECHANICAL_AGE, "chapter_1", "第一章", "Chapter 1");
    public static final QuestItem CUT_LOGS_FIRST = new QuestItem(CHAPTER_1, "cut_logs_first", "先撸树", "Cut logs first").subtitle("经典开局", "Classic Start");
    public static final QuestChapter CHAPTER_2 = new QuestChapter(MECHANICAL_AGE, "chapter_2", "第二章", "Chapter 2");
    public static final QuestChapter CHAPTER_3 = new QuestChapter(MECHANICAL_AGE, "chapter_3", "第三章", "Chapter 3");
    public static final QuestChapter CHAPTER_4 = new QuestChapter(MECHANICAL_AGE, "chapter_4", "第四章", "Chapter 4");
    public static final QuestItem CHAPTER_4_PASS = new QuestItem(CHAPTER_4, "pass", "4 不吉利", "4 is Unlucky").subtitle("在汉语、韩语和日语中，“四”的读音近似“死”，被认为是不吉祥的数字。汉字文化圈对四有一定禁忌，例如：一些住宅没有4座、4楼或4室。船舰的舷号、车辆的车牌号码及航空器注册编号常会避免出现4。", "In Chinese, Korean and Japanese, the pronunciation of \"four\" is similar to \"death\" and is considered an unlucky number. There are certain taboos about four in the Chinese character culture circle. For example, some houses do not have four blocks, four floors or four rooms. Ship's hull number, vehicle license plate number and aircraft registration number are often avoided. 4.");
    public static final QuestGroup ELECTRIC_AGE = new QuestGroup("electric_age", "电力时代", "Electric Age");
    public static final QuestChapter CHAPTER_5 = new QuestChapter(ELECTRIC_AGE, "chapter_5", "第五章", "Chapter 5");

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
        add(MECHANICAL_AGE);
        add(CHAPTER_1);
        add(CUT_LOGS_FIRST);
        add(CHAPTER_2);
        add(CHAPTER_3);
        add(CHAPTER_4);
        add(CHAPTER_4_PASS);
        add(ELECTRIC_AGE);
        add(CHAPTER_5);
    }
}