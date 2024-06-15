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
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.spco.spongefactory.Colors;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.fluid.BaseFluidType;
import top.spco.spongefactory.infrastructure.FluidMapping;

import java.util.HashSet;

@SuppressWarnings("unused")
public class SFFluids {
    public static final HashSet<FluidMapping> FLUIDS = new HashSet<>();
    public static final DeferredRegister<Fluid> REGISTER = DeferredRegister.create(ForgeRegistries.FLUIDS, SpongeFactory.MOD_ID);

    public static final FluidMapping GLOOMY_EXTRACT = fluid("Gloomy Extract", "忧郁提取物", SFFluidTypes.GLOOMY_EXTRACT);
    public static final FluidMapping POTASSIUM_HYDROXIDE_SOLUTION = fluid("Potassium Hydroxide Solution", "氢氧化钾溶液", SFFluidTypes.POTASSIUM_HYDROXIDE_SOLUTION);
    public static final FluidMapping GOLD_PLATING_SOLUTION = fluid("Gold Plating Solution", "金电镀液", SFFluidTypes.GOLD_PLATING_SOLUTION);
    public static final FluidMapping AURATE_SOLUTION = fluid("Aurate Solution", "金酸盐溶液", SFFluidTypes.AURATE_SOLUTION);
    public static final FluidMapping DILUTE_SULFURIC_ACID = fluid("Dilute Sulfuric Acid", "稀硫酸", SFFluidTypes.DILUTE_SULFURIC_ACID);
    public static final FluidMapping OLEUM = fluid("Oleum", "发烟硫酸", SFFluidTypes.OLEUM);
    public static final FluidMapping SULFURIC_ACID = fluid("Concentrated sulfuric acid", "浓硫酸", SFFluidTypes.SULFURIC_ACID);
    public static final FluidMapping HYDROCHLORIC_ACID = fluid("Hydrochloric Acid", "盐酸", SFFluidTypes.HYDROCHLORIC_ACID);
    public static final FluidMapping AQUA_REGIA = fluid("Aqua Regia", "王水", SFFluidTypes.AQUA_REGIA);
    public static final FluidMapping CHLOROAURIC_ACID_SOLUTION = fluid("Chloroauric Acid Solution", "氯金酸溶液", SFFluidTypes.CHLOROAURIC_ACID_SOLUTION);
    public static final FluidMapping NITRIC_ACID = fluid("Nitric Acid", "硝酸", SFFluidTypes.NITRIC_ACID);
    public static final FluidMapping ZINC_PLATING_SOLUTION = fluidAndType("Zinc Plating Solution", "锌电镀液", "zinc_plating_solution", 0xFF99BCFF);
    public static final FluidMapping ZINC_SULFATE_SOLUTION = fluidAndType("Zinc Sulfate Solution", "硫酸锌溶液", "zinc_sulfate_solution", 0xFFA3BEAB);
    public static final FluidMapping MOLTEN_SODIUM = fluid("Molten Sodium", "熔融钠", SFFluidTypes.MOLTEN_SODIUM);
    public static final FluidMapping MOLTEN_SODIUM_CARBONATE = molten("Sodium Carbonate", "碳酸钠", Colors.SODIUM);
    public static final FluidMapping LIQUID_AIR = fluidAndType("Liquid Air", "液态空气", "liquid_air", 0xAA5DEAFF);
    public static final FluidMapping MOLTEN_POTASSIUM = molten("Potassium", "钾", Colors.POTASSIUM);
    public static final FluidMapping MOLTEN_CALCIUM = molten("Calcium", "钙", Colors.CALCIUM);
    public static final FluidMapping MOLTEN_TITANIUM = molten("Titanium", "钛", Colors.TITANIUM);
    public static final FluidMapping TITANIUM_TETRACHLORIDE = fluidAndType("Titanium Tetrachloride", "四氯化钛", "titanium_tetrachloride", 0xFFFFDDC6);
    public static final FluidMapping MOLTEN_SIGNALUM = molten("Signalum", "信素", Colors.SIGNALUM, SFFluidTypes.MOLTEN_ALLOY_STILL, SFFluidTypes.MOLTEN_ALLOY_FLOW);
    public static final FluidMapping MOLTEN_LUMIUM = molten("Lumium", "流明", Colors.LUMIUM, SFFluidTypes.MOLTEN_ALLOY_STILL, SFFluidTypes.MOLTEN_ALLOY_FLOW);
    public static final FluidMapping CHORUS_OIL = fluidAndType("Chorus Oil", "紫颂油", "chorus_oil", Colors.CHORUS, SFFluidTypes.MOLTEN_ALLOY_STILL, SFFluidTypes.MOLTEN_ALLOY_FLOW);
    public static final FluidMapping CHORUS_JUICE = fluidAndType("Chorus Juice", "紫颂汁", "chorus_juice", Colors.CHORUS);
    public static final FluidMapping P_XYLENE = fluidAndType("p-Xylene", "对二甲苯", "p_xylene", 0xFFA4BECD);
    public static final FluidMapping PHTHALOYL_CHLORIDE = fluidAndType("Phthaloyl Chloride", "苯二甲酰氯", "phthaloyl_chloride", 0xFFABBF0A);
    public static final FluidMapping MOLTEN_DESH = molten("Desh", "戴斯", Colors.DESH, SFFluidTypes.MOLTEN_ALLOY_STILL, SFFluidTypes.MOLTEN_ALLOY_FLOW);
    public static final FluidMapping MOLTEN_NETHERITE = molten("Netherite", "下界合金", Colors.NETHERITE);
    public static final FluidMapping MOLTEN_BAUXITE = molten("Bauxite", "铝土矿", Colors.BAUXITE);
    public static final FluidMapping MOLTEN_ALUMINUM = molten("Aluminum", "铝", Colors.convertToArgb(Colors.ALUMINUM));
    public static final FluidMapping MOLTEN_MATTER = molten("Matter", "物质", Colors.convertToArgb(Colors.MATTER));
    public static final FluidMapping ANCIENT_DEBRIS_SUSPENSION = fluidAndType("Ancient Debris Suspension", "远古遗骸悬浊液", "ancient_debris_suspension", Colors.NETHERITE, SFFluidTypes.MOLTEN_ALLOY_STILL, SFFluidTypes.MOLTEN_ALLOY_FLOW);
    public static final FluidMapping MOLTEN_NICKEL = molten("Nickel", "镍", Colors.convertToArgb(Colors.NICKEL));
    public static final FluidMapping MOLTEN_OSMIUM = molten("Osmium", "锇", Colors.convertToArgb(Colors.OSMIUM));
    public static final FluidMapping MOLTEN_URANIUM = molten("Uranium", "铀", Colors.convertToArgb(Colors.URANIUM));

