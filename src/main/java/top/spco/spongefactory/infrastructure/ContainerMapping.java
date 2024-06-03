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
package top.spco.spongefactory.infrastructure;

import mekanism.common.registration.impl.ContainerTypeRegistryObject;
import net.minecraft.world.inventory.AbstractContainerMenu;
import top.spco.spongefactory.SpongeFactory;

public class ContainerMapping<T extends AbstractContainerMenu> extends Translatable {
    private final ContainerTypeRegistryObject<T> container;

    public ContainerMapping(String englishName, String chineseName, String id, ContainerTypeRegistryObject<T> container) {
        super(englishName, chineseName, "container." + SpongeFactory.MOD_ID + "." + id);
        this.container = container;
    }

    public ContainerTypeRegistryObject<T> getContainer() {
        return container;
    }
}