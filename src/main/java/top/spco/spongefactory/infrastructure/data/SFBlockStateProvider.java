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
package top.spco.spongefactory.infrastructure.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.BlockMapping;
import top.spco.spongefactory.registries.SFBlocks;

import java.util.HashSet;

/**
 * Generate blockstates
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class SFBlockStateProvider extends BlockStateProvider {
    public SFBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, SpongeFactory.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        HashSet<BlockMapping<?>> skip = new HashSet<>();
        skip.add(SFBlocks.MASS_ENERGY_CONVERTER);
        skip.add(SFBlocks.STORAGE_STABILIZER_BASE);
        skip.add(SFBlocks.UNPROCESSED_MACHINE_FRAME);
        skip.add(SFBlocks.ADVANCED_MACHINE_FRAME);
        skip.add(SFBlocks.TIME_STORAGE_CONTROLLER);
        skip.add(SFBlocks.MAGNETIZER);
        for (BlockMapping<?> block : SFBlocks.BLOCKS) {
            if (skip.contains(block)) {
                continue;
            }
            blockWithItem(block);
        }
    }

    private void blockWithItem(BlockMapping<?> block) {
        simpleBlock(block.getRegisteredBlock().get(), cubeAll(block.getRegisteredBlock().get()));
        simpleBlockItem(block.getRegisteredBlock().get(), cubeAll(block.getRegisteredBlock().get()));
    }
}