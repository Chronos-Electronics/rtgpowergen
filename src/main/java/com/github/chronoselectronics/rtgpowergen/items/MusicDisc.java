package com.github.chronoselectronics.rtgpowergen.items;

import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import com.github.chronoselectronics.rtgpowergen.Utils.CreativeTab;
import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class MusicDisc extends ItemRecord implements Registerable {

    private static int counter = 1;
    private static final Map<Integer, MusicDisc> musicDiscMap = new HashMap<>();

    protected MusicDisc(String name, SoundEvent soundEvent) {
        super(name, soundEvent);

        reg(name);

        musicDiscMap.put(counter, this);
        counter++;

        Rtgpowergen.log(Level.INFO, getRegistryName().toString() + Integer.toString (counter-1));
    }

    protected void reg(String name) {
        this.setRegistryName("record_" + name);
        setTranslationKey(Rtgpowergen.MOD_ID + "." + "record");
    }

    public static MusicDisc getMusicDiscByID(int id) {
        return musicDiscMap.get(id);
    }

    public static int getCounter() {
        return counter;
    }

    public static int getIDByMusicDisc(MusicDisc disc) {
        for (Map.Entry<Integer, MusicDisc> entry : musicDiscMap.entrySet()) {
            if (entry.getValue().equals(disc)) {
                return entry.getKey();
            }
        }
        Rtgpowergen.logger.log(Level.SEVERE, "Lol thats not possible how did you get here YOU FRICKIN OBTAINED A MUSIC DISC THAT DOES NOT EXISTS (its constructor wasn't called)");
        return -1; // Return -1 if the disc is not found
    }


    @Override
    public void register() {
        setCreativeTab(CreativeTab.INSTANCE);
        ForgeRegistries.ITEMS.register(this);
        initModel();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
