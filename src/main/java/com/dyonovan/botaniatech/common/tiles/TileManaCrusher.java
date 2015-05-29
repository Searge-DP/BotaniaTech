package com.dyonovan.botaniatech.common.tiles;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import vazkii.botania.api.mana.IManaReceiver;

public class TileManaCrusher extends BaseInventoryTile implements ISidedInventory, IManaReceiver {

    public static final int INV_INPUT = 0;
    public static final int MANA_USAGE = 8000;

    public int mana, requireMana;

    public TileManaCrusher() {
        inventory = new Inventory(1);
        requireMana = 0;
        mana = 0;
    }

    @Override
    public void updateEntity() {
        if (worldObj.isRemote) return;

        recieveMana(0);

        if (getStackInSlot(INV_INPUT) != null && mana <= 0) {
            requireMana = MANA_USAGE;
        }
        if (mana > 0 && getStackInSlot(INV_INPUT) == null) {
            reset();
        } else if (mana >= MANA_USAGE) {
            reset();
            decrStackSize(INV_INPUT, 1);
            EntityItem outputItem = new EntityItem(worldObj, xCoord + 0.5, yCoord + 1.5, zCoord + 0.5,
                    new ItemStack(Items.iron_ingot, 2));
            worldObj.spawnEntityInWorld(outputItem);
            worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
    }

    private void reset() {
        mana = 0;
        requireMana = 0;
    }

    @Override
    public boolean isFull() {
        return mana >= requireMana;
    }

    @Override
    public void recieveMana(int mana) {
        this.mana = Math.min(this.mana + mana, requireMana);
    }

    @Override
    public boolean canRecieveManaFromBursts() {
        return !isFull();
    }

    @Override
    public int getCurrentMana() {
        return mana;
    }

    @Override
    public int getSizeInventory() {
        return 1;
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

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        inventory.writeToNBT(tag, ":main");
        tag.setInteger("Mana", mana);
        tag.setInteger("RequiredMana", requireMana);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        inventory.readFromNBT(tag, this, ":main");
        mana = tag.getInteger("Mana");
        requireMana = tag.getInteger("RequiredMana");

    }
}
