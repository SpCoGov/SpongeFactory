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

import net.minecraft.world.item.Item;
import top.spco.spongefactory.registries.ModCreativeModTabs;

/**
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class HammerItem extends Item {
    public HammerItem(int durability) {
        super(new Properties().durability(durability).tab(ModCreativeModTabs.TOOL.get()).defaultDurability(durability));
    }
}