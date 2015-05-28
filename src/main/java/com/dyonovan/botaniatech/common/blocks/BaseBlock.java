package com.dyonovan.botaniatech.common.blocks;

import com.dyonovan.botaniatech.BotaniaTech;
import com.dyonovan.botaniatech.lib.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BaseBlock extends BlockContainer {

    protected Class<? extends TileEntity> tileClass;
    protected String name;

    public BaseBlock(String name, Class<? extends TileEntity> tileClass) {
        super(Material.rock);
        this.setBlockName(Constants.MODID + ":" + name);
        this.setCreativeTab(BotaniaTech.tabBotaniaTech);
        this.setHardness(2.0F);
        this.tileClass = tileClass;
        this.name = name;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon) {
        blockIcon = icon.registerIcon(this.getUnlocalizedName().substring(5));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        if (tileClass != null) {
            try {
                return tileClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
}
