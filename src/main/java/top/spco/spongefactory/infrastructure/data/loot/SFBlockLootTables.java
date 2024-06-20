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
package top.spco.spongefactory.infrastructure.data.loot;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.infrastructure.BlockMapping;
import top.spco.spongefactory.registries.SFBlocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Generate block's loottables
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class SFBlockLootTables extends BlockLoot {
    private final HashSet<BlockMapping<?>> skip = new HashSet<>();

    public SFBlockLootTables() {
        skip.add(SFBlocks.MASS_ENERGY_CONVERTER);
        skip.add(SFBlocks.TITANIUM_ORE);
        skip.add(SFBlocks.DEEPSLATE_TITANIUM_ORE);
        skip.add(SFBlocks.MAGNETIZER);
        skip.add(SFBlocks.FLUIDIZED_BED_REACTOR);
    }

    @Override
    protected void addTables() {
        for (BlockMapping<?> block : SFBlocks.BLOCKS) {
            if (skip.contains(block)) {
                continue;
            }
            dropSelf(block.getRegisteredBlock().get());
        }
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        Collection<RegistryObject<Block>> entries = SFBlocks.REGISTER.getEntries();
        Collection<RegistryObject<Block>> filtered = new ArrayList<>();
        HashSet<RegistryObject<? extends Block>> skipRegistryObject = new HashSet<>();
        for (var object : skip) {
            skipRegistryObject.add(object.getRegisteredBlock());
        }
        for (RegistryObject<Block> entry : entries) {
            if (skipRegistryObject.contains(entry)) {
                continue;
            }
            filtered.add(entry);
        }
        return filtered.stream().flatMap(RegistryObject::stream)::iterator;
    }
}