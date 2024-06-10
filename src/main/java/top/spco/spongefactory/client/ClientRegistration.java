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
package top.spco.spongefactory.client;

import mekanism.client.ClientRegistrationUtil;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.model.DynamicFluidContainerModel;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.cell.SpongeCellInventory;
import top.spco.spongefactory.client.gui.MassEnergyConverterGui;
import top.spco.spongefactory.infrastructure.FluidMapping;
import top.spco.spongefactory.infrastructure.ItemMapping;
import top.spco.spongefactory.item.BasicSpongeCellItem;
import top.spco.spongefactory.item.DustItem;
import top.spco.spongefactory.item.IngotItem;
import top.spco.spongefactory.registries.SFContainerTypes;
import top.spco.spongefactory.registries.SFFluids;
import top.spco.spongefactory.registries.SFItems;

@Mod.EventBusSubscriber(modid = SpongeFactory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistration {
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void registerContainers(RegisterEvent event) {
        event.register(Registry.MENU_REGISTRY, helper -> {
            ClientRegistrationUtil.registerScreen(SFContainerTypes.MASS_ENERGY_CONVERTER.getContainer(), MassEnergyConverterGui::new);
        });
    }

    private static final ItemColor BUCKET_ITEM_COLOR = new DynamicFluidContainerModel.Colors();

    @SubscribeEvent
    public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
        for (FluidMapping fluid : SFFluids.FLUIDS) {
            event.register(BUCKET_ITEM_COLOR, fluid.getBucket());
        }
        for (ItemMapping<DustItem> dustItem : SFItems.DUST_ITEM) {
            event.register((p_92672_, p_92673_) -> dustItem.getItem().getColor(p_92672_, p_92673_), dustItem);
        }
        for (ItemMapping<IngotItem> ingotItem : SFItems.INGOT_ITEM) {
            event.register((p_92672_, p_92673_) -> ingotItem.getItem().getColor(p_92672_, p_92673_), ingotItem);
        }
        event.register(BasicSpongeCellItem::getColor, SFItems.SPONGE_ITEM_STORAGE_CELL);
    }
}