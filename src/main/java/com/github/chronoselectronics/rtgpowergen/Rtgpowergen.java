package com.github.chronoselectronics.rtgpowergen;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.blocks.Blocks;
import com.github.chronoselectronics.rtgpowergen.items.Items;
import com.github.chronoselectronics.rtgpowergen.material.Material;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Mod(
        modid = Rtgpowergen.MOD_ID,
        name = Rtgpowergen.MOD_NAME,
        version = Rtgpowergen.VERSION
)
public class Rtgpowergen {
    static List<Registerable> registerables = new ArrayList<Registerable> () {{
       add(Blocks.INSTANCE);
       add(Items.INSTANCE);
       add(Material.INSTANCE);
    }};

    public static final String MOD_ID = "rtgpowergen";
    public static final String MOD_NAME = "RTG Nuclear Power";
    public static final String VERSION = "1.0";

    public static final Logger logger = Logger.getLogger(Rtgpowergen.class.getName());


    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static Rtgpowergen INSTANCE;

    @SidedProxy
    public static CommonProxy proxy;


    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    public static class CommonProxy {
        public void preInit(FMLPreInitializationEvent e) {
            // Initialization of blocks and items typically goes here:
            logger.log(Level.INFO, "Hello from RTG (Still waiting for AoT last episode");
            for (Registerable object : registerables) {
                object.register();
            }

        }

        public void init(FMLInitializationEvent e) {

        }

        public void postInit(FMLPostInitializationEvent e) {

        }
    }

    public static class ClientProxy extends CommonProxy {
        @Override
        public void preInit(FMLPreInitializationEvent e) {
            super.preInit(e);
        }
    }

    public static class ServerProxy extends CommonProxy {

    }

}
