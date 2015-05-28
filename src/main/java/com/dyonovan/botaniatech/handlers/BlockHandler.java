package com.dyonovan.botaniatech.handlers;

import com.dyonovan.botaniatech.common.blocks.BlockManaCrusher;
import com.dyonovan.botaniatech.common.tiles.TileManaCrusher;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class BlockHandler {

    public static Block blockManaCrusher;

    public static void preInit() {
        registerBlock(blockManaCrusher = new BlockManaCrusher("blockManaCrusher", TileManaCrusher.class), "blockManaCrusher", TileManaCrusher.class);
    }

    public static void registerBlock(Block block, String name, Class<? extends TileEntity> tileEntity) {
        GameRegistry.registerBlock(block, name);
        if (tileEntity != null)
            GameRegistry.registerTileEntity(tileEntity, name);
    }
}
