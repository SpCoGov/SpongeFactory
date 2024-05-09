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

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * A class representing the mapping of an {@link CreativeModeTab}.
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class CreativeModeTabMapping extends Translatable {
    private final CreativeModeTab tab;

    public CreativeModeTabMapping(String englishName, String chineseName, String id, @NotNull Supplier<ItemStack> icon) {
        super(englishName, chineseName, "itemGroup." + id);
        this.tab = new CreativeModeTab(id) {
            @Override
            public @NotNull ItemStack makeIcon() {
                return icon.get();
            }
        };
    }

    public CreativeModeTab get() {
        return tab;
    }
}