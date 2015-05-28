package com.dyonovan.botaniatech.client.renderer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class ItemRenderBlockManaCrusher implements IItemRenderer {

    private TileEntitySpecialRenderer render;
    private TileEntity tile;

    public ItemRenderBlockManaCrusher(TileEntitySpecialRenderer render, TileEntity tile) {
        this.render = render;
        this.tile = tile;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case ENTITY: {
                GL11.glPushMatrix();
                this.render.renderTileEntityAt(this.tile, 0.0D, 0.0D, 0.0D, 0.0F);
                GL11.glPopMatrix();
            }
            case EQUIPPED: {
                GL11.glPushMatrix();
                this.render.renderTileEntityAt(this.tile, 0.0D, 0.0D, 0.0D, 0.0F);
                GL11.glPopMatrix();
            }
            case EQUIPPED_FIRST_PERSON: {
                GL11.glPushMatrix();
                this.render.renderTileEntityAt(this.tile, 0.0D, 0.0D, 0.0D, 0.0F);
                GL11.glPopMatrix();
            }
            case INVENTORY: {
                GL11.glPushMatrix();
                this.render.renderTileEntityAt(this.tile, 0.0D, 0.0D, 0.0D, 0.0F);
                GL11.glPopMatrix();
            }
            default:
                break;
        }
    }
}
