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

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;

/**
 * A class representing the mapping of an {@link Item}.
 *
 * @param <T> The type of the item
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class ItemMapping<T extends Item> implements ItemLike, Translatable {
    private final String englishName;
    private final String chineseName;
    private final String id;
    private final String translationKey;
    private final RegistryObject<T> item;

    public ItemMapping(String englishName, String chineseName, String id, RegistryObject<T> item) {
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.id = id;
        this.translationKey = "item." + SpongeFactory.MOD_ID + "." + id;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public T getItem() {
        return item.get();
    }

    public RegistryObject<T> getRegisteredItem() {
        return item;
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

    @Override
    public @NotNull Item asItem() {
        return getItem();
    }
}