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
package top.spco.spongefactory.client.jei.category;

import cofh.thermal.lib.compat.jei.Drawables;
import cofh.thermal.lib.compat.jei.ThermalRecipeCategory;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.client.gui.MachineMagnetizerScreen;
import top.spco.spongefactory.recipe.MagnetizerRecipe;
import top.spco.spongefactory.registries.SFBlocks;

import java.util.List;

import static cofh.lib.util.helpers.StringHelper.getTextComponent;
import static cofh.thermal.core.compat.jei.TCoreJeiPlugin.defaultOutputTooltip;

public class MagnetizerRecipeCategory extends ThermalRecipeCategory<MagnetizerRecipe> {
    public MagnetizerRecipeCategory(IGuiHelper guiHelper, ItemStack icon, RecipeType<MagnetizerRecipe> type) {
        super(guiHelper, icon, type);

        background = guiHelper.drawableBuilder(MachineMagnetizerScreen.TEXTURE, 26, 11, 124, 62)
                .addPadding(0, 0, 16, 24)
                .build();
        name = getTextComponent(SFBlocks.MAGNETIZER.getTranslationKey());

        progressBackground = Drawables.getDrawables(guiHelper).getProgress(Drawables.PROGRESS_ARROW);
        speedBackground = Drawables.getDrawables(guiHelper).getScale(Drawables.SCALE_FLUX);

        progress = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getProgressFill(Drawables.PROGRESS_ARROW), 200, IDrawableAnimated.StartDirection.LEFT, false);
        speed = guiHelper.createAnimatedDrawable(Drawables.getDrawables(guiHelper).getScaleFill(Drawables.SCALE_FLUX), 400, IDrawableAnimated.StartDirection.TOP, true);
    }

    @Override
    public @NotNull RecipeType<MagnetizerRecipe> getRecipeType() {
        return type;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, MagnetizerRecipe recipe, @NotNull IFocusGroup iFocusGroup) {
        List<Ingredient> inputs = recipe.getInputItems();
        List<ItemStack> outputs = recipe.getOutputItems();

        builder.addSlot(RecipeIngredientRole.INPUT, 52, 15)
                .addIngredients(inputs.get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 115, 24)
                .addItemStack(outputs.get(0))
                .addTooltipCallback(defaultOutputTooltip(recipe.getOutputItemChances().get(0)));
    }

    @Override
    public void draw(@NotNull MagnetizerRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull PoseStack matrixStack, double mouseX, double mouseY) {
        super.draw(recipe, recipeSlotsView, matrixStack, mouseX, mouseY);

        progressBackground.draw(matrixStack, 78, 24);
        speedBackground.draw(matrixStack, 52, 34);

        progress.draw(matrixStack, 78, 24);
        speed.draw(matrixStack, 52, 34);
    }
}