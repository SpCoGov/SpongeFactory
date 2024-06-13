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

import mekanism.common.block.attribute.Attribute;
import mekanism.common.config.MekanismConfig;
import mekanism.common.registries.MekanismBlocks;
import mekanism.common.tier.ChemicalTankTier;
import mekanism.common.util.ChemicalUtil;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.registries.SFCreativeModTabs;
import top.spco.spongefactory.registries.SFGases;
import top.spco.spongefactory.registries.SFInfuseTypes;

import java.util.function.Supplier;

/**
 * A class representing the mapping of an {@link CreativeModeTab}.
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class CreativeModeTabMapping extends Translatable {
    private final CreativeModeTab tab;

    public CreativeModeTabMapping(String englishName, String chineseName, String id, @NotNull Supplier<ItemStack> icon) {
        super(englishName, chineseName, "itemGroup." + id);
        this.tab = new CreativeModeTab(id) {
            @Override
            public @NotNull ItemStack makeIcon() {
                return icon.get();
            }

            @Override
            public void fillItemList(@NotNull NonNullList<ItemStack> list) {
                super.fillItemList(list);
                if (this == SFCreativeModTabs.MATERIAL.tab) {
                    ChemicalTankTier tier = Attribute.getTier(MekanismBlocks.CREATIVE_CHEMICAL_TANK.getBlock(), ChemicalTankTier.class);
                    if (tier == null) {
                        return;
                    }
                    long capacity = tier.getStorage();
                    if (tier == ChemicalTankTier.CREATIVE && MekanismConfig.general.isLoaded()) {
                        for (GasMapping gas : SFGases.GASES) {
                            list.add(ChemicalUtil.getFilledVariant(new ItemStack(MekanismBlocks.CREATIVE_CHEMICAL_TANK), capacity, gas.getGas().getChemical()));
                        }
                        for (InfuseTypeMapping infuseType : SFInfuseTypes.INFUSE_TYPES) {
                            list.add(ChemicalUtil.getFilledVariant(new ItemStack(MekanismBlocks.CREATIVE_CHEMICAL_TANK), capacity, infuseType.getInfuseType().getChemical()));
                        }
                    }
                }
            }
        };
    }

    public CreativeModeTab get() {
        return tab;
    }
}