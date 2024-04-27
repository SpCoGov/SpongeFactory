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
package top.spco.spongefactory.infrastructure.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.item.ModItems;

import java.util.function.Consumer;

/**
 * Generate recipes
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }


    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
/*
        ShapedRecipeBuilder.shaped(ModItems.STONE_HAMMER.getItem())
                .define('S', Items.STONE)//ItemTags.create(new ResourceLocation("quark", "stone_tool_materials")))
                .define('T', Items.STICK)
                .pattern(" ST")
                .pattern(" TS")
                .pattern("T  ")
                .save(consumer);
*/
    }
}