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

import appeng.api.stacks.AEKeyType;
import appeng.items.storage.BasicStorageCell;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.ItemMapping;

import java.util.HashSet;
import java.util.function.Supplier;

/**
 * SpongeFactory's items
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class ModItems {
    public static final HashSet<ItemMapping<?>> ITEMS = new HashSet<>();
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, SpongeFactory.MOD_ID);
    public static final ItemMapping<Item> FURNACE_LINING = item("Furnace Lining", "熔炉内衬", "furnace_lining",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<BasicStorageCell> TEST_CELL = item("Test Cell", "测试磁盘", "test_cell",
            () -> new BasicStorageCell(new Item.Properties().stacksTo(1).tab(ModCreativeModTabs.MATERIAL_TAB), Items.ACACIA_LEAVES, Items.ACACIA_LOG,
                    2.0F, 999998,9999, 99, AEKeyType.items()));

    private static <T extends Item> @NotNull ItemMapping<T> item(String englishName, String chineseName, String id, Supplier<T> item) {
        RegistryObject<T> registeredItem = REGISTER.register(id, item);

        var itemDef = new ItemMapping<>(englishName, chineseName, id, registeredItem);
        ITEMS.add(itemDef);
        return itemDef;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}