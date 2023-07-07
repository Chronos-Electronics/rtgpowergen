package com.github.chronoselectronics.rtgpowergen.material;

import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.material.materials.Plutonium;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Material implements Registerable {
    protected static List<Material> instanceList = new ArrayList<Material>() {{
        add(Plutonium.INSTANCE);
    }};
    public static Material INSTANCE = new Material();

    public Item getItem() {
        return null;
    }

    public Block getBlock() {
        return null;
    }

    public Block getOre() {
        return null;
    }


    public static void registerInstances() {
        for (Material material : instanceList) {
            material.register();
        }
    }

    @Override
    public void register() {
        registerInstances();
    }
}
