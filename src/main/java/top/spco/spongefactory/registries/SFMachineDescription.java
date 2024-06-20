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

public class SFMachineDescription extends Translatable {
    public static final HashSet<SFMachineDescription> DESCRIPTIONS = new HashSet<>();

    public static final SFMachineDescription MASS_ENERGY_CONVERTER = description("A machine that completely converts the rest mass of a specific substance into energy."
            , "将特定物质的静止质量完全转化为能量的机器。", "mass_energy_converter");
    public static final SFMachineDescription FLUIDIZED_BED_REACTOR = description("A machine in which a gas undergoes a chemical reaction in a fluidized bed of solid material."
            , "气体在由固体物料构成的沸腾床层内进行化学反应的机器。", "fluidized_bed_reactor");

    public SFMachineDescription(String englishName, String chineseName, String id) {
        super(englishName, chineseName, "description." + SpongeFactory.MOD_ID + "." + id);
    }

    private static SFMachineDescription description(String englishName, String chineseName, String id) {
        SFMachineDescription description = new SFMachineDescription(englishName, chineseName, id);
        DESCRIPTIONS.add(description);
        return description;
    }
}