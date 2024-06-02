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

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.item.FluidBucketItem;
import top.spco.spongefactory.registries.SFItems;

import java.util.function.Supplier;

public class FluidMapping extends Translatable {
    private final RegistryObject<FlowingFluid> stillFluid;
    private final RegistryObject<FlowingFluid> flowingFluid;
    private final Supplier<FluidType> type;
    private final ItemMapping<? extends BucketItem> bucket;
    private final String id;

    public FluidMapping(String englishName, String chineseName, String id, Supplier<FluidType> type, DeferredRegister<Fluid> register) {
        super(englishName, chineseName, "fluid_type." + SpongeFactory.MOD_ID + "." + id);
        this.type = type;
        this.id = id;
        this.stillFluid = register.register(id, () -> new ForgeFlowingFluid.Source(fluidProperties()));
        this.flowingFluid = register.register(id + "_flowing", () -> new ForgeFlowingFluid.Flowing(fluidProperties()));
        this.bucket = SFItems.item(englishName + "Bucket", chineseName + "桶", id + "_bucket",
                () -> new FluidBucketItem(stillFluid, false));
    }

    private ForgeFlowingFluid.Properties fluidProperties() {
        return new ForgeFlowingFluid.Properties(type, stillFluid, flowingFluid).bucket(bucket.getRegisteredItem());
    }

    public Supplier<FluidType> getType() {
        return type;
    }

    public ItemMapping<? extends BucketItem> getBucket() {
        return bucket;
    }

    public RegistryObject<FlowingFluid> getStillFluid() {
        return stillFluid;
    }

    public RegistryObject<FlowingFluid> getFlowingFluid() {
        return flowingFluid;
    }

    public String getId() {
        return id;
    }
}