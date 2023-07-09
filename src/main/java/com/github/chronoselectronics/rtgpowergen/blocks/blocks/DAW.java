package com.github.chronoselectronics.rtgpowergen.blocks.blocks;

import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import com.github.chronoselectronics.rtgpowergen.items.MusicDisc;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class DAW extends BaseBlock {
    public DAW() {
        super(Material.ANVIL);
        setHardness(2);
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState p_180639_3_, EntityPlayer player, EnumHand hand, EnumFacing p_180639_6_, float p_180639_7_, float p_180639_8_, float p_180639_9_) {
        ItemStack heldItem = player.getHeldItem(hand);
        Item item = heldItem.getItem();

        if (item.getRegistryName().toString().equals("rtgpowergen:record_base")) {
            int newID = new Random().nextInt(MusicDisc.getCounter() -1) + 1;

            player.setHeldItem(hand,new ItemStack(MusicDisc.getMusicDiscByID(newID)));

            return true; // Return true if the MusicDisc is successfully processed
        }

        return false;
    }
}
