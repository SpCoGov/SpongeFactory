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
package top.spco.spongefactory.registries;

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
    public static final CreativeModeTabMapping MATERIAL = tab("SpongeFactory: Material", "海绵工厂：材料", "material",
            () -> new ItemStack(ModItems.MYSTERIUM_LINING));

    public static final CreativeModeTabMapping TOOL = tab("SpongeFactory: Tool", "海绵工厂：工具", "tool",
            () -> new ItemStack(ModItems.STONE_HAMMER));

    public static final CreativeModeTabMapping BLOCK = tab("SpongeFactory: Block", "海绵工厂：方块", "block",
            () -> new ItemStack(ModItems.MAGNET_WIRE));

    private static CreativeModeTabMapping tab(String englishName, String chineseName, String id, @NotNull Supplier<ItemStack> icon) {
        CreativeModeTabMapping tab = new CreativeModeTabMapping(englishName, chineseName, id, icon);
        TABS.add(tab);
        return tab;
    }

}