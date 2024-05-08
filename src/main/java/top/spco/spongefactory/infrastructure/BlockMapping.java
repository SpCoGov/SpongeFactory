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

import mekanism.common.registration.impl.BlockRegistryObject;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import top.spco.spongefactory.SpongeFactory;

/**
 * A class representing the mapping of an {@link Block}.
 *
 * @param <BLOCK> The type of the block
 * @param <ITEM>  The type of the blockItem
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class BlockMapping<BLOCK extends Block, ITEM extends BlockItem> implements Translatable {
    private final String englishName;
    private final String chineseName;
    private final String id;
    private final String translationKey;
    private final BlockRegistryObject<BLOCK, ITEM> block;

    public BlockMapping(String englishName, String chineseName, String id, BlockRegistryObject<BLOCK, ITEM> block) {
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.id = id;
        this.translationKey = "block." + SpongeFactory.MOD_ID + "." + id;
        this.block = block;
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
}