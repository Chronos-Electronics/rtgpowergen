package com.github.chronoselectronics.rtgpowergen.blocks.TileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.Date;

public class RtgpowergeneratorTileEntity extends TileEntity {
    private Date lastClickTime; // Variable to store the last click time

    public boolean canOutputCoal() {
        if (lastClickTime == null || (new Date().getTime() - lastClickTime.getTime()) >= 30000) {
            // 30 seconds have passed or it's the first click
            return true;
        }
        return false;
    }

    public void setLastClickTime(Date lastClickTime) {
        this.lastClickTime = lastClickTime;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("lastClickTime")) {
            lastClickTime = new Date(compound.getLong("lastClickTime"));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        if (lastClickTime != null) {
            compound.setLong("lastClickTime", lastClickTime.getTime());
        }
        return compound;
    }
}