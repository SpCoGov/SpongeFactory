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

/**
 * Represents a translatable object for automatic generation of lang json.<p>
 * Implementing classes provide methods to retrieve the names and translation key
 * of the object in both English and Chinese.
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public interface Translatable {
    /**
     * Gets the name of the object in Chinese.
     *
     * @return The name of the object in Chinese
     */
    String getChineseName();

    /**
     * Gets the name of the object in English.
     *
     * @return The name of the object in English
     */
    String getEnglishName();

    /**
     * Gets the translation key of the object.
     *
     * @return The translation key of the object
     */
    String getTranslationKey();
}