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
package top.spco.spongefactory.infrastructure.data.loot.cofh;

import cofh.lib.data.ItemModelProviderCoFH;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.registries.SFItems;

import java.util.function.Supplier;

public class SFCoFHItemModelProvider extends ItemModelProviderCoFH {
    public SFCoFHItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SpongeFactory.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        alloySet(SFItems.REGISTER, "source_steel");
    }

    protected void alloySet(DeferredRegister<Item> reg, String prefix) {
        generated(getSup(reg, prefix + "_ingot"));
        generated(getSup(reg, prefix + "_dust"));
        generated(getSup(reg, prefix + "_gear"));
        plate(getSup(reg, prefix + "_plate"));
        coin(getSup(reg, prefix + "_coin"));
    }

    protected void plate(Supplier<? extends ItemLike> item) {
        for (int i = 0; i < 4; i++) {
            getBuilder(name(item) + "_" + i).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/" + name(item) + "_" + i));
        }
        getBuilder(name(item)).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/" + name(item) + "_0"))
                .override().predicate(new ResourceLocation("count"), 0F).model(new ModelFile.UncheckedModelFile(modLoc("item/" + name(item) + "_0"))).end()
                .override().predicate(new ResourceLocation("count"), 0.25F).model(new ModelFile.UncheckedModelFile(modLoc("item/" + name(item) + "_1"))).end()
                .override().predicate(new ResourceLocation("count"), 0.5F).model(new ModelFile.UncheckedModelFile(modLoc("item/" + name(item) + "_2"))).end()
                .override().predicate(new ResourceLocation("count"), 1F).model(new ModelFile.UncheckedModelFile(modLoc("item/" + name(item) + "_3"))).end();
    }

    protected void coin(Supplier<? extends ItemLike> item) {
        for (int i = 0; i < 5; i++) {
            getBuilder(name(item) + "_" + i).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/" + name(item) + "_" + i));
        }
        getBuilder(name(item)).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/" + name(item) + "_0"))
                .override().predicate(new ResourceLocation("count"), 0F).model(new ModelFile.UncheckedModelFile(modLoc("item/" + name(item) + "_0"))).end()
                .override().predicate(new ResourceLocation("count"), 0.031255F).model(new ModelFile.UncheckedModelFile(modLoc("item/" + name(item) + "_1"))).end()
                .override().predicate(new ResourceLocation("count"), 0.25F).model(new ModelFile.UncheckedModelFile(modLoc("item/" + name(item) + "_2"))).end()
                .override().predicate(new ResourceLocation("count"), 0.5F).model(new ModelFile.UncheckedModelFile(modLoc("item/" + name(item) + "_3"))).end()
                .override().predicate(new ResourceLocation("count"), 1F).model(new ModelFile.UncheckedModelFile(modLoc("item/" + name(item) + "_4"))).end();
    }


    private static <T> RegistryObject<T> getSup(DeferredRegister<T> register, String resourceLoc) {
        for (RegistryObject<T> registryObject : register.getEntries()) {
            if (registryObject.getId().getPath().equals(resourceLoc)) {
                return registryObject;
            }
        }
        return null;
    }
}