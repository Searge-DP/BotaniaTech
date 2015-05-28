package com.dyonovan.botaniatech.common.blocks;

import com.dyonovan.botaniatech.common.tiles.TileManaCrusher;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockManaCrusher extends BaseBlock {

    public BlockManaCrusher(String name, Class<? extends TileEntity> tileClass) {
        super(name, tileClass);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        TileManaCrusher tile = (TileManaCrusher) world.getTileEntity(x, y, z);
        if (tile == null) return true;

        if (player.getHeldItem() != null && player.getHeldItem().getItem() == Item.getItemFromBlock(Blocks.iron_ore)) {
            if (tile.getStackInSlot(TileManaCrusher.INV_INPUT).stackSize == 0) {
                tile.setInventorySlotContents(TileManaCrusher.INV_INPUT, new ItemStack(player.getHeldItem().getItem(), 1));
                player.inventory.consumeInventoryItem(player.getHeldItem().getItem());
            }
        } else if (player.getHeldItem() == null && tile.getStackInSlot(TileManaCrusher.INV_INPUT) == null) {
            boolean success = player.inventory.addItemStackToInventory(new ItemStack(tile.getStackInSlot(TileManaCrusher.INV_INPUT).getItem(), 1));
            if (success) tile.setInventorySlotContents(TileManaCrusher.INV_INPUT, null);
        }

        return true;
    }
}
