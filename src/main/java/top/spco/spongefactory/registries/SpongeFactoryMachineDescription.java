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

import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.Translatable;

import java.util.HashSet;

public class SpongeFactoryMachineDescription extends Translatable  {
    public static final HashSet<SpongeFactoryMachineDescription> DESCRIPTIONS = new HashSet<>();

    public static final SpongeFactoryMachineDescription MASS_ENERGY_CONVERTER = description("A machine that completely converts the rest mass of a specific substance into energy."
            , "将特定物质的静止质量完全转化为能量的机器。", "mass_energy_converter");

    public SpongeFactoryMachineDescription(String englishName, String chineseName, String id) {
        super(englishName, chineseName, "description." + SpongeFactory.MOD_ID + "." + id);
    }

    private static SpongeFactoryMachineDescription description(String englishName, String chineseName, String id) {
        SpongeFactoryMachineDescription description = new SpongeFactoryMachineDescription(englishName, chineseName, id);
        DESCRIPTIONS.add(description);
        return description;
    }
}