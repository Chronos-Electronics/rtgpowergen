package com.github.chronoselectronics.rtgpowergen.blocks;

import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import com.github.chronoselectronics.rtgpowergen.Utils.CreativeTab;
import com.github.chronoselectronics.rtgpowergen.Utils.Registerable;
import com.github.chronoselectronics.rtgpowergen.items.BaseItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class BaseBlock extends Block implements Registerable {
    private String oreDictName = "";

    public int light = 0;

    public BaseBlock(Material material) {
        super(material);
    }

    public BaseBlock regName(String name) {
        this.setRegistryName(name);
        setTranslationKey (Rtgpowergen.MOD_ID + "." + name);

        return this;
    }

    public BaseBlock setHardness(float f) {
        super.setHardness(f);
        return this;
    }

    public BaseBlock setResistance(float f) {
        super.setResistance(f);
        return this;
    }

    public void register() {
        blockRegister();
        ForgeRegistries.ITEMS.register(new ItemBlock(this).setRegistryName(this.getRegistryName()));

        setCreativeTab(CreativeTab.INSTANCE);

        initModel();

        if (oreDictName != "") {
            OreDictionary.registerOre(oreDictName, this);
        }
    }

    public BaseBlock setOreDict(String name) {
        oreDictName = name;
        return this;
    }


    private void blockRegister() {
        ForgeRegistries.BLOCKS.register(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void onBlockHarvested(World world, BlockPos pos, net.minecraft.block.state.IBlockState state, net.minecraft.entity.player.EntityPlayer player) {
        super.onBlockHarvested(world, pos, state, player);
        //dropBlockAsItem(world, pos, state, 0);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return light;
    }


}