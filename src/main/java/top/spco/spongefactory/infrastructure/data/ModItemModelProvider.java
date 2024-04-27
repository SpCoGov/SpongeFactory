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
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.ItemMapping;
import top.spco.spongefactory.item.ModItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate item models
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SpongeFactory.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        List<ItemMapping<?>> handheldItems = new ArrayList<>();
        handheldItems.add(ModItems.STONE_HAMMER);
        for (var item : ModItems.ITEMS) {
            if (handheldItems.contains(item)) {
                handheldItem(item);
            } else {
                generatedItem(item);
            }
        }
    }

    private ItemModelBuilder generatedItem(ItemMapping<?> item) {
        return withExistingParent(item.getId(), new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SpongeFactory.MOD_ID, "item/" + item.getId()));
    }

    private ItemModelBuilder handheldItem(ItemMapping<?> item) {
        return withExistingParent(item.getId(), new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SpongeFactory.MOD_ID, "item/" + item.getId()));
    }
}