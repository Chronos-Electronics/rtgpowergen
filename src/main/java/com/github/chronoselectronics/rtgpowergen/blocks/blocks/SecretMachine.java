package com.github.chronoselectronics.rtgpowergen.blocks.blocks;

import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import com.github.chronoselectronics.rtgpowergen.items.Items;
import com.github.chronoselectronics.rtgpowergen.material.materials.Plutonium;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;


public class SecretMachine extends BaseBlock {
    public static final SecretMachine INSTANCE = new SecretMachine(Material.ANVIL);

    public SecretMachine(Material material) {
        super(material);
        setHardness(2);
        regName("secret_machine");
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState p_180639_3_, EntityPlayer player, EnumHand hand, EnumFacing p_180639_6_, float p_180639_7_, float p_180639_8_, float p_180639_9_) {
        ItemStack heldItem = player.getHeldItem(hand);
        Item item = heldItem.getItem();

        if (item.getRegistryName().toString().equals("minecraft:dispenser")) {
            heldItem.shrink(1);

            player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS));

            return true; // Return true if the MusicDisc is successfully processed
        }

        if (heldItem != ItemStack.EMPTY) {
            try {
                int[] oreIDs = OreDictionary.getOreIDs(heldItem);

                for (int oreID : oreIDs) {
                    String oreName = OreDictionary.getOreName(oreID);
                    if (oreName.equals("ingotUranium")) {
                        heldItem.shrink(1);
                        player.inventory.addItemStackToInventory(new ItemStack(Plutonium.INSTANCE.getItem()));
                        return true; // If you want to stop checking after finding one instance of "ingotUranium"
                    }
                }
            }
            catch (Exception exception)  {
                return false;
            }

        }
            return false;
    }
}
