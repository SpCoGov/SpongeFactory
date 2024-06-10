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

import mekanism.api.chemical.infuse.InfuseType;
import mekanism.common.registration.impl.InfuseTypeDeferredRegister;
import mekanism.common.registration.impl.InfuseTypeRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.InfuseTypeMapping;

import java.util.HashSet;

@SuppressWarnings("unused")
public class SFInfuseTypes {
    public static final HashSet<InfuseTypeMapping> INFUSE_TYPES = new HashSet<>();
    public static final InfuseTypeDeferredRegister REGISTER = new InfuseTypeDeferredRegister(SpongeFactory.MOD_ID);
    public static final InfuseTypeMapping INFERIUM_ESSENCE = infuseType("Inferium Essence", "下级精华", "inferium_essence", 0xA0C400);
    public static final InfuseTypeMapping PRUDENTIUM_ESSENCE = infuseType("Prudentium Essence", "初级精华", "prudentium_essence", 0x00DC36);
    public static final InfuseTypeMapping INTERMEDIUM_ESSENCE = infuseType("Intermedium Essence", "中级精华", "intermedium_essence", 0xFF7f31);
    public static final InfuseTypeMapping SUPERIUM_ESSENCE = infuseType("Superium Essence", "高级精华", "superium_essence", 0x25A3FF);
    public static final InfuseTypeMapping SUPREMIUM_ESSENCE = infuseType("Supremium Essence", "终级精华", "supremium_essence", 0xFF1515);
    public static final InfuseTypeMapping INSANIUM_ESSENCE = infuseType("Insanium Essence", "究极精华", "insanium_essence", 0x911CD0);

    private static InfuseTypeMapping infuseType(String englishName, String chineseName, String id, int color) {
        InfuseTypeRegistryObject<InfuseType> registered = REGISTER.register(id, color);
        InfuseTypeMapping infuseTypeMapping = new InfuseTypeMapping(englishName, chineseName, id);
        INFUSE_TYPES.add(infuseTypeMapping);
        return infuseTypeMapping;
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}