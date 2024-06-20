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
import net.minecraft.core.particles.ParticleTypes;
import top.spco.spongefactory.block.entity.TileEntityFluidizedBedReactor;
import top.spco.spongefactory.block.entity.TileEntityMassEnergyConverter;
import top.spco.spongefactory.blocktype.SFMachine;

import java.util.EnumSet;

public class SFBlockTypes {
    public static final SFMachine<TileEntityMassEnergyConverter> MASS_ENERGY_CONVERTER = SFMachine.MachineBuilder
            .createMachine(() -> SFMekTileEntityTypes.MASS_ENERGY_CONVERTER, SFMachineDescription.MASS_ENERGY_CONVERTER,
                    ParticleTypes.ELECTRIC_SPARK, ParticleTypes.SMOKE)
            .withSound(MekanismSounds.ISOTOPIC_CENTRIFUGE)
            .withGui(SFMekContainerTypes.MASS_ENERGY_CONVERTER::getContainer)
            .withSupportedUpgrades(EnumSet.of(Upgrade.ENERGY, Upgrade.MUFFLING, Upgrade.SPEED))
            .withEnergyConfig(() -> FloatingLong.create(5000), () -> FloatingLong.create(1800000))
            .withComputerSupport("massEnergyConverter")
            .build();
    public static final SFMachine<TileEntityFluidizedBedReactor> FLUIDIZED_BED_REACTOR = SFMachine.MachineBuilder
            .createMachine(() -> SFMekTileEntityTypes.FLUIDIZED_BED_REACTOR, SFMachineDescription.FLUIDIZED_BED_REACTOR)
            .withSound(MekanismSounds.CHEMICAL_INFUSER)
            .withGui(SFMekContainerTypes.FLUIDIZED_BED_REACTOR::getContainer)
            .withSupportedUpgrades(EnumSet.of(Upgrade.ENERGY, Upgrade.MUFFLING, Upgrade.SPEED))
            .withEnergyConfig(() -> FloatingLong.create(50), () -> FloatingLong.create(20000))
            .withComputerSupport("fluidizedBedReactor")
            .build();
}