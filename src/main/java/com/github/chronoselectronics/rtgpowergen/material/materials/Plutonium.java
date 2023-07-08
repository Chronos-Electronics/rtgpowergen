package com.github.chronoselectronics.rtgpowergen.material.materials;

import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import com.github.chronoselectronics.rtgpowergen.items.BaseItem;
import com.github.chronoselectronics.rtgpowergen.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Plutonium extends Material {
    public static Plutonium INSTANCE = new Plutonium();

    static private BaseItem ITEM = new BaseItem().regName("plutonium_ingot").setOreDict("ingotPlutonium").setOreDict("ingotUranium");
    static private BaseBlock BLOCK = new BaseBlock(net.minecraft.block.material.Material.ROCK).regName("plutonium_block").setOreDict("blockPlutonium").setOreDict("blockUranium").setHardness(2);

    static private BaseBlock ORE = new BaseBlock(net.minecraft.block.material.Material.ROCK){
        public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
            super.addInformation(stack, worldIn, tooltip, flagIn);
            tooltip.add(new TextComponentTranslation("tooltip.plutonium_ore.line").getFormattedText());
        }
    }.regName("plutonium_ore").setHardness(3);


    @Override
    public void register() {
        preRegister();

        //Rtgpowergen.logger.log(Level.INFO,"REGISTERING PLUTONIUM...");
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
        ORE.light = 9;

        BLOCK.light = 15;
    }
}
