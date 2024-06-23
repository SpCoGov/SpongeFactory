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
package top.spco.spongefactory.item;

import mekanism.api.MekanismAPI;
import mekanism.api.chemical.Chemical;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.pigment.Pigment;
import mekanism.api.chemical.slurry.Slurry;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class WrappedChemicalStackItem extends Item {
    public static final String TAG_CHEMICAL = "Chemical";

    public WrappedChemicalStackItem(Properties item) {
        super(item.stacksTo(1));
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {
        Chemical<?> chemical = getChemical(stack);
        if (chemical != null) {
            return chemical.getTextComponent();
        }
        return super.getName(stack);
    }

    public Chemical<?> getChemical(ItemStack stack) {
        if (stack.getTag() == null) {
            return null;
        }
        if (stack.getTag().contains(TAG_CHEMICAL)) {
            Tag chemicalIdTag = stack.getTag().get(TAG_CHEMICAL);
            try {
                assert chemicalIdTag != null;
                ResourceLocation chemicalId = new ResourceLocation(chemicalIdTag.getAsString());
                Chemical<?> chemical;
                if ((chemical = Gas.getFromRegistry(chemicalId)) != MekanismAPI.EMPTY_GAS) {
                    return chemical;
                }
                if ((chemical = InfuseType.getFromRegistry(chemicalId)) != MekanismAPI.EMPTY_INFUSE_TYPE) {
                    return chemical;
                }
                if ((chemical = Pigment.getFromRegistry(chemicalId)) != MekanismAPI.EMPTY_PIGMENT) {
                    return chemical;
                }
                if ((chemical = Slurry.getFromRegistry(chemicalId)) != MekanismAPI.EMPTY_SLURRY) {
                    return chemical;
                }
                return null;
            } catch (Exception ignored) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public void fillItemCategory(@NotNull CreativeModeTab tab, @NotNull NonNullList<ItemStack> nonNullList) {

    }
}