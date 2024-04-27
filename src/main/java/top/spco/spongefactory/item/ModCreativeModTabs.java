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
package top.spco.spongefactory.item;

import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.infrastructure.CreativeModeTabMapping;

import java.util.HashSet;
import java.util.function.Supplier;

/**
 * SpongeFactory's CreativeMode tabs
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class ModCreativeModTabs {
    public static final HashSet<CreativeModeTabMapping> TABS = new HashSet<>();
    public static final CreativeModeTabMapping MATERIAL_TAB = tab("SpongeFactory: Material", "海绵工厂：材料", "material",
            () -> new ItemStack(ModItems.FURNACE_LINING.getRegisteredItem().get()));

    private static CreativeModeTabMapping tab(String englishName, String chineseName, String id, @NotNull Supplier<ItemStack> icon) {
        CreativeModeTabMapping tab = new CreativeModeTabMapping(englishName, chineseName, id, icon);
        TABS.add(tab);
        return tab;
    }

}