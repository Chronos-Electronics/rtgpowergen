package com.github.chronoselectronics.rtgpowergen.material.materials;

import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import com.github.chronoselectronics.rtgpowergen.items.BaseItem;
import com.github.chronoselectronics.rtgpowergen.material.Material;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Thulium extends Material {
    public static Thulium INSTANCE = new Thulium();

    static private BaseItem ITEM = new BaseItem().regName("thulium_ingot").setOreDict("ingotThulium");
    static private BaseBlock BLOCK = new BaseBlock(net.minecraft.block.material.Material.ROCK).regName("thulium_block").setOreDict("blockThulium").setHardness(2);

    static private BaseBlock ORE = new BaseBlock(net.minecraft.block.material.Material.ROCK).regName("thulium_ore").setHardness(3);


    @Override
    public void register() {
        preRegister();

        //Rtgpowergen.logger.log(Level.INFO,"REGISTERING THULIUM...");
        ITEM.register();
        BLOCK.register();
        ORE.register();

        registerNonMaterialSpecificPostRegister();
    }

    @Override
    public BaseItem getItem() {
        return ITEM;
    }

    @Override
    public BaseBlock getBlock() {
        return BLOCK;
    }

    @Override
    public BaseBlock getOre() {
        return ORE;
    }

    private void preRegister() {
        ORE.setHarvestLevel("pickaxe",2);
    }
}
