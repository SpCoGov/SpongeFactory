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

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SimpleFoiledItem;
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
    public static final ItemMapping<Item> FURNACE_LINING = defaultMaterialItem("Furnace Lining", "熔炉内衬", "furnace_lining");
    public static final ItemMapping<Item> HIGH_TEMPERATURE_RESISTANT_LINING = defaultMaterialItem("High Temperature Resistant Lining", "耐高温内衬", "high_temperature_resistant_lining");
    public static final ItemMapping<Item> COKE_OVEN_LINING = defaultMaterialItem("Coke Oven Lining", "焦炉内衬", "coke_oven_lining");
    public static final ItemMapping<Item> MYSTERIUM_LINING = defaultMaterialItem("Mysterium Lining", "神秘元质内衬", "mysterium_lining");
    public static final ItemMapping<Item> QUICKLIME = defaultMaterialItem("Quicklime", "生石灰", "quicklime");
    public static final ItemMapping<Item> SLAKED_LIME = defaultMaterialItem("Slaked Lime", "熟石灰", "slaked_lime");
    public static final ItemMapping<Item> STONE_HAMMER = item("Stone Hammer", "石锤", "stone_hammer",
            () -> new Item(new Item.Properties().durability(64).tab(ModCreativeModTabs.TOOL.get())));
    public static final ItemMapping<Item> POLISHED_BLACK_CORUNDUM = defaultMaterialItem("Polished Black Corundum", "磨制黑色刚玉", "polished_black_corundum");
    public static final ItemMapping<Item> POLISHED_BLUE_CORUNDUM = defaultMaterialItem("Polished Blue Corundum", "磨制蓝色刚玉", "polished_blue_corundum");
    public static final ItemMapping<Item> POLISHED_GREEN_CORUNDUM = defaultMaterialItem("Polished Green Corundum", "磨制绿色刚玉", "polished_green_corundum");
    public static final ItemMapping<Item> POLISHED_INDIGO_CORUNDUM = defaultMaterialItem("Polished Indigo Corundum", "磨制靛蓝色刚玉", "polished_indigo_corundum");
    public static final ItemMapping<Item> POLISHED_ORANGE_CORUNDUM = defaultMaterialItem("Polished Orange Corundum", "磨制橙色刚玉", "polished_orange_corundum");
    public static final ItemMapping<Item> POLISHED_RED_CORUNDUM = defaultMaterialItem("Polished Red Corundum", "磨制红色刚玉", "polished_red_corundum");
    public static final ItemMapping<Item> POLISHED_VIOLET_CORUNDUM = defaultMaterialItem("Polished Violet Corundum", "磨制蓝紫色刚玉", "polished_violet_corundum");
    public static final ItemMapping<Item> POLISHED_WHITE_CORUNDUM = defaultMaterialItem("Polished White Corundum", "磨制白色刚玉", "polished_white_corundum");
    public static final ItemMapping<Item> POLISHED_YELLOW_CORUNDUM = defaultMaterialItem("Polished Yellow Corundum", "磨制黄色刚玉", "polished_yellow_corundum");
    public static final ItemMapping<Item> STRESS_ENDURANCE_MECHANISM = defaultMaterialItem("Stress Endurance Mechanism", "耐应力构件", "stress_endurance_mechanism");
    public static final ItemMapping<Item> INERT_STRESS_ENDURANCE_MECHANISM = defaultMaterialItem("Inert Stress Endurance Mechanism", "惰性耐应力构件", "inert_stress_endurance_mechanism");
    public static final ItemMapping<Item> STRESS_RESISTANCE_MECHANISM = defaultMaterialItem("Stress Resistance Mechanism", "抗应力构件", "stress_resistance_mechanism");
    public static final ItemMapping<Item> YIELDING_MECHANISM = defaultMaterialItem("Yielding Mechanism", "顺应力构件", "yielding_mechanism");
    public static final ItemMapping<Item> IMPURE_CRUSHED_COPPER_ORE = defaultMaterialItem("Impure Crushed Copper Ore", "含杂的破碎铜矿石", "impure_crushed_copper_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_IRON_ORE = defaultMaterialItem("Impure Crushed Iron Ore", "含杂的破碎铁矿石", "impure_crushed_iron_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_ZINC_ORE = defaultMaterialItem("Impure Crushed Zinc Ore", "含杂的破碎锌矿石", "impure_crushed_zinc_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_GOLD_ORE = defaultMaterialItem("Impure Crushed Gold Ore", "含杂的破碎金矿石", "impure_crushed_gold_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_NICKEL_ORE = defaultMaterialItem("Impure Crushed Nickel Ore", "含杂的破碎镍矿石", "impure_crushed_nickel_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_ALUMINUM_ORE = defaultMaterialItem("Impure Crushed Aluminum Ore", "含杂的破碎铝矿石", "impure_crushed_aluminum_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_SILVER_ORE = defaultMaterialItem("Impure Crushed Silver Ore", "含杂的破碎银矿石", "impure_crushed_silver_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_OSMIUM_ORE = defaultMaterialItem("Impure Crushed Silver Ore", "含杂的破碎锇矿石", "impure_crushed_osmium_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_TIN_ORE = defaultMaterialItem("Impure Crushed Silver Ore", "含杂的破碎锡矿石", "impure_crushed_tin_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_LEAD_ORE = defaultMaterialItem("Impure Crushed Lead Ore", "含杂的破碎铅矿石", "impure_crushed_lead_ore");
    public static final ItemMapping<Item> IMPURE_CRUSHED_URANIUM_ORE = defaultMaterialItem("Impure Crushed Uranium Ore", "含杂的破碎铀矿石", "impure_crushed_uranium_ore");
    public static final ItemMapping<Item> CRUSHED_COPPER_ORE = defaultMaterialItem("Crushed Copper Ore", "破碎的铜矿石", "crushed_copper_ore");
    public static final ItemMapping<Item> CRUSHED_IRON_ORE = defaultMaterialItem("Crushed Iron Ore", "破碎的铁矿石", "crushed_iron_ore");
    public static final ItemMapping<Item> CRUSHED_ZINC_ORE = defaultMaterialItem("Crushed Zinc Ore", "破碎的锌矿石", "crushed_zinc_ore");
    public static final ItemMapping<Item> CRUSHED_GOLD_ORE = defaultMaterialItem("Crushed Gold Ore", "破碎的金矿石", "crushed_gold_ore");
    public static final ItemMapping<Item> CRUSHED_NICKEL_ORE = defaultMaterialItem("Crushed Nickel Ore", "破碎的镍矿石", "crushed_nickel_ore");
    public static final ItemMapping<Item> CRUSHED_ALUMINUM_ORE = defaultMaterialItem("Crushed Aluminum Ore", "破碎的铝矿石", "crushed_aluminum_ore");
    public static final ItemMapping<Item> CRUSHED_SILVER_ORE = defaultMaterialItem("Crushed Silver Ore", "破碎的银矿石", "crushed_silver_ore");
    public static final ItemMapping<Item> CRUSHED_OSMIUM_ORE = defaultMaterialItem("Crushed Osmium Ore", "破碎的锇矿石", "crushed_osmium_ore");
    public static final ItemMapping<Item> CRUSHED_TIN_ORE = defaultMaterialItem("Crushed Tin Ore", "破碎的锡矿石", "crushed_tin_ore");
    public static final ItemMapping<Item> CRUSHED_URANIUM_ORE = defaultMaterialItem("Crushed Uranium Ore", "破碎的铀矿石", "crushed_uranium_ore");
    public static final ItemMapping<Item> CRUSHED_LEAD_ORE = defaultMaterialItem("Crushed Lead Ore", "破碎的铅矿石", "crushed_lead_ore");
    public static final ItemMapping<Item> GROUND_COPPER_ORE = defaultMaterialItem("Ground Copper Ore", "粉碎的铜矿石", "ground_copper_ore");
    public static final ItemMapping<Item> GROUND_IRON_ORE = defaultMaterialItem("Ground Iron Ore", "粉碎的铁矿石", "ground_iron_ore");
    public static final ItemMapping<Item> GROUND_ZINC_ORE = defaultMaterialItem("Ground Zinc Ore", "粉碎的锌矿石", "ground_zinc_ore");
    public static final ItemMapping<Item> GROUND_GOLD_ORE = defaultMaterialItem("Ground Gold Ore", "粉碎的金矿石", "ground_gold_ore");
    public static final ItemMapping<Item> GROUND_NICKEL_ORE = defaultMaterialItem("Ground Nickel Ore", "粉碎的镍矿石", "ground_nickel_ore");
    public static final ItemMapping<Item> GROUND_ALUMINUM_ORE = defaultMaterialItem("Ground Aluminum Ore", "粉碎的铝矿石", "ground_aluminum_ore");
    public static final ItemMapping<Item> GROUND_SILVER_ORE = defaultMaterialItem("Ground Silver Ore", "粉碎的银矿石", "ground_silver_ore");
    public static final ItemMapping<Item> GROUND_OSMIUM_ORE = defaultMaterialItem("Ground Osmium Ore", "粉碎的锇矿石", "ground_osmium_ore");
    public static final ItemMapping<Item> GROUND_TIN_ORE = defaultMaterialItem("Ground Tin Ore", "粉碎的锡矿石", "ground_tin_ore");
    public static final ItemMapping<Item> GROUND_LEAD_ORE = defaultMaterialItem("Ground Lead Ore", "粉碎的铅矿石", "ground_lead_ore");
    public static final ItemMapping<Item> GROUND_URANIUM_ORE = defaultMaterialItem("Ground Uranium Ore", "粉碎的铀矿石", "ground_uranium_ore");
    public static final ItemMapping<Item> CHARCOAL_COPPER_ORE_MIXTURE = defaultMaterialItem("Charcoal-Copper Ore Mixture", "木炭铜矿混合物", "charcoal_copper_ore_mixture");
    public static final ItemMapping<Item> CHARCOAL_IRON_ORE_MIXTURE = defaultMaterialItem("Charcoal-Iron Ore Mixture", "木炭铁矿混合物", "charcoal_iron_ore_mixture");
    public static final ItemMapping<Item> CHARCOAL_ZINC_ORE_MIXTURE = defaultMaterialItem("Charcoal-Zinc Ore Mixture", "木炭锌矿混合物", "charcoal_zinc_ore_mixture");
    public static final ItemMapping<Item> CHARCOAL_SILVER_ORE_MIXTURE = defaultMaterialItem("Charcoal-Silver Ore Mixture", "木炭银矿混合物", "charcoal_silver_ore_mixture");
    public static final ItemMapping<Item> CHARCOAL_TIN_ORE_MIXTURE = defaultMaterialItem("Charcoal-Tin Ore Mixture", "木炭锡矿混合物", "charcoal_tin_ore_mixture");
    public static final ItemMapping<Item> CHARCOAL_LEAD_ORE_MIXTURE = defaultMaterialItem("Charcoal-Lead Ore Mixture", "木炭铅矿混合物", "charcoal_lead_ore_mixture");
    public static final ItemMapping<Item> NEGATIVE_ENTHALPY_CHANGE_CYCLE_CATALYST = defaultMaterialItem("Adsorption-Desorption Negative Enthalpy Change Cycle Catalyst",
            "吸附-脱附负焓变循环催化剂", "negative_enthalpy_change_cycle_catalyst");
    public static final ItemMapping<Item> SCRIBING_TOOLS = defaultMaterialItem("Scribing Tools", "笔与墨", "scribing_tools");
    public static final ItemMapping<Item> OTHERWORLD_ELECTRUM_INGOT = defaultMaterialItem("Otherworld Electrum Ingot", "异界琥珀金锭", "otherworld_electrum_ingot");
    public static final ItemMapping<Item> INFUSED_BRASS = defaultMaterialItem("Infused Brass", "灌注黄铜", "infused_brass");
    public static final ItemMapping<SimpleFoiledItem> HOLY_SHIT = item("Holy Shit", "上帝的屎", "holy_shit",
            () -> new SimpleFoiledItem((new Item.Properties()).tab(ModCreativeModTabs.MATERIAL.get()).rarity(Rarity.create("HOLY", ChatFormatting.GOLD))));
    public static final ItemMapping<Item> PLASTIC_LATTICE = defaultMaterialItem("Plastic Lattice", "塑料格栅", "plastic_lattice");
    public static final ItemMapping<Item> DISTILLATION_FILLER = defaultMaterialItem("Distillation Filler", "蒸馏填料", "distillation_filler");
    public static final ItemMapping<Item> SPARK_PLUG = defaultMaterialItem("Spark Plug", "火花塞", "spark_plug");
    public static final ItemMapping<Item> ENGINE_BLOCK = defaultMaterialItem("Engine Block", "气缸", "engine_block");
    public static final ItemMapping<Item> PRIMARY_COIL = defaultMaterialItem("Primary Coil", "初级线圈", "primary_coil");
    public static final ItemMapping<Item> SECONDARY_COIL = defaultMaterialItem("Secondary Coil", "次级线圈", "secondary_coil");
    public static final ItemMapping<Item> IGNITION_COIL = defaultMaterialItem("Ignition Coil", "放电线圈", "ignition_coil");
    public static final ItemMapping<Item> INTERNAL_COMBUSTION_ENGINE = defaultMaterialItem("Internal Combustion Engine", "内燃机", "internal_combustion_engine");
    public static final ItemMapping<Item> MAGNET_WIRE = defaultMaterialItem("Magnet Wire", "漆包线", "magnet_wire");

    private static ItemMapping<Item> defaultMaterialItem(String englishName, String chineseName, String id) {
        return item(englishName, chineseName, id, () -> new Item(new Item.Properties().tab(ModCreativeModTabs.MATERIAL.get())));
    }

    private static <T extends Item> @NotNull ItemMapping<T> item(String englishName, String chineseName, String id, Supplier<T> item) {
        return item(englishName, chineseName, id, item, false);
    }

    static <T extends Item> @NotNull ItemMapping<T> item(String englishName, String chineseName, String id, Supplier<T> item, boolean isBlockItem) {
        RegistryObject<T> registeredItem = REGISTER.register(id, item);

        var itemDef = new ItemMapping<>(englishName, chineseName, id, registeredItem, isBlockItem);
        ITEMS.add(itemDef);
        return itemDef;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}