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

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.block.entity.MachineMagnetizerTile;

public class SFBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SpongeFactory.MOD_ID);

    public static final RegistryObject<BlockEntityType<?>> MAGNETIZER = REGISTER.register("magnetizer", () -> BlockEntityType.Builder.of(MachineMagnetizerTile::new, SFBlocks.MAGNETIZER.getRegisteredBlock().get()).build(null));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}