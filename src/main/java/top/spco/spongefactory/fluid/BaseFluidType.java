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
package top.spco.spongefactory.fluid;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class BaseFluidType extends FluidType {
    private ResourceLocation still = new ResourceLocation("spongefactory", "block/fluids/liquid");
    private ResourceLocation flow = new ResourceLocation("spongefactory", "block/fluids/liquid_flow");
    private ResourceLocation overlay = new ResourceLocation("block/water_overlay");
    private ResourceLocation renderOverlay = new ResourceLocation("textures/misc/underwater.png");
    private int color = 0xFFFFFFFF;

    public BaseFluidType(Properties properties) {
        super(properties);
    }

    public BaseFluidType() {
        super(Properties.create().rarity(Rarity.UNCOMMON)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .temperature(297));
    }

    public BaseFluidType(ResourceLocation still, ResourceLocation flow, Properties properties) {
        super(properties);
        this.still = still;
        this.flow = flow;
    }

    public BaseFluidType(ResourceLocation still, ResourceLocation flow) {
        this(still, flow, Properties.create().rarity(Rarity.UNCOMMON)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .temperature(297));
    }

    public BaseFluidType color(int color) {
        this.color = color;
        return this;
    }

    public BaseFluidType overlay(ResourceLocation overlay) {
        this.overlay = overlay;
        return this;
    }

    public BaseFluidType renderOverlay(ResourceLocation renderOverlay) {
        this.renderOverlay = renderOverlay;
        return this;
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            @Override
            public ResourceLocation getStillTexture() {
                return still;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return flow;
            }

            @Override
            public int getTintColor() {
                return color;
            }

            @Override
            public @Nullable ResourceLocation getOverlayTexture() {
                return overlay;
            }

            @Override
            public @Nullable ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return renderOverlay;
            }
        });
    }
}