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

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.BlockMapping;
import top.spco.spongefactory.infrastructure.ItemMapping;

import java.util.HashSet;
import java.util.function.Supplier;

public class ModBlocks {
    public static final HashSet<BlockMapping<?>> BLOCKS = new HashSet<>();
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, SpongeFactory.MOD_ID);
    public static final BlockMapping<Block> TEST_BLOCK = blockWithItem("testBlock", "测试方块", "test_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1F)));

    private static <T extends Block> @NotNull BlockMapping<T> blockWithItem(String englishName, String chineseName, String id,
                                                                            Supplier<T> block) {
        return blockWithItem(englishName, chineseName, id, block, ModCreativeModTabs.BLOCK.get());
    }

    private static <T extends Block> ItemMapping<BlockItem> blockItem(String englishName, String chineseName, String id, RegistryObject<T> block,
                                                                      CreativeModeTab tab) {
        return ModItems.item(englishName,chineseName,id,() -> new BlockItem(block.get(), new Item.Properties().tab(tab)), true);
    }

    private static <T extends Block> @NotNull BlockMapping<T> blockWithItem(String englishName, String chineseName, String id,
                                                                            Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> registeredBlock = REGISTER.register(id, block);

        var blockMapping = new BlockMapping<>(englishName, chineseName, id, registeredBlock,
                blockItem(englishName, chineseName, id, registeredBlock, tab));
        BLOCKS.add(blockMapping);
        return blockMapping;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}