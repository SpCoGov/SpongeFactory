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
package top.spco.spongefactory.blocktype;

import mekanism.api.Upgrade;
import mekanism.api.text.ILangEntry;
import mekanism.common.block.attribute.AttributeParticleFX;
import mekanism.common.block.attribute.AttributeStateFacing;
import mekanism.common.block.attribute.AttributeUpgradeSupport;
import mekanism.common.block.attribute.Attributes;
import mekanism.common.content.blocktype.BlockTypeTile;
import mekanism.common.lib.math.Pos3D;
import mekanism.common.registration.impl.TileEntityTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;

import java.util.EnumSet;
import java.util.function.Supplier;

public class SFMachine<TILE extends TileEntityMekanism> extends BlockTypeTile<TILE> {
    public SFMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description, ParticleOptions... particles) {
        super(tileEntityRegistrar, description);
        AttributeParticleFX particleFX = new AttributeParticleFX();
        for (ParticleOptions options : particles) {
            particleFX.add(options, rand -> new Pos3D(rand.nextFloat() * 0.6F - 0.3F, rand.nextFloat() * 6.0F / 16.0F, 0.52));
        }
        add(particleFX);
        add(Attributes.ACTIVE_LIGHT, new AttributeStateFacing(), Attributes.INVENTORY, Attributes.SECURITY, Attributes.REDSTONE, Attributes.COMPARATOR);
        add(new AttributeUpgradeSupport(EnumSet.of(Upgrade.SPEED, Upgrade.ENERGY, Upgrade.MUFFLING)));
    }

    public SFMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description) {
        this(tileEntityRegistrar, description, ParticleTypes.SMOKE, DustParticleOptions.REDSTONE);
    }

    public static class MachineBuilder<MACHINE extends SFMachine<TILE>, TILE extends TileEntityMekanism, T extends SFMachine.MachineBuilder<MACHINE, TILE, T>> extends BlockTileBuilder<MACHINE, TILE, T> {

        protected MachineBuilder(MACHINE holder) {
            super(holder);
        }

        public static <TILE extends TileEntityMekanism> SFMachine.MachineBuilder<SFMachine<TILE>, TILE, ?> createMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description) {
            return new SFMachine.MachineBuilder<>(new SFMachine<>(tileEntityRegistrar, description));
        }

        public static <TILE extends TileEntityMekanism> SFMachine.MachineBuilder<SFMachine<TILE>, TILE, ?> createMachine(Supplier<TileEntityTypeRegistryObject<TILE>> tileEntityRegistrar, ILangEntry description, ParticleOptions... particles) {
            return new SFMachine.MachineBuilder<>(new SFMachine<>(tileEntityRegistrar, description, particles));
        }
    }
}