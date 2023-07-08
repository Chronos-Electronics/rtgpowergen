package com.github.chronoselectronics.rtgpowergen.blocks.stickmachine;

import net.minecraft.client.gui.inventory.GuiContainer;

public class StickMachineGUI extends GuiContainer {
    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;



    public StickMachineGUI(StickMachineContainerTileEntity tileEntity, StickMachineContainer container) {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}
