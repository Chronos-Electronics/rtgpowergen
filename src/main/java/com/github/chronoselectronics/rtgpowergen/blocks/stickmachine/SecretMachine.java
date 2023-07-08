package com.github.chronoselectronics.rtgpowergen.blocks.stickmachine;

import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SecretMachine extends BaseBlock implements ITileEntityProvider {
    public static final SecretMachine INSTANCE = new SecretMachine(Material.ANVIL);


    public static final int GUI_ID = 1;

    public SecretMachine(Material material) {
        super(material);
        regName("secret_machine");
    }
    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        // Return the desired light level for your block
        return 2;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }


    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side,
                                    float hitX, float hitY, float hitZ) {
        // Only execute on the server
        if (world.isRemote) {
            return true;
        }
        TileEntity te = world.getTileEntity(pos);
        if (!(te instanceof StickMachineContainerTileEntity)) {
            return false;
        }
        player.openGui(Rtgpowergen.INSTANCE, GUI_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