    private static FluidMapping molten(String englishName, String chineseName, int color) {
        String id = "molten_" + englishName.toLowerCase().replaceAll(" ", "_");
        RegistryObject<FluidType> type = SFFluidTypes.REGISTER.register(id, () -> new BaseFluidType(SFFluidTypes.MOLTEN_STILL, SFFluidTypes.MOLTEN_FLOW).color(color));
        return fluid("Molten " + englishName, "熔融" + chineseName, type);
    }

    private static FluidMapping molten(String englishName, String chineseName, int color, ResourceLocation still, ResourceLocation flow) {
        String id = "molten_" + englishName.toLowerCase().replaceAll(" ", "_");
        RegistryObject<FluidType> type = SFFluidTypes.REGISTER.register(id, () -> new BaseFluidType(still, flow).color(color));
        return fluid("Molten " + englishName, "熔融" + chineseName, type);
    }

    private static FluidMapping fluid(String englishName, String chineseName, RegistryObject<FluidType> type) {
        FluidMapping fluidMapping = new FluidMapping(englishName, chineseName, type.getId().getPath(), type, REGISTER);
        FLUIDS.add(fluidMapping);

        return fluidMapping;
    }

    private static FluidMapping fluidAndType(String englishName, String chineseName, String id, int color, ResourceLocation still, ResourceLocation flow) {
        RegistryObject<FluidType> type = SFFluidTypes.REGISTER.register(id, () -> new BaseFluidType(still, flow).color(color));
        return fluid(englishName, chineseName, type);
    }

    private static FluidMapping fluidAndType(String englishName, String chineseName, String id, int color) {
        RegistryObject<FluidType> type = SFFluidTypes.REGISTER.register(id, () -> new BaseFluidType().color(color));
        return fluid(englishName, chineseName, type);
    }

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}