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

import appeng.api.stacks.AEKeyType;
import cofh.core.item.CoinItem;
import cofh.core.item.CountedItem;
import cofh.core.item.ItemCoFH;
import cofh.core.util.helpers.AugmentDataHelper;
import cofh.thermal.lib.item.AugmentItem;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SimpleFoiledItem;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.spco.spongefactory.Colors;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.ItemMapping;
import top.spco.spongefactory.item.*;

import java.util.HashSet;
import java.util.function.Supplier;

import static cofh.lib.util.constants.NBTTags.*;

/**
 * SpongeFactory's items
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
@SuppressWarnings("unused")
public class SFItems {
    public static final HashSet<ItemMapping<?>> ITEMS = new HashSet<>();
    public static final HashSet<ItemMapping<DustItem>> DUST_ITEM = new HashSet<>();
    public static final HashSet<ItemMapping<IngotItem>> INGOT_ITEM = new HashSet<>();
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, SpongeFactory.MOD_ID);
    public static final ItemMapping<Item> FURNACE_LINING = defaultMaterialItem("Furnace Lining", "熔炉内衬", "furnace_lining");
    public static final ItemMapping<Item> HIGH_TEMPERATURE_RESISTANT_LINING = defaultMaterialItem("High Temperature Resistant Lining", "耐高温内衬", "high_temperature_resistant_lining");
    public static final ItemMapping<Item> COKE_OVEN_LINING = defaultMaterialItem("Coke Oven Lining", "焦炉内衬", "coke_oven_lining");
    public static final ItemMapping<Item> MYSTERIUM_LINING = defaultMaterialItem("Mysterium Lining", "神秘元质内衬", "mysterium_lining");
    public static final ItemMapping<Item> QUICKLIME = defaultMaterialItem("Quicklime", "生石灰", "quicklime");
    public static final ItemMapping<Item> SLAKED_LIME = defaultMaterialItem("Slaked Lime", "熟石灰", "slaked_lime");
    public static final ItemMapping<HammerItem> STONE_HAMMER = item("Stone Hammer", "石锤", "stone_hammer", () -> new HammerItem(64));
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
    public static final ItemMapping<Item> IMPURE_CRUSHED_TITANIUM_ORE = defaultMaterialItem("Impure Crushed Titanium Ore", "含杂的破碎钛矿石", "impure_crushed_titanium_ore");
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
    public static final ItemMapping<Item> CRUSHED_TITANIUM_ORE = defaultMaterialItem("Crushed Titanium Ore", "破碎的钛矿石", "crushed_titanium_ore");
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
    public static final ItemMapping<Item> NEGATIVE_ENTHALPY_CHANGE_CYCLE_CATALYST = defaultMaterialItem("Adsorption-Desorption Negative Enthalpy Change Cycle Catalyst", "吸附-脱附负焓变循环催化剂", "negative_enthalpy_change_cycle_catalyst");
    public static final ItemMapping<Item> SCRIBING_TOOLS = defaultMaterialItem("Scribing Tools", "笔与墨", "scribing_tools");
    public static final ItemMapping<Item> OTHERWORLD_ELECTRUM_INGOT = defaultMaterialItem("Otherworld Electrum Ingot", "异界琥珀金锭", "otherworld_electrum_ingot");
    public static final ItemMapping<Item> INFUSED_BRASS = defaultMaterialItem("Infused Brass", "灌注黄铜", "infused_brass");
    public static final ItemMapping<SimpleFoiledItem> HOLY_SHIT = item("Holy Shit", "上帝的屎", "holy_shit", () -> new SimpleFoiledItem((new Item.Properties()).tab(SFCreativeModTabs.MATERIAL.get()).rarity(Rarity.create("HOLY", ChatFormatting.GOLD))));
    public static final ItemMapping<Item> PLASTIC_LATTICE = defaultMaterialItem("Plastic Lattice", "塑料格栅", "plastic_lattice");
    public static final ItemMapping<Item> DISTILLATION_FILLER = defaultMaterialItem("Distillation Filler", "蒸馏填料", "distillation_filler");
    public static final ItemMapping<Item> SPARK_PLUG = defaultMaterialItem("Spark Plug", "火花塞", "spark_plug");
    public static final ItemMapping<Item> ENGINE_BLOCK = defaultMaterialItem("Engine Block", "气缸", "engine_block");
    public static final ItemMapping<Item> PRIMARY_COIL = defaultMaterialItem("Primary Coil", "初级线圈", "primary_coil");
    public static final ItemMapping<Item> SECONDARY_COIL = defaultMaterialItem("Secondary Coil", "次级线圈", "secondary_coil");
    public static final ItemMapping<Item> IGNITION_COIL = defaultMaterialItem("Ignition Coil", "放电线圈", "ignition_coil");
    public static final ItemMapping<Item> INTERNAL_COMBUSTION_ENGINE = defaultMaterialItem("Internal Combustion Engine", "内燃机", "internal_combustion_engine");
    public static final ItemMapping<Item> MAGNET_WIRE = defaultMaterialItem("Magnet Wire", "漆包线", "magnet_wire");
    public static final ItemMapping<Item> STATOR = defaultMaterialItem("Stator", "定子", "stator");
    public static final ItemMapping<Item> ROTOR = defaultMaterialItem("Rotor", "转子", "rotor");
    public static final ItemMapping<Item> FERROMAGNETIC_MATERIAL = defaultMaterialItem("Ferromagnetic Material", "铁磁材料", "ferromagnetic_material");
    public static final ItemMapping<Item> DIELECTRIC_PASTE_SHEET = defaultMaterialItem("Dielectric Paste Sheet", "绝缘覆层片", "dielectric_paste_sheet");
    public static final ItemMapping<Item> LOGO = defaultMaterialItem("Logo", "Logo", "logo");
    public static final ItemMapping<Item> HIGH_TEMPERATURE_DEPOSITION_SUBSTRATE = defaultMaterialItem("High Temperature Deposition Substrate", "高温沉积基底", "high_temperature_deposition_substrate");
    public static final ItemMapping<Item> SPACE_LINK_EYE = defaultMaterialItem("Eye of Space Link", "空间链接之眼", "space_link_eye");
    public static final ItemMapping<Item> BLACKSTONE_WITH_IRON = defaultMaterialItem("Blackstone With Iron", "含铁的黑石", "blackstone_with_iron");
    public static final ItemMapping<Item> BLACKSTONE_INGOT = defaultMaterialItem("Blackstone Ingot", "黑石锭", "blackstone_ingot");
    public static final ItemMapping<Item> SOURCE_STEEL_INGOT = defaultMaterialItem("Source Steel Ingot", "魔源钢锭", "source_steel_ingot");
    public static final Object SOURCE_STEEL_SET = registerMetalSet("source_steel", SFCreativeModTabs.MATERIAL.get(), Rarity.COMMON);
    public static final ItemMapping<Item> BLANK_ADDON = defaultMaterialItem("Blank Addon", "空白插件", "blank_addon");
    public static final ItemMapping<Item> ADVANCED_BLANK_ADDON = defaultMaterialItem("Advanced Blank Addon", "高级空白插件", "advanced_blank_addon");
    public static final ItemMapping<Item> GOLD_PLATED_BRASS_INGOT = defaultMaterialItem("Gold Plated Brass Ingot", "镀金黄铜锭", "gold_plated_brass_ingot");
    public static final ItemMapping<Item> HEAT_RESISTANT_DIELECTRIC_PASTE_SHEET = defaultMaterialItem("Heat Resistant Dielectric Paste Sheet", "耐热绝缘覆层片", "heat_resistant_dielectric_paste_sheet");
    public static final ItemMapping<AugmentItem> CREATIVE_MACHINE_SPEED_AUGMENT = item("Creative Machine Speed Augment", "创造通量链接放大器", "creative_machine_speed_augment", () -> new AugmentItem(new Item.Properties().rarity(Rarity.EPIC).tab(SFCreativeModTabs.MATERIAL.get()), AugmentDataHelper.builder().type(TAG_AUGMENT_TYPE_MACHINE).mod(TAG_AUGMENT_MACHINE_SPEED, 5F).mod(TAG_AUGMENT_MACHINE_ENERGY, 0F).mod(TAG_AUGMENT_BASE_MOD, 20F).build()));
    public static final ItemMapping<Item> SOLVATION_FABRIC = defaultMaterialItem("Solvation Fabric", "溶剂化织物", "solvation_fabric");
    public static final ItemMapping<Item> COMPRESSED_AIR_BOTTLE = defaultMaterialItem("Compressed Air Bottle", "瓶装压缩空气", "compressed_air_bottle");
    public static final ItemMapping<DustItem> POTASSIUM_HYDROXIDE_DUST = dustItem("Potassium Hydroxide Dust", "氢氧化钾粉", "potassium_hydroxide_dust", Colors.POTASSIUM);
    public static final ItemMapping<IngotItem> CALCIUM_INGOT = ingotItem("Calcium Ingot", "钙锭", "calcium_ingot", Colors.CALCIUM);
    public static final ItemMapping<IngotItem> POTASSIUM_INGOT = ingotItem("Potassium Ingot", "钾锭", "potassium_ingot", Colors.POTASSIUM);
    public static final ItemMapping<IngotItem> TITANIUM_INGOT = ingotItem("Titanium Ingot", "钛锭", "titanium_ingot", Colors.TITANIUM);
    public static final ItemMapping<IngotItem> SODIUM_INGOT = ingotItem("Sodium Ingot", "钠锭", "sodium_ingot", Colors.SODIUM);
    public static final ItemMapping<DustItem> SODIUM_NITRATE = dustItem("Sodium Nitrate", "硝酸钠", "sodium_nitrate", Colors.SODIUM_NITRATE);
    public static final ItemMapping<DustItem> SODIUM_NITRITE = dustItem("Sodium Nitrite", "亚硝酸钠", "sodium_nitrite", Colors.SODIUM_NITRITE);
    public static final ItemMapping<DustItem> SODIUM_OXIDE = dustItem("Sodium Oxide", "氧化钠", "sodium_oxide", Colors.SODIUM_OXIDE);
    public static final ItemMapping<DustItem> SODIUM_PEROXIDE = dustItem("Sodium Peroxide", "过氧化钠", "sodium_peroxide", Colors.SODIUM_PEROXIDE);
    public static final ItemMapping<DustItem> SODIUM_HYDROXIDE = dustItem("Sodium Hydroxide", "氢氧化钠", "sodium_hydroxide", Colors.SODIUM);
    public static final ItemMapping<DustItem> HYDROCHLORIDE = dustItem("Hydrochloride", "盐酸盐", "hydrochloride", Colors.HYDROCHLORIDE);
    public static final ItemMapping<DustItem> HYPOCHLORITE = dustItem("Hypochlorite", "次氯酸盐", "hypochlorite", Colors.HYPOCHLORITE);
    public static final ItemMapping<Item> INDUCTION_COIL = defaultMaterialItem("Induction Coil", "磁感应线圈", "induction_coil");
    public static final ItemMapping<Item> CHORUS_BUTTER = defaultMaterialItem("Chorus Butter", "紫颂脂", "chorus_butter");
    public static final ItemMapping<Item> CHORUS_INGOT = defaultMaterialItem("Chorus Ingot", "紫颂锭", "chorus_ingot");
    public static final ItemMapping<Item> ROCKET_CONTROL_CIRCUIT = defaultMaterialItem("Rocket Control Circuit", "火箭控制电路", "rocket_control_circuit");
    public static final ItemMapping<Item> AEROSPACE_COMPOSITE_FABRIC = defaultMaterialItem("Aerospace Composite Fabric", "航天复合面料", "aerospace_composite_fabric");
    public static final ItemMapping<Item> KEVLAR = defaultMaterialItem("Kevlar", "Kevlar", "kevlar");
    public static final ItemMapping<Item> KAPTON = defaultMaterialItem("Kapton", "Kapton", "kapton");
    public static final ItemMapping<Item> ELASTIC_FABRIC = defaultMaterialItem("Elastic Fabric", "弹性织物", "elastic_fabric");
    public static final ItemMapping<DustItem> P_NITROANILINE = dustItem("p-Nitroaniline", "4-硝基苯胺", "p_nitroaniline", 0xFFFFCB6B);
    public static final ItemMapping<DustItem> TEREPHTHALIC_ACID = dustItem("Terephthalic Acid", "对苯二甲酸", "terephthalic_acid", 0xFFE1E4E8);
    public static final ItemMapping<DustItem> P_PHENYLENEDIAMINE = dustItem("p-Phenylenediamine", "对苯二胺", "p_phenylenediamine", 0xFFBABABA);
    public static final ItemMapping<DustItem> PHTHALIC_ANHYDRIDE = dustItem("Phthalic Anhydride", "苯二酐", "phthalic_anhydride", 0xFFE5E7EB);
    public static final ItemMapping<Item> UNIVERSAL_PRESS = defaultMaterialItem("Universal Press", "通用压印模板", "universal_press");
    public static final ItemMapping<BasicSpongeCellItem> SPONGE_ITEM_STORAGE_CELL_256K = item("256k Sponge Item Storage Cell", "256k-海绵物品存储元件", "sponge_item_storage_cell_256k", () -> new BasicSpongeCellItem(new Item.Properties().stacksTo(1).tab(SFCreativeModTabs.TOOL.get()), 1.5, 256, 512, AEKeyType.items()));
    public static final ItemMapping<Item> SPONGE_ITEM_CELL_HOUSING = defaultMaterialItem("Sponge Item Cell Housing", "海绵物品元件外壳", "sponge_item_cell_housing");
    public static final ItemMapping<Item> CRAFT_CORE = defaultMaterialItem("Craft Core", "合成核心", "craft_core");
    public static final ItemMapping<Item> DESH_COIL = defaultMaterialItem("Desh Coil", "戴斯线圈", "desh_coil");
    public static final ItemMapping<Item> UPGRADE_BLANK = defaultMaterialItem("Blank Upgrade", "空白升级", "upgrade_blank");
    public static final ItemMapping<WrappedChemicalStackItem> WRAPPED_CHEMICAL_STACK_ITEM = item("Chemical", "化学品", "wrapped_chemical_stack_item", () -> new WrappedChemicalStackItem(new Item.Properties()));
    public static final ItemMapping<Item> MANA_FIELD_INGOT = defaultMaterialItem("Mana Field Ingot","魔力场锭","mana_field_ingot");

    public static final ItemMapping<AugmentItem> CREATIVE_MACHINE_SPEED_AUGMENT_TEST = item("Creative Machine Speed Augment Test", "创造通量链接放大器测试物品", "creative_machine_speed_augment_test",
            () -> new AugmentItem(new Item.Properties().rarity(Rarity.EPIC).tab(SFCreativeModTabs.MATERIAL.get()),
                    AugmentDataHelper.builder().type(TAG_AUGMENT_TYPE_MACHINE)
                            .mod(TAG_AUGMENT_MACHINE_SPEED, 5F)
                            .mod(TAG_AUGMENT_MACHINE_ENERGY, 0F)
                            .mod(TAG_AUGMENT_BASE_MOD, 20F)
                            .mod(TAG_AUGMENT_FEATURE_CYCLE_PROCESS, 1F)
                            .mod(TAG_AUGMENT_MACHINE_CATALYST, 0F)
                            .build()));
    public static final ItemMapping<FluidBucketItem> TEST_BUCKET_A = item("Test Water Bucket A", "测试水桶A", "test_bucket_a", () -> new FluidBucketItem(() -> Fluids.WATER, false));
    public static final ItemMapping<FluidBucketItem> TEST_BUCKET_B = item("Test Water Bucket B", "测试水桶B", "test_bucket_b", () -> new FluidBucketItem(() -> Fluids.WATER, true));

    private static ItemMapping<DustItem> dustItem(String englishName, String chineseName, String id, int color) {
        RegistryObject<DustItem> registeredItem = REGISTER.register(id, () -> new DustItem(new Item.Properties().tab(SFCreativeModTabs.MATERIAL.get()), color));
        ItemMapping<DustItem> dustItemMapping = new ItemMapping<>(englishName, chineseName, id, registeredItem);
        DUST_ITEM.add(dustItemMapping);
        return dustItemMapping;
    }

    private static ItemMapping<IngotItem> ingotItem(String englishName, String chineseName, String id, int color) {
        RegistryObject<IngotItem> registeredItem = REGISTER.register(id, () -> new IngotItem(new Item.Properties().tab(SFCreativeModTabs.MATERIAL.get()), color));
        ItemMapping<IngotItem> dustItemMapping = new ItemMapping<>(englishName, chineseName, id, registeredItem);
        INGOT_ITEM.add(dustItemMapping);
        return dustItemMapping;
    }

    private static ItemMapping<Item> defaultMaterialItem(String englishName, String chineseName, String id) {
        return item(englishName, chineseName, id, () -> new Item(new Item.Properties().tab(SFCreativeModTabs.MATERIAL.get())));
    }

    public static <T extends Item> @NotNull ItemMapping<T> item(String englishName, String chineseName, String id, Supplier<T> item) {
        return item(englishName, chineseName, id, item, false);
    }

    static <T extends Item> @NotNull ItemMapping<T> item(String englishName, String chineseName, String id, Supplier<T> item, boolean isBlockItem) {
        RegistryObject<T> registeredItem = REGISTER.register(id, item);

        var itemDef = new ItemMapping<>(englishName, chineseName, id, registeredItem, isBlockItem);
        ITEMS.add(itemDef);
        return itemDef;
    }

    private static @Nullable Object registerMetalSet(String prefix, CreativeModeTab group, Rarity rarity) {
        // Hacky but whatever.
        REGISTER.register(prefix + "_dust", () -> new ItemCoFH(new Item.Properties().tab(group).rarity(rarity)));
        REGISTER.register(prefix + "_gear", () -> new ItemCoFH(new Item.Properties().tab(group).rarity(rarity)));
        REGISTER.register(prefix + "_plate", () -> new CountedItem(new Item.Properties().tab(group).rarity(rarity)));
        REGISTER.register(prefix + "_coin", () -> new CoinItem(new Item.Properties().tab(group).rarity(rarity)));
        return null;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}