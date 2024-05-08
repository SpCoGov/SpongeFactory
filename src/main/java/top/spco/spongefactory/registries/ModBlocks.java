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

import mekanism.common.registration.impl.BlockDeferredRegister;
import mekanism.common.registration.impl.BlockRegistryObject;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.BlockMapping;

import java.util.HashSet;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final HashSet<BlockMapping<?, ?>> BLOCKS = new HashSet<>();
    public static final BlockDeferredRegister REGISTER = new BlockDeferredRegister(SpongeFactory.MOD_ID);


    private static <BLOCK extends Block, ITEM extends BlockItem> @NotNull BlockMapping<BLOCK, ITEM> block(String englishName, String chineseName, String id,
                                                                                                          Supplier<? extends BLOCK> block, Function<BLOCK, ITEM> itemCreator) {
        BlockRegistryObject<BLOCK, ITEM> registeredBlock = REGISTER.register(id, block, itemCreator);

        var blockMapping = new BlockMapping<>(englishName, chineseName, id, registeredBlock);
        BLOCKS.add(blockMapping);
        return blockMapping;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}