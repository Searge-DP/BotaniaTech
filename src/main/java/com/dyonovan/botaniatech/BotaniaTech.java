package com.dyonovan.botaniatech;

import com.dyonovan.botaniatech.common.CommonProxy;
import com.dyonovan.botaniatech.handlers.BlockHandler;
import com.dyonovan.botaniatech.lib.Constants;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;


@SuppressWarnings("unused")
@Mod(name = Constants.MODNAME, modid = Constants.MODID, version = Constants.VERSION, dependencies = Constants.DEPENDENCIES)
public class BotaniaTech {

    @Instance
    public static BotaniaTech instance;

    @SidedProxy(clientSide = "com.dyonovan." + Constants.MODID + ".client.ClientProxy",
                serverSide = "com.dyonovan." + Constants.MODID + ".common.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs tabBotaniaTech = new CreativeTabs("tabBotaniaTech") {
        @Override
        public Item getTabIconItem() {
            return Items.flower_pot;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        BlockHandler.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) { }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evt) {}
}
