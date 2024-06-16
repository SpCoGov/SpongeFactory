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
package top.spco.spongefactory.recipe;

import cofh.thermal.lib.util.recipes.IMachineInventory;
import cofh.thermal.lib.util.recipes.internal.BaseMachineRecipe;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public class MagnetizerRecipeNBT extends BaseMachineRecipe {
    public MagnetizerRecipeNBT(int energy, float experience, @Nonnull ItemStack inputItem, @Nonnull ItemStack outputItem) {
        super(energy, experience);
        this.inputItems.add(inputItem);
        this.outputItems.add(outputItem);
        this.outputItemChances.add(-1.0F);
    }

    public List<ItemStack> getOutputItems(IMachineInventory inventory) {
        ItemStack item = this.outputItems.get(0).copy();

        return Collections.singletonList(item);
    }
}