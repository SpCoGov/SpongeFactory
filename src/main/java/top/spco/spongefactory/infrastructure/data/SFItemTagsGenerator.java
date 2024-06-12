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
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.ItemMapping;
import top.spco.spongefactory.registries.SFItems;

public class SFItemTagsGenerator extends ItemTagsProvider {
    public SFItemTagsGenerator(DataGenerator dataGenerator, SFBlockTagsGenerator blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, SpongeFactory.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (ItemMapping<?> item : SFItems.ITEMS) {
            if (!item.getTags().isEmpty()) {
                for (TagKey<Item> tag : item.getTags()) {
                    tag(tag).add(item.asItem());
                }
            }
        }
    }
}