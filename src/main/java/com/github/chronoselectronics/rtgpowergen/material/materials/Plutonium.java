package com.github.chronoselectronics.rtgpowergen.material.materials;

import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import com.github.chronoselectronics.rtgpowergen.items.BaseItem;
import com.github.chronoselectronics.rtgpowergen.material.Material;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.logging.Level;

public class Plutonium extends Material {
    public static Plutonium INSTANCE = new Plutonium();

    static private BaseItem ITEM = new BaseItem().regName("plutonium_ingot").setOreDict("ingotPlutonium").setOreDict("ingotUranium");
    static private BaseBlock BLOCK = new BaseBlock(net.minecraft.block.material.Material.ROCK).regName("plutonium_block").setOreDict("blockPlutonium").setOreDict("blockUranium").setHardness(2);

    static private BaseBlock ORE = new BaseBlock(net.minecraft.block.material.Material.ROCK).regName("plutonium_ore").setHardness(3);


    @Override
    public void register() {
        preRegister();

        //Rtgpowergen.logger.log(Level.INFO,"REGISTERING PLUTONIUM...");
        ITEM.register();
        BLOCK.register();
        ORE.register();
    }

    @Override
    public Item getItem() {
        return ITEM;
    }

    @Override
    public Block getBlock() {
        return BLOCK;
    }

    @Override
    public Block getOre() {
        return ORE;
    }

    private void preRegister() {
        ORE.setHarvestLevel("pickaxe",2);
        ORE.light = 9;

        BLOCK.light = 15;
    }
}
