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

public class MusicDisc extends ItemRecord implements Registerable {
    protected MusicDisc(String name, SoundEvent soundEvent) {
        super(name, soundEvent);

        this.setRegistryName("record_"+name);
        setTranslationKey (Rtgpowergen.MOD_ID + "." + "record");
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
