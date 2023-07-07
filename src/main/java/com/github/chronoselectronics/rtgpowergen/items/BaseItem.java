package com.github.chronoselectronics.rtgpowergen.items;

import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import com.github.chronoselectronics.rtgpowergen.Utils.CreativeTab;
import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class BaseItem extends Item implements Registerable {
    private String oreDictName = "";

    public BaseItem regName(String name) {
        this.setRegistryName(name);
        setTranslationKey (Rtgpowergen.MOD_ID + "." + name);

        return this;
    }

    @Override
    public void register() {
        setCreativeTab(CreativeTab.INSTANCE);
        ForgeRegistries.ITEMS.register(this);
        initModel();

        if (oreDictName != "") {
            OreDictionary.registerOre(oreDictName, this);
        }

    }

    public BaseItem setOreDict(String name) {
        oreDictName = name;
        return this;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
