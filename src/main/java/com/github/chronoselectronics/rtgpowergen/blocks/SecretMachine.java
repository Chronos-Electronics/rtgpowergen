package com.github.chronoselectronics.rtgpowergen.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class SecretMachine extends BaseBlock implements ITileEntityProvider {
    public static final SecretMachine INSTANCE = new SecretMachine(Material.ANVIL);
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
}
