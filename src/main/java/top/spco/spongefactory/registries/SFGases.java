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
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.GasMapping;

import java.util.HashSet;

@SuppressWarnings("unused")
public class SFGases {
    public static final HashSet<GasMapping> GASES = new HashSet<>();
    public static final GasDeferredRegister REGISTER = new GasDeferredRegister(SpongeFactory.MOD_ID);
    // 费米子
    public static final GasRegistryObject<Gas> UP_QUARK = gas("Up Quark", "上夸克", "up_quark", 0x6969E0);
    public static final GasRegistryObject<Gas> DOWN_QUARK = gas("Down Quark", "下夸克", "down_quark", 0x2CDE2C);
    public static final GasRegistryObject<Gas> STRANGE_QUARK = gas("Strange Quark", "奇夸克", "strange_quark", 0xDEB0ED);
    public static final GasRegistryObject<Gas> CHARM_QUARK = gas("Charm Quark", "粲夸克", "charm_quark", 0xFB7299);
    public static final GasRegistryObject<Gas> BOTTOM_QUARK = gas("Bottom Quark", "底夸克", "bottom_quark", 0x4FC3F7);
    public static final GasRegistryObject<Gas> TOP_QUARK = gas("Top Quark", "顶夸克", "top_quark", 0xFBE000);
    public static final GasRegistryObject<Gas> ELECTRON = gas("Electron", "电子", "electron", 0x044289);
    public static final GasRegistryObject<Gas> MUON = gas("Muon", "μ子", "muon", 0x24292E);
    public static final GasRegistryObject<Gas> TAUON = gas("Tauon", "τ子", "tauon", 0xF97570);
    public static final GasRegistryObject<Gas> NEUTRINO = gas("Neutrino", "中微子", "neutrino", 0xADD8E6);
    // 玻色子
    public static final GasRegistryObject<Gas> BOSON = gas("Boson","W及Z玻色子","boson", 0x6495ED);
    public static final GasRegistryObject<Gas> PHOTON = gas("Photon" ,"光子","photon", 0xFFFF00);
    public static final GasRegistryObject<Gas> GLUON = gas("Gluon" ,"胶子","gluon", 0xFFD700);
    public static final GasRegistryObject<Gas> HIGGS_BOSON = gas("Higgs Boson" ,"希格斯玻色子","higgs_boson", 0x800080);
    public static final GasRegistryObject<Gas> GRAVITON = gas("Graviton" ,"引力子","graviton", 0x333333);

    private static GasRegistryObject<Gas> gas(String englishName, String chineseName, String id, int color) {
        GasRegistryObject<Gas> registeredGas = REGISTER.register(id, color);
        GasMapping gasMapping = new GasMapping(englishName, chineseName, id);
        GASES.add(gasMapping);
        return registeredGas;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}