package com.github.chronoselectronics.rtgpowergen;

import com.github.chronoselectronics.rtgpowergen.blocks.stickmachine.StickMachineContainer;
import com.github.chronoselectronics.rtgpowergen.blocks.stickmachine.StickMachineContainerTileEntity;
import com.github.chronoselectronics.rtgpowergen.blocks.stickmachine.StickMachineGUI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof StickMachineContainerTileEntity) {
            return new StickMachineContainer(player.inventory, (StickMachineContainerTileEntity) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof StickMachineContainerTileEntity) {
            StickMachineContainerTileEntity containerTileEntity = (StickMachineContainerTileEntity) te;
            return new StickMachineGUI(containerTileEntity, new StickMachineContainer(player.inventory, containerTileEntity));
        }
        return null;
    }
}