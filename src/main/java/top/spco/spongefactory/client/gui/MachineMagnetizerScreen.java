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
package top.spco.spongefactory.client.gui;

import cofh.thermal.core.client.gui.ThermalGuiHelper;
import cofh.thermal.lib.client.gui.MachineScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import top.spco.spongefactory.SpongeFactory;

import static cofh.core.util.helpers.GuiHelper.*;

public class MachineMagnetizerScreen extends MachineScreen<MachineMagnetizerContainer> {
    public static final String TEX_PATH = SpongeFactory.MOD_ID + ":textures/gui/container/magnetizer.png";
    public static final ResourceLocation TEXTURE = new ResourceLocation(TEX_PATH);

    public MachineMagnetizerScreen(MachineMagnetizerContainer container, Inventory inv, Component titleIn) {
        super(container, inv, container.tile, titleIn);
        texture = TEXTURE;
        info = generatePanelInfo("info.spongefactory.machine_magnetizer");
        name = "magnetizer";
    }

    @Override
    public void init() {
        super.init();

        addElement(createInputSlot(this, 62, 26, tile));

        addElement(createLargeOutputSlot(this, 125, 35, tile));

        addElement(ThermalGuiHelper.createDefaultProgress(this, 88, 35, PROG_ARROW_RIGHT, tile));
        addElement(ThermalGuiHelper.createDefaultSpeed(this, 62, 44, SCALE_FLUX, tile));
    }
}