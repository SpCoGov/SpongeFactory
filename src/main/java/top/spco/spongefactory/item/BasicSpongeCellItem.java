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

import appeng.api.config.FuzzyMode;
import appeng.api.stacks.AEKeyType;
import appeng.api.storage.StorageCells;
import appeng.api.storage.cells.CellState;
import appeng.api.upgrades.IUpgradeInventory;
import appeng.api.upgrades.UpgradeInventories;
import appeng.items.contents.CellConfig;
import appeng.util.ConfigInventory;
import appeng.util.InteractionUtil;
import net.minecraft.advancements.Advancement;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import top.spco.spongefactory.SpongeFactory;

import java.util.List;
import java.util.Optional;

public class BasicSpongeCellItem extends Item implements ISpongeCellItem {
    protected final double idleDrain;
    protected final int totalBytes;
    protected final int bytesPerType;
    private final AEKeyType keyType;

    public BasicSpongeCellItem(Item.Properties properties,
                               double idleDrain,
                               int kilobytes,
                               int bytesPerType,
                               AEKeyType keyType) {
        super(properties);
        this.idleDrain = idleDrain;
        this.totalBytes = kilobytes * 1024;
        this.bytesPerType = bytesPerType;
        this.keyType = keyType;
    }

    @Override
    public AEKeyType getKeyType() {
        return keyType;
    }

    @Override
    public int getBytes(ItemStack cellItem) {
        return totalBytes;
    }

    @Override
    public int getBytesPerType(ItemStack cellItem) {
        return bytesPerType;
    }

    @Override
    public double getIdleDrain() {
        return idleDrain;
    }

    @Override
    public IUpgradeInventory getUpgrades(ItemStack is) {
        return UpgradeInventories.forItem(is, keyType == AEKeyType.items() ? 4 : 3);
    }

    @Override
    public ConfigInventory getConfigInventory(ItemStack is) {
        return CellConfig.create(keyType.filter(), is);
    }

    @Override
    public @NotNull Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack stack) {
        return getCellTooltipImage(stack);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                Level level,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag advancedTooltips) {
        addCellInformationToTooltip(stack, lines);
    }

    @Override
    public FuzzyMode getFuzzyMode(ItemStack is) {
        final String fz = is.getOrCreateTag().getString("FuzzyMode");
        if (fz.isEmpty()) {
            return FuzzyMode.IGNORE_ALL;
        }
        try {
            return FuzzyMode.valueOf(fz);
        } catch (Throwable t) {
            return FuzzyMode.IGNORE_ALL;
        }
    }

    @Override
    public void setFuzzyMode(ItemStack is, FuzzyMode fzMode) {
        is.getOrCreateTag().putString("FuzzyMode", fzMode.name());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        this.disassembleDrive(player.getItemInHand(hand), level, player);
        return new InteractionResultHolder<>(InteractionResult.sidedSuccess(level.isClientSide()),
                player.getItemInHand(hand));
    }

    private boolean disassembleDrive(ItemStack stack, Level level, Player player) {
        if (InteractionUtil.isInAlternateUseMode(player)) {
            if (level.isClientSide()) {
                return false;
            }

            final Inventory playerInventory = player.getInventory();
            var inv = StorageCells.getCellInventory(stack, null);
            if (inv != null && playerInventory.getSelected() == stack) {
                var list = inv.getAvailableStacks();
                if (list.isEmpty()) {
                    MinecraftServer server = level.getServer();
                    if (server != null && player instanceof ServerPlayer serverPlayer) {
                        Advancement advancement = server.getAdvancements().getAdvancement(new ResourceLocation(SpongeFactory.MOD_ID, "main/sponge_storage_cell"));
                        if (advancement != null) {
                            if (!serverPlayer.getAdvancements().getOrStartProgress(advancement).isDone()) {
                                serverPlayer.getAdvancements().award(advancement, "unlock");
                            }
                        }
                    }

                    playerInventory.setItem(playerInventory.selected, ItemStack.EMPTY);

                    // drop core
                    playerInventory.placeItemBackInInventory(new ItemStack(Blocks.SPONGE));

                    // drop upgrades
                    for (var upgrade : this.getUpgrades(stack)) {
                        playerInventory.placeItemBackInInventory(upgrade);
                    }

                    // drop empty storage cell case
                    playerInventory.placeItemBackInInventory(new ItemStack(Blocks.SPONGE));

                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        return this.disassembleDrive(stack, context.getLevel(), context.getPlayer())
                ? InteractionResult.sidedSuccess(context.getLevel().isClientSide())
                : InteractionResult.PASS;
    }

    public static int getColor(ItemStack stack, int tintIndex) {
        if (tintIndex == 1) {
            // Determine LED color
            var cellInv = StorageCells.getCellInventory(stack, null);
            var cellStatus = cellInv != null ? cellInv.getStatus() : CellState.EMPTY;
            return cellStatus.getStateColor();
        } else {
            // White
            return 0xFFFFFF;
        }
    }
}