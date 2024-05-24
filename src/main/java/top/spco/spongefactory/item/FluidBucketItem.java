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
package top.spco.spongefactory.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.spco.spongefactory.registries.SpongeFactoryCreativeModTabs;

import java.util.function.Supplier;

public class FluidBucketItem extends BucketItem {
    private final boolean hasFluidBlock;

    public FluidBucketItem(Supplier<? extends Fluid> supplier, boolean hasFluidBlock) {
        super(supplier, new Properties().tab(SpongeFactoryCreativeModTabs.MATERIAL.get()).craftRemainder(Items.BUCKET).stacksTo(1));
        this.hasFluidBlock = hasFluidBlock;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level p_40703_, @NotNull Player p_40704_, @NotNull InteractionHand p_40705_) {
        if (hasFluidBlock) {
            return super.use(p_40703_, p_40704_, p_40705_);
        } else {
            ItemStack itemstack = p_40704_.getItemInHand(p_40705_);
            return InteractionResultHolder.pass(itemstack);
        }
    }

    @Override
    public ICapabilityProvider initCapabilities(@NotNull ItemStack stack, @Nullable CompoundTag nbt) {
        return new FluidBucketWrapper(stack);
    }
}