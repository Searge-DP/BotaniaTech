package com.dyonovan.botaniatech.client.renderer;

import com.dyonovan.botaniatech.client.model.ModelBlockManaCrusher;
import com.dyonovan.botaniatech.common.tiles.TileManaCrusher;
import com.dyonovan.botaniatech.lib.Constants;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderBlockManaCrusher extends TileEntitySpecialRenderer {

    public static final ResourceLocation texture = new ResourceLocation(Constants.MODID + ":textures/models/blockManaCrusher.png");

    private ModelBlockManaCrusher model;
    private float rotMod = 0.0F;

    public RenderBlockManaCrusher() {
        this.model = new ModelBlockManaCrusher();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180, 0F, 0F, 1F);

        this.bindTexture(texture);
        this.model.renderModel(0.0625F, tileentity.xCoord, tileentity.yCoord, tileentity.zCoord, (tileentity.getWorldObj() == null));

        GL11.glPopMatrix();

        //Render Item on Top
        TileManaCrusher tile = (TileManaCrusher) tileentity;

        if (tile.getStackInSlot(TileManaCrusher.INV_INPUT) != null) {
            rotMod += ((rotMod % 360) /360) + 1;
            GL11.glPushMatrix();
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.75F, (float) z + 0.5F);
            GL11.glRotatef(360, 0, 1, 1);
            GL11.glRotatef(rotMod, 0.0F, 1.0F, 0.0F);
            RenderManager.instance.renderEntityWithPosYaw(tile.item, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glPopMatrix();
        }
    }
}
