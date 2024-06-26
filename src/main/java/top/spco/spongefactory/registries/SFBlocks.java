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
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.block.StorageStabilizerBaseBlock;
import top.spco.spongefactory.block.TileEntityMassEnergyConverter;
import top.spco.spongefactory.blocktype.SFMachine;
import top.spco.spongefactory.infrastructure.BlockMapping;
import top.spco.spongefactory.infrastructure.ItemMapping;
import top.spco.spongefactory.item.ItemMachine;

import java.util.HashSet;
import java.util.function.Supplier;

public class SFBlocks {
    public static final HashSet<BlockMapping<?>> BLOCKS = new HashSet<>();
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, SpongeFactory.MOD_ID);
    public static final BlockMapping<Block> PORTAL_FRAME = blockWithItem("Portal Frame", "传送门框架", "portal_frame",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).
                    requiresCorrectToolForDrops().strength(50.0F, 1200.0F)));
    public static final BlockMapping<DropExperienceBlock> TITANIUM_ORE = blockWithItem("Titanium Ore", "钛矿石", "titanium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).color(MaterialColor.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.STONE)));
    public static final BlockMapping<DropExperienceBlock> DEEPSLATE_TITANIUM_ORE = blockWithItem("Deepslate Titanium Ore", "深层钛矿石", "deepslate_titanium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(TITANIUM_ORE.getRegisteredBlock().get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    public static final BlockMapping<Block> SHEETMETAL_SOURCE_STEEL = blockWithItem("Source Steel Sheetmetal", "魔源钢板金属", "sheetmetal_source_steel",
            () -> new Block(Block.Properties.of(Material.METAL).sound(SoundType.METAL).strength(2, 2)));
    public static final BlockMapping<BlockTileModel<TileEntityMassEnergyConverter, SFMachine<TileEntityMassEnergyConverter>>> MASS_ENERGY_CONVERTER = blockWithItem(
            "Mass-Energy Converter", "质能转换器", "mass_energy_converter", () -> new BlockTileModel<>(SFBlockTypes.MASS_ENERGY_CONVERTER),
            () -> new ItemMachine(SFBlocks.MASS_ENERGY_CONVERTER.getRegisteredBlock().get(), new Item.Properties().stacksTo(1).tab(SFCreativeModTabs.BLOCK.get())));
    public static final BlockMapping<StorageStabilizerBaseBlock> STORAGE_STABILIZER_BASE = blockWithItem("Storage Stabilizer Base", "存储稳定器基座", "storage_stabilizer_base", () -> new StorageStabilizerBaseBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5f, 30).noOcclusion()));
    public static final BlockMapping<Block> UNPROCESSED_MACHINE_FRAME = blockWithItem("Unprocessed Machine Frame", "未处理的机器框架", "unprocessed_machine_frame", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.LANTERN).strength(2.0F).noOcclusion()));

    private static <T extends Block> @NotNull BlockMapping<T> blockWithItem(String englishName, String chineseName, String id,
                                                                            Supplier<T> block) {
        return blockWithItem(englishName, chineseName, id, block, SFCreativeModTabs.BLOCK.get());
    }

    private static <T extends Block> ItemMapping<BlockItem> blockItem(String englishName, String chineseName, String id, RegistryObject<T> block,
                                                                      CreativeModeTab tab) {
        return SFItems.item(englishName, chineseName, id, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)), true);
    }

    private static <T extends BlockItem> ItemMapping<T> blockItem(String englishName, String chineseName, String id, Supplier<T> blockItem) {
        return SFItems.item(englishName, chineseName, id, blockItem, true);
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