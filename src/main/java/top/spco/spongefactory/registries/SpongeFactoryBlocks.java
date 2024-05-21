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

import mekanism.common.block.prefab.BlockTile.BlockTileModel;
import mekanism.common.item.block.machine.ItemBlockMachine;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.block.TileEntityMassEnergyConverter;
import top.spco.spongefactory.blocktype.SpongeFactoryMachine;
import top.spco.spongefactory.infrastructure.BlockMapping;
import top.spco.spongefactory.infrastructure.ItemMapping;

import java.util.HashSet;
import java.util.function.Supplier;

public class SpongeFactoryBlocks {
    public static final HashSet<BlockMapping<?>> BLOCKS = new HashSet<>();
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, SpongeFactory.MOD_ID);
    public static final BlockMapping<Block> PORTAL_FRAME = blockWithItem("Portal Frame", "传送门框架", "portal_frame",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).
                    requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
    public static final BlockMapping<BlockTileModel<TileEntityMassEnergyConverter, SpongeFactoryMachine<TileEntityMassEnergyConverter>>> MASS_ENERGY_CONVERTER = blockWithItem(
            "Mass-Energy Converter", "质能转换器", "mass_energy_converter", () -> new BlockTileModel<>(SpongeFactoryBlockTypes.MASS_ENERGY_CONVERTER),
            () -> new ItemBlockMachine(SpongeFactoryBlocks.MASS_ENERGY_CONVERTER.getRegisteredBlock().get())
    );

    private static <T extends Block> @NotNull BlockMapping<T> blockWithItem(String englishName, String chineseName, String id,
                                                                            Supplier<T> block) {
        return blockWithItem(englishName, chineseName, id, block, SpongeFactoryCreativeModTabs.BLOCK.get());
    }

    private static <T extends Block> ItemMapping<BlockItem> blockItem(String englishName, String chineseName, String id, RegistryObject<T> block,
                                                                      CreativeModeTab tab) {
        return SpongeFactoryItems.item(englishName, chineseName, id, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)), true);
    }

    private static <T extends BlockItem> ItemMapping<T> blockItem(String englishName, String chineseName, String id, Supplier<T> blockItem) {
        return SpongeFactoryItems.item(englishName, chineseName, id, blockItem, true);
    }

    private static <T extends Block> @NotNull BlockMapping<T> blockWithItem(String englishName, String chineseName, String id,
                                                                            Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> registeredBlock = REGISTER.register(id, block);

        var blockMapping = new BlockMapping<>(englishName, chineseName, id, registeredBlock,
                blockItem(englishName, chineseName, id, registeredBlock, tab));
        BLOCKS.add(blockMapping);
        return blockMapping;
    }

    private static <T extends Block, I extends BlockItem> @NotNull BlockMapping<T> blockWithItem(String englishName, String chineseName, String id,
                                                                                                 Supplier<T> block, Supplier<I> blockItem) {
        RegistryObject<T> registeredBlock = REGISTER.register(id, block);
        var blockMapping = new BlockMapping<>(englishName, chineseName, id, registeredBlock,
                blockItem(englishName, chineseName, id, blockItem));
        BLOCKS.add(blockMapping);
        return blockMapping;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}