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

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.spco.spongefactory.Colors;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.fluid.BaseFluidType;

public class SFFluidTypes {
    public static final DeferredRegister<FluidType> REGISTER = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, SpongeFactory.MOD_ID);

    public static final ResourceLocation MOLTEN_STILL = new ResourceLocation(SpongeFactory.MOD_ID, "block/fluids/molten_still");
    public static final ResourceLocation MOLTEN_FLOW = new ResourceLocation(SpongeFactory.MOD_ID, "block/fluids/molten_flow");

    public static final RegistryObject<FluidType> GLOOMY_EXTRACT = REGISTER.register("gloomy_extract", () -> new BaseFluidType(
            new ResourceLocation("spongefactory:block/fluids/gloomy_extract_still"),
            new ResourceLocation("spongefactory:block/fluids/gloomy_extract_flow")));

    public static final RegistryObject<FluidType> POTASSIUM_HYDROXIDE_SOLUTION = REGISTER.register("potassium_hydroxide_solution", () -> new BaseFluidType().color(Colors.POTASSIUM));
    public static final RegistryObject<FluidType> GOLD_PLATING_SOLUTION = REGISTER.register("gold_plating_solution", () -> new BaseFluidType().color(0xFFBBB345));
    public static final RegistryObject<FluidType> AURATE_SOLUTION = REGISTER.register("aurate_solution", () -> new BaseFluidType().color(0xFFCB8C2F));
    public static final RegistryObject<FluidType> DILUTE_SULFURIC_ACID = REGISTER.register("dilute_sulfuric_acid", () -> new BaseFluidType().color(0xFFA6A32C));
    public static final RegistryObject<FluidType> OLEUM = REGISTER.register("oleum", () -> new BaseFluidType().color(0xFF514F00));
    public static final RegistryObject<FluidType> SULFURIC_ACID = REGISTER.register("sulfuric_acid", () -> new BaseFluidType().color(0xFF6C6B2A));
    public static final RegistryObject<FluidType> HYDROCHLORIC_ACID = REGISTER.register("hydrochloric_acid", () -> new BaseFluidType().color(0xFF618581));
    public static final RegistryObject<FluidType> AQUA_REGIA = REGISTER.register("aqua_regia", () -> new BaseFluidType().color(0xFFC07602));
    public static final RegistryObject<FluidType> CHLOROAURIC_ACID_SOLUTION = REGISTER.register("chloroauric_acid_solution", () -> new BaseFluidType().color(0xFFFCBD16));
    public static final RegistryObject<FluidType> NITRIC_ACID = REGISTER.register("nitric_acid", () -> new BaseFluidType().color(0xFFB58603));
    public static final RegistryObject<FluidType> MOLTEN_SODIUM = REGISTER.register("molten_sodium", () -> new BaseFluidType(MOLTEN_STILL, MOLTEN_FLOW).color(Colors.SODIUM));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}