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
package top.spco.spongefactory.client.hook;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mekanism.api.chemical.Chemical;
import mekanism.client.gui.GuiUtils;
import mekanism.client.render.MekanismRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemStack;
import top.spco.spongefactory.item.WrappedChemicalStackItem;

public class ItemRendererHook {
    public static boolean itemRendererHook(ItemStack stack, int x, int y) {
        if (stack.getItem() instanceof WrappedChemicalStackItem chemicalStackItem) {
            Chemical<?> chemical = chemicalStackItem.getChemical(stack);
            if (chemical == null) {
                return false;
            }
            MekanismRenderer.color(chemical);
            GuiUtils.drawTiledSprite(new PoseStack(), x, y, 16, 16, 16,
                    MekanismRenderer.getSprite(chemical.getIcon()), 16, 16, 100, GuiUtils.TilingDirection.UP_RIGHT, false);
            MekanismRenderer.resetColor();
            RenderSystem.disableBlend();
            return true;
        }
        return false;
    }
}