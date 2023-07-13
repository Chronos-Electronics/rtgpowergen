package com.github.chronoselectronics.rtgpowergen.blocks.blocks;
import com.github.chronoselectronics.rtgpowergen.Rtgpowergen;
import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import com.github.chronoselectronics.rtgpowergen.blocks.TileEntities.RtgpowergeneratorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;
import java.util.Date;

public class Rtgpowergenerator extends BaseBlock implements ITileEntityProvider {
    private Date lastClickTime; // Variable to store the last click time

    public Rtgpowergenerator() {
        super(Material.ANVIL);
        setHardness(2);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState p_180639_3_, EntityPlayer player, EnumHand hand, EnumFacing p_180639_6_, float p_180639_7_, float p_180639_8_, float p_180639_9_) {
        RtgpowergeneratorTileEntity tileEntity = (RtgpowergeneratorTileEntity) world.getTileEntity(pos);
        if (tileEntity == null) {
            Rtgpowergen.log("Appeareantly TileNetity erroeroero");
            return false;
        }

        if (tileEntity.canOutputCoal()) {
            player.inventory.addItemStackToInventory(new ItemStack(Items.COAL));

            tileEntity.setLastClickTime(new Date()); // Update the last click time
            tileEntity.markDirty(); // Mark the tile entity as dirty to save changes

            return true;
        }

        return false;
    }

    @Override
    public void register() {
        GameRegistry.registerTileEntity(RtgpowergeneratorTileEntity.class, new ResourceLocation("rtgpowergenerator_tile_entity"));
        super.register();
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new RtgpowergeneratorTileEntity();
    }
}


