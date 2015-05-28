package com.dyonovan.botaniatech.client;

import com.dyonovan.botaniatech.client.renderer.ItemRenderBlockManaCrusher;
import com.dyonovan.botaniatech.client.renderer.RenderBlockManaCrusher;
import com.dyonovan.botaniatech.common.CommonProxy;
import com.dyonovan.botaniatech.common.tiles.TileManaCrusher;
import com.dyonovan.botaniatech.handlers.BlockHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {

    public void registerRenderInformation() {
        TileEntitySpecialRenderer renderBlockManaCrusher = new RenderBlockManaCrusher();
        ClientRegistry.bindTileEntitySpecialRenderer(TileManaCrusher.class, renderBlockManaCrusher);
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BlockHandler.blockManaCrusher),
                new ItemRenderBlockManaCrusher(renderBlockManaCrusher, new TileManaCrusher()));
    }

}
