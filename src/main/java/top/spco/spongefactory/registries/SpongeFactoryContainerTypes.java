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

import mekanism.common.inventory.container.tile.MekanismTileContainer;
import mekanism.common.registration.impl.ContainerTypeDeferredRegister;
import mekanism.common.registration.impl.ContainerTypeRegistryObject;
import mekanism.common.tile.base.TileEntityMekanism;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.block.TileEntityMassEnergyConverter;
import top.spco.spongefactory.infrastructure.BlockMapping;
import top.spco.spongefactory.infrastructure.ContainerMapping;

import java.util.HashSet;

public class SpongeFactoryContainerTypes {
    public static final ContainerTypeDeferredRegister REGISTER = new ContainerTypeDeferredRegister(SpongeFactory.MOD_ID);
    public static final HashSet<ContainerMapping<?>> CONTAINERS = new HashSet<>();

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }

    public static final ContainerMapping<MekanismTileContainer<TileEntityMassEnergyConverter>> MASS_ENERGY_CONVERTER = container(SpongeFactoryBlocks.MASS_ENERGY_CONVERTER, TileEntityMassEnergyConverter.class);

    private static <T extends AbstractContainerMenu, B extends TileEntityMekanism> ContainerMapping<MekanismTileContainer<B>> container(BlockMapping<? extends Block> block, Class<B> clazz) {
        ContainerTypeRegistryObject<MekanismTileContainer<B>> registeredContainer = REGISTER.register(block.toMekRegistryObject(), clazz);

        var containerMapping = new ContainerMapping<>(block.getEnglishName(), block.getChineseName(), block.getId(), registeredContainer);
        CONTAINERS.add(containerMapping);
        return containerMapping;
    }
}