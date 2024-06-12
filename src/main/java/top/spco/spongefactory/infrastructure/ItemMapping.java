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

import java.util.HashSet;

/**
 * A class representing the mapping of an {@link Item}.
 *
 * @param <T> The type of the item
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class ItemMapping<T extends Item> extends ObjectMapping<Item> implements ItemLike {
    private final String id;
    private final RegistryObject<T> item;
    private final boolean isBlockItem;
    private final HashSet<ItemDerivative> derivatives = new HashSet<>();

    public ItemMapping(String englishName, String chineseName, String id, RegistryObject<T> item, boolean isBlockItem) {
        super(englishName, chineseName, "item." + SpongeFactory.MOD_ID + "." + id);
        this.id = id;
        this.item = item;
        this.isBlockItem = isBlockItem;
    }

    public ItemMapping(String englishName, String chineseName, String id, RegistryObject<T> item) {
        this(englishName, chineseName, id, item, false);
    }

    public boolean isBlockItem() {
        return isBlockItem;
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
    public @NotNull Item asItem() {
        return getItem();
    }

    public ItemMapping<T> addDerivative(ItemDerivative derivative) {
        derivatives.add(derivative);
        return this;
    }

    public HashSet<ItemDerivative> getDerivatives() {
        return derivatives;
    }

    public boolean hasDerivative() {
        return !derivatives.isEmpty();
    }
}