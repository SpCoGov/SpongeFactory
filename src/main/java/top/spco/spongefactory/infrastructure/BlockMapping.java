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
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;

/**
 * A class representing the mapping of an {@link Block}.
 *
 * @param <T> The type of the block
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class BlockMapping<T extends Block> extends Translatable implements ItemLike {
    private final String id;
    private final RegistryObject<T> block;
    private final ItemMapping<BlockItem> blockItem;

    public BlockMapping(String englishName, String chineseName, String id, RegistryObject<T> block, ItemMapping<BlockItem> blockItem) {
        super(englishName, chineseName, "block." + SpongeFactory.MOD_ID + "." + id);
        this.id = id;
        this.block = block;
        this.blockItem = blockItem;
    }

    public RegistryObject<T> getRegisteredBlock() {
        return block;
    }

    public ItemMapping<BlockItem> getRegisteredBlockItem() {
        return blockItem;
    }

    public BlockRegistryObject<T, BlockItem> toMekRegistryObject() {
        return new BlockRegistryObject<>(block, blockItem.getRegisteredItem());
    }

    @Override
    public @NotNull Item asItem() {
        return blockItem.getItem();
    }
}