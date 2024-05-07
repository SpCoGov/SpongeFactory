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
package top.spco.spongefactory.gas;

import mekanism.api.chemical.gas.Gas;
import mekanism.common.registration.impl.GasDeferredRegister;
import mekanism.common.registration.impl.GasRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.GasMapping;

import java.util.HashSet;

public class ModGases {
    public static final HashSet<GasMapping<?>> GASES = new HashSet<>();
    private static final GasDeferredRegister REGISTER = new GasDeferredRegister(SpongeFactory.MOD_ID);

    public static final GasMapping<Gas> UP_QUARK = gas("Up Quark", "上夸克", "up_quark", 0x6969e0);
    public static final GasMapping<Gas> DOWN_QUARK = gas("Down Quark", "下夸克", "down_quark", 0x2cde2c);
    public static final GasMapping<Gas> STRANGE_QUARK = gas(  "Strange Quark", "奇夸克", "strange_quark", 0xdeb0ed);
    public static final GasMapping<Gas> CHARM_QUARK = gas("Charm Quark", "粲夸克", "charm_quark", 0xfb7299);
    public static final GasMapping<Gas> BOTTOM_QUARK = gas("Bottom Quark", "底夸克", "bottom_quark", 0x4fc3f7);
    public static final GasMapping<Gas> TOP_QUARK = gas("Top Quark", "顶夸克", "top_quark", 0xfbe000);

    private static GasMapping<Gas> gas(String englishName, String chineseName, String id, int color) {
        GasRegistryObject<Gas> registeredGas = REGISTER.register(id, color);
        GasMapping<Gas> gasMapping = new GasMapping<>(englishName, chineseName, id, registeredGas);
        GASES.add(gasMapping);
        return gasMapping;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.createAndRegister(eventBus);
    }
}