package com.github.chronoselectronics.rtgpowergen.Utils;

import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import com.github.chronoselectronics.rtgpowergen.material.materials.Plutonium;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
    public static CreativeTab INSTANCE = new CreativeTab();
    public CreativeTab() {
        super(Rtgpowergen.MOD_ID + "tab");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Plutonium.INSTANCE.getItem());
    }
}
