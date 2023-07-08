package com.github.chronoselectronics.rtgpowergen.blocks.demoncore;

import com.github.chronoselectronics.rtgpowergen.blocks.BaseBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Demoncore extends BaseBlock {

    public Demoncore() {
        super(Material.IRON);
        setHardness(5);
    }


    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer player) {
        ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);
        if (heldItem != null && heldItem.getItem().getRegistryName().toString().equals("rtgpowergen:screwdriver")) {
            // Spawn blue particles
            int particleCount = 10; // Number of particles to spawn
            double particleXSpeed = 0.0; // X-axis speed of particles
            double particleYSpeed = 0.0; // Y-axis speed of particles
            double particleZSpeed = 0.0; // Z-axis speed of particles

            // Spawn particles
            for (int i = 0; i < particleCount; i++) {
                world.spawnParticle(EnumParticleTypes.SPELL_MOB, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, particleXSpeed, particleYSpeed, particleZSpeed);
            }
            // Apply wither effect to the player
            player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 200, 1));
        }
    }
}
