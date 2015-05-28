package com.dyonovan.botaniatech.common.tiles;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.mana.IManaReceiver;

public class TileManaCrusher extends BaseInventoryTile implements ISidedInventory, IManaReceiver {

    public static final int INV_INPUT = 0;
    public static final int INV_OUTPUT = 1;

    public int requiredMana;
    int mana;

    public TileManaCrusher() {
        requiredMana = 0;
        mana = 0;
    }

    @Override
    public boolean isFull() {
        return mana >= requiredMana;
    }

    @Override
    public void recieveMana(int mana) {
        this.mana = Math.min(this.mana + mana, requiredMana);
    }

    @Override
    public boolean canRecieveManaFromBursts() {
        return true;
    }

    @Override
    public int getCurrentMana() {
        return mana;
    }

    @Override
    public int getSizeInventory() {
        return 2;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }
}
