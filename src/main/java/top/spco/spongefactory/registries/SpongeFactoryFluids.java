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

import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.FluidMapping;

import java.util.HashSet;

public class SpongeFactoryFluids {
    public static final HashSet<FluidMapping> FLUIDS = new HashSet<>();
    public static final DeferredRegister<Fluid> REGISTER = DeferredRegister.create(ForgeRegistries.FLUIDS, SpongeFactory.MOD_ID);

    public static final FluidMapping GLOOMY_EXTRACT = fluid("Gloomy Extract", "忧郁提取物", SpongeFactoryFluidTypes.GLOOMY_EXTRACT);
    public static final FluidMapping POTASSIUM_HYDROXIDE_SOLUTION = fluid("Potassium Hydroxide Solution", "氢氧化钾溶液",
            SpongeFactoryFluidTypes.POTASSIUM_HYDROXIDE_SOLUTION);
    public static final FluidMapping GOLD_PLATING_SOLUTION = fluid("Gold Plating Solution", "金电镀液",
            SpongeFactoryFluidTypes.GOLD_PLATING_SOLUTION);
    public static final FluidMapping AURATE_SOLUTION = fluid("Aurate Solution", "金酸盐溶液",
            SpongeFactoryFluidTypes.AURATE_SOLUTION);
    public static final FluidMapping DILUTE_SULFURIC_ACID = fluid("Dilute Sulfuric Acid", "稀硫酸", SpongeFactoryFluidTypes.DILUTE_SULFURIC_ACID);
    public static final FluidMapping OLEUM = fluid("Oleum", "发烟硫酸", SpongeFactoryFluidTypes.OLEUM);
    public static final FluidMapping SULFURIC_ACID = fluid("Concentrated sulfuric acid", "浓硫酸", SpongeFactoryFluidTypes.SULFURIC_ACID);
    public static final FluidMapping HYDROCHLORIC_ACID = fluid("Hydrochloric Acid", "盐酸", SpongeFactoryFluidTypes.HYDROCHLORIC_ACID);
    public static final FluidMapping AQUA_REGIA = fluid("Aqua Regia", "王水", SpongeFactoryFluidTypes.AQUA_REGIA);
    public static final FluidMapping CHLOROAURIC_ACID_SOLUTION = fluid("Chloroauric Acid Solution", "氯金酸溶液", SpongeFactoryFluidTypes.CHLOROAURIC_ACID_SOLUTION);
    public static final FluidMapping NITRIC_ACID = fluid("Nitric Acid", "硝酸", SpongeFactoryFluidTypes.NITRIC_ACID);

    private static FluidMapping fluid(String englishName, String chineseName, RegistryObject<FluidType> type) {
        FluidMapping fluidMapping = new FluidMapping(englishName, chineseName, type.getId().getPath(), type, REGISTER);
        FLUIDS.add(fluidMapping);

        return fluidMapping;
    }


    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}