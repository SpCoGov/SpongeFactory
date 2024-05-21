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

import mekanism.api.Upgrade;
import mekanism.api.math.FloatingLong;
import mekanism.common.registries.MekanismSounds;
import top.spco.spongefactory.block.TileEntityMassEnergyConverter;
import top.spco.spongefactory.blocktype.SpongeFactoryMachine;

import java.util.EnumSet;

public class SpongeFactoryBlockTypes {
    public static final SpongeFactoryMachine<TileEntityMassEnergyConverter> MASS_ENERGY_CONVERTER = SpongeFactoryMachine.MachineBuilder
            .createMachine(() -> SpongeFactoryTileEntityTypes.MASS_ENERGY_CONVERTER, SpongeFactoryMachineDescription.MASS_ENERGY_CONVERTER)
            .withSound(MekanismSounds.ISOTOPIC_CENTRIFUGE)
            .withGui(SpongeFactoryContainerTypes.MASS_ENERGY_CONVERTER::getContainer)
            .withSupportedUpgrades(EnumSet.of(Upgrade.ENERGY, Upgrade.MUFFLING, Upgrade.SPEED))
            .withEnergyConfig(() -> FloatingLong.create(500), () -> FloatingLong.create(1800000))
            .withComputerSupport("massEnergyConverter")
            .build();
}