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

    public static final ItemMapping<Item> QUICKLIME = item("Quicklime", "生石灰", "quicklime",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<Item> SLAKED_LIME = item("Slaked Lime", "熟石灰", "slaked_lime",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<Item> STONE_HAMMER = item("Stone Hammer", "石锤", "stone_hammer",
            () -> new Item(new Item.Properties().durability(64).tab(ModCreativeModTabs.TOOL_TAB)));

    public static final ItemMapping<Item> IMPURE_CRUSHED_COPPER_ORE = item("Impure Crushed Copper Ore", "含杂的破碎铜矿石","impure_crushed_copper_ore",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<Item> CRUSHED_COPPER_ORE = item("Crushed Copper Ore", "破碎的铜矿石","crushed_copper_ore",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<Item> GROUND_COPPER_ORE = item("Ground Copper Ore", "粉碎的铜矿石","ground_copper_ore",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<Item> CHARCOAL_COPPER_ORE_MIXTURE = item("Charcoal-Copper Ore Mixture", "木炭铜矿混合物","charcoal_copper_ore_mixture",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<Item> IMPURE_CRUSHED_IRON_ORE = item("Impure Crushed Iron Ore", "含杂的破碎铁矿石","impure_crushed_iron_ore",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<Item> CRUSHED_IRON_ORE = item("Crushed Copper Ore", "破碎的铁矿石","crushed_iron_ore",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<Item> GROUND_IRON_ORE = item("Ground Iron Ore", "粉碎的铁矿石","ground_iron_ore",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

    public static final ItemMapping<Item> CHARCOAL_IRON_ORE_MIXTURE = item("Charcoal-Iron Ore Mixture", "木炭铁矿混合物","charcoal_iron_ore_mixture",
            () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL_TAB)));

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