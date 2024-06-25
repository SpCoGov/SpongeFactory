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

import mekanism.api.chemical.gas.Gas;
import mekanism.common.registration.impl.GasDeferredRegister;
import mekanism.common.registration.impl.GasRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import top.spco.spongefactory.Colors;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.GasMapping;

import java.util.LinkedHashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class SFGases {
    public static final Set<GasMapping> GASES = new LinkedHashSet<>();
    public static final GasDeferredRegister REGISTER = new GasDeferredRegister(SpongeFactory.MOD_ID);

    public static final GasMapping CARBON_MONOXIDE = gas("Carbon Monoxide", "一氧化碳", "carbon_monoxide", Colors.CARBON_MONOXIDE);
    public static final GasMapping CARBON_DIOXIDE = gas("Carbon Dioxide", "二氧化碳", "carbon_dioxide", Colors.CARBON_DIOXIDE);
    public static final GasMapping ALUMINUM = gas("Aluminum", "铝", "aluminum", Colors.ALUMINUM);
    public static final GasMapping MATTER = gas("Matter", "物质", "matter", Colors.MATTER);
    public static final GasMapping NICKEL = gas("Nickel", "镍", "nickel", Colors.NICKEL);
    public static final GasMapping NICKEL_TETRACARBONYL = gas("Nickel Tetracarbonyl", "四羰基镍", "nickel_tetracarbonyl", Colors.NICKEL_TETRACARBONYL);
    public static final GasMapping NICKEL_OXIDE = gas("Nickel Oxide", "氧化镍", "nickel_oxide", Colors.NICKEL_OXIDE);
    public static final GasMapping OSMIUM = gas("Osmium", "锇", "osmium", Colors.OSMIUM);
    public static final GasMapping OSMIUM_TETROXIDE = gas("Osmium Tetroxide", "四氧化锇", "osmium_tetroxide", Colors.OSMIUM_TETROXIDE);
    public static final GasMapping AMMONIA = gas("Ammonia", "氨气", "ammonia", Colors.AMMONIA);
    public static final GasMapping AMMONIA_WATER = gas("Ammonia Water", "氨水", "ammonia_water", Colors.AMMONIA_WATER);
    public static final GasMapping URANIUM = gas("Uranium", "铀", "uranium", Colors.URANIUM);
    public static final GasMapping URANIUM_DIOXIDE = gas("Uranium Dioxide", "二氧化铀", "uranium_dioxide", Colors.URANIUM_DIOXIDE);
    public static final GasMapping URANYL_SULFATE = gas("Uranyl Sulfate", "硫酸铀酰", "uranyl_sulfate", Colors.URANYL_SULFATE);
    public static final GasMapping AMMONIUM_DIURANATE = gas("Ammonium Diuranate", "重铀酸铵", "ammonium_diuranate", Colors.AMMONIUM_DIURANATE);
    public static final GasMapping URANIUM_TETRAFLUORIDE = gas("Uranium Tetrafluoride", "四氟化铀", "uranium_tetrafluoride", Colors.URANIUM_TETRAFLUORIDE);
    public static final GasMapping NITROGEN = gas("Nitrogen", "氮气", "nitrogen", Colors.NITROGEN);
    public static final GasMapping ARGON = gas("Argon", "氩气", "argon", Colors.ARGON);
    public static final GasMapping ETHER = gas("Ether", "以太", "ether", Colors.ETHER);
    // 费米子
    public static final GasMapping UP_QUARK = gas("Up Quark", "上夸克", "up_quark", Colors.UP_QUARK);
    public static final GasMapping DOWN_QUARK = gas("Down Quark", "下夸克", "down_quark", Colors.DOWN_QUARK);
    public static final GasMapping STRANGE_QUARK = gas("Strange Quark", "奇夸克", "strange_quark", Colors.STRANGE_QUARK);
    public static final GasMapping CHARM_QUARK = gas("Charm Quark", "粲夸克", "charm_quark", Colors.CHARM_QUARK);
    public static final GasMapping BOTTOM_QUARK = gas("Bottom Quark", "底夸克", "bottom_quark", Colors.BOTTOM_QUARK);
    public static final GasMapping TOP_QUARK = gas("Top Quark", "顶夸克", "top_quark", Colors.TOP_QUARK);
    public static final GasMapping ELECTRON = gas("Electron", "电子", "electron", Colors.ELECTRON);
    public static final GasMapping MUON = gas("Muon", "μ子", "muon", Colors.MUON);
    public static final GasMapping TAUON = gas("Tauon", "τ子", "tauon", Colors.TAUON);
    public static final GasMapping NEUTRINO = gas("Neutrino", "中微子", "neutrino", Colors.NEUTRINO);
    // 玻色子
    public static final GasMapping BOSON = gas("Boson", "W及Z玻色子", "boson", Colors.BOSON);
    public static final GasMapping PHOTON = gas("Photon", "光子", "photon", Colors.PHOTON);
    public static final GasMapping GLUON = gas("Gluon", "胶子", "gluon", Colors.GLUON);
    public static final GasMapping HIGGS_BOSON = gas("Higgs Boson", "希格斯玻色子", "higgs_boson", Colors.HIGGS_BOSON);
    public static final GasMapping GRAVITON = gas("Graviton", "引力子", "graviton", Colors.GRAVITON);

    private static GasMapping gas(String englishName, String chineseName, String id, int color) {
        GasRegistryObject<Gas> registeredGas = REGISTER.register(id, color);
        GasMapping gasMapping = new GasMapping(englishName, chineseName, id, registeredGas);
        GASES.add(gasMapping);
        return gasMapping;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}